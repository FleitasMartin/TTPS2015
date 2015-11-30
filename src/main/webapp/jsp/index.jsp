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
  <div class="col-sm-6 col-md-4">
  	<div class="panel panel-default">
  		<div class="panel-heading">
    		<h3 class="panel-title">
								<h3>Administrador General</h3>
							</h3>
  		</div>
  		<div class="panel-body">
    		
    		<p>
    	<a href="${pageContext.request.contextPath}/admin/home"
									class="btn btn-primary" role="button">Ingresar</a>
		</p>
  		</div>
	</div>
  </div>
  <div class="col-sm-6 col-md-4">
  	<div class="panel panel-default">
  		<div class="panel-heading">
    		<h3 class="panel-title">
								<h3>Responsable de Sede</h3>
							</h3>
  		</div>
  		<div class="panel-body">
    		
    		<p>
								<a href="${pageContext.request.contextPath}/responsable/home"
									class="btn btn-primary" role="button">Ingresar</a>
							</p>
  		</div>
	</div>
  </div>
  <div class="col-sm-6 col-md-4">
  	<div class="panel panel-default">
  		<div class="panel-heading">
    		<h3 class="panel-title">
								<h3>Usuario</h3>
							</h3>
  		</div>
  		<div class="panel-body">
    		
    		<p>
								<a href="${pageContext.request.contextPath}/user/login"
									class="btn btn-primary" role="button">Ingresar</a>
							</p>
  		</div>
	</div>
  </div>
</div>
</div>
</jsp:attribute>
</tags:template>