package Futbol;


/**
 * Clase defensa
 * 
 * @author ierai
 *
 */
public class Defensa extends JugadorCampo{

	
	
	public Defensa() {
		super();
		
	}

	public Defensa(int dorsal, String nombre, TipoEquipo equipo) {
		super(dorsal, nombre, equipo);
		
		
	}

	@Override
	/**
	 * @return Valoracion del jugador
	 */
	public int obtenerValoracion() {
		
		return getGoles()*20 + getPases()*1 + getRecuperados()*4;
	}

	@Override
	public String toString() {
		return "Defensa "+super.toString()+ " Valoracion: "+obtenerValoracion();
	}

	
}
