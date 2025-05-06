package src.servlets;

import src.dao.CaseDAO;
import src.model.Case;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addCase")
public class AddCaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate opened = LocalDate.parse(request.getParameter("opened"));
        LocalDate closed = LocalDate.parse(request.getParameter("closed"));

        Case c = new Case(0, title, description, opened, closed);
        new CaseDAO().addCase(c);
        response.sendRedirect("jsp/listCases.jsp");
    }
}