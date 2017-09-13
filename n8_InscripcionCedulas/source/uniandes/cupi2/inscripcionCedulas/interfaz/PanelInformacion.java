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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.inscripcionCedulas.mundo.Ciudadano;
import uniandes.cupi2.inscripcionCedulas.mundo.Departamento;
import uniandes.cupi2.inscripcionCedulas.mundo.Municipio;
import uniandes.cupi2.inscripcionCedulas.mundo.PuestoVotacion;

/**
 * Panel donde se muestra la información de departamentos, municipios, puestos de votación y ciudadanos inscritos.
 */
public class PanelInformacion extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para cambio de departamento.
     */
    private static final String CAMBIO_DEPARTAMENTO = "DEPARTAMENTO";

    /**
     * Constante que representa el comando para cambio de municipio.
     */
    private static final String CAMBIO_MUNICIPIO = "MUNICICPIO";

    /**
     * Constante que representa el comando para cambio de puesto de votación.
     */
    private static final String CAMBIO_PUESTO = "PUESTO";

    /**
     * Constante que representa el comando para ver la información del ciudadano.
     */
    private static final String VER_INFO = "Ver información";

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
     * ComboBox con los departamentos.
     */
    //TODO Parte6 PuntoA Declare el atributo comboDepartamentos.
    private JComboBox comboDepartamentos;

    /**
     * ComboBox con los municipios.
     */
    private JComboBox comboMunicipios;

    /**
     * ComboBox con los puestos de votación.
     */
    private JComboBox comboPuestos;

    /**
     * Lista de ciudadanos inscritos.
     */
    private JList listaInscritos;

    /**
     * Scroll de la lista de ciudadanos.
     */
    private JScrollPane scrollInscritos;

    /**
     * Campo de texto con el nombre del puesto de votación.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto con la dirección del puesto de votación.
     */
    private JTextField txtDireccion;

    /**
     * Botón para ver la información del ciudadano.
     */
    private JButton btnVerInfo;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public PanelInformacion( InterfazInscripcionCedulas pPrincipal )
    {
        principal = pPrincipal;

        setLayout( new BorderLayout( ) );

        JPanel aux = new JPanel( );
        aux.setLayout( new GridBagLayout( ) );
        setSize( 800, 200 );
        GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets( 5, 5, 5, 5 );
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        aux.add( new JLabel( " Departamentos " ), gridBagConstraints );
        gridBagConstraints.gridx = 1;
        //TODO Parte6 PuntoB Inicialice el atributo comboDepartamentos, utilice la constante CAMBIO_DEPARTAMENTO como comando asociado, configure su ActionListener y agréguelo al panel.
        comboDepartamentos = new JComboBox( );
        comboDepartamentos.setActionCommand( CAMBIO_DEPARTAMENTO );
        comboDepartamentos.addActionListener( this );
        aux.add( comboDepartamentos, gridBagConstraints );
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        aux.add( new JLabel( " Municipios " ), gridBagConstraints );
        gridBagConstraints.gridx = 1;
        comboMunicipios = new JComboBox( );
        comboMunicipios.setActionCommand( CAMBIO_MUNICIPIO );
        comboMunicipios.addActionListener( this );
        aux.add( comboMunicipios, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        aux.add( new JLabel( " Puesto de votación " ), gridBagConstraints );
        gridBagConstraints.gridx = 1;
        comboPuestos = new JComboBox( );
        comboPuestos.setActionCommand( CAMBIO_PUESTO );
        comboPuestos.addActionListener( this );
        aux.add( comboPuestos, gridBagConstraints );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridBagLayout( ) );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;

        aux2.setPreferredSize( new Dimension( 0, 120 ) );
        aux2.setBorder( new TitledBorder( "Puesto de votación" ) );

        aux2.add( new JLabel( " Nombre: " ), gridBagConstraints );
        gridBagConstraints.gridx = 1;
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        aux2.add( txtNombre, gridBagConstraints );

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        aux2.add( new JLabel( " Dirección " ), gridBagConstraints );
        gridBagConstraints.gridx = 1;
        txtDireccion = new JTextField( );
        txtDireccion.setEditable( false );
        aux2.add( txtDireccion, gridBagConstraints );

        JPanel aux3 = new JPanel( );
        aux3.setLayout( new BorderLayout( ) );
        aux3.add( aux, BorderLayout.CENTER );
        aux3.add( aux2, BorderLayout.SOUTH );

        add( aux3, BorderLayout.CENTER );

        JPanel aux4 = new JPanel( );
        aux4.setLayout( new BorderLayout( ) );

        listaInscritos = new JList( );

        scrollInscritos = new JScrollPane( listaInscritos );
        scrollInscritos.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        scrollInscritos.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scrollInscritos.setBorder( new TitledBorder( "Ciudadanos inscritos" ) );

        aux4.add( scrollInscritos, BorderLayout.CENTER );

        btnVerInfo = new JButton( VER_INFO );
        btnVerInfo.setActionCommand( VER_INFO );
        btnVerInfo.addActionListener( this );
        aux4.add( btnVerInfo, BorderLayout.SOUTH );

        add( aux4, BorderLayout.EAST );
        actualizarDepartamentos( );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el departamento seleccionado actualmente.
     * @return Departamento seleccionado.
     */
    public String darDepartamentoSeleccionado( )
    {
        String d = ( String )comboDepartamentos.getSelectedItem( );
        return d;
    }

    /**
     * Retorna el municipio seleccionado actualmente.
     * @return Municipio seleccionado.
     */
    public String darMunicipioSeleccionado( )
    {
        String m = ( String )comboMunicipios.getSelectedItem( );
        return m;
    }

    /**
     * Retorna el puesto de votación seleccionado actualmente.
     * @return Puesto de votación seleccionado.
     */
    public String darPuestoSeleccionado( )
    {
        String p = ( String )comboPuestos.getSelectedItem( );
        return p;
    }

    /**
     * Actualiza la información de departamentos.
     */
    public void actualizarDepartamentos( )
    {
        ArrayList departamentos = principal.darDepartamentos( );
        comboDepartamentos.removeAllItems( );
        for( int i = 0; i < departamentos.size( ); i++ )
        {
            Departamento d = ( Departamento )departamentos.get( i );
            comboDepartamentos.addItem( d.darNombre( ) );
        }
    }

    /**
     * Actualiza la información de municipios.
     * @param pDepartamento Departamento de los municipios. pDepartamento != null && pDepartamento != "".
     */
    public void actualizarMunicipios( String pDepartamento )
    {
        //TODO Parte6 PuntoC Complete el método según la documentación dada.
        //AYUDA: Agregue los municipios al comboBox correspondiente
    	ArrayList municipios = principal.darMunicipiosDepartamento(pDepartamento);
        comboMunicipios.removeAllItems( );
        //System.out.println("entro");
        for( int i = 0; i < municipios.size( ); i++ )
        {
            Municipio m = ( Municipio)municipios.get( i );
            //System.out.println(m.darNombre());
            comboMunicipios.addItem( m.darNombre( ) );
        }
    }

    /**
     * Actualiza la información de los puestos de votación.
     * @param pMunicipio Municipio de los puestos de votación. pMunicipio != null && pMunicipio != "".
     */
    public void actualizarPuestos( String pMunicipio )
    {
        ArrayList puestos = principal.darPuestosVotacionMunicipio( darDepartamentoSeleccionado( ), pMunicipio );
        comboPuestos.removeAllItems( );
        for( int i = 0; i < puestos.size( ); i++ )
        {
            PuestoVotacion p = ( PuestoVotacion )puestos.get( i );
            comboPuestos.addItem( p.darNombre( ) );
        }
    }

    /**
     * Actualiza la lista de ciudadanos inscritos.
     * @param pPuesto Puesto de votación de los ciudadanos. pPuesto != null && pPuesto != "".
     */
    public void actualizarListaInscritos( String pPuesto )
    {
        ArrayList inscritos = principal.darInscritosPuestoVotacion( darDepartamentoSeleccionado( ), darMunicipioSeleccionado( ), pPuesto );
        listaInscritos.setListData( inscritos.toArray( ) );
        if( !inscritos.isEmpty( ) )
        {
            listaInscritos.setSelectedIndex( 0 );
        }
    }

    /**
     * Actualiza la información del puesto de votación seleccionado.
     * @param pPuestoNombre Nombre del puesto de votación. pPuestoNombre != null && pPuestoNombre != "".
     * @param pPuestoDireccion Dirección del puesto de votación. pPuestoDireccion != null && pPuestoDireccion != "".
     */
    public void actualizarInfoPuesto( String pPuestoNombre, String pPuestoDireccion )
    {
        if( pPuestoNombre != null )
        {
            txtNombre.setText( pPuestoNombre );
            txtDireccion.setText( pPuestoDireccion );
        }
        else
        {
            txtNombre.setText( "" );
            txtDireccion.setText( "" );
        }
    }

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );
        if( comando.equals( CAMBIO_DEPARTAMENTO ) )
        {
            //TODO Parte6 PuntoD Complete el método para que cambie la información de los departamentos. Para esto, utilice el método actualizarMunicipios de la clase.
        	String d = ( String )comboDepartamentos.getSelectedItem( );
            if( d != null )
                actualizarMunicipios( d );
        }
        else if( comando.equals( CAMBIO_MUNICIPIO ) )
        {
            String m = ( String )comboMunicipios.getSelectedItem( );
            if( m != null )
                actualizarPuestos( m );
        }
        else if( comando.equals( CAMBIO_PUESTO ) )
        {
            String p = ( String )comboPuestos.getSelectedItem( );
            if( p != null )
            {
                actualizarListaInscritos( p );
            }
            try
            {
                PuestoVotacion puesto = principal.buscarPuestoVotacionMunicipio( darDepartamentoSeleccionado( ), darMunicipioSeleccionado( ), p );
                actualizarInfoPuesto( puesto.darNombre( ), puesto.darDireccion( ) );
            }
            catch( Exception e )
            {

            }

        }
        else if( comando.equals( VER_INFO ) )
        {
            Ciudadano c = ( Ciudadano )listaInscritos.getSelectedValue( );

            if( c != null )
            {
                DialogoInformacionCiudadano dialogo = new DialogoInformacionCiudadano( c.darCedula( ), c.darApellidos( ), c.darNombres( ), c.darFechaNacimiento( ), c.darLugarNacimiento( ), c.darSexo( ), c.darFechaExpedicion( ),
                        c.darLugarExpedicion( ) );
                dialogo.setVisible( true );
            }
        }
    }
}
