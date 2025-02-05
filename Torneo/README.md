## Esercizio: Torneo di Pokémon

Scrivere un programma che simula un torneo di Pokémon.
Ogni Pokémon avrà degli attributi e dei comportamenti comuni, mentre altri varieranno in base alla tipologia di Pokémon.

### Classi da realizzare:

- Classe Pokémon (astratta)
    Attributi:
        - nome (String)
        - tipo (String) indica la tipologia di Pokémon ("Fuoco", "Acqua", "Erba", ecc.)
        - puntiSalute (int)
        - puntiAttacco (int)
        - puntiDifesa (int)

    Metodi:
        - attacca(Pokémon avversario)  (astratto): diminuisce la salute del Pokémon avversario, in base alla tipologia di Pokémon.  La formula di calcolo del danno dipende dalla combinazione Pokémon/avversario (ad esempio se un Pokémon di tipo "Fuoco" attacca un Pokémon di tipo "Erba" il danno aumenta del 25%)
        - subisciDanno(int danno): la salute diminuisce del valore indicato
        - visualizzaStato(): mostra le informazioni sul Pokémon (nome, salute, ecc.)

### Interfacce da realizzare:

- IEvolvibile:
    Metodi:
        - evolvi(): permette al Pokémon di evolversi (cambia il nome, punti attacco, difesa, salute). Per evolversi un Pokémon deve ottenere almeno 1 vittoria

- IAttaccoSpeciale:
    Metodi:
        - eseguiMossaSpeciale(Pokémon avversario): simile all'attacco, ma causa danni maggiori

- IVolante:
    Metodi:
        - vola(): per il turno successivo l'avversario non può attaccare

- ICorazzato:
    Metodi:
        - attivaCorazza(): per il turno successivo aumenta la sua difesa e diminuisce il suo attacco

### Classi concrete: per ogni Pokémon realizzare una classe che eredita dalla classe astratta e implementa una o più interfacce

Esempio:
    - Pikachu (eredita da Pokémon, implementa IEvolvibile, IAttaccoSpeciale)
    - Charizard (eredita da Pokémon, implementa IEvolvibile, IAttaccoSpeciale, IVolante)
    - Crea altri 2 pokemon di tipo diverso

### Classe Main:
    - simulare una battaglia tra due allenatori (crea classe allenatore). Ogni allenatore ha a disposizione 2 Pokémon, di cui ne può schierare solo 1 alla volta.
    - si procede a turni: quando attacca l'allenatore 1, l'allenatore 2 si difende e viceversa
    - in ogni turno gli allenatori possono decidere di attivare una o più azioni (se disponibili)
    - dopo ogni turno visulizzare le statistiche aggiornate dei Pokémon. Se un Pokémon raggiunge la salute 0 deve essere sostituito con un altro (se disponibile, altrimenti la battaglia finisce e l'allenatore che non ha più Pokémon schierabili ha perso)