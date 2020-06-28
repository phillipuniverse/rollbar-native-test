package com.shipwell.rollbartest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    
    
    private static final Logger log = LoggerFactory.getLogger(TestController.class);


    @GetMapping("/exception/{inpath}")
    void exception(@PathVariable("inpath") String inPath, String inQuery) {
        log.info("Path parameter {} query parameter: {}", inPath, inQuery);
        throw new RuntimeException();
    }

}
