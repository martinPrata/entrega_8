package ej2;

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


	public void close() throws DBManagerException {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Conexión cerrada correctamente.");
            }
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_6, "Error al cerrar la base de datos", e);
        }
	}
}
	
