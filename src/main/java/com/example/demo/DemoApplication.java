package com.example.demo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Timestamp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("100");
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@RestController
	//@CrossOrigin(value="http://localhost:8080/")
	public static class Hello {


		//use post here with input currentTimeStamp, stocklist/F/P in string tokenizer(6060,F,981,P), initizised_mode=true/false
		@RequestMapping(value = "/stockChartData")
		@CrossOrigin
		public String stockChartData(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			
//MongoClientURI uri = new MongoClientURI("mongodb+srv://lamvictor:lam080979@richportaldb.f6s6r.mongodb.net/RichPortal?retryWrites=true&w=majority");
//
//MongoClient mongoClient = new MongoClient(uri);
//MongoDatabase database = mongoClient.getDatabase("RichPortal");
			
			
		    //MongoClient mongoClient = MongoClients.create("mongodb+srv://lamvictor:080979@richportaldb.f6s6r.mongodb.net/RichPortal?retryWrites=true&w=majority");
		    
			MongoClient mongoClient = MongoDBHelper.getClient();
			
		    // get handle to "RichPortal" database
	        MongoDatabase database = mongoClient.getDatabase("RichPortal");
	        
	        MongoCollection<Document> collection = database.getCollection("historyStockInfo");
		   
	        
	        String resp = "";
	        
	        
	        MongoCursor<Document> cursor = collection.find().iterator();
	        try {
	            while (cursor.hasNext()) {
	            	resp += cursor.next().toJson();
	            }
	        } finally {
	            cursor.close();
	        }
	        
	        
	        // release resources
	        mongoClient.close();
	        
	        
			
			//step 0 : get lastSyncTimestamp from MongoDB 
			
			//step 0.1 : db.StockInfo.remove({ stockCode not in stocklist param  }) 
			           //db.StockInfo.insertOne({stockCode:'981', year5Chart: [], year1Chart: [], fiveMinChart:[]})  //insert new in stocklist

			
			
			//step 1 : sync real time stock price to MongoDB realtimePrice
			
//			unique index to stockCode
//			
//			try select max timestamp records from year5chart  
			
			// i) get http://quotese.etnet.com.hk/content/mq3/wl_hkStockCollapse.php?code=981,6060  and update to MongoDB
			
			
//			//step 2 : sync history stock price to MongoDB if neccessary
			
			//loop the stockcode in stocklist :
			
			//year5Chart_limit=0;
			//year1Chart_limit=0;
			//todayChart_limit=0;
			
			// if   ( getyear5Chart(981) / getyear1Chart(981) is empty from MDB) ){
			
				//year5Chart_limit=60;
				//year1Chart_limit=60;
			
	     	//}
			
//			else if (lastSyncTimestamp 's date != currentTimeStamp 's date  {
				//year5Chart_limit=10;
				//year1Chart_limit=10;
//			}
//				
//			if (currentTimeStamp - lastSyncTimestamp > 5min  ) {
			    //todayChart_limit=[calculate_value];
			
//			}
			
//				call if year5Chart_limit>0;
//				    month:
//					http://chartse.etnet.com.hk/HttpServer/TransServer/servlet/SecServlet?minType=102&code=6060&uid=BMPuser&token=%C2%BDQC%C2%A6E%C2%A7JX%3E%C3%B1%C3%9A%C2%9D-j%C2%99l%C2%9E%06%C2%93%C2%8F%C2%A6%C3%B5%C3%85%C3%89&limit=400&dataType=hist_today
//
//					week:
//					http://chartse.etnet.com.hk/HttpServer/TransServer/servlet/SecServlet?minType=101&code=6060&uid=BMPuser&token=%C2%BDQC%C2%A6E%C2%A7JX%3E%C3%B1%C3%9A%C2%9D-j%C2%99l%C2%9E%06%C2%93%C2%8F%C2%A6%C3%B5%C3%85%C3%89&limit=400&dataType=hist_today
//			

			//update each response value to MongoDB
			
//				
//				call  if todayChart_limit>0;{
//				5 min
//				http://chartse.etnet.com.hk/HttpServer/TransServer/servlet/SecServlet?minType=5&code=6060&uid=BMPuser&token=%C2%BDQC%C2%A6E%C2%A7JX%3E%C3%B1%C3%9A%C2%9D-j%C2%99l%C2%9E%06%C2%93%C2%8F%C2%A6%C3%B5%C3%85%C3%89&limit=400&dataType=hist_today
//			
//				update 	lastSyncTimestamp = currentTimeStamp	 to MongoDB
//		}

	
			
			
			//step 3 : response to browser with minimize json content from MongoDB
			
			//loop the stockcode in stocklist :
			
			//if initizised_mode or ( stockCode is Fullupdated ), response all from MongoDB
			//else if   ( stockCode is Partialupdated ) getmaxtimestamp 
			
			
			
			
			//backup:
				 // boolean updatedweekMonthChart = true
				  // boolean updated5minChart = true
			
			return resp;
		}
		
		
		 
		@RequestMapping(value = "/realTimeStockData")
		@CrossOrigin
		public String realTimeStockData(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			return "";
		}
	
		@RequestMapping(value = "/monthWeekStockData")
		@CrossOrigin
		public String monthWeekStockData(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			return "";
		}
		
		@RequestMapping(value = "/fiveMinStockData")
		@CrossOrigin
		public String fiveMinStockData(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			return "";
		}
		
		
		
		@RequestMapping(value = "/hello")
		@CrossOrigin
		public String hello(@RequestParam(value = "name", defaultValue = "World")  String name){
			System.out.println("222");
			
			Timestamp tmpTS = new Timestamp(Long.parseLong("1575014961000"));
			
			return "Hello10, " + name;
		}

		
		@RequestMapping(value = "/hello7")
		@CrossOrigin
		public String hello7(@RequestParam(value = "token", defaultValue = "World")  String token){
			
			//String resp = HttpClientUtils.get("http://quotese.etnet.com.hk/content/mq3/wl_hkStockCollapse.php?code=981", null);
			
			//String token = "%C2%BDQC%C2%A6E%C2%A7JX%3E%C3%B1%C3%9A%C2%9D-j%C2%99l%C2%9E%06%C2%93%C2%8F%C2%A6%C3%B5%C3%85%C3%89";
			String encodedToken = "";
			String limit = "60";
			String minType = "102";
			String code = "6060";
			
			try {
				encodedToken = URLEncoder.encode(token, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				return "encodedToken error";
			}
			
			String resp = HttpClientUtils.get("http://chartse.etnet.com.hk/HttpServer/TransServer/servlet/SecServlet?minType="+minType+"&code="+code+"&uid=BMPuser&token="+encodedToken+"&limit="+limit+"&dataType=hist_today", null);
						
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
