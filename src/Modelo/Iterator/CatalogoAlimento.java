package Modelo.Iterator;

import Modelo.Composite.Producto;
import Modelo.Composite.Alimento;

import java.util.LinkedList;
import java.util.Iterator;

/**
 * Clase que define la característica del menu de alimentos
 *
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 *
 */
public class CatalogoAlimento implements Catalogo{
	/**
	 * Lista de alimentos del catalogo
	 */
	protected LinkedList<Object> listaAlimento;

	/**
	 * Constructor por omisión que inicializa el menu 
         * Los numeros tiene el orden: precio, puntosHambre, puntosFelicidad.
	 */
	public CatalogoAlimento(){
		listaAlimento = new LinkedList<>();
		Producto p1 = new Alimento("00","Manzana dorada", "Si la comes, tendras mucha suerte", 70, 40,20); 
		agregarProducto((Object) p1);
		Producto p2 = new Alimento("01","Hamburguesa", "Muy rico y todo pero...", 15, -10,5);
		agregarProducto((Object) p2);
		Producto p3 = new Alimento("02","Salmon", "Fino señores", 25, 14,-10);
		agregarProducto((Object) p3);
		Producto p4 = new Alimento("03","Galletas no tan premium", "Unas simples galletas no te van a matar", 7, -10,-5);
		agregarProducto((Object) p4);
		Producto p5 = new Alimento("04","Cebollas", "Saludables, y tambien pa' llorar a gusto", 13, 10,-10);
		agregarProducto((Object) p5);
		Producto p6 = new Alimento("05","Papas fritas", "¿A quien no le gustan?", 11, 5,-4);
		agregarProducto((Object) p6);
		Producto p7 = new Alimento("06","Liquido misterioso", "Claramente es una trampa (?)", 60, 30,-23);
		agregarProducto((Object) p7);
		Producto p8 = new Alimento("07","Pizza", "Para nada es lo mejor que puedes comer, pero vaya que es rica", 19, -20,31);
		agregarProducto((Object) p8);
		Producto p9 = new Alimento("08","Objeto misterioso", "No sabes lo que te puede tocar... ¿Quieres arriesgarte?", 5, -20,-15); //trampa para el jugador, el objeto no cambia
		agregarProducto((Object) p9);
		Producto p10 = new Alimento("09","Tocino", "Algo crujiente", 8, 5,-8);
		agregarProducto((Object) p10);
		Producto p11 = new Alimento("10","Tacos de lujo", "¿A quien no le gustan? x2", 59, 20,18);
		agregarProducto((Object) p11);
		Producto p12 = new Alimento("11","Sandwich del metro", "Alguna estadistica aumentaria para bien...", 5, -15,15);
		agregarProducto((Object) p12);
		Producto p13 = new Alimento("12","Agua", "Vital para todos, o casi todos", 5, 0, -10);
		agregarProducto((Object) p13);
		Producto p14 = new Alimento("13","Oro...", "...parece, plata no es. ¿Esta bien que alguien coma minerales?", 100, 0,70);
		agregarProducto((Object) p14);
		Producto p15 = new Alimento("14","Gelatina", "Barata y deliciosa, claro que si", 17, 3,15);
		agregarProducto((Object) p15);
		Producto p16 = new Alimento("15","Leche con chocolate", "La favorita de 'Queso'. ¿Eso es bueno?", 24, -12,8);
		agregarProducto((Object) p16);
		Producto p17 = new Alimento("16","Croqueta especial", "No para todos los paladares", 40, 20,-30);
		agregarProducto((Object) p17);
		Producto p18 = new Alimento("17","Rector Graue", "No sabemos como o cuando llego aqui, pero igual esta a la venta", 50, -120,70);
		agregarProducto((Object) p18);
		Producto p19 = new Alimento("18","Krustyburger", "Tu tambien quieres comerla, ¿no?", 20, -40,20);
		agregarProducto((Object) p19);
		Producto p20 = new Alimento("19","Ratatouille", "Quiza es el platillo lujoso, o tal vez la rata que lo prepara...", 120, 78,60);
		agregarProducto((Object) p20);
	}

	/**
	 * Método que agrega un producto a la lista
	 */
	public void agregarProducto(Object a){
		listaAlimento.add(a);
	}

	/**
	 * Metodo que crea un iterador para recorrer los elementos del menu
	 *
	 * @return iterador
	 */
	public Iterator creaIterador(){
		return new IteradorLista(listaAlimento);
	}

}
