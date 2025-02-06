import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

public abstract class Pokemon {
    protected String nome;
    protected String tipo;
    protected int puntiSalute;
    protected int puntiAttacco;
    protected int puntiDifesa;
    protected int vittorie = 0;
    protected boolean corazzato = false;
    protected boolean volante = false;

    public Pokemon(String nome, String tipo, int puntiSalute, int puntiAttacco, int puntiDifesa) {
        this.nome = nome;
        this.tipo = tipo;
        this.puntiSalute = puntiSalute;
        this.puntiAttacco = puntiAttacco;
        this.puntiDifesa = puntiDifesa;
    }

    public abstract void attacca(Pokemon avversario);

    public abstract Map<Integer, String> opzioni();

    public void getOpzioni() {
        Map<Integer, String> opzioni = opzioni();
        opzioni.values().forEach(System.out::println);
    }

    public int scegliOpzione() {
        Map<Integer, String> opzioni = opzioni();
        List<Integer> key = new ArrayList<>(opzioni.keySet());
        Random random = new Random();
        int sceltaCasuale = key.get(random.nextInt(key.size()));
        return sceltaCasuale;
    }

    public void subisciDanno(int danno) {

        // Se il Pokémon è corazzato, il danno viene ridotto di 10
        if (corazzato) {
            danno -= 10;
            System.out.println(nome + " è corazzato e subisce 10 danni in meno!");
            disattivaCorazza();
        }
    
        // Calcolo del danno effettivo, tenendo conto della difesa
        int dannoEffettivo = 0;
        
        dannoEffettivo = danno - puntiDifesa;
    
        // Se il Pokémon è volante, il danno effettivo è 0
        if (volante) {
            dannoEffettivo = 0;
            System.out.println(nome + " sta volando e non subisce danni!");
            volante=false;
        }
    
        // Se il danno effettivo è minore di 0, impostalo a 0 (non può essere negativo)
        if (dannoEffettivo <= 0) {
            dannoEffettivo = 0;
        }
    
        // Se il danno effettivo è maggiore di 0, sottrarre dalla salute
        if (dannoEffettivo >= 0) {
            puntiSalute -= dannoEffettivo;
            System.out.println(nome + " subisce " + dannoEffettivo + " danni!");
        }
    
        // Se la salute è minore di 0, impostarla a 0
        if (puntiSalute <= 0) {
            puntiSalute = 0;
        }
    }

    public void disattivaCorazza() {
        corazzato = false;
        puntiDifesa -= 30;
        puntiAttacco += 15;
        System.out.println(nome + " ha disattivato la corazza!");
    }

    public void visualizzaStato() {
        System.out.println("Pokémon: " + nome);
        System.out.println("Tipo: " + tipo);
        System.out.println("Punti Salute: " + puntiSalute);
        System.out.println("Punti Attacco: " + puntiAttacco);
        System.out.println("Punti Difesa: " + puntiDifesa);
        System.out.println("Vittorie: " + vittorie);
        System.out.println();
    }

    protected int modificatoreDanno(String tipoAvversario) {
        switch (tipo) {

            case "Fuoco":
                if (tipoAvversario.equalsIgnoreCase("Erba")) 
                    return 5;
                 else if (tipoAvversario.equalsIgnoreCase("Elettrico")) 
                    return 0;
                else if (tipoAvversario.equalsIgnoreCase("Roccia")) 
                    return 0;
                break;

            case "Erba":
                if (tipoAvversario.equalsIgnoreCase("Fuoco")) 
                    return 0;
                 else if (tipoAvversario.equalsIgnoreCase("Roccia")) 
                    return 0;
                else if (tipoAvversario.equalsIgnoreCase("Elettrico")) 
                    return 0;
                break;

            case "Elettrico":
                if (tipoAvversario.equalsIgnoreCase("Erba")) 
                    return 5;
                else if (tipoAvversario.equalsIgnoreCase("Fuoco")) 
                    return 5;
                else if (tipoAvversario.equalsIgnoreCase("Roccia")) 
                    return 0;
                break;

            case "Roccia":
                if (tipoAvversario.equalsIgnoreCase("Erba")) 
                    return 5;
                else if (tipoAvversario.equalsIgnoreCase("Fuoco")) 
                    return 0;
                else if (tipoAvversario.equalsIgnoreCase("Elettrico")) 
                    return 0;
                break;

            default:
                return 1;
        }
        return 1;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public int getPuntiSalute() {
        return puntiSalute;
    }

    public int getPuntiAttacco() {
        return puntiAttacco;
    }

    public int getPuntiDifesa() {
        return puntiDifesa;
    }

    public boolean isCorazzato() {
        return corazzato;
    }

    public boolean isVolante() {
        return volante;
    }

    public void incrementaVittorie() {
        vittorie++;
    }
    
    public int getVittorie() {
        return vittorie;
    }
    
}