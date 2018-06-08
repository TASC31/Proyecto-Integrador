package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.CicloPersistencia;
import control.ControlProyecto;
import model.Ciclo;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VEliminarCic extends JPanel implements IVentanaProyecto {
	private JTable tblCiclo;
	private JScrollPane spTabla;
	private DefaultTableModel dtm;
	private JButton btnEliminar;

	public VEliminarCic() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spTabla = new JScrollPane();
		spTabla.setBounds(31, 64, 385, 143);
		add(spTabla);
		
		tblCiclo = new JTable();
		cargarTablaCic();
		spTabla.setViewportView(tblCiclo);
		
		btnEliminar = new JButton("Eliminar Pokemon");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(31, 233, 130, 23);
		add(btnEliminar);

	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTable() {
		return tblCiclo;
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

	@Override
	public void setControlador(ControlProyecto control) {
		tblCiclo.addMouseListener(control);
		btnEliminar.addActionListener(control);
		
	}

	public int obtenerId() {
		int iSel = tblCiclo.getSelectedRow();
		int id = (int) dtm.getValueAt(iSel, 0);
		return id;
	}

	public void mostrarResultado(String msg) {
		JOptionPane.showMessageDialog(getParent(), 
					msg,
					"Resultado de la operación",
					JOptionPane.INFORMATION_MESSAGE);
	}
	
}
