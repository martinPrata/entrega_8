package ej1;

public class Main {

	public static void main(String[] args) {
		DBManager manager = new DBManager();
		try {
			manager.conectar();
			manager.mostrarProvincias("");
			manager.close();
		} catch (DBManagerException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
