package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Coefficients;
import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CoefficientsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class EditCoefficients implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditCoefficients.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Company company = (Company) session.getAttribute("editCompany");
        Double editOwnSecurity = Double.valueOf(request.getParameter("editOwnSecurity"));
        Double editCurrentLiquidity = Double.valueOf(request.getParameter("editCurrentLiquidity"));
        Double editFinancialSecurity = Double.valueOf(request.getParameter("editFinancialSecurity"));
        Double editAbsoluteLiquidity = null;
        if (request.getParameter("editAbsoluteLiquidity") != null && !"".equals(request.getParameter("editAbsoluteLiquidity"))) {
            editAbsoluteLiquidity = Double.valueOf(request.getParameter("editAbsoluteLiquidity"));
        }

        Coefficients coefficients = new Coefficients(company.getYnn(), editOwnSecurity, editCurrentLiquidity,
                editFinancialSecurity, editAbsoluteLiquidity, company.getCoefficients().getEndNetAssets(),
                company.getCoefficients().getBeginNetAssets(), company.getCoefficients().getProfitability(),
                company.getCoefficients().getProfitabilityWithoutSupport());
        CoefficientsService coefficientsService = ServiceProvider.getInstance().getCoefficientsService();
        try {
            coefficientsService.edit(coefficients);
            session.removeAttribute("editCompany");
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.editCoefficients.complete");
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.edit.unsuccessfully");
        }
    }
}
