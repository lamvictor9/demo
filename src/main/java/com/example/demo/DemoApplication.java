package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("100");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RestController
	//@CrossOrigin(value="http://localhost:8080/")
	public static class Hello {

		@RequestMapping(value = "/hello")
		@CrossOrigin("http://localhost:8080/")
		public String hello(@RequestParam(value = "name", defaultValue = "World")  String name){
			System.out.println("222");
			return "Hello8, " + name;
		}

		
		@RequestMapping(value = "/hello3")
		public String hello3(@RequestParam(value = "name", defaultValue = "World")  String name){
			System.out.println("333");
			return "Hello3, " + name;
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
