package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class frmLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(373, 313);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnIdiomas = new JMenu("Idiomas");
		menuBar.add(mnIdiomas);
		mnIdiomas.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/idiomas.png")));
		
		JMenu mnEspañol = new JMenu("Espa\u00F1ol");
		mnIdiomas.add(mnEspañol);
		mnEspañol.setIcon(new ImageIcon("C:\\Users\\Yolitzy Gpe BL\\eclipse-workspace\\syshotel\\syshotel\\src\\recursos\\espa\u00F1ol.png"));
		
		JMenu mnIngles = new JMenu("Ingles");
		mnIdiomas.add(mnIngles);
		mnIngles.setIcon(new ImageIcon("C:\\Users\\Yolitzy Gpe BL\\eclipse-workspace\\syshotel\\syshotel\\src\\recursos\\inglesss.png"));
		
		
		JMenu mnItaliano = new JMenu("Italiano");
		mnIdiomas.add(mnItaliano);
		mnItaliano.setIcon(new ImageIcon("C:\\Users\\Yolitzy Gpe BL\\eclipse-workspace\\syshotel\\syshotel\\src\\recursos\\italia.png"));

		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("INGRESAR_AL_SISTEMA");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("USUARIO");
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CONTRASE\u00D1A");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		txtContrasena = new JPasswordField();
		
		JButton btnIngresar = new JButton("INGRESAR");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String usuario = txtUsuario.getText();
				String password = String.valueOf(txtContrasena.getPassword());
				if(usuario.equals("admin") && password.equals("123")) {
					dispose();
					frmPrincipal principal = new frmPrincipal();
					principal.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
				
			}
		});
		btnIngresar.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Administrador(a)", "Empleado(a)"}));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(81)
					.addComponent(lblNewLabel)
					.addContainerGap(81, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(111)
					.addComponent(btnIngresar, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(117, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(comboBox, Alignment.LEADING, 0, 226, Short.MAX_VALUE)
						.addComponent(txtContrasena, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2, Alignment.LEADING)
						.addComponent(txtUsuario, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING))
					.addGap(70))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnIngresar)
					.addContainerGap(25, Short.MAX_VALUE))
		);
		gl_contentPane.linkSize(SwingConstants.HORIZONTAL, new Component[] {txtUsuario, txtContrasena});
		contentPane.setLayout(gl_contentPane);
	}
}
