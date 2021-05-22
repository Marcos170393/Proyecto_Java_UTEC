package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Barco;
import main.Main;
import main.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AltaBarco extends JFrame {

	private JPanel contentPane;
	private JTextField textManga;
	private JTextField textEslora;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaBarco frame = new AltaBarco();
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
	public AltaBarco() {
		setTitle("Alta de Barcos");
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaBarco.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo de Barco");
		lblNewLabel.setBounds(27, 36, 88, 14);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox_Tipo = new JComboBox();
		comboBox_Tipo.setModel(new DefaultComboBoxModel(new String[] {"Barco Naval", "Lancha a motor"}));
		comboBox_Tipo.setBounds(125, 32, 88, 22);
		contentPane.add(comboBox_Tipo);
		
		textManga = new JTextField();
		textManga.setToolTipText("Ingrese la cantidad");
		textManga.setColumns(10);
		textManga.setBounds(321, 33, 86, 20);
		contentPane.add(textManga);
		
		textEslora = new JTextField();
		textEslora.setColumns(10);
		textEslora.setBounds(125, 74, 88, 20);
		contentPane.add(textEslora);
		
		JLabel lblNewLabel_1 = new JLabel("Eslora");
		lblNewLabel_1.setBounds(27, 77, 88, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setBounds(27, 120, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox_Colores = new JComboBox();
		comboBox_Colores.setModel(new DefaultComboBoxModel(new String[] {"Blanco", "Negro", "Azul", "Gris", "Verde", "Naranja"}));
		comboBox_Colores.setBounds(125, 116, 88, 22);
		contentPane.add(comboBox_Colores);
		
		JButton btnAlta = new JButton("Dar de alta");
		btnAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Main.idIncremental++;
					String color = String.valueOf(comboBox_Colores.getSelectedItem());
					String tipo = String.valueOf(comboBox_Tipo.getSelectedItem());
					int eslora = Integer.parseInt(textEslora.getText());
					int manga = Integer.parseInt(textManga.getText());
					Vehiculo nuevo = new Barco(Main.idIncremental,tipo,color,eslora,manga);
					Main.listaVehiculos.add(nuevo);
					
					JOptionPane.showMessageDialog(null,"El "+ tipo +" fue dado de alta correctamente","Ventana de confirmación", JOptionPane.INFORMATION_MESSAGE);
					textEslora.setText(null);
					textManga.setText(null);
				}catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"Error en " + e2.getLocalizedMessage().substring(17) + ". Se debe ingresar números.", "Error en datos ingresados", JOptionPane.ERROR_MESSAGE);
					textEslora.setText(null);
					textManga.setText(null);
				}
			}
		});
		btnAlta.setBounds(256, 208, 140, 23);
		contentPane.add(btnAlta);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(27, 208, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana nuevaVentana = new Ventana();
				nuevaVentana.setVisible(true);
				dispose();
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("Manga");
		lblNewLabel_3.setBounds(256, 36, 46, 14);
		contentPane.add(lblNewLabel_3);
	}

}
