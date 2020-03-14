package fun.lsof.feign.fix.urlencode;

import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate template) {

        Map<String, Collection<String>> _queries = template.queries();
        if (!_queries.isEmpty()) {
            //由于在最新的  RFC 3986  规范，+号是不需要编码的，因此spring 实现的是这个规范，这里就需要参数中进行编码先，兼容旧规范。
            Map<String, Collection<String>> encodeQueries = new HashMap<String, Collection<String>>(_queries.size());

            Iterator<String> iterator = _queries.keySet().iterator();
            Collection<String> encodeValues = null;
            while (iterator.hasNext()) {
                encodeValues = new ArrayList<>();

                String key = iterator.next();
                Collection<String> values = _queries.get(key);

                for (String _str : values) {
                    _str = _str.replaceAll("\\+", "%2B");
                    encodeValues.add(_str);
                }
                encodeQueries.put(key, encodeValues);
            }
            template.queries(null);
            template.queries(encodeQueries);
        }

        //处理POST请求的时候转换成了GET的bug
        if (HttpMethod.POST.name().equals(template.method()) && template.requestBody().length() == 0 && !template.queries().isEmpty()) {
            Object object = MapUtils.getObject(template.headers(), HttpHeaders.CONTENT_TYPE);
            if (null != object) {

                if (((Collection) object).contains(APPLICATION_FORM_URLENCODED_VALUE)) {

                    StringBuilder builder = new StringBuilder();
                    Map<String, Collection<String>> queries = template.queries();
                    Iterator<String> queriesIterator = queries.keySet().iterator();

                    while (queriesIterator.hasNext()) {
                        String field = queriesIterator.next();
                        Collection<String> strings = queries.get(field);
                        //由于参数已经做了url编码处理，这里直接拼接即可
                        try {
                            builder.append(field + "=" + URLEncoder.encode(StringUtils.join(strings, ","), template.requestCharset().name()));
                        } catch (UnsupportedEncodingException e) {
                            e.printStackTrace();
                        }
                        builder.append("&");
                    }

                    template.body(Request.Body.encoded(builder.toString().getBytes(), template.requestCharset()));
                    template.queries(null);
                }
            }
        }
        System.out.println(template);
        System.out.println("--------------------------------------");

    }
}


