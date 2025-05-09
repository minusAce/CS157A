package src.servlets;

import src.dao.EvidenceDAO;
import src.model.Evidence;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/logEvidence")
public class EvidenceServlet extends HttpServlet {

    private EvidenceDAO evidenceDAO;

    public void init() {
        evidenceDAO = new EvidenceDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        response.getWriter().append("Served at: ").append(request.getContextPath());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EvidenceRegister.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String evidenceType = request.getParameter("evidenceType");
        LocalDate dateCollected = LocalDate.parse(request.getParameter("dateCollected"));
        String evidenceImage = request.getParameter("evidenceImage");

        Evidence evidence = new Evidence();
        evidence.setEvidenceID(evidenceID);
        evidence.setTitle(title);
        evidence.setDescription(description);
        evidence.setEvidenceType(evidenceType);
        evidence.setDateCollected(dateCollected);
        evidence.setEvidenceImage(evidenceImage);

        try {
            evidenceDAO.registerEvidence(evidence);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/EvidenceDetails.jsp");
        dispatcher.forward(request, response);

    }
}
