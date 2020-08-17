package logica;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {
	private static Conexion instancia;
	private Connection conexion = null;

	public static Conexion getIsntance() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getconnection() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conexion = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=SYSHOTEL", "sa", "123");
		} catch (Exception e) {
			conexion = null;
			JOptionPane.showMessageDialog(null, "NO SE PUDO ESTABLECER LA CONEXION" + e.getMessage(), "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}
		return conexion;

	}

}
