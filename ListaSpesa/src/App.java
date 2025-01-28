import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserisci la lista della spesa (Invio per terminare)");
        String prodotto = sc.nextLine();
        ArrayList<String> listaSpesa = new ArrayList<>();

        // A casa
        while (!prodotto.isEmpty()) {
            listaSpesa.add(prodotto);
            prodotto = sc.nextLine();
        }

        System.out.println();

        // In negozio
        System.out.println("Ora rimuovi i prodotti che hai acquistato");

        while (!listaSpesa.isEmpty()) {

            System.out.print("La tua lista della spesa comprende: ");
            for (int i = 0; i < listaSpesa.size(); i++) {
                System.out.print(listaSpesa.get(i));
                if (i != listaSpesa.size() - 1){
                    System.out.print(", ");
                }
            }

            System.out.println("\nCosa hai acquistato? ");
            prodotto = sc.nextLine();
            if (!listaSpesa.remove(prodotto)) {
                System.out.println("Prodotto non presente in lista");
            }
        }

        System.out.println("La tua spesa è terminata");

        sc.close();
    }
}