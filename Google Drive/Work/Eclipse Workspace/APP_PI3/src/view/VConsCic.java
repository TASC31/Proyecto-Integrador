package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Ciclo;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.CicloPersistencia;

public class VConsCic extends JPanel implements IVentanaProyecto {
	private JTable tblCiclo;
	private JScrollPane spContenedor;
	private DefaultTableModel dtm;

	public VConsCic() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spContenedor = new JScrollPane();
		spContenedor.setBounds(21, 42, 405, 196);
		add(spContenedor);
		
		tblCiclo = new JTable();
		cargarTablaCic();
		spContenedor.setViewportView(tblCiclo);
	}

	public JTable getTblCiclo() {
		return tblCiclo;
	}

	@Override
	public void setControlador(ControlProyecto control) {
		// TODO Auto-generated method stub

	}
	
	public void cargarTablaCic() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblCiclo.setModel(dtm);
		
		dtm.addColumn("ID CICLO");
		dtm.addColumn("NOMBRE DEL CICLO");
		dtm.addColumn("DESCRIPCIÓN");
		
		tblCiclo.getColumn("ID CICLO").setPreferredWidth(75);
		tblCiclo.getColumn("NOMBRE DEL CICLO").setPreferredWidth(75);
		tblCiclo.getColumn("DESCRIPCIÓN").setPreferredWidth(75);
		
		// TODO: recuperar la lista de pilotos
		CicloPersistencia cp = new CicloPersistencia();
		ArrayList<Ciclo> listaCiclos = cp.consultaCiclo();
		Object[] fila = new Object[3];
		
		for (Ciclo ciclo : listaCiclos) {
			fila[0] = ciclo.getId();
			fila[1] = ciclo.getNom();
			fila[2] = ciclo.getDesc();
			dtm.addRow(fila);
		}
		
		
	}
}