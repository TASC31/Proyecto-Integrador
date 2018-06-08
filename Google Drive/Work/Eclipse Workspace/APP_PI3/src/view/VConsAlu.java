package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import control.ControlProyecto;
import model.Alumno;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.AlumnoPersistencia;

public class VConsAlu extends JPanel implements IVentanaProyecto {
	private JTable tblAlumno;
	private JScrollPane spContenedor;
	private DefaultTableModel dtm;

	public VConsAlu() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spContenedor = new JScrollPane();
		spContenedor.setBounds(21, 42, 405, 196);
		add(spContenedor);
		
		tblAlumno = new JTable();
		dtm  = new DefaultTableModel();
		tblAlumno.setModel(dtm);
		cargarTablaAlu();
		spContenedor.setViewportView(tblAlumno);
	}

	public JTable getTblAlumno() {
		return tblAlumno;
	}

	@Override
	public void setControlador(ControlProyecto control) {
		// TODO Auto-generated method stub

	}
	
	public void cargarTablaAlu() {
		dtm = new DefaultTableModel() {  
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		tblAlumno.setModel(dtm);
		
		dtm.addColumn("ID ALUMNO");
		dtm.addColumn("NOMBRE Y APELLIDOS");
		dtm.addColumn("Nº EXPEDIENTE");
		
		tblAlumno.getColumn("ID ALUMNO").setPreferredWidth(75);
		tblAlumno.getColumn("NOMBRE Y APELLIDOS").setPreferredWidth(75);
		tblAlumno.getColumn("Nº EXPEDIENTE").setPreferredWidth(75);
		
		// TODO: recuperar la lista de pilotos
		AlumnoPersistencia ap = new AlumnoPersistencia();
		ArrayList<Alumno> listaAlumnos = ap.consultaAlumno();
		Object[] fila = new Object[3];
		
		for (Alumno alumno : listaAlumnos) {
			fila[0] = alumno.getId();
			fila[1] = alumno.getNom();
			fila[2] = alumno.getNum();
			dtm.addRow(fila);
		}
		
	}
}
