<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>">
    <title>User</title>
</head>
<body>
<div class="allTasks">
    <c:forEach items="${rooms}" var="room">
        <h2>${room.number}</h2>
    </c:forEach>
</div>
</body>
</html>
