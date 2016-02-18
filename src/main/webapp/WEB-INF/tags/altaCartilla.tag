<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<div>
	<form method="POST" action="${pageContext.request.contextPath}/admin/altaCartilla">
		<table class="table">
			<thead>
				<tr>
					<td>Menus</td>
					<td>Lunes</td>
					<td>Martes</td>
					<td>Mi&eacute;rcoles</td>
					<td>Jueves</td>
					<td>Viernes</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="menu" items="${menues}">
				<input type="hidden" value="${menu.id }" name="id">
				<tr>					
					<td><c:out value="${menu.nombre }" /></td>
					<td><input type="checkbox" name="lunes" value="${menu.id }"></td>
					<td><input type="checkbox" name="martes" value="${menu.id }">
					</td>
					<td><input type="checkbox" name="miercoles" value="${menu.id }">
					</td>
					<td><input type="checkbox" name="jueves" value="${menu.id }">
					</td>
					<td><input type="checkbox" name="viernes" value="${menu.id }">
					</td>
				</tr>				
			</c:forEach>

			</tbody>
		</table>
		<input type="submit" value="Alta Cartilla"
			class="form-control btn btn-primary">
		
	</form>
</div>