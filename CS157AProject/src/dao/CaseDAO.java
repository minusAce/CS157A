package src.dao;
import src.model.Case;
import java.util.List;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CaseDAO {
    public List<Case> getAllCases() {
        List<Case> cases = new ArrayList<>();
        String sql = "SELECT * FROM CaseInfo";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Case c = new Case(
                    rs.getInt("CaseID"),
                    rs.getString("Title"),
                    rs.getString("Description"),
                    rs.getDate("DateOpened").toLocalDate(),
                    rs.getDate("DateClosed").toLocalDate()
                );
                cases.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cases;
    }

    public void addCase(Case c) {
        String sql = "INSERT INTO CaseInfo (Title, Description, DateOpened, DateClosed) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, c.getTitle());
            stmt.setString(2, c.getDescription());
            stmt.setDate(3, Date.valueOf(c.getDateOpened()));
            stmt.setDate(4, Date.valueOf(c.getDateClosed()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}