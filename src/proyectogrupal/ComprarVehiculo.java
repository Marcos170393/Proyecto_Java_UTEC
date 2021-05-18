package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.border.SoftBevelBorder;

import javafx.scene.control.ComboBox;
import main.Avion;
import main.Barco;
import main.Main;
import main.Persona;
import main.Vehiculo;

import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class ComprarVehiculo extends JFrame {
	private String seleccionCombo = ""; 
	private int cantidadPasajeros=0;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ComprarVehiculo frame = new ComprarVehiculo();
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
	public ComprarVehiculo() {
		getContentPane().setFont(new Font("Montserrat", Font.BOLD, 11));
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setTitle("Comprar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 497);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBounds(10, 11, 414, 77);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Jet Aircraft 2016");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel_1.setBounds(102, 11, 130, 29);
		panel.add(lblNewLabel_1);
		
		JButton btnComprarJet = new JButton("Comprar");
		btnComprarJet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esta = false;
				Persona comprador = null;
				while(!esta) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							p.setVehiculo(1, Main.listaVehiculos.get(0));
							comprador = p;
							esta=true;
							break;
						}
					}
					if(comprador==null) {
						Component Frame = null;
						JOptionPane.showMessageDialog(Frame,"No se encontro una persona con su id","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
			
		});
		
		btnComprarJet.setBounds(301, 46, 89, 23);
		panel.add(btnComprarJet);
		
		Label label = new Label("Color:      azul");
		label.setBounds(102, 46, 105, 22);
		panel.add(label);
		
		Label label_1 = new Label("Capacidad:         2");
		label_1.setBounds(274, 11, 130, 22);
		panel.add(label_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/jet_1_chico.jpg")));
		lblNewLabel_5.setBounds(0, 0, 77, 77);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ventana abrir = new ventana();
				abrir.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 424, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 99, 414, 67);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("747");
		lblNewLabel_1_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(104, 11, 89, 29);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnComprar747 = new JButton("Comprar");
		btnComprar747.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esta = false;
				Persona comprador = null;
				while(!esta) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							p.setVehiculo(2, Main.listaVehiculos.get(1));
							comprador = p;
							esta=true;
							break;
						}
					}
					if(comprador==null) {
						Component Frame = null;
						JOptionPane.showMessageDialog(Frame,"No se encontro una persona con su id","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnComprar747.setBounds(301, 39, 89, 23);
		panel_1.add(btnComprar747);
		
		Label label_2 = new Label("Color:        Negro");
		label_2.setBounds(104, 40, 107, 22);
		panel_1.add(label_2);
		
		Label label_1_1 = new Label("Capacidad:        200");
		label_1_1.setBounds(273, 11, 141, 22);
		panel_1.add(label_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/747.jpg")));
		lblNewLabel_4.setBounds(0, 0, 79, 67);
		panel_1.add(lblNewLabel_4);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(10, 177, 414, 67);
		getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Barco Naval");
		lblNewLabel_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(103, 12, 141, 29);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JButton btnComprarBarco_Naval = new JButton("Comprar");
		btnComprarBarco_Naval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esta = false;
				Persona comprador = null;
				while(!esta) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							p.setVehiculo(3, Main.listaVehiculos.get(2));
							comprador = p;
							esta=true;
							break;
						}
					}
					if(comprador==null) {
						Component Frame = null;
						JOptionPane.showMessageDialog(Frame,"No se encontro una persona con su id","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnComprarBarco_Naval.setBounds(301, 39, 89, 23);
		panel_1_1.add(btnComprarBarco_Naval);
		
		Label label_2_1 = new Label("Color:        Gris");
		label_2_1.setBounds(103, 40, 130, 22);
		panel_1_1.add(label_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/barco_naval.png")));
		lblNewLabel_2.setBounds(0, 0, 82, 67);
		panel_1_1.add(lblNewLabel_2);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1.setBounds(10, 255, 414, 67);
		getContentPane().add(panel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Lancha con Motor");
		lblNewLabel_1_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(102, 11, 140, 29);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnComprarBarco_Naval_1 = new JButton("Comprar");
		btnComprarBarco_Naval_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esta = false;
				Persona comprador = null;
				while(!esta) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							p.setVehiculo(4, Main.listaVehiculos.get(3));
							comprador = p;
							esta=true;
							break;
						}
					}
					if(comprador==null) {
						Component Frame = null;
						JOptionPane.showMessageDialog(Frame,"No se encontro una persona con su id","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnComprarBarco_Naval_1.setBounds(301, 33, 89, 23);
		panel_1_1_1.add(btnComprarBarco_Naval_1);
		
		Label label_2_1_1 = new Label("Color:        Gris");
		label_2_1_1.setBounds(102, 33, 130, 22);
		panel_1_1_1.add(label_2_1_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/lancha.png")));
		lblNewLabel.setBounds(0, 0, 80, 67);
		panel_1_1_1.add(lblNewLabel);
		
		JPanel panel_1_1_1_1 = new JPanel();
		panel_1_1_1_1.setLayout(null);
		panel_1_1_1_1.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1_1_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1_1_1.setBounds(10, 333, 414, 67);
		getContentPane().add(panel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("BMW    Z4");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Montserrat", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(108, 11, 102, 29);
		panel_1_1_1_1.add(lblNewLabel_1_1_1_1_1);
		
		JButton btnComprarBarco_Naval_1_1 = new JButton("Comprar");
		btnComprarBarco_Naval_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean esta = false;
				Persona comprador = null;
				while(!esta) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							p.setVehiculo(5, Main.listaVehiculos.get(4));
							comprador = p;
							esta=true;
							break;
						}
					}
					if(comprador==null) {
						Component Frame = null;
						JOptionPane.showMessageDialog(Frame,"No se encontro una persona con su id","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnComprarBarco_Naval_1_1.setBounds(301, 33, 89, 23);
		panel_1_1_1_1.add(btnComprarBarco_Naval_1_1);
		
		Label label_2_1_1_1 = new Label("Color:        Gris");
		label_2_1_1_1.setBounds(108, 33, 130, 22);
		panel_1_1_1_1.add(label_2_1_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/z4.png")));
		lblNewLabel_3.setBounds(0, 0, 81, 67);
		panel_1_1_1_1.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Historial");
		btnNewButton.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/historial.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(Persona a: Main.listado) {
					if(a.getListaVehiculos().size() > 0) {
						System.out.print(a.nombre + " " + "compro: ");
						a.getListaVehiculos().forEach((k,v)->System.out.println("Clave " + k + ". Vehiculo: " + v));
					}
				}
			}
		});
		btnNewButton.setBounds(296, 424, 128, 23);
		getContentPane().add(btnNewButton);
	}
}
