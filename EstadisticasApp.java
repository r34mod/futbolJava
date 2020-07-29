package Futbol;


import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


/**
 * Aplicacion que simula un partido de futbol mostrando estadisticas
 * de los jugadores de cada equipo
 * 
 * @author ierai
 * @version 1.0.4
 * @since 3/05/2020
 *
 */

public class EstadisticasApp {

	public static void main(String[] args) throws FactorialNegExc, ArithmeticException {
		Scanner sc = new Scanner(System.in);

		Atacante a;
		Defensa d;
		Portero p = null;
		TipoEquipo t = null;
		Partido partido = new Partido();

		int option = 0;
		int opcionCrear = 0;
		int pasesMas;
		int golesMas;
		int dorsal;
		int paradasMas;
		int recuperarMas;

		String equipo = "";
		String nombre;
		String name;
		String periodista = JOptionPane.showInputDialog("¿Cual es tu nombre?");
		
		ImageIcon futbolista = new ImageIcon("7z.png");
		JOptionPane.showMessageDialog(null,
				periodista,"Partido De futbol comentado por", JOptionPane.INFORMATION_MESSAGE, futbolista);
		
		while (option != 13) {
			option = Integer.parseInt(JOptionPane.showInputDialog(null,
					"Inicio del partido \n" + "1. Crear \n" +
					"2. Ver jugador \n" + 
					"3. Incrementar Gol \n"
					+ "4. Incrementar pases \n" + "5. Incrementar paradas \n" +
					"6. Incrementar recuperados \n"
					+ "7. Media de goles \n" + "8. Media de pases \n" + 
					"9. Eliminar Jugador \n"
					+ "10. Ordenar goles \n" + "11. Ordenar pases \n" +
					"12. Mostrar Equipo \n"+"13. Salir",
					periodista));

			switch (option) {
			case 1:
				opcionCrear = 0;
				while (opcionCrear != 4) {
					opcionCrear = Integer
							.parseInt(JOptionPane.showInputDialog(null, 
					"Crear jugador \n" 
					+ "1. Añadir atacante \n"
					+ "2. Añadir defensa \n" + "3. Añadir portero \n" 
					+ "4. Salir", "Menu"));

					switch (opcionCrear) {
					case 1:

						equipo = JOptionPane.showInputDialog("Local o Visitante");
						if (equipo.equalsIgnoreCase("Local")) {
							t = TipoEquipo.LOCAL;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog
									("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog
										("Que nombre tiene el jugador");
								name = comprobarName(nombre);
								partido.añadirAtacante(t, new Atacante(dorsal, name, t), dorsal);
							} else {
								System.err.println("Dorsal erroneo");
								
							}

						} else if(equipo.equalsIgnoreCase("Visitante")){
							t = TipoEquipo.VISITANTE;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog
									("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog
										("Que nombre tiene el jugador");
								name = comprobarName(nombre);
								partido.añadirAtacante(t, new Atacante(dorsal, name, t), dorsal);
							} else {
								System.err.println("Dorsal erroneo");
							}

						}else {
						
							throw new NumberFormatException("Mal");
							
						}

						

						break;
					case 2:

						equipo = JOptionPane.showInputDialog("Local o Visitante");
						if (equipo.equalsIgnoreCase("Local")) {
							t = TipoEquipo.LOCAL;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog("Que nombre tiene el jugador");
								name = comprobarName(nombre);
								d = new Defensa(dorsal, name, t);
								partido.añadirDefensa(t, d, dorsal);
							} else {
								System.out.println("Dorsal erroneo");
							}
						} else if(equipo.equalsIgnoreCase("Visitante")){
							t = TipoEquipo.VISITANTE;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog("Que nombre tiene el jugador");
								name = comprobarName(nombre);
								d = new Defensa(dorsal, name, t);
								partido.añadirDefensa(t, d, dorsal);
							} else {
								System.out.println("Dorsal erroneo");
							}
						}else {
							throw new NumberFormatException("Mal ");
						}

						

						break;
					case 3:

						equipo = JOptionPane.showInputDialog("Local o Visitante");
						if (equipo.equalsIgnoreCase("Local")) {
							t = TipoEquipo.LOCAL;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog("Añade el nombre del jugador");
								name = comprobarName(nombre);
								p = new Portero(dorsal, name, t);
								partido.añadirPortero(t, p, dorsal);
							} else {
								System.out.println("Dorsal erroneo");
							}
						} else if(equipo.equalsIgnoreCase("Visitante")){
							t = TipoEquipo.VISITANTE;
							dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
							if (comprobarDorsal(dorsal) == true) {

								nombre = JOptionPane.showInputDialog("Añade el nombre del jugador");
								name = comprobarName(nombre);
								p = new Portero(dorsal, name, t);
								partido.añadirPortero(t, p, dorsal);
							} else {
								System.out.println("Dorsal erroneo");
							}
						}else {
							throw new NumberFormatException("Mal ");
						}

						

						break;
					case 4:
						break;

					}
				}
				break;
			case 2:
				
				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));

					partido.mostrarJugador(t, dorsal);
					

				} else if(equipo.equalsIgnoreCase("Visitante")){
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));

					partido.mostrarJugador(t, dorsal);
					

				}else {
					System.out.println("Error de nombre");
				}
				
				

				break;
			case 3:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						golesMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos goles ha metido"));
						partido.contabilizarGol(t, dorsal, golesMas);
						System.out.println("Gol añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						golesMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos goles ha metido"));
						partido.contabilizarGol(t, dorsal, golesMas);
						System.out.println("Gol añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 3;
				}

				

				break;
			case 4:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						pasesMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos pases ha realizado [0 = 1]"));
						partido.contabilizarLosPases(t, dorsal, pasesMas);
						System.out.println("Pase añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						pasesMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos pases ha realizado [0 = 1]"));
						partido.contabilizarLosPases(t, dorsal, pasesMas);
						System.out.println("Pase añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 4;
				}

				

				break;
			case 5:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {
						paradasMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas paradas ha realizado"));
						partido.contabilizarLosParadas(t, dorsal, paradasMas);
						System.out.println("Parada añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {
						paradasMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantas paradas ha realizado"));
						partido.contabilizarLosParadas(t, dorsal, paradasMas);
						System.out.println("Parada añadido");
					} else {
						System.out.println("Dorsal erroneo");
					}
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 5;
				}
				

				break;
			case 6:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						recuperarMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos balones ha recuperado"));
						partido.contabilizarRecuperados(t, dorsal, recuperarMas);
					} else {
						System.out.println("Dorsal erroneo");
					}
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {

						recuperarMas = Integer.parseInt(JOptionPane.showInputDialog("Cuantos balones ha recuperado"));
						partido.contabilizarRecuperados(t, dorsal, recuperarMas);
					} else {
						System.out.println("Dorsal erroneo");
					}
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 6;
				}
				
				break;
			case 7:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					System.out.println(partido.golesTotales(t));
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					System.out.println(partido.golesTotales(t));
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 7;
				}
				
				break;
			case 8:
				
				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					System.out.println(partido.pasesTotal(t));
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					System.out.println(partido.pasesTotal(t));
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 8;
				}

				
				break;
			case 9:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {
						partido.eliminarJugador(t, dorsal);
					} else {
						System.out.println("Dorsal erroneo");
					}
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					dorsal = Integer.parseInt(JOptionPane.showInputDialog("Dorsal del 1-30"));
					if (comprobarDorsal(dorsal) == true) {
						partido.eliminarJugador(t, dorsal);
					} else {
						System.out.println("Dorsal erroneo");
					}
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 9;
				}
				

				break;
			case 10:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					partido.ordenarGoles(t);
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					partido.ordenarGoles(t);
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 10;
				}
				
				break;
			case 11:

				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					partido.ordenarPases(t);
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					partido.ordenarPases(t);
				}else {
					System.err.println("Ningun equipo seleccionado");
					option = 11;
				}
				
				break;
			case 12:
				equipo = JOptionPane.showInputDialog("Que equipo eliges");
				if (equipo.equalsIgnoreCase("Local")) {
					t = TipoEquipo.LOCAL;
					partido.mostrarTodosJugadores(t);
				} else if (equipo.equalsIgnoreCase("Visitante")) {
					t = TipoEquipo.VISITANTE;
					partido.mostrarTodosJugadores(t);
				}else {
					System.err.println("Ningun equipo seleccionado");
					option=12;
				}
				
				
				break;
			case 13:
				
				String salida = JOptionPane.showInputDialog("¿"+periodista+
						" quieres salir del programa?");
				if(salida.equalsIgnoreCase("Si")) {
					option = 13;
				}else {
					option = 0;
				}
				
				
				break;
			}
		}
		sc.close();
	}

	
	
	/**
	 * 
	 * @param nombre
	 * @return nombre
	 * @throws ArithmeticException
	 */
	
	static String comprobarName(String nombre) throws ArithmeticException {
		for (int i = 0; i < nombre.length(); i++) {
			char caracteres = nombre.charAt(i);
			int valorAscii = (int) caracteres;
			try {
				if ((valorAscii == 165 || valorAscii == 164) && (valorAscii >= 65 || valorAscii <= 90)
						&& (valorAscii >= 97 || valorAscii <= 122)) {
					return nombre;
				}
			} catch (NumberFormatException e) {
				System.out.println("Error");
			}
		}
		return nombre;
	}

	
	/**
	 * 
	 * @param dorsal
	 * @return boolean
	 * @throws FactorialNegExc
	 */
	static boolean comprobarDorsal(int dorsal) throws FactorialNegExc {
		boolean bien = true;
		if (dorsal <= 0 || dorsal >= 30) {
			bien = false;
			throw new FactorialNegExc("Error el numero esta fuera de rango");

		} else {
			return bien;
		}

	}

	
	public static class ArithmeticException extends Exception {
		protected String error = "Caracter no alfabetico crack";

		public ArithmeticException(String error) {
			super();
			this.error = error;
		}
	}

	@SuppressWarnings("EXCEPTTION")
	public static class FactorialNegExc extends Exception {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected String error = "Numero negativo";

		public FactorialNegExc(String error) {
			super();
			this.error = error;
		}

	}

}
