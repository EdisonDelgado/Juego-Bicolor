
package juego;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author CC
 */
public class PanelInformacion extends JPanel {
    private JLabel user;
    private JLabel puntaje;
    private int puntos=0;
    private JLabel nivelnum;
    PanelInformacion(int numNivel) {
        super();
        this.user = new JLabel("sin nombre");
        this.puntaje = new JLabel("00000");
        this.nivelnum = new JLabel(numNivel+"");
        this.setLayout(new GridLayout(4,1));
        this.add(user);
        this.add(puntaje);
        this.add(nivelnum);
    }
    void sumaPuntos(int ptosmas){
        this.puntos+=ptosmas;
        this.puntaje.setText(this.puntos+"");
    }
    void fijaPuntos(int ptos){
        this.puntos = ptos;
        this.sumaPuntos(0);
    }
}
