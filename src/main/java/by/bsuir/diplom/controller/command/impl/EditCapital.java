package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.*;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.CattleService;
import by.bsuir.diplom.service.api.CoefficientsService;
import by.bsuir.diplom.service.api.FixedAssetsService;
import by.bsuir.diplom.service.api.SalesReturnService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class EditCapital implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditCapital.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Company company = (Company) session.getAttribute("editCompany");

        Integer editFixedAssets = null;
        if (request.getParameter("editFixedAssets") != null && !"".equals(request.getParameter("editFixedAssets"))) {
            editFixedAssets = Integer.valueOf(request.getParameter("editFixedAssets"));
        }
        Integer editLoansBorrowings = null;
        if (request.getParameter("editLoansBorrowings") != null && !"".equals(request.getParameter("editLoansBorrowings"))) {
            editLoansBorrowings = Integer.valueOf(request.getParameter("editLoansBorrowings"));
        }
        Integer editTotal4 = null;
        if (request.getParameter("editTotal4") != null && !"".equals(request.getParameter("editTotal4"))) {
            editTotal4 = Integer.valueOf(request.getParameter("editTotal4"));
        }
        Integer editShorttermDebt = Integer.valueOf(request.getParameter("editShorttermDebt"));
        Integer editTotal5 = Integer.valueOf(request.getParameter("editTotal5"));
        Integer editSalesRevenue = Integer.valueOf(request.getParameter("editSalesRevenue"));

        Integer editProfit = null;
        if (request.getParameter("editProfit") != null && !"".equals(request.getParameter("editProfit"))) {
            editProfit = Integer.valueOf(request.getParameter("editProfit"));
        }
        Double editSales = null;
        if (request.getParameter("editSales") != null && !"".equals(request.getParameter("editSales"))) {
            editSales = Double.valueOf(request.getParameter("editSales"));
        }
        Integer editCurrentDividendPayments = null;
        if (request.getParameter("editCurrentDividendPayments") != null && !"".equals(request.getParameter("editCurrentDividendPayments"))) {
            editCurrentDividendPayments = Integer.valueOf(request.getParameter("editCurrentDividendPayments"));
        }
        Integer editPrevDividendPayments = null;
        if (request.getParameter("editPrevDividendPayments") != null && !"".equals(request.getParameter("editPrevDividendPayments"))) {
            editPrevDividendPayments = Integer.valueOf(request.getParameter("editPrevDividendPayments"));
        }
        Integer editTotalEndDebt = Integer.valueOf(request.getParameter("editTotalEndDebt"));

        Integer editOverdueEndDebt = null;
        if (request.getParameter("editOverdueEndDebt") != null && !"".equals(request.getParameter("editOverdueEndDebt"))) {
            editOverdueEndDebt = Integer.valueOf(request.getParameter("editOverdueEndDebt"));
        }
        Integer editTotalBeginDebt = null;
        if (request.getParameter("editTotalBeginDebt") != null && !"".equals(request.getParameter("editTotalBeginDebt"))) {
            editTotalBeginDebt = Integer.valueOf(request.getParameter("editTotalBeginDebt"));
        }
        Integer editOverdueBeginDebt = null;
        if (request.getParameter("editOverdueBeginDebt") != null && !"".equals(request.getParameter("editOverdueBeginDebt"))) {
            editOverdueBeginDebt = Integer.valueOf(request.getParameter("editOverdueBeginDebt"));
        }
        Integer editEndNetAssets = Integer.valueOf(request.getParameter("editEndNetAssets"));

        Integer editBeginNetAssets = null;
        if (request.getParameter("editBeginNetAssets") != null && !"".equals(request.getParameter("editBeginNetAssets"))) {
            editBeginNetAssets = Integer.valueOf(request.getParameter("editBeginNetAssets"));
        }
        Integer editCurrentEndBalance = Integer.valueOf(request.getParameter("editCurrentEndBalance"));

        Integer editPrevEndBalance = null;
        if (request.getParameter("editPrevEndBalance") != null && !"".equals(request.getParameter("editPrevEndBalance"))) {
            editPrevEndBalance = Integer.valueOf(request.getParameter("editPrevEndBalance"));
        }
        FixedAssets fixedAssets = new FixedAssets(company.getYnn(), editFixedAssets, editLoansBorrowings, editTotal4,
                editShorttermDebt, editTotal5, editSalesRevenue, editProfit);
        SalesReturn salesReturn = new SalesReturn(company.getYnn(), editSales, editCurrentDividendPayments,
                editPrevDividendPayments, editTotalEndDebt, editOverdueEndDebt, editTotalBeginDebt, editOverdueBeginDebt);
        Coefficients coefficients = company.getCoefficients();
        coefficients.setEndNetAssets(editEndNetAssets);
        coefficients.setBeginNetAssets(editBeginNetAssets);
        Cattle cattle = company.getCattle();
        cattle.setCurrentEndBalance(editCurrentEndBalance);
        cattle.setPrevEndBalance(editPrevEndBalance);

        FixedAssetsService fixedAssetsService = ServiceProvider.getInstance().getFixedAssetsService();
        SalesReturnService salesReturnService = ServiceProvider.getInstance().getSalesReturnService();
        CoefficientsService coefficientsService = ServiceProvider.getInstance().getCoefficientsService();
        CattleService cattleService = ServiceProvider.getInstance().getCattleService();

        try {
            fixedAssetsService.edit(fixedAssets);
            salesReturnService.edit(salesReturn);
            coefficientsService.edit(coefficients);
            cattleService.edit(cattle);
            session.removeAttribute("editCompany");
            session.removeAttribute("companiesList");
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.editCapital.complete");
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + company.getYnn() + "&message=message.edit.unsuccessfully");
        }
    }
}
