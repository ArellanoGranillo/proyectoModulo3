<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Primer nivel</title>
</head>
<style>
    body {
        background-color: #e1758e;
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
        color: #075d9a;
        font-weight: bold;
    }
</style>
<body>
<h1>Segundo nivel</h1>
<img class="imagen-ajustada" src="https://i.pinimg.com/736x/61/0a/5a/610a5aad66b036fc689dfdc870bef73d.jpg" alt="Imagen">

<p class="texto-principal">
    Lograste avanzar por los ductos de ventilación hasta <br>
    encontrar una salida. Frente a ti ves dos caminos y ambos <br>
    tienes un señalamiento que indica que el muelle del ala oeste es por ahí.<br>
    Sin embargo, uno de los caminos está despejado y podrías estar más expuesto a ataques de dinosaurios; <br>
   mientras que el otro es por la selva y podrías hacer más ruido y llamar más la atención.<br>

    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/2b/f6/dc/2bf6dcc3f84abfa35ee52433b735686f.jpg" alt="Imagen">

    <img class="imagen-ajustada" src="https://i.pinimg.com/736x/e3/2f/89/e32f8904e13a6101fe6087aeaf6fc308.jpg" alt="Imagen">
</p>

<p class="pregunta">¿Qué opción eliges?</p>


<p>
<form method="POST" action="${pageContext.request.contextPath}/segundaEleccion">
    <label>Selecciona una opción:</label>
    <select name="opcion">
        <option value="despejado">Camino despejado</option>
        <option value="selva">Camino que cruza la selva</option>
    </select>
    <input type="submit" value="Elegir">
</form>

</body>
