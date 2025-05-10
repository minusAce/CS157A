package src.dao;

import src.model.CaseEvidence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CaseEvidenceDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/forensics";
    private final String jdbcUser = "root";
    private final String jdbcPass = "admin";
    private static final String INSERT_CASEEVIDENCE_SQL = "INSERT INTO CaseEvidence"
            + " (caseID, evidenceID) VALUES "
            + " (?, ?);";
    private static final String SELECT_CASEEVIDENCE_SQL = "SELECT * FROM CaseEvidence";
    private static final String SELECT_CASEEVIDENCE_BY_ID_SQL = "SELECT * FROM CaseEvidence WHERE caseID = ?";
    private static final String DELETE_CASEEVIDENCE_SQL = "DELETE FROM CaseEvidence WHERE caseID = ?;";
    private static final String UPDATE_CASEEVIDENCE_SQL = "UPDATE CaseEvidence SET "
            + "evidenceID = ? WHERE caseID = ?;";

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

    public void insertCaseEvidence(CaseEvidence caseEvidence) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CASEEVIDENCE_SQL)) {
            preparedStatement.setInt(1, caseEvidence.getCaseID());
            preparedStatement.setInt(2, caseEvidence.getEvidenceID());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateCaseEvidence(CaseEvidence caseEvidence) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CASEEVIDENCE_SQL)) {
            preparedStatement.setInt(1, caseEvidence.getEvidenceID());
            preparedStatement.setInt(2, caseEvidence.getCaseID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }

    public CaseEvidence selectCaseEvidenceByID(int caseID) {
        CaseEvidence caseEvidence = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASEEVIDENCE_BY_ID_SQL)) {
            preparedStatement.setInt(1, caseID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int evidenceID = rs.getInt("evidenceID");
                caseEvidence = new CaseEvidence(caseID, evidenceID);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return caseEvidence;
    }

    public List<CaseEvidence> selectCaseEvidence() {
        List<CaseEvidence> CaseEvidenceList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CASEEVIDENCE_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int caseID = rs.getInt("caseID");
                int evidenceID = rs.getInt("evidenceID");
                CaseEvidenceList.add(new CaseEvidence(caseID, evidenceID));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CaseEvidenceList;
    }

    public boolean deleteCaseEvidence(int caseID) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CASEEVIDENCE_SQL)) {
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
