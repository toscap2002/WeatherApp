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
Questo server viene avviato dalla porta 8080, (localhost:8080). Aggiungendo poi le varie richieste per chiedere le informazioni che si desiderano.

| N° | TIPO RICHIESTA | VALORE | DESCRIZIONE|
| ------------------------------------------|
| 1 | GET | /city | Questa chiamata ottiene il meteo corrente di Ancona |
| 2 | GET | /forecast | Questa chiamata restituisce le previsioni meteo dei prossimi 5 giorni ad Ancona |
| 3 | GET | /saveEveryHour | Questa chiamata salva ogni ora le informazioni sulle temperature attuali |
| 4 | GET | /statistic | Questa chiamata ritorna le statistice delle temperature |
| 5 | GET | /error | Questa chiamata restituisce l'errore tra le temperature attuali e le previsioni|

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
L'ultima rotta riporta l'errore tra le temperature attuali e le previsioni, restituendo la differenza di temperature tra le due.



## Autori
Progetto realizzato da:
* Tosca Pierro




