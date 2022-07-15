<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 21.10.2021
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <!-- Required Meta Tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value="/resources/images/logo/favicon.png"/>" type="image/x-icon">

    <link href="https://nightly.datatables.net/css/jquery.dataTables.css" rel="stylesheet" type="text/css"/>

    <!-- Locale -->
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="langs.labels" var="loc"/>

    <fmt:message bundle="${loc}" key="logout.button" var="logout"/>
    <fmt:message bundle="${loc}" key="assortment.button" var="assortment"/>
    <fmt:message bundle="${loc}" key="home.button" var="home"/>
    <fmt:message bundle="${loc}" key="users.button" var="usersButton"/>

    <fmt:message bundle="${loc}" key="label.login" var="loginLabel"/>
    <fmt:message bundle="${loc}" key="label.role" var="roleLabel"/>
    <fmt:message bundle="${loc}" key="label.admin" var="adminLabel"/>
    <fmt:message bundle="${loc}" key="label.director" var="directorLabel"/>
    <fmt:message bundle="${loc}" key="label.accountant" var="accountantLabel"/>
    <fmt:message bundle="${loc}" key="label.tableMessengers" var="messengersLabel"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>

    <fmt:message bundle="${loc}" key="message.emptyUsers" var="emptyUsers"/>
    <c:if test="${requestScope.message ne null}">
        <fmt:message bundle="${loc}" key="${requestScope.message}" var="messageText"/>
    </c:if>

    <title>${usersButton}</title>
</head>
<body>
<c:import url="parts/header.jsp"/>

<!-- Preloader Starts -->
<div class="preloader">
    <div class="spinner"></div>
</div>
<!-- Preloader End -->

<!-- Start Align Area -->
<c:if test="${not empty sessionScope.usersList}">
    <div class="whole-wrap">
        <div class="container">
            <div class="section-top-border">
                <div class="progress-table-wrap">
                    <div class="progress-table">
                        <table id="usersTable" class="display">
                            <thead>
                            <tr class="table-head">
                                <th class="serial">ID</th>
                                <th class="percentage">${loginLabel}</th>
                                <th class="percentage">${roleLabel}</th>
                                <th class="visit"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="user" items="${sessionScope.usersList}">
                                <tr class="table-row">
                                    <td class="serial">${user.id}</td>
                                    <td class="percentage">${user.login}</td>
                                    <c:choose>
                                        <c:when test="${user.role.value eq 0}">
                                            <td class="percentage">${adminLabel}</td>
                                        </c:when>
                                        <c:when test="${user.role.value eq 1}">
                                            <td class="percentage">${directorLabel}</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td class="percentage">${accountantLabel}</td>
                                        </c:otherwise>
                                    </c:choose>
                                    <td class="visit">
                                        <button type="button" style="margin-left: 50px;">
                                            <a href="Controller?command=go_to_edit_user_page&userId=${user.id}"
                                               style="color: #0b2e13">
                                                <em class="fa fa-edit fa-2x"></em></a>
                                        </button>
                                        <form action="Controller" method="post" style="display: inherit">
                                            <input type="hidden" name="command" value="delete_user">
                                            <input type="hidden" name="deleteUserId" value="${user.id}">
                                            <div class="serial">
                                                <button type="submit">
                                                    <em class="fa fa-close fa-2x"></em>
                                                </button>
                                            </div>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--    <div class="whole-wrap">--%>
    <%--        <div class="container">--%>
    <%--            <div class="section-top-border">--%>
    <%--                <div class="progress-table-wrap">--%>
    <%--                    <div class="progress-table" id="usersTable">--%>
    <%--                        <div class="table-head">--%>
    <%--                            <div class="serial">ID</div>--%>
    <%--                            <div class="percentage">${loginLabel}</div>--%>
    <%--                            <div class="percentage">${roleLabel}</div>--%>
    <%--                            <div class="visit"></div>--%>
    <%--                        </div>--%>
    <%--                        <c:forEach var="user" items="${sessionScope.usersList}">--%>
    <%--                            <div class="table-row">--%>
    <%--                                <div class="serial">${user.id}</div>--%>
    <%--                                <div class="percentage">${user.login}</div>--%>
    <%--                                <c:choose>--%>
    <%--                                    <c:when test="${user.role.value eq 0}">--%>
    <%--                                        <div class="percentage">${adminLabel}</div>--%>
    <%--                                    </c:when>--%>
    <%--                                    <c:when test="${user.role.value eq 1}">--%>
    <%--                                        <div class="percentage">${directorLabel}</div>--%>
    <%--                                    </c:when>--%>
    <%--                                    <c:otherwise>--%>
    <%--                                        <div class="percentage">${accountantLabel}</div>--%>
    <%--                                    </c:otherwise>--%>
    <%--                                </c:choose>--%>
    <%--                                <div class="visit">--%>
    <%--                                    <button type="button" style="margin-left: 50px;">--%>
    <%--                                        <a href="Controller?command=go_to_edit_user_page&userId=${user.id}"--%>
    <%--                                           style="color: #0b2e13">--%>
    <%--                                            <em class="fa fa-edit fa-2x"></em></a>--%>
    <%--                                    </button>--%>
    <%--                                    <form action="Controller" method="post" style="display: inherit">--%>
    <%--                                        <input type="hidden" name="command" value="delete_user">--%>
    <%--                                        <input type="hidden" name="deleteUserId" value="${user.id}">--%>
    <%--                                        <div class="serial">--%>
    <%--                                            <button type="submit">--%>
    <%--                                                <em class="fa fa-close fa-2x"></em>--%>
    <%--                                            </button>--%>
    <%--                                        </div>--%>
    <%--                                    </form>--%>
    <%--                                </div>--%>
    <%--                            </div>--%>
    <%--                        </c:forEach>--%>
    <%--                    </div>--%>
    <%--                </div>--%>
    <%--            </div>--%>
    <%--        </div>--%>
    <%--    </div>--%>
</c:if>
<!-- End Align Area -->

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>

</body>
</html>

