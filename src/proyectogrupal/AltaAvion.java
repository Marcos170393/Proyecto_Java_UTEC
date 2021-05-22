package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Avion;
import main.Main;
import main.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AltaAvion extends JFrame {

	private JPanel contentPane;
	private JTextField textLong;
	private JTextField textPasajeros;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaAvion frame = new AltaAvion();
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
	public AltaAvion() {
		setTitle("Alta de Aviones");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaAvion.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Avion");
		lblNewLabel.setBounds(27, 55, 88, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_Tipo = new JComboBox();
		comboBox_Tipo.setModel(new DefaultComboBoxModel(new String[] {"747", "Jet AirCraft", "Avion Privado"}));
		comboBox_Tipo.setBounds(125, 51, 88, 22);
		contentPane.add(comboBox_Tipo);
		
		JLabel lblNewLabel_1 = new JLabel("Longitud");
		lblNewLabel_1.setBounds(27, 96, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		textLong = new JTextField();
		textLong.setBounds(125, 93, 88, 20);
		contentPane.add(textLong);
		textLong.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setBounds(27, 139, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_Colores = new JComboBox();
		comboBox_Colores.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Azul", "Violeta", "Amarillo", "Rosado", "Verde"}));
		comboBox_Colores.setBounds(125, 135, 88, 22);
		contentPane.add(comboBox_Colores);
		
		JLabel lblNewLabel_3 = new JLabel("Pasajeros");
		lblNewLabel_3.setBounds(238, 55, 73, 14);
		contentPane.add(lblNewLabel_3);
		
		textPasajeros = new JTextField();
		textPasajeros.setToolTipText("Ingrese la cantidad");
		textPasajeros.setBounds(321, 52, 86, 20);
		contentPane.add(textPasajeros);
		textPasajeros.setColumns(10);
		
		JButton btnAlta = new JButton("Dar de alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
				Main.idIncremental++;
				double longParam = Double.parseDouble(textLong.getText()); 
				int cantPasaj = Integer.parseInt(textPasajeros.getText()); 
				String tipo = String.valueOf(comboBox_Tipo.getSelectedItem());
				String color = String.valueOf(comboBox_Colores.getSelectedItem());
				
				Vehiculo nuevo = new Avion(Main.idIncremental,tipo,color,longParam,cantPasaj);
				Main.listaVehiculos.add(nuevo);
				
				JOptionPane.showMessageDialog(null,"El "+ tipo +" fue dado de alta correctamente","Ventana de confirmación", JOptionPane.INFORMATION_MESSAGE);
				textLong.setText(null);
				textPasajeros.setText(null);
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"Error en " + e2.getLocalizedMessage().substring(17) + ". Se debe ingresar números.", "Error en datos ingresados", JOptionPane.ERROR_MESSAGE);
					textLong.setText(null);
					textPasajeros.setText(null);
				}
				
			}
		});
		btnAlta.setBounds(256, 227, 140, 23);
		contentPane.add(btnAlta);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana nuevaVentana = new Ventana();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(27, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
