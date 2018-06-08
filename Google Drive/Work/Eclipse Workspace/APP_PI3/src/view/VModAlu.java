package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import accesoDB.AlumnoPersistencia;
import control.ControlProyecto;
import model.Alumno;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class VModAlu extends JPanel implements IVentanaProyecto {
	private JTable tblAlumno;
	private JButton btnModificar;
	private DefaultTableModel dtm;
	private VConsAlu vCA;

	public VModAlu() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 218);
		add(scrollPane);
		
		tblAlumno = new JTable();
		tblAlumno.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargarTablaAlu();
		scrollPane.setViewportView(tblAlumno);
		
		btnModificar = new JButton("Modificar Alumno");
		btnModificar.setBounds(304, 266, 136, 23);
		add(btnModificar);

	}
	
	public JTable getTblAlumnos() {
		return tblAlumno;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public Alumno obtenerRegistroSelAlu() {
		
		int iSel = tblAlumno.getSelectedRow();
		
		int id = (int) dtm.getValueAt(iSel, 0);
		String nom = (String) dtm.getValueAt(iSel, 1);
		int num = (int) dtm.getValueAt(iSel, 2);
		Alumno alumno = new Alumno(num, nom, num);
		
		return alumno;
	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnModificar.addActionListener(control);
		tblAlumno.addMouseListener(control);

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