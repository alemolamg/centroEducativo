package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class Principal extends JFrame {
	
	private JTabbedPane jTabbedPane = null;
	private static Principal instance = null;

	public static Principal getInstance() {
		if (instance == null)
			instance = new Principal();
		return instance;
	}
	
	public Principal() {
		super("Gestión de ventana de fabricantes");
		this.setBounds(0,0,550,388);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
//		this.setJMenuBar(new MenuBar());
		
		this.setLayout(new BorderLayout());
		this.add(getPanelPrincipal(), BorderLayout.CENTER);
		
		this.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
			}
		});
	}
	
	public JTabbedPane getjTabbedPane() {
		return jTabbedPane;
	}
	
	public JTabbedPane getPanelPrincipal() {
		jTabbedPane = new JTabbedPane();
		jTabbedPane.add("Profesores", new PanelProfesor());
		jTabbedPane.add("Estudiantes", new PanelEstudiante());
		jTabbedPane.add("Valoraciones", new PanelValoraciones());
		jTabbedPane.add("Val. por Notas", new PanelValoraciones2());
		return jTabbedPane;
	}

	public static void main(String[] args) {
		Principal.getInstance().setVisible(true);
	}

	/**
	 * Al cerrar la aplicaci�n preguntaremos al usuario si est� seguro de que desea salir.
	 */
	private void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(this,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
}
