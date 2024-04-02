<!DOCTYPE html>
<html>
<head>
    <title>Iniciar Sesi�n</title>
</head>
<body>
    <h1>Iniciar Sesi�n</h1>
    
    <% 
        String logoutMessage = (String) request.getAttribute("logoutMessage");
        if (logoutMessage != null) {
    %>
            <p style="color: green;"><%= logoutMessage %></p>
    <% } %>
    
    <form action="LoginServlet" method="post">
        Correo: <input type="text" name="correo"><br>
        Clave: <input type="password" name="clave"><br>
        <input type="submit" value="Iniciar Sesi�n">
    </form>
    
    <% if ("true".equals(request.getParameter("error"))) { %>
        <p style="color: red;">Credenciales incorrectas. Int�ntalo de nuevo.</p>
    <% } %>
</body>
</html>
