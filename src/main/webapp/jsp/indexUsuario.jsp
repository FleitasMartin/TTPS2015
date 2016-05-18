<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES" "http://www.w3.org/TR/html4/loose.dtd">
<tags:template>
	<jsp:attribute name="body">

	<div class="container ">
		<div class="page-header row col-md-12" style="border: none">
			<div class="col-md-3 well text-center">
			<h1>Bienvenid&#64; <small><c:out value="${nombreUsuario}"></c:out></small>
				</h1>
			</div>
			<div class="col-md-7" id="divTituloDePagina" style="margin-top: 8%">
				<h1 class="text-center">
						<span style="display: none" id="tituloDePagina"
							class="label label-info"></span>
					</h1> 
			</div>
			<div class="col-md-1">
				<h1 class="pull-right">
				<a href="${pageContext.request.contextPath}/salir"
							class="btn btn-warning"> <strong>Salir</strong> <span
							class="glyphicon glyphicon-log-out"></span>
						</a>
				</h1>
			</div>
		</div>
		<div class="row">
		<div class="col-md-2">
			<tags:menuUser />
		</div>
		<div class="col-md-10 ">
        	<c:choose>
        	<c:when test="${contentPage == 'listarCompras'}">
				<tags:listarCompras />
        	</c:when>
         	<c:when test="${contentPage == 'editarPreferencias'}">
				<tags:editarPreferencias />
        	</c:when> 
        	<c:when test="${contentPage == 'userPerfil'}">
				<tags:userPerfil />
        	</c:when>
        	<c:when test="${contentPage == 'compraDeTickets'}">
				<tags:compraDeTickets />
        	</c:when>
        	<c:when test="${contentPage == 'comentar'}">
				<tags:comentar />
        	</c:when>  
        	<c:when test="${contentPage == 'saldo'}">
				<tags:saldo />
        	</c:when>
        	<c:when test="${contentPage == 'listarSedes'}">
				<tags:listarSedes />
        	</c:when>    
		</c:choose>
		</div>
		</div>
	</div>

	</jsp:attribute>
</tags:template>