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

public class PanelSelectorNotas extends JPanel {

	private Profesor profesor;
	private Materia materia;
	private List<Estudiante> listaEst;
	private int nota;
	
	
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
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panelNoSelect.add(scrollPane, gbc_scrollPane);
		
		JList listNoSelect = new JList();
		scrollPane.setViewportView(listNoSelect);
		
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
		btnTodosIzq.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnTodosIzq = new GridBagConstraints();
		gbc_btnTodosIzq.insets = new Insets(5, 5, 5, 0);
		gbc_btnTodosIzq.gridx = 0;
		gbc_btnTodosIzq.gridy = 1;
		panelBotones.add(btnTodosIzq, gbc_btnTodosIzq);
		
		JButton btnIzq = new JButton(" <");
		btnIzq.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnIzq = new GridBagConstraints();
		gbc_btnIzq.insets = new Insets(0, 5, 5, 0);
		gbc_btnIzq.gridx = 0;
		gbc_btnIzq.gridy = 3;
		panelBotones.add(btnIzq, gbc_btnIzq);
		
		JButton btnDer = new JButton(" >");
		btnDer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_btnDer = new GridBagConstraints();
		gbc_btnDer.insets = new Insets(0, 5, 5, 0);
		gbc_btnDer.gridx = 0;
		gbc_btnDer.gridy = 5;
		panelBotones.add(btnDer, gbc_btnDer);
		
		JButton btnTodosDer = new JButton(">>");
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 0;
		panelSelect.add(scrollPane_1, gbc_scrollPane_1);
		
		JList listSelect = new JList();
		scrollPane_1.setViewportView(listSelect);
		
		
		this.profesor = pro;
		this.materia = mat;
		this.listaEst = ControladorEstudiante.getInstance().findAll();
		this.nota = notaS;
		
		colocarAlumnos();
	}
	
	private void colocarAlumnos() {
		DefaultListModel<Estudiante> dlmSelect = new DefaultListModel<Estudiante>();
		DefaultListModel<Estudiante> dlmNoSelect = new DefaultListModel<Estudiante>();
		
		for(Estudiante est : listaEst)
			if(ControladorValMateria.getInstance().buscarPorAlumno(profesor, est, materia, nota))
				dlmSelect.addElement(est);
			else
				dlmNoSelect.addElement(est);
		
	}

}
