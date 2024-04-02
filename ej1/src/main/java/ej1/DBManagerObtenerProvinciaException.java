package ej1;

public class DBManagerObtenerProvinciaException extends DBManagerException {

    private static final long serialVersionUID = 1L;
    
    public DBManagerObtenerProvinciaException(Integer error, String message, Throwable cause) {
        super(error, message, cause);
    }
    
    public DBManagerObtenerProvinciaException(Integer error, String message) {
        super(error, message);
    }
}