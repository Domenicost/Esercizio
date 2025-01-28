import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean trovato = false;

        ArrayList<Persona> elencoPersone=new ArrayList<>();

        elencoPersone.add(new Persona("Mario", "Rossi", LocalDate.of(1995, 6, 15), "Marior", "mario123" ));
        elencoPersone.add(new Impiegato("Pino", "Gialli", LocalDate.of(1995, 2, 13),"Pinog", "pino123", "12321",1600,LocalDate.now()));
        elencoPersone.add(new Professionista("Gino", "Marroni", LocalDate.of(1998, 1, 8),"Ginom", "gino123", "12354654413",LocalDate.now()));

        //Login
        System.out.println("ACCEDI: ");
        System.out.print("Inserisci username: ");
        String user = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String psw = scanner.nextLine();

        Persona autorizzata = null;

        // Controllo dell'username e della password
        for (Persona p : elencoPersone) {
            if (p.getUsername().equals(user) && p.getPassword().equals(psw)) {
                System.out.println("Benvenuto " + p.getNome() + " " + p.getCognome());
                trovato = true;
                autorizzata = p;

            }

        }
        if (!trovato)
            System.out.println("Username o password errati");
        int scelta = 0;

        if (autorizzata instanceof Persona)
            autorizzata.saluta();
        if (autorizzata instanceof Impiegato) { // verifico se persona è anche un impiegato
            Impiegato i = (Impiegato) autorizzata;
            do {
                System.out.println("1. Ricevi aumento");
                System.out.println("2. Ricevi cedolino");
                System.out.println("3. Visualizza cedolino");
                System.out.println("4. Esci");

                System.out.print("Scegli: ");
                scelta = scanner.nextInt();

                switch (scelta) {
                    case 1:
                        i.riceviAumento(1000);
                        System.out.println("Il mio stipendio è " + i.getStipendio());
                        break;

                    case 2:
                        i.riceviCedolino(LocalDate.now(), 20.5);
                        break;

                    case 3: 
                       i.visualizzaCedolini(2024);  
                       break;  

                    default: 
                    System.out.println("Opzione non valida");
                        break;
                }

            } while (scelta != 4);


        }
        if (autorizzata instanceof Professionista) { 
            Professionista pr = (Professionista) autorizzata;
            do {
                System.out.println("1. Visualizza fatturato");
                System.out.println("2. Emetti fattura");
                System.out.println("3. Visualizza fattura");
                System.out.println("4. Esci");

                System.out.print("Scegli: ");
                scelta = scanner.nextInt();

                switch (scelta) {
                    case 1:
                        System.out.println("Il tuo fatturato é di: " + pr.getFatturato());
                        break;

                    case 2:
                        pr.emettiFattura(LocalDate.of(2024, 10, 11), "Mario", 200.0);
                        break;

                    case 3: 
                       pr.visualizzaFatture("Mario");
                       break;  

                    default: 
                    System.out.println("Opzione non valida");
                        break;
                }

            } while (scelta != 4);
             
            

        }

        scanner.close();
    }
}