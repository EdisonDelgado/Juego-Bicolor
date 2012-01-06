
package juego;
import java.awt.*;
import javax.swing.*;

public class Juego extends JFrame {
    long puntaje;
    private Tablero tablero;
    private Nivel nivelActual;
    private Botonera botonera;
    private PanelInformacion pizarra;
            
            
    Juego() {
        super("JUEGO BICOLOR");
        this.crearAmbiente();
    }
    
    public void jugar() {
        while (tablero.avanzarFichas()) {
            this.setVisible(true);
            this.validate();
            
        }
    }
    
    public void pausar() {
    }
    
    public void salir() {
    
    }
    
    public void guardarPuntaje() {
        
    }
    
    public void crearAmbiente() {

        this.nivelActual = new Nivel();
        this.tablero = new Tablero(nivelActual);
        this.botonera = new Botonera(nivelActual,this);
        //botonera.fijarJuego(this);
        this.pizarra = new PanelInformacion(nivelActual.numeroNivelActual());
        pizarra.setSize(100,300);
        tablero.setSize(500,300);
        botonera.setSize(500,100); 
        // por mejorar
        JButton btn = new JButton("Fin");
        btn.setSize(100, 100);
        
        
        this.setSize(600, 400);        
        this.setLayout(new GridLayout(2,2));
        this.add(pizarra);
        this.add(tablero);
        this.add(btn);
        this.add(botonera);
        this.setVisible(true);
   }

    public Nivel miNivel() {
        return this.nivelActual;
    }

    public Tablero miTablero() {
        return this.tablero;
    }    
    
}
