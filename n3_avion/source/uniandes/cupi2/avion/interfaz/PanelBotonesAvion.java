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
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

/**
 * Panel de botones de interacción con el programa del avión.
 */
public class PanelBotonesAvion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el botón de asignar silla a un pasajero.
     */
    public final static String ASIGNAR = "ASIGNAR_PASAJERO";

    /**
     * Constante para el botón de anular silla a un pasajero.
     */
    public final static String ANULAR = "ANULAR_PASAJERO";

    /**
     * Constante para el botón de buscar pasajero.
     */
    public final static String BUSCAR = "BUSCAR_PASAJERO";

    /**
     * Constante para el botón de porcentaje de ocupación.
     */
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    /**
     * Constante para el botón de opción 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante para el botón de opción 2.
     */
    private final static String OPCION_2 = "OPCION_2";

    /**
     * Constante para agregar un equipaje a un pasajero.
     */
    public final static String AGREGAR_EQUIPAJE = "AGREGAR_EQUIPAJE";

    /**
     * Constante para buscar las equipajes de un pasajero.
     */
    public final static String BUSCAR_EQUIPAJES = "BUSCAR_EQUIPAJES";

    /**
     * Constante para el peso total del avión.
     */
    public final static String PESO_TOTA_AVION_EQUIPAJE = "PESO_EQUIPAJE";

    /**
     * Constante para dar los equipajes de una categoría.
     */
    public final static String EQUIPAJES_CATEGORIA = "EQUIPAJES_CATEGORIA";

    /**
     * Constante para dar el equipaje más pesado.
     */
    public final static String EQUIPAJE_MAS_PESADO = "EQUIPAJE_MAS_PESADO";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para asignar silla a un nuevo pasajero.
     */
    private JButton bAsignar;

    /**
     * Botón para anular silla a un nuevo pasajero..
     */
    private JButton bAnular;

    /**
     * Botón para búsqueda de un pasajero.
     */
    private JButton bBuscarPasajero;

    /**
     * Botón para calcular porcentaje de ocupación.
     */
    private JButton bPorcOcupacion;

    /**
     * Botón para agregar equipajes.
     */
    private JButton bAgregarEquipaje;

    /**
     * Botón para buscar equipajes.
     */
    private JButton bBuscarEquipajes;

    /**
     * Botón para dar el peso total del avión.
     */
    private JButton bPesoTotalEquipajesAvion;

    /**
     * Botón para dar los equipajes de un género.
     */
    private JButton bPesoPorCategoriaEquipaje;

    /**
     * Botón para dar el equipaje más pesado.
     */
    private JButton bEquipajeMasPesado;

    /**
     * Botón para extensión 1.
     */
    private JButton botonOpcion1;

    /**
     * Botón para extensión 2.
     */
    private JButton botonOpcion2;

    /**
     * Interfaz principal.
     */
    private InterfazAvion principal;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea el panel de botones <br>
     * <b>post: <b> Se crean y alistan los botones de la interfaz.
     * @param pPrincipal Referencia a la clase principal de la interfaz.
     */
    public PanelBotonesAvion( InterfazAvion pPrincipal )
    {
        // guarda la referencia a la ventana padre
        principal = pPrincipal;

        // Configura propiedades visuales
        setLayout( new GridLayout( 6, 3, 8, 2 ) );
        setBorder( new EmptyBorder( 5, 5, 5, 5 ) );

        // Línea avión
        add( new JLabel( "Opciones del avión:" ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        // Botón asignar
        bAsignar = new JButton( "Asignar silla" );
        bAsignar.setActionCommand( ASIGNAR );
        bAsignar.addActionListener( this );
        bAsignar.setPreferredSize( new Dimension( 40, 10 ) );
        add( bAsignar );

        // Botón anular silla asignada
        bAnular = new JButton( "Desasignar pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        // Botón buscar pasajero
        bBuscarPasajero = new JButton( "Buscar pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        // Botón porcentaje de ocupación
        bPorcOcupacion = new JButton( "Porcentaje ocupación" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        // Botón peso total del avión
        bPesoTotalEquipajesAvion = new JButton( "Peso total del avión" );
        bPesoTotalEquipajesAvion.setActionCommand( PESO_TOTA_AVION_EQUIPAJE );
        bPesoTotalEquipajesAvion.addActionListener( this );
        add( bPesoTotalEquipajesAvion );

        // vacío al final
        add( new JLabel( ) );

        // Línea pasajero
        add( new JLabel( "Opciones del pasajero:" ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        // Botón agregar equipaje
        bAgregarEquipaje = new JButton( "Agregar equipaje" );
        bAgregarEquipaje.setActionCommand( AGREGAR_EQUIPAJE );
        bAgregarEquipaje.addActionListener( this );
        add( bAgregarEquipaje );

        // Botón buscar equipajes
        bBuscarEquipajes = new JButton( "Buscar equipajes" );
        bBuscarEquipajes.setActionCommand( BUSCAR_EQUIPAJES );
        bBuscarEquipajes.addActionListener( this );
        add( bBuscarEquipajes );

        // Botón equipajes de categoría
        bPesoPorCategoriaEquipaje = new JButton( "Peso por categoría" );
        bPesoPorCategoriaEquipaje.setActionCommand( EQUIPAJES_CATEGORIA );
        bPesoPorCategoriaEquipaje.addActionListener( this );
        add( bPesoPorCategoriaEquipaje );

        // Botón equipaje más pesado
        bEquipajeMasPesado = new JButton( "Equipaje más pesado" );
        bEquipajeMasPesado.setActionCommand( EQUIPAJE_MAS_PESADO );
        bEquipajeMasPesado.addActionListener( this );
        add( bEquipajeMasPesado );

        // Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opción 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opción 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ASIGNAR ) )
        {
            principal.registrarPasajero( );
        }
        else if( comando.equals( ANULAR ) )
        {
            principal.desasignarSilla( );
        }
        else if( comando.equals( BUSCAR ) )
        {
            principal.buscarSillaPasajero( );
        }
        else if( comando.equals( PORCENTAJE ) )
        {
            principal.mostrarPorcentajeOcupacion( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if( comando.equals( AGREGAR_EQUIPAJE ) )
        {
            principal.mostrarDialogoAgregarEquipaje( );
        }
        else if( comando.equals( BUSCAR_EQUIPAJES ) )
        {
            principal.buscarEquipajes( );
        }
        else if( comando.equals( PESO_TOTA_AVION_EQUIPAJE ) )
        {
            principal.darPesoTotalEquipajes( );
        }
        else if( comando.equals( EQUIPAJES_CATEGORIA ) )
        {
            principal.mostrarDialogoCategoriaEquipaje( );
        }
        else if( comando.equals( EQUIPAJE_MAS_PESADO ) )
        {
            principal.darEquipajeMasPesado( );
        }
    }
}