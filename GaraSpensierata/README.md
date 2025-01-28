
Scrivere un programma che simula una corsa tra 5 corridori che non hanno tanta voglia di "pensare". All'avvio del programma viene generato in maniera casuale un percorso fatto di più elementi a scelta tra (strada, buca, muro, piscina)

(chiedere all'utente di quanti elementi sarà composto il percorso)

I 5 corridori dovranno superare il percorso, scegliendo in maniera casuale (quindi in maniera "spensierata") una delle seguenti azioni (corri, salta, arrampicati, nuota)

Il corridore supererà un elemento del percorso solo se "sceglie" l'azione giusta (ad es. per superare la buca bisogna saltare)

Simulare la gara mostrando per ogni corridore le azioni scelte e il numero di elementi superati

La gara termina quando tutti i corridori sono arrivati al traguardo

Al termine della gara mostrare la classifica finale (vince chi impiega meno turni)

-----------

Esempio:

Percorso: ["buca", "muro", "strada"]

Turno 1:
c1: ["corri"] - elementi superati: 0
c2: ["SALTA"] - elementi superati: 1
c3: ["nuota"] - elementi superati: 0

Turno 2:
c1: ["corri","SALTA"] - elementi superati: 1
c2: ["SALTA","ARRAMPICATI"] - elementi superati: 2
c3: ["nuota","nuota"] - elementi superati: 0

Turno 3:
c1: ["corri","SALTA","ARRAMPICATI"] - elementi superati: 2
c2: ["SALTA","ARRAMPICATI","CORRI"] - elementi superati: 3
c3: ["nuota","nuota","SALTA"] - elementi superati: 1
Vince il corridore 2

Il programma continua fino a quando non arrivano tutti i corridori