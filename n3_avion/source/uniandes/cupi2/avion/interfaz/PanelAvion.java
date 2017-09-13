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
import javax.swing.border.*;

import uniandes.cupi2.avion.mundo.*;

/**
 * Panel para el dibujo del avi�n.
 */
public class PanelAvion extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen del avi�n.
     */
    private ImageIcon imagen;

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazAvion principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel del avi�n. <br>
     * <b>post: <b>Se dibujan el avi�n y todas las sillas.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     */
    public PanelAvion( InterfazAvion pPrincipal )
    {
        super( new BorderLayout( ) );
        principal = pPrincipal;
        imagen = new ImageIcon( "data/imagenes/planoAvion.gif" );
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );

        // Adiciona las im�genes de las sillas ejecutivas
        JPanel panelEjecutivas = new JPanel( );
        dibujarSillasEjecutivas( panelEjecutivas );
        add( panelEjecutivas, BorderLayout.NORTH );

        // Adiciona las im�genes de las sillas economicas
        JPanel panelEconomicas = new JPanel( );
        dibujarSillasEconomicas( panelEconomicas );
        add( panelEconomicas, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Dibuja la gr�fica del avi�n.
     * @param pGrafica Gr�ficos del avi�n. pGrafica != null
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }

    /**
     * Crea las gr�ficas de las sillas ejecutivas del avi�n. <br>
     * <b>post: </b> Se dibujan las sillas ejecutivas del avi�n.
     * @param panel Panel donde se pintan las sillas.
     */
    private void dibujarSillasEjecutivas( JPanel panel )
    {
        panel.setLayout( new GridLayout( Avion.SILLAS_EJECUTIVAS / 4, 5, 8, 5 ) );
        panel.setBorder( new EmptyBorder( 90, 210, 20, 210 ) );

        Silla[] ejecutivas = principal.darSillasEjecutivas( );
        Silla silla;

        for( int i = 0; i < ejecutivas.length; i++ )
        {
            silla = ejecutivas[ i ];
            SillaGrafica sillaG = new SillaGrafica( silla.darClase( ), silla.sillaAsignada( ), silla.darNumero( ) );
            panel.add( sillaG );
            if( i % 4 == 1 )
            {
                panel.add( new JLabel( " " ) );
            }
        }
        panel.setOpaque( false );
    }

    /**
     * Crea las gr�ficas de las sillas econ�micas del avi�n. <br>
     * <b>post: </b> Se dibujan las sillas econ�micas del avi�n.
     * @param panel Panel donde se pintan las sillas.
     */
    private void dibujarSillasEconomicas( JPanel panel )
    {
        panel.setLayout( new GridLayout( Avion.SILLAS_ECONOMICAS / 6, 7, 5, 4 ) );
        panel.setBorder( new EmptyBorder( 0, 200, 100, 200 ) );

        Silla[] economicas = principal.darSillasEconomicas( );
        Silla silla;

        for( int i = 0; i < economicas.length; i++ )
        {
            silla = economicas[ i ];

            SillaGrafica sillaG = new SillaGrafica( silla.darClase( ), silla.sillaAsignada( ), silla.darNumero( ) );
            panel.add( sillaG );
            if( i % 6 == 2 )
            {
                panel.add( new JLabel( " " ) );
            }
        }
        panel.setOpaque( false );
    }
}