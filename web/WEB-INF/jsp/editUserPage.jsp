<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 21.10.2021
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value="/resources/images/logo/favicon.png"/>" type="image/x-icon">

    <!-- Locale-->
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="langs.labels" var="loc"/>

    <fmt:message bundle="${loc}" key="add.ad.button" var="importButton"/>
    <fmt:message bundle="${loc}" key="logout.button" var="logout"/>
    <fmt:message bundle="${loc}" key="profile.button" var="profile"/>
    <fmt:message bundle="${loc}" key="assortment.button" var="assortment"/>
    <fmt:message bundle="${loc}" key="users.button" var="usersButton"/>
    <fmt:message bundle="${loc}" key="home.button" var="home"/>
    <fmt:message bundle="${loc}" key="edit.button" var="editButton"/>

    <fmt:message bundle="${loc}" key="label.login" var="login"/>
    <fmt:message bundle="${loc}" key="label.newPassword" var="newPassword"/>
    <fmt:message bundle="${loc}" key="label.oldPassword" var="oldPassword"/>
    <fmt:message bundle="${loc}" key="password.input.title" var="passwordTitle"/>
    <fmt:message bundle="${loc}" key="oldPassword.input.placeholder" var="oldPasswordPlaceholder"/>
    <fmt:message bundle="${loc}" key="newPassword.input.placeholder" var="newPasswordPlaceholder"/>


    <fmt:message bundle="${loc}" key="label.role" var="role"/>
    <fmt:message bundle="${loc}" key="label.admin" var="adminLabel"/>
    <fmt:message bundle="${loc}" key="label.director" var="directorLabel"/>
    <fmt:message bundle="${loc}" key="label.accountant" var="accountantLabel"/>

    <fmt:message bundle="${loc}" key="page.editUser" var="pageTitle"/>

    <c:if test="${requestScope.message ne null}">
        <fmt:message bundle="${loc}" key="${requestScope.message}" var="messageText"/>
    </c:if>

    <!-- Page Title -->
    <title>${pageTitle}</title>
</head>
<body>
<c:import url="parts/header.jsp"/>

<!-- Preloader Starts -->
<div class="preloader">
    <div class="spinner"></div>
</div>
<!-- Preloader End -->

<!-- Contact Form Starts -->
<div class="whole-wrap">
    <div class="container">
        <div class="section-top-border">
            <div class="row">
                <div class="col-lg-4 mb-5 mb-lg-0">
                    <br>
                    <div class="d-flex">
                        <div class="info-text">
                            <h4>${login}</h4>
                        </div>
                    </div>
                    <p></p>
                    <div class="d-flex">
                        <div class="info-text">
                            <h4>${oldPassword}</h4>
                        </div>
                    </div>
                    <br>
                    <div class="d-flex">
                        <div class="info-text">
                            <h4>${newPassword}</h4>
                        </div>
                    </div>
                    <p></p>
                    <div class="d-flex">
                        <div class="info-text">
                            <h4>${role}</h4>
                        </div>
                    </div>

                </div>
                <div class="col-lg-5">
                    <form action="Controller" method="post">
                        <input type="hidden" name="command" value="edit_user"/>
                        <div class="mt-10">
                            <input type="text" value="${sessionScope.editUser.login}"
                                   pattern="${"^([0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9})$"}"
                                   placeholder="${sessionScope.editUser.login}" name="editLogin"
                                   onfocus="this.placeholder = '${sessionScope.editUser.login}'"
                                   onblur="this.placeholder = '${sessionScope.editUser.login}'" disabled
                                   class="single-input">
                        </div>
                        <div class="mt-10">
                            <input type="password"
                                   pattern="${"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\w{6,20}$"}"
                                   title="${passwordTitle}" maxlength="20"
                                   placeholder="${oldPasswordPlaceholder}" name="editOldPassword"
                                   onfocus="this.placeholder = 'Password1'"
                                   onblur="this.placeholder = '${oldPasswordPlaceholder}'" class="single-input">
                        </div>
                        <div class="mt-10">
                            <input type="password"
                                   pattern="${"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])\\w{6,20}$"}"
                                   title="${passwordTitle}" maxlength="20"
                                   placeholder="${newPasswordPlaceholder}" name="editNewPassword"
                                   onfocus="this.placeholder = 'Password1'"
                                   onblur="this.placeholder = '${newPasswordPlaceholder}'" class="single-input">
                        </div>
                        <c:if test="${sessionScope.user.role.value eq 0}">
                            <c:choose>
                                <c:when test="${sessionScope.editUser.role.value eq 0}">
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fa fa-user" aria-hidden="true"></i></div>
                                        <div class="form-select">
                                            <select name="editRole" class="nice-select list" disabled>
                                                <option value="0">${adminLabel}</option>
                                            </select>
                                        </div>
                                    </div>
                                </c:when>
                                <c:when test="${sessionScope.editUser.role.value eq 1 or sessionScope.editUser.role.value eq 2}">
                                    <div class="input-group-icon mt-10">
                                        <div class="icon"><i class="fa fa-user" aria-hidden="true"></i></div>
                                        <div class="form-select">
                                            <select name="editRole" class="nice-select list">
                                                <option value="0">${adminLabel}</option>
                                                <c:choose>
                                                    <c:when test="${sessionScope.editUser.role.value eq 1}">
                                                        <option value="1" selected>${directorLabel}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="1">${directorLabel}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                                <c:choose>
                                                    <c:when test="${sessionScope.editUser.role.value eq 2}">
                                                        <option value="2" selected>${accountantLabel}</option>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <option value="2">${accountantLabel}</option>
                                                    </c:otherwise>
                                                </c:choose>
                                            </select>
                                        </div>
                                    </div>
                                </c:when>
                            </c:choose>
                        </c:if>
                        <br>
                        <button type="submit" class="template-btn">${editButton}</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Contact Form End -->

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>
</body>
</html>
