/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: n2_empresa
 * Autor: EquipoCupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package uniandes.cupi2.empresa.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de la aplicaci�n.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    //-----------------------------------------------------------------
    // Constantes
    //-----------------------------------------------------------------

    /**
     * Constante para el extensi�n 1.
     */
    private final static String OPCION_1 = "opcion1";

    /**
     * Constante para la extensi�n 2.
     */
    private final static String OPCION_2 = "opcion2";
    
    /**
     * Constante para buscar un empleado.
     */
    private final static String BUSCAR = "buscar";
    
    /**
     * Constante para calcular el promedio de edad.
     */
    private final static String PROMEDIO = "promedio";
    
    /**
     * Constante para calcular las prestaciones.
     */
    private final static String PRESTACIONES = "prestaciones";
    
    /**
     * Constante para la cota m�nima.
     */
    private final static String COTA = "cota";

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------

    /**
     * Ventana  principal de la aplicaci�n.
     */
    private InterfazEmpresa principal;

    //-----------------------------------------------------------------
    // Atributos de la Interfaz
    //-----------------------------------------------------------------

    /**
     * Bot�n para buscar un empleado.
     */
    private JButton btnBuscar;
    
    /**
     * Bot�n para calcular el promedio de edad.
     */
    private JButton btnPromedio;
    
    /**
     * Bot�n para calcular las prestaciones.
     */
    private JButton btnPrestaciones;
    
    /**
     * Bot�n para verificar si los salarios superan la cota m�nima.
     */
    private JButton btnCota;
    
    /**
     * Bot�n de la extensi�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n de la extensi�n 2.
     */
    private JButton btnOpcion2;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Construye el panel de extensiones. <br>
     * <b>post: </b> Construy� el panel. <br>
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelOpciones( InterfazEmpresa pPrincipal )
    {
        principal = pPrincipal;

        setBorder(  new TitledBorder( "Opciones" ) );

        setLayout( new GridLayout( 2, 3, 10, 10 ) );
        
        btnBuscar = new JButton( "Buscar empleado" );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        
        btnPrestaciones = new JButton( "Calcular prestaciones" );
        btnPrestaciones.setActionCommand( PRESTACIONES );
        btnPrestaciones.addActionListener( this );
        
        btnPromedio = new JButton( "Edad promedio" );
        btnPromedio.setActionCommand( PROMEDIO );
        btnPromedio.addActionListener( this );
        
        btnCota = new JButton( "Cota m�nima" );
        btnCota.setActionCommand( COTA );
        btnCota.addActionListener( this );
        
        btnOpcion1 = new JButton( "Opci�n 1" );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );

        btnOpcion2 = new JButton( "Opci�n 2" );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );

        add( btnBuscar );
        add( btnPrestaciones );
        add( btnPromedio );
        add( btnCota );
        add( btnOpcion1 );
        add( btnOpcion2 );
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Evento de click sobre un bot�n. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( OPCION_1.equals( comando ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( OPCION_2.equals( comando ) )
        {
            principal.reqFuncOpcion2( );
        }
        else if ( BUSCAR.equals( comando ))
        {
            principal.buscarEmpleado();
        }
        else if ( PROMEDIO.equals( comando ))
        {
            principal.calcularPromedioEdad();
        }
        else if( PRESTACIONES.equals( comando ))
        {
            principal.calcularPrestacionesEmpleado();
        }
        else if( COTA.equals( comando ))
        {
            principal.verificarCotaMinima();
        }
    }

}
