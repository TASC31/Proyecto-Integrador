package accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Proyecto;

public class ProyectoPersistencia {
	
	private AccesoDB acceso;

	public ProyectoPersistencia() {
		acceso = new AccesoDB();
	}
	
	public Proyecto consultarProyectoId(int id) {
		Proyecto proy = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM PROYINT WHERE ID_PI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rslt = pstmt.executeQuery();
			
			int idpi = 0;
			String nom = "";
			String url = "";
			int nota = 0;
			int anio = 0;
			int curso = 0;
			String grupo = "";
			int ciclo = 0;
			String comp = "";
			if (rslt.next()) {
				idpi = rslt.getInt(1);
				nom = rslt.getString(2);
				url = rslt.getString(3);
				nota = rslt.getInt(4);
				anio = rslt.getInt(5);
				curso = rslt.getInt(5);
				grupo = rslt.getString(7);
				ciclo = rslt.getInt(8);
				comp = rslt.getString(9);
				proy = new Proyecto(idpi, nom, url, nota, anio, curso, grupo, ciclo, comp);
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
		
		return proy;
	}

	public String modificarProyecto(Proyecto proy) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String msg = "";
		
		try {
			con = acceso.getConexion();
			
			String query = "UPDATE PROYINT SET NOMPI = ?, URL = ?, NOTA = ?, ANIO = ?, CURSO = ?, GRUPO = ?, CICLO = ?, COMPONENTES = ? WHERE ID_PI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, proy.getNom());
			pstmt.setString(2, proy.getUrl());
			pstmt.setInt(3, proy.getNota());
			pstmt.setInt(4, proy.getAnio());
			pstmt.setInt(5, proy.getCurso());
			pstmt.setString(6, proy.getGrupo());
			pstmt.setInt(7, proy.getCiclo());
			pstmt.setString(8, proy.getComponentes());
			pstmt.setInt(9, proy.getId());
			
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

	public ArrayList<Proyecto> consultaProyecto() {
		ArrayList<Proyecto> listaProyectos = new ArrayList<Proyecto>();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT * FROM PROYINT";
			pstmt = con.prepareStatement(query);
			
			rslt = pstmt.executeQuery();
			
			
			Proyecto proyecto = null;
			int idpi = 0;
			String nom = "";
			String url = "";
			int nota = 0;
			int anio = 0;
			int curso = 0;
			String grupo = "";
			int ciclo = 0;
			String comp = "";
			while (rslt.next()) {
				idpi = rslt.getInt("ID_PI");
				nom = rslt.getString("NOMPI");
				url = rslt.getString("URL");
				nota = rslt.getInt("NOTA");
				anio = rslt.getInt("ANIO");
				curso = rslt.getInt("CURSO");
				grupo = rslt.getString("GRUPO");
				ciclo = rslt.getInt("CICLO");
				comp = rslt.getString("COMPONENTES");
				proyecto = new Proyecto(idpi, nom, url, nota, anio, curso, grupo, ciclo, comp);
				listaProyectos.add(proyecto);
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
		
		return listaProyectos;
	}
	
	public String borrarProyecto(int id) {
		String res = "";
		int iRes = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = acceso.getConexion();
			
			String query = "DELETE FROM PROYINT WHERE ID_PI = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			
			iRes = pstmt.executeUpdate();
			
			if (iRes > 0) {
				res = "Se ha eliminado el proyecto";
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
