import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Persona {
    private String nome,cognome;
    private LocalDate dataNascita;
    private String username;
    private String password;
   
    public Persona(String nome, String cognome, LocalDate dataNascita, String username, String password) {
        setNome(nome);       
        setCognome(cognome);
        this.password=password;
        this.username=username;
        
        if (dataNascita.isBefore(LocalDate.now()))
            this.dataNascita = dataNascita;
        else
            throw new IllegalArgumentException("Data di nascita non valida"); 
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.trim().isEmpty())
            this.nome = nome;
        else
            throw new IllegalArgumentException("Nome non valido");  //se il nome è vuoto genero un'eccezione
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        if (!cognome.trim().isEmpty())
            this.cognome = cognome;
        else
            throw new IllegalArgumentException("Cognome non valido");  //se il nome è vuoto genero un'eccezione
    }

    public void saluta() {
        DateTimeFormatter df=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.printf("Ciao mi chiamo %s %s e sono nato il %s%n",nome,cognome,dataNascita.format(df));
    }

    

    
    
}