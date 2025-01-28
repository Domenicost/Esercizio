Scrivere un programma che simula un partita a tris (tic-tac-toe) tra l'utente e il computer.

l'utente inizia per primo e ha sempre il segno "X"
si gioca a turno: dopo ogni mossa si cambia giocatore (utente/computer)
obiettivo del gioco: piazzare il proprio segno su tre caselle allineate (orizzontale/verticale/obbliquo)
Il programma va sviluppato a passi successivi:

#passo 1: gioca solo l'utente. Il programma chiede in che posizione (riga,colonna) inserire la X e viene mostrata la griglia con la X nel posto indicato. Le caselle vuote mostreranno invece il simbolo "-"

Esempio: Inserisci la riga: 1 Inserisci la colonna: 2

- - -
- - X
- - -

#passo 2: ripetere l'inserimento fino a quando non si completano tutte le caselle. Verificare che l'utente non scelga una casella già occupata oppure non valida (es: riga 5, colonna 0)

#passo 3: alternare i simboli inseriti nella griglia ("X" e "O")

Esempio: Inserisci la riga: 1 Inserisci la colonna: 2

- - -
- - X
- - -

Inserisci la riga: 1
Inserisci la colonna: 1

- - -
- O X
- - -

Inserisci la riga: 0
Inserisci la colonna: 0

X - -
- O X
- - -
terminare sempre quando si riempiono tutte le caselle

#passo 4: il simbolo "O" viene piazzato dal computer generando in maniera casuale riga e colonna (vericare che non sia già occupata) Mostrare, per ogni turno, qual è il giocatore corrente (utente o computer)

#passo 5: verificare, dopo ogni turno, se c'è un vincitore (se qualcuno ha fatto "tris"). Se tutte le caselle vengono occupate e nessuno ha fatto tris, mostrare un messaggio "Pareggio"