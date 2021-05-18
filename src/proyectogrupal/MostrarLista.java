package proyectogrupal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import main.Main;
import main.Persona;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;

public class MostrarLista extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JTextField textFiltro;
	DefaultTableModel dm;

	private void filtro(String consulta, JTable jTableBuscar) {
		dm = (DefaultTableModel) jTableBuscar.getModel();
		TableRowSorter<TableModel> tr = new TableRowSorter<>(dm);
		jTableBuscar.setRowSorter(tr);
		tr.setRowFilter(RowFilter.regexFilter(consulta));
		
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MostrarLista frame = new MostrarLista();
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
	
	public MostrarLista() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MostrarLista.class.getResource("/proyectogrupal/Imagen/logo.jpeg")));
		setTitle("Mostrar Listado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.setBounds(5, 233, 424, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana ventanaPrincipal = new ventana();
				dispose();
				ventanaPrincipal.setVisible(true);
			
				
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 424, 186);
		contentPane.add(scrollPane);
		
			
		
		table = new JTable();
		boolean bander = true;
							for(Persona persona: Main.listado) {
									if(bander) {
										table.setModel(new DefaultTableModel(
											new Object[][] {
												{persona.idPersona, persona.nombre.toUpperCase(), persona.apellido.toUpperCase(), persona.dptoResidencia.toUpperCase(), persona.getHijos(), persona.getDate()},
											},
											new String[] {
												"ID", "Nombre", "Apellido", "Ciudad", "Cant. Hijos", "Fech.Nacimiento"
											}
										) {
											/**
											 * 
											 */
											private static final long serialVersionUID = 1L;
											Class[] columnTypes = new Class[] {
												Integer.class, String.class, String.class, String.class, Byte.class, String.class
											};
											public Class getColumnClass(int columnIndex) {
												return columnTypes[columnIndex];
											}
										});
										bander=false;
									}else {
										DefaultTableModel model = (DefaultTableModel) table.getModel();
										model.addRow(new Object[]{persona.idPersona, persona.nombre.toUpperCase(), persona.apellido.toUpperCase(), persona.dptoResidencia.toUpperCase(), persona.getHijos(), persona.getDate()});
									}
							}
		scrollPane.setViewportView(table);
		lblNewLabel = new JLabel("Filtro");
		lblNewLabel.setBounds(10, 12, 46, 14);
		contentPane.add(lblNewLabel);
		
		textFiltro = new JTextField();
		textFiltro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				filtro(textFiltro.getText().toUpperCase(),table);
			}
		});
		textFiltro.setBounds(51, 5, 86, 20);
		contentPane.add(textFiltro);
		textFiltro.setColumns(10);
	}

}
