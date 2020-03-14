package fun.lsof.feign.controller;

import feign.template.UriUtils;
import org.apache.commons.collections.ListUtils;
//import org.apache.http.NameValuePair;
//import org.apache.http.client.utils.URLEncodedUtils;
//import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 提供服务，仅用于feign.
 *
 * @author jerry
 * @date 2020 -03-14 23:11:43
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @PostMapping("/post2query")
    public String post2query(@RequestParam("p") String p) {
        return p;
    }

    @PostMapping("/post2body")
    public String post2body(@RequestBody String p) {
        return p;
    }


    @GetMapping("/get2query")
    public String get2query(@RequestParam("p") String p) {
        return p;
    }


    public static void main(String[] args) {
/*

        BasicNameValuePair p1 = new BasicNameValuePair("p1", "+");


        List<BasicNameValuePair> l2 = new ArrayList<>();
        l2.add(p1);


        String format = URLEncodedUtils.format(l2, "UTF-8");


        System.out.println(format);


        String s = UriUtils.encodeReserved("&+", "", Charset.forName("UTF-8"));


        System.out.println(s);

*/
    }
}
