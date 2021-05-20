package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import main.Main;
import main.Persona;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AltaPersona extends JFrame {

	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDia;
	private JTextField textId;
	private JTextField textDpto;
	private JTextField textHijos;
	private JTextField textMes;
	private JTextField textAnio;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPersona frame = new AltaPersona();
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
	public AltaPersona() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AltaPersona.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setTitle("Alta Persona");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(34, 90, 46, 14);
		contentPane.add(lblNewLabel);
		
		textNombre = new JTextField();
		textNombre.setBounds(174, 84, 86, 20);
		contentPane.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(34, 121, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textApellido = new JTextField();
		textApellido.setBounds(174, 115, 86, 20);
		contentPane.add(textApellido);
		textApellido.setColumns(10);
		
		textDia = new JTextField();
		textDia.setColumns(10);
		textDia.setBounds(174, 150, 46, 20);
		contentPane.add(textDia);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_1_1.setBounds(34, 156, 107, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textId = new JTextField();
		textId.setBounds(174, 48, 86, 20);
		contentPane.add(textId);
		textId.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID ");
		lblNewLabel_2.setBounds(34, 51, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textDpto = new JTextField();
		textDpto.setBounds(174, 192, 86, 20);
		contentPane.add(textDpto);
		textDpto.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Departamento");
		lblNewLabel_3.setBounds(34, 198, 107, 14);
		contentPane.add(lblNewLabel_3);
		
		textHijos = new JTextField();
		textHijos.setBounds(174, 235, 86, 20);
		contentPane.add(textHijos);
		textHijos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cantidad de hijos");
		lblNewLabel_4.setBounds(34, 241, 107, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int bandera = 0;
				if(bandera == 0) {
					try {
						String idS = textId.getText();
						int idI = Integer.parseInt(idS); //for input string
						String nombre = textNombre.getText();
						String apellido = textApellido.getText();
						String dpto = textDpto.getText();
						byte hijos =Byte.parseByte(textHijos.getText()); 
						int dia = Integer.parseInt(textDia.getText());
						int mes = Integer.parseInt(textMes.getText());
						int anio = Integer.parseInt(textAnio.getText());
						Persona persona = new Persona(idI,nombre,apellido,dpto,hijos,LocalDate.of(anio, mes, dia));
						Main.ingresar(persona);
						bandera=1;
						
					}catch(NumberFormatException a){
						JOptionPane.showMessageDialog(null,"Error en " + a.getLocalizedMessage().substring(17) + ". Se debe ingresar números.", "Error en datos ingresados", JOptionPane.ERROR_MESSAGE);
						textId.setText(null);
						textHijos.setText(null);
						textDia.setText(null);
						textMes.setText(null);
						textAnio.setText(null);
						bandera=2;
					}
				}
				if(bandera==1) {
					textId.setText(null);
					textNombre.setText(null);
					textApellido.setText(null);
					textDpto.setText(null);
					textHijos.setText(null);
					textDia.setText(null);
					textMes.setText(null);
					textAnio.setText(null);
					Component Frame = null;
					JOptionPane.showMessageDialog(Frame,"La persona fue ingresada correctamente","Ventana de confirmación", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnNewButton.setBounds(171, 329, 89, 23);
		contentPane.add(btnNewButton);
		
		textMes = new JTextField();
		textMes.setBounds(256, 150, 46, 20);
		contentPane.add(textMes);
		textMes.setColumns(10);
		
		textAnio = new JTextField();
		textAnio.setBounds(351, 150, 46, 20);
		contentPane.add(textAnio);
		textAnio.setColumns(10);
		
		lblNewLabel_5 = new JLabel("d\u00EDa");
		lblNewLabel_5.setBounds(151, 153, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("mes");
		lblNewLabel_6.setBounds(230, 153, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("a\u00F1o");
		lblNewLabel_7.setBounds(312, 153, 46, 14);
		contentPane.add(lblNewLabel_7);
		
		btnNewButton_1 = new JButton("Volver");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Ventana volverVentana = new Ventana();
				volverVentana.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(23, 378, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}
