package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Expenses;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.ExpensesService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class EditExpenses implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditExpenses.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        Integer ynn = (Integer) session.getAttribute("editCompanyYnn");
        Integer editLaborCost = Integer.valueOf(request.getParameter("editLaborCost"));
        Integer editMaterialCosts = Integer.valueOf(request.getParameter("editMaterialCosts"));
        Integer editFeed = null;
        if (request.getParameter("editFeed") != null && !"".equals(request.getParameter("editFeed"))) {
            editFeed = Integer.valueOf(request.getParameter("editFeed"));
        }
        Integer editPurchasedFeed = null;
        if (request.getParameter("editPurchasedFeed") != null && !"".equals(request.getParameter("editPurchasedFeed"))) {
            editPurchasedFeed = Integer.valueOf(request.getParameter("editPurchasedFeed"));
        }
        Integer editDeprecation = null;
        if (request.getParameter("editDeprecation") != null && !"".equals(request.getParameter("editDeprecation"))) {
            editDeprecation = Integer.valueOf(request.getParameter("editDeprecation"));
        }
        Integer editInsurancePayments = null;
        if (request.getParameter("editInsurancePayments") != null && !"".equals(request.getParameter("editInsurancePayments"))) {
            editInsurancePayments = Integer.valueOf(request.getParameter("editInsurancePayments"));
        }
        Integer editOtherCosts = null;
        if (request.getParameter("editOtherCosts") != null && !"".equals(request.getParameter("editOtherCosts"))) {
            editOtherCosts = Integer.valueOf(request.getParameter("editOtherCosts"));
        }
        Integer editTotalCosts = Integer.valueOf(request.getParameter("editTotalCosts"));
        Integer editPlantingCosts = null;
        if (request.getParameter("editPlantingCosts") != null && !"".equals(request.getParameter("editPlantingCosts"))) {
            editPlantingCosts = Integer.valueOf(request.getParameter("editPlantingCosts"));
        }

        Expenses expenses = new Expenses(ynn, editLaborCost, editMaterialCosts, editFeed, editPurchasedFeed,
                editDeprecation, editInsurancePayments, editOtherCosts, editTotalCosts, editPlantingCosts);
        ExpensesService expensesService = ServiceProvider.getInstance().getExpensesService();

        try {
            expensesService.edit(expenses);
            session.removeAttribute("editCompany");
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + ynn + "&message=message.editCompany.complete");
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + ynn + "&message=message.edit.unsuccessfully");
        }
    }
}
