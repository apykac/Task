<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Page</title>
</head>
<body>
<h2>Список организаций</h2>
<table>
    <tr>
        <th>ID</th>
        <th>ИНН</th>
        <th>ОГРН</th>
        <th>Нименование</th>
        <th>Адрес</th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <th>${item.id}</th>
            <th>${item.inn}</th>
            <th>${item.ogrn}</th>
            <th>${item.name}</th>
            <th>${item.address}</th>
        </tr>
    </c:forEach>
</table>
<br/>
<br/>

<a href="${pageContext.request.contextPath}/main_page">на главную</a>
<a href="${pageContext.request.contextPath}/method/get_organization${backPage}">назад</a>
</body>
</html>
