<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>The World Clock</title>
</head>
<body>
<form action="/calculator" method="post">
  <input required type="number" name="num1">
  <input required type="number" name="num2">
  <button type="submit" name="calculator" value="addition">Addition(+)</button>
  <button type="submit" name="calculator" value="subtraction">Subtraction(-)</button>
  <button type="submit" name="calculator" value="multiplication">Multiplication(*)</button>
  <button type="submit" name="calculator" value="division">Division(/)</button>
</form>
<div>${message}</div>

</body>
</html>