package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import accesoDB.AlumnoPersistencia;
import accesoDB.CicloPersistencia;
import accesoDB.ProyectoPersistencia;
import accesoDB.UsuarioPersistencia;
import model.Alumno;
import model.Ciclo;
import model.Proyecto;
import model.Usuario;
import view.VPpalProy;
import view.VAcciones;
import view.VAnadirAlu;
import view.VAnadirCic;
import view.VAnadirProy;
import view.VBotones;
import view.VCambiarAlu;
import view.VCambiarCic;
import view.VCambiarProy;
import view.VConsAlu;
import view.VConsCic;
import view.VConsProy;
import view.VEliminarAlu;
import view.VEliminarCic;
import view.VEliminarProy;
import view.VLogin;
import view.VModAlu;
import view.VModCic;
import view.VModProy;

public class ControlProyecto implements ActionListener, MouseListener {

	private VPpalProy vPpal;
	private VBotones vBot;
	private VLogin vLog;
	private VAcciones vAcc;
	private VConsAlu vCA;
	private VConsCic vCC;
	private VConsProy vCP;
	private VModAlu vMA;
	private VModCic vMC;
	private VModProy vMP;
	private VCambiarAlu vCamA;
	private VCambiarCic vCamC;
	private VCambiarProy vCamP;
	private VEliminarAlu vEA;
	private VEliminarCic vEC;
	private VEliminarProy vEP;
	private VAnadirAlu vAA;
	private VAnadirCic vAC;
	private VAnadirProy vAP;
	private AlumnoPersistencia ap = new AlumnoPersistencia();
	private CicloPersistencia cp = new CicloPersistencia();
	private ProyectoPersistencia pp = new ProyectoPersistencia();
	private UsuarioPersistencia up = new UsuarioPersistencia();
	public boolean logeado = false;
	public ControlProyecto(VPpalProy vPpal) {
		super();
		this.vPpal = vPpal;
	}

	public void setvAcc(VAcciones vAcc) {
		this.vAcc = vAcc;
	}
	
	public void setvBot(VBotones vBot) {
		this.vBot = vBot;
	}

	public void setvCA(VConsAlu vCA) {
		this.vCA = vCA;
	}

	public void setvCC(VConsCic vCC) {
		this.vCC = vCC;
	}

	public void setvCP(VConsProy vCP) {
		this.vCP = vCP;
	}

	public void setvMA(VModAlu vMA) {
		this.vMA = vMA;
	}

	public void setvMC(VModCic vMC) {
		this.vMC = vMC;
	}

	public void setvMP(VModProy vMP) {
		this.vMP = vMP;
	}

	public void setvCamA(VCambiarAlu vCamA) {
		this.vCamA = vCamA;
	}

	public void setvCamC(VCambiarCic vCamC) {
		this.vCamC = vCamC;
	}

	public void setvCamP(VCambiarProy vCamP) {
		this.vCamP = vCamP;
	}

	public void setvEA(VEliminarAlu vEA) {
		this.vEA = vEA;
	}

	public void setvEC(VEliminarCic vEC) {
		this.vEC = vEC;
	}

	public void setvEP(VEliminarProy vEP) {
		this.vEP = vEP;
	}

	public void setvAA(VAnadirAlu vAA) {
		this.vAA = vAA;
	}

	public void setvAC(VAnadirCic vAC) {
		this.vAC = vAC;
	}

	public void setvAP(VAnadirProy vAP) {
		this.vAP = vAP;
	}

	public void setvLog(VLogin vLog) {
		this.vLog = vLog;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object fuente = e.getSource();
		
		
		
		if (fuente.equals(vAA.getBtnInsertarAlumno())) {
			Alumno alu = vAA.InsertarAlumno();
			
			if(ap.consultaAlumno().equals(null)) {
				
				if (alu != null) {
					int listaAlumnos = ap.insertarAlumno(alu);
				}
			}else {
				vAA.mensaje();
			}
			
			
			
		}
		
		
		
		
		if (fuente.equals(vBot.getBtnProfesores())) {
			vLog.hacerVisible();
		} else if (fuente.equals(vBot.getBtnAlumnos())) {
			mensajeAlu();
			logeado = false;
		} else if (fuente.equals(vPpal.getMntmSalir())) {
			vPpal.confirmarSalida();
		} else if (fuente.equals(vPpal.getMntmCambiar())) {
			vPpal.visualizarPanel(vBot);
		} else if (fuente.equals(vPpal.getMntmConsultarAlu())) {
			vPpal.visualizarPanel(vCA);
		} else if (fuente.equals(vPpal.getMntmConsultarCic())) {
			vPpal.visualizarPanel(vCC);
		} else if (fuente.equals(vPpal.getMntmConsultarProy())) {
			vPpal.visualizarPanel(vCP);
		} else if (fuente.equals(vPpal.getMntmBorrarAlu())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vEA);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmBorrarCic())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vEC);
			}
		} else if (fuente.equals(vPpal.getMntmBorrarProy())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vEP);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmAnadirAlu())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vAA);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmAnadirCic())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vAC);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmAnadirProy())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vAP);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmModificarAlu())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vMA);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmModificarCic())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vMC);
			}else mensajeD();
		} else if (fuente.equals(vPpal.getMntmModificarProy())) {
			if (logeado == true) {
			vPpal.visualizarPanel(vMP);
			}else mensajeD();
		} else if (fuente.equals(vMA.getBtnModificar())) {
			if (logeado == true) {
			if (vMA.getTblAlumnos().getSelectedRowCount() < 1) {
				mensajeMod();
			} else {
			// veremos si hay solo una fila seleccionada, si es asi
			Alumno alumno = vMA.obtenerRegistroSelAlu();

			// se abrirá el panel de modificar
			vPpal.visualizarPanel(vCamA);
			}
			}else mensajeD();
		} else if (fuente.equals(vCamA.getBtnVolver())) {
			vPpal.visualizarPanel(vMA);
			vCA.cargarTablaAlu();
		} else if (fuente.equals(vCamA.getBtnGuardar())) {
			Alumno alumno = vCamA.obtenerDatosAlumno();
			String msg = ap.modificarAlumno(alumno);
			vCamA.mostrarResultado(msg);
		} else if (fuente.equals(vMC.getBtnModificar())) {
			if (logeado == true) {
			if (vMC.getTblCiclos().getSelectedRowCount() < 1) {
				mensajeMod();
			} else {
			Ciclo ciclo = vMC.obtenerRegistroSelCic();
			vCamC.cargarDatosCiclo(ciclo);
			vPpal.visualizarPanel(vCamC);
			}
			}else mensajeD();
		} else if (fuente.equals(vCamC.getBtnVolver())) {
			vPpal.visualizarPanel(vMC);
			vCC.cargarTablaCic();
		} else if (fuente.equals(vCamC.getBtnGuardar())) {
			Ciclo  ciclo = vCamC.obtenerDatosCiclo();
			String msg = cp.modificarCiclo(ciclo);
			vCamC.mostrarResultado(msg);
		} else if (fuente.equals(vMP.getBtnModificar())) {
			if (logeado == true) {
			if (vMP.getTblProyectos().getSelectedRowCount() < 1) {
				mensajeMod();
			} else {
			// veremos si hay solo una fila seleccionada, si es asi
			Proyecto proyecto = vMP.obtenerRegistroSelProy();
			vCamP.cargarDatosProyecto(proyecto);
		
			vPpal.visualizarPanel(vCamP);
			}
			}else mensajeD();
		} else if (fuente.equals(vCamP.getBtnVolver())) {
			vPpal.visualizarPanel(vMP);
			vCP.cargarTablaProy();
		} else if (fuente.equals(vCamP.getBtnGuardar())) {
			Proyecto proyecto = vCamP.obtenerDatosProyecto();
			String msg = pp.modificarProyecto(proyecto);
			vCamP.mostrarResultado(msg);
		} else if (fuente.equals(vEA.getBtnEliminar())) {
					int id = vEA.obtenerId();
					String msg = ap.borrarAlumno(id);
					vEA.mostrarResultado(msg);
					vEA.cargarTablaAlu();
		} else if (fuente.equals(vEC.getBtnEliminar())) {
					int id = vEC.obtenerId();
					String msg = cp.borrarCiclo(id);
					vEC.mostrarResultado(msg);
					vEC.cargarTablaCic();
		} else if (fuente.equals(vEP.getBtnEliminar())) {
					int id = vEP.obtenerId();
					String msg = pp.borrarProyecto(id);
					vEP.mostrarResultado(msg);
					vEP.cargarTablaProy();
		}else if (fuente.equals(vLog.getBtnAcceder())) {
			Usuario user = vLog.getDatos();
			boolean userOK = up.comprobarUsuario(user);
			if (userOK) {
				logeado = true;
				vLog.dispose();
				vPpal.hacerVisible();
			} else 	vLog.mostrarMensajeE();
			
		}
	
	}

	private void mensajeAlu() {
		int res = JOptionPane.YES_NO_OPTION;
		JOptionPane.showMessageDialog( null, "Vas a iniciar sesión como alumno, por lo que no tendrás todos los permisos. ¿Desea continuar?",
				"Aviso" , JOptionPane.YES_NO_OPTION);
		if (res == JOptionPane.YES_OPTION) {
			
		} else {
			
		}
	}

	private void mensajeMod() {
		JOptionPane.showMessageDialog( null, "No has seleccionado ninguna fila",
				"Aviso" , JOptionPane.WARNING_MESSAGE);	
	}
	private void mensajeD() {
		JOptionPane.showMessageDialog( null, "Debes ser profesor",
				"Aviso" , JOptionPane.WARNING_MESSAGE);	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (vEA.getTable().getSelectedRowCount() >= 1) {
			vEA.getBtnEliminar().setEnabled(true);;
		}else if (vEC.getTable().getSelectedRowCount() >= 1) {
			vEC.getBtnEliminar().setEnabled(true);;
		} else if (vEP.getTable().getSelectedRowCount() >= 1) {
			vEP.getBtnEliminar().setEnabled(true);;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
