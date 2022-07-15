<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 19.05.2022
  Time: 0:46
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
    <fmt:message bundle="${loc}" key="correlation.button" var="correlationButton"/>

    <fmt:message bundle="${loc}" key="label.ynn" var="kodUnn"/>
    <fmt:message bundle="${loc}" key="label.profitFromSales" var="profitFromSales"/>
    <fmt:message bundle="${loc}" key="label.netDiscountedValue" var="netDiscountedValue"/>
    <fmt:message bundle="${loc}" key="label.costRecovery" var="costRecovery"/>
    <fmt:message bundle="${loc}" key="label.productionProfitability" var="productionProfitability"/>
    <fmt:message bundle="${loc}" key="label.increasePerEmployed" var="increasePerEmployed"/>
    <fmt:message bundle="${loc}" key="label.landGrowth" var="landGrowth"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>
    <fmt:message bundle="${loc}" key="label.organization" var="organization"/>

    <fmt:message bundle="${loc}" key="page.indicators" var="pageTitle"/>

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

<!-- Start blog-posts Area -->
<div class="whole-wrap">
    <%--    <div class="container">--%>
    <div class="section-top-border">
        <div class="progress-table-wrap">
            <div class="progress-table">
                <table id="companiesTable" class="display">
                    <thead>
                    <tr class="table-head">
                        <th class="serial">${kodUnn}</th>
                        <th class="visit">${profitFromSales}</th>
                        <th class="visit">${netDiscountedValue}</th>
                        <th class="visit">${costRecovery}</th>
                        <th class="visit">${productionProfitability}</th>
                        <th class="visit">${increasePerEmployed}</th>
                        <th class="visit">${landGrowth}</th>
                        <c:if test="${sessionScope.user.role.value eq 2}">
                            <th class="visit"></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="company" items="${sessionScope.companiesIndicators}">
                        <tr class="table-row">
                            <td class="serial">
                                <h5>${company.ynn}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.profitFromSales}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.netDiscountedValue}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.costRecovery}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.productionProfitability}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.increasePerEmployed}</h5>
                            </td>
                            <td class="visit">
                                <h5>${company.landGrowth}</h5>
                            </td>
                            <c:if test="${sessionScope.user.role.value eq 2}">
                                <td class="visit">
                                    <a href="Controller?command=go_to_correlation_page&companyYnn=${company.ynn}"
                                       style="color: #0b2e13">
                                        <div class="third-btn"><c:out value="${correlationButton}"/></div>
                                    </a>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%--    </div>--%>
</div>


<div class="whole-wrap">
    <%--    <div class="container">--%>
    <div class="section-top-border">
        <div class="progress-table-wrap">
            <div class="progress-table">
                <div class="table-head">
                    <div class="visit">${organization}</div>
                    <div class="visit">${profitFromSales}</div>
                    <div class="visit">${netDiscountedValue}</div>
                    <div class="visit">${costRecovery}</div>
                    <div class="visit">${productionProfitability}</div>
                    <div class="visit">${increasePerEmployed}</div>
                    <div class="visit">${landGrowth}</div>
                </div>
                <c:forEach var="enterpriseIndicators" items="${sessionScope.enterpriseIndicators}" varStatus="value">
                    <div class="table-row">
                        <div class="visit">
                            <h5>
                                <c:choose>
                                    <c:when test="${value.count eq 1}">
                                        <c:out value="РУП"/>
                                    </c:when>
                                    <c:when test="${value.count eq 2}">
                                        <c:out value="КУП"/>
                                    </c:when>
                                    <c:when test="${value.count eq 3}">
                                        <c:out value="ХО"/>
                                    </c:when>
                                    <c:when test="${value.count eq 4}">
                                        <c:out value="СПК"/>
                                    </c:when>
                                    <c:when test="${value.count eq 5}">
                                        <c:out value="Прочие"/>
                                    </c:when>
                                </c:choose>
                            </h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.profitFromSales}</h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.netDiscountedValue}</h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.costRecovery}</h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.productionProfitability}</h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.increasePerEmployed}</h5>
                        </div>
                        <div class="visit">
                            <h5>${enterpriseIndicators.landGrowth}</h5>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
    <%--    </div>--%>
</div>
<!-- End blog-posts Area -->

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>
</body>
</html>
