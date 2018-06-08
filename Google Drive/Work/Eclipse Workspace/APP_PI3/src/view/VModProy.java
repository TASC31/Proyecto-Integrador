package view;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import accesoDB.ProyectoPersistencia;
import control.ControlProyecto;
import model.Alumno;
import model.Ciclo;
import model.Proyecto;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

public class VModProy extends JPanel implements IVentanaProyecto {
	private JTable tblProy;
	private JButton btnModificar;
	private DefaultTableModel dtm;
	private VConsProy vCP;

	public VModProy() {
		inicializar();
	}

	@Override
	public void inicializar() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 218);
		add(scrollPane);
		
		tblProy = new JTable();
		tblProy.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cargarTablaProy();
		scrollPane.setViewportView(tblProy);
		
		btnModificar = new JButton("Modificar Proyectos");
		btnModificar.setBounds(304, 266, 136, 23);
		add(btnModificar);

	}
	
	public JTable getTblProyectos() {
		return tblProy;
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public Proyecto obtenerRegistroSelProy() {
		
		int iSel = tblProy.getSelectedRow();
		
		int id = (int) dtm.getValueAt(iSel, 0);
		String nom = (String) dtm.getValueAt(iSel, 1);
		String url = (String) dtm.getValueAt(iSel, 2);
		int nota = (int) dtm.getValueAt(iSel, 3);
		int anio = (int) dtm.getValueAt(iSel, 4);
		int curso = (int) dtm.getValueAt(iSel, 5);
		String grupo = (String) dtm.getValueAt(iSel, 6);
		int ciclo = (int) dtm.getValueAt(iSel, 7);
		String componentes = (String) dtm.getValueAt(iSel, 8);
		Proyecto proyecto = new Proyecto(id, nom, url, nota, anio, curso, grupo, ciclo, componentes);
		
		return proyecto;
	}

	@Override
	public void setControlador(ControlProyecto control) {
		btnModificar.addActionListener(control);
		tblProy.addMouseListener(control);

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