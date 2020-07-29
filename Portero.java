package Futbol;

/**
 * Clase portero
 * 
 * @author ierai
 *
 */
public class Portero extends Jugador{
	
	private int paradas;

	public Portero(int dorsal, String nombre, TipoEquipo equipo) {
		super(dorsal, nombre, equipo);
	}

	
	
	public Portero() {
		super();
	}


	//GETTERS Y SETTERS

	public int getParadas() {
		return paradas;
	}


	//METODOS
	
	public void contabilizarParadas(int paradasMas) {
		if(paradasMas == 0) {
			this.paradas = this.getParadas()+1;
		}else {
			this.paradas = this.getParadas()+paradasMas;
	
		}
	}
	@Override
	/**
	 * @return Valoracion del jugador
	 */
	public int obtenerValoracion() {
		
		return getGoles()*10 + getParadas()*5;
	}



	@Override
	public String toString() {
		return "Portero [paradas=" + paradas + "]"+ super.toString()+
				"Valoracion: "+obtenerValoracion();
	}

	
	
	
}
