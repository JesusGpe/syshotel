package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import datos.vTipoHabitacion;
import logica.fTipoHabitacion;
import utils.Idioma;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class frmTipoHabitacion extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtBuscar;
	private JTable table;
	private JButton btnGuardar;
	private JButton btnCanelar;
	private JButton btnNuevo;

	fTipoHabitacion fTipoH = new fTipoHabitacion();
	private JTextArea txtDescripcion;
	private boolean isEdit = false;

	public frmTipoHabitacion(Idioma idioma) {
		getContentPane().setBackground(Color.WHITE);
		setClosable(true);
		setBounds(100, 100, 887, 500);

		JLabel lblNewLabel = new JLabel("Tipo_habtacion");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Agregar/Editar", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "/Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(20)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
						.addComponent(lblNewLabel))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(22).addComponent(lblNewLabel).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
						.addContainerGap()));

		JLabel lblNewLabel_2 = new JLabel("BUSCAR");

		txtBuscar = new JTextField();
		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				mostrarTipoHabitacion(txtBuscar.getText());
			}
		});
		txtBuscar.setColumns(10);

		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (row != -1) {
					vTipoHabitacion tipoH = new vTipoHabitacion();
					tipoH.setId_tipohabitacion(Integer.parseInt(table.getValueAt(row, 0).toString()));
					int opc = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el tipo habitacion?", "Info",
							JOptionPane.YES_NO_OPTION);
					if (opc == JOptionPane.YES_OPTION) {
						if (fTipoH.eliminarTipoHabitacion(tipoH)) {
							JOptionPane.showMessageDialog(null, "Tipo habitacion elimiado con exito");
							desHabilitar();
							mostrarTipoHabitacion("");
						} else {
							JOptionPane.showMessageDialog(null, "Tipo habitacion no eliminado");
							desHabilitar();
							mostrarTipoHabitacion("");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Debe de seleccionar un registro");
				}

			}
		});
		button.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/eliminar.png")));

		JScrollPane scrollPane_1 = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNewLabel_2)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtBuscar, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap()));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup().addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup().addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_2)
										.addComponent(txtBuscar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE).addContainerGap()));

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// obtenemos la fila donde se hizo click
				int row = table.getSelectedRow();
				habilitar();
				txtId.setText(table.getValueAt(row, 0).toString());
				txtNombre.setText(table.getValueAt(row, 1).toString());
				txtDescripcion.setText(table.getValueAt(row, 2).toString());
				btnGuardar.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/editar.png")));
				btnGuardar.setText("Editar");
				isEdit = true;

			}
		});
		table.setModel(
				new DefaultTableModel(new Object[][] { { "1", "SUITE", "DOS HABITACIONES DOS BA\u00D1OS ETC" }, },
						new String[] { "ID", "NOMBRE", "DESCRIPCION" }));
		table.getColumnModel().getColumn(1).setPreferredWidth(113);
		scrollPane_1.setViewportView(table);
		panel_1.setLayout(gl_panel_1);

		JLabel lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));

		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setFont(new Font("SansSerif", Font.PLAIN, 14));

		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();

		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("SansSerif", Font.PLAIN, 14));

		txtId = new JTextField();
		txtId.setEnabled(false);
		txtId.setColumns(10);

		btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				habilitar();
			}
		});
		btnNuevo.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/nuevo.png")));

		btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (txtNombre.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "El nombre es requerido");
					txtNombre.requestFocus();
				} else {
					vTipoHabitacion tipoHabitacion = new vTipoHabitacion();
					tipoHabitacion.setNombre(txtNombre.getText());
					tipoHabitacion.setDescripcion(txtDescripcion.getText());
					if (!isEdit) {
						if (fTipoH.insertarTipoHabitacion(tipoHabitacion)) {
							JOptionPane.showMessageDialog(null, "Tipo habitacion registrado con exito");
							desHabilitar();
							mostrarTipoHabitacion("");

						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido registrar el tipo habitacion");
						}
					} else {
						tipoHabitacion.setId_tipohabitacion(Integer.parseInt(txtId.getText()));
						if (fTipoH.editarTipoHabitacion(tipoHabitacion)) {
							JOptionPane.showMessageDialog(null, "Tipo habitacion editado con exito");
							desHabilitar();
							mostrarTipoHabitacion("");

						} else {
							JOptionPane.showMessageDialog(null, "No se ha podido editar el tipo habitacion");
						}
					}
				}

			}
		});
		btnGuardar.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/guardar.png")));

		btnCanelar = new JButton("Cancelar");
		btnCanelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desHabilitar();
			}
		});
		btnCanelar.setEnabled(false);
		btnCanelar.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/cancelar.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnNuevo, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, 113,
												Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(btnCanelar, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup().addGroup(gl_panel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_panel.createSequentialGroup().addGap(5).addComponent(lblDescripcion))
										.addComponent(lblNewLabel_1).addComponent(lblId, GroupLayout.PREFERRED_SIZE, 59,
												GroupLayout.PREFERRED_SIZE))
										.addGap(13)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(txtId, GroupLayout.PREFERRED_SIZE, 57,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 226,
														Short.MAX_VALUE))))
						.addContainerGap()));
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(16)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel_1)
										.addComponent(
												txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_panel.createSequentialGroup().addGap(26).addComponent(lblDescripcion,
														GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(scrollPane,
														GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnGuardar)
										.addComponent(btnNuevo).addComponent(btnCanelar))
								.addGap(28)));

		txtDescripcion = new JTextArea();
		txtDescripcion.setEnabled(false);
		scrollPane.setViewportView(txtDescripcion);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

		mostrarTipoHabitacion("");

	}

	public void mostrarTipoHabitacion(String buscar) {
		table.setModel(fTipoH.listarTipoHabitacion(buscar));
	}

	public void habilitar() {

		txtNombre.setEnabled(true);
		txtDescripcion.setEnabled(true);

		btnNuevo.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnCanelar.setEnabled(true);
	}

	public void desHabilitar() {

		txtNombre.setEnabled(false);
		txtDescripcion.setEnabled(false);

		txtNombre.setText("");
		txtDescripcion.setText("");
		txtId.setText("");

		btnNuevo.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnCanelar.setEnabled(false);

		btnGuardar.setIcon(new ImageIcon(frmTipoHabitacion.class.getResource("/recursos/guardar.png")));
		btnGuardar.setText("Guardar");
		isEdit = false;
	}
}
