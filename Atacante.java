package Futbol;


/**
 * Clase atacante
 * 
 * @author ierai
 *
 */
public class Atacante extends JugadorCampo{


	
	public Atacante() {
		super();
		
	}

	public Atacante(int dorsal, String nombre, TipoEquipo equipo) {
		super(dorsal, nombre, equipo);
		
	}

	@Override
	/**
	 * @return Valoracion del jugador
	 */
	public int obtenerValoracion() {
		
		return getGoles()*30 + getPases()*1 + getRecuperados()*3 ;
	}

	@Override
	public String toString() {
		return "Atacante "+super.toString()+ " Valoracion: "+ obtenerValoracion();
	}

	
	
}
