public class Materiale {
    
    private String codiceInterno;
    private String titolo;
    private String genere;
    private boolean disponibile;
    private int idBiblioteca;

    public Materiale(String titolo, String genere, int idBiblioteca) {
        this.titolo = titolo;
        this.genere = genere;
        this.disponibile = true;  // Disponibile di default
        this.idBiblioteca = idBiblioteca;
    }

    public String getCodiceInterno() {
        return codiceInterno;
    }

    public boolean isDisponibile() {
        return disponibile;
    }

    public void setCodiceInterno(String codiceInterno) {
        this.codiceInterno = codiceInterno;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public int getIdBiblioteca() {
        return idBiblioteca;
    }

    public void setIdBiblioteca(int idBiblioteca) {
        this.idBiblioteca = idBiblioteca;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}