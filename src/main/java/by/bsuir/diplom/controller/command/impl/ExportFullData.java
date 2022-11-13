package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.bean.*;
import by.bsuir.diplom.controller.command.Command;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;

public class ExportFullData extends ExportTemplate implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Company> toExport = null;
        if (session.getAttribute("companiesList")!=null)
            toExport = (List<Company>) session.getAttribute("companiesList");
        export(toExport, response);
    }
}
