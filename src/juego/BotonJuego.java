
package juego;
import javax.swing.*;
import java.awt.*;

public class BotonJuego extends JButton {
    private Columna micolumna;
    BotonJuego() {
        super();
    }
    
    BotonJuego(Color fondo,Columna suColumna) {
        super();
        this.setBackground(fondo);
        this.micolumna = suColumna;
    }


    public void fijarColumna(Columna clm){
        this.micolumna = clm;

    }

    public void pintarNegro() {
        this.setBackground(Color.BLACK);
    }

    public void pintarBlanco() {
        this.setBackground(Color.WHITE);
    }


}
