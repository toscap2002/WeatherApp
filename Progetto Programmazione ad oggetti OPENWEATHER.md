# Programmazione ad oggetti: OPENWEATHER
## Introduzione
Il progetto sviluppa un'applicazione Java, la quale data una città italiana, faccia visualizzare tutte le informazioni attuali temperature effettive  e alle previsioni per i successivi 5 giorni. 

* Il servizio salverà le informazioni attuali ogni ora, infine genererà delle statistiche riguardanti valori minimi, massimi, media e varianza di temperature reali. 

* In fine calcolerà la soglia di errore tra il forecast e l'attuale.

## Rotte
| TIPO RICHIESTA | VALORE | DESCRIZIONE|
| ----------------------------------------------------|
| GET | /city | Restituisce il meteo corrente di Ancona |
| GET | /forecast | Restituisce le previsioni meteo dei prossimi 5 giorni ad Ancona |
| GET | /saveEveryHour | Salva ogni ora le informazioni sulle temperature attuali |
| GET | /statistic | Restituisce le statistice delle temperature |
| GET | /error | Restituisce l'errore tra le temperature attuali e le previsioni|

## Funzionamento
### . /city
---------
La prima rotta riporta le informazioni sulle temperature attuali della città di Ancona, restituendo un JSONObject contenente tulle le informazioni.

### . /forecast
------------
La seconda rotta restituisce un JSONArray contenente le previsioni per i prossimi 5 giorni con tulle le temperature .

### . /saveEveryHour
-----------------------
La terza rotta salva le informazioni attuali sulle temperature di Ancona. Viene creato un file "HourlyReport.txt" che si aggiornerà ogni 3 ore. 

### . /statistic
---------------
La quarta rotta riporta un JSONObject contenente le statistiche riguardanti le temperature: di massima, minima, media e varianza.

### . /error
-------------
L'ultima rotta riporta l'errore tra le temperature attuali e il forecast restituendo la differenza di temperature tra le due.



## Autori
Progetto realizzato da:
* Tosca Pierro
* Giorgia Pelliccia



