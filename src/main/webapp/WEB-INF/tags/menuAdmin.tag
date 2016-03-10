<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a href="${pageContext.request.contextPath}/sede/listar">Gestion
			de sedes</a></li>
	<li><a href="${pageContext.request.contextPath}/componente/listar">Administraci&oacute;n
			de Componentes</a></li>
	<li><a href="${pageContext.request.contextPath}/menu/listar">Administraci&oacute;n
			de Men&uacute;es</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/buzonVirtual">Buzon
			virtual</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/estadisticasMenues">Estad&iacute;sticas</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/listar">Gestion
			de administradores</a></li>
	<li><a
		href="${pageContext.request.contextPath}/responsable/listar">Gestion
			de responsables</a></li>
	<li><a href="${pageContext.request.contextPath}/cartilla/listar">Cartilla
			Semanal</a></li>
</ul>
<script>
	$(function() {
		$('ul a[href^="' + location.pathname + '"]').parent()
				.addClass('active');
	});
</script>