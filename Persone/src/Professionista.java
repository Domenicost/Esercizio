import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Professionista extends Persona {
    private String partitaIVA;
    private int fatturato;
    private LocalDate dataInizioAttività;
    private List<Fattura> fatture; // Lista delle fatture emesse
    private HashMap<Integer, Integer> contatoreFatturePerAnno; // Contatore fatture per anno

    public Professionista(String nome, String cognome, LocalDate dataNascita, String username, String password, String partitaIVA,
                          LocalDate dataInizioAttività) {
        super(nome, cognome, dataNascita, username, password);

        if (partitaIVA.trim().length() == 11)
            this.partitaIVA = partitaIVA;
        else
            throw new IllegalArgumentException("Partita IVA non valida");

        if (dataInizioAttività.isAfter(getDataNascita()) &&
                (dataInizioAttività.isBefore(LocalDate.now()) || dataInizioAttività.equals(LocalDate.now())))
            this.dataInizioAttività = dataInizioAttività;
        else
            throw new IllegalArgumentException("Data di inizio attività non valida");

        this.fatturato = 0;
        this.fatture = new ArrayList<>();
        this.contatoreFatturePerAnno = new HashMap<>();
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public int getFatturato() {
        return fatturato;
    }

    public LocalDate getDataInizioAttività() {
        return dataInizioAttività;
    }

    // Metodo per emettere una fattura
    public void emettiFattura(LocalDate data, String cliente, double importo) {
        if (importo <= 0) {
            throw new IllegalArgumentException("Importo non valido");
        }

        int anno = data.getYear();
        int numeroFattura = contatoreFatturePerAnno.getOrDefault(anno, 0) + 1;
        contatoreFatturePerAnno.put(anno, numeroFattura);

        Fattura nuovaFattura = new Fattura(numeroFattura, data, cliente, importo);
        fatture.add(nuovaFattura);
        fatturato += importo;

        System.out.println("Fattura emessa: " + nuovaFattura);
    }

    public void visualizzaFatture(String cliente) {
        System.out.println("Fatture per il cliente " + cliente + ":");
        boolean trovato = false;
        for (Fattura fattura : fatture) {
            if (fattura.getCliente().equalsIgnoreCase(cliente)) {
                System.out.println(fattura);
                trovato = true;
            }
        }
        if (!trovato) {
            System.out.println("Nessuna fattura trovata per il cliente " + cliente + ".");
        }
    }

    @Override
    public String toString() {
        return "Professionista [partitaIVA=" + partitaIVA + ", fatturato=" + fatturato
                + ", dataInizioAttività=" + dataInizioAttività + ", data di nascita="
                + getDataNascita() + ", nome=" + getNome() + ", cognome=" + getCognome()
                + "]";
    }
}
