package src.dao;

import src.model.Evidence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EvidenceDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/forensics";
    private final String jdbcUser = "root";
    private final String jdbcPass = "admin";
    private static final String INSERT_EVIDENCE_SQL = "INSERT INTO Evidence" +
            " (evidenceID, title, description, evidenceType, dateCollected) VALUES " +
            " (?, ?, ?, ?, ?);";
    private static final String SELECT_EVIDENCE_SQL = "SELECT * FROM Evidence";
    private static final String SELECT_EVIDENCE_BY_ID_SQL = "SELECT * FROM Evidence WHERE evidenceID = ?";
    private static final String DELETE_EVIDENCE_SQL = "DELETE FROM Evidence WHERE evidenceID = ?;";
    private static final String UPDATE_EVIDENCE_SQL = "UPDATE Evidence SET " +
            "title = ?, description = ?, evidenceType = ?, dateCollected = ? WHERE evidenceID = ?;";

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

    public void insertEvidence(Evidence evidence) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVIDENCE_SQL)) {
            preparedStatement.setInt(1, evidence.getEvidenceID());
            preparedStatement.setString(2, evidence.getTitle());
            preparedStatement.setString(3, evidence.getDescription());
            preparedStatement.setString(4, evidence.getEvidenceType());
            preparedStatement.setDate(5, java.sql.Date.valueOf(evidence.getDateCollected()));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateEvidence(Evidence evidence) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EVIDENCE_SQL)) {
            preparedStatement.setString(1, evidence.getTitle());
            preparedStatement.setString(2, evidence.getDescription());
            preparedStatement.setString(3, evidence.getEvidenceType());
            preparedStatement.setDate(4, java.sql.Date.valueOf(evidence.getDateCollected()));
            preparedStatement.setInt(5, evidence.getEvidenceID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }


    public Evidence selectEvidenceByID(int evidenceID) {
        Evidence evidence = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVIDENCE_BY_ID_SQL)) {
            preparedStatement.setInt(1, evidenceID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                String description = rs.getString("description");
                String evidenceType = rs.getString("evidenceType");
                LocalDate dateCollected = rs.getDate("dateCollected").toLocalDate();
                evidence = new Evidence(evidenceID, title, description, evidenceType, dateCollected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evidence;
    }

    public List<Evidence> selectEvidence() {
        List<Evidence> evidenceList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EVIDENCE_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int evidenceID = rs.getInt("evidenceID");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String evidenceType = rs.getString("evidenceType");
                LocalDate dateCollected = rs.getDate("dateCollected").toLocalDate();
                evidenceList.add(new Evidence(evidenceID, title, description, evidenceType, dateCollected));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evidenceList;
    }

    public boolean deleteEvidence(int evidenceID) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EVIDENCE_SQL)) {
            preparedStatement.setInt(1, evidenceID);
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
