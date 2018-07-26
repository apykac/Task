<%--
  Created by IntelliJ IDEA.
  User: APYKAC
  Date: 27.07.2018
  Time: 2:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Действия:</h2>
<ul>
    <li><a href="${pageContext.request.contextPath}/method/add_organization">Добавление организации</a></li>
    <li><a href="${pageContext.request.contextPath}/method/get_organization/by_id">Поиск организации по ID</a></li>
    <li><a href="${pageContext.request.contextPath}/method/get_organization/by_inn">Поиск организации по ИНН</a></li>
    <li><a href="${pageContext.request.contextPath}/method/get_organization/by_ogrn">Поиск организации по ОГРН</a></li>
    <li><a href="${pageContext.request.contextPath}/method/get_organization/by_name">Поиск организации по Наименованию</a></li>
    <li><a href="${pageContext.request.contextPath}/method/get_organization/by_address">Поиск организации по Адресу</a></li>
</ul>
</body>
</html>
