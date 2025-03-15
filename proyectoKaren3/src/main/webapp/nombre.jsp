<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Inicio del juego</title>
</head>
<style>
    body {
        background-color: #efd681;
        text-align: center;
        font-family: Arial, sans-serif;
    }
    h1 {
        font-size: 32px;
        color: #c25e05;
    }
    .texto-principal {
        font-size: 24px;
        color: #b42f85;
    }

    .imagen-ajustada {
        width: 180px;
        height: auto;
        border-radius: 10px;
    }

</style>
<body>
<p class="texto-principal">
Excelente decisión.
<p>
    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/39/4f/25/394f25e2a989996ae17528d804264cb9.jpg" alt="Imagen"> <br>


    <form method="POST" action="${pageContext.request.contextPath}/nombre">
    <label for="nombre">Ingresa tu nombre:</label>
    <input id="nombre" name="player" type="text">
    <input type="submit" value="Jugar">
</form>
</body>
