package Futbol;

import java.util.Comparator;

/**
 * Clase para realizar la ordenacion de goles
 * 
 * @author ierai
 *
 */

public class OrdenarGoles implements Comparator<Jugador>{

	@Override
	public int compare(Jugador j1, Jugador j2) {
		int resultado =0;
		if(j1== null || j2==null) {
			resultado = 0;
		}
		else if(j1.getGoles()<j2.getGoles()) {
            resultado = 1;
        }else if(j1.getGoles()>j2.getGoles()){
            resultado = -1;
        }
        return resultado;
	}
}
