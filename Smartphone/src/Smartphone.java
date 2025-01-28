import java.util.ArrayList;
import java.time.LocalDateTime;

public class Smartphone {
    private String modello;
    private String marca;
    private SIM sim;
    private ArrayList<Contatto> contatti;
    private ArrayList<Chiamata> registroChiamate;

    // Costruttore
    public Smartphone(String modello, String marca, SIM sim) {
        this.modello = modello;
        this.marca = marca;
        this.sim = sim;
        this.contatti = new ArrayList<>();
        this.registroChiamate = new ArrayList<>();
    }

    // Metodo per aggiungere un contatto
    public void aggiungiContatto(String nome, String numero) {
        if (!nome.trim().isEmpty()) {
            if (!numero.trim().isEmpty()) {
                boolean numeroEsistente = contatti.stream().anyMatch(c -> c.getNumero().equals(numero));

                if (numeroEsistente) {
                    System.out.println("Errore: Numero già associato a un contatto esistente");
                } else {
                    contatti.add(new Contatto(nome, numero));
                }
            } else {
                System.out.println("Errore: Numero inserito non valido");
            }
        } else {
            System.out.println("Errore: Nome inserito non valido");
        }
    }

    // Metodo per visualizzare i contatti
    public ArrayList<Contatto> visualizzaContatti() {
        return contatti;
    }

    // Metodo per effettuare una chiamata
    public void effettuaChiamata(String numero, int durata) {
        double costo = durata * sim.getCostoPerMinuto();
        if (sim.scalaCredito(costo)) {
            String nomeContatto = cercaContatto(numero);
            registroChiamate.add(new Chiamata(numero, durata, LocalDateTime.now()));
            System.out.println("Chiamata effettuata verso: " + (nomeContatto != null ? nomeContatto : numero));
        } else {
            System.out.println("Credito insufficiente per effettuare la chiamata.");
        }
    }

    // Metodo per inviare un SMS
    public void inviaSMS(String numero) {
        double costo = sim.getCostoSMS();
        if (sim.scalaCredito(costo)) {
            String nomeContatto = cercaContatto(numero);
            System.out.println("SMS inviato a: " + (nomeContatto != null ? nomeContatto : numero));
        } else {
            System.out.println("Credito insufficiente per inviare l'SMS.");
        }
    }

    // Metodo per visualizzare il registro delle chiamate
    public ArrayList<Chiamata> visualizzaRegistroChiamate() {
        return registroChiamate;
    }

    // Metodo per cambiare SIM
    public void cambiaSIM(SIM nuovaSim) {
        this.sim = nuovaSim;
    }

    // Metodo per trovare il nome associato a un numero
    private String cercaContatto(String numero) {
        for (Contatto contatto : contatti) {
            if (contatto.getNumero().equals(numero)) {
                return contatto.getNome();
            }
        }
        return null;
    }
}