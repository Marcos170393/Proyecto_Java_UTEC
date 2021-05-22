package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.Avion;
import main.Barco;
import main.Main;
import main.Vehiculo;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Inventario extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable Barcos;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario frame = new Inventario();
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
	public Inventario() {
		setTitle("Inventario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inventario.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 11, 414, 239);
		contentPane.add(tabbedPane);
		
		table = new JTable();
		boolean bandera = true;
		for(Vehiculo v: Main.listaVehiculos) {
			if(v instanceof Avion) {
				if(bandera) {
					table.setModel(new DefaultTableModel(
							new Object[][] {
								{v.idVehiculo, v.nombre, v.color , ((Avion) v).longitud, ((Avion) v).cantPasajeros, v.dueno.nombre},
							},
							new String[] {
								"Id", "Tipo", "Color", "Longitud", "Capacidad", "Due\u00F1o"
							}
						) {
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
							Class[] columnTypes = new Class[] {
								Integer.class, String.class, String.class, Double.class, Integer.class, String.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					bandera = false;
				}else {
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[]{v.idVehiculo, v.nombre, v.color , ((Avion) v).longitud, ((Avion) v).cantPasajeros, v.dueno.nombre});
				}
				
			}
			
		}
		
		tabbedPane.addTab("Aviones", null, table, null);
		
		Barcos = new JTable();
		boolean bandera2 = true;
		for(Vehiculo v: Main.listaVehiculos) {
			if(v instanceof Barco) {
				if(bandera2) {
					Barcos.setModel(new DefaultTableModel(
							new Object[][] {
								{v.idVehiculo, v.nombre, v.color,((Barco) v).eslora, ((Barco) v).manga, v.dueno.nombre},
							},
							new String[] {
								"Id", "Tipo", "Color", "Eslora", "Manga", "Due\u00F1o"
							}
						) {
							/**
							 * 
							 */
							private static final long serialVersionUID = 1L;
							Class[] columnTypes = new Class[] {
								Integer.class, String.class, String.class, Double.class, Double.class, String.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					bandera2 = false;
				}else {
					DefaultTableModel model2 = (DefaultTableModel) Barcos.getModel();
					model2.addRow(new Object[]{v.idVehiculo, v.nombre, v.color,((Barco) v).eslora, ((Barco) v).manga, v.dueno.nombre});
				}
			}
		}
		
		tabbedPane.addTab("Barcos", null, Barcos, null);
		
		btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana nueva = new Ventana();
				nueva.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(10, 268, 89, 23);
		contentPane.add(btnNewButton);
	}

}
