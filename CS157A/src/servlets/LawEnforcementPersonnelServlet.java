package src.servlets;

import src.dao.LawEnforcementPersonnelDAO;
import src.model.LawEnforcementPersonnel;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/lawEnforcementPersonnel/*")
public class LawEnforcementPersonnelServlet extends HttpServlet {
    private LawEnforcementPersonnelDAO lawEnforcementPersonnelDAO;

    public LawEnforcementPersonnelServlet() {
        this.lawEnforcementPersonnelDAO = new LawEnforcementPersonnelDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/register":
                showRegisterForm(request, response);
                break;
            case "/insert":
                insertLawEnforcementPersonnel(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateLawEnforcementPersonnel(request, response);
                break;
            case "/delete":
                deleteLawEnforcementPersonnel(request, response);
                break;
            default:
                listLawEnforcementPersonnel(request, response);
                break;
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LawEnforcementPersonnelForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        LawEnforcementPersonnel lawEnforcementPersonnel = lawEnforcementPersonnelDAO.selectLawEnforcementPersonnelByID(personnelID);
        request.setAttribute("LawEnforcementPersonnel", lawEnforcementPersonnel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LawEnforcementPersonnelForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertLawEnforcementPersonnel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        LawEnforcementPersonnel lawEnforcementPersonnel = new LawEnforcementPersonnel(personnelID, name, role);
        lawEnforcementPersonnelDAO.insertLawEnforcementPersonnel(lawEnforcementPersonnel);

        listLawEnforcementPersonnel(request, response);
    }

    private void updateLawEnforcementPersonnel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        LawEnforcementPersonnel lawEnforcementPersonnel = new LawEnforcementPersonnel(personnelID, name, role);
        lawEnforcementPersonnelDAO.updateLawEnforcementPersonnel(lawEnforcementPersonnel);
        request.setAttribute("LawEnforcementPersonnel", lawEnforcementPersonnel);

        listLawEnforcementPersonnel(request, response);
    }

    private void deleteLawEnforcementPersonnel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        lawEnforcementPersonnelDAO.deleteLawEnforcementPersonnel(personnelID);
        listLawEnforcementPersonnel(request, response);
    }

    private void listLawEnforcementPersonnel(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<LawEnforcementPersonnel> lawEnforcementPersonnelList = lawEnforcementPersonnelDAO.selectLawEnforcementPersonnel();
        request.setAttribute("listLawEnforcementPersonnel", lawEnforcementPersonnelList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/LawEnforcementPersonnelList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}