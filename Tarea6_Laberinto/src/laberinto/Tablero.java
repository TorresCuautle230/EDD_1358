/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laberinto;

/**
 *
 * @author cuaut
 */
import Estructuras.Arreglo_DosD_ADT;
import Estructuras.ArregloADT;
import Estructuras.ArregloCSV;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Tablero<T> {
	private String ruta;
	private Arreglo_DosD_ADT<Casilla<Boolean>> datos;
	private Pila<ArregloADT<Integer>> trallecto;
	private ArrayList<ArrayList<Casilla<Boolean>>> caminos;
        String[] cont;
        private ArregloCSV<Casilla<Boolean>> datTem;        
        private ArregloCSV tableroFisico;        
        int z;        
        int filas, columnas;

	public Tablero(String ruta,int filas, int columnas,int filaInicial, int columnaInicial, int filaFinal, int columnaFinal) throws IOException {
		super();
		this.ruta = ruta;
		tableroFisico = new ArregloCSV(filas, columnas);
                datTem=new ArregloCSV(filas, columnas);
                datos = new Arreglo_DosD_ADT<>(columnas, filas);
		String contenido = "";
		ArrayList<ArrayList<String>> datosArr = new ArrayList<ArrayList<String>>();
                 Path filePath = Paths.get(ruta);
		 BufferedReader br = Files.newBufferedReader(filePath, Charset.forName("ISO-8859-1"));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datosDelinea = linea.split(",");
                
                 cont = linea.split("\n");
                z = z + cont.length;
                ArrayList<String> datosTemporal = new ArrayList<String>();
                for (String dato : datosDelinea) {
                    datosTemporal.add(dato);
                }
                datosArr.add(datosTemporal);

            }
		br.close();
		String[] arregloTemporal = contenido.split("\n");
                
		
            for (int col = 0; col <= columnas - 1; col++) {
                for (int fil = 0; fil <= filas - 1; fil++) {
                    if(datosArr.get(0).get(0)!=null&&col==0&&fil==0){
                        tableroFisico.setElemento("0", fil, col);
                    }else if("1".equals(datosArr.get(0).get(0))&&col==0&&fil==0){
                        tableroFisico.setElemento(" ", fil, col);
                    } else
                        tableroFisico.setElemento(datosArr.get(col).get(fil), fil, col);                    
                }
            }
            
            
            for (int col = 0; col <= columnas - 1; col++) {
                for (int fil = 0; fil <= filas - 1; fil++) {
                    boolean valor;
                    if("0".equals( tableroFisico.getElemento(fil, col))){
                        valor=false;
                    }else{
                        valor=true;
                    }
                    Casilla casilla =new Casilla(col, fil, null, false, valor);
                    datTem.setElemento(casilla, fil, col);
                                         
                }
            }
            System.out.println("labe\n"+tableroFisico.toString());
            for (int col = 0; col <= columnas - 1; col++) {
                for (int fil = 0; fil <= filas - 1; fil++) {
                    datos.setItem(col, fil, datTem.getElemento(fil, col));
                                         
                }
            }
             
             
            
                
		datos.getItem(filaFinal, columnaFinal).setCasillaFin(true);
		
		this.cPaso();
		trallecto = new Pila<>();
		trallecto.push(this.getElementoPosicion(datos.getItem(filaInicial, columnaInicial)));
		caminos = new ArrayList<>();
	}

	public void cPaso() { 
		for (int i = 0; i < datos.getFilas(); i++) {
			for (int j = 0; j < datos.getColumnas(); j++) {
				Casilla<Boolean> aux = datos.getItem(i, j);

				try {
					
					if(i == 0 && j == 0) {
						boolean[] pasoaux = { false,
								(boolean) datos.getItem(i, j + 1).getValor(),
								(boolean) datos.getItem(i + 1, j).getValor(),
								false };
						aux.setPaso(pasoaux);
						
					}else if(i == 0 && j == datos.getColumnas()-1) {
						boolean[] pasoaux = { false,
								false,
								(boolean) datos.getItem(i + 1, j).getValor(),
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
						
					}else if(i == datos.getFilas()-1 && j == 0) {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(),
								(boolean) datos.getItem(i, j + 1).getValor(),
								false,
								false};
						aux.setPaso(pasoaux);
						
					}else if(i == datos.getFilas()-1 && j == datos.getColumnas()-1) {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(),
								false,
								false,
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
						
					}else if (i == 0) {
						boolean[] pasoaux = { false, (boolean) datos.getItem(i, j + 1).getValor(),
								(boolean) datos.getItem(i + 1, j).getValor(),
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
						
						
					} else if (j == 0) {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(),
								(boolean) datos.getItem(i, j + 1).getValor(),
								(boolean) datos.getItem(i + 1, j).getValor(), false };
						aux.setPaso(pasoaux);
						
					} else if (i == datos.getFilas() - 1) {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(),
								(boolean) datos.getItem(i, j + 1).getValor(), false,
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
						
					} else if (j == datos.getColumnas() - 1) {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(), false,
								(boolean) datos.getItem(i + 1, j).getValor(),
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
						
					} else {
						boolean[] pasoaux = { (boolean) datos.getItem(i - 1, j).getValor(),
								(boolean) datos.getItem(i, j + 1).getValor(),
								(boolean) datos.getItem(i + 1, j).getValor(),
								(boolean) datos.getItem(i, j - 1).getValor() };
						aux.setPaso(pasoaux);
					}
					
				} catch (java.lang.NullPointerException e) {
					System.out.println("error con los indices");
				}
			}
		}
	}
	
	public ArregloADT<Integer> getElementoPosicion(Casilla<Boolean> casilla){
		ArregloADT<Integer> posicion = new ArregloADT<>(2);
		for (int i = 0; i < datos.getFilas(); i++) {
			for (int j = 0; j < datos.getColumnas(); j++) {
				if(casilla.equals(datos.getItem(i, j))) {
					posicion.setElemento(0, i);
					posicion.setElemento(1, j);
					return posicion;
				}
			}
		}
		return null;
	}
			
	public Arreglo_DosD_ADT<Casilla<Boolean>> getDatos() {
		return datos;
	}

	public Pila<ArregloADT<Integer>> getTrallecto() {
		return trallecto;
	}

	public boolean dentroDelLimite(int fila, int columna) {
		return (fila >= 0 && fila <= datos.getFilas()) && (columna >= 0 && columna <= datos.getColumnas());
	}
        
        public boolean izquierdaD(Casilla<Boolean> casillaActual, Casilla<Boolean> casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return casillaActual.izquierdaDisponible();
		}
		return false;
	}

	public boolean arribaD(Casilla<Boolean> casillaActual, Casilla<Boolean> casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return casillaActual.arribaDisponible();
		}
		return false;
	}

	public boolean derechaD(Casilla<Boolean> casillaActual, Casilla<Boolean> casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return casillaActual.derechaDisponible();
		}
		return false;
	}

	public boolean abajoD(Casilla<Boolean> casillaActual, Casilla<Boolean> casillaDestino) {

		if (casillaDestino != null && !casillaDestino.isVisitado()) {
			return casillaActual.abajoDisponible();
		}
		return false;
	}

	

	public Casilla<Boolean> getCasillaAt(int x, int y) {
		if (dentroDelLimite(x, y)) {
			return datos.getItem(x, y);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public void rellenarCaminos(Tablero<Casilla<Boolean>> laberinto, Casilla<Boolean> casillaActual, ArrayList<Casilla<Boolean>> caminoArr) {

		if (casillaActual.isCasillaFin()) {
			trallecto.push(this.getElementoPosicion(casillaActual));
			laberinto.añadirCamino((ArrayList<Casilla<Boolean>>) caminoArr.clone());

		} else {

			
			int[][] movimientos = { { -1, 0 }, // arriba
					{ 0, 1 }, // derecha
					{ 1, 0 }, // abajo
					{ 0, -1 } // izquierda
			};

			int posFilaNueva, posColumnaNueva;
			Casilla<Boolean> aux;

			
			for (int i = 0; i < movimientos.length; i++) {

				posFilaNueva = casillaActual.getPosicionX() + movimientos[i][0];
				posColumnaNueva = casillaActual.getPosicionY() + movimientos[i][1];
				aux = laberinto.getCasillaAt(posFilaNueva, posColumnaNueva);

				switch (i) {
				case 0: // arriba
					if (laberinto.arribaD(casillaActual, aux)) {
						trallecto.push(this.getElementoPosicion(aux));
						caminoArr.add(aux);
						casillaActual.setVisitado(true);
						rellenarCaminos(laberinto, aux, caminoArr);
						casillaActual.setVisitado(false);
						if (trallecto.Peek().equals(getElementoPosicion(aux))) {
							trallecto.pop();
						}
						caminoArr.remove(aux);
					}
					break;
				case 1: // derecha
					if (laberinto.derechaD(casillaActual, aux)) {
						trallecto.push(this.getElementoPosicion(aux));
						caminoArr.add(aux);
						casillaActual.setVisitado(true);
						rellenarCaminos(laberinto, aux, caminoArr);
						casillaActual.setVisitado(false);
						if (trallecto.Peek().equals(getElementoPosicion(aux))) {
							trallecto.pop();
						}
						caminoArr.remove(aux);
					}
					break;
				case 2:// abajo
					if (laberinto.abajoD(casillaActual, aux)) {
						trallecto.push(this.getElementoPosicion(aux));
						caminoArr.add(aux);
						casillaActual.setVisitado(true);
						rellenarCaminos(laberinto, aux, caminoArr);
						casillaActual.setVisitado(false);
						if (trallecto.Peek().equals(getElementoPosicion(aux))) {
							trallecto.pop();
						}
						caminoArr.remove(aux);
					}
					break;
				case 3: // izquierda
					if (laberinto.izquierdaD(casillaActual, aux)) {
						trallecto.push(this.getElementoPosicion(aux));
						caminoArr.add(aux);
						casillaActual.setVisitado(true);
						rellenarCaminos(laberinto, aux, caminoArr);
						casillaActual.setVisitado(false);
						if (trallecto.Peek().equals(getElementoPosicion(aux))) {
							trallecto.pop();
						}
						caminoArr.remove(aux);
					}
					break;
				}

			}

		}

	}
	 public void añadirCamino(ArrayList<Casilla<Boolean>> camino) {
	        if (camino != null && !camino.isEmpty()) {
	            caminos.add(camino);
	        }
	    }

	    public void mostrarCaminos() {

	        int contador = 1;
	        for (ArrayList<Casilla<Boolean>> camino : caminos) {
	            System.out.println("Camino: " + contador);
	            for (Casilla<Boolean> casilla : camino) {
	                System.out.println(this.getElementoPosicion(casilla));
	            }
	            contador++;
	        }

	    }
}