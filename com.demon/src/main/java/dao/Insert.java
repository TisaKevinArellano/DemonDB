package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import reader.PropertiesReader;

public class Insert {
	
	public void Adding(Connection connProd,Connection connDev,String tabla,String idProd) {
		Select getAllData = new Select();
		Logger log = LogManager.getLogger("Insert");
		List<String> dataToInsert = new ArrayList<String>();
		dataToInsert = getAllData.SelectNewData(connProd,tabla,idProd);
		Iterator<String> dtInsIte = dataToInsert.iterator();
		PropertiesReader prop = new PropertiesReader();
		int RESULT;
		String insrt = null;
		String columns = null;
		columns = prop.reader(tabla);
		
		
		while(dtInsIte.hasNext()){
			try {
				//String valuswonull =dtInsIte.next().replace("'null'", "");
				insrt = "INSERT INTO "+tabla+columns+" VALUES "+dtInsIte.next();
				PreparedStatement PRPSTM =connDev.prepareStatement(insrt);
				RESULT = PRPSTM.executeUpdate();
				log.debug(RESULT);
			} catch (SQLException e) {
				log.error("Tabla: "+tabla+" query: "+insrt+e);
			}
		}
		
		
	}
	
}
