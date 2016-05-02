package examen;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
	private App(){
		
	}

	public static void main(String[] args) {
		Logger l=Logger.getLogger("log");
		polinomio clase=new polinomio();
		Scanner leer=new Scanner(System.in);
		TreeMap<Integer, Double> poli;
		l.log(Level.INFO,"Bienvenid@ a nuestra aplicación.\n");
		boolean salir=false;
		while(!salir){
		l.log(Level.INFO,"1 - Insertar polinomio.");
		l.log(Level.INFO,"2 - Seleccionar operación.");
		l.log(Level.INFO,"Cualquier tecla para Salir.");
		l.log(Level.INFO,"Opción: ");
		String opcion=leer.nextLine();
		if("1".equals(opcion)){
			poli=new TreeMap<>();
			l.log(Level.INFO,"Se irán insertando bloques aXb.\na--> valor base.\nb-->valor exponente(no se pueden exponentes negativos).\nSi añade una base con el mismo exponente se sumaran las bases.");
			while(true){
				l.log(Level.INFO,"Inserte la base: ");
				double base=Double.parseDouble(leer.nextLine());
				l.log(Level.INFO,"Inserte el exponente: ");
				int exponente=Math.abs(Integer.parseInt(leer.nextLine()));
				
				if (poli.containsKey(exponente)) {
					poli.replace(exponente, poli.get(exponente)+base);
				} else {
					poli.put(exponente, base);
				}
				
				l.log(Level.INFO,"Su polinomio es "+clase.poliToString(poli, "x"));
				l.log(Level.INFO,"Para volver pulse 1.\nPara seguir añadiendo valores pulse cualquier tecla.");
				l.log(Level.INFO,"Opcion: ");
				
				if(leer.nextLine().equals("1")){
					break;
				}
			}
			clase.add(poli);
		}else if("2".equals(opcion)){
			while(true){
			l.log(Level.INFO,"1 - Suma de expresiones.");
			l.log(Level.INFO,"2 - Producto de expresiones.");
			l.log(Level.INFO,"3 - División método de Ruffini.");
			l.log(Level.INFO,"4 - Teorema de Routh-Hurwitz.");
			l.log(Level.INFO,"5 - Método de interpolación Lineal.");
			l.log(Level.INFO,"Cualquier tecla para volver.");
			l.log(Level.INFO,"Operación: ");
			String operacion=leer.nextLine();
			if(operacion.equals("1")){
				operaciones(clase,1);
			}else if(operacion.equals("2")){
				operaciones(clase,2);
			}else if(operacion.equals("3")){
				operaciones(clase,3);
			}else if(operacion.equals("4")){
				operaciones(clase,4);
			}else if(operacion.equals("5")){
				Interpolacion.main(args);
				Scanner aux=new Scanner(System.in);
				aux.nextLine();
			}else{
				break;
			}
			}
		}else{
			salir=true;
		} 
		}
	}

	private static void operaciones(polinomio clase,int i) {
		Logger l=Logger.getLogger("log");
		Scanner leer=new Scanner(System.in);
		l.log(Level.INFO,"Lista de polinomios:");
		l.log(Level.INFO,clase.listaPolinomios());
		l.log(Level.INFO,"Seleccione el 1er polinomio: ");
		int p1=Integer.parseInt(leer.nextLine());
		if(i==3){
			l.log(Level.INFO,"Seleccione un monomio: ");}
		else{
			l.log(Level.INFO,"Seleccione el 2º polinomio: ");
		}
		int p2=0;
		if(i!=4){
			p2=Integer.parseInt(leer.nextLine());
		}
		String raya="\n---------------------\n";
		if(i==1){
		l.log(Level.INFO,"\n"+clase.poliToString(clase.getPolinomio(p1), "x")+"\n+\n"+clase.poliToString(clase.getPolinomio(p2), "x")+raya+clase.poliToString(clase.suma(p1, p2), "x"));
		}else if(i==2){
			l.log(Level.INFO,"\n"+clase.poliToString(clase.getPolinomio(p1), "x")+"\n*\n"+clase.poliToString(clase.getPolinomio(p2), "x")+raya+clase.poliToString(clase.multiplicacion(p1, p2), "x"));	
		}else if(i==3){
			l.log(Level.INFO,"\n"+clase.poliToString(clase.getPolinomio(p1), "x")+"\n/\n"+clase.poliToString(clase.getPolinomio(p2), "x")+raya+clase.poliToString(clase.ruffini(p1, p2), "x")+"	Resto: "+clase.getResto());
		}else if(i==4){
			l.log(Level.INFO,"\n"+clase.routh(p1));
		}
		leer.nextLine();
		
	}
	
}
