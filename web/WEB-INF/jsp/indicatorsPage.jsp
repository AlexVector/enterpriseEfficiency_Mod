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
    <style><%@include file="/resources/css/style.css"%></style>

    <script>
        var dynamicbutton = document.getElementById('showdynamic');
        dynamicbutton.onclick = function (event){
            if (document.getElementById('adv_searchpanel').hidden==true)
                document.getElementById('adv_searchpanel').hidden=false;
            else
                document.getElementById('adv_searchpanel').hidden=true;
        }
    </script>

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

<!-- Preloader Starts //
<div class="preloader">
    <div class="spinner"></div>
</div>
Preloader End -->

<!-- Start blog-posts Area -->
<div class="whole-wrap">
    <%--    <div class="container">--%>

        <button class="btn btn-primary mb-2 ml-5" id="showdynamic" type="button">Расширенный поиск</button>
        <div class="single-content1" id="adv_searchpanel" hidden>
            <div class="single-job d-lg-flex justify-content-between">
                <div class="job-text" style="width: 100%">
                    <h4>Расширенный поиск</h4>
                    <h5>Выберите степень сложности запроса:</h5>
                    <h5 class="ml-5"><input class="form-check-input" id="firstdiff" type="radio" name="difficult" checked>1 запрос&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="form-check-input" id="seconddiff" type="radio" name="difficult">2 запроса&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <input class="form-check-input" id="thirddiff" type="radio" name="difficult">3 запроса
                    </h5>
                    <form action="Controller" method="post">
                        <input class="form-control" type="hidden" name="command" value="advanced_search">
                        <div class="single-content1" id="diff1div" >
                            <div class="single-job d-lg-flex justify-content-between">
                                <div class="job-text">
                                    <ul>
                                        <li>
                                            <h5>Параметр:<br>
                                                <select class="form-control" name="parameter" id="param1">
                                                    <option selected disabled>Сначала выберите категорию...</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="statusli1">
                                            <h5>Статус:
                                                <select class="form-control" name="status" id="stat1">
                                                    <option selected disabled>Выберите статус...</option>
                                                    <option value="sort" id="sortoption1">Сортировать...</option>
                                                    <option value="morethan">Больше чем...</option>
                                                    <option value="lessthan">Меньше чем...</option>
                                                    <option value="equal">Равен...</option>
                                                    <option value="max" id="maxoption1">Максимальный</option>
                                                    <option value="min" id="minoption1">Минимальный</option>
                                                    <option value="isnull" id="isnulloption1">Отсутствует</option>
                                                    <option value="average" id="averageoption1">Среднее значение</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="typeli1" hidden>
                                            <h5>Тип:
                                                <select class="form-control" name="type" id="type1">
                                                    <option selected disabled value="0">Выберите тип сортировки...</option>
                                                    <option value="asc">По возрастанию</option>
                                                    <option value="desc">По убыванию</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="numli1" hidden><h5>Значение: <input class="form-control" id="number1" type="number" size="10" name="val" placeholder="Число"></h5></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="single-content1" id="diff2div" hidden>
                            <div class="single-job d-lg-flex justify-content-between">
                                <div class="job-text">
                                    <ul>
                                        <li><h5>Параметр:<br> <select class="form-control" name="parameter" id="param2">
                                            <option selected disabled>Сначала выберите категорию...</option>
                                        </select></h5></li>
                                        <li id="statusli2">
                                            <h5>Статус:
                                                <select class="form-control" name="status" id="stat2">
                                                    <option selected disabled>Выберите статус...</option>
                                                    <option value="sort" id="sortoption2">Сортировать...</option>
                                                    <option value="morethan">Больше чем...</option>
                                                    <option value="lessthan">Меньше чем...</option>
                                                    <option value="equal">Равен...</option>
                                                    <option value="max" id="maxoption2">Максимальный</option>
                                                    <option value="min" id="minoption2">Минимальный</option>
                                                    <option value="isnull" id="isnulloption2">Отсутствует</option>
                                                    <option value="average" id="averageoption2">Среднее значение</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="typeli2" hidden>
                                            <h5>Тип:
                                                <select class="form-control" name="type" id="type2">
                                                    <option selected disabled value="0">Выберите тип сортировки...</option>
                                                    <option value="asc">По возрастанию</option>
                                                    <option value="desc">По убыванию</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="numli2" hidden><h5>Значение: <input class="form-control" id="number2" type="number" size="10" name="val" placeholder="Число"></h5></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="single-content1" id="diff3div" hidden>
                            <div class="single-job d-lg-flex justify-content-between">
                                <div class="job-text">
                                    <ul>
                                        <li><h5>Параметр:<br> <select class="form-control" name="parameter" id="param3">
                                            <option selected disabled>Сначала выберите категорию...</option>
                                        </select></h5></li>
                                        <li id="statusli3">
                                            <h5>Статус:
                                                <select class="form-control" name="status" id="stat3">
                                                    <option selected disabled>Выберите статус...</option>
                                                    <option value="sort" id="sortoption3">Сортировать...</option>
                                                    <option value="morethan">Больше чем...</option>
                                                    <option value="lessthan">Меньше чем...</option>
                                                    <option value="equal">Равен...</option>
                                                    <option value="max" id="maxoption3">Максимальный</option>
                                                    <option value="min" id="minoption3">Минимальный</option>
                                                    <option value="isnull" id="isnulloption3">Отсутствует</option>
                                                    <option value="average" id="averageoption3">Среднее значение</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="typeli3" hidden>
                                            <h5>Тип:
                                                <select class="form-control" name="type" id="type3">
                                                    <option selected disabled value="0">Выберите тип сортировки...</option>
                                                    <option value="asc">По возрастанию</option>
                                                    <option value="desc">По убыванию</option>
                                                </select>
                                            </h5>
                                        </li>
                                        <li id="numli3" hidden><h5>Значение: <input class="form-control" id="number3" type="number" size="10" name="val" placeholder="Число"></h5></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <input class="btn btn-primary mb-2" type="submit">
                        <input class="btn mb-2" type="reset" id="resetbutton">
                    </form>
                </div>
            </div>
        </div>

    <div class="section-top-border">
        <div class="progress-table-wrap">
            <div class="progress-table">
                <table id="companiesTable" class="display">
                    <thead>
                    <tr class="table-head">
                        <th class="wd-120 table-head-indicator">${kodUnn}</th>
                        <th class="wd-120 table-head-indicator ">${profitFromSales}</th>
                        <th class="wd-120 table-head-indicator ">${netDiscountedValue}</th>
                        <th class="wd-120 table-head-indicator ">${costRecovery}</th>
                        <th class="wd-60 table-head-indicator ">${productionProfitability}</th>
                        <th class="wd-120 table-head-indicator ">${increasePerEmployed}</th>
                        <th class="wd-150 table-head-indicator ">${landGrowth}</th>
                        <c:if test="${sessionScope.user.role.value eq 2}">
                            <th class="visit"></th>
                        </c:if>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="company" items="${sessionScope.companiesIndicators}">
                        <tr class="table-row">
                            <td class="wd-120">
                                <h5>${company.ynn}</h5>
                            </td>
                            <td class="wd-120">
                                <h5>${company.profitFromSales}</h5>
                            </td>
                            <td class="wd-120">
                                <h5>${company.netDiscountedValue}</h5>
                            </td>
                            <td class="wd-120">
                                <h5>${company.costRecovery}</h5>
                            </td>
                            <td class="wd-60">
                                <h5>${company.productionProfitability}</h5>
                            </td>
                            <td class="wd-120">
                                <h5>${company.increasePerEmployed}</h5>
                            </td>
                            <td class="wd-150">
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
