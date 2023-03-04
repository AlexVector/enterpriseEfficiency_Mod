<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 02.10.2021
  Time: 22:35
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
                    <%--My modification--%>
                    <c:when test="${sessionScope.advSearchCompanies ne null || sessionScope.advSearchResult ne null}">
                        <h2>Результаты запроса:</h2>
                    </c:when>
                    <%--My modification--%>
                    <c:when test="${sessionScope.filterArea ne null}">
                        <h2>${areaMessage}</h2>
                    </c:when>
                    <c:when test="${sessionScope.filterDistrict ne null}">
                        <h2>${districtMessage}</h2>
                    </c:when>
                    <c:when test="${empty sessionScope.companiesList}">
                        <h2>${emptyCompanies}</h2>
                        <p>${emptyCompaniesContinue}</p>
                        <c:if test="${sessionScope.user ne null}">
                            <div class="whole-wrap">
                                <div class="container">
                                    <div class="section-top-border">
                                        <div class="row">
                                            <div class="col-lg-3 mb-5 mb-lg-0">
                                                <br>
                                                <div class="d-flex">
                                                    <div class="info-text">
                                                        <h5>${excelLabel}</h5>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-8">
                                                <form action="Controller" method="post" enctype="multipart/form-data">
                                                    <input type="hidden" name="command" value="import_data"/>
                                                    <input class="mt-10" type="file" name="importFile"
                                                           accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet">
                                                    <br>
                                                    <br>
                                                    <button type="submit" class="template-btn">${importButton}</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:if>
                    </c:when>
                </c:choose>
            </div>
        </div>
    </div>
</div>
<!-- Page Title End -->

<!-- Start blog-posts Area -->
<c:choose>
    <c:when test="${not empty sessionScope.companiesList}">
        <%--My modification--%>
        <section class="job-single-content">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="main-content">

                            <button class="btn btn-primary mb-2" id="showanomaly" type="button">Поиск аномалий</button>
                            <div class="single-content1" id="anomalypanel" hidden>
                                <div class="single-job d-lg-flex justify-content-between">
                                    <div class="job-text" style="width: 100%">
                                        <h4>Поиск аномалий</h4>
                                        <form action="Controller" method="post">
                                            <input class="form-control" type="hidden" name="command" value="anomalies_search">
                                            <h5>Выберите зону поиска:</h5>
                                            <h5 class="ml-5"><input class="form-check-input" id="allanomalies" type="radio" name="anomaly" value="all" checked>По всем параметрам&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input class="form-check-input" id="oneanomaly" type="radio" name="anomaly" value="one">По выбранному параметру&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            </h5>
                                            <div class="single-content1" id="oneanomalysearchpanel" hidden>
                                                <div class="single-job d-lg-flex justify-content-between">
                                                    <div class="job-text">
                                                        <ul>
                                                            <li>
                                                                <h5>Категория:
                                                                    <select class="form-control" name="anomcat" id="anomcat">
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
                                                            <li>
                                                                <h5>Параметр:<br>
                                                                    <select class="form-control" name="anomparam" id="anomparam">
                                                                        <option selected disabled>Сначала выберите категорию...</option>
                                                                    </select>
                                                                </h5>
                                                            </li>
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

                            <button class="btn btn-primary mb-2" id="showdynamic" type="button">Расширенный поиск</button>
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
                                                                <h5>Категория:
                                                                    <select class="form-control" name="category" id="cat1">
                                                                        <option selected disabled>Выберите категорию...</option>
                                                                        <option value="0">Текстовая информация</option>
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
                                                                    </select>
                                                                </h5>
                                                            </li>
                                                            <li id="textvalueli1" hidden><h5>Текстовое значение: <input class="form-control" id="textvalue1" type="text" size="30" name="text_value" placeholder="Текст"></h5></li>
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
                                                            <li>
                                                                <h5>Категория:
                                                                    <select class="form-control" name="category" id="cat2">
                                                                        <option selected disabled>Выберите категорию...</option>
                                                                        <option value="0">Текстовая информация</option>
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
                                                                    </select>
                                                                </h5>
                                                            </li>
                                                            <li id="textvalueli2" hidden><h5>Текстовое значение: <input class="form-control" id="textvalue2" type="text" size="30" name="text_value" placeholder="Текст"></h5></li>
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
                                                            <li>
                                                                <h5>Категория:
                                                                    <select class="form-control" name="category" id="cat3">
                                                                        <option selected disabled>Выберите категорию...</option>
                                                                        <option value="0">Текстовая информация</option>
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
                                                                    </select>
                                                                </h5>
                                                            </li>
                                                            <li id="textvalueli3" hidden><h5>Текстовое значение: <input class="form-control" id="textvalue3" type="text" size="30" name="text_value" placeholder="Текст"></h5></li>
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
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%--My modification--%>

        <section class="blog-posts-area section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <table id="companiesTable" class="display">
                            <thead>
                            <tr class="table-head">
                                <th class="serial">${kodUnn}</th>
                                <th class="serial">${okpo}</th>
                                <th class="country">${name}</th>
                                <th class="percentage">${fullName}</th>
                                <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                    <th class="visit"></th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="company" items="${sessionScope.companiesList}">
                                <tr class="table-row">
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.ynn}</h5></a>
                                    </td>
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.okpo}</h5></a>
                                    </td>
                                    <td class="country"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.name}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.fullName}</h5></a>
                                    </td>
                                    <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                        <td class="visit">
                                            <button type="button">
                                                <a href="Controller?command=go_to_edit_company_page&editCompanyYnn=${company.ynn}"
                                                   style="color: #0b2e13">
                                                    <em class="fa fa-edit fa-1x"></em></a></button>
                                            <form action="Controller" method="post" style="display: inherit">
                                                <input type="hidden" name="command" value="delete_company">
                                                <input type="hidden" name="deleteCompanyYnn" value="${company.ynn}">
                                                <div class="serial">
                                                    <button type="submit">
                                                        <em class="fa fa-close fa-1x"></em>
                                                    </button>
                                                </div>
                                            </form>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-3 sidebar">


                            <%--My modification--%>
                        <div style="display: flex; flex-direction: row; justify-content: flex-start">
                            <form action="Controller" method="post" style="margin-right:3px">
                                <input type="hidden" name="command" value="export_full_data"/>
                                <button type="submit" class="mb-2"><img class="btn pb-2" src="<c:url value="/resources/images/icons8-export-excel-48.png"/>" alt="Кнопка" title="Выгрузить данные в Excel"></button>
                            </form>
                            <c:if test="${sessionScope.user.role.value eq 0}">
                                <form name="drop_data_form" action="Controller" method="post" style="margin-right:3px">
                                    <input type="hidden" name="command" value="drop_data"/>
                                    <button type="submit" class="mb-2"><img class="btn pb-2" src="<c:url value="/resources/images/icons8-delete-48.png"/>" alt="Кнопка" title="Удаление данных"></button>
                                </form>
                            </c:if>
                        </div>
                            <%--My modification--%>


                        <c:if test="${sessionScope.locationMap ne null}">
                            <div class="single-widget category-widget">
                                <h4 class="title">${areas}</h4>
                                <ul class="top">
                                    <c:forEach var="area" items="${sessionScope.locationMap.keySet()}">
                                        <li>
                                            <a href="Controller?command=filter_by_location&filterArea=${area}"
                                               class="justify-content-between align-items-center d-flex">
                                                <h6>${area}</h6>
                                            </a>
                                            <ul class="sub">
                                                <c:forEach var="district" items="${sessionScope.locationMap.get(area)}">
                                                    <li>
                                                        <a href="Controller?command=filter_by_location&filterDistrict=${district}"
                                                           class="justify-content-between align-items-center d-flex">
                                                            <h6>${district}</h6>
                                                        </a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>
    </c:when>
    <c:when test="${not empty sessionScope.filterCompanies}">
        <section class="blog-posts-area section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <table id="filterCompaniesTable" class="display">
                            <thead>
                            <tr class="table-head">
                                <th class="serial">${kodUnn}</th>
                                <th class="serial">${okpo}</th>
                                <th class="country">${name}</th>
                                <th class="percentage">${fullName}</th>
                                <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                    <th class="visit"></th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="company" items="${sessionScope.filterCompanies}">
                                <tr class="table-row">
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.ynn}</h5></a>
                                    </td>
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.okpo}</h5></a>
                                    </td>
                                    <td class="country"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.name}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.fullName}</h5></a>
                                    </td>
                                    <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                        <td class="visit">
                                            <button type="button">
                                                <a href="Controller?command=go_to_edit_company_page&editCompanyYnn=${company.ynn}"
                                                   style="color: #0b2e13">
                                                    <em class="fa fa-edit fa-1x"></em></a></button>
                                            <form action="Controller" method="post" style="display: inherit">
                                                <input type="hidden" name="command" value="delete_company">
                                                <input type="hidden" name="deleteCompanyYnn" value="${company.ynn}">
                                                <div class="serial">
                                                    <button type="submit">
                                                        <em class="fa fa-close fa-1x"></em>
                                                    </button>
                                                </div>
                                            </form>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-3 sidebar">
                        <c:if test="${sessionScope.locationMap ne null}">
                            <div class="single-widget category-widget">
                                <h4 class="title">${areas}</h4>
                                <ul class="top">
                                    <c:forEach var="area" items="${sessionScope.locationMap.keySet()}">
                                        <li>
                                            <a href="Controller?command=filter_by_location&filterArea=${area}"
                                               class="justify-content-between align-items-center d-flex">
                                                <h6>${area}</h6>
                                            </a>
                                            <ul class="sub">
                                                <c:forEach var="district" items="${sessionScope.locationMap.get(area)}">
                                                    <li>
                                                        <a href="Controller?command=filter_by_location&filterDistrict=${district}"
                                                           class="justify-content-between align-items-center d-flex">
                                                            <h6>${district}</h6>
                                                        </a>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </section>
    </c:when>
    <%--My modification--%>
    <c:when test="${not empty sessionScope.advSearchCompanies}">
        <section class="blog-posts-area section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <table id="filterCompaniesTable" class="display" data-order=''>
                            <thead>
                            <tr class="table-head">
                                <th class="serial">${kodUnn}</th>
                                <th class="serial">${okpo}</th>
                                <th class="country">${name}</th>
                                <th class="percentage">${fullName}</th>
                                <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                    <th class="visit"></th>
                                </c:if>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="company" items="${sessionScope.advSearchCompanies}">
                                <tr class="table-row">
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.ynn}</h5></a>
                                    </td>
                                    <td class="serial"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.okpo}</h5></a>
                                    </td>
                                    <td class="country"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.name}</h5></a>
                                    </td>
                                    <td class="percentage"><a
                                            href="Controller?command=go_to_company_page&companyYnn=${company.ynn}">
                                        <h5>${company.fullName}</h5></a>
                                    </td>
                                    <c:if test="${sessionScope.user.role.value eq 1 or sessionScope.user.role.value eq 2}">
                                        <td class="visit">
                                            <button type="button">
                                                <a href="Controller?command=go_to_edit_company_page&editCompanyYnn=${company.ynn}"
                                                   style="color: #0b2e13">
                                                    <em class="fa fa-edit fa-1x"></em></a></button>
                                            <form action="Controller" method="post" style="display: inherit">
                                                <input type="hidden" name="command" value="delete_company">
                                                <input type="hidden" name="deleteCompanyYnn" value="${company.ynn}">
                                                <div class="serial">
                                                    <button type="submit">
                                                        <em class="fa fa-close fa-1x"></em>
                                                    </button>
                                                </div>
                                            </form>
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                        <%--My modification--%>
                    <div class="col-lg-3 sidebar">
                        <form action="Controller" method="post">
                            <input type="hidden" name="command" value="export_search_data"/>
                            <button type="submit" class="mb-2"><img class="btn pb-2" src="<c:url value="/resources/images/icons8-export-excel-48.png"/>" alt="Кнопка" title="Выгрузить данные в Excel"></button>
                        </form>
                    </div>
                        <%--My modification--%>
                </div>
            </div>
        </section>
    </c:when>

    <c:when test="${not empty sessionScope.advSearchResult}">
        <section class="blog-posts-area section-padding">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <h2>${sessionScope.advSearchResult}</h2>
                    </div>
                </div>
            </div>
        </section>
    </c:when>

    <%--My modification--%>
</c:choose>

<div id="wrapper"></div>

<!-- Footer Area -->
<c:import url="parts/footer.jsp"/>

<script>

    var diff1 = document.getElementById('firstdiff');
    var diff2 = document.getElementById('seconddiff');
    var diff3 = document.getElementById('thirddiff');
    var divfordiff1 = document.getElementById('diff1div');
    var divfordiff2 = document.getElementById('diff2div');
    var divfordiff3 = document.getElementById('diff3div');
    var category1 = document.getElementById('cat1');
    var category2 = document.getElementById('cat2');
    var category3 = document.getElementById('cat3');
    var param1 = document.getElementById('param1');
    var param2 = document.getElementById('param2');
    var param3 = document.getElementById('param3');
    var stat1 = document.getElementById('stat1');
    var stat2 = document.getElementById('stat2');
    var stat3 = document.getElementById('stat3');
    var num1 = document.getElementById('number1');
    var num2 = document.getElementById('number2');
    var num3 = document.getElementById('number3');
    var textval1 = document.getElementById('textvalue1');
    var textval2 = document.getElementById('textvalue2');
    var textval3 = document.getElementById('textvalue3');
    //В parameters2 разобраться с чистой прибылью

    let options0 = [{"text":"Наименование","value":"company.name"},
        {"text":"Полное наименование","value":"company.full_name"},
        {"text":"Адрес","value":"address.address"},
        {"text":"Вид деятельности","value":"company.activity_type"},
        {"text":"Наименование района","value":"address.district"},
        {"text":"Наименование области","value":"address.area"},
        {"text":"Наименование отрасли","value":"company_info.industry_name"},
        {"text":"Наименование управления","value":"company_info.department_name"},
        {"text":"Наименование объединения","value":"company_info.association_name"},
        {"text":"Наименование вида собственности","value":"company_info.ownership_type"}];

    let options1 = [{"text":"Код ОКПО","value":"company.okpo"},
        {"text":"Код УНН","value":"company.ynn"},
        {"text":"Код отрасли","value":"company_info.industry_code"},
        {"text":"Уровень рентабельности, %","value":"coefficients.profitability"},
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



    var anomalydinbutton = document.getElementById('showanomaly');
    anomalydinbutton.onclick = function (event){
        if (document.getElementById('anomalypanel').hidden==true)
            document.getElementById('anomalypanel').hidden=false;
        else
            document.getElementById('anomalypanel').hidden=true;
    };



    document.getElementById('oneanomaly').onclick = function(event) {
        document.getElementById('oneanomalysearchpanel').hidden = false;
    };
    document.getElementById('allanomalies').onclick = function (event) {
        document.getElementById('oneanomalysearchpanel').hidden = true;
    };


    document.getElementById('showdynamic').onclick = function (event){
        if (document.getElementById('adv_searchpanel').hidden==true)
            document.getElementById('adv_searchpanel').hidden=false;
        else
            document.getElementById('adv_searchpanel').hidden=true;
    };

    //для аномалий сделать кастомные options без текстовой информации, кодов унн, окпо и отрасли

    document.getElementById('anomcat').onclick = function (event){
        if (document.getElementById('anomcat').value=='1'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options1.length; i++) {
                var opt = options1[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='2'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options2.length; i++) {
                var opt = options2[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='3'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options3.length; i++) {
                var opt = options3[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='4'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options4.length; i++) {
                var opt = options4[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='5'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options5.length; i++) {
                var opt = options5[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='6'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options6.length; i++) {
                var opt = options6[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
        if (document.getElementById('anomcat').value=='7'){
            document.getElementById('anomparam').innerHTML='';
            for(var i = 0; i < options7.length; i++) {
                var opt = options7[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                document.getElementById('anomparam').appendChild(el);
            }
        }
    };




    //Нужно доработать
    document.getElementById('resetbutton').onclick = function (event){
        //var opt = 'Сначала выберите категорию...';
        //var el = document.createElement("option");
        //el.textContent = opt;
        //el.value = '';
        //el.selected = true;
        //el.disabled = true;
        param1.innerHTML = '';
        param2.innerHTML = '';
        param3.innerHTML = '';
        //param1.appendChild(el);
        //param2.appendChild(el);
        //param3.appendChild(el);
    };//Нужно доработать



    let sortOption = new Option("Сортировать...", "sort");
    let sortopselected = false;
    let min_max_null_average_option_selected = false;
    stat1.addEventListener("change", function() {
        if (min_max_null_average_option_selected == true){
            document.getElementById('minoption1').disabled = true;
            document.getElementById('maxoption1').disabled = true;
            document.getElementById('isnulloption1').disabled = true;
            document.getElementById('averageoption1').disabled = true;
            document.getElementById('sortoption1').disabled = true;
        }
        else{
            document.getElementById('minoption1').disabled = false;
            document.getElementById('maxoption1').disabled = false;
            document.getElementById('isnulloption1').disabled = false;
            document.getElementById('averageoption1').disabled = false;
            document.getElementById('sortoption1').disabled = false;
        }
        if ((stat1.value == 'min') || (stat1.value == 'max') || (stat1.value == 'isnull') || (stat1.value == 'average')){
            min_max_null_average_option_selected = true;
            document.getElementById('minoption2').disabled = true;
            document.getElementById('maxoption2').disabled = true;
            document.getElementById('isnulloption2').disabled = true;
            document.getElementById('averageoption2').disabled = true;
            document.getElementById('sortoption2').disabled = true;
            document.getElementById('minoption3').disabled = true;
            document.getElementById('maxoption3').disabled = true;
            document.getElementById('isnulloption3').disabled = true;
            document.getElementById('averageoption3').disabled = true;
            document.getElementById('sortoption3').disabled = true;
        }
        else {
            if ((stat2.value == 'min') || (stat2.value == 'max') || (stat2.value == 'isnull') || (stat2.value == 'average')){
                min_max_null_average_option_selected = true;
                document.getElementById('minoption1').disabled = true;
                document.getElementById('maxoption1').disabled = true;
                document.getElementById('isnulloption1').disabled = true;
                document.getElementById('averageoption1').disabled = true;
                document.getElementById('sortoption1').disabled = true;
                document.getElementById('minoption3').disabled = true;
                document.getElementById('maxoption3').disabled = true;
                document.getElementById('isnulloption3').disabled = true;
                document.getElementById('averageoption3').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if ((stat3.value == 'min') || (stat3.value == 'max') || (stat3.value == 'isnull') || (stat3.value == 'average')){
                    min_max_null_average_option_selected = true;
                    document.getElementById('minoption1').disabled = true;
                    document.getElementById('maxoption1').disabled = true;
                    document.getElementById('isnulloption1').disabled = true;
                    document.getElementById('averageoption1').disabled = true;
                    document.getElementById('sortoption1').disabled = true;
                    document.getElementById('minoption2').disabled = true;
                    document.getElementById('maxoption2').disabled = true;
                    document.getElementById('isnulloption2').disabled = true;
                    document.getElementById('averageoption2').disabled = true;
                    document.getElementById('sortoption2').disabled = true;
                }
                else{
                    min_max_null_average_option_selected = false;
                    document.getElementById('minoption1').disabled = false;
                    document.getElementById('maxoption1').disabled = false;
                    document.getElementById('isnulloption1').disabled = false;
                    document.getElementById('averageoption1').disabled = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('minoption2').disabled = false;
                    document.getElementById('maxoption2').disabled = false;
                    document.getElementById('isnulloption2').disabled = false;
                    document.getElementById('averageoption2').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('minoption3').disabled = false;
                    document.getElementById('maxoption3').disabled = false;
                    document.getElementById('isnulloption3').disabled = false;
                    document.getElementById('averageoption3').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });
    stat2.addEventListener("change", function() {
        if (min_max_null_average_option_selected == true){
            document.getElementById('minoption2').disabled = true;
            document.getElementById('maxoption2').disabled = true;
            document.getElementById('isnulloption2').disabled = true;
            document.getElementById('averageoption2').disabled = true;
            document.getElementById('sortoption2').disabled = true;
        }
        else{
            document.getElementById('minoption2').disabled = false;
            document.getElementById('maxoption2').disabled = false;
            document.getElementById('isnulloption2').disabled = false;
            document.getElementById('averageoption2').disabled = false;
            document.getElementById('sortoption2').disabled = false;
        }
        if ((stat2.value == 'min') || (stat2.value == 'max') || (stat2.value == 'isnull')  || (stat2.value == 'average')){
            min_max_null_average_option_selected = true;
            document.getElementById('minoption1').disabled = true;
            document.getElementById('maxoption1').disabled = true;
            document.getElementById('isnulloption1').disabled = true;
            document.getElementById('averageoption1').disabled = true;
            document.getElementById('sortoption1').disabled = true;
            document.getElementById('minoption3').disabled = true;
            document.getElementById('maxoption3').disabled = true;
            document.getElementById('isnulloption3').disabled = true;
            document.getElementById('averageoption3').disabled = true;
            document.getElementById('sortoption3').disabled = true;
        }
        else {
            if ((stat1.value == 'min') || (stat1.value == 'max') || (stat1.value == 'isnull')  || (stat1.value == 'average')){
                min_max_null_average_option_selected = true;
                document.getElementById('minoption2').disabled = true;
                document.getElementById('maxoption2').disabled = true;
                document.getElementById('isnulloption2').disabled = true;
                document.getElementById('averageoption2').disabled = true;
                document.getElementById('sortoption2').disabled = true;
                document.getElementById('minoption3').disabled = true;
                document.getElementById('maxoption3').disabled = true;
                document.getElementById('isnulloption3').disabled = true;
                document.getElementById('averageoption3').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if ((stat3.value == 'min') || (stat3.value == 'max') || (stat3.value == 'isnull')  || (stat3.value == 'average')){
                    min_max_null_average_option_selected = true;
                    document.getElementById('minoption1').disabled = true;
                    document.getElementById('maxoption1').disabled = true;
                    document.getElementById('isnulloption1').disabled = true;
                    document.getElementById('averageoption1').disabled = true;
                    document.getElementById('sortoption1').disabled = true;
                    document.getElementById('minoption2').disabled = true;
                    document.getElementById('maxoption2').disabled = true;
                    document.getElementById('isnulloption2').disabled = true;
                    document.getElementById('averageoption2').disabled = true;
                    document.getElementById('sortoption2').disabled = true;
                }
                else{
                    min_max_null_average_option_selected = false;
                    document.getElementById('minoption1').disabled = false;
                    document.getElementById('maxoption1').disabled = false;
                    document.getElementById('isnulloption1').disabled = false;
                    document.getElementById('averageoption1').disabled = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('minoption2').disabled = false;
                    document.getElementById('maxoption2').disabled = false;
                    document.getElementById('isnulloption2').disabled = false;
                    document.getElementById('averageoption2').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('minoption3').disabled = false;
                    document.getElementById('maxoption3').disabled = false;
                    document.getElementById('isnulloption3').disabled = false;
                    document.getElementById('averageoption3').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });
    stat3.addEventListener("change", function() {
        if (min_max_null_average_option_selected == true){
            document.getElementById('minoption3').disabled = true;
            document.getElementById('maxoption3').disabled = true;
            document.getElementById('isnulloption3').disabled = true;
            document.getElementById('averageoption3').disabled = true;
            document.getElementById('sortoption3').disabled = true;
        }
        else{
            document.getElementById('minoption3').disabled = false;
            document.getElementById('maxoption3').disabled = false;
            document.getElementById('isnulloption3').disabled = false;
            document.getElementById('averageoption3').disabled = false;
            document.getElementById('sortoption3').disabled = false;
        }
        if ((stat3.value == 'min') || (stat3.value == 'max') || (stat3.value == 'isnull') || (stat3.value == 'average')){
            min_max_null_average_option_selected = true;
            document.getElementById('minoption1').disabled = true;
            document.getElementById('maxoption1').disabled = true;
            document.getElementById('isnulloption1').disabled = true;
            document.getElementById('averageoption1').disabled = true;
            document.getElementById('sortoption1').disabled = true;
            document.getElementById('minoption2').disabled = true;
            document.getElementById('maxoption2').disabled = true;
            document.getElementById('isnulloption2').disabled = true;
            document.getElementById('averageoption2').disabled = true;
            document.getElementById('sortoption2').disabled = true;
        }
        else {
            if ((stat1.value == 'min') || (stat1.value == 'max') || (stat1.value == 'isnull')){
                min_max_null_average_option_selected = true;
                document.getElementById('minoption2').disabled = true;
                document.getElementById('maxoption2').disabled = true;
                document.getElementById('isnulloption2').disabled = true;
                document.getElementById('averageoption2').disabled = true;
                document.getElementById('sortoption2').disabled = true;
                document.getElementById('minoption3').disabled = true;
                document.getElementById('maxoption3').disabled = true;
                document.getElementById('isnulloption3').disabled = true;
                document.getElementById('averageoption3').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if ((stat2.value == 'min') || (stat2.value == 'max') || (stat2.value == 'isnull') || (stat2.value == 'average')){
                    min_max_null_average_option_selected = true;
                    document.getElementById('minoption2').disabled = true;
                    document.getElementById('maxoption2').disabled = true;
                    document.getElementById('isnulloption2').disabled = true;
                    document.getElementById('averageoption2').disabled = true;
                    document.getElementById('sortoption2').disabled = true;
                    document.getElementById('minoption3').disabled = true;
                    document.getElementById('maxoption3').disabled = true;
                    document.getElementById('isnulloption3').disabled = true;
                    document.getElementById('averageoption3').disabled = true;
                    document.getElementById('sortoption3').disabled = true;
                }
                else{
                    min_max_null_average_option_selected = false;
                    document.getElementById('minoption1').disabled = false;
                    document.getElementById('maxoption1').disabled = false;
                    document.getElementById('isnulloption1').disabled = false;
                    document.getElementById('averageoption1').disabled = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('minoption2').disabled = false;
                    document.getElementById('maxoption2').disabled = false;
                    document.getElementById('isnulloption2').disabled = false;
                    document.getElementById('averageoption2').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('minoption3').disabled = false;
                    document.getElementById('maxoption3').disabled = false;
                    document.getElementById('isnulloption3').disabled = false;
                    document.getElementById('averageoption3').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });
    stat1.addEventListener("change", function() {
        if (sortopselected == true)
            document.getElementById('sortoption1').disabled = true;
        else
            document.getElementById('sortoption1').disabled = false;
        if (stat1.value == 'sort'){
            sortopselected = true;
            document.getElementById('sortoption2').disabled = true;
            document.getElementById('sortoption3').disabled = true;
        }
        else {
            if (stat2.value == 'sort'){
                sortopselected = true;
                document.getElementById('sortoption1').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if (stat3.value == 'sort'){
                    sortopselected = true;
                    document.getElementById('sortoption1').disabled = true;
                    document.getElementById('sortoption2').disabled = true;
                }
                else{
                    sortopselected = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });
    stat2.addEventListener("change", function() {
        if (sortopselected == true)
            document.getElementById('sortoption2').disabled = true;
        else
            document.getElementById('sortoption2').disabled = false;
        if (stat2.value == 'sort'){
            sortopselected = true;
            document.getElementById('sortoption1').disabled = true;
            document.getElementById('sortoption3').disabled = true;
        }
        else {
            if (stat1.value == 'sort'){
                sortopselected = true;
                document.getElementById('sortoption2').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if (stat3.value == 'sort'){
                    sortopselected = true;
                    document.getElementById('sortoption1').disabled = true;
                    document.getElementById('sortoption2').disabled = true;
                }
                else{
                    sortopselected = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });
    stat3.addEventListener("change", function() {
        if (sortopselected == true)
            document.getElementById('sortoption3').disabled = true;
        else
            document.getElementById('sortoption3').disabled = false;
        if (stat3.value == 'sort'){
            sortopselected = true;
            document.getElementById('sortoption1').disabled = true;
            document.getElementById('sortoption2').disabled = true;
        }
        else {
            if (stat1.value == 'sort'){
                sortopselected = true;
                document.getElementById('sortoption2').disabled = true;
                document.getElementById('sortoption3').disabled = true;
            }
            else {
                if (stat2.value == 'sort'){
                    sortopselected = true;
                    document.getElementById('sortoption1').disabled = true;
                    document.getElementById('sortoption3').disabled = true;
                }
                else{
                    sortopselected = false;
                    document.getElementById('sortoption1').disabled = false;
                    document.getElementById('sortoption2').disabled = false;
                    document.getElementById('sortoption3').disabled = false;
                }
            }
        }
    });


    /*
    stat1.onclick = function (event) {
        else {
            sortOption.id = 'sortoption2';
            stat2.append(sortOption);
            sortOption.id = 'sortoption3';
            stat3.append(sortOption);
        }

    };
    stat2.onclick = function (event) {
        if (sortopselected == true){
            document.getElementById('sortoption2').style.display='none';
        }
        if ((stat2.value == 'sort')){
            sortopselected = true;
            document.getElementById('sortoption1').style.display='none';
            document.getElementById('sortoption3').style.display='none';
        }

        else {
            sortOption.id = 'sortoption2';
            stat2.append(sortOption);
            sortOption.id = 'sortoption3';
            stat3.append(sortOption);
        }

    };
    stat3.onclick = function (event) {
        if (sortopselected == true){
            document.getElementById('sortoption3').style.display='none';
        }
        if ((stat3.value == 'sort')){
            sortopselected = true;
            document.getElementById('sortoption1').style.display='none';
            document.getElementById('sortoption2').style.display='none';
        }

        else {
            sortOption.id = 'sortoption2';
            stat2.append(sortOption);
            sortOption.id = 'sortoption3';
            stat3.append(sortOption);
        }

    };
    */


    category1.onclick = function (event){
        textval1.value='';
        num1.value='';
        if (category1.value=='0'){
            document.getElementById("statusli1").hidden=true;
            document.getElementById("typeli1").hidden=true;
            document.getElementById("numli1").hidden=true;
            document.getElementById("textvalueli1").hidden=false;

            stat1.value = 'morethan';<%--Костыль--%>

            param1.innerHTML='';
            for(var i = 0; i < options0.length; i++) {
                var opt = options0[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='1'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options1.length; i++) {
                var opt = options1[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='2'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options2.length; i++) {
                var opt = options2[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='3'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options3.length; i++) {
                var opt = options3[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='4'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options4.length; i++) {
                var opt = options4[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='5'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options5.length; i++) {
                var opt = options5[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='6'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options6.length; i++) {
                var opt = options6[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
        if (category1.value=='7'){
            document.getElementById("statusli1").hidden=false;
            document.getElementById("textvalueli1").hidden=true;
            param1.innerHTML='';
            for(var i = 0; i < options7.length; i++) {
                var opt = options7[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param1.appendChild(el);
            }
        }
    };
    category2.onclick = function (event){
        textval2.value='';
        num2.value='';
        if (category2.value=='0'){
            document.getElementById("statusli2").hidden=true;
            document.getElementById("typeli2").hidden=true;
            document.getElementById("numli2").hidden=true;
            document.getElementById("textvalueli2").hidden=false;
            param2.innerHTML='';
            stat2.value = 'morethan';<%--Костыль--%>
            for(var i = 0; i < options0.length; i++) {
                var opt = options0[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='1'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options1.length; i++) {
                var opt = options1[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='2'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options2.length; i++) {
                var opt = options2[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='3'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options3.length; i++) {
                var opt = options3[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='4'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options4.length; i++) {
                var opt = options4[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='5'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options5.length; i++) {
                var opt = options5[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='6'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options6.length; i++) {
                var opt = options6[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
        if (category2.value=='7'){
            document.getElementById("statusli2").hidden=false;
            document.getElementById("textvalueli2").hidden=true;
            param2.innerHTML='';
            for(var i = 0; i < options7.length; i++) {
                var opt = options7[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param2.appendChild(el);
            }
        }
    };
    category3.onclick = function (event){
        textval3.value='';
        num3.value='';
        if (category3.value=='0'){
            document.getElementById("statusli3").hidden=true;
            document.getElementById("typeli3").hidden=true;
            document.getElementById("numli3").hidden=true;
            document.getElementById("textvalueli3").hidden=false;
            param3.innerHTML='';
            stat3.value = 'morethan';<%--Костыль--%>
            for(var i = 0; i < options0.length; i++) {
                var opt = options0[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='1'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options1.length; i++) {
                var opt = options1[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='2'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options2.length; i++) {
                var opt = options2[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='3'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options3.length; i++) {
                var opt = options3[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='4'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options4.length; i++) {
                var opt = options4[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='5'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options5.length; i++) {
                var opt = options5[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='6'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options6.length; i++) {
                var opt = options6[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
        if (category3.value=='7'){
            document.getElementById("statusli3").hidden=false;
            document.getElementById("textvalueli3").hidden=true;
            param3.innerHTML='';
            for(var i = 0; i < options7.length; i++) {
                var opt = options7[i];
                var el = document.createElement("option");
                el.text = opt.text;
                el.value = opt.value;
                param3.appendChild(el);
            }
        }
    };


    stat1.onclick = function (event) {
        document.getElementById('type1').value = '0';
        num1.value = '';
        if (stat1.value == 'sort'){
            document.getElementById('typeli1').hidden = false;
            document.getElementById('numli1').hidden = true;
        }
        if ((stat1.value == 'morethan') || (stat1.value == 'lessthan') || (stat1.value == 'equal')){
            document.getElementById('typeli1').hidden = true;
            document.getElementById('numli1').hidden = false;
        }
        if ((stat1.value == 'max') || (stat1.value == 'min') || (stat1.value == 'isnull')){
            document.getElementById('typeli1').hidden = true;
            document.getElementById('numli1').hidden = true;
        }
    };
    stat2.onclick = function (event) {
        document.getElementById('type2').value = '0';
        num2.value = '';
        if (stat2.value == 'sort'){
            document.getElementById('typeli2').hidden = false;
            document.getElementById('numli2').hidden = true;
        }
        if ((stat2.value == 'morethan') || (stat2.value == 'lessthan') || (stat2.value == 'equal')){
            document.getElementById('typeli2').hidden = true;
            document.getElementById('numli2').hidden = false;
        }
        if ((stat2.value == 'max') || (stat2.value == 'min') || (stat2.value == 'isnull')){
            document.getElementById('typeli2').hidden = true;
            document.getElementById('numli2').hidden = true;
        }
    };
    stat3.onclick = function (event) {
        document.getElementById('type3').value = '0';
        num3.value = '';
        if (stat3.value == 'sort'){
            document.getElementById('typeli3').hidden = false;
            document.getElementById('numli3').hidden = true;
        }
        if ((stat3.value == 'morethan') || (stat3.value == 'lessthan') || (stat3.value == 'equal')){
            document.getElementById('typeli3').hidden = true;
            document.getElementById('numli3').hidden = false;
        }
        if ((stat3.value == 'max') || (stat3.value == 'min') || (stat3.value == 'isnull')){
            document.getElementById('typeli3').hidden = true;
            document.getElementById('numli3').hidden = true;
        }
    };



    diff1.onclick = function(event) {
        divfordiff2.hidden = true;
        divfordiff3.hidden = true;
    };
    diff2.onclick = function(event) {
        divfordiff2.hidden = false;
        divfordiff3.hidden = true;
    };
    diff3.onclick = function(event) {
        divfordiff2.hidden = false;
        divfordiff3.hidden = false;
    };

    //может вызвать ошибку за счет того, что элемент есть только у администратора. ОСТАВЛЯТЬ В КОНЦЕ СКРИПТА
    if (document.getElementsByName('drop_data_form') != null){
        document.getElementsByName('drop_data_form')[0].onsubmit = function (e) {
            result = prompt('Вы собираетесь удалить все существующие в системе записи. Введите "Подтвердить" и подтвердите удаление данных.');
            if (result!=='Подтвердить') {
                e.preventDefault();
                alert('Удаление данных отменено!');
            }
        };
    }
</script>

</body>
</html>
