<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<tags:template>
	<jsp:attribute name="body">

	<div class="container">
		<div class="page-header well row">
			<div class="col-md-10 col-xs-13">
			<h1>Bienvenido <small>responsable</small>
				</h1>
			</div>
			<div class="col-md-2 col-xs-5">
				<h1 class="pull-right">
				<a href="${pageContext.request.contextPath}/index"
							class="btn btn-warning">Salir</a>
				</h1>
			</div>
		</div>
		<div class="row">
		<div class="col-md-3 col-xs-6">
		<tags:menuResponsable />
		</div>
		<div class="col-md-9 col-xs-12">
			
        	<c:choose>
        	<c:when test="${contentPage == 'usersList'}">
				<tags:usersList />
        	</c:when>
        	        	<c:when test="${contentPage == 'buzonVirtual'}">
				<tags:buzonVirtual />
        	</c:when>
        	    
        	<c:when test="${contentPage == 'pagosTickets'}">
				<tags:pagosTickets />
        	</c:when>
        	<c:when test="${contentPage == 'registroTickets'}">
				<tags:registroTickets />
        	</c:when>
		</c:choose>
					
		</div>
		</div>
	</div>

	</jsp:attribute>
</tags:template>