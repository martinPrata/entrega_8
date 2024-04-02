<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
    <title>Empleados Administrativos</title>
</head>
<body>
    <h1>Lista de Empleados Administrativos</h1>
    
    <ul>
        <% 
            Map<String, String> empleados = (Map<String, String>) request.getAttribute("empleados");
            if (empleados != null) {
                Set<Map.Entry<String, String>> entrySet = empleados.entrySet();
                for (Map.Entry<String, String> entry : entrySet) { 
        %>
                    <li><%= entry.getKey() %> - <%= entry.getValue() %></li>
        <% 
                } 
            } 
        %>
    </ul>
    
    <br>
    <a href="logout">Cerrar Sesión</a>
    <br>
    <p>ID de la Sesión: <%= session.getId() %></p>
</body>
</html>
