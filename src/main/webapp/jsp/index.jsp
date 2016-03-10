<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tags:template>
	<jsp:attribute name="body">
<div class="container">
<div class="page-header well">
  <h1>Comedor Universitario UNLP <small> Bienvenido!</small>
				</h1>
</div>
<div class="row">
<br>
<div class="col-sm-offset-3 col-sm-8">
	<form action="${pageContext.request.contextPath}/login"
						method="POST" class="form-horizontal">
		<div class="form-group">
		<label class="col-sm-offset-1 col-sm-2 control-label">DNI</label> 
		<div class="col-sm-3">
								<input type="text" name="dni" class="form-control">
								</div>
		</div>
		<div class="form-group"> <label class="col-sm-offset-1 col-sm-2 control-label">Password</label>
		<div class="col-sm-3">
								<input type="password" name="contrasena" class="form-control">
							</div>
		</div>  
		<div class="form-group">
    		<div class="col-sm-offset-3 col-sm-3">
		<input type="submit" value="Ingresar"
									class="form-control btn btn-primary ">
							</div>
							</div>
	</form>
</div>
</div>
<c:if test="${not empty error}">
<div class="row">
<div class="col-sm-offset-3 col-sm-6">
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
</jsp:attribute>
</tags:template>