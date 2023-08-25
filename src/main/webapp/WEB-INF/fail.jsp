<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ninja Gold Game</title>
		<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />	
		<link rel="stylesheet" type="text/css" href="/css/style.css">
	</head>
	<body class="fail-container">
		<div class="fail fade-in">
			<h1 class="fail-message">You have failed</h1>
			<a href="/" class="btn btn-warning fail-button">Try Again?</a>
		</div>
	</body>
</html>