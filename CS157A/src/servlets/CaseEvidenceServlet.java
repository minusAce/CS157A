package src.servlets;

import src.dao.CaseEvidenceDAO;
import src.model.CaseEvidence;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/caseevidence/*")
public class CaseEvidenceServlet extends HttpServlet {
    private CaseEvidenceDAO caseEvidenceDAO;

    public CaseEvidenceServlet() {
        this.caseEvidenceDAO = new CaseEvidenceDAO();
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
                insertCaseEvidence(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCaseEvidence(request, response);
                break;
            case "/delete":
                deleteCaseEvidence(request, response);
                break;
            default:
                listCaseEvidence(request, response);
                break;
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseEvidenceForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        CaseEvidence existingCaseEvidence = caseEvidenceDAO.selectCaseEvidenceByID(caseID);
        request.setAttribute("CaseEvidence", existingCaseEvidence);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseEvidenceForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCaseEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        CaseEvidence caseEvidence = new CaseEvidence(caseID, evidenceID);
        caseEvidenceDAO.insertCaseEvidence(caseEvidence);

        listCaseEvidence(request, response);
    }

    private void updateCaseEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        CaseEvidence caseEvidence = new CaseEvidence(caseID, evidenceID);
        caseEvidenceDAO.updateCaseEvidence(caseEvidence);

        listCaseEvidence(request, response);
    }

    private void deleteCaseEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        caseEvidenceDAO.deleteCaseEvidence(caseID);

        listCaseEvidence(request, response);
    }

    private void listCaseEvidence(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CaseEvidence> caseEvidenceList = caseEvidenceDAO.selectCaseEvidence();
        request.setAttribute("listCaseEvidence", caseEvidenceList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseEvidenceList.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}

