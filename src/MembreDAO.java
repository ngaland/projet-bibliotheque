import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {

    private Connection connection;

    public MembreDAO(Connection connection) {
        this.connection = connection;
    }

    // Ajouter un membre
    public void addMembre(Membre membre) throws SQLException {
        String query = "INSERT INTO membres (nom, prenom, email, adhesion_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, membre.getNom());
            pstmt.setString(2, membre.getPrenom());
            pstmt.setString(3, membre.getEmail());
            pstmt.setDate(4, Date.valueOf(membre.getAdhesionDate()));
            pstmt.executeUpdate();
        }
    }

    // Récupérer tous les membres
    public List<Membre> getAllMembres() throws SQLException {
        String query = "SELECT * FROM membres";
        List<Membre> membres = new ArrayList<>();
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                membres.add(new Membre(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getDate("adhesion_date").toLocalDate()
                ));
            }
        }
        return membres;
    }

    // Supprimer un membre par ID
    public void deleteMembreById(int id) throws SQLException {
        String query = "DELETE FROM membres WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }

    public List<Membre> searchMembresByNom(String searchNom) throws SQLException {
        String query = "SELECT * FROM membres WHERE LOWER(nom) LIKE LOWER(?)";
        List<Membre> membres = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + searchNom + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                membres.add(new Membre(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getString("email"),
                        resultSet.getDate("adhesion_date").toLocalDate()
                ));
            }
        }
        return membres;
    }

}
