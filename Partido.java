package Futbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase que estan los metodos necesarios 
 * 
 * @author ierai
 * @version 1.0
 *
 */

public class Partido {

	private Jugador[] equipoLocal;
	private ArrayList<Jugador> equipoVisitante;

	public Partido() {
		equipoLocal = new Jugador[15];
		equipoVisitante = new ArrayList<Jugador>();
	}

	/**
	 * Añadimos un defensa
	 * @param t  (Tipo de equipo)
	 * @param d  (Jugador Defensor)
	 * @param dorsal  (Numero del dorsal)
	 */

	public void añadirDefensa(TipoEquipo t, Defensa d, int dorsal) {
		boolean repetido = false;
		if (t.toString().equalsIgnoreCase("Local")) {
			for (int i = 0; i < equipoLocal.length; i++) {
				if(equipoLocal[i]!=null) {
					if (equipoLocal[i].getDorsal() == dorsal) {
						repetido = true;
					}
				}else {
					i=equipoLocal.length;
				}
			}
			if (repetido == false) {
				añadirJugadorLocal(d);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (int i = 0; i < equipoVisitante.size(); i++) {
				if (equipoVisitante.get(i).getDorsal() == dorsal) {
					repetido = true;
				}
			}
			if (repetido == false) {
				añadirJugadorVisitante(d);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}
		}

	}

	/**
	 * Añadimos un atacante
	 * @param t  (Tipo de equipo)
	 * @param a  (Jugador atacante)
	 * @param dorsal  (Numero de dorsal)
	 */
	public void añadirAtacante(TipoEquipo t, Atacante a, int dorsal) {
		boolean repetido = false;
		if (t.toString().equalsIgnoreCase("Local")) {
			for (int i = 0; i < equipoLocal.length; i++) {
				if(equipoLocal[i]!=null) {
					if (equipoLocal[i].getDorsal() == dorsal) {
						repetido = true;
					}
				}else {
					i = equipoLocal.length;
				}
			}
			if (repetido == false) {
				añadirJugadorLocal(a);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (int i = 0; i < equipoVisitante.size(); i++) {
				if (equipoVisitante.get(i).getDorsal() == dorsal) {
					repetido = true;
				}
			}
			if (repetido == false) {
				añadirJugadorVisitante(a);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}
		}
	}

	/**
	 * Añadimos un portero
	 * @param t  (Tipo de equipo)
	 * @param p  (Jugador Portero)
	 * @param dorsal  (Numero de dorsal)
	 */
	public void añadirPortero(TipoEquipo t, Portero p, int dorsal) {
		boolean repetido = false;
		if (t.toString().equalsIgnoreCase("Local")) {
			for (int i = 0; i < equipoLocal.length; i++) {
				if(equipoLocal[i]!=null) {
					if (equipoLocal[i].getDorsal() == dorsal) {
						repetido = true;
					}
				}else {
					i = equipoLocal.length;
				}
			}
			if (repetido == false) {
				añadirJugadorLocal(p);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}

		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (int i = 0; i < equipoVisitante.size(); i++) {
				if (equipoVisitante.get(i).getDorsal() == dorsal) {
					repetido = true;
				}
			}
			if (repetido == false) {
				añadirJugadorVisitante(p);
				System.out.println("Añadido");
			} else {
				System.out.println("Dorsal repetido");
			}
		}
	}

	/**
	 * Se añade el jugar al equipo Local
	 * @param j  (Añadimos el jugador)
	 */
	private void añadirJugadorLocal(Jugador j) {
		for (int i = 0; i < equipoLocal.length; i++) {
			if (equipoLocal[i] == null) {
				equipoLocal[i] = j;
				i = equipoLocal.length;
			}
		}
	}

	/**
	 * Se añade el jugador el equipo Visitante
	 * @param j : (Añadimos el jugador)
	 */
	private void añadirJugadorVisitante(Jugador j) {
		equipoVisitante.add(j);
	}

	/**
	 * Contabiliza los goles de un jugador
	 * @param t  (Tipo del equipo)
	 * @param dorsal  (Numero de dorsal)
	 * @param golesMas  (Numeros de goles que ha marcado)
	 */
	public void contabilizarGol(TipoEquipo t, int dorsal, int golesMas) {
		if (t.toString().equalsIgnoreCase("Local") && dorsal >= 1 && dorsal <= 30) {
			for (int i = 0; i < equipoLocal.length; i++) {
				if (equipoLocal[i] != null && equipoLocal[i].getDorsal() == dorsal) {
					equipoLocal[i].contabilizarGol(golesMas);
				}

			}
		} else if (t.toString().equalsIgnoreCase("Visitante") && dorsal >= 1 && dorsal <= 30) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador.getDorsal() == dorsal) {
					jugador.contabilizarGol(golesMas);
				}
			}
		}
	}

	/**
	 * Incrementa el numero de los pases de un jugador
	 * 
	 * @param t  (Tipo del equipo)
	 * @param dorsal  (Dorsal del jugador)
	 * @param pasesMas  (Numero de pases que ha realizado)
	 */
	public void contabilizarLosPases(TipoEquipo t, int dorsal, int pasesMas) {
		if (t.toString().equalsIgnoreCase("Local")) {
			for (Jugador jugador : equipoLocal) {
				if (jugador instanceof Atacante) {
					if (((Atacante) jugador).getDorsal() == dorsal) {
						((Atacante) jugador).contabilizarPases(pasesMas);
					}
				} else if (jugador instanceof Defensa) {
					if (((Defensa) jugador).getDorsal() == dorsal) {
						((Defensa) jugador).contabilizarPases(pasesMas);
					}
				}
			}
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof JugadorCampo) {
					if (((JugadorCampo) jugador).getDorsal() == dorsal) {
						((JugadorCampo) jugador).contabilizarPases(pasesMas);
					}
				}
			}
		}

	}

	/**
	 * Metodo para incrementar el valor de las paradas realizadas por el portero
	 * 
	 * @param t  (Tipo del equipo)
	 * @param dorsal  (Dorsal del jugador)
	 * @param paradasMas  (Numero de paradas realizadas por el portero)
	 */

	public void contabilizarLosParadas(TipoEquipo t, int dorsal, int paradasMas) {
		if (t.toString().equalsIgnoreCase("Local")) {
			for (Jugador jugador : equipoLocal) {
				if (jugador instanceof Portero) {
					if (((Portero) jugador).getDorsal() == dorsal) {
						((Portero) jugador).contabilizarParadas(paradasMas);
					}
				}
			}
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof Portero) {

					if (((Portero) jugador).getDorsal() == dorsal) {
						((Portero) jugador).contabilizarParadas(paradasMas);
					}
				}
			}
		}
	}

	/**
	 * Este metodo incrementara en 1 o más los balones recuperados
	 * 
	 * @param t  (Tipo de equipo)
	 * @param dorsal  (Dorsal del jugador)
	 * @param recuperarMas  (Incremento de balones recuperados del jugador)
	 */

	public void contabilizarRecuperados(TipoEquipo t, int dorsal, int recuperarMas) {
		if (t.toString().equalsIgnoreCase("Visitante")) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof Atacante) {
					if (((Atacante) jugador).getDorsal() == dorsal) {
						((Atacante) jugador).contabilizarRecuperados(recuperarMas);
					}
				} else if (jugador instanceof Defensa) {
					if (((Defensa) jugador).getDorsal() == dorsal) {
						((Defensa) jugador).contabilizarRecuperados(recuperarMas);
					}
				}
			}
		} else if (t.toString().equalsIgnoreCase("Local")) {
			for (Jugador jugador : equipoLocal) {
				if (jugador instanceof Portero) {
					if (((JugadorCampo) jugador).getDorsal() == dorsal) {
						((JugadorCampo) jugador).contabilizarRecuperados(recuperarMas);
					}
				}
			}
		}
	}

	/**
	 * Este metodo se encarga en mostrar la informacion de los jugadores
	 * 
	 * @param t  (Tipo de equipo)
	 * @param dorsal  (Dorsal del jugador)
	 * 
	 */

	public void mostrarJugador(TipoEquipo t, int dorsal) {
		if (t.toString().equalsIgnoreCase("Local") && dorsal >= 1 && dorsal <= 30) {
			for (Jugador jugador : equipoLocal) {
				if (jugador instanceof Portero) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Portero) jugador).toString());
					}
				} else if (jugador instanceof Defensa) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Defensa) jugador).toString());
					}
				} else if (jugador instanceof Atacante) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Atacante) jugador).toString());
					}
				}
			}

		} else if (t.toString().equalsIgnoreCase("Visitante") && dorsal >= 1 && dorsal <= 30) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof Portero) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Portero) jugador).toString());
					}
				} else if (jugador instanceof Defensa) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Defensa) jugador).toString());
					}
				} else if (jugador instanceof Atacante) {
					if (jugador.getDorsal() == dorsal) {
						System.out.println(((Atacante) jugador).toString());
					}
				}
			}
		}

	}

	

	/**
	 * Elimina el jugador que quieras
	 * @param t  (Tipo de equipo)
	 * @param dorsal  (Numero de dorsal)
	 */

	public void eliminarJugador(TipoEquipo t, int dorsal) {
		if (t.toString().equalsIgnoreCase("Local")) {
			for (int i = 0; i < equipoLocal.length; i++) {
				if (equipoLocal[i].getDorsal() == dorsal) {
					equipoLocal[i] = null;
				}
			}
			
			Arrays.sort(equipoLocal);
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			Iterator<Jugador> listaEliminar;
			listaEliminar = equipoVisitante.iterator();

			while (listaEliminar.hasNext()) {
				if (listaEliminar.next().getDorsal() == dorsal) {
					listaEliminar.remove();
				}
			}
		}
	}

	
	/**
	 * Ordena los goles de un equipo
	 * @param t  (Tipo de equipo)
	 * 
	 */
	
	public void ordenarGoles(TipoEquipo t) {
		Jugador[] equipoLocalGoles;
		if (t.toString().equalsIgnoreCase("Local")) {
			int longitud = 0;
			while (equipoLocal[longitud] != null) {

				longitud++;
			}
			for (int i = 0; i < longitud - 1; i++) {
				for (int j = 0; j < longitud - i - 1; j++) {
					if (equipoLocal[j + i].getGoles() < equipoLocal[j].getGoles()) {
						Jugador aux = equipoLocal[j + 1];
						equipoLocal[j + 1] = equipoLocal[j];
						equipoLocal[j] = aux;
					}
				}
			}

			equipoLocalGoles = equipoLocal;
			for (int i = 0; i < equipoLocalGoles.length; i++) {
				System.out.println(equipoLocalGoles[i].getGoles());
			}

		} else if (t.toString().equalsIgnoreCase("Visitantes")) {
			Collections.sort(equipoVisitante, new OrdenarGoles());
			for (int i = 0; i < equipoVisitante.size(); i++) {
				equipoVisitante.get(i).toString();
				System.out.println("\n");
			}
		}
	}
	
	
	/**
	 * Muestra todos los jugadores del equipo
	 * @param t  (Tipo de equipo)
	 * 
	 */

	public void mostrarTodosJugadores(TipoEquipo t) {
		if (t.toString().equalsIgnoreCase("Local")) {
			for (Jugador jugador : equipoLocal) {
				if (jugador instanceof Portero) {
					System.out.println(((Portero) jugador).toString());
				} else if (jugador instanceof Defensa) {
					System.out.println(((Defensa) jugador).toString());
				} else if (jugador instanceof Atacante) {
					System.out.println(((Atacante) jugador).toString());
				}
			}

		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof Portero) {
					System.out.println(((Portero) jugador).toString());
				} else if (jugador instanceof Defensa) {
					System.out.println(((Defensa) jugador).toString());
				} else if (jugador instanceof Atacante) {
					System.out.println(((Atacante) jugador).toString());
				}
			}
		}
	}
	
	
	/**
	 * Ordena los pases de un equipo
	 * @param t  (Tipo de equipo)
	 * 
	 */

	public void ordenarPases(TipoEquipo t) {
		
		if (t.toString().equalsIgnoreCase("Local")) {
			Arrays.sort(equipoLocal, new OrdenarPases());
			for(Jugador jugador : equipoLocal) {
				if(jugador != null) {
					System.out.println(jugador.toString());
				}
			}

		} else if (t.toString().equalsIgnoreCase("Visitantes")) {
			Collections.sort(equipoVisitante, new OrdenarPases());
			for (Jugador jugador : equipoVisitante) {
				if (jugador instanceof Atacante) {
					System.out.println(((Atacante) jugador).getPases());
				} else if (jugador instanceof Defensa) {
					System.out.println(((Defensa) jugador).getPases());
				}
			}
		}
	}
	
	
	/**
	 * 
	 * @param t  (Tipo de equipo)
	 * @return Goles totales del equipo
	 */

	public int golesTotales(TipoEquipo t) {
		int golesT = 0;
		int longitud=0;
		if (t.toString().equalsIgnoreCase("Local")) {
			while (equipoLocal[longitud] != null) {

				longitud++;
			}
			for(int i=0; i<longitud; i++) {
				golesT+= equipoLocal[i].getGoles();
			}

		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			int i = 0;
			while (i < equipoVisitante.size()) {
				golesT += equipoVisitante.get(i).getGoles();
				i++;
			}
		}
		return golesT;
	}

	/**
	 * 
	 * @param t  (Tipo de equipo)
	 * @return Los pases totales del equipo
	 */

	public float pasesTotal(TipoEquipo t) {
		float pases = 0;
		int longitud=0;
		if (t.toString().equalsIgnoreCase("Local")) {
			while (equipoLocal[longitud] != null) {

				longitud++;
			}
			for (int i = 0; i < longitud; i++) {
				if(equipoLocal[i]==null) {
					
				}else {
					pases += ((JugadorCampo) equipoLocal[i]).getPases();
				}
			}
			pases = pases / longitud;
		} else if (t.toString().equalsIgnoreCase("Visitante")) {
			int i = 0;
			while (i < equipoVisitante.size()) {
				pases += ((JugadorCampo) equipoVisitante.get(i)).getPases();
				i++;
			}
		}

		return pases;
	}
	
}
