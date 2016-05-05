<%@ tag%>
<%@ attribute name="id" fragment="true"%>
<ul class="nav nav-pills nav-stacked">
	<li><a
		href="${pageContext.request.contextPath}/sede/usuariosHabilitados">Usuarios
			habilitados</a></li>
	<li><a
		href="${pageContext.request.contextPath}/pago/listadoSemanal">Compras
			semanales</a></li>
	<li><a
		href="${pageContext.request.contextPath}/responsable/registroTickets">Registro
			tickets</a></li>
	<li><a
		href="${pageContext.request.contextPath}/sugerencia/buzonVirtualDeSede">Buzon
			virtual</a></li>
</ul>
<script>
	$(function() {
		//$('ul a[href^="/' + location.pathname.split("/")[1] + '"]').parent()
		$('ul a[href^="' + location.pathname + '"]').parent()
				.addClass('active');
	});
</script>