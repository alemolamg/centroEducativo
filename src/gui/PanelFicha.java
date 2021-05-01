package gui;

import javax.swing.JPanel;

import model.controllers.ControladorValMateria;
import model.entities.Estudiante;
import model.entities.Materia;
import model.entities.Profesor;
import model.entities.ValoracionMateria;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.util.List;
import java.awt.Font;

public class PanelFicha extends JPanel {
	
	private Estudiante estudiante;
	private Profesor profesor;
	private Materia materia;
	private JTextField jtfValoracion;
	
	
	public PanelFicha(Estudiante est, Materia mat, Profesor pro) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel jlbNombre = new JLabel("Nombre");
		jlbNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jlbNombre = new GridBagConstraints();
		gbc_jlbNombre.insets = new Insets(0, 0, 0, 5);
		gbc_jlbNombre.anchor = GridBagConstraints.EAST;
		gbc_jlbNombre.gridx = 0;
		gbc_jlbNombre.gridy = 0;
		add(jlbNombre, gbc_jlbNombre);
		
		jtfValoracion = new JTextField();
		jtfValoracion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jtfValoracion = new GridBagConstraints();
		gbc_jtfValoracion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfValoracion.gridx = 1;
		gbc_jtfValoracion.gridy = 0;
		add(jtfValoracion, gbc_jtfValoracion);
		jtfValoracion.setColumns(10);

		
		this.materia = mat;
		this.profesor = pro;
		this.estudiante = est;	// Asigno el estudiante a la variable de la clase
		jlbNombre.setText(estudiante.toString());
		cargarNotas();
		
	}
	
	
	private boolean cargarNotas() {
		boolean cargado = false;
		for(ValoracionMateria valMatActual : ControladorValMateria.getInstance().findAll()) {
			if(valMatActual.getEstudiante().getId() == estudiante.getId() && valMatActual.getMateria().getId() == materia.getId()
					&& valMatActual.getProfesor().getId() == profesor.getId()) {
				if(valMatActual.getValoracion() != 0)
					this.jtfValoracion.setText(""+ valMatActual.getValoracion());
				else
					this.jtfValoracion.setText("");
				cargado = true;
			}			
		}
		return cargado;
	}
	
	
	public ValoracionMateria guardar() {
		ValoracionMateria valMateria = null;
		for(ValoracionMateria valMatActual : ControladorValMateria.getInstance().findAll())
			if(valMatActual.getEstudiante().getId() == estudiante.getId() && valMatActual.getMateria().getId() == materia.getId()
					&& valMatActual.getProfesor().getId() == profesor.getId()) {
//			valMateria = new ValoracionMateria(valMatActual.getId(),estudiante, materia, profesor, Float.parseFloat(jtfValoracion.getText()) );
				valMatActual.setValoracion(Float.parseFloat(jtfValoracion.getText()));
				valMateria = valMatActual;
		} else
			valMateria = new ValoracionMateria(0,estudiante, materia, profesor, Float.parseFloat(jtfValoracion.getText()) );
		return valMateria;
	}

}
