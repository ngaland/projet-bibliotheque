// ---CLASSE LIVRE---

import java.util.ArrayList;

public class Livre {

        private int id;
        private String titre;
        private String auteur;
        private String categorie;
        private int nombreExemplaires;

        public Livre(int id, String titre, String auteur, String categorie, int nombreExemplaires) {
            this.id = id;
            this.titre = titre;
            this.auteur = auteur;
            this.categorie = categorie;
            this.nombreExemplaires = nombreExemplaires;
        }

        public int getId() {
            return id;
        }

        public String getTitre() {
            return titre;
        }

        public String getAuteur() {
            return auteur;
        }

        public String getCategorie() {
            return categorie;
        }

        public int getNombreExemplaires() {
            return nombreExemplaires;
        }

        public void setId(int id){
            this.id = id;
        }

        public void setTitre(String titre){
            this.titre = titre;
        }

        public void setAuteur(String auteur){
            this.auteur = auteur;
        }

        public void setCategorie(String categorie){
            this.categorie = categorie;
        }

        public void setNombreExemplaires(int nombreExemplaires) {
            this.nombreExemplaires = nombreExemplaires;
        }


    @Override
    public String toString() {
        return "Livre{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", categorie='" + categorie + '\'' +
                ", nombreExemplaires=" + nombreExemplaires +
                '}';
    }

}
