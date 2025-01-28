import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] Campo = new char[3][3];

        // Inizializza la griglia con '-'
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Campo[i][j] = '-';
            }
        }

        System.err.println("-------------------------");
        System.err.println("Tic Tac Toe");
        System.err.println("-------------------------");
        
        char giocatore1 = 'X';
        char giocatore2 = 'O';

        boolean turnoGiocatore1 = true;
        Random rand = new Random();
        
        for (int mossa = 0; mossa < 9; mossa++) {
            char simboloCorrente = turnoGiocatore1 ? giocatore1 : giocatore2;
            
            // Mostra chi sta giocando
            if (turnoGiocatore1) {
                System.err.println("Mossa numero " + (mossa + 1) + " - Giocatore Utente (" + simboloCorrente + ")");

                int sceltaColonna = 0;
                int sceltaRiga = 0;
                boolean inputValido = false;

                while (!inputValido) {
                    System.err.print("In che colonna vuoi inserirla? (1-3): ");
                    sceltaColonna = scanner.nextInt();

                    System.err.print("In che riga vuoi inserirla? (1-3): ");
                    sceltaRiga = scanner.nextInt();

                    // Controllo validità coordinate (1-3)
                    if (sceltaColonna < 1 || sceltaColonna > 3 || sceltaRiga < 1 || sceltaRiga > 3) {
                        System.err.println("Coordinate non valide. Inserire valori tra 1 e 3.");
                        continue; 
                    }

                    // Controllo se la casella è libera
                    if (Campo[sceltaRiga - 1][sceltaColonna - 1] != '-') {
                        System.err.println("Casella già occupata, scegline un'altra.");
                        continue; 
                    }

                    // Input valido
                    Campo[sceltaRiga - 1][sceltaColonna - 1] = simboloCorrente;
                    inputValido = true;
                }

            } else {
                System.err.println("Mossa numero " + (mossa + 1) + " - Giocatore Computer (" + simboloCorrente + ")");
                
                boolean sceltaFatta = false;
                while (!sceltaFatta) {
                    int rigaRandom = rand.nextInt(3);    // da 0 a 2
                    int colonnaRandom = rand.nextInt(3); // da 0 a 2

                    if (Campo[rigaRandom][colonnaRandom] == '-') {
                        Campo[rigaRandom][colonnaRandom] = simboloCorrente;
                        sceltaFatta = true;
                    }
                }
            }

            // Stampa della griglia aggiornata
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(Campo[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println(); // riga vuota tra una mossa e l'altra

            // Controllo del vincitore
            char winner = '-';

            // Controllo righe
            for (int i = 0; i < 3; i++) {
                if (Campo[i][0] != '-' && Campo[i][0] == Campo[i][1] && Campo[i][1] == Campo[i][2]) {
                    winner = Campo[i][0];
                }
            }

            // Controllo colonne
            for (int j = 0; j < 3; j++) {
                if (Campo[0][j] != '-' && Campo[0][j] == Campo[1][j] && Campo[1][j] == Campo[2][j]) {
                    winner = Campo[0][j];
                }
            }

            // Controllo diagonali
            if (Campo[0][0] != '-' && Campo[0][0] == Campo[1][1] && Campo[1][1] == Campo[2][2]) {
                winner = Campo[0][0];
            }
            if (Campo[0][2] != '-' && Campo[0][2] == Campo[1][1] && Campo[1][1] == Campo[2][0]) {
                winner = Campo[0][2];
            }

            // Se c'è un vincitore
            if (winner == 'X') {
                System.out.println("Ha vinto il Giocatore Utente (X)!");
                break;
            } else if (winner == 'O') {
                System.out.println("Ha vinto il Giocatore Computer (O)!");
                break;
            }

            // Cambia turno
            turnoGiocatore1 = !turnoGiocatore1;

            // Se siamo all'ultima mossa (mossa = 8) e non c'è vincitore, è pareggio
            if (mossa == 8) {
                System.out.println("Pareggio! Non ci sono più mosse disponibili.");
            }
        }

        scanner.close();
    }
}
