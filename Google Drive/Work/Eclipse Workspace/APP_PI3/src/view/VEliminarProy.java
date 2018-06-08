package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.ProyectoPersistencia;
import control.ControlProyecto;
import model.Proyecto;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VEliminarProy extends JPanel implements IVentanaProyecto {
	private JTable tblProy;
	private JScrollPane spTabla;
	private DefaultTableModel dtm;
	private JButton btnEliminar;

	public VEliminarProy() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spTabla = new JScrollPane();
		spTabla.setBounds(31, 64, 385, 143);
		add(spTabla);
		
		tblProy = new JTable();
		cargarTablaProy();
		spTabla.setViewportView(tblProy);
		
		btnEliminar = new JButton("Eliminar Pokemon");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(31, 233, 130, 23);
		add(btnEliminar);

	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTable() {
		return tblProy;
	}

	public void cargarTablaProy() {
		dtm = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblProy.setModel(dtm);
		
		dtm.addColumn("ID P.I.");
		dtm.addColumn("NOMBRE DEL P.I.");
		dtm.addColumn("URL");
		dtm.addColumn("NOTA");
		dtm.addColumn("AÑO");
		dtm.addColumn("CURSO");
		dtm.addColumn("GRUPO");
		dtm.addColumn("CICLO");
		dtm.addColumn("COMPONENTES");
		
		tblProy.getColumn("ID P.I.").setPreferredWidth(75);
		tblProy.getColumn("NOMBRE DEL P.I.").setPreferredWidth(75);
		tblProy.getColumn("URL").setPreferredWidth(75);
		tblProy.getColumn("NOTA").setPreferredWidth(75);
		tblProy.getColumn("AÑO").setPreferredWidth(75);
		tblProy.getColumn("CURSO").setPreferredWidth(75);
		tblProy.getColumn("GRUPO").setPreferredWidth(75);
		tblProy.getColumn("CICLO").setPreferredWidth(75);
		tblProy.getColumn("COMPONENTES").setPreferredWidth(75);
		
		// TODO: recuperar la lista de pilotos
		ProyectoPersistencia pp = new ProyectoPersistencia();
		ArrayList<Proyecto> listaProyecto = pp.consultaProyecto();
		Object[] fila = new Object[9];
		
		for (Proyecto proyecto : listaProyecto) {
			fila[0] = proyecto.getId();
			fila[1] = proyecto.getNom();
			fila[2] = proyecto.getUrl();
			fila[3] = proyecto.getNota();
			fila[4] = proyecto.getAnio();
			fila[5] = proyecto.getCurso();
			fila[6] = proyecto.getGrupo();
			fila[7] = proyecto.getCiclo();
			fila[8] = proyecto.getComponentes();
			dtm.addRow(fila);
		}
		
		
	}

	@Override
	public void setControlador(ControlProyecto control) {
		tblProy.addMouseListener(control);
		btnEliminar.addActionListener(control);
		
	}
public int obtenerId() {
		
		int iSel = tblProy.getSelectedRow();
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
	

