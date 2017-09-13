/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: sistemaAntecedentes
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.sistemaAntecedentes.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.sistemaAntecedentes.mundo.Antecedente;

/**
 * Diálogo para buscar procesados por antecedente.
 */
public class DialogoBuscarPorAntecedente extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para aceptar.
     */
    private final static String ACEPTAR = "Aceptar";

    /**
     * Constante que representa el comando para cancelar.
     */
    private final static String CANCELAR = "Cancelar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazSistemaAntecedentes principal;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Combobox con los tipos de antecedentes.
     */
    private JComboBox cbbTiposAntecedentes;

    /**
     * Botón de aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón de cancelar.
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo para buscar un antecedente dado el tipo. <br>
     * <b>post: </b> Se construyó el panel e inicializó el atributo principal con el valor dado por parámetro. <br>
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoBuscarPorAntecedente( InterfazSistemaAntecedentes pPrincipal )
    {
        principal = pPrincipal;

        setTitle( "Buscar por antecedente" );
        setModal( true );
        setSize( 250, 100 );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new BorderLayout( ) );
        setLocationRelativeTo( principal );

        JPanel aux1 = new JPanel( );
        aux1.setLayout( new GridLayout( 2, 1 ) );

        JLabel label = new JLabel( "Seleccione un antecedente: " );
        aux1.add( label );

        cbbTiposAntecedentes = new JComboBox( );
        cbbTiposAntecedentes.addItem( Antecedente.HOMICIDIO );
        cbbTiposAntecedentes.addItem( Antecedente.VIOLENCIA );
        cbbTiposAntecedentes.addItem( Antecedente.ROBO );
        cbbTiposAntecedentes.addItem( Antecedente.ECOLOGICO );
        cbbTiposAntecedentes.addItem( Antecedente.TRANSITO );
        cbbTiposAntecedentes.addItem( Antecedente.SECUESTRO );
        cbbTiposAntecedentes.addItem( Antecedente.ALLANAMIENTO_DE_MORADA );
        cbbTiposAntecedentes.addItem( Antecedente.ESTAFA );
        cbbTiposAntecedentes.addItem( Antecedente.CONSUMO_DE_DROGAS );
        cbbTiposAntecedentes.addItem( Antecedente.TRAFICO_DE_DROGAS );
        aux1.add( cbbTiposAntecedentes );

        JPanel aux2 = new JPanel( );
        aux2.setLayout( new GridLayout( 1, 2 ) );

        btnAceptar = new JButton( ACEPTAR );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        aux2.add( btnAceptar );

        btnCancelar = new JButton( CANCELAR );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        aux2.add( btnCancelar );

        add( aux1, BorderLayout.CENTER );
        add( aux2, BorderLayout.SOUTH );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones. <br>
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        String comando = pEvento.getActionCommand( );

        if( comando.equals( ACEPTAR ) )
        {
            if( cbbTiposAntecedentes.getSelectedIndex( ) != -1 )
            {
                try
                {
                    String procesados = principal.buscarPorAntecedente( ( String )cbbTiposAntecedentes.getSelectedItem( ) );
                    JOptionPane.showMessageDialog(this, procesados);
                    dispose( );                    
                }
                catch( Exception e )
                {
                    JOptionPane.showMessageDialog( this, e.getMessage( ), "Buscar por antecedente", JOptionPane.INFORMATION_MESSAGE );
                    dispose( );
                }
            }
        }
        else if( comando.equals( CANCELAR ) )
        {
            dispose( );
        }
    }
}
