package dataBase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import reader.PropertiesReader;

public class DataBase {
	
	public Connection dbConnection(String envir){
		PropertiesReader prop = new PropertiesReader();
		Connection conn;
		Logger log = LogManager.getLogger();
		
		String db;
		String user;
		String pswd;
		String port;
		String srvName;
		
		try {
			 db= prop.reader("DataBase"+envir);
			System.out.println(db);
			 user= prop.reader("User"+envir);
			 System.out.println(user);
			 pswd= prop.reader("Password"+envir);
			 System.out.println(pswd);
			 port= prop.reader("Port"+envir);
			 System.out.println(port);
			 srvName= prop.reader("ServerName"+envir);
			 System.out.println(srvName);
			conn = DriverManager.getConnection(
					"jdbc:postgresql://"+srvName+":"+port+"/"+db,user,pswd);
			return conn;
			
		} catch (SQLException e) {
			log.error("Error trying to connect to DB: " + e);
			return null;
		}
		
	}
	

}
