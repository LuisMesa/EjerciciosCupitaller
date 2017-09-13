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
import javax.swing.border.*;

/**
 * Panel de botones de interacci�n con el programa del avi�n.
 */
public class PanelBotonesAvion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante para el bot�n de asignar silla a un pasajero.
     */
    public final static String ASIGNAR = "ASIGNAR_PASAJERO";

    /**
     * Constante para el bot�n de anular silla a un pasajero.
     */
    public final static String ANULAR = "ANULAR_PASAJERO";

    /**
     * Constante para el bot�n de buscar pasajero.
     */
    public final static String BUSCAR = "BUSCAR_PASAJERO";

    /**
     * Constante para el bot�n de porcentaje de ocupaci�n.
     */
    public final static String PORCENTAJE = "PORCENTAJE_OCUPACION";

    /**
     * Constante para el bot�n de opci�n 1.
     */
    private final static String OPCION_1 = "OPCION_1";

    /**
     * Constante para el bot�n de opci�n 2.
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
     * Constante para el peso total del avi�n.
     */
    public final static String PESO_TOTA_AVION_EQUIPAJE = "PESO_EQUIPAJE";

    /**
     * Constante para dar los equipajes de una categor�a.
     */
    public final static String EQUIPAJES_CATEGORIA = "EQUIPAJES_CATEGORIA";

    /**
     * Constante para dar el equipaje m�s pesado.
     */
    public final static String EQUIPAJE_MAS_PESADO = "EQUIPAJE_MAS_PESADO";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para asignar silla a un nuevo pasajero.
     */
    private JButton bAsignar;

    /**
     * Bot�n para anular silla a un nuevo pasajero..
     */
    private JButton bAnular;

    /**
     * Bot�n para b�squeda de un pasajero.
     */
    private JButton bBuscarPasajero;

    /**
     * Bot�n para calcular porcentaje de ocupaci�n.
     */
    private JButton bPorcOcupacion;

    /**
     * Bot�n para agregar equipajes.
     */
    private JButton bAgregarEquipaje;

    /**
     * Bot�n para buscar equipajes.
     */
    private JButton bBuscarEquipajes;

    /**
     * Bot�n para dar el peso total del avi�n.
     */
    private JButton bPesoTotalEquipajesAvion;

    /**
     * Bot�n para dar los equipajes de un g�nero.
     */
    private JButton bPesoPorCategoriaEquipaje;

    /**
     * Bot�n para dar el equipaje m�s pesado.
     */
    private JButton bEquipajeMasPesado;

    /**
     * Bot�n para extensi�n 1.
     */
    private JButton botonOpcion1;

    /**
     * Bot�n para extensi�n 2.
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

        // L�nea avi�n
        add( new JLabel( "Opciones del avi�n:" ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        // Bot�n asignar
        bAsignar = new JButton( "Asignar silla" );
        bAsignar.setActionCommand( ASIGNAR );
        bAsignar.addActionListener( this );
        bAsignar.setPreferredSize( new Dimension( 40, 10 ) );
        add( bAsignar );

        // Bot�n anular silla asignada
        bAnular = new JButton( "Desasignar pasajero" );
        bAnular.setActionCommand( ANULAR );
        bAnular.addActionListener( this );
        add( bAnular );

        // Bot�n buscar pasajero
        bBuscarPasajero = new JButton( "Buscar pasajero" );
        bBuscarPasajero.setActionCommand( BUSCAR );
        bBuscarPasajero.addActionListener( this );
        add( bBuscarPasajero );

        // Bot�n porcentaje de ocupaci�n
        bPorcOcupacion = new JButton( "Porcentaje ocupaci�n" );
        bPorcOcupacion.setActionCommand( PORCENTAJE );
        bPorcOcupacion.addActionListener( this );
        add( bPorcOcupacion );

        // Bot�n peso total del avi�n
        bPesoTotalEquipajesAvion = new JButton( "Peso total del avi�n" );
        bPesoTotalEquipajesAvion.setActionCommand( PESO_TOTA_AVION_EQUIPAJE );
        bPesoTotalEquipajesAvion.addActionListener( this );
        add( bPesoTotalEquipajesAvion );

        // vac�o al final
        add( new JLabel( ) );

        // L�nea pasajero
        add( new JLabel( "Opciones del pasajero:" ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        // Bot�n agregar equipaje
        bAgregarEquipaje = new JButton( "Agregar equipaje" );
        bAgregarEquipaje.setActionCommand( AGREGAR_EQUIPAJE );
        bAgregarEquipaje.addActionListener( this );
        add( bAgregarEquipaje );

        // Bot�n buscar equipajes
        bBuscarEquipajes = new JButton( "Buscar equipajes" );
        bBuscarEquipajes.setActionCommand( BUSCAR_EQUIPAJES );
        bBuscarEquipajes.addActionListener( this );
        add( bBuscarEquipajes );

        // Bot�n equipajes de categor�a
        bPesoPorCategoriaEquipaje = new JButton( "Peso por categor�a" );
        bPesoPorCategoriaEquipaje.setActionCommand( EQUIPAJES_CATEGORIA );
        bPesoPorCategoriaEquipaje.addActionListener( this );
        add( bPesoPorCategoriaEquipaje );

        // Bot�n equipaje m�s pesado
        bEquipajeMasPesado = new JButton( "Equipaje m�s pesado" );
        bEquipajeMasPesado.setActionCommand( EQUIPAJE_MAS_PESADO );
        bEquipajeMasPesado.addActionListener( this );
        add( bEquipajeMasPesado );

        // Botones de opciones adicionales
        botonOpcion1 = new JButton( "Opci�n 1" );
        botonOpcion1.setActionCommand( OPCION_1 );
        botonOpcion1.addActionListener( this );
        add( botonOpcion1 );
        botonOpcion2 = new JButton( "Opci�n 2" );
        botonOpcion2.setActionCommand( OPCION_2 );
        botonOpcion2.addActionListener( this );
        add( botonOpcion2 );
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