package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Productos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Productos frame = new Productos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Productos() {
		setTitle("Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdprocucto = new JLabel("ID_procucto");
		lblIdprocucto.setBackground(new Color(248, 248, 255));
		lblIdprocucto.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdprocucto.setBounds(31, 52, 105, 14);
		contentPane.add(lblIdprocucto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
		lblNombre.setBounds(31, 96, 78, 14);
		contentPane.add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Arial", Font.BOLD, 12));
		lblDescripcion.setBounds(31, 158, 105, 14);
		contentPane.add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrecio.setBounds(31, 206, 78, 14);
		contentPane.add(lblPrecio);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 182, 193));
		textField.setBounds(161, 52, 195, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBackground(new Color(255, 182, 193));
		textField_1.setColumns(10);
		textField_1.setBounds(161, 94, 195, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBackground(new Color(255, 182, 193));
		textField_2.setColumns(10);
		textField_2.setBounds(161, 156, 195, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(255, 182, 193));
		textField_3.setColumns(10);
		textField_3.setBounds(161, 204, 195, 20);
		contentPane.add(textField_3);
	}
}
