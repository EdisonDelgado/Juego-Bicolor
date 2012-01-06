package juego;
import javax.swing.*;
import java.awt.*;
public class Columna extends JPanel {

    private Color colorColumna = Color.getHSBColor(140,240,230);
    private static boolean impar = true;
    private Ficha ficha[];
    Columna(Nivel nvl) {
        super();
        this.fijarColor();
        this.setLayout(null);
        this.creaFichas(nvl);
        
        
    }
    
    private void fijarColor(){
        if (impar) 
            this.setBackground(colorColumna);
        else 
            this.setBackground(colorColumna.brighter());
        impar = !impar;        
    }
    
    private void creaFichas(Nivel nvl){
        this.ficha = new Ficha[4];
        for (int i=0;i<4;i++) {
            ficha[i]=new Ficha(this,nvl);
            this.add(ficha[i]);
        }
        ficha[3].aparecer();
    }
    
    public boolean avanzarFichas() {
        boolean ret = true;
        int n = this.ficha.length;
        for (int i=0;i<n && ret;i++) {
            if (ficha[i].isVisible()) ret = ficha[i].avanzar();
        }
        return ret;
    }
   
}
