package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

public class Rayo extends Estencil
{
    public static final int ALTO = 50;
    public static final int  ANCHO = 100;
    public static final String TIPO ="Rayo";
    
    public Rayo(int pX, int pY, Color pColor)
    {
        super( pX, pY, ALTO, ALTO, pColor );
        tipo = TIPO;
    }
    public  Rayo(BufferedReader pBr) throws Exception
    {
        super( pBr, ALTO, ANCHO );
        tipo = TIPO;
    }
    public void pintar(Graphics2D pG)
    {
        pG.setColor( color );
        
        int dx= ANCHO/21;
        int dy = ALTO / 13;
        
        int[] xs ={x+dx,x+6*dx,x+7*dx,x+11*dx,x+12*dx,x+21*dx,x+11*dx,x+10*dx,x+6*dx,x+5*dx,x};
        int[] ys ={y,y+4*dy,y+2*dy,y+6*dy,y+4*dy,y+13*dy,y+8*dy,y+10*dy,y+7*dy,y+9*dy,y+6*dy};
        pG.fillPolygon( xs, ys, 11 );
        //System.out.println("clase rayo pintar");
        
    }
    
}
