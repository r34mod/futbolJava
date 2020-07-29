package Futbol;

/**
 * Clase jugador de campo 
 * 
 * @author ierai
 *
 */

public abstract class JugadorCampo extends Jugador{

	
	private int pases;
	private int recuperados;
	
	
	public JugadorCampo(int dorsal, String nombre, TipoEquipo equipo) {
		super(dorsal, nombre, equipo);
	}


	public JugadorCampo() {
		super();
	}

	//GETTERS Y SETTERS
	
	public int getPases() {
		return pases;
	}


	public int getRecuperados() {
		return recuperados;
	}
	
	
	//METODOS
	
	/**
	 * 
	 * @param pasesMas  (Numero de pases recuperados)
	 */
	
	public void contabilizarPases(int pasesMas) {
		if(pasesMas == 0) {
			this.pases = this.getPases()+1;
		}else {
			this.pases = this.getPases()+pasesMas;
		}
		
	}
	
	
	/**
	 * 
	 * @param recuperarMas  (Numero de balones recuperados)
	 */
	
	public void contabilizarRecuperados(int recuperarMas) {
		if(recuperarMas == 0) {
			this.recuperados = this.getRecuperados()+1;
		}else {
			this.recuperados = this.getRecuperados()+recuperarMas;
		}
	}
	
	
	public abstract int obtenerValoracion();


	@Override
	public String toString() {
		return super.toString() + " , recuperados "+ this.getRecuperados()+ " y pases "+ this.getPases();
	}
	
	
	
	
}
