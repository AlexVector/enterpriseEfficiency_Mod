package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Address;
import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.bean.CompanyInfo;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.AddressService;
import by.bsuir.diplom.service.api.CompanyInfoService;
import by.bsuir.diplom.service.api.CompanyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class EditCompanyInfo implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditCompanyInfo.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Company company = (Company) session.getAttribute("editCompany");

        String editName = request.getParameter("editName");
        String editFullName = request.getParameter("editFullName");
        String editLocation = request.getParameter("editLocation");
        String editArea = request.getParameter("editArea");
        String editDistrict = request.getParameter("editDistrict");
        String editActivityType = request.getParameter("editActivityType");
        Integer editIndustryCode = Integer.valueOf(request.getParameter("editIndustryCode"));
        String editIndustryName = request.getParameter("editIndustryName");
        String editDepartmentName = request.getParameter("editDepartmentName");
        String editAssociationName = request.getParameter("editAssociationName");
        String editOwnershipType = request.getParameter("editOwnershipType");

        Address newAddress = new Address(company.getYnn(), editLocation, editArea, editDistrict);
        CompanyInfo newCompanyInfo = new CompanyInfo(company.getYnn(), editIndustryCode, editIndustryName, editDepartmentName, editAssociationName, editOwnershipType);
        Company newCompany = new Company(company.getYnn(), company.getId(), company.getOkpo(), editName, editFullName, company.getYear(), company.getPeriod(), editActivityType);

        CompanyService companyService = ServiceProvider.getInstance().getCompanyService();
        CompanyInfoService companyInfoService = ServiceProvider.getInstance().getCompanyInfoService();
        AddressService addressService = ServiceProvider.getInstance().getAddressService();

        try {
            companyService.edit(newCompany);
            companyInfoService.edit(newCompanyInfo);
            addressService.edit(newAddress);
            session.removeAttribute("editCompany");
            session.removeAttribute("companiesList");
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.editCompany.complete");
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.edit.unsuccessfully");
        }
    }
}
