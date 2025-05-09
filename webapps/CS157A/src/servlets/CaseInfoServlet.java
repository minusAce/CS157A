package src.servlets;

import src.dao.CaseDAO;
import src.model.CaseInfo;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


@WebServlet("/register")
public class CaseInfoServlet extends HttpServlet {
    private CaseDAO caseDAO;

    public void init() {
        caseDAO = new CaseDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoRegister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate dateOpened = LocalDate.parse(request.getParameter("dateOpened"));
        LocalDate dateClosed = LocalDate.parse(request.getParameter("dateClosed"));

        CaseInfo case1 = new CaseInfo();
        case1.setCaseID(caseID);
        case1.setTitle(title);
        case1.setDescription(description);
        case1.setDateOpened(dateOpened);
        case1.setDateClosed(dateClosed);

        try {
            caseDAO.registerCaseInfo(case1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoDetails.jsp");
        dispatcher.forward(request, response);
    }
}