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
                        <%--My modification--%>
                        <button class="btn btn-primary mb-2" id="showdynamic" type="button">Динамика показателей</button>
                            <div class="single-content0" hidden>
                                <div class="single-job mb-4 d-lg-flex justify-content-between">
                                    <div class="job-text">
                                        <h4>Динамика показателей</h4>
                                        <ul>
                                            <li>
                                                <h5>Категория:
                                                    <select class="form-control" name="category" id="dynamiccat">
                                                        <option selected disabled>Выберите категорию...</option>
                                                        <option value="1">Основная информация о предприятии</option>
                                                        <option value="2">Капитал предприятия</option>
                                                        <option value="3">Коэффициенты предприятия (На конец отчетного периода)</option>
                                                        <option value="4">Персонал предприятия</option>
                                                        <option value="5">Продукция</option>
                                                        <option value="6">Затраты предприятия (На конец отчетного периода)</option>
                                                        <option value="7">Другие параметры</option>
                                                    </select>
                                                </h5>
                                            </li>
                                            <li><h5>Параметр:<br> <select class="form-control" name="parameter" id="dynamicparam">
                                                <option selected disabled>Сначала выберите категорию...</option>
                                            </select></h5></li>
                                        </ul>
                                        <figure class="highcharts-figure">
                                            <div id="container_for_dynamic_chart"></div>
                                        </figure>
                                    </div>
                                </div>
                            </div>
                        <%--My modification--%>
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


    let options1 = [{"text":"Уровень рентабельности, %","value":"coefficients.profitability"},
        {"text":"Уровень рентабельности без учета государственной поддержки, %","value":"coefficients.profitability_without_support"}];


    let options2 = [{"text":"Основные средства","value":"fixed_assets.fixed_assets"},
        {"text":"Долгосрочные кредиты и займы","value":"fixed_assets.loans_borrowings"},
        {"text":"ИТОГО по разделу IV","value":"fixed_assets.total_4"},
        {"text":"Краткосрочная кредиторская задолженность","value":"fixed_assets.shortterm_debt"},
        {"text":"ИТОГО по разделу V","value":"fixed_assets.total_5"},
        {"text":"Выручка от реализации товаров, продукции, работ, услуг","value":"fixed_assets.sales_revenue"},
        {"text":"Чистая прибыль","value":"fixed_assets.profit"},
        {"text":"Рентабельность продаж, %","value":"sales_return.sales_return"},
        {"text":"На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2020 года)","value":"sales_return.current_dividend_payments"},
        {"text":"На выплаты дивидендов и др. доходов от участия в уставном капитале организации (За январь-декабрь 2019 года)","value":"sales_return.prev_dividend_payments"},
        {"text":"Кредиторская задолженность на конец отчетного периода всего","value":"sales_return.total_end_debt"},
        {"text":"Кредиторская задолженность на конец отчетного периода, в том числе просроченная","value":"sales_return.overdue_end_debt"},
        {"text":"Кредиторская задолженность на начало отчетного года всего","value":"sales_return.total_begin_debt"},
        {"text":"Кредиторская задолженность на начало отчетного года, в том числе просроченная","value":"sales_return.overdue_begin_debt"},
        {"text":"Чистые активы на конец отчетного периода","value":"coefficients.end_net_assets"},
        {"text":"Чистые активы на начало отчетного периода","value":"coefficients.begin_net_assets"},
        {"text":"Баланс на 31 декабря 2020 года","value":"cattle.current_end_balance"},
        {"text":"Баланс на 31 декабря 2019 года","value":"cattle.prev_end_balance"}];

    let options3 = [{"text": "Коэффициент обеспеченности собственными оборотными средствами", "value": "coefficients.own_security"},
        {"text": "Коэффициент текущей ликвидности", "value": "coefficients.current_liquidity"},
        {"text": "Коэффициент обеспеченности финансовых обязательств активами", "value": "coefficients.financial_security"},
        {"text": "Коэффициент абсолютной ликвидности", "value": "coefficients.absolute_liquidity"}];

    let options4 = [{"text":"Среднесписочная численность работников, человек* (всего, включая наемный персонал в колхозах)","value":"staff.column_index=107 AND staff.average_number"},
        {"text":"Среднесписочная численность работников, человек* (персонал основной деят. занятый в с/х производстве)","value":"staff.column_index=109 AND staff.average_number"},
        {"text":"Среднесписочная численность работников, человек* (рабочие)","value":"staff.column_index=111 AND staff.average_number"},
        {"text":"Среднесписочная численность работников, человек* (служащие)","value":"staff.column_index=113 AND staff.average_number"},
        {"text":"Среднесписочная численность работников, человек* (руководители)","value":"staff.column_index=115 AND staff.average_number"},
        {"text":"Среднесписочная численность работников, человек* (специалисты)","value":"staff.column_index=117 AND staff.average_number"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (всего, вкл. наемный персонал в колхозах)","value":"staff.column_index=107 AND staff.salary_fund"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (персонал основной деят. занятый в с/х производстве)","value":"staff.column_index=109 AND staff.salary_fund"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (рабочие)","value":"staff.column_index=111 AND staff.salary_fund"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (служащие)","value":"staff.column_index=113 AND staff.salary_fund"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (руководители)","value":"staff.column_index=115 AND staff.salary_fund"},
        {"text":"Фонд ЗП работников, вкл. совместителей млн. руб. (специалисты)","value":"staff.column_index=117 AND staff.salary_fund"}];


    let options5 = [{"text":"Полная себестоимость проданной продукции растениеводства","value":"crop_production.column_index = 123 AND crop_production.full_cost_price"},
        {"text":"Полная себестоимость проданной продукции животноводства","value":"crop_production.column_index = 127 AND crop_production.full_cost_price"},
        {"text":"Полная себестоимость проданной продукции итого","value":"crop_production.column_index = 129 AND crop_production.full_cost_price"},
        {"text":"Выручено с продажи с продажи продукции растениеводства","value":"crop_production.column_index = 123 AND crop_production.bailed_out"},
        {"text":"Выручено с продажи с продажи продукции животноводства","value":"crop_production.column_index = 127 AND crop_production.bailed_out"},
        {"text":"Выручено с продажи с продажи продукции итого","value":"crop_production.column_index = 129 AND crop_production.bailed_out"}];

    let options6 = [{"text":"Затраты на оплату труда с отчислениями на социальные нужды","value":"expenses.labor_cost"},
        {"text":"Матеpиальные затpаты, вошедшие в себестоимость пpодукции","value":"expenses.material_costs"},
        {"text":"Коpма (всего)","value":"expenses.feed"},
        {"text":"Корма покупные","value":"expenses.purchased_feed"},
        {"text":"Амоpтизация основных сpедств и нематериальных активов","value":"expenses.deprecation"},
        {"text":"Страховые платежи","value":"expenses.insurance_payments"},
        {"text":"Пpочие затpаты","value":"expenses.other_costs"},
        {"text":"Итого затpат","value":"expenses.total_costs"},
        {"text":"Затраты по закладке и выращиванию молодых многолетних насаждений","value":"expenses.planting_costs"}];


    let options7 = [{"text":"Сбор зеpна в физической массе после доpаботки, всего","value":"grounds.products_index=140 AND grounds.total_products"},
        {"text":"Сбор зеpна в физической массе после доpаботки, с 1 га","value":"grounds.products_index=140 AND grounds.hectare_products"},
        {"text":"Себестоимость единицы продукции (зерно)","value":"grounds.products_index=140 AND grounds.production_cost"},
        {"text":"Сбор картофеля, всего","value":"grounds.products_index=143 AND grounds.total_products"},
        {"text":"Сбор картофеля, с 1 га","value":"grounds.products_index=143 AND grounds.hectare_products"},
        {"text":"Себестоимость единицы продукции (картофель)","value":"grounds.products_index=143 AND grounds.production_cost"},
        {"text":"Всего сельскохозяйственных угодий (гектары)","value":"grounds.products_index=140 AND grounds.hectare"},
        {"text":"Всего сельскохозяйственных угодий (баллогектары га)","value":"grounds.products_index=140 AND grounds.ballogectars"},
        {"text":"Пашня (гектары)","value":"grounds.products_index=143 AND grounds.hectare"},
        {"text":"Пашня (баллогектары га)","value":"grounds.products_index=143 AND grounds.ballogectars"},
        {"text":"КРС. Молочного направления основное стадо молочного скота","value":"dairy_products.cattle"},
        {"text":"Молоко тонн (Выход продукции количество)","value":"dairy_products.output_dairy_products"},
        {"text":"Молоко тонн (Себестоимость единицы продукции)","value":"dairy_products.cost_dairy_products"},
        {"text":"Пpиpост тонн (Выход продукции количество)","value":"dairy_products.production_growth"},
        {"text":"Пpиpост тонн (Себестоимость единицы продукции)","value":"dairy_products.production_cost_growth"},
        {"text":"Сpеднегодовой удой молока от одной коpовы","value":"cattle.milk_yield"},
        {"text":"Сpеднесуточный пpиpост кpупного pогатого скота - всего","value":"cattle.average_daily_increase"},
        {"text":"Коровы и быки-производители(кроме рабочего скота). Расход кормов на единицу продукции, кормо-единиц","value":"cattle.cattle_producers"},
        {"text":"Крупный рогатый скот на выpащивании и откоpме всего. Расход кормов на единицу продукции, кормо-единиц","value":"cattle.cattle_cultivation"}];

    var staffinfo = document.getElementsByClassName('country');
    var dynamicbutton = document.getElementById('showdynamic');

    document.getElementById('dynamiccat').onclick = function (event){
        if (document.getElementById('dynamiccat').value=='0'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options0.length; i++) {
                var opt = options0[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='1'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options1.length; i++) {
                var opt = options1[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='2'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options2.length; i++) {
                var opt = options2[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='3'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options3.length; i++) {
                var opt = options3[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='4'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options4.length; i++) {
                var opt = options4[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='5'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options5.length; i++) {
                var opt = options5[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='6'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options6.length; i++) {
                var opt = options6[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
        if (document.getElementById('dynamiccat').value=='7'){
            document.getElementById('dynamicparam').innerHTML='';
            for(var i = 0; i < options7.length; i++) {
                var opt = options7[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('dynamicparam').appendChild(el);
            }
        }
    };

    dynamicbutton.onclick = function (event){
        if (document.getElementsByClassName('single-content0')[0].hidden==true)
            document.getElementsByClassName('single-content0')[0].hidden=false;
        else
            document.getElementsByClassName('single-content0')[0].hidden=true;
    }

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
