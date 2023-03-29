package reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PropertiesReader {
	
	public String reader(String property) {
		String properties = "C:\\Users\\n6y\\eclipse-workspace\\com.demon\\src\\config.properties";
		Properties proper= new Properties();
		Logger log = LogManager.getLogger();
		try {
			proper.load(new FileReader(properties));
			return proper.getProperty(property);
		} catch (FileNotFoundException e) {
			log.error("File "+properties+" doesn`t exist:" + e);
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
