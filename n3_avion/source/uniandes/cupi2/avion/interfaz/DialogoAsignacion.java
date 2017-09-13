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

import uniandes.cupi2.avion.mundo.*;

/**
 * Dialogo para la asignación de una silla.
 */
public class DialogoAsignacion extends JDialog
{

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Interfaz principal.
     */
    private InterfazAvion ventana;

    /**
     * Panel con los botones.
     */
    private PanelBotonesAsignacion panelBotones;

    /**
     * Panel con los datos.
     */
    private PanelDatosAsignacion panelDatos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el formulario de asignación de pasajeros.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAsignacion( InterfazAvion pPrincipal )
    {

        // Guarda la referencia a la ventana padre
        ventana = pPrincipal;

        // Configuración de propiedades gráficas
        setLayout( new BorderLayout( ) );

        // Crea el panel de datos
        panelDatos = new PanelDatosAsignacion( );
        add( panelDatos, BorderLayout.CENTER );

        // Crea el panel de botones
        panelBotones = new PanelBotonesAsignacion( this );
        add( panelBotones, BorderLayout.SOUTH );

        setTitle( "Registro de pasajero" );
        pack( );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Procesa la asignación de la silla de un pasajero. Recoge los datos del pasajero y de la clase y ubicación en la que desea su silla y procesa su registro<br>
     * <b>post: </b> Si el pasajero no está registrado y hay silla con las características solicitadas se asigna el pasajero a una silla del avión.<br>
     * Si la asignación no se puede hacer correctamente, muestra un mensaje.
     */
    public void asignarSillaPasajero( )
    {
        int cedula, clase;
        char ubicacion;
        String nombre, sCedula;

        nombre = panelDatos.darNombre( );
        sCedula = panelDatos.darCedula( );

        if( sCedula == null || sCedula.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "La cédula es requerida.", "Asignar silla", JOptionPane.ERROR_MESSAGE );
            return;
        }

        try
        {
            cedula = Integer.parseInt( sCedula );
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "La cédula debe ser numérica.", "Asignar silla", JOptionPane.ERROR_MESSAGE );
            return;
        }

        if( nombre == null || nombre.equals( "" ) )
        {
            JOptionPane.showMessageDialog( this, "El nombre es requerido.", "Asignar silla", JOptionPane.ERROR_MESSAGE );
            return;
        }

        // Asigna silla al pasajero
        clase = panelDatos.darClase( );
        ubicacion = panelDatos.darUbicacion( );
        ventana.asignarSilla( clase, ubicacion, cedula, nombre );

        ventana.actualizar( );
        dispose( );

    }

    /**
     * Cancela el proceso de asignación.
     */
    public void cancelar( )
    {
        ventana.actualizar( );
        dispose( );
    }
}