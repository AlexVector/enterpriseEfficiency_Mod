<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 23.10.2021
  Time: 23:22
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

    <!-- Locale -->
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="langs.labels" var="loc"/>

    <fmt:message bundle="${loc}" key="signIn.button" var="signIn"/>
    <fmt:message bundle="${loc}" key="signUp.button" var="signUp"/>
    <fmt:message bundle="${loc}" key="import.button" var="importButton"/>
    <fmt:message bundle="${loc}" key="logout.button" var="logout"/>
    <fmt:message bundle="${loc}" key="users.button" var="usersButton"/>
    <fmt:message bundle="${loc}" key="home.button" var="home"/>
    <fmt:message bundle="${loc}" key="indicators.button" var="indicatorsButton"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>

    <c:if test="${requestScope.message ne null}">
        <fmt:message bundle="${loc}" key="${requestScope.message}" var="messageText"/>
    </c:if>

    <!-- CSS Files -->
    <link rel="stylesheet" href="<c:url value="/resources/css/fontello.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontello-codes.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontello-embedded.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontello-ie7.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/fontello-ie7-codes.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/animation.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/animate-3.7.0.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome-4.7.0.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/flat-icon/flaticon.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-4.1.3.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/owl-carousel.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/nice-select.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">
<%--    <link rel="stylesheet" href="<c:url value="/resources/css/downloadFontawesome.css"/>">--%>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.0/css/jquery.dataTables.css">

    <title>Title</title>
</head>
<body>
<!-- Header Area Starts -->
<c:choose>
    <c:when test="${sessionScope.user eq null}">
        <header>
            <div class="header-top">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2">
                            <div class="logo-area">
                                <a href="Controller?command=go_to_home_page">
                                    <img src="<c:url value="/resources/images/newlogo.png"/>" height="96px" alt="logo">
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-10">
                            <div class="custom-navbar">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                            <div class="main-menu main-menu-light">
                                <ul>
                                    <c:if test="${requestScope.message ne null}">
                                        <li>
                                            <c:out value="${messageText}"/>
                                        </li>
                                    </c:if>
                                    <li>
                                        <a href="Controller?command=ru_RU">
                                            <img src="<c:url value="/resources/images/elements/flag_russia.png"/> " height="30"
                                                 width="40" alt="RU">
                                        </a>
                                    </li>
                                    <li>
                                        <a href="Controller?command=en_US">
                                            <img src="<c:url value="/resources/images/elements/flag_usa.png"/> " height="30"
                                                 width="40" alt="EN">
                                        </a>
                                    </li>
                                        <%--                            <li class="menu-btn">--%>
                                        <%--                                <a href="Controller?command=go_to_sign_up_page"--%>
                                        <%--                                   class="template-btn">${signUp}</a>--%>
                                        <%--                            </li>--%>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </c:when>
    <c:otherwise>
        <header>
            <div class="header-area blog-menu">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-2">
                            <div class="logo-area">
                                <a href="Controller?command=go_to_home_page">
                                    <img src="<c:url value="/resources/images/newlogo.png"/>" height="96px" alt="logo">
                                </a>
                            </div>
                        </div>
                        <div class="col-lg-10">
                            <div class="custom-navbar">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                            <div class="main-menu">
                                <ul>
                                    <li>
                                        <a href="Controller?command=ru_RU">
                                            <img src="<c:url value="/resources/images/elements/flag_russia.png"/> " height="30"
                                                 width="40" alt="RU">
                                        </a>
                                    </li>
                                    <li>
                                        <a href="Controller?command=en_US">
                                            <img src="<c:url value="/resources/images/elements/flag_usa.png"/> " height="30"
                                                 width="40" alt="EN">
                                        </a>
                                    </li>
                                    <c:choose>
                                        <c:when test="${sessionScope.user eq null}">
                                            <li class="menu-btn">
                                                <a href="Controller?command=go_to_sign_in_page"
                                                   class="template-btn">${signIn}</a>
                                            </li>
                                            <li>
                                                <a href="Controller?command=go_to_sign_up_page"
                                                   class="template-btn">${signUp}</a>
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="Controller?command=logout" class="template-btn">${logout}</a>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <div class="custom-navbar">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                            <div class="main-menu">
                                <ul>
                                    <li class="active"><a href="Controller?command=go_to_home_page">${home}</a></li>
                                    <c:choose>
                                        <%--                                <c:when test="${sessionScope.user eq null}">--%>
                                        <%--                                    <li><a href="#">FAQ</a></li>--%>
                                        <%--                                </c:when>--%>
                                        <c:when test="${sessionScope.user.role.value eq 0}">
                                            <li><a href="Controller?command=go_to_sign_up_page">${signUpLabel}</a></li>
                                            <li><a href="Controller?command=go_to_users_page">${usersButton}</a></li>
                                            <%--                                    <li><a href="#">FAQ</a></li>--%>
                                        </c:when>
                                        <c:when test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                            <li><a href="Controller?command=go_to_indicators_page">${indicatorsButton}</a></li>
                                            <%--                                    <li><a href="#">FAQ</a></li>--%>
                                        </c:when>
                                    </c:choose>
                                    <%--My modification--%>
                                    <br>
                                        <%--My modification--%>
                                    <c:if test="${requestScope.message ne null}">
                                        <li>
                                            <c:out value="${messageText}"/>
                                        </li>
                                    </c:if>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    </c:otherwise>
</c:choose>
<!-- Header Area End -->
</body>
</html>
