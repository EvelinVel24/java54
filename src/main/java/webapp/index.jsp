<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Consulta de Departamentos</title>
</head>
<body>
    <h2>Consulta de Departamentos</h2>

    <form action="departamento" method="get">
        <label for="filtro">Filtro:</label>
        <input type="text" id="filtro" name="filtro" />
        <button type="submit">Buscar</button>
    </form>

    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
        </tr>
        <c:forEach var="depto" items="${departamentos}">
            <tr>
                <td>${depto.id}</td>
                <td>${depto.nombre}</td>
                <td>${depto.descripcion}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
