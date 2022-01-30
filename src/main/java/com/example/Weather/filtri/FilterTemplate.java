package com.example.Weather.filtri;

import com.example.Weather.model.Lista;
import org.json.JSONObject;

/**
 * interfaccia per definire la struttura di una classe filtro
 */
public interface FilterTemplate {

    /**
     * Il metodo riceve in input un json contenente i parametri su cu effettuare il filtro. Filtraggio possibile per:
     * <ul>
     *     <li>orario</li>
     *     <li>giorno</li>
     *     <li>settimana</li>
     * </ul>
     * @param json
     * @return
     */
    public Lista filter(JSONObject json, Lista l);

}
