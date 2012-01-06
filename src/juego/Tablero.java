/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class Tablero extends JPanel {
    LinkedList<Columna> columna;
    
    Tablero(Nivel nvl) {
        this.setLayout(new GridLayout(1,nvl.columnas()));
        Columna col;
        columna = new LinkedList();
        for(int i=1;i<=nvl.columnas();i++) {
            col = new Columna(nvl);
            this.add(col);
            columna.addFirst(col);
        }
        this.validate();
        this.setVisible(true);
        
    }
    
    public boolean avanzarFichas(){
        Iterator it = columna.iterator();
        boolean ret = true;
        Columna col;
        int j=0;
        while(it.hasNext() && ret ) {
            col = (Columna)it.next();
            ret = ret && col.avanzarFichas();
        }
        return ret;
    }
    

    public Columna miColumna(int numColumna) {
        Columna ret;
        numColumna--;
        if (columna==null) return null;
        if (columna.size()<numColumna || numColumna<=0) return null;
        ret= columna.get(numColumna);
        return ret;
    }
}
