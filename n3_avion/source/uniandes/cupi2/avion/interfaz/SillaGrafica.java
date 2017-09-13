/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n3_avion
 * Autor: Equipo Cupi2.
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.avion.interfaz;

import java.awt.*;

import javax.swing.*;

/**
 * Representaci�n gr�fica de una silla del avi�n.
 */
public class SillaGrafica extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen de la silla.
     */
    private ImageIcon imagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la representaci�n gr�fica de la silla. <br>
     * <b>post: </b> Imagen de la silla distingue si est� libre u ocupada.
     * @param pClaseSilla Clase de la silla del pasajero.
     * @param pSillaAsignada Silla asignada al pasajero.
     * @param pNumeroSilla N�mero de silla asignada al pasajero.
     */
    public SillaGrafica( int pClaseSilla, boolean pSillaAsignada, int pNumeroSilla )
    {
        super( new BorderLayout( ) );
        JLabel lSilla = new JLabel( );
        if( pClaseSilla == 1 && pSillaAsignada )
            imagen = new ImageIcon( "data/imagenes/silla-ejec-asig.gif" );
        else if( pClaseSilla == 1 && !pSillaAsignada )
            imagen = new ImageIcon( "data/imagenes/silla-ejec-libre.gif" );
        else if( pClaseSilla == 2 && pSillaAsignada )
            imagen = new ImageIcon( "data/imagenes/silla-econ-asig.gif" );
        else if( pClaseSilla == 2 && !pSillaAsignada )
        {
            imagen = new ImageIcon( "data/imagenes/silla-econ-libre.gif" );
            lSilla.setForeground( Color.white );
        }
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );
        lSilla.setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        lSilla.setText( "" + pNumeroSilla );
        lSilla.setHorizontalAlignment( SwingConstants.CENTER );
        add( lSilla );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Dibuja la imagen de la silla.
     * @param pGrafica Gr�fica de la silla.
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }
}