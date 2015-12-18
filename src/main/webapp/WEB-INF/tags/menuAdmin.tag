<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a href="${pageContext.request.contextPath}/admin/listarSedes">Gestion
			de sedes</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/administracionComponentes">Administraci&oacute;n
			de Componentes</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/administracionMenues">Administraci&oacute;n
			de Men&uacute;es</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/buzonVirtual">Buzon
			virtual</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/estadisticasMenues">Estad&iacute;sticas</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/listarAdmins">Gestion
			de administradores</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/listarResponsables">Gestion
			de responsables</a></li>
	<li><a
		href="${pageContext.request.contextPath}/admin/cartillaSemanal">Cartilla
			Semanal</a></li>
</ul>
<script>
	$(function() {
		//$('ul a[href^="/' + location.pathname.split("/")[1] + '"]').parent()
		$('ul a[href^="' + location.pathname + '"]').parent()
				.addClass('active');
	});
</script>