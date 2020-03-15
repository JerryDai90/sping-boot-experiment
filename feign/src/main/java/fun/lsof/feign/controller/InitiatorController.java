package fun.lsof.feign.controller;

import fun.lsof.feign.service.feign.IProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/initiator")
public class InitiatorController implements IProviderService {

    @Autowired
    IProviderService provider;

    @Override
    @PostMapping("/post2query")
    public String post2query(String p) {
        return provider.post2query(p);
    }

    @Override
    @PostMapping("/post2body")
    public String post2body(String p) {
        return provider.post2body(p);
    }

    @Override
    @PostMapping("/post2body4map")
    public String post2body4map(@RequestBody Map p){
        return provider.post2body4map(p);
    }


    @Override
    @GetMapping("/get2query")
    public String get2query(String p) {
        return provider.get2query(p);
    }

    @Override
    @PostMapping(path = "/post2form", consumes = "application/x-www-form-urlencoded")
    public String post2form(@RequestParam("p") String p) {
        return provider.post2form(p);
    }
}
