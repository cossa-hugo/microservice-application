package org.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RefreshScope
@RestController
public class CompanyRestService {
    @Value("${globalParam}")
    private String globalParam;
    @Value("${myself}")
    private String me;
    @Value("${server.port}")
    private String port;

    @GetMapping("/myConfig")
    Map<String, Object> myConfig(){
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("globalParam", globalParam);
        parameters.put("me", me);
        parameters.put("port", port);
        // The currentThread properties will explain us how many instance of the service
        // do we have and how "la montée" en charge du proxy works
        parameters.put("Thread", Thread.currentThread().getName());
        return parameters;
    }
}
