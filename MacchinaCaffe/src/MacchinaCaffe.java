import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

public class MacchinaCaffe {

    // Mappa per i tipi di caffè disponibili
    private HashMap<Integer, TipoCaffe> menu = new HashMap<>();
    private double credito;
    private int capienza = 30;

    public MacchinaCaffe() {
        credito = 0.0;

        menu.put(1, new TipoCaffe("Caffè Normale", 1.0, 10));
        menu.put(2, new TipoCaffe("Caffè Macchiato", 1.5, 10));
        menu.put(3, new TipoCaffe("Caffè al Ginseng", 2.0, 10));
    }

    // Metodo per inserire monete
    public void inserisciMoneta() {
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Inserisci: ");
            double moneta = scanner.nextDouble();

            // Esce dal ciclo
            if (moneta <= 0) {
                System.out.println("\nHai inserito: "+ credito + "€");
                break;
            }

            // Controlla se la moneta è valida
            if (moneta == 0.5 || moneta == 1.0 || moneta == 2.0) {
                credito += moneta;
            } else {
                System.out.println("\nTaglio non valido. Inserisci solo 0.5€, 1.0€ o 2.0€.");
                continue;
            }
        }
    }

    // Metodo per ottenere il credito
    public double getCredito() {
        return credito;
    }

    // Metodo per selezionare e ottenere un caffè
    public void selezionaCaffe(int tipo) {

        TipoCaffe caffe = menu.get(tipo);

        if (caffe == null) {
            System.out.println("Tipo di caffè non disponibile.");
            return;
        }

        if (caffe.quantita == 0) {
            System.out.println("Caffè esaurito.");
            return;
        }

        if (credito >= caffe.prezzo) {
            System.out.println("Erogazione: " + caffe.nome);
            credito -= caffe.prezzo;
            caffe.quantita--;

            // Erogazione Resto
            if (credito > 0) {
                System.out.println("\nResto erogato: " + credito + "€");
                credito = 0.0;
            }

        } else {
            System.out.println("Credito insufficiente. Inserire almeno: " + (caffe.prezzo - credito) + "€");
        }
    }

    // Metodo per calcolare il totale delle quantità nella macchina
    private int calcolaQuantitaTotale() {

        int totale = 0;
        for (TipoCaffe caffe : menu.values()) {
            totale += caffe.quantita;
        }
        return totale;
    }

    // Metodo per caricare la macchina
    public void caricaCaffe(int tipo, int quantita) {

        TipoCaffe caffe = menu.get(tipo);

        if (caffe != null && quantita > 0) {
            int quantitaTotale = calcolaQuantitaTotale();

            if (quantitaTotale + quantita > capienza) {
                System.out.println("Impossibile caricare il caffè. La quantita disponibile per raggiungere la capienza massima è di: " + (capienza - quantitaTotale) + " unità");
            } else {
                caffe.quantita += quantita;
                System.out.println("Caricati " + quantita + " unità di: " + caffe.nome + " Quantita totale: " + caffe.quantita);
            }
        } else {
            System.out.println("Tipo di caffè non valido o quantità errata.");
        }
    }

    // Metodo per mostrare il menu
    public void mostraMenu() {

        System.out.println("\n--- Menu Caffè ---");
    
        for (Entry<Integer, TipoCaffe> e : menu.entrySet()) {
            Integer chiave = e.getKey();
            TipoCaffe caffe = e.getValue();
            
            System.out.println(chiave + ". " + caffe.nome + " - Prezzo: " + caffe.prezzo + "€ - Disponibile: " + caffe.quantita);
        }
    }

}