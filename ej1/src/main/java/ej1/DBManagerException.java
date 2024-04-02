package ej1;

public class DBManagerException extends Exception {

    private static final long serialVersionUID = 1L;
    public static final int ERROR_1 = 1;
    public static final int ERROR_2 = 2;
    public static final int ERROR_3 = 3;
    public static final int ERROR_4 = 4;
    public static final int ERROR_5 = 5;
    public static final int ERROR_6 = 6;
    public static final int ERROR_7 = 7;

    private Integer error;

    public DBManagerException(Integer error, String message) {
        super(message);
        this.error = error;
    }

    public DBManagerException(Integer error, Throwable cause) {
        super(cause);
        this.error = error;
    }

    public DBManagerException(Integer error, String message, Throwable cause) {
        super(message, cause);
        this.error = error;
    }
    
    public Integer getErrorCode() {
        return error;
    }

    @Override
    public String getMessage() {
        switch (error) {
            case ERROR_1:
                return "Se produjo un error conectando a la base de datos. Error: " + super.getMessage();
            case ERROR_2:
                return "Se produjo un error mostrando provincias. Error: " + super.getMessage();
            case ERROR_3:
                return "Se produjo un error cerrando la conexión con la base de datos. Error: " + super.getMessage();
            case ERROR_4:
                return "Se produjo un error al agregar provincia. Error: " + super.getMessage();
            case ERROR_5:
                return "Se produjo un error al modificar provincia. Error: " + super.getMessage();
            case ERROR_6:
                return "Se produjo un error al eliminar provincia. Error: " + super.getMessage();
            case ERROR_7:
                return "Se produjo un error al obtener las provincias. Error: " + super.getMessage();
            default:
                return super.getMessage();
        }
    }
}
