# Programmazione ad oggetti: OPENWEATHER

## Indice
* Introduzione
* Rotte
* Funzionamento

## Introduzione
* Il progetto sviluppa un'applicazione Java, la quale data una città italiana, faccia visualizzare tutte le informazioni attuali relative alle temperature effettive  e alle previsioni per i successivi 5 giorni. 

* Il servizio salverà le informazioni attuali ogni ora, infine genererà delle statistiche riguardanti valori minimi, massimi, media e varianza di temperature reali. 

* In fine il servizio calcolerà la soglia di errore tra le previsioni meteo e il meteo attuale.

## Rotte
Questo server viene avviato dalla porta 80, (localhost:80). Aggiungendo poi le varie richieste per chiedere le informazioni che si desiderano.



| N° | TIPO RICHIESTA | VALORE | DESCRIZIONE|
| ---|----------------|--------|------------|
| 1 | GET | /city | Questa chiamata ottiene il meteo corrente di Ancona |
| 2 | GET | /forecast | Questa chiamata restituisce le previsioni meteo dei prossimi 5 giorni ad Ancona |
| 3 | GET | /saveEveryHour | Questa chiamata salva ogni ora le informazioni sulle temperature attuali |
| 4 | GET | /statistic | Questa chiamata ritorna le statistice delle temperature |
| 5 | GET | /error | Questa chiamata restituisce l'errore tra le temperature attuali e le previsioni|
| 6 | POST | /filter | Questa chiamata permette recuperare dal file o dalle api del forecast il meteo della città e poi filtra la lista in base ai parametri inseriti nel json di input|

## Funzionamento
### 1. /city
-------------
La prima rotta riporta le informazioni sulle temperature attuali della città di Ancona, restituendo il tutto con un JSONObject.

### 2. /forecast
------------
La seconda rotta restituisce un JSONArray contenente le previsioni per i prossimi 5 giorni con tulle le temperature.

### 3. /saveEveryHour
-----------------------
La terza rotta salva le informazioni attuali sulle temperature di Ancona. Viene creato un file "HourlyReport.txt" che si aggiornerà ogni 3 ore. 

### 4. /statistic
---------------
La quarta rotta riporta un JSONObject contenente le statistiche riguardanti le temperature di massima, di minima, di media e di varianza.

### 5. /error
-------------
La quinta rotta riporta l'errore tra le temperature attuali e le previsioni, restituendo la differenza di temperature tra le due.

### 6. /filter
-------------
L'ultima rotta riceve in input un json tramite il body della richiesta in POST e filtra le informazioni in base ai parametri inseriti in quest'ultimo.


## Strumenti utilizzati
* IntelliJ IDE
* Postman
* OpenWeatherMap Api
* MarkDown Monster



## Autori
Progetto realizzato da:
* Tosca Pierro



