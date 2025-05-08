package src.dao;

import src.model.CaseInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CaseDAO {
    public int registerCaseInfo(CaseInfo case1) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO CaseInfo" +
                " (caseID, title, description, dateOpened, dateClosed) VALUES " +
                " (?, ?, ?, ?, ?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/forensics", "root", "admin");

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {

            preparedStatement.setInt(1, case1.getCaseID());
            preparedStatement.setString(2, case1.getTitle());
            preparedStatement.setString(3, case1.getDescription());
            preparedStatement.setDate(4, java.sql.Date.valueOf(case1.getDateOpened()));
            preparedStatement.setDate(5, java.sql.Date.valueOf(case1.getDateClosed()));

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
