import java.util.HashMap;
import java.util.Map;

class Venusaur extends Pokemon implements IAttaccoSpeciale {
    public Venusaur() {
        super("Venusar", "Erba", 100, 50, 10);
    }

    @Override
    public void attacca(Pokemon avversario) {
        int danno = puntiAttacco + modificatoreDanno(avversario.tipo);
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha inflitto " + danno + " danni a " + avversario.nome);
    }

    @Override
    public void eseguiMossaSpeciale(Pokemon avversario) {
        int danno = puntiAttacco + 20 + modificatoreDanno(avversario.tipo);
        avversario.subisciDanno(danno);
        System.out.println(nome + " ha usato la mossa speciale e ha inflitto " + danno + " danni a " + avversario.nome);
    }

    @Override
    public Map<Integer, String> opzioni() {
        
        Map<Integer, String> opzioni = new HashMap<>();
        opzioni.put(1, "1. Attacca");
        opzioni.put(2, "2. Mossa Speciale");
        return opzioni;
    }

    


    @Override
    public String toString() {
        return "Venusaur";
    }

    
}