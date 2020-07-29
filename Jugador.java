package Futbol;

/**
 * Clase jugador
 * 
 * @author ierai
 *
 */

public abstract class Jugador{
	
	private int dorsal;
	private String nombre;
	private int goles;
	private TipoEquipo equipo;
	
	public Jugador(int dorsal, String nombre, TipoEquipo equipo) {
		super();
		try {
			if(dorsal < 1 || dorsal > 30) {
				this.dorsal = dorsal;
			}
		}catch(NumberFormatException e) {
			e.getCause();
		}
		
		for(int i=0; i<nombre.length(); i++) {
			char caracteres = nombre.charAt(i);
			int valorAscii = (int)caracteres;
			try {	
				if((valorAscii == 165 || valorAscii == 164) || (valorAscii >= 65 || valorAscii <= 90) ||
						(valorAscii >= 97 || valorAscii<= 122)) {
					this.nombre = nombre;
				}
			}catch(NumberFormatException e) {
				e.getMessage();
			}
		}
		
		if(equipo == TipoEquipo.LOCAL || equipo==TipoEquipo.VISITANTE) {
			this.equipo = equipo;
		}else {
			System.out.println("EQUIPO MAL");
		}
		
		
	}

	public Jugador() {
		
	}
	
	//GETTERS Y SETTERS

	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}


	public String getNombre() {
		return nombre;
	}



	public int getGoles() {
		return goles;
	}

	
	public TipoEquipo getEquipo() {
		return equipo;
	}

	
	//METODOS

	/**
	 * 
	 * @param golesMas  (Incremento de goles)
	 */
	public void contabilizarGol(int golesMas) {
		if(golesMas == 0) {
			this.goles = this.getGoles()+1;
		}else {
			this.goles = this.getGoles()+golesMas;
		}
	}

	public abstract int obtenerValoracion();

	@Override
	public String toString() {
		return "Jugador [dorsal=" + this.getDorsal() + ", nombre=" + this.getNombre() + 
				", goles=" + this.getGoles() + ", equipo=" + this.getEquipo() + "]";
	}
	
	
	
	
	
	
	
	
}
