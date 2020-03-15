package fun.lsof.feign.service.feign;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "http://localhost:8080", name = "IProviderController")
@Primary
public interface IProviderService {


    @PostMapping("/provider/post2query")
    public String post2query(@RequestParam("p") String p);

    @PostMapping(path = "/provider/post2form", consumes = "application/x-www-form-urlencoded")
    public String post2form(@RequestParam("p") String p);

    @PostMapping("/provider/post2body")
    public String post2body(@RequestBody String p);

    @PostMapping("/provider/post2body4map")
    public String post2body4map(@RequestBody Map p);


    @GetMapping("/provider/get2query")
    public String get2query(@RequestParam("p") String p);




}
