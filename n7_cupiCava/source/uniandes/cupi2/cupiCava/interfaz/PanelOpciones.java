/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones de ordenamiento y búsqueda.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando de ordenar.
     */
    private final static String ORDENAR = "Ordenar";

    /**
     * Constante que representa el comando de buscar.
     */
    private final static String BUSCAR = "Buscar";

    /**
     * Constante que representa la opción de ordenamiento por nombre.
     */
    private final static String ORDENAR_NOMBRE = "Nombre";

    /**
     * Constante que representa la opción de ordenamiento por año de elaboración.
     */
    private final static String ORDENAR_ANHO = "Año de elaboración";

    /**
     * Constante que representa la opción de ordenamiento por lugar de origen.
     */
    private final static String ORDENAR_ORIGEN = "Lugar de origen";

    /**
     * Constante que representa la opción de búsqueda por nombre.
     */
    private final static String BUSCAR_NOMBRE = "Nombre";

    /**
     * Constante que representa la opción de búsqueda por tipo.
     */
    private final static String BUSCAR_TIPO = "Tipo";

    /**
     * Constante que representa la opción de búsqueda del vino más dulce.
     */
    private final static String BUSCAR_MAS_DULCE = "Más dulce";

    /**
     * Constante que representa la opción de búsqueda del vino más seco.
     */
    private final static String BUSCAR_MAS_SECO = "Más seco";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiCava principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Combo box con las opciones de ordenamiento.
     */
    private JComboBox comboOrdenamiento;

    /**
     * Combo box con las opciones de búsqueda.
     */
    private JComboBox comboBusqueda;

    /**
     * Botón para ordenar.
     */
    private JButton btnOrdenar;

    /**
     * Botón para buscar.
     */
    private JButton btnBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelOpciones( InterfazCupiCava pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new GridLayout( 1, 2 ) );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridLayout( 1, 2 ) );
        aux.setBorder( new CompoundBorder( new EmptyBorder( 0, 10, 0, 10 ), new TitledBorder( "Ordenar" ) ) );

        comboOrdenamiento = new JComboBox( );
        comboOrdenamiento.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        comboOrdenamiento.addItem( ORDENAR_NOMBRE );
        comboOrdenamiento.addItem( ORDENAR_ANHO );
        comboOrdenamiento.addItem( ORDENAR_ORIGEN );
        aux.add( comboOrdenamiento );

        btnOrdenar = new JButton( ORDENAR );
        btnOrdenar.setActionCommand( ORDENAR );
        btnOrdenar.addActionListener( this );
        aux.add( btnOrdenar );

        add( aux );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 1, 2 ) );
        aux2.setBorder( new CompoundBorder( new EmptyBorder( 0, 10, 0, 10 ), new TitledBorder( "Buscar" ) ) );

        comboBusqueda = new JComboBox( );
        comboBusqueda.setBorder( new EmptyBorder( 0, 0, 0, 10 ) );
        comboBusqueda.addItem( BUSCAR_NOMBRE );
        comboBusqueda.addItem( BUSCAR_TIPO );
        comboBusqueda.addItem( BUSCAR_MAS_DULCE );
        comboBusqueda.addItem( BUSCAR_MAS_SECO );
        aux2.add( comboBusqueda );

        btnBuscar = new JButton( BUSCAR );
        btnBuscar.setActionCommand( BUSCAR );
        btnBuscar.addActionListener( this );
        aux2.add( btnBuscar );

        add( aux2 );
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( ORDENAR ) )
        {
            String ordenamiento = ( String )comboOrdenamiento.getSelectedItem( );
            if( ordenamiento.equals( ORDENAR_NOMBRE ) )
            {
                principal.ordenarPorNombre( );
            }
            else if( ordenamiento.equals( ORDENAR_ANHO ) )
            {
                principal.ordenarPorAnhoElaboracion( );
            }
            else if( ordenamiento.equals( ORDENAR_ORIGEN ) )
            {
                principal.ordenarPorLugarOrigen( );
            }
        }
        else if( comando.equals( BUSCAR ) )
        {
            String busqueda = ( String )comboBusqueda.getSelectedItem( );
            if( busqueda.equals( BUSCAR_NOMBRE ) )
            {
                principal.buscarPorNombre( );
            }
            else if( busqueda.equals( BUSCAR_TIPO ) )
            {
                principal.buscarPorTipo( );
            }
            else if( busqueda.equals( BUSCAR_MAS_DULCE ) )
            {
                principal.buscarVinoMasDulce( );
            }
            else if( busqueda.equals( BUSCAR_MAS_SECO ) )
            {
                principal.buscarVinoMasSeco( );
            }
        }
    }
}