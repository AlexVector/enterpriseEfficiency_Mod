package by.bsuir.diplom.controller.command.impl;

import by.bsuir.diplom.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class GrabbsTest implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response, File uploadFilePath) throws ServletException, IOException {
        System.out.println("Заглушка");
    }
}
