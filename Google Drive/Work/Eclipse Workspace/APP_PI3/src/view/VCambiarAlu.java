package view;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Alumno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VCambiarAlu extends JPanel implements IVentanaProyecto {
	private JSpinner spnId;
	private JTextField txtNombre;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JSpinner spnNum;
	
	public VCambiarAlu() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID de Alumno:");
		lblId.setBounds(37, 62, 103, 14);
		add(lblId);
		
		spnId = new JSpinner();
		spnId.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spnId.setEnabled(false);
		spnId.setBounds(150, 59, 56, 20);
		add(spnId);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		lblNombre.setBounds(37, 110, 103, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(148, 107, 141, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNum = new JLabel("Nº de Expediente:");
		lblNum.setBounds(37, 155, 103, 14);
		add(lblNum);
		
		btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(37, 243, 159, 23);
		add(btnGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(351, 243, 89, 23);
		add(btnVolver);
		
		spnNum = new JSpinner();
		spnNum.setModel(new SpinnerNumberModel(100000, 100000, 999999, 1));
		spnNum.setEnabled(false);
		spnNum.setBounds(148, 153, 56, 17);
		add(spnNum);

	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public void cargarDatosAlumno(Alumno piloto) {
		spnId.setValue(piloto.getId());
		txtNombre.setText(piloto.getNom());
		spnNum.setValue(piloto.getNum());
	
	}
	
	public Alumno obtenerDatosAlumno() {
		int id = (int) spnId.getValue();
		String nom = txtNombre.getText();
		int num = (int) spnNum.getValue();
		Alumno alumno = new Alumno(id, nom, num);
		
		return alumno;
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