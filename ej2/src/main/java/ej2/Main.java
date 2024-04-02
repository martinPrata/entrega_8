package ej2;

public class Main {

    public static void main(String[] args) {
        ProvinciaDAO provinciaDAO = new ProvinciaDAOImplementacion();

        try {
            provinciaDAO.insertarProvincia("Provincia Ficticia2");

            provinciaDAO.modificarProvincia("Provincia Ficticia2", "Nombre Modificado");

            provinciaDAO.eliminarProvincia("Provincia Ficticia1");
 
            System.out.println("Todas las provincias:");
            for (Provincia p : provinciaDAO.obtenerTodasLasProvincias()) {
                System.out.println("ID: " + p.getId() + ", Descripción: " + p.getDescripcion());
            }
        } catch (DBManagerException e) {
            System.err.println("Error en la operación de la base de datos: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
