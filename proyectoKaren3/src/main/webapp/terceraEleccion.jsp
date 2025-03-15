<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tercer nivel</title>
</head>
<style>
    body {
        background-color: #e7c9b5;
        text-align: center;
        font-family: Arial, sans-serif;
    }
    h1 {
        font-size: 32px;
        color: #a12e73;
    }
    .texto-principal {
        font-size: 24px;
        color: #0d4ba8;
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
<h1>Tercer nivel</h1>
<img class="imagen-ajustada" src="https://i.pinimg.com/736x/77/c7/89/77c789bf224bf4eaaf278412d795e708.jpg" alt="Imagen">
<p class="texto-principal">
    Pudiste ir cubriendote con el follaje de la selva y llegaste al final del camino.<br>
    Logras ver el muelle a lo lejos y solo hay dos caminos para llegar. <br>
    Por el lado derecho ves que se acerca una manada de Gigantospinosaurus
    y por el lado izquierdo una manada de Dimorphodones.  <br>
    Una de las especies es carnivora y la otra es herbivora. <br>

    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/6e/9f/4f/6e9f4f9517c939a926ada934db1ab9de.jpg" alt="Imagen">

    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/56/de/3e/56de3e7b26567f16d80e9bdb067a0f47.jpg" alt="Imagen">
</p>

<p class="pregunta">¿Qué opción eliges?</p>


<p>
<form method="POST" action="${pageContext.request.contextPath}/terceraEleccion">
    <label>Selecciona una opción:</label>
    <select name="opcion">
        <option value="derecha">Hacia la manada de Gigantspinosaurus</option>
        <option value="izquierda">Hacia la manada de Dimorphodones</option>
    </select>
    <input type="submit" value="Elegir">
</form>

</body>
