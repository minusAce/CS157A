package src.dao;

import src.model.LawEnforcementPersonnel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class LawEnforcementPersonnelDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/forensics";
    private final String jdbcUser = "root";
    private final String jdbcPass = "admin";
    private static final String INSERT_LAWENFORCEMENTPERSONNEL_SQL = "INSERT INTO LawEnforcementPersonnel" +
            " (personnelID, name, role) VALUES " +
            " (?, ?, ?);";
    private static final String SELECT_LAWENFORCEMENTPERSONNEL_SQL = "SELECT * FROM LawEnforcementPersonnel";
    private static final String SELECT_LAWENFORCEMENTPERSONNEL_BY_ID_SQL = "SELECT * FROM LawEnforcementPersonnel WHERE personnelID = ?";
    private static final String DELETE_LAWENFORCEMENTPERSONNEL_SQL = "DELETE FROM LawEnforcementPersonnel WHERE personnelID = ?;";
    private static final String UPDATE_LAWENFORCEMENTPERSONNEL_SQL = "UPDATE LawEnforcementPersonnel SET " +
            "name = ?, role = ? WHERE personnelID = ?;";

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

    public void insertLawEnforcementPersonnel(LawEnforcementPersonnel lawEnforcementPersonnel) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LAWENFORCEMENTPERSONNEL_SQL)) {
            preparedStatement.setInt(1, lawEnforcementPersonnel.getPersonnelID());
            preparedStatement.setString(2, lawEnforcementPersonnel.getName());
            preparedStatement.setString(3, lawEnforcementPersonnel.getRole());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateLawEnforcementPersonnel(LawEnforcementPersonnel lawEnforcementPersonnel) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LAWENFORCEMENTPERSONNEL_SQL)) {
            preparedStatement.setString(1, lawEnforcementPersonnel.getName());
            preparedStatement.setString(2, lawEnforcementPersonnel.getRole());
            preparedStatement.setInt(3, lawEnforcementPersonnel.getPersonnelID());
            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowUpdated;
    }


    public LawEnforcementPersonnel selectLawEnforcementPersonnelByID(int personnelID) {
        LawEnforcementPersonnel lawEnforcementPersonnel = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAWENFORCEMENTPERSONNEL_BY_ID_SQL)) {
            preparedStatement.setInt(1, personnelID);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                lawEnforcementPersonnel = new LawEnforcementPersonnel(personnelID, name, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lawEnforcementPersonnel;
    }

    public List<LawEnforcementPersonnel> selectLawEnforcementPersonnel() {
        List<LawEnforcementPersonnel> lawEnforcementPersonnelList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAWENFORCEMENTPERSONNEL_SQL)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int personnelID = rs.getInt("personnelID");
                String name = rs.getString("name");
                String role = rs.getString("role");
                lawEnforcementPersonnelList.add(new LawEnforcementPersonnel(personnelID, name, role));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lawEnforcementPersonnelList;
    }

    public boolean deleteLawEnforcementPersonnel(int personnelID) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_LAWENFORCEMENTPERSONNEL_SQL)) {
            preparedStatement.setInt(1, personnelID);
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
