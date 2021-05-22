package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import main.Persona;
import main.Vehiculo;

import javax.swing.JTabbedPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.JInternalFrame;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class PanelDeControl extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDeControl frame = new PanelDeControl();
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
	public PanelDeControl() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana nuevaVent = new Ventana();
				nuevaVent.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(20, 329, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Informaci\u00F3n general");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(128, 11, 304, 94);
		contentPane.add(lblNewLabel_2);
		
		JProgressBar progressBar_Mont = new JProgressBar();
		progressBar_Mont.setForeground(new Color(0, 100, 0));
		progressBar_Mont.setToolTipText("Montevideo");
		progressBar_Mont.setStringPainted(true);
		progressBar_Mont.setValue(0);
		progressBar_Mont.setBounds(143, 303, 174, 14);
		contentPane.add(progressBar_Mont);
		
		JProgressBar progressBar_SJ = new JProgressBar();
		progressBar_SJ.setForeground(new Color(0, 0, 128));
		progressBar_SJ.setToolTipText("San Jos\u00E9");
		progressBar_SJ.setStringPainted(true);
		progressBar_SJ.setValue(0);
		progressBar_SJ.setBounds(143, 253, 174, 14);
		contentPane.add(progressBar_SJ);
		
		JProgressBar progressBar_Can = new JProgressBar();
		progressBar_Can.setForeground(new Color(0, 0, 205));
		progressBar_Can.setToolTipText("Canelones");
		progressBar_Can.setStringPainted(true);
		progressBar_Can.setValue(0);
		progressBar_Can.setBounds(143, 278, 174, 14);
		contentPane.add(progressBar_Can);
		
		JLabel lblNewLabel = new JLabel("Personas ingresadas:");
		lblNewLabel.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel.setBounds(125, 147, 125, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Veh\u00EDculos por persona(Prom):");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(125, 172, 192, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPromedioAutos = new JLabel("");
		lblPromedioAutos.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblPromedioAutos.setBounds(336, 180, 96, 14);
		contentPane.add(lblPromedioAutos);
		
		JLabel lblCantPersonas = new JLabel("");
		lblCantPersonas.setFont(new Font("Montserrat", Font.PLAIN, 11));
		lblCantPersonas.setBounds(255, 147, 46, 14);
		contentPane.add(lblCantPersonas);
		
		/*..............................................
		 * Logica para la muestra de datos
		 * ...............................................
		 */
		try {
				int cantPersonas=0;// <-------- CANT. PERSONAS EN LA LISTA
				int cantAutosCan=0; //<--------AUTOS DE CANELONES
				int cantAutosMon=0;//<--------AUTOS DE MONTEVIDEO
				int cantAutosSJ=0;
				for(Persona p: Main.listado) {
					cantPersonas++;
					String residencia =p.dptoResidencia;
					switch(residencia){
						case "Canelones":
							if(p.getListaVehiculos().size() != 0) {
								cantAutosCan += p.getListaVehiculos().size();
							}
							break;
						case "Montevideo":
							if(p.getListaVehiculos().size() != 0) {
								cantAutosMon += p.getListaVehiculos().size();
							}
							break;
						case "San José":
							if(p.getListaVehiculos().size() != 0) {
								cantAutosSJ += p.getListaVehiculos().size();
							}
							break;
					}
				}
				lblCantPersonas.setText(String.valueOf(cantPersonas));
				int cantVehiculosTotales= cantAutosCan + cantAutosMon + cantAutosSJ;
				double promedio = cantVehiculosTotales / cantPersonas;
				lblPromedioAutos.setText(String.valueOf(promedio)); 
				
				calcularPorc(cantAutosCan, cantVehiculosTotales,progressBar_Can);
				
				calcularPorc(cantAutosMon, cantVehiculosTotales,progressBar_Mont);
				
				calcularPorc(cantAutosSJ, cantVehiculosTotales,progressBar_SJ);
		}catch(ArithmeticException e) {
			Component Frame = null;
			JOptionPane.showMessageDialog(Frame,"Aun no hay vehiculos ingresados. Por favor ingrese un vehiculo desde la opción Comprar","Ventana de notificación", JOptionPane.ERROR_MESSAGE);
		}
	}
	/**
	 * 
	 * @param cantAutosDep: Recibe cantidad de autos que se encontraron por departamento.
	 * @param cantTotal: Recibe el largo de la lista que se esta recorriendo.
	 * @param barra: Nombre de la barra en la que se incerta el valor.
	 */
	public void calcularPorc(int cantAutosDep, int cantTotal,JProgressBar barra) {
		barra.setValue((cantAutosDep * 100) / cantTotal); 
	}
}
