package com.example.demo;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;


//copied from /Users/victor/Downloads/OpenAPI/sec-get-stock-quote-master/src/main/java/com/ccba/openapi/ccbaopenapi/jdbc/BasicDBSource.java



public class MongoDBHelper  {
	
    //private Properties props;
    private String url;
    //private String user;
    //private String passwd;
    private int max; 
    private static MongoClient instance;
    
    public MongoDBHelper() {
       
    }
    
    
    public static MongoClient getClient(){
        if(instance == null){
            instance = MongoClients.create("mongodb+srv://lamvictor:080979@richportaldb.f6s6r.mongodb.net/RichPortal?retryWrites=true&w=majority");
        } 
        return instance;
    }
    
//    public BasicDBSource(String configFile) throws IOException, 
//                                                     ClassNotFoundException {
//        props = new Properties();
//        props.load(new FileInputStream(configFile));
//        
//        String ip = props.getProperty("address");
//		String database = props.getProperty("database");
//        
//        url = "jdbc:sqlserver://"+ip+";databaseName="+database;
//        //url = props.getProperty("url");
//        
//        String decrypted[] = DoDecrypt.decryptJdbcPassword();
//        user = decrypted[0];
//        passwd = decrypted[1];
//        
//        max = 10;//Integer.parseInt(props.getProperty("poolmax"));
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        
//        connections = new ArrayList<Connection>();
//    }
//    
//    public synchronized Connection getConnection() 
//                                                    throws SQLException {
//        if(connections.size() == 0) {
//            return DriverManager.getConnection(url, user, passwd);
//        }
//        else {
//            int lastIndex = connections.size() - 1;
//            return connections.remove(lastIndex);
//        }
//    }
//    
//    public synchronized void closeConnection(Connection conn) 
//                                                        throws SQLException {
//        if(connections.size() == max) {
//            conn.close();
//        }
//        else {
//            connections.add(conn);
//        }
//    }



}


