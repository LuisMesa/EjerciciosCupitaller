/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
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
 * Panel para el dibujo del avión.
 */
public class PanelAvion extends JPanel
{

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Imagen del avión.
     */
    private ImageIcon imagen;

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazAvion principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel del avión. <br>
     * <b>post: <b>Se dibujan el avión y todas las sillas.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     */
    public PanelAvion( InterfazAvion pPrincipal )
    {
        super( new BorderLayout( ) );
        principal = pPrincipal;
        imagen = new ImageIcon( "data/imagenes/planoAvion.gif" );
        setPreferredSize( new Dimension( imagen.getIconWidth( ), imagen.getIconHeight( ) ) );
        setOpaque( false );

        // Adiciona las imágenes de las sillas ejecutivas
        JPanel panelEjecutivas = new JPanel( );
        dibujarSillasEjecutivas( panelEjecutivas );
        add( panelEjecutivas, BorderLayout.NORTH );

        // Adiciona las imágenes de las sillas economicas
        JPanel panelEconomicas = new JPanel( );
        dibujarSillasEconomicas( panelEconomicas );
        add( panelEconomicas, BorderLayout.CENTER );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Dibuja la gráfica del avión.
     * @param pGrafica Gráficos del avión. pGrafica != null
     */
    public void paint( Graphics pGrafica )
    {
        pGrafica.drawImage( imagen.getImage( ), 0, 0, null, null );
        super.paint( pGrafica );
    }

    /**
     * Crea las gráficas de las sillas ejecutivas del avión. <br>
     * <b>post: </b> Se dibujan las sillas ejecutivas del avión.
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
     * Crea las gráficas de las sillas económicas del avión. <br>
     * <b>post: </b> Se dibujan las sillas económicas del avión.
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