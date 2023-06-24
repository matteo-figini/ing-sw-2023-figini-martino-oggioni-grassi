# Prova Finale di Ingegneria del Software - AA 2022-2023

AGGIUNGERE UN'IMMAGINE (?)

Implementazione del gioco da tavolo [MyShelfie](http://www.craniocreations.it/prodotto/my-shelfie/).

Il progetto consiste nell’implementazione di un sistema distribuito composto da un singolo server in grado di gestire una partita alla volta e multipli client (uno per giocatore) che possono partecipare ad una sola partita alla volta utilizzando il pattern MVC (Model-View-Controller).
La rete è stata gestita con l'utilizzo delle socket o RMI.

Interazione e gameplay: linea di comando (CLI) e grafica (GUI).

## Documentazione

### UML
I seguenti diagrammi delle classi rappresentano rispettivamente il modello iniziale sviluppato durante la fase di progettazione e i diagrammi del prodotto finale nelle parti critiche riscontrate.
- [UML Iniziali](https://github.com/matteo-figini/ing-sw-2023-figini-martino-oggioni-grassi/blob/main/deliverables/Class%20Diagram/uml_model_initial.png)
- [UML Finali]() DA AGGIUNGERE (?)

### JavaDoc
La seguente documentazione include una descrizione per la maggior parte delle classi e dei metodi utilizzati, segue le tecniche di documentazione di Java e può essere consultata al seguente indirizzo:
[Javadoc]() DA AGGIUNGERE

### Coverage report
Al seguente link è possibile consultare il report della coverage dei test effettuati con Junit: 
[Report]() DA AGGIUNGERE

### Librerie e Plugins
|Libreria/Plugin|Descrizione|
|---------------|-----------|
|__Maven__|Strumento di automazione della compilazione utilizzato principalmente per progetti Java.|
|__JavaFx__|Libreria grafica per realizzare interfacce utente.|
|__JUnit__|Framework di unit testing.|

## Funzionalità
### Funzionalità Sviluppate
- Regole Complete
- TUI
- CLI
- GUI
- Socket
- RMI
- 2 FA (Funzionalità Avanzate):
    - __Persistenza:__ Fare in modo che il server salvi periodicamente lo stato della partita su disco, in modo
che l'esecuzione possa riprendere da dove si è interrotta anche a seguito del crash del server stesso.
Per riprendere una partita, i giocatori si dovrenno ricollegare al server utilizzando gli stessi nickname
una volta che questo sia tornato attivo. Si assume che il disco costituisca una memoria totalmente
affidabile.
    - __Resilienza:__ Resilienza alle disconnessioni: I giocatori disconnessi a seguito della caduta della rete o del crash
del client, possono ricollegarsi e continuare la partita. Mentre un giocatore non è collegato, il gioco
continua saltando i turni di quel giocatore. Se rimane attivo un solo giocatore, il gioco viene sospeso
fino a che non si ricollega almeno un altro giocatore oppure scade un timeout che decreta la vittoria
dell'unico giocatore rimasto connesso.

## Componenti del gruppo
- [__Matteo Figini__](https://github.com/matteofigini)
- [__Simone Oggioni__](https://github.com/Simone-Oggioni21)
- [__Federico Grassi__](https://github.com/Fede-g01)
- [__Marianna Martino__](https://github.com/mariannamartino)
