import java.sql.Connection;  // Pour gérer la connexion à la base de données
import java.sql.SQLException;
import java.time.LocalDate;  // Pour gérer les dates, notamment pour la date d'inscription ou d'emprunt
import java.util.List;
import java.util.Scanner;

        public class Main {

            public static void main(String[] args) {
                try (Connection connection = DBConnection.getConnection()) {
                    System.out.println("Connexion à la base de données réussie !");
                    LivreDAO livreDAO = new LivreDAO(connection);
                    MembreDAO membreDAO = new MembreDAO(connection);
                    EmpruntDAO empruntDAO = new EmpruntDAO(connection);

                    Scanner scanner = new Scanner(System.in);
                    boolean quitter = false;

                    while (!quitter) {
                        System.out.println("\n--- MENU ---");
                        System.out.println("1 - Ajouter un livre");
                        System.out.println("2 - Modifier un livre");
                        System.out.println("3 - Supprimer un livre");
                        System.out.println("4 - Rechercher un livre");
                        System.out.println("5 - Afficher tous les livres disponibles");
                        System.out.println("6 - Inscrire un membre");
                        System.out.println("7 - Afficher tous les membres");
                        System.out.println("8 - Supprimer un membre");
                        System.out.println("9 - Rechercher un membre");
                        System.out.println("10 - Enregistrer un emprunt");
                        System.out.println("11 - Liste des emprunts");
                        System.out.println("12 - Retourner un livre");
                        System.out.println("13 - Calculer une pénalité");
                        System.out.println("14 - Quitter");
                        System.out.print("Votre choix : ");

                        int choix = scanner.nextInt();
                        scanner.nextLine(); // Consomme la ligne restante

                        switch (choix) {
                            case 1: // Ajouter un livre
                                System.out.print("Titre : ");
                                String titre = scanner.nextLine();
                                System.out.print("Auteur : ");
                                String auteur = scanner.nextLine();
                                System.out.print("Catégorie : ");
                                String categorie = scanner.nextLine();
                                System.out.print("Nombre d'exemplaires : ");
                                int nombreExemplaires = scanner.nextInt();

                                Livre livre = new Livre(0, titre, auteur, categorie, nombreExemplaires);
                                livreDAO.addLivre(livre);
                                System.out.println("Livre ajouté avec succès !");
                                break;

                            case 2: // Modifier un livre
                                System.out.print("ID du livre à modifier : ");
                                int idLivre = scanner.nextInt();
                                scanner.nextLine();
                                System.out.print("Nouveau titre : ");
                                String newTitre = scanner.nextLine();
                                System.out.print("Nouvel auteur : ");
                                String newAuteur = scanner.nextLine();
                                System.out.print("Nouvelle catégorie : ");
                                String newCategorie = scanner.nextLine();
                                System.out.print("Nouveau nombre d'exemplaires : ");
                                int newNombreExemplaires = scanner.nextInt();

                                Livre updatedLivre = new Livre(idLivre, newTitre, newAuteur, newCategorie, newNombreExemplaires);
                                livreDAO.updateLivre(updatedLivre);
                                System.out.println("Livre modifié avec succès !");
                                break;

                            case 3: // Supprimer un livre
                                System.out.print("ID du livre à supprimer : ");
                                idLivre = scanner.nextInt();
                                livreDAO.deleteLivreById(idLivre);
                                System.out.println("Livre supprimé avec succès !");
                                break;

                            case 4: // Rechercher un livre
                                System.out.print("Rechercher par (1: Titre, 2: Catégorie) : ");
                                int critere = scanner.nextInt();
                                scanner.nextLine();
                                if (critere == 1) {
                                    System.out.print("Titre : ");
                                    String searchTitre = scanner.nextLine();
                                    List<Livre> livresByTitre = livreDAO.searchLivresByTitre(searchTitre);
                                    livresByTitre.forEach(System.out::println);
                                } else if (critere == 2) {
                                    System.out.print("Catégorie : ");
                                    String searchCategorie = scanner.nextLine();
                                    List<Livre> livresByCategorie = livreDAO.searchLivresByCategorie(searchCategorie);
                                    livresByCategorie.forEach(System.out::println);
                                } else {
                                    System.out.println("Critère invalide.");
                                }
                                break;

                            case 5: // Afficher tous les livres disponibles
                                List<Livre> livres = livreDAO.getAllLivres();
                                if (livres.isEmpty()) {
                                    System.out.println("Aucun livre disponible.");
                                } else {
                                    livres.forEach(System.out::println);
                                }
                                break;

                            case 6: // Inscrire un membre
                                System.out.print("Nom : ");
                                String nom = scanner.nextLine();
                                System.out.print("Prénom : ");
                                String prenom = scanner.nextLine();
                                System.out.print("Email : ");
                                String email = scanner.nextLine();

                                Membre membre = new Membre(0, nom, prenom, email, LocalDate.now());
                                membreDAO.addMembre(membre);
                                System.out.println("Membre inscrit avec succès !");
                                break;

                            case 7: // Afficher tous les membres disponibles
                                List<Membre> membres = membreDAO.getAllMembres();
                                if (membres.isEmpty()) {
                                    System.out.println("Aucun membre disponible.");
                                } else {
                                    membres.forEach(System.out::println);
                                }
                                break;

                            case 8: // Supprimer un membre
                                System.out.print("ID du membre à supprimer : ");
                                int idMembre = scanner.nextInt();
                                membreDAO.deleteMembreById(idMembre);
                                System.out.println("Membre supprimé avec succès !");
                                break;

                            case 9: // Rechercher un membre
                                System.out.print("Nom du membre : ");
                                String searchNom = scanner.nextLine();
                                List<Membre> membresByNom = membreDAO.searchMembresByNom(searchNom);
                                membresByNom.forEach(System.out::println);
                                break;

                            case 10: // Enregistrer un emprunt
                                System.out.print("ID du membre : ");
                                int membreId = scanner.nextInt();
                                System.out.print("ID du livre : ");
                                int livreId = scanner.nextInt();

                                Emprunt emprunt = new Emprunt(0, membreId, livreId, LocalDate.now(), LocalDate.now().plusDays(14), null);
                                empruntDAO.addEmprunt(emprunt);
                                System.out.println("Emprunt enregistré avec succès !");
                                break;

                            case 11: // Afficher tous les emprunts
                                List<Emprunt> emprunts = empruntDAO.getAllEmprunts();
                                if (emprunts.isEmpty()) {
                                    System.out.println("Aucun emprunt en cours.");
                                } else {
                                    emprunts.forEach(System.out::println);
                                }
                                break;

                            case 12: // Retourner un livre
                                System.out.print("ID de l'emprunt : ");
                                int idEmprunt = scanner.nextInt();
                                System.out.print("Date de retour effective (yyyy-mm-dd) : ");
                                String dateRetour = scanner.next();
                                LocalDate dateRetourEffective = LocalDate.parse(dateRetour);
                                empruntDAO.returnLivre(idEmprunt, dateRetourEffective);
                                System.out.println("Livre retourné avec succès !");
                                break;

                            case 13: // Calculer une pénalité
                                System.out.print("ID de l'emprunt : ");
                                idEmprunt = scanner.nextInt();  // Utilisation de la variable déjà définie
                                System.out.print("Montant par jour de retard (en FCFA) : ");
                                int montantParJour = scanner.nextInt();
                                try {
                                    int penalite = empruntDAO.calculatePenalty(idEmprunt, montantParJour);
                                    if (penalite > 0) {
                                        System.out.println("Pénalité calculée : " + penalite + " FCFA");
                                    } else {
                                        System.out.println("Aucune pénalité. Pas de retard enregistré ou emprunt introuvable.");
                                    }
                                } catch (SQLException e) {
                                    System.out.println("Erreur lors du calcul de la pénalité : " + e.getMessage());
                                }
                                break;


                            case 14: // Quitter
                                quitter = true;
                                System.out.println("Au revoir !");
                                break;

                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
