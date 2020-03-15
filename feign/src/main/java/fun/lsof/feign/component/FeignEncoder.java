package fun.lsof.feign.component;


import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.form.FormEncoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

/**
 * 主要用于转换body中的数据.
 *
 * @author jerry
 * @date 2020 -03-15 12:37:56
 */
@Component
public class FeignEncoder extends SpringEncoder {

    @Autowired
    public FeignEncoder(ObjectFactory<HttpMessageConverters> messageConverters) {
        super(messageConverters);
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        super.encode(object, bodyType, template);
    }
}
