package src.servlets;

import src.dao.CaseDAO;
import src.model.Case;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCases")
public class ListCasesServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Case> cases = new CaseDAO().getAllCases();
        request.setAttribute("cases", cases);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/listCases.jsp");
        dispatcher.forward(request, response);
    }
}