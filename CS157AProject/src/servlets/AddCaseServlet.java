package src.servlets;

import src.dao.CaseDAO;
import src.model.Case;

import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

public class AddCaseServlet extends HttpServlet {
    // Handle GET requests to display the form
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Forward the request to addCase.jsp
        request.getRequestDispatcher("/jsp/addCase.jsp").forward(request, response);
    }

    // Handle POST requests to process the form submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate opened = LocalDate.parse(request.getParameter("opened"));
        LocalDate closed = LocalDate.parse(request.getParameter("closed"));

        // Create a new Case object
        Case c = new Case(0, title, description, opened, closed);

        // Add the case to the database
        new CaseDAO().addCase(c);

        // Redirect to the list of cases
        response.sendRedirect("listCases");  // or forward to another page
    }
}
