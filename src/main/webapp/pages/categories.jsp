<%@ page import="java.util.List" %>
<%@ page import="categoria.dominio.Categoria" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Formulario de Categoría</title>
</head>
<body>

    <h2>Formulario de Categoría</h2>

    <form action="${pageContext.request.contextPath}/SvAddCategory" method="post">
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required>
        <br>
        <label for="descripcion">Descripción:</label>
        <textarea id="descripcion" name="descripcion" required></textarea>
        <br>
        <button type="submit">Agregar Categoría</button>
    </form>
    
    
     <h2>Listado de Categorías</h2>

    <%
    List<Categoria> categorias = (List<Categoria>) request.getAttribute("categorias");

    if (categorias != null && !categorias.isEmpty()) {
        for (Categoria categoria : categorias) {
%>
            <div>
                <p>Nombre: <%= categoria.getNombre() %></p>
                <p>Descripción: <%= categoria.getDescripcion() %></p>
                <hr>
            </div>
<%
        }
    } else {
%>
        <p>No hay categorías disponibles.</p>
<%
    }
%>
    
    

</body>
</html>
