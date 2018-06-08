package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Alumno;
import model.Ciclo;
import model.Proyecto;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.AlumnoPersistencia;
import accesoDB.CicloPersistencia;
import accesoDB.ProyectoPersistencia;

public class VConsProy extends JPanel implements IVentanaProyecto {
	private JTable tblProy;
	private JScrollPane spContenedor;
	private DefaultTableModel dtm;

	public VConsProy() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spContenedor = new JScrollPane();
		spContenedor.setBounds(21, 42, 405, 196);
		add(spContenedor);
		
		tblProy = new JTable();
		cargarTablaProy();
		spContenedor.setViewportView(tblProy);
	}

	@Override
	public void setControlador(ControlProyecto control) {
		// TODO Auto-generated method stub

	}
	
	public JTable getTblProy() {
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
}
