<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 17.05.2022
  Time: 15:17
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
    <fmt:message bundle="${loc}" key="logout.button" var="logout"/>
    <fmt:message bundle="${loc}" key="users.button" var="usersButton"/>
    <fmt:message bundle="${loc}" key="home.button" var="home"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>
    <fmt:message bundle="${loc}" key="calcEfficiency.button" var="calcEfficiency"/>

    <fmt:message bundle="${loc}" key="label.companyInfo" var="companyInfo"/>
    <fmt:message bundle="${loc}" key="label.period" var="period"/>
    <fmt:message bundle="${loc}" key="label.year" var="year"/>
    <fmt:message bundle="${loc}" key="label.name" var="name"/>
    <fmt:message bundle="${loc}" key="label.fullName" var="fullName"/>
    <fmt:message bundle="${loc}" key="label.okpo" var="okpo"/>
    <fmt:message bundle="${loc}" key="label.address" var="address"/>
    <fmt:message bundle="${loc}" key="label.ynn" var="kodUnn"/>
    <fmt:message bundle="${loc}" key="label.activityType" var="activityType"/>
    <fmt:message bundle="${loc}" key="label.district" var="district"/>
    <fmt:message bundle="${loc}" key="label.area" var="area"/>
    <fmt:message bundle="${loc}" key="label.industryCode" var="industryCode"/>
    <fmt:message bundle="${loc}" key="label.industryName" var="industryName"/>
    <fmt:message bundle="${loc}" key="label.departmentName" var="departmentName"/>
    <fmt:message bundle="${loc}" key="label.associationName" var="associationName"/>
    <fmt:message bundle="${loc}" key="label.ownershipType" var="ownershipType"/>
    <fmt:message bundle="${loc}" key="label.profitabilityLevel" var="profitability"/>
    <fmt:message bundle="${loc}" key="label.profitabilityWithoutSupport" var="profitabilityWithoutSupport"/>

    <fmt:message bundle="${loc}" key="label.enterpriseEfficiency" var="enterpriseEfficiency"/>

    <fmt:message bundle="${loc}" key="label.capital" var="capital"/>
    <fmt:message bundle="${loc}" key="label.fixedAssets" var="fixedAssets"/>
    <fmt:message bundle="${loc}" key="label.loansBorrowings" var="loansBorrowings"/>
    <fmt:message bundle="${loc}" key="label.total4" var="total4"/>
    <fmt:message bundle="${loc}" key="label.shorttermDebt" var="shorttermDebt"/>
    <fmt:message bundle="${loc}" key="label.total5" var="total5"/>
    <fmt:message bundle="${loc}" key="label.salesRevenue" var="salesRevenue"/>
    <fmt:message bundle="${loc}" key="label.profit" var="profit"/>
    <fmt:message bundle="${loc}" key="label.salesReturn" var="salesReturn"/>
    <fmt:message bundle="${loc}" key="label.currentDividendPayments" var="currentDividendPayments"/>
    <fmt:message bundle="${loc}" key="label.prevDividendPayments" var="prevDividendPayments"/>
    <fmt:message bundle="${loc}" key="label.totalEndDebt" var="totalEndDebt"/>
    <fmt:message bundle="${loc}" key="label.overdueEndDebt" var="overdueEndDebt"/>
    <fmt:message bundle="${loc}" key="label.totalBeginDebt" var="totalBeginDebt"/>
    <fmt:message bundle="${loc}" key="label.overdueBeginDebt" var="overdueBeginDebt"/>
    <fmt:message bundle="${loc}" key="label.endNetAssets" var="endNetAssets"/>
    <fmt:message bundle="${loc}" key="label.beginNetAssets" var="beginNetAssets"/>
    <fmt:message bundle="${loc}" key="label.currentEndBalance" var="currentEndBalance"/>
    <fmt:message bundle="${loc}" key="label.prevEndBalance" var="prevEndBalance"/>

    <fmt:message bundle="${loc}" key="label.coefficients" var="coefficientsLabel"/>
    <fmt:message bundle="${loc}" key="label.ownSecurityCoefficient" var="ownSecurityCoefficient"/>
    <fmt:message bundle="${loc}" key="label.currentLiquidityCoefficient" var="currentLiquidityCoefficient"/>
    <fmt:message bundle="${loc}" key="label.financialSecurityCoefficient" var="financialSecurityCoefficient"/>
    <fmt:message bundle="${loc}" key="label.absoluteLiquidityCoefficient" var="absoluteLiquidityCoefficient"/>

    <fmt:message bundle="${loc}" key="label.staff" var="staffLabel"/>
    <fmt:message bundle="${loc}" key="label.averageNumberStaff" var="averageNumber"/>
    <fmt:message bundle="${loc}" key="label.salaryFundStaff" var="salaryFund"/>
    <fmt:message bundle="${loc}" key="tableRow.totalStaff" var="totalStaff"/>
    <fmt:message bundle="${loc}" key="tableRow.mainActStaff" var="mainActStaff"/>
    <fmt:message bundle="${loc}" key="tableRow.worker" var="worker"/>
    <fmt:message bundle="${loc}" key="tableRow.employee" var="employee"/>
    <fmt:message bundle="${loc}" key="tableRow.managers" var="managers"/>
    <fmt:message bundle="${loc}" key="tableRow.specialists" var="specialists"/>

    <fmt:message bundle="${loc}" key="label.products" var="products"/>
    <fmt:message bundle="${loc}" key="label.fullCostPrice" var="fullCostPrice"/>
    <fmt:message bundle="${loc}" key="label.bailedOut" var="bailedOut"/>
    <fmt:message bundle="${loc}" key="tableRow.plantProducts" var="plantProducts"/>
    <fmt:message bundle="${loc}" key="tableRow.totalPlant" var="totalPlant"/>
    <fmt:message bundle="${loc}" key="tableRow.livestockProducts" var="livestockProducts"/>
    <fmt:message bundle="${loc}" key="tableRow.totalHusbandry" var="totalHusbandry"/>
    <fmt:message bundle="${loc}" key="tableRow.total" var="total"/>

    <fmt:message bundle="${loc}" key="label.expenses" var="expensesLabel"/>
    <fmt:message bundle="${loc}" key="label.laborCost" var="laborCost"/>
    <fmt:message bundle="${loc}" key="label.materialCost" var="materialCost"/>
    <fmt:message bundle="${loc}" key="label.feed" var="feed"/>
    <fmt:message bundle="${loc}" key="label.purchasedFeed" var="purchasedFeed"/>
    <fmt:message bundle="${loc}" key="label.deprecation" var="deprecation"/>
    <fmt:message bundle="${loc}" key="label.insurancePayments" var="insurancePayments"/>
    <fmt:message bundle="${loc}" key="label.totalCosts" var="totalCosts"/>
    <fmt:message bundle="${loc}" key="label.otherCosts" var="otherCosts"/>
    <fmt:message bundle="${loc}" key="label.plantingCosts" var="plantingCosts"/>

    <fmt:message bundle="${loc}" key="label.otherParameters" var="otherParameters"/>
    <fmt:message bundle="${loc}" key="label.seed" var="seed"/>
    <fmt:message bundle="${loc}" key="label.totalProducts" var="totalProducts"/>
    <fmt:message bundle="${loc}" key="label.hectareProducts" var="hectareProducts"/>
    <fmt:message bundle="${loc}" key="label.productionCost" var="productionCost"/>
    <fmt:message bundle="${loc}" key="label.potato" var="potato"/>
    <fmt:message bundle="${loc}" key="label.agriculturalLand" var="agriculturalLand"/>
    <fmt:message bundle="${loc}" key="label.arableLand" var="arableLand"/>
    <fmt:message bundle="${loc}" key="label.hectare" var="hectare"/>
    <fmt:message bundle="${loc}" key="label.ballogectary" var="ballogectary"/>
    <fmt:message bundle="${loc}" key="label.cattle" var="cattle"/>
    <fmt:message bundle="${loc}" key="label.milk" var="milk"/>
    <fmt:message bundle="${loc}" key="label.increase" var="increase"/>
    <fmt:message bundle="${loc}" key="label.outputProduction" var="outputProduction"/>
    <fmt:message bundle="${loc}" key="label.milkYield" var="milkYield"/>
    <fmt:message bundle="${loc}" key="label.averageDailyIncrease" var="averageDailyIncrease"/>
    <fmt:message bundle="${loc}" key="label.cattleProducers" var="cattleProducers"/>
    <fmt:message bundle="${loc}" key="label.cattleCultivation" var="cattleCultivation"/>

    <fmt:message bundle="${loc}" key="page.company" var="pageTitle"/>

    <c:if test="${requestScope.message ne null}">
        <fmt:message bundle="${loc}" key="${requestScope.message}" var="messageText"/>
    </c:if>
    <fmt:message bundle="${loc}" key="message.noDataInfo" var="noInfo"/>

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


<c:if test="${sessionScope.companyInfo ne null}">
    <section class="job-single-content section-padding">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main-content">
                        <div class="single-content1">
                            <div class="single-job mb-4 d-lg-flex justify-content-between">
                                <div class="job-text">
                                    <h4>${companyInfo}</h4>
                                    <ul class="mt-4">
                                        <li><h5> ${period}: ${sessionScope.companyInfo.period}</h5></li>
                                        <li><h5> ${year}: ${sessionScope.companyInfo.year}</h5></li>
                                        <li class="mb-3"><h5> ${name}: ${sessionScope.companyInfo.name}</h5></li>
                                        <li class="mb-3"><h5> ${fullName}: ${sessionScope.companyInfo.fullName}</h5>
                                        </li>
                                        <li><h5> ${okpo}: ${sessionScope.companyInfo.okpo}</h5></li>
                                        <li class="mb-3">
                                            <h5> ${address}: <c:choose>
                                                <c:when test="${sessionScope.companyInfo.address.location eq null}">${noInfo}</c:when>
                                                <c:otherwise>${sessionScope.companyInfo.address.location}</c:otherwise>
                                            </c:choose></h5></li>
                                        <li><h5> ${kodUnn}: ${sessionScope.companyInfo.ynn}</h5></li>
                                        <li><h5> ${activityType}: ${sessionScope.companyInfo.activityType}</h5></li>
                                        <li><h5> ${district}: ${sessionScope.companyInfo.address.district}</h5></li>
                                        <li class="mb-3"><h5> ${area}: ${sessionScope.companyInfo.address.area}</h5>
                                        </li>
                                        <li>
                                            <h5> ${industryCode}: ${sessionScope.companyInfo.companyInfo.industryCode}</h5>
                                        </li>
                                        <li>
                                            <h5> ${industryName}: ${sessionScope.companyInfo.companyInfo.industryName}</h5>
                                        </li>
                                        <li>
                                            <h5> ${departmentName}: ${sessionScope.companyInfo.companyInfo.departmentName}</h5>
                                        </li>
                                        <li>
                                            <h5> ${associationName}: ${sessionScope.companyInfo.companyInfo.associationName}</h5>
                                        </li>
                                        <li class="mb-3">
                                            <h5> ${ownershipType}: ${sessionScope.companyInfo.companyInfo.ownershipType}</h5>
                                        </li>
                                        <li>
                                            <h5> ${profitability}: <c:choose>
                                                <c:when test="${sessionScope.companyInfo.coefficients.profitability eq null}">${noInfo}</c:when>
                                                <c:otherwise>${sessionScope.companyInfo.coefficients.profitability}</c:otherwise>
                                            </c:choose></h5>
                                        </li>
                                        <li>
                                            <h5> ${profitabilityWithoutSupport}: <c:choose>
                                                <c:when test="${sessionScope.companyInfo.coefficients.profitabilityWithoutSupport eq null}">${noInfo}</c:when>
                                                <c:otherwise>${sessionScope.companyInfo.coefficients.profitabilityWithoutSupport}</c:otherwise>
                                            </c:choose></h5>
                                        </li>
                                    </ul>
                                </div>
                                <c:if test="${sessionScope.user.role.value eq 1}">
                                    <div class="job-btn align-self-center">
                                        <input type="button" id="calcEfficiency" class="third-btn"
                                               value="${calcEfficiency}">
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <!-- Category Area Starts -->
                        <div id="enterpriseEfficiency">
                            <div class="single-category text-center mb-4">
                                <img src="<c:url value="/resources/images/cat1.png"/>" alt="diagram">
                                <h4>${enterpriseEfficiency}</h4>
                                <h5><c:out value="${sessionScope.enterpriseEfficiency} %"/></h5>
                            </div>
                        </div>
                        <!-- Category Area End -->
                        <div class="single-content2">
                            <div class="single-job mb-4 d-lg-flex justify-content-between">
                                <div class="job-text">
                                    <h4>${capital}</h4>
                                    <ul class="mt-4">
                                        <li><h5> ${fixedAssets}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.fixedAssets.fixedAssets eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.fixedAssets.fixedAssets}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${loansBorrowings}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.fixedAssets.loansBorrowings eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.fixedAssets.loansBorrowings}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li class="mb-3"><h5> ${total4}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.fixedAssets.total4 eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.fixedAssets.total4}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${shorttermDebt}: <fmt:formatNumber type="currency"
                                                                                     value="${sessionScope.companyInfo.fixedAssets.shorttermDebt}"/></h5>
                                        </li>
                                        <li class="mb-3"><h5> ${total5}: <fmt:formatNumber type="currency"
                                                                                           value="${sessionScope.companyInfo.fixedAssets.total5}"/></h5>
                                        </li>
                                        <li><h5> ${salesRevenue}: <fmt:formatNumber type="currency"
                                                                                    value="${sessionScope.companyInfo.fixedAssets.salesRevenue}"/></h5>
                                        </li>
                                        <li><h5> ${profit}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.fixedAssets.profit eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.fixedAssets.profit}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${salesReturn}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.sales eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="number"
                                                                           value="${sessionScope.companyInfo.salesReturn.sales}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${currentDividendPayments}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.currentDividendPayments eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.salesReturn.currentDividendPayments}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li class="mb-3"><h5> ${prevDividendPayments}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.prevDividendPayments eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.salesReturn.prevDividendPayments}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${totalEndDebt}: <fmt:formatNumber type="currency"
                                                                                    value="${sessionScope.companyInfo.salesReturn.totalEndDebt}"/></h5>
                                        </li>
                                        <li><h5> ${overdueEndDebt}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.overdueEndDebt eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.salesReturn.overdueEndDebt}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${totalBeginDebt}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.totalBeginDebt eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.salesReturn.totalBeginDebt}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li class="mb-3"><h5> ${overdueBeginDebt}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.salesReturn.overdueBeginDebt eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.salesReturn.overdueBeginDebt}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${endNetAssets}: <fmt:formatNumber type="currency"
                                                                                    value="${sessionScope.companyInfo.coefficients.endNetAssets}"/></h5>
                                        </li>
                                        <li class="mb-3"><h5> ${beginNetAssets}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.coefficients.beginNetAssets eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.coefficients.beginNetAssets}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                        <li><h5> ${currentEndBalance}: <fmt:formatNumber type="currency"
                                                                                         value="${sessionScope.companyInfo.cattle.currentEndBalance}"/></h5>
                                        </li>
                                        <li><h5> ${prevEndBalance}: <c:choose>
                                            <c:when test="${sessionScope.companyInfo.cattle.prevEndBalance eq null}">${noInfo}</c:when>
                                            <c:otherwise><fmt:formatNumber type="currency"
                                                                           value="${sessionScope.companyInfo.cattle.prevEndBalance}"/></c:otherwise>
                                        </c:choose></h5>
                                        </li>
                                    </ul>

                                    <!--My modification-->
                                    <figure class="highcharts-figure">
                                        <div id="container_for_capital"></div>
                                    </figure>
                                    <!--My modification-->

                                </div>
                            </div>
                        </div>
                        <div class="single-content3 py-4">
                            <h4>${coefficientsLabel}</h4>
                            <ul>
                                <li>${ownSecurityCoefficient}: <fmt:formatNumber type="number"
                                                                                 value="${sessionScope.companyInfo.coefficients.ownSecurity}"/></li>
                                <li>${currentLiquidityCoefficient}: <fmt:formatNumber type="number"
                                                                                      value="${sessionScope.companyInfo.coefficients.currentLiquidity}"/></li>
                                <li>${financialSecurityCoefficient}: <fmt:formatNumber type="number"
                                                                                       value="${sessionScope.companyInfo.coefficients.financialSecurity}"/></li>
                                <c:if test="${sessionScope.companyInfo.coefficients.absoluteLiquidity ne null}">
                                    <li>${absoluteLiquidityCoefficient}: <fmt:formatNumber type="number"
                                                                                           value="${sessionScope.companyInfo.coefficients.absoluteLiquidity}"/></li>
                                </c:if>
                            </ul>
                        </div>
                        <c:if test="${sessionScope.companyInfo.staff ne null}">
                            <div class="single-content4 py-4">
                                <h3 class="mb-30 title_color">${staffLabel}</h3>
                                <div class="progress-table-wrap">
                                    <div class="progress-table">
                                            <%--Style modification--%>
                                        <div class="table-head table-bordered pl-4">
                                            <div class="percentage">${staffLabel}</div>
                                            <div class="country">${averageNumber}</div>
                                            <div class="country">${salaryFund}</div>
                                        </div>
                                        <c:forEach var="staff" items="${sessionScope.companyInfo.staff}">
                                            <div class="table-row table-bordered pl-4">
                                                <c:choose>
                                                    <c:when test="${staff.index eq 107}">
                                                        <div class="percentage">${totalStaff}</div>
                                                    </c:when>
                                                    <c:when test="${staff.index eq 109}">
                                                        <div class="percentage">${mainActStaff}</div>
                                                    </c:when>
                                                    <c:when test="${staff.index eq 111}">
                                                        <div class="percentage">${worker}</div>
                                                    </c:when>
                                                    <c:when test="${staff.index eq 113}">
                                                        <div class="percentage">${employee}</div>
                                                    </c:when>
                                                    <c:when test="${staff.index eq 115}">
                                                        <div class="percentage">${managers}</div>
                                                    </c:when>
                                                    <c:when test="${staff.index eq 117}">
                                                        <div class="percentage">${specialists}</div>
                                                    </c:when>
                                                </c:choose>
                                                    <%--Style modification--%>
                                                <div class="country">
                                                    <c:choose>
                                                        <c:when test="${staff.averageNumber eq null}">${noInfo}</c:when>
                                                        <c:otherwise><fmt:formatNumber type="number"
                                                                                       value="${staff.averageNumber}"/></c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="country">
                                                    <c:choose>
                                                        <c:when test="${staff.salaryFund eq null}">${noInfo}</c:when>
                                                        <c:otherwise><fmt:formatNumber type="number"
                                                                                       value="${staff.salaryFund}"/></c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>



                                <!--My modification-->
                                <figure class="highcharts-figure">
                                    <div id="container_for_staffLabel"></div>
                                </figure>
                                <!--My modification-->



                            </div>
                        </c:if>
                        <c:if test="${sessionScope.companyInfo.cropProductions ne null}">
                            <div class="single-content5 py-4">
                                <h3 class="mb-30 title_color">${products}</h3>
                                <div class="progress-table-wrap">
                                    <div class="progress-table">
                                        <div class="table-head table-bordered pl-4">
                                            <div class="percentage">${products}</div>
                                            <div class="country">${fullCostPrice}</div>
                                            <div class="country">${bailedOut}</div>
                                        </div>
                                        <c:forEach var="cropProduction"
                                                   items="${sessionScope.companyInfo.cropProductions}">
                                            <div class="table-row table-bordered pl-4">
                                                <c:choose>
                                                    <c:when test="${cropProduction.index eq 121}">
                                                        <div class="percentage">${plantProducts}</div>
                                                    </c:when>
                                                    <c:when test="${cropProduction.index eq 123}">
                                                        <div class="percentage">${totalPlant}</div>
                                                    </c:when>
                                                    <c:when test="${cropProduction.index eq 125}">
                                                        <div class="percentage">${livestockProducts}</div>
                                                    </c:when>
                                                    <c:when test="${cropProduction.index eq 127}">
                                                        <div class="percentage">${totalHusbandry}</div>
                                                    </c:when>
                                                    <c:when test="${cropProduction.index eq 129}">
                                                        <div class="percentage">${total}</div>
                                                    </c:when>
                                                </c:choose>
                                                <div class="country">
                                                    <c:choose>
                                                        <c:when test="${cropProduction.fullCostPrice eq null}">${noInfo}</c:when>
                                                        <c:otherwise><fmt:formatNumber type="number"
                                                                                       value="${cropProduction.fullCostPrice}"/></c:otherwise>
                                                    </c:choose>
                                                </div>
                                                <div class="country">
                                                    <c:choose>
                                                        <c:when test="${cropProduction.bailedOut eq null}">${noInfo}</c:when>
                                                        <c:otherwise><fmt:formatNumber type="number"
                                                                                       value="${cropProduction.bailedOut}"/></c:otherwise>
                                                    </c:choose>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                        <div class="single-content6 py-4">
                            <h4>${expensesLabel}</h4>
                            <ul>
                                <li>${laborCost}: <fmt:formatNumber type="currency"
                                                                    value="${sessionScope.companyInfo.expenses.laborCost}"/></li>
                                <li>${materialCost}: <fmt:formatNumber type="currency"
                                                                       value="${sessionScope.companyInfo.expenses.materialCosts}"/></li>
                                <c:if test="${sessionScope.companyInfo.expenses.feed ne null}">
                                    <li>${feed}: <fmt:formatNumber type="currency"
                                                                   value="${sessionScope.companyInfo.expenses.feed}"/></li>
                                </c:if>
                                <c:if test="${sessionScope.companyInfo.expenses.purchasedFeed ne null}">
                                    <li>${purchasedFeed}: <fmt:formatNumber type="currency"
                                                                            value="${sessionScope.companyInfo.expenses.purchasedFeed}"/></li>
                                </c:if>
                                <c:if test="${sessionScope.companyInfo.expenses.deprecation ne null}">
                                    <li>${deprecation}: <fmt:formatNumber type="currency"
                                                                          value="${sessionScope.companyInfo.expenses.deprecation}"/></li>
                                </c:if>
                                <c:if test="${sessionScope.companyInfo.expenses.insurancePayments ne null}">
                                    <li>${insurancePayments}: <fmt:formatNumber type="currency"
                                                                                value="${sessionScope.companyInfo.expenses.insurancePayments}"/></li>
                                </c:if>
                                <c:if test="${sessionScope.companyInfo.expenses.otherCosts ne null}">
                                    <li>${otherCosts}: <fmt:formatNumber type="currency"
                                                                         value="${sessionScope.companyInfo.expenses.otherCosts}"/></li>
                                </c:if>
                                <li>${totalCosts}: <fmt:formatNumber type="currency"
                                                                     value="${sessionScope.companyInfo.expenses.totalCosts}"/></li>
                                <c:if test="${sessionScope.companyInfo.expenses.plantingCosts ne null}">
                                    <li>${plantingCosts}: <fmt:formatNumber type="currency"
                                                                            value="${sessionScope.companyInfo.expenses.plantingCosts}"/></li>
                                </c:if>
                            </ul>



                            <!--My modification-->
                            <figure class="highcharts-figure">
                                <div id="container_for_expensesLabel"></div>
                            </figure>
                            <!--My modification-->



                        </div>
                        <div class="single-content7 py-4">
                            <h4>${otherParameters}</h4>
                            <span>${seed}</span>
                            <ul>
                                <li>${totalProducts}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(0).totalProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(0).totalProducts}"/></c:otherwise>
                                </c:choose></li>
                                <li>${hectareProducts}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(0).hectareProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(0).hectareProducts}"/></c:otherwise>
                                </c:choose></li>
                                <li>${productionCost}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(0).productionCost eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="currency"
                                                                   value="${sessionScope.companyInfo.grounds.get(0).productionCost}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <span>${potato}</span>
                            <ul>
                                <li>${totalProducts}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(1).totalProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(1).totalProducts}"/></c:otherwise>
                                </c:choose></li>
                                <li>${hectareProducts}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(1).hectareProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(1).hectareProducts}"/></c:otherwise>
                                </c:choose></li>
                                <li>${productionCost}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(1).productionCost eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="currency"
                                                                   value="${sessionScope.companyInfo.grounds.get(1).productionCost}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <span>${agriculturalLand}</span>
                            <ul>
                                <li>${hectare}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(0).hectare eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(0).hectare}"/></c:otherwise>
                                </c:choose></li>
                                <li>${ballogectary}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(0).ballogectars eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(0).ballogectars}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <span>${arableLand}</span>
                            <ul>
                                <li>${hectare}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(1).hectare eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(1).hectare}"/></c:otherwise>
                                </c:choose></li>
                                <li>${ballogectary}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.grounds.get(1).ballogectars eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.grounds.get(1).ballogectars}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <c:if test="${sessionScope.companyInfo.dairyProducts.cattle ne null}">
                            <p>${cattle}: <fmt:formatNumber type="number"
                                                               value="${sessionScope.companyInfo.dairyProducts.cattle}"/></p>
                            </c:if>
                            <span>${milk}</span>
                            <ul>
                                <li>${outputProduction}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.dairyProducts.outputDairyProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.dairyProducts.outputDairyProducts}"/></c:otherwise>
                                </c:choose></li>
                                <li>${productionCost}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.dairyProducts.costDairyProducts eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="currency"
                                                                   value="${sessionScope.companyInfo.dairyProducts.costDairyProducts}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <span>${increase}</span>
                            <ul>
                                <li>${outputProduction}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.dairyProducts.productionGrowth eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.dairyProducts.productionGrowth}"/></c:otherwise>
                                </c:choose></li>
                                <li>${productionCost}: <c:choose>
                                    <c:when test="${sessionScope.companyInfo.dairyProducts.productionCostGrowth eq null}">${noInfo}</c:when>
                                    <c:otherwise><fmt:formatNumber type="currency"
                                                                   value="${sessionScope.companyInfo.dairyProducts.productionCostGrowth}"/></c:otherwise>
                                </c:choose></li>
                            </ul>
                            <br>
                            <c:if test="${sessionScope.companyInfo.cattle.milkYield ne null}">
                                <p>${milkYield}: <fmt:formatNumber type="number"
                                                                   value="${sessionScope.companyInfo.cattle.milkYield}"/></p>
                            </c:if>
                            <c:if test="${sessionScope.companyInfo.cattle.averageDailyIncrease ne null}">
                                <p>${averageDailyIncrease}: <fmt:formatNumber type="number"
                                                                              value="${sessionScope.companyInfo.cattle.averageDailyIncrease}"/></p>
                            </c:if>
                            <c:if test="${sessionScope.companyInfo.cattle.cattleProducers ne null}">
                                <p>${cattleProducers}: <fmt:formatNumber type="number"
                                                                         value="${sessionScope.companyInfo.cattle.cattleProducers}"/></p>
                            </c:if>
                            <c:if test="${sessionScope.companyInfo.cattle.cattleCultivation ne null}">
                                <p>${cattleCultivation}: <fmt:formatNumber type="number"
                                                                           value="${sessionScope.companyInfo.cattle.cattleCultivation}"/></p>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</c:if>

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>



<!--My modification-->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/data.js"></script>
<script src="https://code.highcharts.com/modules/drilldown.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script>
    var staffinfo = document.getElementsByClassName('country');
    Highcharts.chart('container_for_staffLabel', {
        chart: {type: 'pie'},
        title: {text: "${averageNumber}"},
        accessibility: {announceNewData: {enabled: true}, point: {valueSuffix: 'чел.'}},
        plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.0f} чел.'}}},
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.0f} чел.</b><br/>'
        },

        series: [
            {
                name: "${averageNumber}", colorByPoint: true,
                data: [
                    {name: "Рабочие", y: Number(staffinfo.item(6).innerHTML), drilldown: null},
                    {name: "Служащие", y: Number(staffinfo.item(8).innerHTML), drilldown: "Служащие"},
                ].filter(function(d) {return d["y"]>0})
            }
        ],
        drilldown: {
            series: [
                {
                    name: "Служащие", id: "Служащие",
                    data: [
                        ["Руководители", Number(staffinfo.item(10).innerHTML)],
                        ["Специалисты", Number(staffinfo.item(12).innerHTML)],
                        ["Другие", Number(staffinfo.item(8).innerHTML)-(Number(staffinfo.item(10).innerHTML)+Number(staffinfo.item(12).innerHTML))]
                    ].filter(function(d) {return d[1]>0})
                }
            ]
        }
    });
    Highcharts.chart('container_for_expensesLabel', {
        chart: {type: 'pie'},
        title: {text: "${expensesLabel}"},
        accessibility: {
            announceNewData: {enabled: true},
            point: {valueSuffix: '₽'}
        },
        plotOptions: {series: {dataLabels: {enabled: true, format: '{point.name}: {point.y:.1f}₽'}}},
        tooltip: {
            headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
            pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}₽</b><br/>'
        },
        series: [
            {
                name: "${expensesLabel}",
                colorByPoint: true,
                data: [
                    {name: "${laborCost}", y: Number(${sessionScope.companyInfo.expenses.laborCost})},
                    {name: "${materialCost}", y: Number(${sessionScope.companyInfo.expenses.materialCosts})},
                    {name: "${feed}", y: Number(${sessionScope.companyInfo.expenses.feed})},
                    {name: "${purchasedFeed}", y: Number(${sessionScope.companyInfo.expenses.purchasedFeed})},
                    {name: "${deprecation}", y: Number(${sessionScope.companyInfo.expenses.deprecation})},
                    {name: "${insurancePayments}", y: Number(${sessionScope.companyInfo.expenses.insurancePayments})},
                    {name: "${otherCosts}", y: Number(${sessionScope.companyInfo.expenses.otherCosts})}
                ].filter(function(d) {return d["y"]>0})
            }
        ],
    });

    Highcharts.chart('container_for_capital', {
        chart: {type: 'column'},
        title: {text: 'Капитал предприятия на начало/конец отчетного периода.'},
        xAxis: {categories: ['Начало отчетного периода', 'Конец отчетного периода']},
        yAxis: {title: {text: 'Рублей, ₽'}},
        credits: {enabled: false},
        series: [{
            name: 'Кредиторская задолженность, всего',
            data: [Number(${sessionScope.companyInfo.salesReturn.totalBeginDebt}), Number(${sessionScope.companyInfo.salesReturn.totalEndDebt})]
        }, {
            name: 'Кредиторская задолженность, в т.ч. просроченная',
            data: [Number(${sessionScope.companyInfo.salesReturn.overdueBeginDebt}), Number(${sessionScope.companyInfo.salesReturn.overdueEndDebt})]
        }, {
            name: 'Чистые активы',
            data: [Number(${sessionScope.companyInfo.coefficients.beginNetAssets}), Number(${sessionScope.companyInfo.coefficients.endNetAssets})]
        }]
    });

</script>
<!--My modification-->



</body>
</html>
