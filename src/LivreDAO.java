import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LivreDAO {

        private Connection connection;

        public LivreDAO(Connection connection) {
            this.connection = connection;
        }

        // Ajouter un livre
        public void addLivre(Livre livre) throws SQLException {
            String query = "INSERT INTO livres (titre, auteur, categorie, nombre_exemplaires) VALUES (?, ?, ?, ?)";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, livre.getTitre());
                pstmt.setString(2, livre.getAuteur());
                pstmt.setString(3, livre.getCategorie());
                pstmt.setInt(4, livre.getNombreExemplaires());
                pstmt.executeUpdate();
            }
        }

    public void updateLivre(Livre updatedLivre) throws SQLException {
        String query = "UPDATE livres SET titre = ?, auteur = ?, categorie = ?, nombre_exemplaires = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, updatedLivre.getTitre());
            statement.setString(2, updatedLivre.getAuteur());
            statement.setString(3, updatedLivre.getCategorie());
            statement.setInt(4, updatedLivre.getNombreExemplaires());
            statement.setInt(5, updatedLivre.getId());
            statement.executeUpdate();
        }
    }

        // Récupérer tous les livres
        public List<Livre> getAllLivres() throws SQLException {
            String query = "SELECT * FROM livres";
            List<Livre> livres = new ArrayList<>();
            try (PreparedStatement pstmt = connection.prepareStatement(query);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    livres.add(new Livre(
                            rs.getInt("id"),
                            rs.getString("titre"),
                            rs.getString("auteur"),
                            rs.getString("categorie"),
                            rs.getInt("nombre_exemplaires")
                    ));
                }
            }
            return livres;
        }

        // Supprimer un livre par ID
        public void deleteLivreById(int id) throws SQLException {
            String query = "DELETE FROM livres WHERE id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }
        }

    public List<Livre> searchLivresByTitre(String searchTitre) throws SQLException {
        String query = "SELECT * FROM livres WHERE LOWER(titre) LIKE LOWER(?)";
        List<Livre> livres = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + searchTitre + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                livres.add(new Livre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("categorie"),
                        resultSet.getInt("nombre_exemplaires")
                ));
            }
        }
        return livres;
    }

    public List<Livre> searchLivresByCategorie(String searchCategorie) throws SQLException {
        String query = "SELECT * FROM livres WHERE LOWER(categorie) LIKE LOWER(?)";
        List<Livre> livres = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, "%" + searchCategorie + "%");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                livres.add(new Livre(
                        resultSet.getInt("id"),
                        resultSet.getString("titre"),
                        resultSet.getString("auteur"),
                        resultSet.getString("categorie"),
                        resultSet.getInt("nombre_exemplaires")
                ));
            }
        }
        return livres;
    }


}



