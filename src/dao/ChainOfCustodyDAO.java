package src.dao;

import src.model.ChainOfCustody;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChainOfCustodyDAO {

    private final String jdbcURL = "jdbc:mysql://localhost:3306/forensics";
    private final String jdbcUser = "root";
    private final String jdbcPass = "admin";
    private static final String INSERT_CHAIN_SQL = "INSERT INTO ChainOfCustody (PersonnelID, EvidenceID, DateLogged) VALUES (?, ?, ?);";
    private static final String SELECT_CHAIN_SQL = "SELECT * FROM ChainOfCustody";
    private static final String DELETE_CHAIN_SQL = "DELETE FROM ChainOfCustody WHERE PersonnelID = ? AND EvidenceID = ? AND DateLogged = ?;";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPass);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertChainOfCustody(ChainOfCustody chain) {
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHAIN_SQL)) {
            preparedStatement.setInt(1, chain.getPersonnelID());
            preparedStatement.setInt(2, chain.getEvidenceID());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(chain.getDateLogged()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ChainOfCustody> selectAllChains() {
        List<ChainOfCustody> chains = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHAIN_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int personnelID = rs.getInt("PersonnelID");
                int evidenceID = rs.getInt("EvidenceID");
                java.time.LocalDateTime dateLogged = rs.getTimestamp("DateLogged").toLocalDateTime();
                chains.add(new ChainOfCustody(personnelID, evidenceID, dateLogged));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chains;
    }

    public boolean deleteChainOfCustody(int personnelID, int evidenceID, java.time.LocalDateTime dateLogged) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CHAIN_SQL)) {
            preparedStatement.setInt(1, personnelID);
            preparedStatement.setInt(2, evidenceID);
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(dateLogged));
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}
