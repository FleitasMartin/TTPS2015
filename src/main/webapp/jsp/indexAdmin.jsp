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
			<h1>Bienvenido <small>admin</small>
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
		<c:if test="${!(contentPage == 'loginAdmin')}">
			<tags:menuAdmin />
		</c:if>		
		</div>
		<div class="col-md-9 col-xs-12">
			
        	<c:choose>
        	<c:when test="${contentPage == 'loginAdmin'}">
				<tags:loginAdmin />
        	</c:when>
        	<c:when test="${contentPage == 'listarAdmins'}">
				<tags:listarAdmins />
        	</c:when>
        	<c:when test="${contentPage == 'listarResponsables'}">
				<tags:listarResponsables />
        	</c:when>
        	<c:when test="${contentPage == 'buzonVirtual'}">
				<tags:buzonVirtual />
        	</c:when>
        	<c:when test="${contentPage == 'administracionComponentes'}">
				<tags:administracionComponentes />
        	</c:when>
        	<c:when test="${contentPage == 'altaComponente'}">
				<tags:altaComponente />
        	</c:when>
        	<c:when test="${contentPage == 'administracionMenues'}">
				<tags:administracionMenues />
        	</c:when>
        	<c:when test="${contentPage == 'altaMenu'}">
				<tags:altaMenu />
        	</c:when>
        	<c:when test="${contentPage == 'estadisticasMenues'}">
				<tags:estadisticasMenues />
        	</c:when>
        	<c:when test="${contentPage == 'cartillaSemanal'}">
				<tags:cartillaSemanal />
        	</c:when>
        	<c:when test="${contentPage == 'adminSedes'}">
				<tags:adminSedes />
        	</c:when>
        	<c:when test="${contentPage == 'altaCartilla'}">
				<tags:altaCartilla />
        	</c:when>
        	<c:when test="${contentPage == 'altaSede'}">
				<tags:altaSede />
        	</c:when>
        	<c:when test="${contentPage == 'altaAdmin'}">
				<tags:altaAdmin />
        	</c:when>
        	<c:when test="${contentPage == 'altaResponsable'}">
				<tags:altaResponsable />
        	</c:when>
		</c:choose>
					
		</div>
		</div>
	</div>

	</jsp:attribute>
</tags:template>