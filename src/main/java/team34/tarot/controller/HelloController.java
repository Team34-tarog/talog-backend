package team34.tarot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/utils")
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<Map> hello() {
        Map<String, String> response = new HashMap<String, String>();

        response.put("data", SecurityContextHolder.getContext().getAuthentication().toString());

        return ResponseEntity.ok(response);
    }
}
