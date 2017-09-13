package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;

public class RinesDeLujo extends Llanta
{

   public static final String TIPO ="RinesDeLujo";
   
    public RinesDeLujo( BufferedReader pLector ) throws Exception
    {
        super( pLector );
        tipo = TIPO;
    }
    public RinesDeLujo( int pX, int pY, Color pColorCarro)
    {
        super( pX, pY, pColorCarro );
        tipo = TIPO;
    }

    
    public void pintarRines( Graphics2D pG )
    {
        
        //Rines Gama Media
        pG.setColor( new Color( 14, 14, 14 ) );
        pG.fillOval( x + 3 * DIAMETRO / 10, y + 3 * DIAMETRO / 10, +4 * DIAMETRO / 10, +4 * DIAMETRO / 10 );

        double cos = 0.829;
        double sin = 0.559;
        int d2 = 3*DIAMETRO / 5;
        int d1 = d2 / 3;
        int radio = DIAMETRO / 2;
        int radio2 = DIAMETRO / 2 - d2 - d1;
        pG.setColor( Color.YELLOW );

        BasicStroke stroke = new BasicStroke( DIAMETRO / 15 );
        pG.setStroke( stroke );
        int a = ( int ) ( radio2 * sin );
        int b = ( int ) ( radio2 * cos );

        int puntox1 = x + radio;
        int puntox2 = x + radio + b;
        int puntox3 = x + radio - b;
        int puntoy1 = y + d1 + d2;
        int puntoy2 = y + radio - a;
        int puntoy3 = y + radio + a;
        int puntoy4 = y + ancho - d2 - d1;

        pG.drawLine( puntox1, puntoy1, puntox1, puntoy4 );
        pG.drawLine( puntox2, puntoy2, puntox3, puntoy3 );
        pG.drawLine( puntox3, puntoy2, puntox2, puntoy3 );

        pG.fillOval( x + radio - d1 / 2, y + radio - d1 / 2, d1, d1 );

        pG.setColor( Color.gray );
        stroke = new BasicStroke( DIAMETRO / 50 );
        pG.setStroke( stroke );
        pG.drawOval( x + radio - d1 / 4, y + radio - d1 / 4, d1 / 2, d1 / 2 );
    }

}
