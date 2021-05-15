package gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorValMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelSelectorNotas extends JPanel {

	private Profesor profesor;
	private Materia materia;
	private List<Estudiante> listaEst;
	private int nota;
	private JList jListSelect;
	private JList jListNoSelect;
	private DefaultListModel<Estudiante> dlmSelect;
	private DefaultListModel<Estudiante> dlmNoSelect;
	private JScrollPane spSeleccionados;
	private JScrollPane spNoSelect;
	
	
	/**
	 * Create the panel.
	 */
	public PanelSelectorNotas(Profesor pro, Materia mat, int notaS) {
		setBackground(new Color(240, 230, 140));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("alumnado no seleccionado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("alumnado seleccionado: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JPanel panelNoSelect = new JPanel();
		panelNoSelect.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelNoSelect = new GridBagConstraints();
		gbc_panelNoSelect.insets = new Insets(0, 0, 0, 5);
		gbc_panelNoSelect.fill = GridBagConstraints.BOTH;
		gbc_panelNoSelect.gridx = 0;
		gbc_panelNoSelect.gridy = 1;
		add(panelNoSelect, gbc_panelNoSelect);
		GridBagLayout gbl_panelNoSelect = new GridBagLayout();
		gbl_panelNoSelect.columnWidths = new int[]{93, 2, 0};
		gbl_panelNoSelect.rowHeights = new int[]{2, 0};
		gbl_panelNoSelect.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panelNoSelect.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelNoSelect.setLayout(gbl_panelNoSelect);
		
		spNoSelect = new JScrollPane();
		GridBagConstraints gbc_spNoSelect = new GridBagConstraints();
		gbc_spNoSelect.gridwidth = 2;
		gbc_spNoSelect.insets = new Insets(0, 0, 0, 5);
		gbc_spNoSelect.fill = GridBagConstraints.BOTH;
		gbc_spNoSelect.gridx = 0;
		gbc_spNoSelect.gridy = 0;
		panelNoSelect.add(spNoSelect, gbc_spNoSelect);
		
		jListNoSelect = new JList();
		spNoSelect.setViewportView(jListNoSelect);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(Color.PINK);
		GridBagConstraints gbc_panelBotones = new GridBagConstraints();
		gbc_panelBotones.insets = new Insets(0, 0, 0, 5);
		gbc_panelBotones.fill = GridBagConstraints.BOTH;
		gbc_panelBotones.gridx = 1;
		gbc_panelBotones.gridy = 1;
		add(panelBotones, gbc_panelBotones);
		GridBagLayout gbl_panelBotones = new GridBagLayout();
		gbl_panelBotones.columnWidths = new int[]{0, 0};
		gbl_panelBotones.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelBotones.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelBotones.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelBotones.setLayout(gbl_panelBotones);
		
		JButton btnTodosIzq = new JButton("<<");
		btnTodosIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarTodos();
			}
		});
		btnTodosIzq.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnTodosIzq = new GridBagConstraints();
		gbc_btnTodosIzq.insets = new Insets(5, 5, 5, 0);
		gbc_btnTodosIzq.gridx = 0;
		gbc_btnTodosIzq.gridy = 1;
		panelBotones.add(btnTodosIzq, gbc_btnTodosIzq);
		
		JButton btnIzq = new JButton(" <");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				quitarNotaSeleccionados();
			}
		});
		btnIzq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnIzq = new GridBagConstraints();
		gbc_btnIzq.insets = new Insets(0, 5, 5, 0);
		gbc_btnIzq.gridx = 0;
		gbc_btnIzq.gridy = 3;
		panelBotones.add(btnIzq, gbc_btnIzq);
		
		JButton btnDer = new JButton(" >");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirNotaSeleccionados();
			}
		});
		btnDer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnDer = new GridBagConstraints();
		gbc_btnDer.insets = new Insets(0, 5, 5, 0);
		gbc_btnDer.gridx = 0;
		gbc_btnDer.gridy = 5;
		panelBotones.add(btnDer, gbc_btnDer);
		
		JButton btnTodosDer = new JButton(">>");
		btnTodosDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aniadirTodos();
			}
		});
		btnTodosDer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnTodosDer = new GridBagConstraints();
		gbc_btnTodosDer.insets = new Insets(0, 5, 5, 0);
		gbc_btnTodosDer.gridx = 0;
		gbc_btnTodosDer.gridy = 7;
		panelBotones.add(btnTodosDer, gbc_btnTodosDer);
		
		JPanel panelSelect = new JPanel();
		panelSelect.setBackground(Color.WHITE);
		GridBagConstraints gbc_panelSelect = new GridBagConstraints();
		gbc_panelSelect.fill = GridBagConstraints.BOTH;
		gbc_panelSelect.gridx = 2;
		gbc_panelSelect.gridy = 1;
		add(panelSelect, gbc_panelSelect);
		GridBagLayout gbl_panelSelect = new GridBagLayout();
		gbl_panelSelect.columnWidths = new int[]{0, 0};
		gbl_panelSelect.rowHeights = new int[]{0, 0};
		gbl_panelSelect.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelSelect.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelSelect.setLayout(gbl_panelSelect);
		
		spSeleccionados = new JScrollPane();
		GridBagConstraints gbc_spSeleccionados = new GridBagConstraints();
		gbc_spSeleccionados.fill = GridBagConstraints.BOTH;
		gbc_spSeleccionados.gridx = 0;
		gbc_spSeleccionados.gridy = 0;
		panelSelect.add(spSeleccionados, gbc_spSeleccionados);
		
		jListSelect = new JList();
		spSeleccionados.setViewportView(jListSelect);
		
		
		
		this.profesor = pro;
		this.materia = mat;
		this.listaEst = ControladorEstudiante.getInstance().findAll();
		this.nota = notaS;
		
		colocarAlumnos();
	}
	
	
	/**
	 * Carga todos los alumnos en los JScrollPane para poder seleccionarlos. 
	 */
	private void colocarAlumnos() {
		dlmSelect = new DefaultListModel<Estudiante>();
		dlmNoSelect = new DefaultListModel<Estudiante>();
		
		for(Estudiante est : listaEst)
			if(ControladorValMateria.getInstance().buscarPorAlumno(profesor, est, materia, nota))
				dlmSelect.addElement(est);
			else
				dlmNoSelect.addElement(est);
		
		jListSelect = new JList(dlmSelect);
		jListNoSelect = new JList(dlmNoSelect);
		spSeleccionados.setViewportView(jListSelect);
		spNoSelect.setViewportView(jListNoSelect);
	}

	
	private void aniadirNotaSeleccionados() {
		if(!jListNoSelect.isSelectionEmpty()) {
			
			for(int i = 0; i < jListNoSelect.getSelectedIndices().length; i++) {
				dlmSelect.addElement(dlmNoSelect.getElementAt(jListNoSelect.getSelectedIndices()[i]));
			}
			
			for(int i = this.jListNoSelect.getSelectedIndices().length - 1; i >= 0; i--) {
				dlmNoSelect.removeElementAt(jListNoSelect.getSelectedIndices()[i]);
			}			
		} 				
	}
	
	private void quitarNotaSeleccionados() { 	//TODO: no terminado, TERMINAR
		if(!jListSelect.isSelectionEmpty()) {
			
			for(int i = 0; i < jListSelect.getSelectedIndices().length; i++)
				dlmNoSelect.addElement(dlmSelect.getElementAt(jListSelect.getSelectedIndices()[i]));
			
			
			for(int i = this.jListSelect.getSelectedIndices().length - 1; i >= 0; i--)
				dlmSelect.removeElementAt(jListSelect.getSelectedIndices()[i]);
						
		} 
		
	}
	
	private void aniadirTodos() {
		  for (int i = 0; i < this.dlmNoSelect.size(); i++) { 
			  this.dlmSelect.addElement(this.dlmNoSelect.elementAt(i)); 
			  }         //Una vez pasados todos a una JList hay que vaciar la otra   
		  this.dlmNoSelect.clear();
	}
	
	
	private void quitarTodos() {
		  for (int i = 0; i < this.dlmSelect.size(); i++) { 
			  this.dlmNoSelect.addElement(this.dlmSelect.elementAt(i)); 
			  }         //Una vez pasados todos a una JList hay que vaciar la otra   
		  this.dlmSelect.clear();
	}
	
	public boolean guardarDatos() {	
		boolean guardado = true;
		ValoracionMateria valMateria = null;
		for(ValoracionMateria valMatActual : ControladorValMateria.getInstance().findAll()) {
			for(int i = 0; i < dlmSelect.size();i++) {
				Estudiante est = dlmSelect.elementAt(i);
				if(valMatActual.getEstudiante().getId() == est.getId() && valMatActual.getMateria().getId() == materia.getId()
						&& valMatActual.getProfesor().getId() == profesor.getId()) {
					valMatActual.setValoracion(this.nota);
					valMateria = valMatActual;
					break;
				} else
					valMateria = new ValoracionMateria(0,est, materia, profesor, this.nota);
			}
			if(!ControladorValMateria.getInstance().guardar(valMatActual))
				guardado = false;
		}
		guardarNoPresentados();
		return guardado;
	}
	
	
	private void guardarNoPresentados() {
		ValoracionMateria valMateria = null;
		for(ValoracionMateria valMatActual : ControladorValMateria.getInstance().findAll()) {
			for(int i = 0; i < dlmNoSelect.size();i++) {
				Estudiante est = dlmNoSelect.elementAt(i);
				if(valMatActual.getEstudiante().getId() == est.getId() && valMatActual.getMateria().getId() == materia.getId()
						&& valMatActual.getProfesor().getId() == profesor.getId()) {
					valMatActual.setValoracion(-1);
					valMateria = valMatActual;
					break;
				} 
			}
			ControladorValMateria.getInstance().guardar(valMatActual);
		}
	}
		
	
}
