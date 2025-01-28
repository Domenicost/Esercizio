import java.util.Scanner;

public class Casuale {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci nome: ");
        String nome = scanner.nextLine();

        String invertita = new StringBuilder(nome).reverse().toString();
        
        if (nome.equals(invertita))
        System.out.println("Palindroma");
        else
        System.out.println("Non è palindroma"); 

    }
}
