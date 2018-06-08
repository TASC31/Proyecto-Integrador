package view;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Alumno;
import model.Proyecto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SpinnerListModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VCambiarProy extends JPanel implements IVentanaProyecto {
	private JSpinner spnId;
	private JTextField txtNombre;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JTextField txtUrl;
	private JSpinner spnNota;
	private JSpinner spnCurso;
	private JSpinner spnAnio;
	private JSpinner spnGrupo;
	private JTextArea txtAComponentes;
	private JSpinner spnCiclo;
	
	public VCambiarProy() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID de Proyecto:");
		lblId.setBounds(37, 37, 103, 14);
		add(lblId);
		
		spnId = new JSpinner();
		spnId.setModel(new SpinnerNumberModel(0, 0, 99, 1));
		spnId.setEnabled(false);
		spnId.setBounds(164, 34, 56, 20);
		add(spnId);
		
		JLabel lblNombre = new JLabel("Nombre de P.I.:");
		lblNombre.setBounds(37, 62, 103, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(164, 59, 276, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(164, 342, 177, 23);
		add(btnGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(351, 342, 89, 23);
		add(btnVolver);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(37, 87, 46, 14);
		add(lblUrl);
		
		txtUrl = new JTextField();
		txtUrl.setBounds(164, 84, 276, 17);
		add(txtUrl);
		txtUrl.setColumns(10);
		
		JLabel lblNota = new JLabel("Nota del P.I.:");
		lblNota.setBounds(37, 112, 103, 14);
		add(lblNota);
		
		spnNota = new JSpinner();
		spnNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spnNota.setBounds(164, 109, 56, 20);
		add(spnNota);
		
		JLabel lblAnio = new JLabel("A\u00F1o del P.I.:");
		lblAnio.setBounds(37, 137, 103, 14);
		add(lblAnio);
		
		spnAnio = new JSpinner();
		spnAnio.setModel(new SpinnerNumberModel(2014, 2014, 2018, 1));
		spnAnio.setBounds(164, 134, 56, 20);
		add(spnAnio);
		
		JLabel lblCurso = new JLabel("Curso: ");
		lblCurso.setBounds(37, 162, 46, 14);
		add(lblCurso);
		
		spnCurso = new JSpinner();
		spnCurso.setModel(new SpinnerNumberModel(1, 1, 2, 1));
		spnCurso.setBounds(164, 159, 56, 20);
		add(spnCurso);
		
		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(37, 187, 46, 14);
		add(lblGrupo);
		
		spnGrupo = new JSpinner();
		spnGrupo.setModel(new SpinnerListModel(new String[] {"M11", "M12", "M22"}));
		spnGrupo.setBounds(164, 184, 56, 20);
		add(spnGrupo);
		
		JLabel lblCiclo = new JLabel("ID del Ciclo:");
		lblCiclo.setBounds(37, 212, 81, 14);
		add(lblCiclo);
		
		spnCiclo = new JSpinner();
		spnCiclo.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spnCiclo.setBounds(164, 209, 56, 20);
		add(spnCiclo);
		
		JLabel lblComponentes = new JLabel("Componentes:");
		lblComponentes.setBounds(37, 237, 81, 14);
		add(lblComponentes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(164, 243, 276, 82);
		add(scrollPane);
		
		txtAComponentes = new JTextArea();
		scrollPane.setViewportView(txtAComponentes);

	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public void cargarDatosProyecto(Proyecto proyecto) {
		spnId.setValue(proyecto.getId());
		txtNombre.setText(proyecto.getNom());
		txtUrl.setText(proyecto.getUrl());
		spnNota.setValue(proyecto.getNota());
		spnAnio.setValue(proyecto.getAnio());
		spnCurso.setValue(proyecto.getCurso());
		spnGrupo.setValue(proyecto.getGrupo());
		spnCiclo.setValue(proyecto.getCiclo());
		txtAComponentes.setText(proyecto.getComponentes());
	
	}
	
	public Proyecto obtenerDatosProyecto() {
		int id = (int) spnId.getValue();
		String nom = txtNombre.getText();
		String url = txtUrl.getText();
		int nota = (int) spnNota.getValue();
		int anio = (int) spnAnio.getValue();
		int curso = (int) spnCurso.getValue();
		String grupo = (String) spnGrupo.getValue();
		int ciclo = (int) spnCiclo.getValue();
		String componentes = txtAComponentes.getText();
		Proyecto proyecto = new Proyecto(id, nom, url, nota, anio, curso, grupo, ciclo, componentes);
		
		return proyecto;
	}
	
	public void mostrarResultado(String msg) {
		JOptionPane.showMessageDialog(getParent(), 
					msg,
					"Resultado de la operación",
					JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnGuardar.addActionListener(control);
		btnVolver.addActionListener(control);

	}
}