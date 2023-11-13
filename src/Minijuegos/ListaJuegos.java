package Minijuegos;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.Random;

import javax.management.ConstructorParameters;

import Modelo.Iterator.Catalogo;
import Modelo.Iterator.IteradorLista;

public class ListaJuegos implements Catalogo{
    
    protected LinkedList<Object> listaJuegos;

    public ListaJuegos(){
        listaJuegos = new LinkedList<>();
        String texto;
        String resultado;
        

        //Evento 1
        texto = "Daniel se le ha complicado resolver un problema de Álgebra Superior y está pidiendo ayuda.";
        ConstructorEventos c1 = new ConstructorEventos("1", "Ayuda en Tarea", texto, 1, 2, 5);
        resultado = "Lograste resolver el problema, y Daniel los recompensó con 3 pejecoins.";
        c1.agregarCaso(resultado, 3.0 , -7.0 , -12.0, 8.0, 4);
        resultado = "Te quedaste dormido en clases, por lo tanto no pudiste ayudar a Daniel :(";
        c1.agregarCaso(resultado, 0, -8, -15.0, -5.0, 1);
        agregarEvento((Object) c1);

        //evento 2
        texto = "Sal a explorar el parque con tu mascota.";
        ConstructorEventos c2 = new ConstructorEventos("2", "Paseo en el parque", texto, 1, 3, 5);
        resultado = "En el paseo, le respondiste a una mujer la dirección de la plaza, por lo que en agradecimiento les \n" + "dió 3 pejecoins.";
        c2.agregarCaso(resultado, 3, -10, -12, 10, 3);
        resultado = "En el paseo, te encontraste caminando 8 pejecoins, ¡Que suerte!";
        c2.agregarCaso(resultado, 8, -10, -10, 20, 1);
        resultado = "Se escapó el bulldog llamado Princesa, el cual los persiguió por todo el parque. Después de tanto correr,\n"  +
        "lograron escapar de el.";
        c2.agregarCaso(resultado, 0, -15, -15, -10, 1);
        agregarEvento((Object) c2);

        //evento 3
        texto = "InsanoMaster300 con su mascota está ofreciendo 25 pejecoins a quien logre ganarles un match 2v2 en \n" + "Smash bros(ojo que son main Steve y Kazuya). El costo por intentar es 10 pejecoins.";
        ConstructorEventos c3 = new ConstructorEventos("3", "Retas Smash", texto, 2, 2, 14);
        resultado = "Con tus skills, lograste ganar el match! Obtienes 25 pejecoins.";
        c3.agregarCaso(resultado, 15, -10, -13, 15, 6);
        resultado = "No lograron ganar, su Steve era demasiado fuerte...";
        c3.agregarCaso(resultado, -10, -10, -15, -8, 8);
        agregarEvento((Object) c3);

        //evento 4
        texto = "El mago brujo que vive afuera del Oxxo reta a la gente a tirar en su ruleta mágica! (Es para \n" + "un tik tok dice :v)";
        ConstructorEventos c4 = new ConstructorEventos("4", "Ruleta Mágica", texto, 2, 6, 6);
        resultado = "Deposito mágico: Se agregaron mágicamente 15 pejecoins a tu monedero electrónico!";
        c4.agregarCaso(resultado, 15, -8, -10, 15, 1);
        resultado = "Poción mágica: +15 pts a cada estadística de tu mascota!";
        c4.agregarCaso(resultado, 0, 15, 15, 15, 1);
        resultado = "Hechizo de visión Futura: Finalmente lograron ver el gameplay de Buscaminas 2!! Felicidad aumentada\n" + 
        "por severa obra que va a ser lanzada!";
        c4.agregarCaso(resultado, 0, -10, -12, 20, 1);
        resultado = "/tp @s -48120 301 15644: Fueron teletansportados a un bosque en medio de la carretera!\n" + 
        "El viaje de regreso fue largo y cansado.";
        c4.agregarCaso(resultado, 0, -20, -18, -12, 1);
        resultado = "Doxxeo mágico: Salió re troll el mago brujo, obtuvo tu información y te cambió a Movistar!\n" +
        "El spam de mensajes y llamadas es agobiante (ayudenme no me puedo cambiar).";
        c4.agregarCaso(resultado, 0, -10, -16, -13, 1);
        resultado = "Deposito mágico: Se agregaron mágicamente 15 pejecoins a tu monedero electrónico!\n" +
        "Eso diría si hubiera salido bien el hechizo, ahora perdiste 15 pejecoins :/.";
        c4.agregarCaso(resultado, -15, -8, -13, -13, 1);
        agregarEvento((Object) c4);

        //evento 5
        texto = "¿Necesitas dinero? Puedes conseguir una gran cantidad realizando encargos a randoms, eso si no te\n" + 
        "importa ser descubierto...";
        ConstructorEventos c5 = new ConstructorEventos("5", "Fraude fiscal", texto, 3, 3, 6);
        resultado = "Después de un arduo trabajo, lograste con éxito que tu cliente evadiera impuestos, \n" + 
        "obtienes 35 pejecoins como pago.";
        c5.agregarCaso(resultado, 35, -20, -15, 15, 2);
        resultado = "Con unas horas explotando el sistema, lograste hackear el Banco Azteca para que tu\n" + 
        "cliente saldara su gran deuda, obtienes 45 pejecoins como pago.";
        c5.agregarCaso(resultado, 45, -17, -12, 18, 1);
        resultado = "-Drake, he leído sobre la prisión...\n" +
                    "-y?\n" +
                    "-No es bonita :(\n" +
                    "\n(Tu cliente declaró mal los impuestos luego de que lavaras dinero con su taquería 'El John Cecinas'.\n" +
                    "Después de estar casi todo el día encerrados, un papu misterioso los ayudó a salir sacando tremendos\n" + 
                    "genjustsus a los guardias...)";
        c5.agregarCaso(resultado, 0, -20, -25, -13, 3);
        agregarEvento((Object) c5);

        //evento 6
        texto = "A un día de la entrega, el equipo del Brayan qué está por reprobar, ofrecen 30 pejecoins a los que \n" + 
        "les pasen la práctica 20! Aunque deberías tener cuidado...";
        ConstructorEventos c6 = new ConstructorEventos("6", "Pasar práctica de java", texto, 3, 3, 13);
        resultado = "Cambiando algunas variables y clases, pasaste la practica...\n" + 
        "No los descubrieron y encima conseguiste 30 pejecoins!";
        c6.agregarCaso(resultado, 30, -15, -15, 18, 8);
        resultado = "Cambiando algunas variables y clases, pasaste la practica...\n" +
        "Para su mala suerte, un método mal escrito causó que la práctica no compilara y \n" + 
        "no funcionara. El brayan te busca, será mejor que corras pa";
        c6.agregarCaso(resultado, 0, -18, -15, -10, 3);
        resultado = "No cambiaste nada y pasaste la practica...\n" +
        "Les descubrieron la copia y mandaron a ambos equipos a extra... Al menos te pagaron antes las 30 pejecoins.";
        c6.agregarCaso(resultado, 30, -18, -15, -8, 2);
        agregarEvento((Object) c6);

        //evento 7
        texto = "En un callejón solitario, unos sujetos con traje adinerados sospechosos ponen a sus mascotas a jugar, pero les falta una...";
        ConstructorEventos c7 = new ConstructorEventos("7", "¿¡RULETA RUSA!?", texto, 4, 4, 7);
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5...\n" +
        "4... *BANG!\n" +
        "\nSe reparte el dinero entre los ganadores, te han tocado 70 pejecoins.\n" +
        "No deberías hacer esto...";
        c7.agregarCaso(resultado, 70.0, -15.0, -15.0, -30.0, 2);
        
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5...\n" +
        "4...\n" +
        "3...\n" +
        "2... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores, esta vez te ha tocado 100 pejecoins...\n" +
        "¿De verdad valió la pena?";
        c7.agregarCaso(resultado, 100.0, -15.0, -15.0, -30.0, 1);
        
        resultado = "Comienza el juego...\n" +
        "6...\n" +
        "5... *BANG!!\n" +
        "\nSe reparte el dinero entre los ganadores, has obtenido 65 pejecoins...\n" +
        "Puedes conseguir dinero de otra forma.";
        c7.agregarCaso(resultado, 65.0, -15.0, -15.0, -30.0, 2);
        
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

        //evento 8
        texto = "En un sótano extraño hay una arena de peleas mortales de mascotas...!\n" +
        "Participa con 30 pejecoins y llevate una recompensa si tu mascota gana! ()";
        ConstructorEventos c8 = new ConstructorEventos("8", "PvP DE MASCOTAS!", texto, 4, 4, 4);
        resultado = "       QUE COMIENCE EL COMBATE!\n" +
        "\nTu mascota le ha tocado enfrentarse a... un gallo de pelea!?\n" +
        "Tras unos picotazos y cacareos del gallo, tu mascota contratacó con\n" + "un mordizco aturdidor a la cabeza!\n" +
        "Tu mascota remata con tremendo FALCON PUNCH!!\n" +
        "\n Has ganado!! Obtienes 70 pejecoins como recompensa.\n" +
        "Tuviste suerte con tu oponente...";
        c8.agregarCaso(resultado, 40, -15, -15, 16, 1);
        resultado = "       QUE COMIENCE EL COMBATE!\n" +
        "\n Tu mascota le ha tocado enfrentarse a... un macaco con kaiokenx50 modo javero despertado al 100%\n" +
        "Las mascotas comienzan a lanzar golpes acá bien maquiavélico como el kokun Z!\n" + 
        "El macaco logra derribar con su método embestidaDeLosPrimitivos() a tu mascota!\n" +
        "En medio de la conmoción, tu mascota está a punto de caer al suelo... pero se rehusa a morir!\n" +
        "Tras haber recordado las enseñanzas del Marselo, con su útlimo aliento tu mascota se levanta,\n" + 
        "activa el ultra instinto y ataca con una ráfaga de ganchos sin parar!!! El macaco ha caídooo!!\n" +
        "(Momentos después, tu mascota no resistió y también cayó, el daño recibido fue mortal...)\n" +
        "\n Has ganado!! Obtienes 120 pejecoins como recompensa.\n" +
        "Pero a qué costo...";
        c8.asignarMuerte(true);
        c8.agregarCaso(resultado, 90, 0, 0, 0, 1);
        resultado = "       QUE COMIENCE EL COMBATE!\n" +
        "\nTu mascota le ha tocado enfrentarse a... el bulldog llamado PRINCESA!\n" +
        "Tu mascota comienza atacando con la respiración del EsoTilin, 2da postura!\n" +
        "Ha enfuercido al bulldog, el cual responde con su mandíbula aplastante!\n" +
        "Tu mascota contraataca con un Hadouken, pero ese bulldog es imparable y ataca aunque reciba daño!\n" +
        "El ataque fue impactante y tu mascota cae malherida al suelo!\n" +
        "\nHas perdido... No se supone que debías cuidar a tu mascota? o_O";
        c8.agregarCaso(resultado, -30, -26, -19, -15, 1);
        resultado = "       QUE COMIENCE EL COMBATE!\n" +
        "\nTu mascota le ha tocado enfrentarse a... El mismísimo Big Chungus lvl 200 con build de fuerza y destreza!\n" +
        "\nFloppa ataca con un ataque pesado, pero tu mascota logra esquivarlo!\n" +
        "Tu mascota hace una embestida al estilo indio e impacta!\n" +
        "Floppa comenzó a rodar sin sentido y se ha alejado!\n" +
        "Floppa cambió de arma, y lanza el hechizo 'aullido aturdidor'?!, lo que deja paralizada a tu mascota!\n" +
        "Floppa hace un golpe crítico por la espalda a tu mascota, y termina cayendo!!!\n" +
        "\nHas perdido, tu mascota está malherida...";
        c8.agregarCaso(resultado, -30, -30, -17, -16, 1);
        agregarEvento((Object) c8);
    }

    /**
	 * Método que agrega un producto a la lista
	 */
	public void agregarEvento(Object a){
		listaJuegos.add(a);
	}

	/**
	 * Metodo que crea un iterador para recorrer los elementos del menu
	 *
	 * @return iterador
	 */
	public Iterator creaIterador(){
		return new IteradorLista(listaJuegos);
	}
}