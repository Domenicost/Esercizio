import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Biblioteca {
    private static int libroCounter = 1;
    private static int rivistaCounter = 1;

    private static Map<String, Materiale> elencoMateriali = new HashMap<>();
    private static Map<String, Biblioteca> collocazioni = new HashMap<>();
    private static List<Biblioteca> elencoBiblioteche = new ArrayList<>();

    private int id;
    private String via;
    private String civico;
    private String cap;
    private String citta;

    public Biblioteca(int id, String via, String civico, String cap, String citta) {
        this.id = id;
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.citta = citta;
        elencoBiblioteche.add(this);
    }

    public int getId() {
        return id;
    }

    public String getVia(){
        return via;
    }

    public static void aggiungiMateriale(Materiale materiale) {
        String codice;
        if (materiale instanceof Libro) {
            codice = String.format("L%04d", libroCounter++);
        } else if (materiale instanceof Rivista) {
            codice = String.format("R%04d", rivistaCounter++);
        } else {
            throw new IllegalArgumentException("Tipo di materiale non supportato.");
        }
        materiale.codiceInterno = codice;
        elencoMateriali.put(codice, materiale);
        collocazioni.put(codice, trovaBibliotecaById(materiale.idBiblioteca));
        System.out.println("Materiale aggiunto con codice: " + codice);
    }

    public static boolean verificaDisponibilita(String codice) {
        Materiale materiale = elencoMateriali.get(codice);
        return materiale != null && materiale.isDisponibile();
    }

    public static boolean effettuaPrestito(String codice) {
        Materiale materiale = elencoMateriali.get(codice);
        if (materiale != null && materiale.isDisponibile()) {
            materiale.setDisponibile(false);
            System.out.println("Prestito effettuato per codice: " + codice);
            return true;
        }
        System.out.println("Materiale non disponibile o codice errato.");
        return false;
    }

    public static boolean restituisciPrestito(String codice) {
        Materiale materiale = elencoMateriali.get(codice);
        if (materiale != null && !materiale.isDisponibile()) {
            materiale.setDisponibile(true);
            System.out.println("Prestito restituito per codice: " + codice);
            return true;
        }
        System.out.println("Materiale non in prestito o codice errato.");
        return false;
    }

    public static Biblioteca trovaCollocazione(String codice) {
        return collocazioni.get(codice);
    }

    private static Biblioteca trovaBibliotecaById(int id) {
        for (Biblioteca biblioteca : elencoBiblioteche) {
            if (biblioteca.getId() == id) {
                return biblioteca;
            }
        }
        System.out.println("Biblioteca con ID " + id + " non trovata.");
        return null;
    }

    @Override
    public String toString() {
        return "biblioteca [id=" + id + ", via=" + via + ", civico=" + civico + ", cap=" + cap + ", citta=" + citta
                + "]";
    }
    
}