package Futbol;

import java.util.Comparator;

/**
 * Clase para realizar la ordenacion de pases
 * 
 * @author ierai
 *
 */

public class OrdenarPases implements Comparator<Jugador>{

	@Override
	public int compare(Jugador j1, Jugador j2) {
        int resultado=0;
        if(((JugadorCampo)j1==null) || ((JugadorCampo)j2)==null){
        	resultado = 0;
        }
        else if(((JugadorCampo)j1).getPases()<((JugadorCampo)j2).getPases()) {
            resultado = -1;
        }else if(((JugadorCampo)j1).getPases()>((JugadorCampo)j2).getPases()){
            resultado = 1;
        }
        return resultado;
    }

	
}
