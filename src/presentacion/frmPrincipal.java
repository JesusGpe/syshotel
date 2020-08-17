package presentacion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import com.toedter.components.JLocaleChooser;

import utils.Configuracion;
import utils.Idioma;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private BufferedImage  img;
	Idioma idioma;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame.setDefaultLookAndFeelDecorated(true);
					JDialog.setDefaultLookAndFeelDecorated(true);
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					frmPrincipal frame = new frmPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmPrincipal() {
		idioma = new Idioma("ingles");
		setTitle(idioma.getProperty("reservas"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 487);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		

        try {
            img = ImageIO.read(frmPrincipal.class.getResource("/recursos/fondo.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // A specialized layered pane to be used with JInternalFrames
        desktopPane = new JDesktopPane() {
           
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, desktopPane.getWidth()/4, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };

		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("INCIO");
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnNewMenu.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/inicio.png")));
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem_5 = new JMenuItem("SALIR [F12]");
		mntmNewMenuItem_5.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem_5);

		JMenu mnNewMenu_1 = new JMenu("ADMINISTRACION");
		mnNewMenu_1.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnNewMenu_1.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/administracion.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("TIPO HABITACION [F1]");
		mntmNewMenuItem.setFont(new Font("SansSerif", Font.BOLD, 12));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmTipoHabitacion tipoH = new frmTipoHabitacion(idioma);
					tipoH.show();
					desktopPane.add(tipoH);
					tipoH.setMaximum(true);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("HABITACIONES [F2]");
		mntmNewMenuItem_1.setFont(new Font("SansSerif", Font.BOLD, 12));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmHabitaciones habitaciones = new frmHabitaciones();
					habitaciones.show();
					desktopPane.add(habitaciones);
					habitaciones.setMaximum(true);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}

			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_2 = new JMenu("CLIENTES");
		mnNewMenu_2.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnNewMenu_2.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/clientes.png")));
		menuBar.add(mnNewMenu_2);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("CLIENTES [F3]");
		mntmNewMenuItem_2.setFont(new Font("SansSerif", Font.BOLD, 12));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmClientes clientes = new frmClientes();
					clientes.show();
					desktopPane.add(clientes);
					clientes.setMaximum(true);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);

		JMenu mnNewMenu_3 = new JMenu("RESERVAS");
		mnNewMenu_3.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnNewMenu_3.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/reservas.png")));
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_4 = new JMenuItem("RESERVAS [F4]");
		mntmNewMenuItem_4.setFont(new Font("SansSerif", Font.BOLD, 12));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmReservas reservas = new frmReservas();
					reservas.show();
					desktopPane.add(reservas);
					reservas.setMaximum(true);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_4);

		JMenu mnNewMenu_4 = new JMenu("EMPLEADOS");
		mnNewMenu_4.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnNewMenu_4.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/empleados.png")));
		menuBar.add(mnNewMenu_4);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("EMPLEADOS [F5]");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmEmpleados empleados = new frmEmpleados();
					empleados.show();
					desktopPane.add(empleados);
					empleados.setMaximum(true);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		mntmNewMenuItem_3.setFont(new Font("SansSerif", Font.BOLD, 12));
		mnNewMenu_4.add(mntmNewMenuItem_3);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnProductos.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/productos.png")));
		menuBar.add(mnProductos);
		
		JMenuItem mntmProductosf = new JMenuItem("Productos [F6]");
		mnProductos.add(mntmProductosf);
		
		JMenu mnPagos = new JMenu("Pagos");
		mnPagos.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnPagos.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/pagos.png")));
		menuBar.add(mnPagos);
		
		JMenu mnCargos = new JMenu("Cargos");
		mnCargos.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnCargos.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/cargo.png")));
		menuBar.add(mnCargos);
		
		JMenu mnUsuarios = new JMenu("Usuarios");
		mnUsuarios.setFont(new Font("SansSerif", Font.BOLD, 14));
		mnUsuarios.setIcon(new ImageIcon(frmPrincipal.class.getResource("/recursos/usuario.png")));
		menuBar.add(mnUsuarios);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
					.addGap(22))
		);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 841, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 393, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		contentPane.setLayout(gl_contentPane);
	}
}
