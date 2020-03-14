package fun.lsof.feignlearn.comm.feign;


import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.form.spring.SpringFormEncoder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class FeignEncoder extends SpringFormEncoder {

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        super.encode(object, bodyType, template);
    }
}
