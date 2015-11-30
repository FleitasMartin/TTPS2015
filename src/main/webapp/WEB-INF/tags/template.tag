<%@ tag%>
<%@ attribute name="body" fragment="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html>
<head>
<style>
#map {
	width: 600px;
	height: 500px;
}
</style>
<tags:headTemplate />
</head>
<body>
	<jsp:invoke fragment="body" />
</body>
</html>