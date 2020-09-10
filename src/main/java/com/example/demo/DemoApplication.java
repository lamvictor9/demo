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
		@CrossOrigin
		public String hello(@RequestParam(value = "name", defaultValue = "World")  String name){
			System.out.println("222");
			return "Hello10, " + name;
		}

		
		@RequestMapping(value = "/hello7")
		@CrossOrigin
		public String hello7(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			//String resp = HttpClientUtils.get("http://quotese.etnet.com.hk/content/mq3/wl_hkStockCollapse.php?code=981", null);
			
			//String token = "%C2%BDQC%C2%A6E%C2%A7JX%3E%C3%B1%C3%9A%C2%9D-j%C2%99l%C2%9E%06%C2%93%C2%8F%C2%A6%C3%B5%C3%85%C3%89";
			String limit = "60";
			String minType = "102";
			String code = "6060";
			
			String resp = HttpClientUtils.get("http://chartse.etnet.com.hk/HttpServer/TransServer/servlet/SecServlet?minType="+minType+"&code="+code+"&uid=BMPuser&token="+token+"&limit="+limit+"&dataType=hist_today", null);
						
			System.out.println(resp);
	
			if (resp.indexOf("setOpenWindow")!=-1 && resp.indexOf("ScreenWidth")!=-1) {
				resp = "token expired";
			}
			
			return "Hello3, " + resp;
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
