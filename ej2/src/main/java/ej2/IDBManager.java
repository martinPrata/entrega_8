package ej2;


public interface IDBManager {


    void conectar() throws DBManagerException;

    void close() throws DBManagerException;
}
