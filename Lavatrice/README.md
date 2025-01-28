Scrivere una classe “Lavatrice” che contiene i seguenti attributi:

boolean sportelloChiuso (indica se lo sportello è chiuso)
int stato (0: spenta; 1:standby; 2: lavaggio in corso). Eventualmente gestire con Enum
boolean detersivoPresente (indica se è stato aggiunto il detersivo)
int temperatura
e i seguenti metodi;

void accendi()
void spegni()
void apriSportello()
void chiudiSportello()
void aggiungiDetersivo()
void impostaTemperatura(int temperatura)
void avviaLavaggio() (mostra il messaggio “lavaggio in corso a x gradi”, dove “x” è la temperatura)
void terminaLavaggio() (mostra il messaggio “lavaggio terminato”)
aggiungere costruttore e opportuni getter e setter, e fare in modo da impedire un utilizzo inappropriato della lavatrice (ad esempio si può avviare il lavaggio solo se lo sportello è chiuso, il detersivo è presente e la lavatrice è in standby)

Bonus:

gestire tutti i messaggi nella classe App, rendendo utilizzabile la classe Lavatrice anche in applicazioni non testuali.
Aggiungere voce di menu (nella classe App) imposta lingua che, se la lingua è supportata, visualizza i messaggi nella lingua scelta