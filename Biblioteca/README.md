## Esercizio: Biblioteca

Scrivere un programma che simula il funzionamento di una biblioteca.
La biblioteca possiede due tipologie di materiale:
- libri
    - codice interno (stringa) (attributo di istanza)
    - titolo
    - autore
    - genere
    - editore
    - isbn
    - nr pagine
    - disponibile (vero/falso)

- riviste
    - codice interno (stringa) (attributo di istanza)
    - titolo
    - editore
    - genere
    - anno
    - nr volume 
    - disponibile (vero/falso)

Il codice interno viene generato automaticamente all'aggiunta di un nuovo materiale secondo questi criteri:
    - i libri hanno un codice del tipo L0001, L0002, L0003, ecc. (tutti i libri hanno il codice che inizia per "L" seguito da un numero incrementale)
    - le riviste hanno un codice del tipo R0001, R0002, R0003, ecc. (tutte le riviste hanno il codice che inizia per "R" seguito da un numero incrementale)

Il catalogo del materiale è condiviso tra più biblioteche.
Ogni Biblioteca ha un indirizzo composto da:
- id
- via
- civico
- cap
- città

La deve fornire le seguenti funzionalità (indipendentemente dalla sede):
- aggiungi materiale (viene fornito in ingresso un libro o una rivista)
- verifica disponibilità (viene fornito il codice interno e viene restituito un valore vero/falso)
- effettua prestito (viene fornito il codice interno e se il titolo è disponibile viene impostata la disponibilità a false)
- restituisci prestito (viene fornito il codice interno e se il titolo è in prestito viene impostata la disponibilità a true)


Suggerimenti:
    - superclasse Materiale di Libri e Riviste 
        -codice interno
        -titolo
        -genere
        -disponibile
        -idBiblioteca

    - classe Biblioteca (che contiene le istanze di libri e riviste)
        attributi statici:
        - elenco materiali (lista/mappa/ecc.) 

        attributi di istanza
        - id
        - via
        - civico
        - cap
        - città

        metodi statici
        - aggiungiMateriale(Materiale) (si può passare un libro o una rivista, viene generato automaticamente il codice interno)
        - verificaDisponibilità(codice) 
        - effettuaPrestito
        - restituisciPrestito
        - trovaCollocazione(codice) restituisce un oggetto Biblioteca (dove si trova il materiale)