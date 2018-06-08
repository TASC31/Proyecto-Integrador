package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import accesoDB.CicloPersistencia;
import control.ControlProyecto;
import model.Alumno;
import model.Ciclo;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class VModCic extends JPanel implements IVentanaProyecto {
	private JTable tblCiclo;
	private JButton btnModificar;
	private DefaultTableModel dtm;
	private VConsCic vCC;

	public VModCic() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 218);
		add(scrollPane);
		
		tblCiclo = new JTable();
		tblCiclo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargarTablaCic();
		scrollPane.setViewportView(tblCiclo);
		
		btnModificar = new JButton("Modificar Ciclos");
		btnModificar.setBounds(304, 266, 136, 23);
		add(btnModificar);

	}
	
	public JTable getTblCiclos() {
		return tblCiclo;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public Ciclo obtenerRegistroSelCic() {
		
		int iSel = tblCiclo.getSelectedRow();
		
		int id = (int) dtm.getValueAt(iSel, 0);
		String nom = (String) dtm.getValueAt(iSel, 1);
		String desc = (String) dtm.getValueAt(iSel, 2);
		Ciclo ciclo = new Ciclo(id, nom, desc);
		
		return ciclo;
	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnModificar.addActionListener(control);
		tblCiclo.addMouseListener(control);

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