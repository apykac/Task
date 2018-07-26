<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавление организации</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/method/add_organization" method="post">
    <table>
        <tr>
            <td><label for="inn">ИНН</label></td>
            <td><input type="text" name="inn" id="inn"></td>
        </tr>
        <tr>
            <td><label for="ogrn">ОГРН</label></td>
            <td><input type="text" name="ogrn" id="ogrn"></td>
        </tr>
        <tr>
            <td><label for="name">Наименование Организации</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td><label for="address">Адрес</label></td>
            <td><input type="text" name="address" id="address"></td>
        </tr>
    </table>
    <input type="submit" name="add">
</form>
<br/>
<br/>
<c:if test="${isSuccess != null && isSuccess}">Добавление Организации успешно</c:if>
<c:if test="${isSuccess != null && !isSuccess}">
    <h1>Ошибки:</h1>
    <ul>
        <c:forEach items="${errorList}" var="error">
            <li>${error}</li>
        </c:forEach>
    </ul>
</c:if>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/main_page">на главную</a>
</body>
</html>
