public class Materiale {
    
    protected String codiceInterno;
    protected String titolo;
    protected String genere;
    protected boolean disponibile;
    protected int idBiblioteca;

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

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }
}