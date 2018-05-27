<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta charset="utf-8">
<title>Battleship</title>
<style>
body {
	background-color: black;
}
div#board {
	position: relative;
    width: 1024px;
    height: 863px;
	margin: auto;
	background: url("${pageContext.request.contextPath}/resources/images/board.jpg") no-repeat;
}

div#messageArea {
	position: absolute;
	top: 0px;
	left: 0px;
	color: rgb(83, 175, 19);
}
.hit {
	background: url("${pageContext.request.contextPath}/resources/images/ship.png") no-repeat center center;
}
.miss {
	background: url("${pageContext.request.contextPath}/resources/images/miss.png") no-repeat center center;
}
table {
	border-spacing: 0px; 
	/* could use border-collapse instead */
	/* border-collapse: collapse; */
	position: absolute;
	left: 173px;
	top: 98px;
}
td {
	width: 94px;
	height: 94px;
}
form {
	position: relative;
	bottom: 0px;
	right: 0px;
	padding: 15px;
	background-color: rgb(83, 175, 19);
}
form input {
	background-color: rgb(152, 207, 113);
	border-color: rgb(83, 175, 19);
	font-size: 1em;
}
</style>
</head>
<body>
<form>
    <input type="text" id="guessInput" placeholder="A0">
    <input type="button" id="fireButton" value="Fire!">
</form>
<div id="board">
<div id="messageArea"></div>
<table>
<tr>
<td id="00"></td> <td id="01"></td> <td id="02"></td> <td id="03"></td>
<td id="04"></td> <td id="05"></td> <td id="06"></td>
</tr>
<tr>
<td id="10"></td> <td id="11"></td> <td id="12"></td> <td id="13"></td>
<td id="14"></td> <td id="15"></td> <td id="16"></td>
</tr>
<tr>
<td id="20"></td> <td id="21"></td> <td id="22"></td> <td id="23"></td>
<td id="24"></td> <td id="25"></td> <td id="26"></td>
</tr>
<tr>
<td id="30"></td> <td id="31"></td> <td id="32"></td> <td id="33"></td>
<td id="34"></td> <td id="35"></td> <td id="36"></td>
</tr>
<tr>
<td id="40"></td> <td id="41"></td> <td id="42"></td> <td id="43"></td>
<td id="44"></td> <td id="45"></td> <td id="46"></td>
</tr>
<tr>
<td id="50"></td> <td id="51"></td> <td id="52"></td> <td id="53"></td>
<td id="54"></td> <td id="55"></td> <td id="56"></td>
</tr>
<tr>
<td id="60"></td> <td id="61"></td> <td id="62"></td> <td id="63"></td>
<td id="64"></td> <td id="65"></td> <td id="66"></td>
</tr>
</table>
</div>
<script src="${pageContext.request.contextPath}/resources/js/battleship.js">
</script>
</body>
</html>
