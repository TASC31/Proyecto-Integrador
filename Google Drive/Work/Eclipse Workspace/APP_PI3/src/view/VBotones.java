package view;

import javax.swing.JPanel;

import control.ControlProyecto;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class VBotones extends JPanel implements IVentanaProyecto {
	private JButton btnProfesores;
	private JButton btnAlumnos;
	
	public VBotones() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		btnProfesores = new JButton("Acceso Profesores");
		btnProfesores.setBounds(166, 213, 126, 23);
		add(btnProfesores);
		
		btnAlumnos = new JButton("Acceso Alumnos");
		btnAlumnos.setBounds(166, 247, 126, 23);
		add(btnAlumnos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\\u00C1lvaro\\Google Drive\\Work\\Eclipse Workspace\\APP_PI3\\LOGO_PROYECTO(192).png"));
		lblNewLabel.setBounds(128, 51, 164, 116);
		add(lblNewLabel);
		
		JLabel lblAmazingAccessAplication = new JLabel("Amazing Access Aplication");
		lblAmazingAccessAplication.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
		lblAmazingAccessAplication.setBounds(47, 11, 370, 49);
		add(lblAmazingAccessAplication);
		
		JLabel lblTripleAaa = new JLabel("TRIPLE AAA");
		lblTripleAaa.setFont(new Font("Britannic Bold", Font.PLAIN, 20));
		lblTripleAaa.setBounds(176, 164, 126, 24);
		add(lblTripleAaa);

	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnProfesores.addActionListener(control);
		btnAlumnos.addActionListener(control);
	}

	public JButton getBtnProfesores() {
		return btnProfesores;
	}

	public JButton getBtnAlumnos() {
		return btnAlumnos;
	}
}
