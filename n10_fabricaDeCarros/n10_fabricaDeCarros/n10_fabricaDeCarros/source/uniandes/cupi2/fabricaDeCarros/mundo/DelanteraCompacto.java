package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.io.BufferedReader;

public class DelanteraCompacto extends Chasis
{
    public static final int ANCHO =374;
    
    public static final String IMAGEN ="delanteraCompacto.gif";
    
    public static final String TIPO ="DelanteraCompacto";
    
    
    public DelanteraCompacto(int px, int py, Color pColor)
    {
           super( px, py, ANCHO, IMAGEN, pColor );
           tipo = TIPO;
    }
    public DelanteraCompacto(BufferedReader pBr) throws Exception
    {
        super( pBr, ANCHO, IMAGEN );
        tipo = TIPO;
    }
}
