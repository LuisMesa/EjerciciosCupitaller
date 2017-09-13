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
import java.awt.event.*;

import javax.swing.*;

/**
 * Panel de los botones de la ventana de informaci�n del pasajero.
 */
public class PanelBotonesDatosPasajero extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el bot�n aceptar.
     */
    public final static String ACEPTAR = "ACEPTAR";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Ventana de datos del pasajero.
     */
    private VentanaDatosPasajero ventana;

    /**
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones de la ventana de datos del pasajero.
     * @param pVentana Ventana de la que hace parte el panel. pVentana != null.
     */
    public PanelBotonesDatosPasajero( VentanaDatosPasajero pVentana )
    {
        setLayout( new GridLayout( 1, 2, 10, 1 ) );
        ventana = pVentana;

        // Aceptar
        botonAceptar = new JButton( );
        botonAceptar.setText( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );
        add( botonAceptar );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------
    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            ventana.aceptar( );
        }
    }
}