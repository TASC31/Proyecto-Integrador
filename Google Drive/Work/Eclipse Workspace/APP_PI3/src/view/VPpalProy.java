package view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import control.ControlProyecto;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VPpalProy extends JFrame implements IVentanaProyecto {
	private JScrollPane spContenedor;
	private Container menuBar;
	private JMenuItem mntmConsultarAlu;
	private JMenuItem mntmAnadirAlu;
	private JMenuItem mntmBorrarAlu;
	private JMenuItem mntmModificarAlu;
	private JMenuItem mntmConsultarCic;
	private JMenuItem mntmAnadirCic;
	private JMenuItem mntmBorrarCic;
	private JMenuItem mntmModificarCic;
	private JMenuItem mntmConsultarProy;
	private JMenuItem mntmAnadirProy;
	private JMenuItem mntmBorrarProy;
	private JMenuItem mntmModificarProy;
	private JMenuItem mntmSalir;
	private JMenuItem mntmCambiar;

	public VPpalProy() throws HeadlessException {
		super("Acceso Aplicación Proyectos Integradores");
		inicializar();
	}

	@Override
	public void inicializar() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		spContenedor = new JScrollPane();
		getContentPane().add(spContenedor, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAlumno = new JMenu("Alumno");
		menuBar.add(mnAlumno);
		
		mntmConsultarAlu = new JMenuItem("Consultar");
		mnAlumno.add(mntmConsultarAlu);
		
		mntmAnadirAlu = new JMenuItem("Añadir");
		mnAlumno.add(mntmAnadirAlu);
		
		mntmBorrarAlu = new JMenuItem("Borrar");
		mnAlumno.add(mntmBorrarAlu);
		
		mntmModificarAlu = new JMenuItem("Modificar");
		mnAlumno.add(mntmModificarAlu);
		
		JMenu mnCiclo = new JMenu("Ciclo");
		menuBar.add(mnCiclo);
		
		mntmConsultarCic = new JMenuItem("Consultar");
		mnCiclo.add(mntmConsultarCic);
		
		mntmAnadirCic = new JMenuItem("Añadir");
		mnCiclo.add(mntmAnadirCic);
		
		mntmBorrarCic = new JMenuItem("Borrar");
		mnCiclo.add(mntmBorrarCic);
		
		mntmModificarCic = new JMenuItem("Modificar");
		mnCiclo.add(mntmModificarCic);
		
		JMenu mnProyectoIntegrador = new JMenu("Proyecto Integrador");
		menuBar.add(mnProyectoIntegrador);
		
		mntmConsultarProy = new JMenuItem("Consultar");
		mnProyectoIntegrador.add(mntmConsultarProy);
		
		mntmAnadirProy = new JMenuItem("Añadir");
		mnProyectoIntegrador.add(mntmAnadirProy);
		
		mntmBorrarProy = new JMenuItem("Borrar");
		mnProyectoIntegrador.add(mntmBorrarProy);
		
		mntmModificarProy = new JMenuItem("Modificar");
		mnProyectoIntegrador.add(mntmModificarProy);
		
		mntmCambiar = new JMenuItem("Cambiar de acceso\r\n");
		menuBar.add(mntmCambiar);
		
		mntmSalir = new JMenuItem("Salir");
		menuBar.add(mntmSalir);
		
		// ** CERRAR AL PULSAR SOBRE LA X DE LA VENTANA **
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// ** INICIO DEL CÓDIGO ENCARGADO DE LA POSICIÓN Y LA DIMENSIÓN **
		// asignamos tamaño a la ventana 
		setPreferredSize(new Dimension(600, 400));  

		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               

		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = this.getPreferredSize();               

		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setLocation((pantalla.width - ventana.width) / 2,  
					(pantalla.height - ventana.height) / 2);
	}
	
	public void hacerVisible() {
		pack();
		setVisible(true);
	}
	
	public void confirmarSalida() {
		int opcion = JOptionPane.showConfirmDialog(getContentPane(), 
					"¿Está seguro de que desea salir?", 
					"Confirmación salida", 
					JOptionPane.YES_NO_OPTION);
		
		if (opcion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	@Override
	public void setControlador(ControlProyecto control) {
		mntmConsultarAlu.addActionListener(control);
		mntmAnadirAlu.addActionListener(control);
		mntmBorrarAlu.addActionListener(control);
		mntmModificarAlu.addActionListener(control);
		mntmConsultarCic.addActionListener(control);
		mntmAnadirCic.addActionListener(control);
		mntmBorrarCic.addActionListener(control);
		mntmModificarCic.addActionListener(control);
		mntmConsultarProy.addActionListener(control);
		mntmAnadirProy.addActionListener(control);
		mntmBorrarProy.addActionListener(control);
		mntmModificarProy.addActionListener(control);
		mntmSalir.addActionListener(control);
		mntmCambiar.addActionListener(control);
	}
	
	public JMenuItem getMntmConsultarAlu() {
		return mntmConsultarAlu;
	}

	public JMenuItem getMntmAnadirAlu() {
		return mntmAnadirAlu;
	}

	public JMenuItem getMntmBorrarAlu() {
		return mntmBorrarAlu;
	}

	public JMenuItem getMntmModificarAlu() {
		return mntmModificarAlu;
	}

	public JMenuItem getMntmConsultarCic() {
		return mntmConsultarCic;
	}

	public JMenuItem getMntmAnadirCic() {
		return mntmAnadirCic;
	}

	public JMenuItem getMntmBorrarCic() {
		return mntmBorrarCic;
	}

	public JMenuItem getMntmModificarCic() {
		return mntmModificarCic;
	}

	public JMenuItem getMntmConsultarProy() {
		return mntmConsultarProy;
	}

	public JMenuItem getMntmAnadirProy() {
		return mntmAnadirProy;
	}

	public JMenuItem getMntmBorrarProy() {
		return mntmBorrarProy;
	}

	public JMenuItem getMntmModificarProy() {
		return mntmModificarProy;
	}
	
	public JMenuItem getMntmSalir() {
		return mntmSalir;
	}

	public JMenuItem getMntmCambiar() {
		return mntmCambiar;
	}

	public void setMntmSalir(JMenuItem mntmSalir) {
		this.mntmSalir = mntmSalir;
	}

	public void visualizarPanel(JPanel panel) {
		spContenedor.setViewportView(panel);
	}
}
