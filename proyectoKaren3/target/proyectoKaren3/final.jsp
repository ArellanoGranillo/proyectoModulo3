<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Final</title>
</head>
<style>
    body {
        background-color: #cbafb5;
        text-align: center;
        font-family: Arial, sans-serif;
    }
    h1 {
        font-size: 32px;
        color: #0b7041;
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
    .pregunta {
        font-size: 24px;
        color: #c25e05;
        font-weight: bold;
    }
</style>
<body>
<h1>¡Lo lograste!</h1>
<img class="imagen-ajustada" src="https://i.pinimg.com/736x/77/6c/24/776c24cacdec323843722bc53acdc2b7.jpg" alt="Imagen">


<p class="texto-principal">
    Llegaste al muelle y pudiste escapar <br>
    ¡Felicidades! <br>
    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/88/d6/42/88d6429c774ab4cf946ac91d11483483.jpg" alt="Imagen">

<p class="pregunta">
    ¿Quieres volverlo a intentar?
    <br>
    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/9d/e2/77/9de277c459a5dabce87c8bb5dedd73c6.jpg" alt="Imagen">
<form method="POST" action="${pageContext.request.contextPath}/final">
    <label for="aceptar"> Regresar al inicio </label>
    <input id="aceptar" type="radio" value="true" name="desafio">

    <br>
    <label for="cancelar"> Rechazar el desafio </label>
    <input id="cancelar" type= "radio" value= "false" name= "desafio"/>
    <br/>
    <input type="submit" name="desafio" value="Enviar">
</form>

</body>