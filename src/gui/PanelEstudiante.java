package gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import model.controllers.ControladorEstudiante;
import model.controllers.ControladorProfesor;
import model.entities.Estudiante;
import model.entities.Tipologiasexo;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEstudiante extends JPanel {
	private PnlDatosPersonales pnlDatosP;
	private JToolBar barraHerramientas;
	private Estudiante actual = new Estudiante();	
	
	/**
	 * Create the panel.
	 */
	public PanelEstudiante() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		barraHerramientas = new JToolBar();
		barraHerramientas.setFloatable(false);
		GridBagConstraints gbc_barraHerramientas = new GridBagConstraints();
		gbc_barraHerramientas.insets = new Insets(0, 0, 5, 0);
		gbc_barraHerramientas.gridx = 0;
		gbc_barraHerramientas.gridy = 0;
		add(barraHerramientas, gbc_barraHerramientas);
		
		JButton btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findPrimero();
				cargarActualEnPantalla();
			}
		});
		btnPrimero.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findAnterior(actual.getId());
				cargarActualEnPantalla();
			}
		});
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnAnterior);
		
		JButton btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findSiguiente(actual.getId());
				cargarActualEnPantalla(); 
			}
		});
		btnSiguiente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actual = ControladorEstudiante.getInstance().findUltimo();
				cargarActualEnPantalla();
			}
		});
		btnUltimo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnUltimo);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vaciarCampos();
			}
		});
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnNuevo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnGuardar);
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrar();
			}
		});
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		barraHerramientas.add(btnBorrar);
		
		pnlDatosP = new PnlDatosPersonales();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 1;
		add(pnlDatosP, gbc_textField_1);
		
		
		cargarDatosSexo();
		this.actual = ControladorEstudiante.getInstance().findPrimero();
		cargarActualEnPantalla();

	}
	
	private void guardar() {
		cargarActualDesdePantalla();
		if (ControladorEstudiante.getInstance().guardar(actual))
			JOptionPane.showMessageDialog(null, "Guardado Correctamente");
		else
			JOptionPane.showMessageDialog(null, "Error al guardar");
		cargarActualEnPantalla();
	}
	

	private void cargarActualDesdePantalla() {
		actual.setId(Integer.parseInt(pnlDatosP.getId().getText()));
		actual.setNombre(this.pnlDatosP.getNombre().getText());
		actual.setApellido1(this.pnlDatosP.getApellido1().getText());
		actual.setApellido2(this.pnlDatosP.getApellido2().getText());
		actual.setDireccion(this.pnlDatosP.getDireccion().getText());
		actual.setDni(this.pnlDatosP.getJtfDNI().getText());
		actual.setEmail(this.pnlDatosP.getJtfDNI().getText());
		actual.setTelefono(this.pnlDatosP.getTelefono().getText());	
		actual.setTipologiasexo((Tipologiasexo)this.pnlDatosP.getJcbSexo().getSelectedItem());
	}

	private void cargarActualEnPantalla() {
		this.pnlDatosP.getId().setText(""+this.actual.getId());
		this.pnlDatosP.getNombre().setText(this.actual.getNombre());
		this.pnlDatosP.getApellido1().setText(this.actual.getApellido1());
		this.pnlDatosP.getApellido2().setText(this.actual.getApellido2());
		this.pnlDatosP.getJtfDNI().setText(this.actual.getDni());
		this.pnlDatosP.getDireccion().setText(this.actual.getDireccion());
		this.pnlDatosP.getEmail().setText(this.actual.getEmail());
		this.pnlDatosP.getTelefono().setText(this.actual.getTelefono());
		
		// Cargar el sexo
		for (int i = 1; i <= this.pnlDatosP.getJcbSexo().getItemCount(); i++)
			if (this.actual.getTipologiasexo().getId() == this.pnlDatosP.getJcbSexo().getItemAt(i).getId())
				this.pnlDatosP.getJcbSexo().setSelectedIndex(i);
		
	}
	
	private void vaciarCampos() {
		this.pnlDatosP.getId().setText("0");
		this.pnlDatosP.getNombre().setText("");
		this.pnlDatosP.getApellido1().setText("");
		this.pnlDatosP.getApellido2().setText("");
		this.pnlDatosP.getJtfDNI().setText("");
		this.pnlDatosP.getDireccion().setText("");
		this.pnlDatosP.getEmail().setText("");
		this.pnlDatosP.getTelefono().setText("");
	}
	
	public void borrar() {
		if(ControladorEstudiante.getInstance().borrar(actual))
			JOptionPane.showMessageDialog(null, "Borrado Correctamente");
		else
			JOptionPane.showMessageDialog(null, "Error al borrar");
	}
	
	private void cargarDatosSexo() {		
		for (Tipologiasexo sex : ControladorEstudiante.getInstance().findAllSexo()) {
			this.pnlDatosP.getJcbSexo().addItem(sex);
		}
	}

}
