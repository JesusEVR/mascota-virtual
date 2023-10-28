import src.Composite.Producto;
import src.Composite.Alimento;
import src.Composite.Inventario;
import src.Iterator.Catalogo;
import src.Iterator.CatalogoAlimento;
import src.Iterator.IteradorLista;
import java.util.Iterator;


public class prueba{
public static void main(String[] args){
		
		Producto p = new Alimento("11","Hamburguesa", "es mortal", 23.0, 1,-3);
		//Composite
		Inventario inventario = new Inventario();
		inventario.agregarProducto(p);
		System.out.println("***AÑADIR ALIMENTOS AL REFRIGERADOR *** (prueba composite)");
		System.out.println( "(version para imprimir la info del refrigerador)"+"\n"+ inventario.informacion());
		System.out.println("");
		System.out.println("(version para imprimir la info del menu)" +"\n"+ inventario.informacionConPrecio());
	
		System.out.println("");
		//Iterator
		Producto pr;
		Catalogo c = new CatalogoAlimento();
		Iterator i = c.creaIterador();
		System.out.println("*** MENU DE ALIMENTOS *** (prueba iterator)");
		while(i.hasNext()){
			pr = (Producto) i.next();
			System.out.println(pr.informacionConPrecio());
			
		}
		
		
	}
}