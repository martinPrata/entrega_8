package com.educacionit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {

    private static final Map<String, String> credenciales = new HashMap<>();
    static {
        credenciales.put("correo", "clave");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");

        if (validarCredenciales(correo, clave)) {
            HttpSession session = request.getSession();
            session.setAttribute("correo", correo);
            request.setAttribute("empleados", cargarEmpleados());
            request.getRequestDispatcher("/empleados.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp?error=true");
        }
    }

    private boolean validarCredenciales(String correo, String clave) {
        String claveAlmacenada = credenciales.get(correo);
        return claveAlmacenada != null && claveAlmacenada.equals(clave);
    }

    private Map<String, String> cargarEmpleados() {
        Map<String, String> empleados = new HashMap<>();
        empleados.put("Nombre1", "Cargo1");
        empleados.put("Nombre2", "Cargo2");
        return empleados;
    }
}
