package app;

import java.awt.EventQueue;

import control.ControlProyecto;
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

public class AppProyectoIntegrador {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				VPpalProy vPpal = new VPpalProy();
				VBotones vBot = new VBotones();
				VAcciones vAcc = new VAcciones();
				VConsAlu vCA = new VConsAlu();
				VConsCic vCC = new VConsCic();
				VConsProy vCP = new VConsProy();
				VModAlu vMA = new VModAlu();
				VModCic vMC = new VModCic();
				VModProy vMP = new VModProy();
				VCambiarAlu vCamA = new VCambiarAlu();
				VCambiarCic vCamC = new VCambiarCic();
				VCambiarProy vCamP = new VCambiarProy();
				VEliminarAlu vEA = new VEliminarAlu();
				VEliminarCic vEC = new VEliminarCic();
				VEliminarProy vEP = new VEliminarProy();
				VAnadirAlu vAA = new VAnadirAlu();
				VAnadirCic vAC = new VAnadirCic();
				VAnadirProy vAP = new VAnadirProy();
				VLogin vLog = new VLogin();
				
				ControlProyecto control = new ControlProyecto(vPpal);
				control.setvBot(vBot);
				control.setvAcc(vAcc);
				control.setvCA(vCA);
				control.setvCC(vCC);
				control.setvCP(vCP);
				control.setvMA(vMA);
				control.setvMC(vMC);
				control.setvMP(vMP);
				control.setvCamA(vCamA);
				control.setvCamC(vCamC);
				control.setvCamP(vCamP);
				control.setvEA(vEA);
				control.setvEC(vEC);
				control.setvEP(vEP);
				control.setvAA(vAA);
				control.setvAC(vAC);
				control.setvAP(vAP);
				control.setvLog(vLog);
				
				
				vPpal.setControlador(control);
				vBot.setControlador(control);
				vAcc.setControlador(control);
				vCA.setControlador(control);
				vCC.setControlador(control);
				vCP.setControlador(control);
				vMA.setControlador(control);
				vMC.setControlador(control);
				vMP.setControlador(control);
				vCamA.setControlador(control);
				vCamC.setControlador(control);
				vCamP.setControlador(control);
				vEA.setControlador(control);
				vEC.setControlador(control);
				vEP.setControlador(control);
				vAA.setControlador(control);
				vAC.setControlador(control);
				vAP.setControlador(control);
				vLog.setControlador(control);
				
				vPpal.visualizarPanel(vBot);
				vPpal.hacerVisible();
			}
			
		});

	}

}
