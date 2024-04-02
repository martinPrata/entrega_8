package ej1;

public interface IDBManager {


    void conectar() throws DBManagerException;

    void mostrarProvincias() throws DBManagerException;

 
    void close() throws DBManagerException;
}
