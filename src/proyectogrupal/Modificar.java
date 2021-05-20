package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;

import main.Main;
import main.Persona;

import javax.swing.event.ChangeEvent;
import java.awt.Toolkit;

public class Modificar extends JFrame {

	private JPanel contentPane;
	private JTextField textPersona;
	private JTextField textHijos;
	private JTextField textDia;
	private JTextField textNombre;
	private JTextField textDpto;
	private JTextField textApellido;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField textMes;
	private JTextField textAnio;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Modificar frame = new Modificar();
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
	public Modificar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modificar.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setTitle("Modificar Datos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPersona = new JTextField();
		textPersona.setBounds(171, 21, 86, 20);
		contentPane.add(textPersona);
		textPersona.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingresar ID de la persona");
		lblNewLabel.setBounds(33, 24, 128, 14);
		contentPane.add(lblNewLabel);
		
		textHijos = new JTextField();
		textHijos.setEnabled(false);
		textHijos.setBounds(283, 125, 86, 20);
		contentPane.add(textHijos);
		textHijos.setColumns(10);
		
		textDia = new JTextField();
		textDia.setEnabled(false);
		textDia.setBounds(121, 173, 24, 20);
		contentPane.add(textDia);
		textDia.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setEnabled(false);
		textNombre.setBounds(96, 83, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		textDpto = new JTextField();
		textDpto.setEnabled(false);
		textDpto.setBounds(283, 80, 86, 20);
		contentPane.add(textDpto);
		textDpto.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setEnabled(false);
		textApellido.setBounds(96, 125, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(40, 89, 46, 14);
		contentPane.add(lblNombre);
		
		lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(40, 131, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Dpto");
		lblNewLabel_3.setBounds(217, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Cant. Hijos");
		lblNewLabel_4.setBounds(211, 131, 62, 14);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Fech. Nac.");
		lblNewLabel_5.setBounds(40, 176, 71, 14);
		contentPane.add(lblNewLabel_5);
		
		btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				int id =Integer.parseInt(textPersona.getText());
				for(Persona persona: Main.listado) {
						if(persona.idPersona == id) {
							textNombre.setEnabled(true);
							textApellido.setEnabled(true);
							textDpto.setEnabled(true);
							textHijos.setEnabled(true);
							textDia.setEnabled(true);
							textMes.setEnabled(true);
							textAnio.setEnabled(true);
							textNombre.setText(persona.nombre);
							textApellido.setText(persona.apellido);
							textDpto.setText(persona.dptoResidencia);
							String hijosCast = String.valueOf(persona.getHijos());
							textHijos.setText(hijosCast);
							String dia = String.valueOf(persona.getDate().getDayOfMonth()) ;
							String mes = String.valueOf(persona.getDate().getMonthValue()) ;
							String anio = String.valueOf(persona.getDate().getYear()) ;
							textDia.setText(dia);
							textMes.setText(mes);
							textAnio.setText(anio);
						}
				}
			}
		});
		btnNewButton.setBounds(283, 20, 89, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana volverVentana = new Ventana();
				volverVentana.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		textMes = new JTextField();
		textMes.setEnabled(false);
		textMes.setBounds(158, 173, 24, 20);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		textAnio = new JTextField();
		textAnio.setEnabled(false);
		textAnio.setBounds(192, 173, 48, 20);
		contentPane.add(textAnio);
		textAnio.setColumns(10);
		
		btnNewButton_2 = new JButton("Actualizar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bandera = 0;
				if(bandera == 0) {
				try {
				int id =Integer.parseInt(textPersona.getText());
				byte hijos = Byte.parseByte(textHijos.getText());
				for(Persona persona: Main.listado) {
					
						if(persona.idPersona == id) {
							persona.nombre = textNombre.getText();
							persona.apellido = textApellido.getText();
							persona.dptoResidencia = textDpto.getText();
							persona.setCantHijos(hijos);
							persona.setFechaNacimiento( LocalDate.of( Integer.parseInt(textAnio.getText()),
																			Integer.parseInt(textMes.getText()) ,
																			Integer.parseInt(textDia.getText())));
								bandera=1;								
						}
					
				}
				}catch(NumberFormatException a){
					JOptionPane.showMessageDialog(null,"Error en " + a.getLocalizedMessage().substring(17) + ". Se debe ingresar números.", "Error en datos ingresados", JOptionPane.ERROR_MESSAGE);
				}
				}
				if(bandera==1) {
					
					textNombre.setText(null);
					textApellido.setText(null);
					textDpto.setText(null);
					textHijos.setText(null);
					textDia.setText(null);
					textMes.setText(null);
					textAnio.setText(null);
					Component Frame = null;
					JOptionPane.showMessageDialog(Frame,"La información fue modificada correctamente","Ventana de confirmación", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton_2.setBounds(317, 227, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
