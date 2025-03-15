<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Perdiste</title>
</head>
<style>
  body {
    background-color: #c25e05;
    text-align: center;
    font-family: Arial, sans-serif;
  }
  h1 {
    font-size: 32px;
    color: #0b7041;
  }
  .texto-principal {
    font-size: 24px;
    color: #eaeff1;
  }
  .pregunta {
    font-size: 24px;
    color: #a12e73;
    font-weight: bold;
  }
  .imagen-ajustada {
    width: 200px;
    height: auto;
    border-radius: 10px;
  }
</style>
<body>
<h1>¡Perdiste!</h1>

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/be/3b/f4/be3bf48077c371e2e2d338e2097f9b1a.jpg" alt="Imagen"> <br>

<p class="texto-principal">
  Te lo advertí. <br>
  No podrás despertar. <br>
  ¡JAMÁS! <br>
</p>

<img class="imagen-ajustada" src="https://i.pinimg.com/736x/a0/e6/e3/a0e6e3c32c7e810967e818b788ed8ecf.jpg" alt="Imagen"> <br>

<p class="pregunta">¿Qué opinas? ¿Te animas a jugar?</p>
<br>
<form method="POST" action="${pageContext.request.contextPath}/perder">
  <label for="aceptar"> Regresar al inicio </label>
  <input id="aceptar" type="radio" value="true" name="desafio">

  <br>
  <label for="cancelar"> Rechazar el desafio </label>
  <input id="cancelar" type= "radio" value= "false" name= "desafio"/>
  <br/>
  <input type="submit" name="desafio" value="Enviar">
</form>



</body>
</html>