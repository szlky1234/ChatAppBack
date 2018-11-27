package com.szlky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/hello",
        method = RequestMethod.GET,
        produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity greet() {
        log.debug("hello world");
        return new ResponseEntity<>( "yeet", HttpStatus.OK);
    }

    @RequestMapping(value = "/helloWorld",
            method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity helloWorld(@RequestBody String body) {
        log.debug("hello world");
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @RequestMapping(value = "/helloWorld2",
            method = RequestMethod.GET,
            produces = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity helloWorld2(@RequestParam String name) {
        log.debug(name);
        return new ResponseEntity<>(name, HttpStatus.OK);
    }

}
