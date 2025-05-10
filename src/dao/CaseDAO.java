package src.dao;

import src.model.CaseInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CaseDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/forensics";
    private final String jdbcUser = "root";
    private final String jdbcPass = "admin";
    private static final String INSERT_CASEINFO_SQL = "INSERT INTO CaseInfo"
            + " (caseID, title, description, dateOpened, dateClosed) VALUES "
            + " (?, ?, ?, ?, ?);";
    private static final String SELECT_CASEINFO_SQL = "SELECT * FROM CaseInfo";
    private static final String SELECT_CASEINFO_BY_ID_SQL = "SELECT * FROM CaseInfo WHERE caseID = ?";
    private static final String DELETE_CASEINFO_SQL = "DELETE FROM CaseInfo WHERE caseID = ?;";
    private static final String UPDATE_CASEINFO_SQL = "UPDATE CaseInfo SET "
            + "title = ?, description = ?, dateOpened = ?, dateClosed = ? WHERE caseID = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertCaseInfo(CaseInfo case1) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CASEINFO_SQL)) {
            preparedStatement.setInt(1, case1.getCaseID());
            preparedStatement.setString(2, case1.getTitle());
            preparedStatement.setString(3, case1.getDescription());
            preparedStatement.setDate(4, java.sql.Date.valueOf(case1.getDateOpened()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(case1.getDateClosed()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateCaseInfo(CaseInfo case1) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CASEINFO_SQL)) {
            preparedStatement.setString(1, case1.getTitle());
            preparedStatement.setString(2, case1.getDescription());
            preparedStatement.setDate(3, java.sql.Date.valueOf(case1.getDateOpened()));
            preparedStatement.setDate(4, java.sql.Date.valueOf(case1.getDateClosed()));
            preparedStatement.setInt(5, case1.getCaseID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public CaseInfo selectCaseInfoByID(int caseID) {
        CaseInfo case1 = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASEINFO_BY_ID_SQL)) {
            preparedStatement.setInt(1, caseID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDate dateOpened = rs.getDate("dateOpened").toLocalDate();
                LocalDate dateClosed = rs.getDate("dateClosed").toLocalDate();
                case1 = new CaseInfo(caseID, title, description, dateOpened, dateClosed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return case1;
    }

    public List<CaseInfo> selectCaseInfo() {
        List<CaseInfo> caseInfoList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASEINFO_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int caseID = rs.getInt("caseID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDate dateOpened = rs.getDate("dateOpened").toLocalDate();
                LocalDate dateClosed = rs.getDate("dateClosed").toLocalDate();
                caseInfoList.add(new CaseInfo(caseID, title, description, dateOpened, dateClosed));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseInfoList;
    }

    public List<CaseInfo> searchByTitle(String keyword) {
        List<CaseInfo> caseInfoList = new ArrayList<>();
        String sql = "SELECT * FROM CaseInfo WHERE title LIKE ?";

        try (Connection connection = getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int caseID = rs.getInt("caseID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                LocalDate dateOpened = rs.getDate("dateOpened").toLocalDate();
                LocalDate dateClosed = rs.getDate("dateClosed").toLocalDate();
                CaseInfo caseInfo = new CaseInfo(caseID, title, description, dateOpened, dateClosed);
                caseInfoList.add(caseInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caseInfoList;
    }

    public boolean deleteCaseInfo(int caseID) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CASEINFO_SQL)) {
            preparedStatement.setInt(1, caseID);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
