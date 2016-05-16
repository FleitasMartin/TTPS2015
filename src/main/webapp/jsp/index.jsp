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
	
<div class="container">

<div class="col-md-6 page-header well text-center">
  <h1>Comedor Universitario UNLP <small> Bienvenido!</small>
				</h1>
</div>
<div class="row">
<br>

				
				
				<div class="col-md-8">
	<form action="${pageContext.request.contextPath}/login" method="POST"
						class="form-horizontal">
		<div class="form-group">
		<label class="col-sm-offset-1 col-sm-2 control-label">DNI</label> 
		<div class="col-sm-3">
								<input type="text" name="dni" class="form-control">
								
							
							
							</div>
		</div>
		<div class="form-group"> <label
								class="col-sm-offset-1 col-sm-2 control-label">Password</label>
		<div class="col-sm-3">
								<input type="password" name="contrasena" class="form-control">
							
							
							
							</div>
		</div>  
		<div class="form-group">
    		<div class="col-sm-offset-3 col-sm-3">
    		<!-- spring:message code='login.boton'  -->
		<input type="submit" value="Login"
									class="form-control btn btn-primary ">
							
							
							
							</div>
							</div>
	</form>
</div>
</div>
<div>
<c:if test="${not empty error}">
<div class="row">
<div class="col-md-6">
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
<!-- <div class="col-sm-offset-3 col-sm-6"> -->
<div class="col-md-6">
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