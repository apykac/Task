<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get Page</title>
</head>
<body>
<h2>Введите данные</h2>
<c:choose>
    <c:when test="${type.equals('id')}">
        <form action="${pageContext.request.contextPath}/method/get_organization/by_id/list" method="post">
            <table>
                <tr>
                    <td><label for="id">Введите ИД</label></td>
                    <td><input type="text" name="id" id="id"></td>
                </tr>
            </table>
            <input type="submit" name="get">
        </form>
    </c:when>
    <c:when test="${type.equals('inn')}">
        <form action="${pageContext.request.contextPath}/method/get_organization/by_inn/list" method="post">
            <table>
                <tr>
                    <td><label for="inn">Введите ИНН</label></td>
                    <td><input type="text" name="inn" id="inn"></td>
                </tr>
            </table>
            <input type="submit" name="get">
        </form>
    </c:when>
    <c:when test="${type.equals('ogrn')}">
        <form action="${pageContext.request.contextPath}/method/get_organization/by_ogrn/list" method="post">
            <table>
                <tr>
                    <td><label for="ogrn">Введите ОГРН</label></td>
                    <td><input type="text" name="ogrn" id="ogrn"></td>
                </tr>
            </table>
            <input type="submit" name="get">
        </form>
    </c:when>
    <c:when test="${type.equals('name')}">
        <form action="${pageContext.request.contextPath}/method/get_organization/by_name/list" method="post">
            <table>
                <tr>
                    <td><label for="name">Введите Наименование</label></td>
                    <td><input type="text" name="name" id="name"></td>
                </tr>
            </table>
            <input type="submit" name="get">
        </form>
    </c:when>
    <c:when test="${type.equals('address')}">
        <form action="${pageContext.request.contextPath}/method/get_organization/by_address/list" method="post">
            <table>
                <tr>
                    <td><label for="address">Введите Адрес</label></td>
                    <td><input type="text" name="address" id="address"></td>
                </tr>
            </table>
            <input type="submit" name="get">
        </form>
    </c:when>
</c:choose>
<br/>
<br/>
<c:if test="${errorList != null && errorList.size() != 0}">
    ${errorList.get(0)}
</c:if>
<br/>
<br/>
<a href="${pageContext.request.contextPath}/main_page">на главную</a>
</body>
</html>
