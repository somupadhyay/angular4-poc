package org.error.redirect;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ErrorRedirectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrorRedirectApplication.class, args);
	}
	
	@GetMapping(path="available")
	public Map<String, String> available(){
	    Map<String,String> map = new HashMap<String, String>();
	    map.put("status", "available");
	    return map;
	}
}
