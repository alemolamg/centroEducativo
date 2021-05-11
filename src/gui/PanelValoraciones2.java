package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.controllers.ControladorValMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;

public class PanelValoraciones2 extends JPanel {
	
	private ValoracionMateria valMateria;
	private Profesor actualProf;
	private Materia actualMat;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Materia> jcbMateria;
	private JScrollPane scrollPane;
	private PanelSelectorNotas actualPanel;
	private JComboBox<Integer> jcbNotas;
	private int actualNota;
	
	/**
	 * Create the panel.
	 */
	public PanelValoraciones2() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblMateria = new JLabel("Materia: ");
		lblMateria.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 0;
		add(lblMateria, gbc_lblMateria);
		
		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.gridwidth = 2;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		add(jcbMateria, gbc_jcbMateria);
		
		JLabel lblNewLabel_1 = new JLabel("  Profesor: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.gridwidth = 2;
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		add(jcbProfesor, gbc_jcbProfesor);
		
		JButton btnBuscarAlumnos = new JButton("Buscar Alumnos");
		btnBuscarAlumnos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPulsado();
				//cargarFichasAlumnos();
				cargarSelectorNotas();
			}
		});
		
		JLabel lblabelNota = new JLabel("Nota: ");
		lblabelNota.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblabelNota = new GridBagConstraints();
		gbc_lblabelNota.anchor = GridBagConstraints.EAST;
		gbc_lblabelNota.insets = new Insets(0, 0, 5, 5);
		gbc_lblabelNota.gridx = 0;
		gbc_lblabelNota.gridy = 2;
		add(lblabelNota, gbc_lblabelNota);
		
		jcbNotas = new JComboBox();
		GridBagConstraints gbc_jcbNotas = new GridBagConstraints();
		gbc_jcbNotas.gridwidth = 2;
		gbc_jcbNotas.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNotas.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNotas.gridx = 1;
		gbc_jcbNotas.gridy = 2;
		add(jcbNotas, gbc_jcbNotas);
		btnBuscarAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnBuscarAlumnos = new GridBagConstraints();
		gbc_btnBuscarAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscarAlumnos.gridx = 2;
		gbc_btnBuscarAlumnos.gridy = 3;
		add(btnBuscarAlumnos, gbc_btnBuscarAlumnos);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		add(scrollPane, gbc_scrollPane);
		
		JButton btnGuardarNotas = new JButton("Guardar Valoraciones");
		btnGuardarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonPulsado();
//				for(PanelFichaAlumno ficha : listaFichas) {
//					if(ControladorValMateria.getInstance().guardar(ficha.guardar()) ) {
//						JOptionPane.showMessageDialog(null, "Guardado Correctamente");
//					} else
//						JOptionPane.showMessageDialog(null, "Error al Guardar");
//				}
			}
		});
		btnGuardarNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnGuardarNotas = new GridBagConstraints();
		gbc_btnGuardarNotas.gridx = 2;
		gbc_btnGuardarNotas.gridy = 5;
		add(btnGuardarNotas, gbc_btnGuardarNotas);
		
		
		
		cargarListas();
	}
	
	private void cargarListas() {
		for(Materia mat : ControladorMateria.getInstance().findAll()) 
			this.jcbMateria.addItem(mat);
		
		for(Profesor pro : ControladorProfesor.getInstance().findAll())
			this.jcbProfesor.addItem(pro);
		
		this.crearNotasEnteras();
		
	}
	
	
	private void cargarSelectorNotas() {
		actualNota = (int) jcbNotas.getSelectedItem();
		actualMat = (Materia) jcbMateria.getSelectedItem();		//Guardo la materia con la que trabajo
		actualProf = (Profesor) jcbProfesor.getSelectedItem();	
		
		this.actualPanel = new PanelSelectorNotas(actualProf,actualMat,actualNota);
		
		this.scrollPane.setViewportView(actualPanel);
		scrollPane.revalidate();
		scrollPane.repaint();	
	}
	
	
	public static void botonPulsado() {
		System.out.println("Pulsado");
	}
	
	public void crearNotasEnteras() {
		int i = 0;
		List<Integer> listaEnteros = new ArrayList<Integer>();
		while (i <=10) {
			 this.jcbNotas.addItem(i++);
		}
	}
	
}
