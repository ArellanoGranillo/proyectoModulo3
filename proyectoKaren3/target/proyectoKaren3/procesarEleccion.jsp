<%@ page import="java.util.Map" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Primer nivel</title>
</head>
<style>
    body {
        background-color: #e7c9b5;
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
    .segundo-Par {
        font-size: 24px;
        color: #178aaf;
        font-weight: bold;
    }
    .tercer-Par {
        font-size: 24px;
        color: #d9277f;
        font-weight:bold;
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
<h1>Primer nivel</h1>
<%
    String playerName = (String) session.getAttribute("playerName");
    if (playerName == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<h1>Bienvenido, <%= playerName %>!</h1>
<%
    String nombre = (String) session.getAttribute("playerName");
    Map<String, int[]> stats = (Map<String, int[]>) application.getAttribute("estadisticas");

    int derrotas = 0;
    int victorias = 0;

    if (playerName != null && stats != null && stats.containsKey(playerName)) {
        derrotas = stats.get(playerName)[0];
        victorias = stats.get(playerName)[1];
    }
%>

<p>Jugador: <%= playerName %></p>
<p>Has perdido <%= derrotas %> veces.</p>
<p>Has ganado <%= victorias %> veces.</p>

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/c5/92/9e/c5929e66978986de1f69c3b06c2e35ab.jpg" alt="Imagen">
<p class="texto-principal">
    Abres los ojos y estás en una habitación de hotel. <br>
    Te asomas por la ventana y te das cuenta de que es <br>
    una especie de parque de diversiones.<br>
    A lo lejos logras ver un letrero que dice: <br>
    "Diversión Cretácica"<br>
    Suena como un parque de dinosaurios... pero los dinosaurios ya no existen, ¿o sí? <br>
    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/c7/ee/55/c7ee55d026644259085e3a37088fce7c.jpg" alt="Imagen">

</p>

<p class="segundo-Par">De pronto suena una señal de alerta. <br>
    Escuchas que por los altavoces alguien dice: "Tenemos una emergencia en la isla.<br>
    Se solicita a todos los visitantes que se dirijan al muelle del ala oeste.<br>
    Ahí encontrarán barcos de evacuación. Favor de salir de inmediato y mantener la calma."<br>


</p>
<p class="tercer-Par"> Te asomas por la puerta y ves demasiada gente en los pasillos. <br>
    Te asomas por la ventana y te das cuenta de que justo hacia la entrada del hotel, que <br>
    es hacia donde se dirigen todos, vienen un par de Troodones. No estás seguro de que salir <br>
    con el grupo sea la mejor idea. Cerca del techo ves los ductos de evacuación. Quizás podrías salir<br>
    por ahí, pero no tienes ni idea de a dónde te llevarán y podrías perderte o encontrar algo peor. <br>


<p class="pregunta">¿Qué opción eliges?</p>


<img class="imagen-ajustada" src="https://i.pinimg.com/736x/f9/c0/a4/f9c0a4b7e225d9b778e754b1f0d600a2.jpg" alt="Imagen">

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/20/fc/41/20fc41c17abf54546b651a72b950b1e6.jpg" alt="Imagen">

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/53/1d/7d/531d7d072096d922c90277f1ae4ce7f1.jpg" alt="Imagen">


<p>
<form method="POST" action="${pageContext.request.contextPath}/procesarEleccion">
    <label>Selecciona una opción:</label>
    <select name="opcion">
        <option value="puerta">Salir por la puerta</option>
        <option value="ducto">Tomar el ducto de ventilación</option>
    </select>
    <input type="submit" value="Elegir">
</form>


</body>
