package Minijuegos;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

import javax.management.ConstructorParameters;

import Modelo.Iterator.Catalogo;
import Modelo.Iterator.IteradorLista;

/**
 * Clase que define la lista de Juegos (eventos) del minijuego.
 * 
 * @author paolasanv
 * @author Supr-Lilito
 * @author JesusEVR
 * @version noviembre 2023
 *
 */
public class ListaJuegos implements Catalogo{
    /**
     * Lista que guarda los eventos del minijuego.
     */
    protected LinkedList<Object> listaJuegos;

    /**
     * Constructor por omisión. Se crean los eventos del minijuego y se agregan a la lista.
     */
    public ListaJuegos(){
        listaJuegos = new LinkedList<>();
        String texto;
        String resultado;

        // Evento 1
        texto = "A Daniel se le complica resolver un problema de su tarea de Algebra Superior y pide ayuda a ti y a tu mascota.";
        ConstructorEventos c1 = new ConstructorEventos("1", "Ayuda en Tarea", texto, 1, 2, 5);
        resultado = "Lograron resolver el problema y Daniel los recompenso con 3 pejecoins.";
        c1.agregarCaso(resultado, 3.0 , -7.0 , -12.0, 8.0, 4);
        resultado = "Te quedaste dormido en clases, por lo tanto no pudiste ayudar a Daniel :(";
        c1.agregarCaso(resultado, 0, -8, -15.0, -5.0, 1);
        agregarEvento((Object) c1);

        // Evento 2
        texto = "Sal a explorar el parque con tu mascota.";
        ConstructorEventos c2 = new ConstructorEventos("2", "Paseo en el parque", texto, 1, 3, 5);
        resultado = "En el paseo, le dijiste la direccion de la plaza a una ancianita, por lo que en agradecimiento les \n" + 
        "dio 3 pejecoins.";
        c2.agregarCaso(resultado, 3, -10, -12, 10, 3);
        resultado = "Durante el paseo, te encontraste 8 pejecoins en el suelo. ¡Que suerte!";
        c2.agregarCaso(resultado, 8, -10, -10, 20, 1);
        resultado = "Se escapo el bulldog llamado Princesa, el cual los persiguio por todo el parque. Despues de tanto correr,\n"  +
        "lograron escapar de el.";
        c2.agregarCaso(resultado, 0, -15, -15, -10, 1);
        agregarEvento((Object) c2);

        // Evento 3
        texto = "InsanoMaster300 con su mascota esta ofreciendo 25 pejecoins a quien logre ganarles un match 2v2 en \n" + "Super Smash Bros (ojo que son main Steve y Kazuya). El costo por intentar es 10 pejecoins.";
        ConstructorEventos c3 = new ConstructorEventos("3", "Retas Smash", texto, 2, 2, 14);
        resultado = "¡Gracias a tus habilidades, hiciste tremendo combo y lograron ganar el match! Obtienes 25 pejecoins.";
        c3.agregarCaso(resultado, 15, -10, -13, 15, 6);
        resultado = "No lograron ganar, su Steve era demasiado fuerte...";
        c3.agregarCaso(resultado, -10, -10, -15, -8, 8);
        agregarEvento((Object) c3);

        // Evento 4
        texto = "El mago brujo que vive afuera del Oxxo reta a la gente a tirar en su ruleta magica! (Es para \n" + "un TikTok dice :v)";
        ConstructorEventos c4 = new ConstructorEventos("4", "Ruleta Mágica", texto, 2, 6, 6);
        resultado = "¡Deposito magico: Se agregaron magicamente 15 pejecoins a tu monedero electronico!";
        c4.agregarCaso(resultado, 15, -8, -10, 15, 1);
        resultado = "¡Poción magica: +15 pts a cada estadística de tu mascota!";
        c4.agregarCaso(resultado, 0, 15, 15, 15, 1);
        resultado = "¡Hechizo de vision futura: Finalmente lograron ver el gameplay de Buscaminas 2! ¡Felicidad aumentada\n" + 
        "por severa obra que va a ser lanzada!";
        c4.agregarCaso(resultado, 0, -10, -12, 20, 1);
        resultado = "/tp @s -48120 301 15644: Fueron teletansportados a un bosque en medio de la carretera!\n" + 
        "El viaje de regreso fue largo y cansado.";
        c4.agregarCaso(resultado, 0, -20, -18, -12, 1);
        resultado = "¡Doxxeo magico: Salio re troll el mago brujo, obtuvo tu informacion y te cambio a Movistar!\n" +
        "El spam de mensajes y llamadas es agobiante (ayudenme no me puedo cambiar).";
        c4.agregarCaso(resultado, 0, -10, -16, -13, 1);
        resultado = "¡Deposito magico: Se agregaron magicamente 15 pejecoins a tu monedero electronico!\n" +
        "Eso diria si hubiera salido bien el hechizo. Solo perdiste 15 pejecoins :/.";
        c4.agregarCaso(resultado, -15, -8, -13, -13, 1);
        agregarEvento((Object) c4);

        // Evento 5
        texto = "¿Necesitas dinero? Puedes conseguir una gran cantidad realizando encargos a desconocidos, si no te\n" + 
        "importa ser descubierto...";
        ConstructorEventos c5 = new ConstructorEventos("5", "Fraude fiscal", texto, 3, 3, 6);
        resultado = "Despues de un arduo trabajo, lograste con exito que tu cliente evadiera impuestos, \n" + 
        "obtienes 35 pejecoins como pago.";
        c5.agregarCaso(resultado, 35, -20, -15, 15, 2);
        resultado = "Con unas horas explotando el sistema, lograste hackear el Banco Azteca para que tu\n" + 
        "cliente saldara su gran deuda, obtienes 45 pejecoins como pago.";
        c5.agregarCaso(resultado, 45, -17, -12, 18, 1);
        resultado = "- Drake, he leído sobre la prisión...\n" +
                    "- ¿Y?\n" +
                    "- No es bonita :(\n" +
                    "\n(Tu cliente declaro mal los impuestos luego de que lavaras dinero con su taquería 'El John Cecinas'.\n" +
                    "Despues de estar casi todo el dia encerrados, un papu misterioso los ayudo a salir con tremendos\n" + 
                    "genjustsus...)";
        c5.agregarCaso(resultado, 0, -20, -25, -13, 3);
        agregarEvento((Object) c5);

        // Evento 6
        texto = "¡A un dia de la entrega, el equipo de Aquiles Esquivel Madrazo (que esta por reprobar) ofrece 30 pejecoins a quienes \n" + 
        "les pasen el proyecto 2! Aunque deberias tener cuidado...";
        ConstructorEventos c6 = new ConstructorEventos("6", "Pasar practica de java", texto, 3, 3, 13);
        resultado = "Cambiando algunas variables y clases, pasaste la practica...\n" + 
        "No los descubrieron y te pagaron las 30 pejecoins prometidas.";
        c6.agregarCaso(resultado, 30, -15, -15, 18, 8);
        resultado = "Cambiando algunas variables y clases, pasaste la practica...\n" +
        "Para su mala suerte, un metodo mal escrito causó que la practica no compilara y \n" + 
        "no funcionara. Aquiles te busca, sera mejor que corras pa'.";
        c6.agregarCaso(resultado, 0, -18, -15, -10, 3);
        resultado = "No cambiaste nada y pasaste la practica...\n" +
        "Les descubrieron la copia y mandaron a ambos equipos a extra... Al menos te pagaron antes las 30 pejecoins.";
        c6.agregarCaso(resultado, 30, -18, -15, -8, 2);
        agregarEvento((Object) c6);

        // Evento 7
        texto = "En un callejon solitario, unos sujetos con traje adinerados sospechosos ponen a sus\n" +
        "mascotas a jugar, pero les falta una...";
        ConstructorEventos c7 = new ConstructorEventos("7", "¿¡RULETA RUSA!?", texto, 4, 4, 7);
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5...\n" +
        "4... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores, te han tocado 56 pejecoins.\n" +
        "No deberías hacer esto de nuevo, a tu mascota casi le da un infarto...";
        c7.agregarCaso(resultado, 56.0, -15.0, -15.0, -30.0, 2);
        
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5...\n" +
        "4...\n" +
        "3...\n" +
        "2... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores, esta vez te ha tocado 64 pejecoins...\n" +
        "¿De verdad valió la pena?";
        c7.agregarCaso(resultado, 64.0, -15.0, -15.0, -30.0, 1);
        
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores, has obtenido 60 pejecoins...\n" +
        "Seguro que puedes conseguir dinero de otra forma.";
        c7.agregarCaso(resultado, 60.0, -15.0, -15.0, -30.0, 2);
        
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5...\n" +
        "4...\n" +
        "3... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores...\n" + 
        "Pero tú no eres uno de ellos.";
        c7.asignarMuerte(true);
        c7.agregarCaso(resultado, 0.0, 0.0, 0.0, 0.0, 2);
        agregarEvento((Object) c7);

        // Evento 8
        texto = "En un extraño sotano hay una arena de peleas mortales entre mascotas...!\n" +
        "¡Participa con 30 pejecoins y llevate una recompensa si tu mascota gana! ()";
        ConstructorEventos c8 = new ConstructorEventos("8", "¡PvP DE MASCOTAS!", texto, 4, 4, 4);
        resultado = "       ¡QUE COMIENCE EL COMBATE!\n" +
        "\nA tu mascota le ha tocado enfrentarse a... ¡¿un gallo de pelea!?\n" +
        "¡Tras unos picotazos y cacareos del gallo, tu mascota contrataca con\n" + "un mordizco aturdidor a la cabeza!\n" +
        "¡Tu mascota remata con tremendo FALCON PUNCH!!\n" +
        "\n ¡Has ganado! Obtienes 70 pejecoins como recompensa.\n" +
        "Tuviste suerte con tu oponente...";
        c8.agregarCaso(resultado, 40, -15, -15, 16, 1);
        resultado = "       ¡QUE COMIENCE EL COMBATE!\n" +
        "\nA tu mascota le ha tocado enfrentarse a... un macaco con Kaio-ken x50 modo javero despertado al 100%\n" +
        "¡Las mascotas comienzan a lanzar golpes aca bien maquiavelicos como el Kokun Z!\n" + 
        "¡El macaco logra derribar con su metodo embestidaDeLosPrimitivos() a tu mascota!\n" +
        "¡En medio de la conmocion, tu mascota esta a punto de caer al suelo... pero se rehusa a morir!\n" +
        "¡¡Tras haber recordado las enseñanzas del Marselo, con su utlimo aliento tu mascota se levanta,\n" + 
        "activa el ultra instinto y ataca con una rafaga de ganchos sin parar!!! ¡El macaco ha caidooo!!\n" +
        "(Momentos despues, tu mascota no resistio y tambien cayo, el daño recibido fue mortal...)\n" +
        "\n ¡¡Has ganado!! Obtienes 120 pejecoins como recompensa.\n" +
        "Pero a que costo... Por andar participando en peleas clandestinas";
        c8.asignarMuerte(true);
        c8.agregarCaso(resultado, 90, 0, 0, 0, 1);
        resultado = "       ¡QUE COMIENCE EL COMBATE!\n" +
        "\n¡Tu mascota le ha tocado enfrentarse a... el bulldog llamado PRINCESA!\n" +
        "¡Tu mascota comienza atacando con la respiracion del EsoTilin, 2da postura!\n" +
        "¡Ha enfuercido al bulldog, el cual responde con su mandíbula aplastante!\n" +
        "Tu mascota contraataca con un Hadouken, pero ese bulldog es imparable y ataca aunque reciba daño!\n" +
        "El ataque fue impactante y tu mascota cae malherida al suelo!\n" +
        "\nHas perdido... No se supone que debías cuidar a tu mascota? o_O";
        c8.asignarMuerte(false);
        c8.agregarCaso(resultado, -30, -26, -19, -15, 1);
        resultado = "       ¡QUE COMIENCE EL COMBATE!\n" +
        "\nTu mascota le ha tocado enfrentarse a... El mismísimo Big Chungus lvl 200 con build de fuerza y destreza!\n" +
        "\nChungus ataca con un ataque pesado, pero tu mascota logra esquivarlo!\n" +
        "Tu mascota hace una embestida al estilo indio e impacta!\n" +
        "Chungus comenzo a rodar sin sentido y se ha alejado!\n" +
        "¡Tu mascota cambia de arma, y lanza el hechizo 'aullido aturdidor'! ¡Esto deja paralizado a Cungus!\n" +
        "¡¡¡Tu mascota hace un golpe crítico por la espalda a Chungus, y termina cayendo!!!\n" +
        "\n ¡Has ganado! Obtienes 90 pejecoins como recompensa.\n" +
        "Pero deberías hacer otras actividades menos peligrosas con tu mascota...";
        c8.agregarCaso(resultado, 60, -25, -17, -16, 1);
        agregarEvento((Object) c8);
    }
	
	/**
	 * Método que agrega un evento a la lista de eventos
	 */
	public void agregarEvento(Object a){
		listaJuegos.add(a);
	}

	/**
	 * Metodo que crea un iterador para recorrer los elementos de la lista de eventos
	 *
	 * @return iterador
	 */
	public Iterator creaIterador(){
		return new IteradorLista(listaJuegos);
	}
}
