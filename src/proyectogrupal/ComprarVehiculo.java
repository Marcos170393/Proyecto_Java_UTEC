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
	private int contador = 0;
	
	
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
		lblNewLabel_1.setBounds(101, 22, 130, 29);
		panel.add(lblNewLabel_1);
		
		JButton btnComprarJet = new JButton("Comprar");
		btnComprarJet.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				boolean estaPersona = false;
				boolean estaVehiculo = false;
				Persona comprador = null;
				
				Vehiculo temp = null;
				
				while(!estaVehiculo) {
					int idV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del Jet")); 
							for(Vehiculo v: Main.listaVehiculos) {
								if(v.idVehiculo == idV) {
									estaVehiculo = true;
									if(v.dueno.idPersona == 0) {
										temp = v;
									}
								}
							}
							
							if(!estaVehiculo) {
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"No se encontro el vehiculo.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}else if(temp == null){
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"El vehiculo tiene dueño.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}
				}
				
				
				while(!estaPersona) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							temp.dueno = p;
							p.setVehiculo(contador, temp);
							comprador = p;
							estaPersona=true;
							contador++;
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
		
		btnComprarJet.setBounds(302, 27, 89, 23);
		panel.add(btnComprarJet);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/jet_1_chico.jpg")));
		lblNewLabel_5.setBounds(0, 0, 77, 77);
		panel.add(lblNewLabel_5);
		
		JButton btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana abrir = new Ventana();
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
		lblNewLabel_1_1.setBounds(106, 17, 89, 29);
		panel_1.add(lblNewLabel_1_1);
		
		JButton btnComprar747 = new JButton("Comprar");
		btnComprar747.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean estaPersona = false;
				boolean estaVehiculo = false;
				Persona comprador = null;
				
				Vehiculo temp = null;
				
				while(!estaVehiculo) {
					int idV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vehiculo")); 
							for(Vehiculo v: Main.listaVehiculos) {
								if(v.idVehiculo == idV) {
									estaVehiculo = true;
									if(v.dueno.idPersona == 0) {
										temp = v;
									}
								}
							}
							
							if(!estaVehiculo) {
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"No se encontro el vehiculo.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}else if(temp == null){
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"El vehiculo tiene dueño.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}
				}
				
				
				while(!estaPersona) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							temp.dueno = p;
							p.setVehiculo(contador, temp);
							comprador = p;
							estaPersona=true;
							contador++;
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
		btnComprar747.setBounds(301, 22, 89, 23);
		panel_1.add(btnComprar747);
		
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
		lblNewLabel_1_1_1.setBounds(103, 17, 141, 29);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		JButton btnComprarBarco_Naval = new JButton("Comprar");
		btnComprarBarco_Naval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean estaPersona = false;
				boolean estaVehiculo = false;
				Persona comprador = null;
				
				Vehiculo temp = null;
				
				while(!estaVehiculo) {
					int idV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vehiculo")); 
							for(Vehiculo v: Main.listaVehiculos) {
								if(v.idVehiculo == idV) {
									estaVehiculo = true;
									if(v.dueno.idPersona == 0) {
										temp = v;
									}
								}
							}
							
							if(!estaVehiculo) {
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"No se encontro el vehiculo.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}else if(temp == null){
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"El vehiculo tiene dueño.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}
				}
				
				
				while(!estaPersona) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							temp.dueno = p;
							p.setVehiculo(contador, temp);
							comprador = p;
							estaPersona=true;
							contador++;
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
		btnComprarBarco_Naval.setBounds(304, 22, 89, 23);
		panel_1_1.add(btnComprarBarco_Naval);
		
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
		lblNewLabel_1_1_1_1.setBounds(106, 17, 140, 29);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);
		
		JButton btnComprarBarco_Lancha = new JButton("Comprar");
		btnComprarBarco_Lancha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				boolean estaPersona = false;
				boolean estaVehiculo = false;
				Persona comprador = null;
				
				Vehiculo temp = null;
				
				while(!estaVehiculo) {
					int idV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del vehiculo")); 
							for(Vehiculo v: Main.listaVehiculos) {
								if(v.idVehiculo == idV) {
									estaVehiculo = true;
									if(v.dueno.idPersona == 0) {
										temp = v;
									}
								}
							}
							
							if(!estaVehiculo) {
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"No se encontro el vehiculo.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}else if(temp == null){
								Component Frame = null;
								JOptionPane.showMessageDialog(Frame,"El vehiculo tiene dueño.","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
							}
				}
				
				
				while(!estaPersona) {
					String respuesta = JOptionPane.showInputDialog("Ingrese su Id"); 
					int respuestaInt = Integer.parseInt(respuesta);
					for(Persona p: Main.listado){
						if(p.idPersona == respuestaInt) {
							temp.dueno = p;
							p.setVehiculo(contador, temp);
							comprador = p;
							estaPersona=true;
							contador++;
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
		btnComprarBarco_Lancha.setBounds(303, 22, 89, 23);
		panel_1_1_1.add(btnComprarBarco_Lancha);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ComprarVehiculo.class.getResource("/proyectogrupal/Imagen/lancha.png")));
		lblNewLabel.setBounds(0, 0, 80, 67);
		panel_1_1_1.add(lblNewLabel);
		
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
