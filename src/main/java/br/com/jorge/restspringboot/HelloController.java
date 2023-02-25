package br.com.jorge.restspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(path = "/hello")
	public String getHello() {
		return"Hello World!";
	}
}
