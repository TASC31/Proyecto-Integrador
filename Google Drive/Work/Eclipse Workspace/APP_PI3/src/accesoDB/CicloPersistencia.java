package accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Ciclo;

public class CicloPersistencia {
	
	private AccesoDB acceso;

	public CicloPersistencia() {
		acceso = new AccesoDB();
	}
	
	public Ciclo consultarCicloId(int id) {
		Ciclo cic = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM CICLOS WHERE ID_CI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rslt = pstmt.executeQuery();
			
			int idci = 0;
			String nom = "";
			String desc = "";
			if (rslt.next()) {
				idci = rslt.getInt(1);
				nom = rslt.getString(2);
				desc = rslt.getString(3);
				cic = new Ciclo(idci, nom, desc);
			}
					
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return cic;
	}

	public String modificarCiclo(Ciclo cic) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String msg = "";
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE CICLOS SET NOMCI = ?, DESC = ? WHERE ID_CI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, cic.getNom());
			pstmt.setString(2, cic.getDesc());
			pstmt.setInt(3, cic.getId());
			
			int res = pstmt.executeUpdate();
			
			if (res == 1) {
				msg = "Se ha realizado la modificación";
			} else {
				msg = "NO se ha realizado la modificación";
			}
			
		} catch (ClassNotFoundException e) {
			msg = "No se ha podido establecer la conexión con la base de datos";
			// e.printStackTrace();
		} catch (SQLException e) {
			msg = "Se ha producido un error SQL";
			// e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return msg;
	}

	public ArrayList<Ciclo> consultaCiclo() {
		ArrayList<Ciclo> listaCiclos = new ArrayList<Ciclo>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM CICLOS";
			pstmt = con.prepareStatement(query);
			
			rslt = pstmt.executeQuery();
			
			int id = 0;
			String nom = "";
			String desc = "";
			Ciclo ciclo = null;
			
			while (rslt.next()) {
				id = rslt.getInt("ID_CI");
				nom = rslt.getString("NOMCI");
				desc = rslt.getString("DESC");
				ciclo = new Ciclo(id, nom, desc);
				listaCiclos.add(ciclo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) rslt.close();
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return listaCiclos;
	}
	
	public String borrarCiclo(int id) {
		String res = "";
		int iRes = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM CICLOS WHERE ID_CI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			iRes = pstmt.executeUpdate();
			
			if (iRes > 0) {
				res = "Se ha eliminado el ciclo";
			}
			
		} catch (ClassNotFoundException e) {
			//e.printStackTrace();
			res = "No se ha podido establecer la conexión con la base de datos";
		} catch (SQLException e) {
			//e.printStackTrace();
			res = "No se ha podido realizar la acción por un error SQl";
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				
				if (con != null) con.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return res;
	}
}
