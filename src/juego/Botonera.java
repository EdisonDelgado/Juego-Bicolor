package juego;

import javax.swing.*;
import java.util.*;
import java.awt.*;
public class Botonera extends JPanel {
    private Juego mijuego;
    int numColumnas=5;
    LinkedList boton;
    BotonJuego btn;

    //Constructor
    Botonera(Nivel nvl,Juego padre) {
        super();
        mijuego=padre;
        Columna col;
        boton = new LinkedList();
        BotonJuego b1,b2;
        if (mijuego!=null) {
            numColumnas = nvl.columnas();
            this.setLayout(new GridLayout(2,numColumnas));
            this.creaLinea(Color.WHITE, numColumnas);
            this.creaLinea(Color.BLACK, numColumnas);
        }
        this.setSize(new Dimension(200,50));
        this.setVisible(true);
    }

    
    public void creaLinea(Color colorInicial,int numColumnas){
        Columna col;
        BotonJuego b;
        for(int i=0;i<numColumnas;i++){
             col = mijuego.miTablero().miColumna(i+1);
             b = new BotonJuego(colorInicial,col);
             this.add(b);
             if (colorInicial.equals(Color.WHITE)) colorInicial = Color.BLACK;
             else colorInicial = Color.WHITE;
        }
    } 
    public void fijarJuego(Juego jgo) {
        this.mijuego = jgo;
    }
}
