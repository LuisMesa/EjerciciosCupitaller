package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

public abstract class Llanta extends Parte
{

    public static final int DIAMETRO = 85 ;
    
    public Llanta(int pX, int pY, Color pColorCarro)
    {
        super( pX, pY, DIAMETRO, DIAMETRO, pColorCarro );
    }
    public Llanta(BufferedReader pLector) throws Exception
    {
        super( pLector, DIAMETRO,DIAMETRO);
    }
    
    public void pintar( Graphics2D gP )
    {
        gP.setColor( new Color( 14, 14, 14 ) );
        gP.fillOval( x , y  , +85, +85);
        gP.setColor( Color.WHITE );
        gP.fillOval( x +DIAMETRO/5, y+DIAMETRO/5  , +3*DIAMETRO/5, +3*DIAMETRO/5);
        //pG.fillOval( x + 3 * DIAMETRO / 10, y + 3 * DIAMETRO / 10, +4 * DIAMETRO / 10, +4 * DIAMETRO / 10 );
        pintarRines( gP );
        
    }
    
    public abstract void pintarRines(Graphics2D gp);
    
}
