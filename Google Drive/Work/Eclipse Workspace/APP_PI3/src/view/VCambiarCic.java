package view;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Ciclo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class VCambiarCic extends JPanel implements IVentanaProyecto {
	private JSpinner spnId;
	private JTextField txtNombre;
	private JButton btnGuardar;
	private JButton btnVolver;
	private JTextArea txtADesc;
	
	public VCambiarCic() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JLabel lblId = new JLabel("ID de Ciclo:");
		lblId.setBounds(37, 62, 103, 14);
		add(lblId);
		
		spnId = new JSpinner();
		spnId.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spnId.setEnabled(false);
		spnId.setBounds(148, 59, 58, 20);
		add(spnId);
		
		JLabel lblNombre = new JLabel("Nombre de Ciclo:");
		lblNombre.setBounds(37, 110, 103, 14);
		add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.setEditable(false);
		txtNombre.setBounds(148, 107, 141, 20);
		add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDesc = new JLabel("Descripción:");
		lblDesc.setBounds(37, 155, 103, 14);
		add(lblDesc);
		
		btnGuardar = new JButton("Guardar Datos");
		btnGuardar.setBounds(37, 243, 159, 23);
		add(btnGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(351, 243, 89, 23);
		add(btnVolver);
		
		JScrollPane spta = new JScrollPane();
		spta.setBounds(148, 155, 246, 65);
		add(spta);
		
		txtADesc = new JTextArea();
		txtADesc.setEditable(false);
		txtADesc.setEnabled(false);
		spta.setViewportView(txtADesc);

	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}
	
	public void cargarDatosCiclo(Ciclo ciclo) {
		spnId.setValue(ciclo.getId());
		txtNombre.setText(ciclo.getNom());
		txtADesc.setText(ciclo.getDesc());
	
	}
	
	public Ciclo obtenerDatosCiclo() {
		int id = (int) spnId.getValue();
		String nom = txtNombre.getText();
		String desc = txtADesc.getText();
		Ciclo ciclo = new Ciclo(id, nom, desc);
		
		return ciclo;
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