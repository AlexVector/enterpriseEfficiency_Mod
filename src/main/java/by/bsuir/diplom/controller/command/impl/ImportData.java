package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.controller.command.Command;
import by.bsuir.diplom.service.ServiceException;
import by.bsuir.diplom.service.excel.Reader;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImportData implements Command {
    private static final Logger userLogger = LogManager.getLogger(ImportData.class);

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("companiesList");

        Object fileObject = request.getAttribute("importFile");
        FileItem fileItem = (FileItem) fileObject;

        // Get file name from uploaded file and trim path from it.
        // Some browsers (e.g. IE, Opera) also sends the path, which is completely irrelevant.
        String fileName = FilenameUtils.getName(fileItem.getName());

        // Prepare filename prefix and suffix for an unique filename in upload folder.
        String prefix = FilenameUtils.getBaseName(fileName) + "_";
        String suffix = "." + FilenameUtils.getExtension(fileName);
        File file = null;
        try {
            // Prepare unique local file based on file name of uploaded file.
            file = File.createTempFile(prefix, suffix, uploadFilePath);
            Files.delete(Paths.get(file.getPath()));
            // Write uploaded file to local file.
            fileItem.write(file);
        } catch (Exception e) {
            // Can be thrown by uniqueFile() and FileItem#write().
            userLogger.fatal(e);
        }

        if (file != null) {
            Reader reader = new Reader();
            try {
                reader.read(file.getAbsolutePath());
                response.sendRedirect("Controller?command=go_to_home_page&message=message.import.complete");
            } catch (ServiceException e) {
                userLogger.error(e);
                if(e.getMessage().contains("NumberFormatException")){
                    response.sendRedirect("Controller?command=go_to_home_page&message=message.import.complete");
                }else {
                    response.sendRedirect("Controller?command=go_to_home_page&message=message.import.unsuccessfully");
                }
            }
        } else {
            response.sendRedirect("Controller?command=go_to_home_page&message=message.import.unsuccessfully");
        }
    }
}
