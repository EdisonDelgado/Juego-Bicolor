package juego;
import java.awt.*;

public class Nivel {
    private int nivel=1;
    private int cantidadColumnas;
    private int velocidadCaida;
    private final int cantidadColores=2;
    private int tasaAparicionPorSeg;
    private long horaUltimoGeneradoMs;
    static private int deltaColumnas;
    static private int deltaVelocidadCaida;
    static private int cantidadColumnasInicial=12;
    static private int velocidadInicialCaidaPorcentaje=5;
    static private int lapsoEntreCaidasMs=500;
    private Color colorFicha[];
    Nivel() {
        colorFicha = new Color[2];
        colorFicha[0] = Color.WHITE; 
        colorFicha[1] = Color.BLACK;
        this.fijarNivel(1);
        
   }
    
   public void siguiente() {
       this.cantidadColumnas += this.deltaColumnas;
       this.velocidadCaida += this.deltaVelocidadCaida;
       this.nivel++;
   }
   
   public void fijarNivel(int nivelPartida) {
       
       if(nivelPartida>0 && nivelPartida<=10){
        this.cantidadColumnas = this.cantidadColumnasInicial;
        this.velocidadCaida= this.velocidadInicialCaidaPorcentaje;
        this.tasaAparicionPorSeg= 1500;
        this.deltaColumnas=1;
        this.deltaVelocidadCaida=3;
        for(int i=2;i<=nivelPartida;i++)
               this.siguiente();
       }
   }
   
   public int deltaVelocidadPctj() {
       return this.velocidadCaida;
   }
   
   public int deltaEntreCaidasMs() {
       return this.lapsoEntreCaidasMs;
   }

   public int columnas() {
       return this.cantidadColumnas;
   }
   
   public int numeroNivelActual() {
       return this.nivel;
   }
   
   public int numColoresFicha() {
       return colorFicha.length;
   }
   
   public Color colorFicha(int indice){
       if (indice<0 || indice>= colorFicha.length) return null;
       return colorFicha[indice];
   }
    
}
