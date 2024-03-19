package com.spti.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	//public URL
	@RequestMapping( "/register" )
	public String register( @RequestParam( "id" ) int id, @RequestParam( "name" ) String name, @RequestParam int sal ) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>( "body", headers );
		ResponseEntity<String> result = restTemplate.exchange( "http://localhost:7878/demo", HttpMethod.GET, entity, String.class );
		String res = result.getBody();
		return "result";
	}
}

//@RequestParam( "id" ) will read the data from input whose name is id.