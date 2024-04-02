package ej2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProvinciaDAOImplementacion implements ProvinciaDAO {
    @Override
    public void insertarProvincia(String nombreProvincia) throws DBManagerException {
        DBManager manager = new DBManager();
        try {
            manager.conectar();
            String query = "INSERT INTO provincias (descripcion, id_pais) VALUES (?, ?)";
            PreparedStatement stmt = manager.getConn().prepareStatement(query);
            stmt.setString(1, nombreProvincia);
            stmt.setInt(2, 1);
            
            int filasInsertadas = stmt.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("La provincia fue insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la provincia.");
            }

            stmt.close();
            
            manager.close();
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_2, "Error al insertar la provincia", e);
        }
    }
    
    @Override
    
    public void modificarProvincia(String nombreActual, String nuevoNombre) throws DBManagerException {
        DBManager manager = new DBManager();
        try {
            manager.conectar();
            String query = "UPDATE provincias SET descripcion = ? WHERE descripcion = ?";
            PreparedStatement stmt = manager.getConn().prepareStatement(query);
            stmt.setString(1, nuevoNombre);
            stmt.setString(2, nombreActual);
            int filasActualizadas = stmt.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Provincia modificada correctamente.");
            } else {
                System.out.println("No se encontró la provincia a modificar.");
            }
            stmt.close();
            manager.close();
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_3, "Error al modificar la provincia", e);
        }
    }

   

    @Override
    public void eliminarProvincia(String nombreProvincia) throws DBManagerException {
        DBManager manager = new DBManager();
        try {
            manager.conectar();
            String query = "DELETE FROM provincias WHERE descripcion = ?";
            PreparedStatement stmt = manager.getConn().prepareStatement(query);
            stmt.setString(1, nombreProvincia);
            int filasEliminadas = stmt.executeUpdate();
            if (filasEliminadas > 0) {
                System.out.println("Provincia eliminada correctamente.");
            } else {
                System.out.println("No se encontró la provincia a eliminar.");
            }
            stmt.close();
            manager.close();
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_4, "Error al eliminar la provincia", e);
        }
    }



    @Override
    public List<Provincia> obtenerTodasLasProvincias() throws DBManagerException {
        List<Provincia> provincias = new ArrayList<>();
        DBManager manager = new DBManager();
        try {
            manager.conectar();
            String query = "SELECT id, descripcion, id_pais FROM provincias";
            PreparedStatement stmt = manager.getConn().prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                int idPais = rs.getInt("id_pais");
                Provincia provincia = new Provincia(id, descripcion, null); 
                provincias.add(provincia);
            }
            rs.close();
            stmt.close();
            manager.close();
        } catch (SQLException e) {
            throw new DBManagerException(DBManagerException.ERROR_5, "Error al obtener las provincias", e);
        }
        return provincias;
    }
}
