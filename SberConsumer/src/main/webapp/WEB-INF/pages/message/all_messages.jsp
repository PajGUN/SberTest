<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%--<html xmlns:th="http://www.thymeleaf.org" lang="en">--%>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Messages</title>
</head>

<body>
<h2>Messages</h2>

<table border="1" cellpadding="5">
    <tr>
        <th>Id</th>
        <th>Message</th>
        <th>Date</th>
    </tr>
    <c:forEach items="${messages}" var="message">
        <tr>
            <td><c:out value="${message.id}" /></td>
            <td><c:out value="${message.text}" /></td>
            <td><c:out value="${message.date}" /></td>
        </tr>
    </c:forEach>
</table>



</body>

</html>