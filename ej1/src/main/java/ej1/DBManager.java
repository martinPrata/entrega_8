package ej1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBManager implements IDBManager{
	
	private Connection conn;
	
	public void conectar() throws DBManagerException {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/entrega8_ej1", "root", "42915204110821");
			System.out.println("Conexion establecida.");
		} catch (SQLException e) {
			throw new DBManagerException(DBManagerException.ERROR_1, "Error al conectar a la base de datos", e);
		}
	}
	  public Connection getConn() {
	        return conn;
	    }

	public void mostrarProvincias(String palabraClave) throws DBManagerException {
	    String query = "SELECT id, descripcion, id_pais FROM provincias WHERE descripcion LIKE ?";
	    try (PreparedStatement stmt = conn.prepareStatement(query)) {
	        stmt.setString(1, "%" + palabraClave + "%");
	        try (ResultSet rs = stmt.executeQuery()) {
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String descripcion = rs.getString("descripcion");
	                int idPais = rs.getInt("id_pais");
	                System.out.println("ID: " + id + ", Descripción: " + descripcion + ", ID País: " + idPais);
	            }
	        }
	    } catch (SQLException e) {
	        throw new DBManagerException(DBManagerException.ERROR_2, "Error al mostrar provincias.", e);
	    }
	}



	public void close() throws DBManagerException {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_3, "Error al cerrar la base de datos", e);
        }
    }
	@Override
	public void mostrarProvincias() throws DBManagerException {
		// TODO Auto-generated method stub
		
	}

	
}
