public class Rivista extends Materiale {

    private String editore;
    private int anno;
    private int numeroVolume;

    public Rivista(String titolo, String editore, String genere, int anno, int numeroVolume, int idBiblioteca) {
        super(titolo, genere, idBiblioteca);
        this.editore = editore;
        this.anno = anno;
        this.numeroVolume = numeroVolume;
    }

    @Override
    public String toString() {
        return "Rivista [editore=" + editore + ", anno=" + anno + ", numeroVolume=" + numeroVolume
                + ", getCodiceInterno()=" + getCodiceInterno() + ", isDisponibile()=" + isDisponibile()
                + ", getTitolo()=" + getTitolo() + ", getGenere()=" + getGenere() + ", getIdBiblioteca()="
                + getIdBiblioteca() + "]";
    }


}