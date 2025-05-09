package src.dao;

import src.model.Evidence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EvidenceDAO {
    public int registerEvidence(Evidence evidence) throws ClassNotFoundException {
        String INSERT_EVIDENCE_SQL = "INSERT INTO Evidence" +
                " (evidenceID, title, description, evidenceType, dateCollected, evidenceImage) VALUES " +
                " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/forensics", "root", "admin");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EVIDENCE_SQL)) {

            preparedStatement.setInt(1, evidence.getEvidenceID());
            preparedStatement.setString(2, evidence.getTitle());
            preparedStatement.setString(3, evidence.getDescription());
            preparedStatement.setString(4, evidence.getEvidenceType());
            preparedStatement.setDate(5, java.sql.Date.valueOf(evidence.getDateCollected()));
            preparedStatement.setString(6, evidence.getEvidenceImage());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
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