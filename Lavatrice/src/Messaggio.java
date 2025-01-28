import java.util.HashMap;

class Messaggio {

    // Lingue
    public enum Lingua {
        ITALIANO, INGLESE
    }

    // Mappa per identificare la Lingua
    private HashMap<Lingua, HashMap<Integer, String>> messaggio = new HashMap<>();

    public Messaggio() {

        // ITALIANO
        HashMap<Integer, String> messaggioItaliano = new HashMap<>();
        messaggioItaliano.put(1, "1. Accendi Lavatrice");
        messaggioItaliano.put(2, "2. Apri Sportello");
        messaggioItaliano.put(3, "3. Chiudi Sportello");
        messaggioItaliano.put(4, "4. Aggiungi Detersivo");
        messaggioItaliano.put(5, "5. Imposta Temperatura");
        messaggioItaliano.put(6, "6. Avvia Lavaggio");
        messaggioItaliano.put(7, "7. Termina Lavaggio");
        messaggioItaliano.put(8, "8. Spegni Lavatrice");
        messaggioItaliano.put(9, "9. Mostra stato");
        messaggioItaliano.put(10, "10. Esci");
        messaggioItaliano.put(11, "Scegli: ");
        
        // Lavatrice Accesa
        messaggioItaliano.put(112, "La lavatrice è accesa!");
        messaggioItaliano.put(113, "La lavatrice è in funzione!");
        messaggioItaliano.put(114, "La lavatrice è già accesa!");

        //Associo la lingua
        messaggio.put(Lingua.ITALIANO, messaggioItaliano);


        // INGLESE
        HashMap<Integer, String> messaggioInglese = new HashMap<>();
        messaggioInglese.put(1, "1. Turn On Washing Machine");
        messaggioInglese.put(2, "2. Open Door");
        messaggioInglese.put(3, "3. Close Door");
        messaggioInglese.put(4, "4. Add Detergent");
        messaggioInglese.put(5, "5. Set Temperature");
        messaggioInglese.put(6, "6. Start Washing Cycle");
        messaggioInglese.put(7, "7. End Washing Cycle");
        messaggioInglese.put(8, "8. Turn Off Washing Machine");
        messaggioInglese.put(9, "9. Show Status");
        messaggioInglese.put(10, "10. Exit");
        messaggioInglese.put(11, "Select: ");

        messaggioInglese.put(112, "The washing machine is on!");
        messaggioInglese.put(113, "The washing machine is running!");
        messaggioInglese.put(114, "The washing machine is already on!");

        messaggio.put(Lingua.INGLESE, messaggioInglese);
    }

    // Metodo per ottenere il messaggio
    public String getMessaggio(int chiave, Lingua lingua) {
        return messaggio.get(lingua).get(chiave);
    }
}