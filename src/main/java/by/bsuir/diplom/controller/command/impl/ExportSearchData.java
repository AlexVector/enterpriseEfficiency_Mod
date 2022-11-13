package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.Company;
import by.bsuir.diplom.controller.command.Command;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

public class ExportSearchData extends ExportTemplate implements Command{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Company> toExport = null;
        if (session.getAttribute("advSearchCompanies")!=null)
            toExport = (List<Company>) session.getAttribute("advSearchCompanies");
        export(toExport, response);
    }
}
