/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inscripcionCedulas.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de opciones del usuario.
 */
public class PanelOpciones extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para inscribir a un ciudadano.
     */
    private static final String INSCRIBIR = "Inscribir";

    /**
     * Constante que representa el comando para generar estadísticas.
     */
    private static final String ESTADISTICAS = "Estadísticas";

    /**
     * Constante que representa el comando para importar información.
     */
    private static final String IMPORTAR = "Importar información";

    /**
     * Constante que representa el comando para generar reporte.
     */
    private static final String REPORTE = "Generar reporte";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazInscripcionCedulas principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón para inscribir a un ciudadano.
     */
    private JButton btnInscribir;

    /**
     * Botón para generar estadísticas.
     */
    private JButton btnEstadisticas;

    /**
     * Botón para importar información.
     */
    private JButton btnImportar;

    /**
     * Botón para generar reporte.
     */
    private JButton btnReporte;
    
    /**
     * Estado de carga. True si está cargado, falso de lo contrario.
     */
    private boolean sistemaCargado;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.<br>
     * @param pPrincipal Ventana principal. pPrincipal != null.
     */
    public PanelOpciones( InterfazInscripcionCedulas pPrincipal )
    {
        principal = pPrincipal;
        if( principal.darDepartamentos( ).size( ) == 0 )
        {
            sistemaCargado = false;
        }
        else
        {
            sistemaCargado = true;
        }
        setBorder( new TitledBorder( "" ) );
        setLayout( new GridLayout( 4, 1 ) );

        // Botón Inscribir Ciudadano
        btnInscribir = new JButton( );
        btnInscribir.setActionCommand( INSCRIBIR );
        btnInscribir.addActionListener( this );
        btnInscribir.setIcon( new ImageIcon( "./data/imagenes/inscribir.png" ) );
        btnInscribir.setToolTipText( "Inscribir ciudadano" );
       
        if(!sistemaCargado){
            btnInscribir.setEnabled( false );
        }
        add( btnInscribir );

        // Botón Generar Estadísticas
        btnEstadisticas = new JButton( );
        btnEstadisticas.setActionCommand( ESTADISTICAS );
        btnEstadisticas.addActionListener( this );
        btnEstadisticas.setIcon( new ImageIcon( "./data/imagenes/estadisticas.png" ) );
        btnEstadisticas.setToolTipText( "Gráficos estadísticos" );
        if(!sistemaCargado){
            btnEstadisticas.setEnabled( false );
        }
        add( btnEstadisticas );

        // Botón Generar Reporte
        btnReporte = new JButton( );
        btnReporte.setActionCommand( REPORTE );
        btnReporte.addActionListener( this );
        btnReporte.setIcon( new ImageIcon( "./data/imagenes/reporte.png" ) );
        btnReporte.setToolTipText( "Generar reporte" );
        if(!sistemaCargado){
            btnReporte.setEnabled( false );
        }
        add( btnReporte );

        // Botón Importar Datos
        btnImportar = new JButton( );
        btnImportar.setActionCommand( IMPORTAR );
        btnImportar.addActionListener( this );
        btnImportar.setIcon( new ImageIcon( "./data/imagenes/importar.png" ) );
        btnImportar.setToolTipText( "Importar datos" );
        add( btnImportar );
        
        
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones. <br>
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( INSCRIBIR ) )
        {
            principal.inscribirCiudadano( );
        }
        else if( comando.equals( ESTADISTICAS ) )
        {
            DialogoEstadisticas dialogo = new DialogoEstadisticas( principal );
            dialogo.setVisible( true );
        }
        else if( comando.equals( REPORTE ) )
        {
            principal.generarReporte( );
        }
        else if( comando.equals( IMPORTAR ) )
        {
            principal.importar( );
            if( principal.darDepartamentos( ).size( ) != 0 )
            {
                btnInscribir.setEnabled( true );
                btnEstadisticas.setEnabled( true );
                btnReporte.setEnabled( true );
            }
            else
            {
                btnInscribir.setEnabled( false );
                btnEstadisticas.setEnabled( false );
                btnReporte.setEnabled( false );
            }
           
        }
    }
}
