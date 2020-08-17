package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		setTitle("Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIdusuario = new JLabel("ID_usuario:");
		lblIdusuario.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdusuario.setBounds(192, 33, 65, 14);
		contentPane.add(lblIdusuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Arial", Font.BOLD, 12));
		lblContrasea.setBounds(192, 108, 88, 14);
		contentPane.add(lblContrasea);
		
		JLabel lblIdempleado = new JLabel("ID_empleado:");
		lblIdempleado.setFont(new Font("Arial", Font.BOLD, 12));
		lblIdempleado.setBounds(192, 176, 88, 14);
		contentPane.add(lblIdempleado);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(117, 133, 214, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(117, 68, 214, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(117, 216, 214, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
