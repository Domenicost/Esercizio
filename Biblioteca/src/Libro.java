class Libro extends Materiale {
    private String autore;
    private String editore;
    private String isbn;
    private int numeroPagine;

    public Libro(String titolo, String autore, String genere, String editore, String isbn, int numeroPagine, int idBiblioteca) {
        super(titolo, genere, idBiblioteca);
        this.autore = autore;
        this.editore = editore;
        this.isbn = isbn;
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Libro [autore=" + autore + ", editore=" + editore + ", titolo=" + titolo + ", isbn=" + isbn
                + ", genere=" + genere + ", numeroPagine=" + numeroPagine + ", getCodiceInterno()=" + getCodiceInterno()
                + ", isDisponibile()=" + isDisponibile() + "]";
    }
}