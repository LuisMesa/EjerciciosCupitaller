package uniandes.cupi2.fabricaDeCarros.mundo;

import java.awt.Color;
import java.io.BufferedReader;

public class TraseraCompacto extends Chasis
{
    public static final int ANCHO =215;

    public static final String IMAGEN ="delanteraCompacto.gif";

    public static final String TIPO ="TraseraCompacto";

    public TraseraCompacto(int pX, int pY, Color pColorCarro)
    {
        super( pX, pY, ANCHO, IMAGEN, pColorCarro );
        tipo = TIPO;
    }
    public TraseraCompacto(BufferedReader pBr) throws Exception
    {
        super( pBr, ANCHO, IMAGEN );
        tipo = TIPO;
    }

}
