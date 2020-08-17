package logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

import datos.vHabitacion;
import datos.vTipoHabitacion;

public class fHabitaciones {
	Conexion con = Conexion.getIsntance();
	private Connection conexion = con.getconnection();
	private String sql = "";

	public DefaultTableModel listarHabitaciones(String buscar) {
		DefaultTableModel modelo;
		String titulos[] = { "ID", "NUMERO", "COSTO","DESCRIPCION","IDTIPO","TIPO","ESTADO" };
		String datos[] = new String[7];
		modelo = new DefaultTableModel(null, titulos);
		sql = "SELECT h.*,th.nombre as tipoH FROM habitaciones h INNER JOIN tipo_habitacion th ON h.id_tipohabitacion = th.id_tipohabitacion WHERE numero LIKE '%" + buscar + "%'";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				datos[0] = rs.getString("id_habitacion");
				datos[1] = rs.getString("numero");
				datos[2] = rs.getString("costo");
				datos[3] = rs.getString("descripcion");
				datos[4] = rs.getString("id_tipohabitacion");
				datos[5] = rs.getString("tipoH");
				datos[6] = rs.getString("estado");
				modelo.addRow(datos);
			}
		} catch (Exception e) {
			System.out.println("error al traer los registros" + e.getMessage());
		}

		return modelo;
	}

	public boolean insertarHabitacion(vHabitacion habitacion) {
		try {
			CallableStatement insert = conexion.prepareCall("{call insertarHabitacion (?,?,?,?,?)}");
			insert.setInt(1, habitacion.getId_tipoHabitacion());
			insert.setInt(2, habitacion.getNumero());
			insert.setDouble(3, habitacion.getCosto());
			insert.setString(4, habitacion.getDescripcion());
			insert.setString(5, habitacion.getEstado());
			int res = insert.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean editarHabitacion(vHabitacion habitacion) {
		try {
			CallableStatement edit = conexion.prepareCall("{call editar_habitacion (?,?,?,?,?,?)}");
			edit.setInt(1, habitacion.getId_habitacion());
			edit.setInt(2, habitacion.getNumero());
			edit.setDouble(3, habitacion.getCosto());
			edit.setString(4, habitacion.getDescripcion());
			edit.setInt(5, habitacion.getId_tipoHabitacion());
			edit.setString(6, habitacion.getEstado());
			int res = edit.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}
	
	public boolean eliminarHabitacion(vHabitacion habitacion) {
		try {
			CallableStatement delete = conexion.prepareCall("{call eliminar_habitacion (?)}");
			delete.setInt(1, habitacion.getId_habitacion());
			int res = delete.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

}
