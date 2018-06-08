package accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Alumno;

public class AlumnoPersistencia {
	
	private AccesoDB acceso;

	public AlumnoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public Alumno consultarAlumnoId(int id) {
		Alumno alu = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM ALUMNOS WHERE ID_AL = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rslt = pstmt.executeQuery();
			
			int idal = 0;
			String nom = "";
			int num = 0;
			if (rslt.next()) {
				idal = rslt.getInt(1);
				nom = rslt.getString(2);
				num = rslt.getInt(3);
				alu = new Alumno(idal, nom, num);
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
		
		return alu;
	}

	public String modificarAlumno(Alumno alu) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String msg = "";
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE ALUMNOS SET NOMAL = ?, NUMEXP = ? WHERE ID_AL = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, alu.getNom());
			pstmt.setInt(2, alu.getNum());
			pstmt.setInt(3, alu.getId());
			
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

	public ArrayList<Alumno> consultaAlumno() {
		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM ALUMNOS";
			pstmt = con.prepareStatement(query);
			
			rslt = pstmt.executeQuery();
			
			int id = 0;
			String nom = "";
			int num = 0;
			Alumno alumno = null;
			
			while (rslt.next()) {
				id = rslt.getInt("ID_AL");
				nom = rslt.getString("NOMAL");
				num = rslt.getInt("NUMEXP");
				alumno = new Alumno(id, nom, num);
				listaAlumnos.add(alumno);
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
		
		return listaAlumnos;
	}
	
	public String borrarAlumno(int id) {
		String res = "";
		int iRes = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM ALUMNOS WHERE ID_AL = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			iRes = pstmt.executeUpdate();
			
			if (iRes > 0) {
				res = "Se ha eliminado el alumno";
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
	
	public int insertarAlumno(Alumno alu) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int row = 0;
		
		try {
			con = acceso.getConexion();
			
			String query = "INSERT INTO ALUMNOS (ID_AL, NOMAL, NUMEXP) VALUES (?, ?, ?)";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, alu.getId());
			pstmt.setString(2, alu.getNom());
			pstmt.setInt(3, alu.getNum());
			
			row = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return row;
	}
}
