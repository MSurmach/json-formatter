package com.nocompany.controller;

import com.nocompany.formatter.Formatter;
import com.nocompany.formatter.FormatterSelector;
import com.nocompany.parser.Parser;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/process")
public class JsonServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String formContent = req.getParameter("json");
        String template = req.getParameter("template");
        Parser parser = new Parser(formContent);
        parser.parse();
        FormatterSelector selector = FormatterSelector.getFormatter();
        Formatter formatter = selector.getFormatter(template);
        String formattedJson = formatter.format(Parser.STORAGE);
        req.setAttribute("formattedJSON", formattedJson);
        ServletContext context = req.getServletContext();
        context.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
