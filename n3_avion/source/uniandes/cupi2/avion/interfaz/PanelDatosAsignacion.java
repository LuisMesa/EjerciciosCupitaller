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

import uniandes.cupi2.avion.mundo.*;

/**
 * Panel de los datos de asignaci�n de silla para un pasajero.
 */
public class PanelDatosAsignacion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    /**
     * Constante para la clase ejecutiva.
     */
    private final static String CLASE_EJECUTIVA = "Clase ejecutiva";
    
    /**
     * Constante para la clase econ�mica.
     */
    private final static String CLASE_ECONOMICA = "Clase econ�mica";
    
    /**
     * Constante para la ubicaci�n de la ventana.
     */
    private final static String UBICACION_VENTANA = "Ventana";
    
    /**
     * Constante para la ubicaci�n del pasillo.
     */
    private final static String UBICACION_PASILLO = "Pasillo";
    
    /**
     * Constante para la ubicaci�n del centro.
     */
    private final static String UBICACION_CENTRO = "Centro";
    
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Combo de selecci�n de la clase.
     */
    private JComboBox cbClase;

    /**
     * Combo de selecci�n de la ubicaci�n.
     */
    private JComboBox cbUbicacion;

    /**
     * Texto de ingreso de c�dula.
     */
    private JTextField txtCedula;

    /**
     * Texto de ingreso de nombre.
     */
    private JTextField txtNombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de los datos requeridos para la asignaci�n.
     */
    public PanelDatosAsignacion( )
    {
        setLayout( new GridLayout( 4, 1, 1, 6 ) );
        setBorder( BorderFactory.createTitledBorder( "Datos del pasajero" ) );

        // C�dula
        JPanel panelCedula = new JPanel( );
        panelCedula.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaCedula = new JLabel( "C�dula " );
        txtCedula = new JTextField( );
        txtCedula.setColumns( 15 );
        panelCedula.add( etiquetaCedula );
        panelCedula.add( txtCedula );
        add( panelCedula );

        // Nombre
        JPanel panelNombre = new JPanel( );
        panelNombre.setLayout( new FlowLayout( FlowLayout.RIGHT, 5, 0 ) );
        JLabel etiquetaNombre = new JLabel( "Nombre " );
        txtNombre = new JTextField( );
        txtNombre.setColumns( 15 );
        panelNombre.add( etiquetaNombre );
        panelNombre.add( txtNombre );
        add( panelNombre );

        // Ubicaci�n en el avi�n
        JPanel pUbicacion = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pUbicacion.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lUbicacion = new JLabel( "Ubicaci�n " );
        cbUbicacion = new JComboBox( );
        cbUbicacion.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbUbicacion.setPreferredSize( txtCedula.getPreferredSize( ) );
        cbUbicacion.addActionListener( this );
        pUbicacion.add( lUbicacion );
        pUbicacion.add( cbUbicacion );

        // Clase de silla
        JPanel pClase = new JPanel( new FlowLayout( FlowLayout.RIGHT ) );
        pClase.setPreferredSize( new Dimension( 250, 30 ) );
        JLabel lClase = new JLabel( "Clase " );
        cbClase = new JComboBox( );
        cbClase.setAlignmentX( Component.LEFT_ALIGNMENT );
        cbClase.addActionListener( this );
        cbClase.addItem( CLASE_ECONOMICA );
        cbClase.addItem( CLASE_EJECUTIVA );
        cbClase.setPreferredSize( txtCedula.getPreferredSize( ) );
        pClase.add( lClase );
        pClase.add( cbClase );

        add( pClase );
        add( pUbicacion );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Retorna el contenido del campo nombre en el panel.
     * @return valor del campo nombre.
     */
    public String darNombre( )
    {
        return txtNombre.getText( );
    }

    /**
     * Retorna el contenido del campo c�dula en el panel.
     * @return valor del campo c�dula.
     */
    public String darCedula( )
    {
        return txtCedula.getText( );
    }

    /**
     * Retorna la clase de la silla elegida en el panel.
     * @return Clase a la que pertenece la silla.
     */
    public int darClase( )
    {
        String sClase = ( String )cbClase.getSelectedItem( );
        if( sClase.equals( CLASE_EJECUTIVA ) )
            return Silla.CLASE_EJECUTIVA;
        else
            return Silla.CLASE_ECONOMICA;
    }

    /**
     * Retorna la ubicaci�n de la silla elegida en el panel.
     * @return Ubicaci�n al que pertenece la silla.
     */
    public char darUbicacion( )
    {
        String sUbicacion = ( String )cbUbicacion.getSelectedItem( );
        if( sUbicacion.equals( UBICACION_VENTANA ) )
            return Silla.VENTANA;
        else if( sUbicacion.equals( UBICACION_PASILLO ) )
            return Silla.PASILLO;
        else
            return Silla.CENTRAL;
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getSource( ) == cbClase )
        {
            String sClase = ( String )cbClase.getSelectedItem( );

            if( sClase.equals( CLASE_EJECUTIVA ) )
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_VENTANA );
                cbUbicacion.addItem( UBICACION_PASILLO );
            }
            else
            {
                cbUbicacion.removeAllItems( );
                cbUbicacion.addItem( UBICACION_VENTANA );
                cbUbicacion.addItem( UBICACION_CENTRO );
                cbUbicacion.addItem( UBICACION_PASILLO );
            }
            cbUbicacion.validate( );
        }
    }
}