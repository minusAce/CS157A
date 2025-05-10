package src.servlets;

import src.dao.CaseDAO;
import src.model.CaseInfo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/caseinfo/*")
public class CaseInfoServlet extends HttpServlet {
    private CaseDAO caseDAO;

    public CaseInfoServlet() {
        this.caseDAO = new CaseDAO();
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
                insertCaseInfo(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateCaseInfo(request, response);
                break;
            case "/select":
                break;
            case "/delete":
                deleteCaseInfo(request, response);
                break;
            case "/search":
                    searchCaseInfo(request, response);
                    break;
            default:
                listCaseInfo(request, response);
                break;
        }
    }

    private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        CaseInfo existingCaseInfo = caseDAO.selectCaseInfoByID(caseID);
        request.setAttribute("CaseInfo", existingCaseInfo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertCaseInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate dateOpened = LocalDate.parse(request.getParameter("dateOpened"));
        LocalDate dateClosed = LocalDate.parse(request.getParameter("dateClosed"));
        CaseInfo case1 = new CaseInfo(caseID, title, description, dateOpened, dateClosed);
        caseDAO.insertCaseInfo(case1);

        listCaseInfo(request, response);
    }

    private void updateCaseInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        LocalDate dateOpened = LocalDate.parse(request.getParameter("dateOpened"));
        LocalDate dateClosed = LocalDate.parse(request.getParameter("dateClosed"));
        CaseInfo case1 = new CaseInfo(caseID, title, description, dateOpened, dateClosed);
        caseDAO.updateCaseInfo(case1);
        request.setAttribute("CaseInfo", case1);

        listCaseInfo(request, response);
    }

    private void deleteCaseInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int caseID = Integer.parseInt(request.getParameter("caseID"));
        caseDAO.deleteCaseInfo(caseID);

        listCaseInfo(request, response);
    }

    private void listCaseInfo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<CaseInfo> caseInfoList = caseDAO.selectCaseInfo();
        request.setAttribute("listCaseInfo", caseInfoList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoList.jsp");
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    private void searchCaseInfo(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    String keyword = request.getParameter("keyword");
    List<CaseInfo> results = caseDAO.searchByTitle(keyword);
    request.setAttribute("listCaseInfo", results);
    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/CaseInfoList.jsp");
    dispatcher.forward(request, response);
}

}