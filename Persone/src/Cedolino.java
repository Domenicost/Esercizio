import java.time.LocalDate;

public class Cedolino {
    private LocalDate data;
    private double importo;

    public Cedolino(LocalDate data, double importo) {
        if (data == null || importo <= 0) {
            throw new IllegalArgumentException("Dati del cedolino non validi");
        }
        this.data = data;
        this.importo = importo;
    }

    public LocalDate getData() {
        return data;
    }

    public double getImporto() {
        return importo;
    }

    @Override
    public String toString() {
        return "Cedolino [data=" + data + ", importo=" + importo + "]";
    }
}
