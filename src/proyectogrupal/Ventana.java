package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Main;
import main.Persona;

import java.awt.Font;
import javax.swing.JList;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.Insets;
import java.awt.Cursor;

public class Ventana extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setResizable(false);
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setFocusable(false);
		menuBar.setBorder(null);
		menuBar.setForeground(Color.DARK_GRAY);
		menuBar.setBackground(Color.DARK_GRAY);
		menuBar.setFont(new Font("Montserrat", Font.BOLD, 12));
		menuBar.setBounds(0, 0, 601, 38);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Men\u00FA");
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnNewMenu.setMargin(new Insets(4, 2, 4, 2));
		mnNewMenu.setBorder(null);
		mnNewMenu.setBackground(Color.DARK_GRAY);
		mnNewMenu.setForeground(Color.LIGHT_GRAY);
		mnNewMenu.setFont(new Font("Montserrat", Font.BOLD, 12));
		mnNewMenu.setIcon(null);
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Alta de personas");
		mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem.setMargin(new Insets(4, 0, 0, 2));
		mntmNewMenuItem.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/Add.png")));
		mntmNewMenuItem.setBorder(null);
		mntmNewMenuItem.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			AltaPersona nuevaVentanaAlta = new AltaPersona();
			nuevaVentanaAlta.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ver listado");
		mntmNewMenuItem_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem_2.setMargin(new Insets(4, 0, 2, 0));
		mntmNewMenuItem_2.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/List.png")));
		mntmNewMenuItem_2.setBorder(null);
		mntmNewMenuItem_2.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_2.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MostrarLista nueva = new MostrarLista();
				nueva.setVisible(true);
				
			}
		});
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Modificar Datos");
		mntmNewMenuItem_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem_1.setMargin(new Insets(4, 0, 2, 0));
		mntmNewMenuItem_1.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/Edit.png")));
		mntmNewMenuItem_1.setBorder(null);
		mntmNewMenuItem_1.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_1.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Modificar nuevaVentana = new Modificar();
				dispose();
				nuevaVentana.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Alta de Veh\u00EDculo");
		mnNewMenu_1.setBackground(Color.LIGHT_GRAY);
		mnNewMenu_1.setForeground(Color.DARK_GRAY);
		mnNewMenu_1.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/checked.png")));
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Alta de Barco");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaBarco nuevaVentana = new AltaBarco();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Alta de Avion");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaAvion nuevaVentana = new AltaAvion();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_Inventario = new JMenuItem("Inventario");
		mntmNewMenuItem_Inventario.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_Inventario.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_Inventario.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/warehouse.png")));
		mntmNewMenuItem_Inventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventario nuevaVentana = new Inventario();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_Inventario);
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Comprar Vehiculo");
		mntmNewMenuItem_3.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/buy.png")));
		mntmNewMenuItem_3.setForeground(Color.DARK_GRAY);
		mntmNewMenuItem_3.setBackground(Color.LIGHT_GRAY);
		mntmNewMenuItem_3.setBorder(null);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ComprarVehiculo abrir = new ComprarVehiculo();
				abrir.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

			JMenuItem mntmNewMenuItem_4 = new JMenuItem("Panel de control");
			mntmNewMenuItem_4.setBackground(Color.LIGHT_GRAY);
			mntmNewMenuItem_4.setForeground(Color.DARK_GRAY);
			mntmNewMenuItem_4.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/control-panel.png")));
			mntmNewMenuItem_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					PanelDeControl abrir = new PanelDeControl();
					abrir.setVisible(true);
				}
			});
		
			mnNewMenu.add(mntmNewMenuItem_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon(Ventana.class.getResource("/proyectogrupal/Imagen/Logo_Wild Coders(Sin fondo).png")));
		lblNewLabel.setBounds(165, 90, 227, 209);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Gabriel Pose");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(20, 378, 75, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Martin Rodriguez");
		lblNewLabel_2_1.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(105, 378, 103, 14);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nahuel Morales");
		lblNewLabel_2_2.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_2_2.setBounds(227, 378, 103, 14);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Florencia Chick");
		lblNewLabel_2_3.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_2_3.setBounds(452, 378, 109, 14);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Marcos Correa");
		lblNewLabel_2_4.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_2_4.setBounds(340, 378, 126, 14);
		contentPane.add(lblNewLabel_2_4);
	}
}
