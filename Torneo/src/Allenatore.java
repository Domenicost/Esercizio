import java.util.ArrayList;

public class Allenatore {
    private String nome;
    private ArrayList<Pokemon> squadra;

    public Allenatore(String nome, ArrayList<Pokemon> squadra) {
        this.nome = nome;
        this.squadra = squadra;
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<Pokemon> getSquadra() {
        return squadra;
    }

    public void StatoSquadra() {
        if (squadra.size() != 0) {
            for (Pokemon p : squadra) {
                p.visualizzaStato();
            }
        } else {
            System.out.println("Nessun Pokémon in squadra.");
        }
    }
}