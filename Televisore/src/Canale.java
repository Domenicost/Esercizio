public class Canale {
    
        int numero;
        String nome;
        double frequenza;
        int potenza;
        
        public Canale(int numero, String nome, double frequenza, int potenza) {
            this.numero = numero;
            this.nome = nome;
            this.frequenza = frequenza;
            this.potenza = potenza;
        }
        
        @Override
        public String toString() {
            return "Canale " + numero + " - " + nome + " (freq: " + frequenza + "MHz, potenza: " + potenza + ")";
        }
    }