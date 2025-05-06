package src.servlets;

import src.dao.CaseDAO;
import src.model.Case;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class ListCasesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Case> cases = new CaseDAO().getAllCases();
        request.setAttribute("cases", cases);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/listCases.jsp");
        dispatcher.forward(request, response);
        
    }
}