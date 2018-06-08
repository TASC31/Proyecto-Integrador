package view;

import javax.swing.JPanel;

import control.ControlProyecto;
import javax.swing.JLabel;

public class VAcciones extends JPanel implements IVentanaProyecto {

	public VAcciones() {
	inicializar();
	}

	@Override
	public void inicializar() {
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);

	}

	@Override
	public void setControlador(ControlProyecto control) {
		// TODO Auto-generated method stub

	}

}
