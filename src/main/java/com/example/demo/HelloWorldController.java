package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/classpath")
    public List<String> classpath() {
        return FileUtils.getResources(Pattern.compile(".*"));
    }

    @RequestMapping("/values")
    public Map<String, String> values(
            @Value("${k1:undefined}") String k1,
            @Value("${k2:undefined}") String k2,
            @Value("${k3:undefined}") String k3,
            @Value("${k4:undefined}") String k4,
            @Value("${k5:undefined}") String k5,
            @Value("${k6:undefined}") String k6,
            @Value("${k7:undefined}") String k7,
            @Value("${k8:undefined}") String k8,
            @Value("${k9:undefined}") String k9,
            @Value("${k10:undefined}") String k10,
            @Value("${k11:undefined}") String k11,
            @Value("${k12:undefined}") String k12,
            @Value("${k13:undefined}") String k13,
            @Value("${k14:undefined}") String k14,
            @Value("${k15:undefined}") String k15,
            @Value("${k16:undefined}") String k16
    ) {
        HashMap<String, String> map = new HashMap<>();
        map.put("k1", k1);
        map.put("k2", k2);
        map.put("k3", k3);
        map.put("k4", k4);
        map.put("k5", k5);
        map.put("k6", k6);
        map.put("k7", k7);
        map.put("k8", k8);
        map.put("k9", k9);
        map.put("k10", k10);
        map.put("k11", k11);
        map.put("k12", k12);
        map.put("k13", k13);
        map.put("k14", k14);
        map.put("k15", k15);
        map.put("k16", k16);
        return map;
    }
}
