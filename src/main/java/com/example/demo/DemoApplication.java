package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("111");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RestController
	public static class Hello {

		@RequestMapping(value = "/hello")
		public String hello(@RequestParam(value = "name", defaultValue = "World")  String name){
			System.out.println("222");
			return "Hello, " + name;
		}
	
	}
	
	
	
//	@RestController
//	public class GetStockQuoteController {
// 
//	    @RequestMapping("/hello")
//	    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
//	        return "hi " + name + " ,i am from port:";
//	    }
//
//	}
//	
	
}
