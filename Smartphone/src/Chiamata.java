import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Chiamata {
    private String numero;
    private int durata;
    private LocalDateTime dataOra; 

    public Chiamata(String numero, int durata, LocalDateTime dataOra) {
        this.numero = numero;
        this.durata = durata;
        this.dataOra = dataOra;
    }

    @Override
    public String toString() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Numero: " +  numero + ", Durata: " + durata + " Quando: " + dataOra.format(f);
    }
}