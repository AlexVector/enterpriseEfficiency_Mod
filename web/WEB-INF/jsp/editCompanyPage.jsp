<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 18.05.2022
  Time: 5:03
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
    <fmt:message bundle="${loc}" key="edit.company.button" var="editCompanyButton"/>
    <fmt:message bundle="${loc}" key="label.signUp" var="signUpLabel"/>
    <fmt:message bundle="${loc}" key="edit.capital.button" var="editCapitalButton"/>
    <fmt:message bundle="${loc}" key="edit.coefficients.button" var="editCoefficientsButton"/>
    <fmt:message bundle="${loc}" key="edit.expenses.button" var="editExpensesButton"/>

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

    <fmt:message bundle="${loc}" key="page.editCompany" var="pageTitle"/>

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

<!-- Start Align Area -->
<c:choose>
    <c:when test="${sessionScope.user.role.value eq 1 and sessionScope.editCompany ne null}">
        <div class="whole-wrap">
            <div class="container">
                <div class="section-top-border">
                    <h3 class="mb-30 title_color">${companyInfo}</h3>
                    <div class="row">
                        <div class="col-lg-3 mb-5 mb-lg-0">
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${period}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${year}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${kodUnn}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${okpo}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${name}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <br>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${fullName}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <br><br><br><br><br>
                                    <h5>${address}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <br><br><br><br><br>
                                    <h5>${area}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${district}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${activityType}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${industryCode}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${industryName}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${departmentName}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${associationName}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${ownershipType}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8">
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="edit_company_info"/>
                                <div class="mt-10">
                                    <input type="text" name="period" placeholder="${sessionScope.editCompany.period}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.period}'" disabled
                                           onblur="this.placeholder = '${sessionScope.editCompany.period}'"
                                           value="${sessionScope.editCompany.period}"
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="year" maxlength="50"
                                           placeholder="${sessionScope.editCompany.year}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.year}'" disabled
                                           onblur="this.placeholder = '${sessionScope.editCompany.year}'"
                                           value="${sessionScope.editCompany.year}"
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="unn" placeholder="${sessionScope.editCompany.ynn}"
                                           disabled
                                           onfocus="this.placeholder = '${sessionScope.editCompany.ynn}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.ynn}'"
                                           value="${sessionScope.editCompany.ynn}"
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="okpo" placeholder="${sessionScope.editCompany.okpo}"
                                           disabled
                                           onfocus="this.placeholder = '${sessionScope.editCompany.okpo}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.okpo}'"
                                           value="${sessionScope.editCompany.okpo}"
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                            <textarea name="editName" placeholder="${sessionScope.editCompany.name}" maxlength="100"
                                      onfocus="this.placeholder = '${sessionScope.editCompany.name}'"
                                      onblur="this.placeholder = '${sessionScope.editCompany.name}'" required
                                      class="single-input"><c:out value="${sessionScope.editCompany.name}"/></textarea>
                                </div>
                                <div class="mt-10">
                            <textarea name="editFullName" class="single-textarea" maxlength="250"
                                      placeholder="${sessionScope.editCompany.fullName}"
                                      onfocus="this.placeholder = '${sessionScope.editCompany.fullName}'"
                                      onblur="this.placeholder = '${sessionScope.editCompany.fullName}'" required><c:out
                                    value="${sessionScope.editCompany.fullName}"/></textarea>
                                </div>
                                <div class="mt-10">
                            <textarea name="editLocation" class="single-textarea" maxlength="250"
                                      placeholder="${sessionScope.editCompany.address.location}"
                                      onfocus="this.placeholder = '${sessionScope.editCompany.address.location}'"
                                      onblur="this.placeholder = '${sessionScope.editCompany.address.location}'"><c:out
                                    value="${sessionScope.editCompany.address.location}"/></textarea>
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editArea"
                                           placeholder="${sessionScope.editCompany.address.area}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.address.area}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.address.area}'"
                                           value="${sessionScope.editCompany.address.area}"
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editDistrict"
                                           placeholder="${sessionScope.editCompany.address.district}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.address.district}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.address.district}'"
                                           value="${sessionScope.editCompany.address.district}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editActivityType"
                                           placeholder="${sessionScope.editCompany.activityType}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.activityType}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.activityType}'"
                                           value="${sessionScope.editCompany.activityType}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editIndustryCode" min="0" step="1"
                                           placeholder="${sessionScope.editCompany.companyInfo.industryCode}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.companyInfo.industryCode}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.companyInfo.industryCode}'"
                                           value="${sessionScope.editCompany.companyInfo.industryCode}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editIndustryName"
                                           placeholder="${sessionScope.editCompany.companyInfo.industryName}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.companyInfo.industryName}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.companyInfo.industryName}'"
                                           value="${sessionScope.editCompany.companyInfo.industryName}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editDepartmentName"
                                           placeholder="${sessionScope.editCompany.companyInfo.departmentName}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.companyInfo.departmentName}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.companyInfo.departmentName}'"
                                           value="${sessionScope.editCompany.companyInfo.departmentName}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editAssociationName"
                                           placeholder="${sessionScope.editCompany.companyInfo.associationName}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.companyInfo.associationName}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.companyInfo.associationName}'"
                                           value="${sessionScope.editCompany.companyInfo.associationName}" required
                                           class="single-input">
                                </div>
                                <div class="mt-10">
                                    <input type="text" name="editOwnershipType"
                                           placeholder="${sessionScope.editCompany.companyInfo.ownershipType}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.companyInfo.ownershipType}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.companyInfo.ownershipType}'"
                                           value="${sessionScope.editCompany.companyInfo.ownershipType}" required
                                           class="single-input">
                                </div>
                                <br>
                                <br>
                                <button type="submit" class="template-btn">${editCompanyButton}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <c:if test="${sessionScope.editCompany.staff ne null}">
            <div class="whole-wrap">
                <div class="container">
                    <div class="section-top-border">
                        <h3 class="mb-30 title_color">${staffLabel}</h3>
                        <div class="progress-table-wrap">
                            <div class="progress-table">
                                <div class="table-head">
                                    <div class="percentage">${staffLabel}</div>
                                    <div class="country">${averageNumber}</div>
                                    <div class="country">${salaryFund}</div>
                                    <div class="serial"></div>
                                </div>
                                <c:forEach var="staff" items="${sessionScope.editCompany.staff}">
                                    <form action="Controller" method="post" style="display: inherit">
                                        <input type="hidden" name="command" value="edit_staff"/>
                                        <input type="hidden" name="editStaffIndex" value="${staff.index}"/>
                                        <input type="hidden" name="staffId" value="${staff.id}"/>
                                        <input type="hidden" name="ynn" value="${sessionScope.editCompany.ynn}"/>
                                        <div class="table-row">
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
                                            <div class="country">
                                                <c:choose>
                                                    <c:when test="${staff.averageNumber eq null}">
                                                        <input type="number" name="editAverageNumber" min="1" step="1"
                                                               placeholder="${noInfo}"
                                                               onfocus="this.placeholder = '${noInfo}'"
                                                               onblur="this.placeholder = '${noInfo}'"
                                                               class="single-input">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="number" name="editAverageNumber" min="1" step="1"
                                                               placeholder="${staff.averageNumber}"
                                                               onfocus="this.placeholder = '${staff.averageNumber}'"
                                                               onblur="this.placeholder = '${staff.averageNumber}'"
                                                               class="single-input" value="${staff.averageNumber}">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="country">
                                                <c:choose>
                                                    <c:when test="${staff.salaryFund eq null}">
                                                        <input type="number" name="editSalaryFund" min="1" step="0.01"
                                                               placeholder="${noInfo}"
                                                               onfocus="this.placeholder = '${noInfo}'"
                                                               onblur="this.placeholder = '${noInfo}'"
                                                               class="single-input">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="number" name="editSalaryFund" min="1" step="0.01"
                                                               placeholder="${staff.salaryFund}"
                                                               onfocus="this.placeholder = '${staff.salaryFund}'"
                                                               onblur="this.placeholder = '${staff.salaryFund}'"
                                                               class="single-input" value="${staff.salaryFund}">
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="serial">
                                                <button type="submit">
                                                    <em class="fa fa-edit fa-1x"></em>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
    </c:when>
    <c:when test="${sessionScope.user.role.value eq 2 and sessionScope.editCompany ne null}">
        <div class="whole-wrap">
            <div class="container">
                <div class="section-top-border">
                    <h3 class="mb-30 title_color">${capital}</h3>
                    <div class="row">
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${fixedAssets}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${loansBorrowings}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${total4}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${shorttermDebt}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${total5}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${salesRevenue}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${profit}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${salesReturn}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${currentDividendPayments}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${prevDividendPayments}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${totalEndDebt}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${overdueEndDebt}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${totalBeginDebt}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${overdueBeginDebt}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${endNetAssets}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${beginNetAssets}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${currentEndBalance}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${prevEndBalance}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="edit_capital"/>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.fixedAssets.fixedAssets eq null}">
                                            <input type="number" name="editFixedAssets" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editFixedAssets" class="single-input"
                                                   placeholder="${sessionScope.editCompany.fixedAssets.fixedAssets}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.fixedAssets}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.fixedAssets}'"
                                                   value="${sessionScope.editCompany.fixedAssets.fixedAssets}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.fixedAssets.loansBorrowings eq null}">
                                            <input type="number" name="editLoansBorrowings" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editLoansBorrowings" class="single-input"
                                                   placeholder="${sessionScope.editCompany.fixedAssets.loansBorrowings}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.loansBorrowings}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.loansBorrowings}'"
                                                   value="${sessionScope.editCompany.fixedAssets.loansBorrowings}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.fixedAssets.total4 eq null}">
                                            <input type="number" name="editTotal4" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editTotal4" class="single-input"
                                                   placeholder="${sessionScope.editCompany.fixedAssets.total4}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.total4}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.total4}'"
                                                   value="${sessionScope.editCompany.fixedAssets.total4}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editShorttermDebt" class="single-input" required
                                           placeholder="${sessionScope.editCompany.fixedAssets.shorttermDebt}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.shorttermDebt}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.shorttermDebt}'"
                                           value="${sessionScope.editCompany.fixedAssets.shorttermDebt}">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editTotal5" class="single-input" required
                                           placeholder="${sessionScope.editCompany.fixedAssets.total5}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.total5}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.total5}'"
                                           value="${sessionScope.editCompany.fixedAssets.total5}">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editSalesRevenue" class="single-input" required
                                           placeholder="${sessionScope.editCompany.fixedAssets.salesRevenue}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.salesRevenue}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.salesRevenue}'"
                                           value="${sessionScope.editCompany.fixedAssets.salesRevenue}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.fixedAssets.profit eq null}">
                                            <input type="number" name="editProfit" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editProfit" class="single-input"
                                                   placeholder="${sessionScope.editCompany.fixedAssets.profit}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.fixedAssets.profit}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.fixedAssets.profit}'"
                                                   value="${sessionScope.editCompany.fixedAssets.profit}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.sales eq null}">
                                            <input type="number" name="editSales" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editSales" class="single-input" step="0.01"
                                                   placeholder="${sessionScope.editCompany.salesReturn.sales}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.sales}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.sales}'"
                                                   value="${sessionScope.editCompany.salesReturn.sales}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <p></p>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.currentDividendPayments eq null}">
                                            <input type="number" name="editCurrentDividendPayments" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editCurrentDividendPayments" class="single-input"
                                                   placeholder="${sessionScope.editCompany.salesReturn.currentDividendPayments}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.currentDividendPayments}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.currentDividendPayments}'"
                                                   value="${sessionScope.editCompany.salesReturn.currentDividendPayments}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.prevDividendPayments eq null}">
                                            <input type="number" name="editPrevDividendPayments" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editPrevDividendPayments" class="single-input"
                                                   placeholder="${sessionScope.editCompany.salesReturn.prevDividendPayments}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.prevDividendPayments}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.prevDividendPayments}'"
                                                   value="${sessionScope.editCompany.salesReturn.prevDividendPayments}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editTotalEndDebt" class="single-input" required
                                           placeholder="${sessionScope.editCompany.salesReturn.totalEndDebt}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.totalEndDebt}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.totalEndDebt}'"
                                           value="${sessionScope.editCompany.salesReturn.totalEndDebt}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.overdueEndDebt eq null}">
                                            <input type="number" name="editOverdueEndDebt" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editOverdueEndDebt" class="single-input"
                                                   placeholder="${sessionScope.editCompany.salesReturn.overdueEndDebt}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.overdueEndDebt}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.overdueEndDebt}'"
                                                   value="${sessionScope.editCompany.salesReturn.overdueEndDebt}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.totalBeginDebt eq null}">
                                            <input type="number" name="editTotalBeginDebt" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editTotalBeginDebt" class="single-input"
                                                   placeholder="${sessionScope.editCompany.salesReturn.totalBeginDebt}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.totalBeginDebt}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.totalBeginDebt}'"
                                                   value="${sessionScope.editCompany.salesReturn.totalBeginDebt}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.salesReturn.overdueBeginDebt eq null}">
                                            <input type="number" name="editOverdueBeginDebt" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editOverdueBeginDebt" class="single-input"
                                                   placeholder="${sessionScope.editCompany.salesReturn.overdueBeginDebt}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.salesReturn.overdueBeginDebt}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.salesReturn.overdueBeginDebt}'"
                                                   value="${sessionScope.editCompany.salesReturn.overdueBeginDebt}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editEndNetAssets" class="single-input" required
                                           placeholder="${sessionScope.editCompany.coefficients.endNetAssets}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.endNetAssets}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.coefficients.endNetAssets}'"
                                           value="${sessionScope.editCompany.coefficients.endNetAssets}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.coefficients.beginNetAssets eq null}">
                                            <input type="number" name="editBeginNetAssets" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editBeginNetAssets" class="single-input"
                                                   placeholder="${sessionScope.editCompany.coefficients.beginNetAssets}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.beginNetAssets}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.coefficients.beginNetAssets}'"
                                                   value="${sessionScope.editCompany.coefficients.beginNetAssets}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editCurrentEndBalance" class="single-input" required
                                           placeholder="${sessionScope.editCompany.cattle.currentEndBalance}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.cattle.currentEndBalance}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.cattle.currentEndBalance}'"
                                           value="${sessionScope.editCompany.cattle.currentEndBalance}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.cattle.prevEndBalance eq null}">
                                            <input type="number" name="editPrevEndBalance" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editPrevEndBalance" class="single-input"
                                                   placeholder="${sessionScope.editCompany.cattle.prevEndBalance}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.cattle.prevEndBalance}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.cattle.prevEndBalance}'"
                                                   value="${sessionScope.editCompany.cattle.prevEndBalance}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <br>
                                <br>
                                <button type="submit" class="template-btn">${editCapitalButton}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="whole-wrap">
            <div class="container">
                <div class="section-top-border">
                    <h3 class="mb-30 title_color">${coefficientsLabel}</h3>
                    <div class="row">
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${ownSecurityCoefficient}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${currentLiquidityCoefficient}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${financialSecurityCoefficient}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${absoluteLiquidityCoefficient}</h5>
                                    <p></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="edit_coefficients"/>
                                <div class="mt-10">
                                    <input type="number" name="editOwnSecurity" class="single-input" required step="0.01"
                                           placeholder="${sessionScope.editCompany.coefficients.ownSecurity}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.ownSecurity}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.coefficients.ownSecurity}'"
                                           value="${sessionScope.editCompany.coefficients.ownSecurity}">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editCurrentLiquidity" class="single-input" required step="0.01"
                                           placeholder="${sessionScope.editCompany.coefficients.currentLiquidity}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.currentLiquidity}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.coefficients.currentLiquidity}'"
                                           value="${sessionScope.editCompany.coefficients.currentLiquidity}">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editFinancialSecurity" class="single-input" required step="0.01"
                                           placeholder="${sessionScope.editCompany.coefficients.financialSecurity}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.financialSecurity}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.coefficients.financialSecurity}'"
                                           value="${sessionScope.editCompany.coefficients.financialSecurity}">
                                </div>
                                <p></p>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.coefficients.absoluteLiquidity eq null}">
                                            <input type="number" name="editAbsoluteLiquidity" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'" step="0.01"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editAbsoluteLiquidity" class="single-input" step="0.01"
                                                   placeholder="${sessionScope.editCompany.coefficients.absoluteLiquidity}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.coefficients.absoluteLiquidity}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.coefficients.absoluteLiquidity}'"
                                                   value="${sessionScope.editCompany.coefficients.absoluteLiquidity}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <br>
                                <br>
                                <button type="submit" class="template-btn">${editCoefficientsButton}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="whole-wrap">
            <div class="container">
                <div class="section-top-border">
                    <h3 class="mb-30 title_color">${expensesLabel}</h3>
                    <div class="row">
                        <div class="col-lg-6 mb-5 mb-lg-0">
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${laborCost}</h5>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${materialCost}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${feed}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${purchasedFeed}</h5>
                                    <p></p>
                                </div>
                            </div>
                            <div class="d-flex">
                                <div class="info-text">
                                    <p></p>
                                    <h5>${deprecation}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${insurancePayments}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${otherCosts}</h5>
                                </div>
                            </div>
                            <br>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${totalCosts}</h5>
                                </div>
                            </div>
                            <p></p>
                            <div class="d-flex">
                                <div class="info-text">
                                    <h5>${plantingCosts}</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-6">
                            <form action="Controller" method="post">
                                <input type="hidden" name="command" value="edit_expenses"/>
                                <div class="mt-10">
                                    <input type="number" name="editLaborCost" class="single-input" required
                                           placeholder="${sessionScope.editCompany.expenses.laborCost}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.expenses.laborCost}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.expenses.laborCost}'"
                                           value="${sessionScope.editCompany.expenses.laborCost}">
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editMaterialCosts" class="single-input" required
                                           placeholder="${sessionScope.editCompany.expenses.materialCosts}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.expenses.materialCosts}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.expenses.materialCosts}'"
                                           value="${sessionScope.editCompany.expenses.materialCosts}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.feed eq null}">
                                            <input type="number" name="editFeed" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editFeed" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.feed}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.feed}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.feed}'"
                                                   value="${sessionScope.editCompany.expenses.feed}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.purchasedFeed eq null}">
                                            <input type="number" name="editPurchasedFeed" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editPurchasedFeed" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.purchasedFeed}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.purchasedFeed}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.purchasedFeed}'"
                                                   value="${sessionScope.editCompany.expenses.purchasedFeed}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.deprecation eq null}">
                                            <input type="number" name="editDeprecation" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editDeprecation" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.deprecation}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.deprecation}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.deprecation}'"
                                                   value="${sessionScope.editCompany.expenses.deprecation}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.insurancePayments eq null}">
                                            <input type="number" name="editInsurancePayments" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editInsurancePayments" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.insurancePayments}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.insurancePayments}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.insurancePayments}'"
                                                   value="${sessionScope.editCompany.expenses.insurancePayments}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.otherCosts eq null}">
                                            <input type="number" name="editOtherCosts" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editOtherCosts" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.otherCosts}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.otherCosts}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.otherCosts}'"
                                                   value="${sessionScope.editCompany.expenses.otherCosts}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <div class="mt-10">
                                    <input type="number" name="editTotalCosts" class="single-input" required
                                           placeholder="${sessionScope.editCompany.expenses.totalCosts}"
                                           onfocus="this.placeholder = '${sessionScope.editCompany.expenses.totalCosts}'"
                                           onblur="this.placeholder = '${sessionScope.editCompany.expenses.totalCosts}'"
                                           value="${sessionScope.editCompany.expenses.totalCosts}">
                                </div>
                                <div class="mt-10">
                                    <c:choose>
                                        <c:when test="${sessionScope.editCompany.expenses.plantingCosts eq null}">
                                            <input type="number" name="editPlantingCosts" placeholder="${noInfo}"
                                                   onfocus="this.placeholder = '${noInfo}'"
                                                   onblur="this.placeholder = '${noInfo}'" class="single-input">
                                        </c:when>
                                        <c:otherwise>
                                            <input type="number" name="editPlantingCosts" class="single-input"
                                                   placeholder="${sessionScope.editCompany.expenses.plantingCosts}"
                                                   onfocus="this.placeholder = '${sessionScope.editCompany.expenses.plantingCosts}'"
                                                   onblur="this.placeholder = '${sessionScope.editCompany.expenses.plantingCosts}'"
                                                   value="${sessionScope.editCompany.expenses.plantingCosts}">
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <br>
                                <br>
                                <button type="submit" class="template-btn">${editExpensesButton}</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:when>
</c:choose>
<!-- End Align Area -->

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>
</body>
</html>
