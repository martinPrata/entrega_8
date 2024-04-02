package ej2;

import java.util.List;


public interface ProvinciaDAO {
    void insertarProvincia(String nombreProvincia) throws DBManagerException;
    void modificarProvincia(String nombreActual, String nuevoNombre) throws DBManagerException;
    void eliminarProvincia(String nombreProvincia) throws DBManagerException;
    List<Provincia> obtenerTodasLasProvincias() throws DBManagerException;

}
