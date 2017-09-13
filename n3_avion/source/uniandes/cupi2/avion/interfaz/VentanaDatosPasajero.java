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


/**
 * Formulario para presentar los datos y el registro del pasajero.
 */
public class VentanaDatosPasajero extends JFrame
{
    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con los botones.
     */
    private PanelBotonesDatosPasajero panelBotones;

    /**
     * Panel de los datos del pasajero.
     */
    private PanelDatosPasajero panelDatosPasajero;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea la ventana con los datos del pasajero
     * @param pNombrePasajero Nombre del pasajero.
     * @param pCedulaPasajero Cédula del pasajero.
     * @param pClaseSilla Clase de la silla del pasajero.
     * @param pNumeroSilla Número de la silla del pasajero.
     * @param pUbicacionSilla Ubicación de la silla del pasajero.
     */
    public VentanaDatosPasajero( String pNombrePasajero, int pCedulaPasajero, int pClaseSilla, int pNumeroSilla, int pUbicacionSilla )
    {
        setLayout( new BorderLayout( ) );

        // Crea el panel de datos del pasajero
        panelDatosPasajero = new PanelDatosPasajero( pNombrePasajero, pCedulaPasajero, pClaseSilla, pNumeroSilla, pUbicacionSilla );
        add( panelDatosPasajero, BorderLayout.NORTH );

        // Crea el panel de botones
        panelBotones = new PanelBotonesDatosPasajero( this );
        add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Datos registro del pasajero" );
        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Cierra la ventana
     */
    public void aceptar( )
    {
        dispose( );
    }
}