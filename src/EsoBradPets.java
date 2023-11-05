import Composite.Producto;
import Composite.Alimento;
import Composite.Inventario;
import Iterator.Catalogo;
import Iterator.CatalogoAlimento;
import Iterator.IteradorLista;
import java.util.Iterator;
import Facade.CentroAdopcion;

/**
 * Clase principal del juego "Juego".
 *
 */
public class EsoBradPets{
	
	public static void main(String[] args){
		
		CentroAdopcion c = new CentroAdopcion();
		
		c.darBienvenida();
		c.elegirNivel();
		c.adoptar();
		c.convivir();
		c.darFelicitacion();
	
	}
}
