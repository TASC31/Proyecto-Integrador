package view;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import control.ControlProyecto;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;;

public class VLogin extends JFrame {
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JButton btnAcceder;
	private JTextField txtUsuario;
	private JPasswordField pswCont;

	public VLogin() throws HeadlessException {
		super("Acceso Profesores");
		inicializar();
	}

	private void inicializar() {
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblPassword = new JLabel("Contraseña:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsuario.setColumns(10);
		
		pswCont = new JPasswordField();
		pswCont.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		btnAcceder = new JButton("Acceder");
		btnAcceder.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnAcceder)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPassword))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(pswCont)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblUsuario)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblPassword)
						.addComponent(pswCont, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAcceder))
					.addGap(30))
		);
		getContentPane().setLayout(groupLayout);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// asignamos tamaño a la ventana 
		setPreferredSize(new Dimension(350, 200));  

		// Se obtienen las dimensiones en pixels de la pantalla.       
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();               

		// Se obtienen las dimensiones en pixels de la ventana.       
		Dimension ventana = this.getPreferredSize();               

		// Una cuenta para situar la ventana en el centro de la pantalla.       
		setBounds((pantalla.width - ventana.width) / 2,  
				(pantalla.height - ventana.height) / 2, 350, 220);
		
	}
	
	public void hacerVisible() {
		setVisible(true);
	}
	
	public void setControlador(ControlProyecto control) {
		btnAcceder.addActionListener(control);
	}

	public JButton getBtnAcceder() {
		return btnAcceder;
	}

	public Usuario getDatos() {
		String usuario = txtUsuario.getText();
		String pwd = new String(pswCont.getPassword());
		Usuario user = new Usuario(usuario, pwd);
		return user;
	}
	
	public void mostrarMensajeE() {
		JOptionPane.showMessageDialog(getContentPane(), "No existe el usuario o la contraseña no es correcta",
				"Error", JOptionPane.ERROR_MESSAGE);
	}
}
