// ---CLASSE MEMBRE---

import java.time.LocalDate;
import java.util.ArrayList;

public class Membre {

        private int id;
        private String nom;
        private String prenom;
        private String email;
        private LocalDate adhesionDate;

        public Membre(int id, String nom, String prenom, String email, LocalDate adhesionDate) {
            this.id = id;
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.adhesionDate = adhesionDate;
        }

        public int getId() {
            return id;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getEmail() {
            return email;
        }

        public LocalDate getAdhesionDate() {
            return adhesionDate;
        }

        public void setId(int id){
            this.id = id;
        }

        public void setNom(String nom){
            this.nom = nom;
        }

        public void setPrenom(String prenom){
            this.prenom = prenom;
        }

        public void setEmail(String email){
            this.email = email;
        }

        public void setAdhesionDate(LocalDate adhesionDate){
            this.adhesionDate = adhesionDate;
        }

    @Override
    public String toString() {
        return "Membre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", adhesionDate=" + adhesionDate +
                '}';
    }

}
