/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de acciones.
 */
public class PanelAcciones extends JPanel implements ActionListener
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando buscar por antecedente.
     */
    private final static String BUSCAR_POR_ANTECEDENTE = "Buscar por antecedentes";

    /**
     * Constante que representa el comando buscar procesado con m�s antecedentes.
     */
    private final static String MAS_ANTECEDENTES = "M�s antecedentes";

    /**
     * Constante que representa el comando buscar procesado con menos antecedentes.
     */
    private final static String MENOS_ANTECEDENTES = "Menos antecedentes";

    /**
     * Constante que representa el comando buscar procesado mayor de edad con m�s a�os de condena.
     */
    private final static String MAS_ANHOS_CONDENA = "M�s a�os de condena";

    /**
     * Constante que representa el comando buscar procesado menor de edad con menos a�os de condena.
     */
    private final static String MENOS_ANHOS_CONDENA = "Menos a�os de condena";

    /**
     * Constante que representa el comando para la opci�n 1.
     */
    private static final String OPCION_1 = "Opci�n 1";

    /**
     * Constante que representa el comando para la opci�n 2.
     */
    private static final String OPCION_2 = "Opci�n 2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazSistemaAntecedentes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Bot�n para buscar procesado por antecedente.
     */
    private JButton btnBuscarPorAntecedente;

    /**
     * Bot�n para buscar el procesado con el mayor n�mero de antecedentes.
     */
    private JButton btnMasAntecedentes;

    /**
     * Bot�n para buscar el procesado con el menor n�mero de antecedentes.
     */
    private JButton btnMenosAntecedentes;

    /**
     * Bot�n para buscar el procesado con la mayor cantidad de a�os de condena.
     */
    private JButton btnMasAnhosCondena;

    /**
     * Bot�n para buscar el procesado en la menor cantidad de a�os de condena.
     */
    private JButton btnMenosAnhosCondena;

    /**
     * Bot�n para la opci�n 1.
     */
    private JButton btnOpcion1;

    /**
     * Bot�n para la opci�n 2.
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel con las acciones del programa.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal != null.
     */
    public PanelAcciones( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        TitledBorder border = BorderFactory.createTitledBorder( "Acciones" );
        border.setTitleColor( Color.BLUE );
        setBorder( border );

        setLayout( new GridLayout( 3, 1 ) );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new GridLayout( 1, 5 ) );

        btnBuscarPorAntecedente = new JButton( BUSCAR_POR_ANTECEDENTE );
        btnBuscarPorAntecedente.setActionCommand( BUSCAR_POR_ANTECEDENTE );
        btnBuscarPorAntecedente.addActionListener( this );
        aux1.add( btnBuscarPorAntecedente );

        btnMasAntecedentes = new JButton( MAS_ANTECEDENTES );
        btnMasAntecedentes.setActionCommand( MAS_ANTECEDENTES );
        btnMasAntecedentes.addActionListener( this );
        aux1.add( btnMasAntecedentes );

        btnMenosAntecedentes = new JButton( MENOS_ANTECEDENTES );
        btnMenosAntecedentes.setActionCommand( MENOS_ANTECEDENTES );
        btnMenosAntecedentes.addActionListener( this );
        aux1.add( btnMenosAntecedentes );

        add( aux1 );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 1, 2 ) );

        btnMasAnhosCondena = new JButton( MAS_ANHOS_CONDENA );
        btnMasAnhosCondena.setActionCommand( MAS_ANHOS_CONDENA );
        btnMasAnhosCondena.addActionListener( this );
        aux2.add( btnMasAnhosCondena );

        btnMenosAnhosCondena = new JButton( MENOS_ANHOS_CONDENA );
        btnMenosAnhosCondena.setActionCommand( MENOS_ANHOS_CONDENA );
        btnMenosAnhosCondena.addActionListener( this );
        aux2.add( btnMenosAnhosCondena );

        add( aux2 );

        JPanel aux3 = new JPanel( );
        aux3.setLayout( new GridLayout( 1, 2 ) );

        // Bot�n opci�n 1
        btnOpcion1 = new JButton( OPCION_1 );
        btnOpcion1.setActionCommand( OPCION_1 );
        btnOpcion1.addActionListener( this );
        aux3.add( btnOpcion1 );

        // Bot�n opci�n 2
        btnOpcion2 = new JButton( OPCION_2 );
        btnOpcion2.setActionCommand( OPCION_2 );
        btnOpcion2.addActionListener( this );
        aux3.add( btnOpcion2 );

        add( aux3 );
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( BUSCAR_POR_ANTECEDENTE ) )
        {
            principal.abrirDialogoBuscarPorAntecedente( );
        }
        else if( comando.equals( MAS_ANTECEDENTES ) )
        {
            principal.buscarProcesadoMasAntecedentes( );
        }
        else if( comando.equals( MENOS_ANTECEDENTES ) )
        {
            principal.buscarProcesadoMenosAntecedentes( );
        }
        else if( comando.equals( MAS_ANHOS_CONDENA ) )
        {
            principal.buscarProcesadoConMasAnhosCondena( );
        }
        else if( comando.equals( MENOS_ANHOS_CONDENA ) )
        {
            principal.buscarProcesadoConMenosAnhosCondena( );
        }
        else if( comando.equals( OPCION_1 ) )
        {
            principal.reqFuncOpcion1( );
        }
        else if( comando.equals( OPCION_2 ) )
        {
            principal.reqFuncOpcion2( );
        }
    }
}
