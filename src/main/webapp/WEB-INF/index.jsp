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
	<body style="background-color:#eee">
		<div class="container mt-3">
			<div class="top">
				<h1>Ninja Gold Game</h1>
				<p>Make money by completing any of the actions below.</p>
				<div class="d-flex justify-content-between mt-5 ho">
					<h3>Your Gold: <span class="score p-1 shadow-lg"><c:out value="${myGold}"/></span></h3>
					<form action="/reset" method="post">
						<input type="submit" value="Restart Game" class="btn btn-danger shadow"/>
					</form>
				</div>
			</div>
			<div class="actionCards d-flex justify-content-between mt-4 mb-5 text-center">
				<div class="action p-3 col-2 d-flex flex-column justify-content-between shadow-lg">
					<h3 class="mb-2">Farm</h3>
					<p>(earns 10-20 gold)</p>
					<form action="/action/farm" method="post">
						<input type="submit" value="Find Gold!" class="btn btn-primary shadow"/>
					</form>
				</div>
				<div class="action p-3 col-2 d-flex flex-column justify-content-between shadow-lg">
					<h3 class="mb-2">Cave</h3>
					<p>(earns 5-10 gold)</p>
					<form action="/action/cave" method="post">
						<input type="submit" value="Find Gold!" class="btn btn-primary shadow"/>
					</form>
				</div>
				<div class="action p-3 col-2 d-flex flex-column justify-content-between shadow-lg">
					<h3 class="mb-2">House</h3>
					<p>(earns 2-5 gold)</p>
					<form action="/action/house" method="post">
						<input type="submit" value="Find Gold!" class="btn btn-primary shadow"/>
					</form>				
				</div>
				<div class="action p-3 col-2 d-flex flex-column justify-content-between shadow-lg">
					<h3 class="mb-2">Quest</h3>
					<p>(earns/takes 0-50 gold)</p>
					<form action="/action/quest" method="post">
						<input type="submit" value="Find Gold!" class="btn btn-primary shadow"/>
					</form>				
				</div>
				<div class="action p-3 col-2 d-flex flex-column justify-content-between shadow-lg">
					<h3 class="mb-2">Spa</h3>
					<p>(takes 5-20 gold)</p>
					<form action="/action/spa" method="post">
						<input type="submit" value="Go to Spa!" class="btn btn-primary shadow"/>
					</form>				
				</div>
			</div>
			<div class="activites" style="height: 300px">
				<h3 class="mb-3">Activities</h3>
				<div class="messages h-75 overflow-auto shadow-lg" data-spy="scroll">
					<c:forEach var="msg" items="${messages}">
						<c:choose>
							<c:when test="${msg.contains('failed')||msg.contains('spa')}">
								<p style="margin:0; color:red"><c:out value="${msg}"/></p>
							</c:when>
							<c:otherwise>
								<p style="margin:0; color:green"><c:out value="${msg}"/></p>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
</html>