<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesión</title>
</head>
<body>
    <h1>Iniciar Sesión</h1>
    
    <% 
        String logoutMessage = (String) request.getAttribute("logoutMessage");
        if (logoutMessage != null) {
    %>
            <p style="color: green;"><%= logoutMessage %></p>
    <% } %>
    
    <form action="LoginServlet" method="post">
        Correo: <input type="text" name="correo"><br>
        Clave: <input type="password" name="clave"><br>
        <input type="submit" value="Iniciar Sesión">
    </form>
    
    <% if ("true".equals(request.getParameter("error"))) { %>
        <p style="color: red;">Credenciales incorrectas. Inténtalo de nuevo.</p>
    <% } %>
</body>
</html>
