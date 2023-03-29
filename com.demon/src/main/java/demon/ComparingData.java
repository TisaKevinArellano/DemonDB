package demon;

import java.sql.Connection;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import dao.Insert;
import reader.PropertiesReader;

public class ComparingData {
	
	public void Compare(List<String> Prod,List <String>Dev,Connection connProd,Connection connDev) {
		Logger log = LogManager.getLogger("Comparing Data");
		Iterator<String> iterProd = Prod.iterator();
		Iterator<String> iterDev = Dev.iterator();
		Insert addData = new Insert();
		PropertiesReader prop = new PropertiesReader();
		String[] tablas = prop.reader("tables").toString().split(",");
		String itrprod;
		String itrdev;
		int numTabla=0;
		if(Prod.size()== Dev.size()) {
			while(iterProd.hasNext()) {
				itrprod = iterProd.next();
				itrdev = iterDev.next();
				if(!itrprod.equals(itrdev)) {
					log.info("calling addData");
					addData.Adding(connProd,connDev,tablas[numTabla],itrdev);
				}
				else {
					log.info("Tabla: "+tablas[numTabla]+" no ha cambiado");
				}
				numTabla++;
			}
		}
	}

}
