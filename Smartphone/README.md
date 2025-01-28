## Esercizio: Smartphone

Creare una classe "Smartphone" e una classe "SIM" per simulare il comportamento di uno smartphone e della SIM dati.

**Classe SIM**

Rappresenta una SIM dati.

Attributi:

* String numero: il numero di telefono della SIM.
* String operatore: l'operatore telefonico.
* double credito: il credito residuo.
* costoPerMinuto: il costo per ogni minuto di chiamata
* costoSMS: il costo di un sms

Metodi:

* Costruttore per inizializzare numero, operatore e credito.
* Metodo double verificaCredito(): restituisce il credito attuale.
* Metodo void ricarica(double importo): aggiunge credito alla SIM.
* Metodo void scalaCredito(double costo): scala credito per una chiamata o un messaggio (se sufficiente).

**Classe Smartphone**

Rappresenta uno smartphone con una SIM.

Attributi:

* String modello: il modello dello smartphone.
* String marca: la marca dello smartphone.
* SIM sim: l'oggetto SIM associato.
* List<String> contatti: una lista di contatti (nome e numero).
* List<String> registroChiamate: una lista delle chiamate effettuate (numero chiamato e durata).
  Metodi:

Metodi:

* Costruttore per inizializzare modello, marca e associare una SIM.
* Metodo void aggiungiContatto(String nome, String numero): aggiunge un contatto alla lista.
* Metodo List<String> visualizzaContatti(): restituisce la lista dei contatti.
* Metodo void effettuaChiamata(String numero, int durata): simula una chiamata verso un numero, aggiungendo il numero al registro chiamate e scalando il credito in base alla durata.
  Verificare se il numero chiamato esiste all'interno dei contatti, nel qual caso mostrare il nome associato
* Metodo inviaSMS(String numero): invia un sms al numero specificato, scalando il credito.
  Verificare se il numero chiamato esiste all'interno dei contatti, nel qual caso mostrare il nome associato
* Metodo List<String> visualizzaRegistroChiamate(): restituisce il registro delle chiamate.
* Metodo void cambiaSIM(SIM nuovaSim): sostituisce la SIM attuale con una nuova.