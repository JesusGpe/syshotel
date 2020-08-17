package logica;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import datos.vTipoHabitacion;

public class fTipoHabitacion {
	Conexion con = Conexion.getIsntance();
	private Connection conexion = con.getconnection();
	private String sql = "";

	public DefaultTableModel listarTipoHabitacion(String buscar) {
		DefaultTableModel modelo;
		String titulos[] = { "ID", "NOMBRE", "DESCRIPCION" };
		String datos[] = new String[3];
		modelo = new DefaultTableModel(null, titulos);
		sql = "SELECT * FROM tipo_habitacion WHERE nombre LIKE '%" + buscar + "%'";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				datos[0] = rs.getString("id_tipohabitacion");
				datos[1] = rs.getString("nombre");
				datos[2] = rs.getString("descripcion");
				modelo.addRow(datos);
			}
		} catch (Exception e) {
			System.out.println("error al traer los registos" + e.getMessage());
		}

		return modelo;
	}

	public boolean insertarTipoHabitacion(vTipoHabitacion tipoHabitacion) {
		try {
			CallableStatement insert = conexion.prepareCall("{call insertar_tipohabitacion (?,?)}");
			insert.setString(1, tipoHabitacion.getNombre());
			insert.setString(2, tipoHabitacion.getDescripcion());
			int res = insert.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean editarTipoHabitacion(vTipoHabitacion tipoHabitacion) {
		try {
			CallableStatement edit = conexion.prepareCall("{call editar_tipohabitacion (?,?,?)}");
			edit.setInt(1, tipoHabitacion.getId_tipohabitacion());
			edit.setString(2, tipoHabitacion.getNombre());
			edit.setString(3, tipoHabitacion.getDescripcion());
			int res = edit.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public boolean eliminarTipoHabitacion(vTipoHabitacion tipoHabitacion) {
		try {
			CallableStatement delete = conexion.prepareCall("{call eliminar_tipohabitacion (?)}");
			delete.setInt(1, tipoHabitacion.getId_tipohabitacion());
			int res = delete.executeUpdate();
			if (res == 1) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;
	}

	public void llenaCombo(JComboBox<vTipoHabitacion> combo) {
		sql = "SELECT * FROM tipo_habitacion";
		try {
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				vTipoHabitacion tipo = new vTipoHabitacion(rs.getInt("id_tipohabitacion"), rs.getString("nombre"),
						rs.getString("Descripcion"));
				combo.addItem(tipo);
			}
		} catch (Exception e) {
			System.out.println("error al llenar el combo" + e.getMessage());
		}
	}

}
