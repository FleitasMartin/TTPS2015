<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//ES" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<tags:template>
	<jsp:attribute name="body">
<script type="text/javascript">
	//	$('#body').css('background-image', 'url(./img/fondo2.jpg)');
</script>

<!-- Language : <a href="?language=en">English</a>|<a href="?language=es_AR">Espa&ntilde;ol</a> -->

<!-- <h2> -->
<%-- welcome.springmvc : <spring:message code="bienvenida.springmvc" /> --%>
<!-- </h2> -->
Current Locale : ${pageContext.response.locale}
<div class="container">
	<div class="col-md-5 page-header well text-center">
	 	<h2>Comedor Universitario UNLP 
	 		<small> Bienvenido!</small>
		</h2>
		
		
	</div>
	<div class="row">
	<br>
		
				<div class="col-md-8">
			<form action="${pageContext.request.contextPath}/login" method="POST"
						class="form-horizontal">
				<div class="form-group">
					<h4>
						<label class="col-md-offset-1 col-md-2 control-label">
							<span class="label label-default"><spring:message code="login.dni" text="" /> </span>
						</label> 
					</h4>
					<div class="col-md-3">
						<input type="text" name="dni" class="form-control">	
					
							</div>
				</div>
				<div class="form-group"> 
					<h4>
						<label class="col-md-offset-1 col-md-2 control-label">
							<span class="label label-default"> <spring:message code="login.password" text="" /> </span>
						</label>
					</h4>
					<div class="col-md-3">
						<input type="password" name="contrasena" class="form-control">						
					
							</div>
				</div>  
				<div class="form-group">
		    		<div class="col-md-offset-3 col-md-2">
		    			<!-- spring:message code='login.boton'  -->
<!-- 						<input type="submit" value="Entrar" class="col-md-offset-4 col-md-12 form-control btn btn-primary "> -->
						<button type="submit"
									class="col-md-offset-4 col-md-12 form-control btn btn-primary ">
						<strong>Entrar</strong> <span class="glyphicon glyphicon-log-in"></span> </button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div>
		<c:if test="${not empty error}">
		<div class="row">
			<div class="col-md-5">
				<div class="alert alert-danger">
					<h3 class="text-center">
						<strong>¡Encontramos un problema!</strong>
					</h3>
					<h4 class="text-center">
						<c:out value="${error}"></c:out>
					</h4>
				</div>
			</div>
		</div>
		</c:if>
	</div>
	<div>
		<c:if test="${not empty mensaje}">
		<div class="row">
			<div class="col-md-5">
				<div class="alert alert-success">
					<h3 class="text-center">
						<strong><c:out value="${mensaje}"></c:out></strong>
					</h3>
				</div>
			</div>
		</div>
		</c:if>
	</div>
</div>

	</jsp:attribute>
</tags:template>