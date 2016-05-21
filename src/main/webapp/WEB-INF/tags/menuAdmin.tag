<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked navbar navbar-default text-center"
	style="color: red;">
	<li><a id="sede"
		href="${pageContext.request.contextPath}/sede/listarAdmin"><strong>Sedes</strong></a></li>
	<li><a id="componente"
		href="${pageContext.request.contextPath}/componente/listar"><strong>Componentes</strong></a></li>
	<li><a id="menu"
		href="${pageContext.request.contextPath}/menu/listar"><strong>Men&uacute;es</strong></a></li>
	<li><a id="cartilla"
		href="${pageContext.request.contextPath}/cartilla/listar"><strong>Cartilla
				Semanal</strong></a></li>
	<li><a id="admin"
		href="${pageContext.request.contextPath}/admin/listar"><strong>Administradores</strong></a></li>
	<li><a id="responsable"
		href="${pageContext.request.contextPath}/responsable/listar"><strong>Responsables</strong></a></li>
	<li><a id="sugerencia"
		href="${pageContext.request.contextPath}/sugerencia/buzonVirtual"><strong>Buzon
				Virtual</strong></a></li>
	<!-- <li><a
		href="${pageContext.request.contextPath}/admin/estadisticasMenues">Estad&iacute;sticas</a></li> -->
</ul>
<script type="text/javascript">
	$('#body').css('background-image',
			'url(${pageContext.request.contextPath}/img/verduras01.jpg)');

	var splitPath = location.pathname.split('/');

	$(function() {
		$('#' + splitPath[2]).parent().addClass('active');
	});
</script>