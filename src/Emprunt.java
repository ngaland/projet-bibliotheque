// ---CLASSE EMPRUNT---

import java.time.LocalDate;

public class Emprunt {

        private int idEmprunt;
        private int membreId;
        private int livreId;
        private LocalDate dateEmprunt;
        private LocalDate dateRetourPrevue;
        private LocalDate dateRetourEffective;

        public Emprunt(int idEmprunt, int membreId, int livreId, LocalDate dateEmprunt, LocalDate dateRetourPrevue, LocalDate dateRetourEffective) {
            this.idEmprunt = idEmprunt;
            this.membreId = membreId;
            this.livreId = livreId;
            this.dateEmprunt = dateEmprunt;
            this.dateRetourPrevue = dateRetourPrevue;
            this.dateRetourEffective = dateRetourEffective;
        }

        public int getIdEmprunt() { return idEmprunt; }

        public int getMembreId() {
            return membreId;
        }

        public int getLivreId() {
            return livreId;
        }

        public LocalDate getDateEmprunt() {
            return dateEmprunt;
        }

        public LocalDate getDateRetourPrevue() {
            return dateRetourPrevue;
        }

        public LocalDate getDateRetourEffective() {
            return dateRetourEffective;
        }

        public void setIdEmprunt(int idEmprunt){
            this.idEmprunt = idEmprunt;
        }

        public void setMembreId(int membreId){
            this.membreId = membreId;
        }

        public void setLivreId(int livreId){
            this.livreId = livreId;
        }

        public void setDateEmprunt(LocalDate dateEmprunt){
            this.dateEmprunt = dateEmprunt;
        }

        public void setDateRetourPrevue(LocalDate dateRetourPrevue){
            this.dateRetourPrevue = dateRetourPrevue;
        }

        public void setDateRetourEffective(LocalDate dateRetourEffective){
            this.dateRetourEffective = dateRetourEffective;
        }

    @Override
    public String toString() {
        return "Emprunt{" +
                "idEmprunt=" + idEmprunt +
                ", membreId=" + membreId +
                ", livreId=" + livreId +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetourPrevue=" + dateRetourPrevue +
                ", dateRetourEffective=" + dateRetourEffective +
                '}';
    }

}
