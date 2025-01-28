import java.util.ArrayList;
import java.util.Random;

public class Televisore {
    
    private boolean acceso;
    private int volume;
    private ArrayList<Canale> listaCanali;
    
    // Costruttore
    public Televisore() {
        acceso = false;
        volume = 5;      
        listaCanali = new ArrayList<>();
    }
    
    // Getter per verificare se il TV è acceso
    public boolean isAcceso() {
        return acceso;
    }
    
    // Metodo per accendere/spegnere
    public void accendiSpegni() {
        if(acceso) {
            acceso = false;
            System.out.println("Televisore spento.");
        } else {
            acceso = true;
            System.out.println("Televisore acceso.");
        }
    }
    
    public void scansiona() {
        if(!acceso) {
            System.out.println("Per effettuare la scansione, il televisore deve essere acceso!");
            return;
        }
        
        // Lista di canali "base"
        String[] nomiCanali = {
            "Rai 1", "Rai 2", "Rai 3",
            "Canale 5", "Italia 1", "Rete 4",
            "La7", "TV8", "Nove", "Paramount Network"
        };
        
        // Svuota la lista dei canali scansionati
        listaCanali.clear();
        
        Random rand = new Random();
        
        for(int i = 0; i < nomiCanali.length; i++) {
            int potenzaSegnale = rand.nextInt(100)+1; 
            if(potenzaSegnale > 30) {
                double frequenza = 400 + (100 * rand.nextDouble());
                Canale canale = new Canale(i+1, nomiCanali[i], frequenza, potenzaSegnale);
                listaCanali.add(canale);
            }
        }
        
        if(listaCanali.isEmpty()) {
            System.out.println("Nessun canale trovato (la potenza del segnale era troppo bassa!).");
        } else {
            System.out.println("Scansione completata. Canali trovati:");
            for(Canale c : listaCanali) {
                System.out.println("  " + c);
            }
        }
    }
    
    // Metodo per guardare un canale
    public void guardaCanale(int numeroCanale) {
        if(!acceso) {
            System.out.println("Il televisore è spento.");
            return;
        }
        
        // Cerchiamo il canale con il numero indicato
        for(Canale c : listaCanali) {
            if(c.numero == numeroCanale) {
                System.out.println("Stai guardando il canale: " + c.nome);
                return;
            }
        }
    }
    
    // Metodo per aumentare il volume
    public void aumentaVolume() {
        if(!acceso) {
            System.out.println("Il televisore è spento.");
            return;
        }
        if(volume < 10) {
            volume++;
        }
        System.out.println("Volume attuale: " + volume);
    }
    
    // Metodo per diminuire il volume
    public void diminuisciVolume() {
        if(!acceso) {
            System.out.println("Il televisore è spento.");
            return;
        }
        if(volume > 0) {
            volume--;
        }
        System.out.println("Volume attuale: " + volume);
    }
}
