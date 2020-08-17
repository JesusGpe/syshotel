package utils;

import java.util.Properties;

public class Idioma extends Properties{
	private static final long serialVersionUID = 1L;
	
	public Idioma(String idioma) {
		switch (idioma) {
		case "ingles":
			getProperties("ingles.properties");
			break;

		default:
			break;
		}
	}
	
	private void getProperties(String idioma) {
		try {
			this.load(getClass().getResourceAsStream(idioma));
		} catch (Exception e) {
			System.out.println("erro al cargar idioma" + e.getMessage());
		}
	}
	
}
