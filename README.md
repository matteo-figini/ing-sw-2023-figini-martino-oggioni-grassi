# Prova Finale di Ingegneria del Software - AA 2022-2023

Implementazione del gioco da tavolo [MyShelfie](http://www.craniocreations.it/prodotto/my-shelfie/).

Il progetto consiste nell’implementazione di un sistema distribuito composto da un singolo server in grado di gestire una partita alla volta e multipli client (uno per giocatore) che possono partecipare ad una sola partita alla volta utilizzando il pattern MVC (Model-View-Controller).
La rete è stata gestita con l'utilizzo delle socket o RMI.

Interazione e gameplay: linea di comando (CLI) e grafica (GUI).

## Documentazione

### UML
I seguenti diagrammi delle classi rappresentano rispettivamente il modello iniziale sviluppato durante la fase di progettazione e i diagrammi del prodotto finale nelle parti critiche riscontrate.
- [UML Iniziale](https://github.com/matteo-figini/ing-sw-2023-figini-martino-oggioni-grassi/blob/main/deliverables/initial/uml_model_initial.png)
- [UML Finali](https://github.com/matteo-figini/ing-sw-2023-figini-martino-oggioni-grassi/blob/main/deliverables/final/uml/Class%20Diagram/final_uml.png)
- [Sequence Diagrams](https://github.com/matteo-figini/ing-sw-2023-figini-martino-oggioni-grassi/blob/main/deliverables/final/uml/Sequence%20Diagrams/)

### JavaDoc
La seguente documentazione include una descrizione per la maggior parte delle classi e dei metodi utilizzati, segue le tecniche di documentazione di Java e può essere consultata al seguente indirizzo:
[Javadoc]() DA AGGIUNGERE

### Coverage report
Al seguente link è possibile consultare il report della coverage dei test effettuati con Junit: 
[Report]() DA AGGIUNGERE

### Librerie e Plugins
|Libreria/Plugin|Descrizione|
|---------------|-----------|
|__Maven__|Strumento di automazione della compilazione per progetti Java.|
|__JavaFx__|Libreria grafica per realizzare interfacce utente.|
|__JUnit__|Framework di unit testing.|

## Funzionalità
### Funzionalità Sviluppate
- _Set di regole_: Regole Complete
- _Interfaccia grafica_: CLI e GUI
- _Connessioni di rete_: Socket e RMI
- 2 FA (Funzionalità Avanzate):
    - __Persistenza:__ Fare in modo che il server salvi periodicamente lo stato della partita su disco, in modo
che l'esecuzione possa riprendere da dove si è interrotta anche a seguito del crash del server stesso.
Per riprendere una partita, i giocatori si dovrenno ricollegare al server utilizzando gli stessi nickname
una volta che questo sia tornato attivo. Si assume che il disco costituisca una memoria totalmente
affidabile.
    - __Resilienza alle disconnessioni:__ I giocatori disconnessi a seguito della caduta della rete o del crash
del client, possono ricollegarsi e continuare la partita. Mentre un giocatore non è collegato, il gioco
continua saltando i turni di quel giocatore. Se rimane attivo un solo giocatore, il gioco viene sospeso
fino a che non si ricollega almeno un altro giocatore oppure scade un timeout che decreta la vittoria
dell'unico giocatore rimasto connesso.

## Utilizzo
Per poter eseguire il gioco, è necessario posizionarsi nella cartella _/deliverables/final/jar_ e avviare il 
terminale da questa posizione.
Per avviare il server, eseguire il comando:
```
java -jar '.\My Shelfie-server.jar'
```
È possibile avviare al più un'istanza del server su una singola macchina.

Per avviare il client, eseguire il comando:
```
java -jar '.\My Shelfie-client.jar'
```
Qualora si voglia operare con la modalità a linea di comando (CLI) è necessario aggiungere il parametro "-c" oppure 
"--cli" durante il lancio dell'applicazione.

Per quanto riguarda la scelta delle connessioni, se il server è correttamente istanziato, al client è chiesto in fase di 
inizializzazione sia l'indirizzo IP della macchina su cui è ospitato il server sia la porta da utilizzare. 
Per quanto riguarda la connessione Socket la porta di default attiva sul server è la porta 5000, mentre per quanto 
riguarda la connessione RMI la porta di default aperta sul server è la porta 1099. Attenzione, è necessario abbinare
correttamente la porta inserita alla connessione scelta.

Nella cartella in cui è presente il file "My Shelfie-server.jar" viene periodicamente creato e aggiornato un file di nome
"match.data" contenente le informazioni di gioco necessarie per l'implementazione della persistenza; informazioni che poi
vengono cancellate assieme al file al termine della partita. All'avvio del gioco, qualora il file non venga trovato o 
venga spostato, il server ne interpreta l'assenza come assenza di informazioni salvate e inizia comunque una nuova partita.

Per quanto riguarda l'implementazione della resilienza alle disconnessioni, qualora rimanga solamente un giocatore 
connesso alla partita il gioco viene sospeso indefinitamente fino al momento in cui uno dei giocatori già presenti (ovvero
con lo stesso nickname) si riconnette, come da specifica richiesta. Se non rimangono giocatori connessi, il gioco termina: 
può essere ripreso al riavvio del server combinando l'implementazione della resilienza alle disconnessioni con 
l'implementazione della persistenza.

### Requisiti di sistema
È necessario essere in possesso di una versione di JRE (_Java Runtime Environment_) che supporti la versione numero 20 di
Java.

## Componenti del gruppo
- [__Matteo Figini__](https://github.com/matteofigini)
- [__Simone Oggioni__](https://github.com/Simone-Oggioni21)
- [__Federico Grassi__](https://github.com/Fede-g01)
- [__Marianna Martino__](https://github.com/mariannamartino)
