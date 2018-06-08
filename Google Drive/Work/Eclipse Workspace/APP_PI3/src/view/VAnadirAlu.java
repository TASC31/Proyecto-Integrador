package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JPanel;


import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import control.ControlProyecto;
import model.Alumno;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;

public class VAnadirAlu extends JPanel implements IVentanaProyecto {
	private JSpinner spnId;
	private JTextField txtNom;
	private JButton btnInsertar;
	private JSpinner spnExp;

	
	
	public VAnadirAlu() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setPreferredSize(new Dimension(430, 280));  
		setLayout(null);
		
		spnId = new JSpinner();
		spnId.setModel(new SpinnerNumberModel(1, 1, 99, 1));
		spnId.setBounds(184, 30, 61, 20);
		add(spnId);
		
		JLabel lblId = new JLabel("ID de Alumno:");
		lblId.setBounds(59, 33, 78, 14);
		add(lblId);
		
		JLabel lblNombre = new JLabel("Nombre y Apellido:");
		lblNombre.setBounds(59, 89, 115, 14);
		add(lblNombre);
		
		txtNom = new JTextField();
		txtNom.setBounds(184, 86, 160, 20);
		add(txtNom);
		txtNom.setColumns(10);
		
		btnInsertar = new JButton("Insertar Alumno");
		btnInsertar.setBounds(147, 205, 146, 23);
		add(btnInsertar);
		
		JLabel lblExp = new JLabel("Nº Expediente: ");
		lblExp.setBounds(59, 155, 78, 14);
		add(lblExp);
		
		spnExp = new JSpinner();
		spnExp.setModel(new SpinnerNumberModel(100000, 100000, 999999, 1));
		spnExp.setBounds(184, 152, 61, 17);
		add(spnExp);

	}


	public JButton getBtnInsertarAlumno() {
		return btnInsertar;
	}

	public Alumno InsertarAlumno() {
		int id = (int) spnId.getValue();
		String nom = txtNom.getText();
		int num = (int) spnExp.getValue();
		Alumno alu = null;
		
		
			
		if (nom.equals("")) {
			JOptionPane.showMessageDialog(getParent(), 
					"No has puesto un  nombre",
					"Resultado de la operación",
					JOptionPane.INFORMATION_MESSAGE);
			
		} else {
			alu = new Alumno(id, nom, num);
			
		}
		
		return alu;
	}
	
	public void mensaje() {
		JOptionPane.showMessageDialog(getParent(), "Ese id ya está insertado",
				"Resultado de la operación" , JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnInsertar.addActionListener(control);
		
	}
}
