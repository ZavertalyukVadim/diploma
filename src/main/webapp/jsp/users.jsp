<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/src/main/resources/static/css/style.css"/>">
    <title>User</title>
</head>
<body>
<div class="allTasks">
    <c:forEach items="${users}" var="user">
        <h2>${user.firstName}</h2>
    </c:forEach>
</div>
</body>
</html>
