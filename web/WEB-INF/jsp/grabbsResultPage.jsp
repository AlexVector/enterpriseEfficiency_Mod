<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Favicon -->
    <link rel="shortcut icon" href="<c:url value="/resources/images/logo/favicon.png"/>" type="image/x-icon">

    <!-- Locale -->
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="langs.labels" var="loc"/>

    <fmt:message bundle="${loc}" key="signIn.button" var="signIn"/>
    <fmt:message bundle="${loc}" key="signUp.button" var="signUp"/>
    <fmt:message bundle="${loc}" key="import.button" var="importButton"/>
    <fmt:message bundle="${loc}" key="logout.button" var="logout"/>
    <fmt:message bundle="${loc}" key="profile.button" var="profile"/>
    <fmt:message bundle="${loc}" key="assortment.button" var="assortment"/>
    <fmt:message bundle="${loc}" key="users.button" var="usersButton"/>
    <fmt:message bundle="${loc}" key="home.button" var="home"/>
    <fmt:message bundle="${loc}" key="indicators.button" var="indicatorsButton"/>

    <fmt:message bundle="${loc}" key="label.okpo" var="okpo"/>
    <fmt:message bundle="${loc}" key="label.ynn" var="kodUnn"/>
    <fmt:message bundle="${loc}" key="label.name" var="name"/>
    <fmt:message bundle="${loc}" key="label.fullName" var="fullName"/>
    <fmt:message bundle="${loc}" key="label.activityType" var="activityType"/>
    <fmt:message bundle="${loc}" key="label.areas" var="areas"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>
    <fmt:message bundle="${loc}" key="label.excel" var="excelLabel"/>

    <fmt:message bundle="${loc}" key="search.input.placeholder" var="searchPlaceholder"/>

    <fmt:message bundle="${loc}" key="page.home" var="pageTitle"/>

    <fmt:message bundle="${loc}" key="message.area" var="areaMessage">
        <fmt:param value="${sessionScope.filterArea}"/>
    </fmt:message>
    <fmt:message bundle="${loc}" key="message.district" var="districtMessage">
        <fmt:param value="${sessionScope.filterDistrict}"/>
    </fmt:message>
    <fmt:message bundle="${loc}" key="message.emptyCompanies" var="emptyCompanies"/>
    <fmt:message bundle="${loc}" key="message.emptyCompanies.continue" var="emptyCompaniesContinue"/>
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

<!-- Page Title Starts -->
<div class="page-title text-center">
    <div class="container">
        <div class="row">
            <div class="col-md-6 offset-md-3">
                <c:choose>
                    <c:when test="${sessionScope.anomalyResult == null}">
                        <h2>Аномалий не обнаружено...</h2>
                    </c:when>
                    <c:when test="${sessionScope.anomalyResult ne null}">
                        <h2>Найдены следующие аномалии:</h2>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<!-- Page Title End -->

<!-- Start blog-posts Area -->
<c:choose>
    <c:when test="${not empty sessionScope.anomalyResult}">
        <section>
            <div class="container">
                <div class="row">
                    <!--оформить страницу под аномалии-->
                    <div class="mx-auto">
                        <table id="anomalyTable" class="display">
                            <thead>
                            <tr class="table-head">
                                <th class="serial">${kodUnn}</th>
                                <th class="serial">${okpo}</th>
                                <th class="country">${name}</th>
                                <th class="percentage">${fullName}</th>
                                <th class="percentage">Аномальный параметр</th>
                                <th class="percentage">Аномальное значение</th>
                                <th class="percentage">Аномалия</th>
                                <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                    <th class="visit"></th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="result" items="${sessionScope.anomalyResult}">
                                <tr class="table-row">
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.company.ynn}</h5></a>
                                    </td>
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.company.okpo}</h5></a>
                                    </td>
                                    <td class="country"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.company.name}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.company.fullName}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.anomaly_parameter}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.anomaly_parameter_value}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${result.company.ynn}">
                                        <h5>${result.anomaly_type}</h5></a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </c:when>


</c:choose>

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>

<script>
    $(document).ready( function () {
        var table = $('#anomalyTable').DataTable();
    } );
</script>
</body>
</html>
