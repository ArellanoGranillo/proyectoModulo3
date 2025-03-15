<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Juego del sueño</title>
</head>
<style>
    body {
        background-color: #dc9aa8;
        text-align: center;
        font-family: Arial, sans-serif;
    }
    h1 {
        font-size: 32px;
        color: #fd2e7b;
    }
    .texto-principal {
        font-size: 24px;
        color: #278d62;
    }
    .pregunta {
        font-size: 24px;
        color: #e36d00;
        font-weight: bold;
    }
    .imagen-ajustada {
        width: 200px;
        height: auto;
        border-radius: 10px;
    }
</style>
<body>
<h1>¡Bienvenido al juego!</h1>

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/db/44/93/db44930d3b8f7d6868603a823436d45d.jpg" alt="Imagen"> <br>

<p class="texto-principal">
    Esto es un sueño. <br>
    Pero no es como todos los demás. <br>
    Hoy tendrás que pasar un juego. <br>
    Solo si lo pasas con éxito podrás despertar.<br>
</p>

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/eb/30/9e/eb309e4202307dd4e3bc737e0ad98c3c.jpg" alt="Imagen"> <br>

<p class="pregunta">¿Qué opinas? ¿Te animas a jugar?</p>
<br>
<form method="POST" action="${pageContext.request.contextPath}/elegir">
    <label for="aceptar">Aceptar el desafío</label>
    <input id="aceptar" type="radio" value="true" name="desafio">

    <br>

    <label for="cancelar">Rechazar el desafío</label>
    <input id="cancelar" type="radio" value="false" name="desafio">

    <br/>
    <input type="submit" value="Enviar">
</form>
</body>
</html>