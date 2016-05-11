<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked" style="color: red;">
	<li><a href="${pageContext.request.contextPath}/sede/listarAdmin">Gesti&oacute;n
			de Sedes</a></li>
	<li><a href="${pageContext.request.contextPath}/componente/listar">Gesti&oacute;n
			de Componentes</a></li>
	<li><a href="${pageContext.request.contextPath}/menu/listar">Gesti&oacute;n
			de Men&uacute;es</a></li>
	<li><a href="${pageContext.request.contextPath}/cartilla/listar">Gesti&oacute;n
			de Cartilla Semanal</a></li>
	<li><a href="${pageContext.request.contextPath}/admin/listar">Gesti&oacute;n
			de Administradores</a></li>
	<li><a
		href="${pageContext.request.contextPath}/responsable/listar">Gesti&oacute;n
			de Responsables</a></li>
	<li><a
		href="${pageContext.request.contextPath}/sugerencia/buzonVirtual">Buzon
			Virtual</a></li>
	<!-- <li><a
		href="${pageContext.request.contextPath}/admin/estadisticasMenues">Estad&iacute;sticas</a></li> -->
</ul>
<script>
	$(function() {
		$('ul a[href^="' + location.pathname + '"]').parent()
				.addClass('active');
	});
</script>