package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.vHabitacion;
import datos.vTipoHabitacion;
import logica.fHabitaciones;
import logica.fTipoHabitacion;
import utils.Validacion;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmHabitaciones extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNumeroHabitacion;
	private JTextField txtCosto;
	private JTextField txtId;
	private JTextField txtBuscar;
	private JTable table;

	fTipoHabitacion fTipoH = new fTipoHabitacion();
	fHabitaciones fHabitaciones = new fHabitaciones();
	Validacion vali = new Validacion();

	private JButton btnCancelar;
	private JButton btnNuevo;
	private JButton btnGuardar;
	private JComboBox<String> cmbEstado;
	private JComboBox<vTipoHabitacion> cmbTipoHabitacion;
	private JTextArea txtDescripcion;

	private boolean isEdit = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmHabitaciones frame = new frmHabitaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmHabitaciones() {
		setClosable(true);
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 885, 510);

		JLabel lblNewLabel = new JLabel("HABITACIONES");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 22));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Agregar/Editar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "/Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addGroup(groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)))
						.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap().addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 418,
										Short.MAX_VALUE)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 418,
										Short.MAX_VALUE))
						.addContainerGap()));

		JLabel lblNewLabel_4 = new JLabel("BUSCAR");

		txtBuscar = new JTextField();
		txtBuscar.setColumns(10);

		JButton btnEliminar = new JButton("");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					vHabitacion habitacion = new vHabitacion();
					habitacion.setId_habitacion(Integer.parseInt(table.getValueAt(row, 0).toString()));
					int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar la habitacion?", "Info",
							JOptionPane.YES_NO_OPTION);
					if (opc == JOptionPane.YES_OPTION) {
						if (fHabitaciones.eliminarHabitacion(habitacion)) {
							JOptionPane.showMessageDialog(null, "Habitacion elimiada con exito");
							desHabilitar();
							mostrarHabitaciones("");
						} else {
							JOptionPane.showMessageDialog(null, "Habitacion no eliminada");
							desHabilitar();
							mostrarHabitaciones("");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe de seleccionar un registro");
				}

			}

		});
		btnEliminar.setIcon(new ImageIcon(frmHabitaciones.class.getResource("/recursos/eliminar.png")));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_panel_1.createSequentialGroup().addContainerGap().addGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_4)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnEliminar,
										GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
						.addGap(1)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_4)
										.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();

				txtId.setText(table.getValueAt(row, 0).toString());
				txtNumeroHabitacion.setText(table.getValueAt(row, 1).toString());
				txtCosto.setText(table.getValueAt(row, 2).toString());
				txtDescripcion.setText(table.getValueAt(row, 3).toString());

				cmbEstado.setSelectedItem(table.getValueAt(row, 6).toString());

				btnGuardar.setIcon(new ImageIcon(frmHabitaciones.class.getResource("/recursos/editar.png")));
				isEdit = true;
				habilitar();

			}
		});
		table.setModel(new DefaultTableModel(
				new Object[][] { { "1", "1", "1200.00", "CAMA MUY COMODA Y ESAS COSAS", "SUITE", "DISPONIBLE" }, },
				new String[] { "ID", "NUMERO", "COSTO", "DESCRIPCION", "TIPO", "ESTADO" }));
		scrollPane_1.setViewportView(table);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("# HABITACION");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 14));

		txtNumeroHabitacion = new JTextField();
		txtNumeroHabitacion.setEnabled(false);
		txtNumeroHabitacion.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("COSTO");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 14));

		txtCosto = new JTextField();
		txtCosto.setEnabled(false);
		txtCosto.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("DESCRIPCION");
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("SansSerif", Font.BOLD, 14));

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);

		JLabel lblTipo = new JLabel("TIPO");
		lblTipo.setFont(new Font("SansSerif", Font.BOLD, 14));

		cmbTipoHabitacion = new JComboBox<vTipoHabitacion>();

		cmbTipoHabitacion.setEnabled(false);

		JLabel lblEstado = new JLabel("ESTADO");
		lblEstado.setFont(new Font("SansSerif", Font.BOLD, 14));

		cmbEstado = new JComboBox<String>();
		cmbEstado.setEnabled(false);
		cmbEstado.setModel(
				new DefaultComboBoxModel<String>(new String[] { "", "DISPONIBLE", "OCUPADA", "EN_MANTENIMIENTO" }));

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitar();
			}
		});
		btnNuevo.setIcon(new ImageIcon(frmHabitaciones.class.getResource("/recursos/nuevo.png")));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vHabitacion habitacion = new vHabitacion();
				vTipoHabitacion s = (vTipoHabitacion) cmbTipoHabitacion.getSelectedItem();
				habitacion.setId_tipoHabitacion(s.getId_tipohabitacion());
				habitacion.setNumero(Integer.parseInt(txtNumeroHabitacion.getText()));
				habitacion.setCosto(Double.parseDouble(txtCosto.getText()));
				habitacion.setDescripcion(txtDescripcion.getText());
				habitacion.setEstado(cmbEstado.getSelectedItem().toString());
				if (!isEdit) {

					if (fHabitaciones.insertarHabitacion(habitacion)) {
						JOptionPane.showMessageDialog(null, "Habitacion guardada con exito");
						mostrarHabitaciones("");
						desHabilitar();
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podigo registrar la habitacion");
					}
				} else {
					habitacion.setId_habitacion(Integer.parseInt(txtId.getText()));
					if (fHabitaciones.editarHabitacion(habitacion)) {
						JOptionPane.showMessageDialog(null, "Habitacion editada con exito");
						mostrarHabitaciones("");
						desHabilitar();
					} else {
						JOptionPane.showMessageDialog(null, "No se ha podido editar la habiacion");
					}
				}

			}
		});
		btnGuardar.setIcon(new ImageIcon(frmHabitaciones.class.getResource("/recursos/guardar.png")));

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desHabilitar();
			}
		});
		btnCancelar.setEnabled(false);
		btnCancelar.setIcon(new ImageIcon(frmHabitaciones.class.getResource("/recursos/cancelar.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblNewLabel_3).addGap(18)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 93,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(cmbTipoHabitacion, 0, 264, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 93,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18).addComponent(cmbEstado, 0, 264, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1).addComponent(lblNewLabel_2)
												.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 93,
														GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 96,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNumeroHabitacion, GroupLayout.DEFAULT_SIZE, 260,
														Short.MAX_VALUE)
												.addComponent(txtCosto, GroupLayout.DEFAULT_SIZE, 260,
														Short.MAX_VALUE))))
						.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
								.addComponent(btnNuevo, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE).addGap(6)
								.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnCancelar, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
								.addGap(7)))));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
								.addComponent(txtNumeroHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
								.addComponent(txtCosto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel_3)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cmbTipoHabitacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTipo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnNuevo)
								.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		txtDescripcion = new JTextArea();
		txtDescripcion.setEnabled(false);
		scrollPane.setViewportView(txtDescripcion);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		fTipoH.llenaCombo(cmbTipoHabitacion);
		mostrarHabitaciones("");

		vali.soloNumero(txtCosto);
		vali.soloNumero(txtNumeroHabitacion);

	}

	public void mostrarHabitaciones(String buscar) {
		table.setModel(fHabitaciones.listarHabitaciones(buscar));
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMaxWidth(0);
		table.getTableHeader().getColumnModel().getColumn(4).setMinWidth(0);
	}

	public void habilitar() {

		txtNumeroHabitacion.setEnabled(true);
		txtCosto.setEnabled(true);
		txtDescripcion.setEnabled(true);
		cmbTipoHabitacion.setEnabled(true);
		cmbEstado.setEnabled(true);

		btnNuevo.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCancelar.setEnabled(true);

	}

	public void desHabilitar() {

		txtNumeroHabitacion.setEnabled(false);
		txtCosto.setEnabled(false);
		txtDescripcion.setEnabled(false);
		cmbTipoHabitacion.setEnabled(false);
		cmbEstado.setEnabled(false);

		txtNumeroHabitacion.setText("");
		txtCosto.setText("");
		txtDescripcion.setText("");
		cmbTipoHabitacion.setSelectedIndex(0);
		cmbEstado.setSelectedIndex(0);
		txtId.setText("");

		btnNuevo.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCancelar.setEnabled(false);

		isEdit = false;
	}

}
