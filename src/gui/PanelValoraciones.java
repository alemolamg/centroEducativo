package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorMateria;
import model.controllers.ControladorProfesor;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelValoraciones extends JPanel {
	
	private ValoracionMateria valMateria;
	private Profesor actualProf;
	private Materia actualMat;
	private JComboBox<Profesor> jcbProfesor;
	private JComboBox<Materia> jcbMateria;
	private JPanel jpnlParaFichas;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public PanelValoraciones() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
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
		
		JLabel lblNewLabel_1 = new JLabel("Profesor: ");
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
				cargarFichasAlumnos();
			}
		});
		btnBuscarAlumnos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnBuscarAlumnos = new GridBagConstraints();
		gbc_btnBuscarAlumnos.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuscarAlumnos.gridx = 2;
		gbc_btnBuscarAlumnos.gridy = 2;
		add(btnBuscarAlumnos, gbc_btnBuscarAlumnos);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 3;
		add(scrollPane, gbc_scrollPane);
		
		jpnlParaFichas = new JPanel();
		scrollPane.setViewportView(jpnlParaFichas);
		
		JButton btnGuardarNotas = new JButton("Guardar Valoraciones");
		btnGuardarNotas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnGuardarNotas = new GridBagConstraints();
		gbc_btnGuardarNotas.gridx = 2;
		gbc_btnGuardarNotas.gridy = 4;
		add(btnGuardarNotas, gbc_btnGuardarNotas);
		
		
		
		cargarListas();

	}
	
	private void cargarListas() {
		for(Materia mat : ControladorMateria.getInstance().findAll()) {
			this.jcbMateria.addItem(mat);
		}
		for(Profesor pro : ControladorProfesor.getInstance().findAll())
			this.jcbProfesor.addItem(pro);
	}
	
		
	private void cargarFichasAlumnos() {
		actualMat = (Materia) jcbMateria.getSelectedItem();		//Guardo la materia con la que trabajo
		actualProf = (Profesor) jcbProfesor.getSelectedItem();	// Guardo el profesor con el que trabajo
		
		// Hay que crear el panel aquí y cambiar el GBC la coordenada Y para cada ficha de Estudiante.
		for(Estudiante est : ControladorEstudiante.getInstance().findAll()) {
			this.jpnlParaFichas.add(new PanelFicha(est));
		}
		
		this.scrollPane.setViewportView(jpnlParaFichas);
		scrollPane.revalidate();
		scrollPane.repaint();
		
		
	}
	
	
}
