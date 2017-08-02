/**
 * 
 */
package com.example.demo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.util.SimpleIdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author upadhs5
 *
 */
@RestController
@RequestMapping("/v1/api")
public class DemoController {

	private static final Map<String, Object> imdb = new HashMap<>();
	private SimpleIdGenerator idGen = new SimpleIdGenerator();

	@GetMapping("demo")
	public Collection<Object> getDemo() {
		return imdb.values();
	}

	@GetMapping("demo/{id}")
	public Object getOneDemo(@PathVariable(name = "id") String id) {
		return imdb.get(id);
	}

	@PostMapping(path = "demo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String addOneDemo(@RequestBody Object obj) {
		String id = idGen.generateId().toString();
		imdb.put(id, obj);
		return id;
	}
}
