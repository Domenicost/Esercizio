import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Impiegato extends Persona {
    private String nrTesserino;
    private int stipendio;
    private LocalDate dataAssunzione;
    private List<Cedolino> cedolini; // Lista dei cedolini ricevuti

    public Impiegato(String nome, String cognome, LocalDate dataNascita, String username, String password, String nrTesserino,
                     int stipendio, LocalDate dataAssunzione) {
        super(nome, cognome, dataNascita, username, password);
        setNrTesserino(nrTesserino);
        setStipendio(stipendio);

        if (dataAssunzione.isAfter(getDataNascita()) &&
                (dataAssunzione.isBefore(LocalDate.now()) || dataAssunzione.equals(LocalDate.now())))
            this.dataAssunzione = dataAssunzione;
        else
            throw new IllegalArgumentException("Data di assunzione non valida");

        this.cedolini = new ArrayList<>(); // Inizializza la lista dei cedolini
    }

    public String getNrTesserino() {
        return nrTesserino;
    }

    public void setNrTesserino(String nrTesserino) {
        if (!nrTesserino.trim().isEmpty())
            this.nrTesserino = nrTesserino;
        else
            throw new IllegalArgumentException("Nr di tesserino non valido");
    }

    public int getStipendio() {
        return stipendio;
    }

    public void setStipendio(int stipendio) {
        if (stipendio > 500)
            this.stipendio = stipendio;
        else
            throw new IllegalArgumentException("La schiavitù è illegale");
    }

    public LocalDate getDataAssunzione() {
        return dataAssunzione;
    }

    public void riceviAumento(int aumento) {
        if (aumento > 0)
            stipendio += aumento;
        else
            throw new IllegalArgumentException("Aumento non valido");
    }

    // Metodo per ricevere un cedolino
    public void riceviCedolino(LocalDate data, double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }
        Cedolino cedolino = new Cedolino(data, importo);
        cedolini.add(cedolino);
        System.out.println("Cedolino ricevuto: " + cedolino);
    }

    // Metodo per visualizzare i cedolini di un anno specifico
    public void visualizzaCedolini(int anno) {
        System.out.println("Cedolini per l'anno " + anno + ":");
        boolean trovato = false;
        for (Cedolino cedolino : cedolini) {
            if (cedolino.getData().getYear() == anno) {
                System.out.println(cedolino);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessun cedolino trovato per l'anno " + anno + ".");
        }
    }

    @Override
    public String toString() {
        return "Impiegato [nrTesserino=" + nrTesserino + ", stipendio=" + stipendio
                + ", data assunzione=" + dataAssunzione + ", data di nascita=" + getDataNascita()
                + ", nome=" + getNome() + ", cognome=" + getCognome() + "]";
    }
}
