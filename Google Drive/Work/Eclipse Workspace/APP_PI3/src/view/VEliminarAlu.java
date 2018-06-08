package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import accesoDB.AlumnoPersistencia;
import control.ControlProyecto;
import model.Alumno;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VEliminarAlu extends JPanel implements IVentanaProyecto {
	private JTable tblAlumno;
	private JScrollPane spTabla;
	private DefaultTableModel dtm;
	private JButton btnEliminar;

	public VEliminarAlu() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		spTabla = new JScrollPane();
		spTabla.setBounds(31, 64, 385, 143);
		add(spTabla);
		
		tblAlumno = new JTable();
		cargarTablaAlu();
		spTabla.setViewportView(tblAlumno);
		
		btnEliminar = new JButton("Eliminar Pokemon");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(31, 233, 130, 23);
		add(btnEliminar);

	}
	
	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public JTable getTable() {
		return tblAlumno;
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

	@Override
	public void setControlador(ControlProyecto control) {
		tblAlumno.addMouseListener(control);
		btnEliminar.addActionListener(control);
		
	}

	public void mostrarResultado(String msg) {
		JOptionPane.showMessageDialog(getParent(), 
					msg,
					"Resultado de la operación",
					JOptionPane.INFORMATION_MESSAGE);
	}

	public int obtenerId() {
		int iSel = tblAlumno.getSelectedRow();
		int id = (int) dtm.getValueAt(iSel, 0);
		return id;
	}
	
}
