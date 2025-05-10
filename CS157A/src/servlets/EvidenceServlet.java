package src.servlets;

import src.dao.EvidenceDAO;
import src.model.Evidence;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/evidence/*")
public class EvidenceServlet extends HttpServlet {
    private EvidenceDAO evidenceDAO;

    public EvidenceServlet() {
        this.evidenceDAO = new EvidenceDAO();
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
                insertEvidence(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateEvidence(request, response);
                break;
            case "/delete":
                deleteEvidence(request, response);
                break;
            default:
                listEvidence(request, response);
                break;
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EvidenceForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        Evidence existingEvidence = evidenceDAO.selectEvidenceByID(evidenceID);
        request.setAttribute("Evidence", existingEvidence);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EvidenceForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String evidenceType = request.getParameter("evidenceType");
        LocalDate dateCollected = LocalDate.parse(request.getParameter("dateCollected"));

        Evidence evidence = new Evidence(evidenceID, title, description, evidenceType, dateCollected);
        evidenceDAO.insertEvidence(evidence);

        listEvidence(request, response);
    }

    private void updateEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String evidenceType = request.getParameter("evidenceType");
        LocalDate dateCollected = LocalDate.parse(request.getParameter("dateCollected"));

        Evidence evidence = new Evidence(evidenceID, title, description, evidenceType, dateCollected);
        evidenceDAO.updateEvidence(evidence);
        request.setAttribute("Evidence", evidence);

        listEvidence(request, response);
    }

    private void deleteEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        evidenceDAO.deleteEvidence(evidenceID);
        
        listEvidence(request, response);
    }

    private void listEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Evidence> evidenceList = evidenceDAO.selectEvidence();
        request.setAttribute("listEvidence", evidenceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EvidenceList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}