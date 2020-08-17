package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuracion extends Properties{

	private static final long serialVersionUID = 1L;

	public void getProperties() {
		try {
			this.load(getClass().getResourceAsStream("config.properties"));
		} catch (Exception e) {
			System.out.println("erro al cargar config" + e.getMessage());
		}
	}
	
	public void setPropierties(String key, String value) {
		System.out.println("sii entre");
		Properties prop = new Properties();
		InputStream config = getClass().getResourceAsStream("config.properties");
		try {
			prop.load(config);
			prop.put(key, value);
			prop.store(new FileOutputStream("config.properties"), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
