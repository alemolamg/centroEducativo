package gui;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import model.controllers.ControladorProfesor;
import model.entities.Tipologiasexo;

import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.awt.event.ActionEvent;

public class PnlDatosPersonales extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfApellido1;
	private JTextField jtfApellido2;
	private JTextField jtfDNI;
	private JTextField jtfDirec;
	private JTextField jtfEmail;
	private JTextField jtfTelefono;
	private JComboBox<Tipologiasexo> jcbSexo;
	private JButton btnCambiarImg;
	private JScrollPane jspImage;
	private byte arrayByteImagen[];
	private JFileChooser jfileChooser;
	private JLabel jlabelColor;
	private JTextField jtfColorFav;
	private JButton btnColor;
	private JColorChooser selectorColor;
	private String colorPanel;
	//private JPopupMenu popupMenu;
	

	/**
	 * Create the panel.
	 */
	public PnlDatosPersonales() {
		super();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 384, 200, 0 };
		gridBagLayout.rowHeights = new int[] { 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);
		JLabel lblNewLabel = new JLabel("Id: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		jtfId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 20);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 0;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		jspImage = new JScrollPane();
		GridBagConstraints gbc_jspImage = new GridBagConstraints();
		gbc_jspImage.gridheight = 7;
		gbc_jspImage.insets = new Insets(0, 0, 5, 0);
		gbc_jspImage.fill = GridBagConstraints.BOTH;
		gbc_jspImage.gridx = 2;
		gbc_jspImage.gridy = 0;
		add(jspImage, gbc_jspImage);
		JLabel lblNewLabel_1 = new JLabel("Nombre: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfNombre = new JTextField();
		jtfNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfNombre.setColumns(10);
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 1;
		add(jtfNombre, gbc_jtfNombre);
		JLabel lblNewLabel_1_1 = new JLabel("Apellido 1:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jtfApellido1 = new JTextField();
		jtfApellido1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfApellido1.setColumns(10);
		GridBagConstraints gbc_jtfApellido1 = new GridBagConstraints();
		gbc_jtfApellido1.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido1.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido1.gridx = 1;
		gbc_jtfApellido1.gridy = 2;
		add(jtfApellido1, gbc_jtfApellido1);
		JLabel lblNewLabel_1_1_1 = new JLabel("Apellido 2:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jtfApellido2 = new JTextField();
		jtfApellido2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfApellido2.setColumns(10);
		GridBagConstraints gbc_jtfApellido2 = new GridBagConstraints();
		gbc_jtfApellido2.insets = new Insets(0, 0, 5, 5);
		gbc_jtfApellido2.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfApellido2.gridx = 1;
		gbc_jtfApellido2.gridy = 3;
		add(jtfApellido2, gbc_jtfApellido2);
		JLabel lblNewLabel_1_1_1_1 = new JLabel("DNI:");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 4;
		add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		jtfDNI = new JTextField();
		jtfDNI.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfDNI.setColumns(10);
		GridBagConstraints gbc_jtfDNI = new GridBagConstraints();
		gbc_jtfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDNI.gridx = 1;
		gbc_jtfDNI.gridy = 4;
		add(jtfDNI, gbc_jtfDNI);
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Dirección:");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_1_1_2.gridy = 5;
		add(lblNewLabel_1_1_1_2, gbc_lblNewLabel_1_1_1_2);
		
		jtfDirec = new JTextField();
		jtfDirec.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfDirec.setColumns(10);
		GridBagConstraints gbc_jtfDirec = new GridBagConstraints();
		gbc_jtfDirec.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDirec.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDirec.gridx = 1;
		gbc_jtfDirec.gridy = 5;
		add(jtfDirec, gbc_jtfDirec);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Email: ");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_2_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_2_1.gridy = 6;
		add(lblNewLabel_1_1_1_2_1, gbc_lblNewLabel_1_1_1_2_1);
		
		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfEmail.setColumns(10);
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 5);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 6;
		add(jtfEmail, gbc_jtfEmail);
		
		JLabel lblNewLabel_1_1_1_2_1_1 = new JLabel("Telefono: ");
		lblNewLabel_1_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1_1_1_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_2_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_2_1_1.gridy = 7;
		add(lblNewLabel_1_1_1_2_1_1, gbc_lblNewLabel_1_1_1_2_1_1);
		
		jtfTelefono = new JTextField();
		jtfTelefono.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfTelefono.setColumns(10);
		GridBagConstraints gbc_jtfTelefono = new GridBagConstraints();
		gbc_jtfTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTelefono.gridx = 1;
		gbc_jtfTelefono.gridy = 7;
		add(jtfTelefono, gbc_jtfTelefono);
		
		btnCambiarImg = new JButton("Cambiar Imagen");
		btnCambiarImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaFichero();
			}
		});
		GridBagConstraints gbc_btnCambiarImg = new GridBagConstraints();
		gbc_btnCambiarImg.insets = new Insets(0, 0, 5, 0);
		gbc_btnCambiarImg.gridx = 2;
		gbc_btnCambiarImg.gridy = 7;
		add(btnCambiarImg, gbc_btnCambiarImg);
		
		jlabelColor = new JLabel("Color Favorito:");
		jlabelColor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_jlabelColor = new GridBagConstraints();
		gbc_jlabelColor.anchor = GridBagConstraints.EAST;
		gbc_jlabelColor.insets = new Insets(0, 0, 5, 5);
		gbc_jlabelColor.gridx = 0;
		gbc_jlabelColor.gridy = 8;
		add(jlabelColor, gbc_jlabelColor);
		
		jtfColorFav = new JTextField();
		jtfColorFav.setEnabled(false);
		jtfColorFav.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtfColorFav.setColumns(10);
		GridBagConstraints gbc_jtfColorFav = new GridBagConstraints();
		gbc_jtfColorFav.insets = new Insets(0, 0, 5, 5);
		gbc_jtfColorFav.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfColorFav.gridx = 1;
		gbc_jtfColorFav.gridy = 8;
		add(jtfColorFav, gbc_jtfColorFav);
		
		btnColor = new JButton("Cambiar Color");
		btnColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seleccionaColor();
			}
		});
		GridBagConstraints gbc_btnColor = new GridBagConstraints();
		gbc_btnColor.insets = new Insets(0, 0, 5, 0);
		gbc_btnColor.gridx = 2;
		gbc_btnColor.gridy = 8;
		add(btnColor, gbc_btnColor);
		
		JLabel lblNewLabelSexo = new JLabel("Sexo:");
		lblNewLabelSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabelSexo = new GridBagConstraints();
		gbc_lblNewLabelSexo.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabelSexo.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabelSexo.gridx = 0;
		gbc_lblNewLabelSexo.gridy = 9;
		add(lblNewLabelSexo, gbc_lblNewLabelSexo);
		
		jcbSexo = new JComboBox();
		jcbSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jcbSexo = new GridBagConstraints();
		gbc_jcbSexo.insets = new Insets(0, 0, 0, 5);
		gbc_jcbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbSexo.gridx = 1;
		gbc_jcbSexo.gridy = 9;
		add(jcbSexo, gbc_jcbSexo);
		
//		creacionPopupMenu();
		
		cargarDatosSexo();
	}

	private void creacionPopupMenu() {
		JPopupMenu popupMenu = getPopUpMenu();
		this.jspImage.addMouseListener(new MouseAdapter() {
			 
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }
 
            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }
 
            /**
             * Método llamado cuando se detecta el evento de ratón, muestra el menú
             * @param e
             */
            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    popupMenu.show(e.getComponent(),
                            e.getX(), e.getY());
                }
            }
        });
	}

	public JTextField getId() {
		return jtfId;
	}

	public void setId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

	public JTextField getNombre() {
		return jtfNombre;
	}

	public void setNombre(JTextField jtfNombre) {
		this.jtfNombre = jtfNombre;
	}

	public JTextField getApellido1() {
		return jtfApellido1;
	}

	public void setApellido1(JTextField jtfApellido1) {
		this.jtfApellido1 = jtfApellido1;
	}

	public JTextField getApellido2() {
		return jtfApellido2;
	}

	public void setApellido2(JTextField jtfApellido2) {
		this.jtfApellido2 = jtfApellido2;
	}

	public JTextField getJtfDNI() {
		return jtfDNI;
	}

	public void setDNI(JTextField jtfDNI) {
		this.jtfDNI = jtfDNI;
	}

	public JTextField getDireccion() {
		return jtfDirec;
	}

	public void setDireccion(JTextField jtfDirec) {
		this.jtfDirec = jtfDirec;
	}

	public JTextField getEmail() {
		return jtfEmail;
	}

	public void setEmail(JTextField jtfEmail) {
		this.jtfEmail = jtfEmail;
	}
	
	

	public String getJtfColorFav() {
		return jtfColorFav.getText();
	}

	public void setJtfColorFav(String jtfColorFav) {
		this.jtfColorFav.setText(jtfColorFav);
	}

	public JTextField getTelefono() {
		return jtfTelefono;
	}

	public void setTelefono(JTextField jtfTelefono) {
		this.jtfTelefono = jtfTelefono;
	}
	
	public void setJcbSexo(JComboBox<Tipologiasexo> jcbSexo) {
		this.jcbSexo = jcbSexo;
	}
	
	public JComboBox<Tipologiasexo> getJcbSexo() {
		return jcbSexo;
	}
	
	private void cargarDatosSexo() {		
		for (Tipologiasexo sex : ControladorProfesor.getInstance().findAllSexo()) {
			this.jcbSexo.addItem(sex);
		}
	}
	
	public void setImagen(byte[] imagen) {
		this.arrayByteImagen = imagen;
		if(imagen != null) {
			ImageIcon imgIcon = new ImageIcon(imagen);
			JLabel jlb = new JLabel(imgIcon);
			this.jspImage.setViewportView(jlb);
		} else
			this.jspImage.setViewportView(new JLabel());
		
		this.jspImage.revalidate();
		this.jspImage.repaint();
		creacionPopupMenu();
	}

	public byte[] getImagen() {
		return this.arrayByteImagen;
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	private byte[] leerContenidoFicheroBinario (File f) {
		try {
			return Files.readAllBytes(f.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new byte[] {};
	}

	private void seleccionaFichero () {
		this.jfileChooser = new JFileChooser();
		
		// Configurando el componente
		
		// Establecimiento de la carpeta de inicio
		this.jfileChooser.setCurrentDirectory(new File("C:\\"));
		
		// Tipo de selecci�n que se hace en el di�logo
//		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY); // S�lo selecciona ficheros
		//this.jfileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); // S�lo selecciona ficheros
		this.jfileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // Selecciona ficheros y carpetas
		
		// Filtro del tipo de ficheros que puede abrir
		this.jfileChooser.setFileFilter(new FileFilter() {
			
			public String getDescription() {
				return "Archivos de imagen *.png";
			}
			
			@Override
			public boolean accept(File f) {
				if (f.isFile() || f.isDirectory() && ( f.getAbsolutePath().endsWith(".jpg") || f.getAbsolutePath().endsWith(".png"))) 
					return true;
				return false;
			}
		});
		
		// Abro el di�logo para la elecci�n del usuario
		int seleccionUsuario = jfileChooser.showOpenDialog(null);
		
		if (seleccionUsuario == JFileChooser.APPROVE_OPTION) {
			File fichero = this.jfileChooser.getSelectedFile();
			setImagen(leerContenidoFicheroBinario(fichero));
		}
	}
	
	private void cambiarFondo(Color color) {
		this.setBackground(color);
	}
		
	public String getColorPanel() {
		return colorPanel;
	}

	public void setColorPanel(String color) {
		if(color != null) {
			this.colorPanel = color;
			cambiarFondo(Color.decode(color));
			this.jtfColorFav.setText(color);
		} else {
			cambiarFondo(Color.decode("0xeeeeee"));
			this.jtfColorFav.setText("");
		}
		
	}
	
	/**
	 * 
	 */
	private void seleccionaColor () {
		Color color = selectorColor.showDialog(null, "Seleccione un Color", Color.gray);
		// Si el usuario pulsa sobre aceptar, el color elegido no ser� nulo
		if (color != null) {
//			String strColor = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.colorPanel = "#"+Integer.toHexString(color.getRGB()).substring(2);
			this.jtfColorFav.setText(colorPanel);
			this.cambiarFondo(color);
		}
	}
	
	private JPopupMenu getPopUpMenu() {
		JPopupMenu menu = new JPopupMenu();
		
		menu.add(itemCambiarImagen());
		menu.addSeparator();
		menu.add(itemDimensiones());		
		return menu;
	}
	
	private JMenuItem itemCambiarImagen() {
		JMenuItem item = new JMenuItem("Cambiar Imagen");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionaFichero();				
			}
		});
		return item;
	}
	
	
	private JMenuItem itemDimensiones() {
		return new JMenuItem(leerDimensionesImagenActual());
	}
	
	
	private String leerDimensionesImagenActual() {
		String texto ="";
		ImageIcon imgIcon;
		if(this.arrayByteImagen != null) {
			 imgIcon = new ImageIcon(arrayByteImagen);
			 texto ="Dimension: " + imgIcon.getIconHeight() + " x " + imgIcon.getIconWidth();
		} else
			 texto ="Dimension: NULL X NULL";	
		return texto;
	}
	
}
