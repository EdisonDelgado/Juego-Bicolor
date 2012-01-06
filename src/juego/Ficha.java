
package juego;
import javax.swing.*;
import java.awt.*;
import java.lang.*;

public class Ficha extends JPanel {
    private Color color;
    private int porcentajeAvance=0;
    //private boolean visible;
    private long horaUltimaCaidaMs;
    private Columna miColumna;
    private Nivel nivel;
    static private double azar; 
    Ficha (Columna col, Nivel nvl){
        this.nivel = nvl;
        this.miColumna=col;
        this.setVisible(false);
        this.setSize(10,10);
    }
    
    void aparecer() {
        this.fijarColorAzar();
        this.porcentajeAvance=0;
        this.setVisible(true);
        this.fijaPosicion();
        this.validate();
        this.miColumna.validate();
        this.horaUltimaCaidaMs = System.currentTimeMillis();
        
        if (Double.isNaN(this.azar)) {
            this.azar = Math.log10(this.horaUltimaCaidaMs);
        }
    }
    
    private void fijarColorAzar() {
        this.azar = Math.log10(this.azar)*10000;
        this.azar -= Math.floor(this.azar);        
        int cT = (int)(this.azar*this.nivel.numColoresFicha());
        this.setBackground(this.nivel.colorFicha(cT));
        }
    
    public boolean avanzar() {
        long horaActual = System.currentTimeMillis();
        if (horaActual>=nivel.deltaEntreCaidasMs()+this.horaUltimaCaidaMs) {
            this.setVisible(false);
            this.porcentajeAvance += nivel.deltaVelocidadPctj();
            this.fijaPosicion();
            this.setVisible(true);
            this.horaUltimaCaidaMs = horaActual;
        }
        return this.porcentajeAvance<100;
    }
    
    
    private void fijaPosicion() {
        int ancho = 15;
        int alto = 15;
        int altoColumna = this.miColumna.getHeight();
        int posY = (int)((this.porcentajeAvance/100.0)*altoColumna);
        this.setBounds(3,posY,ancho,alto);
    }
    
}
