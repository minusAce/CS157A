package src.servlets;

import src.dao.ChainOfCustodyDAO;
import src.model.ChainOfCustody;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/chainofcustody/*")
public class ChainOfCustodyServlet extends HttpServlet {
    private ChainOfCustodyDAO chainOfCustodyDAO;

    public ChainOfCustodyServlet() {
        this.chainOfCustodyDAO = new ChainOfCustodyDAO();
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
                insertChainOfCustody(request, response);
                break;
            case "/delete":
                deleteChainOfCustody(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateChainOfCustody(request, response);
                break;
            default:
                listChainOfCustody(request, response);
                break;
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ChainOfCustodyForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertChainOfCustody(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        LocalDateTime dateLogged = LocalDateTime.parse(request.getParameter("dateLogged"));
        ChainOfCustody chain = new ChainOfCustody(personnelID, evidenceID, dateLogged);
        chainOfCustodyDAO.insertChainOfCustody(chain);

        response.sendRedirect("list");
    }

    private void deleteChainOfCustody(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        LocalDateTime dateLogged = LocalDateTime.parse(request.getParameter("dateLogged"));
        chainOfCustodyDAO.deleteChainOfCustody(personnelID, evidenceID, dateLogged);

        response.sendRedirect("list");
    }

    private void listChainOfCustody(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ChainOfCustody> chainList = chainOfCustodyDAO.selectAllChains();
        request.setAttribute("listChainOfCustody", chainList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ChainOfCustodyList.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        LocalDateTime dateLogged = LocalDateTime.parse(request.getParameter("dateLogged"));

        ChainOfCustody chain = chainOfCustodyDAO.selectChainOfCustody(personnelID, evidenceID, dateLogged);
        request.setAttribute("ChainOfCustody", chain);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/ChainOfCustodyForm.jsp");
        dispatcher.forward(request, response);
    }

    private void updateChainOfCustody(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int personnelID = Integer.parseInt(request.getParameter("personnelID"));
        int evidenceID = Integer.parseInt(request.getParameter("evidenceID"));
        LocalDateTime dateLogged = LocalDateTime.parse(request.getParameter("dateLogged"));

        ChainOfCustody chain = new ChainOfCustody(personnelID, evidenceID, dateLogged);
        boolean isUpdated = chainOfCustodyDAO.updateChainOfCustody(chain);

        if (isUpdated) {
            request.setAttribute("message", "Chain of Custody updated successfully.");
        } else {
            request.setAttribute("error", "Failed to update Chain of Custody.");
        }

        listChainOfCustody(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}
