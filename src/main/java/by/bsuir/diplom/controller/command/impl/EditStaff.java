package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Staff;
import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.ServiceProvider;
import by.bsuir.diplom.service.api.StaffService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

public class EditStaff implements Command {
    private static final Logger userLogger = LogManager.getLogger(EditStaff.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();

        int ynn = (int) session.getAttribute("editCompanyYnn");
        Integer staffId = Integer.valueOf(request.getParameter("staffId"));
        Integer editStaffIndex = Integer.valueOf(request.getParameter("editStaffIndex"));
        Integer editAverageNumber = null;
        if (request.getParameter("editAverageNumber") != null && !"".equals(request.getParameter("editAverageNumber"))) {
            editAverageNumber = Integer.valueOf(request.getParameter("editAverageNumber"));
        }
        Double editSalaryFund = null;
        if (request.getParameter("editSalaryFund") != null && !"".equals(request.getParameter("editSalaryFund"))) {
            editSalaryFund = Double.valueOf(request.getParameter("editSalaryFund"));
        }

        Staff staff = new Staff(staffId, ynn, editStaffIndex, editAverageNumber, editSalaryFund);

        StaffService service = ServiceProvider.getInstance().getStaffService();
        try {
            service.edit(staff);
            session.removeAttribute("editCompany");
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + ynn + "&message=message.editStaff.complete");
        } catch (ServiceException e) {
            userLogger.error(e);
            response.sendRedirect("Controller?command=go_to_edit_company_page&editCompanyYnn=" + ynn + "&message=message.edit.unsuccessfully");
        }
    }
}
