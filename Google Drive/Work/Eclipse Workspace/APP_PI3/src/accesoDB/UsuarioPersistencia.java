package accesoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;

public class UsuarioPersistencia {
	
	private AccesoDB acceso;

	public UsuarioPersistencia() {
		acceso = new AccesoDB();
	}
	
	public boolean comprobarUsuario(Usuario user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rslt = null;
		boolean userOK = false;
		
		try {
			con = acceso.getConexion();
			
			String query = "SELECT CONTRASEÑA FROM USUARIO WHERE NOMUS = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, user.getUsuario().toUpperCase());
			
			rslt = pstmt.executeQuery();
			
			if (rslt.next()) {
				String pwdDB = rslt.getString("CONTRASEÑA");
				
				if (pwdDB.equals(user.getCont())) {
					userOK = true;
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rslt != null) {
					rslt.close();
				}
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
		return userOK;
	}

}
