import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Televisore tv = new Televisore();
        Scanner input = new Scanner(System.in);
        
        int scelta = 0;
        
        do {
            System.out.println("\n========== MENU TELEVISORE ==========");
            System.out.println("1. Accendere/Spegnere");
            System.out.println("2. Scansiona Canali");
            System.out.println("3. Guarda Canale");
            System.out.println("4. Aumenta Volume");
            System.out.println("5. Diminuisci Volume");
            System.out.println("6. Esci");
            
            System.out.print("Inserisci la tua scelta: ");
            scelta = input.nextInt();
            
            switch(scelta) {
                case 1:
                    tv.accendiSpegni();
                    break;
                case 2:
                    tv.scansiona();
                    break;
                case 3:
                    if (tv.isAcceso()) {
                        System.out.print("Inserisci il numero del canale che vuoi guardare: ");
                        while (!input.hasNextInt()) {
                            System.out.println("Per favore inserisci un numero intero.");
                            input.next();
                        }
                        int numeroCanale = input.nextInt();
                        tv.guardaCanale(numeroCanale);
                    } else {
                        System.out.println("Il televisore è spento! Accendilo prima di guardare un canale.");
                    }
                    break;
                case 4:
                    tv.aumentaVolume();
                    break;
                case 5:
                    tv.diminuisciVolume();
                    break;
                case 6:
                    System.out.println("Uscita dal programma...");
                    break;
                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        } while (scelta != 6);
        
        input.close();
    }
}
