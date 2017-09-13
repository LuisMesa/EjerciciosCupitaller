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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.avion.mundo.Equipaje;

/**
 * Dialogo para seleccionar una categor�a de equipaje para la b�squeda.
 */
public class DialogoEquipajeCategoria extends JDialog implements ActionListener
{
    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Comando para la acci�n de aceptar.
     */
    private final static String ACEPTAR = "ACEPTAR";

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazAvion principal;

    /**
     * Etiqueta de la c�dula pasajero.
     */
    private JLabel labelCedulaPasajero;

    /**
     * Etiqueta de la categor�a del equipaje.
     */
    private JLabel labelCategoria;

    /**
     * Texto con la c�dula pasajero.
     */
    private JTextField textoCedulaPasajero;

    /**
     * Combo de las categor�as.
     */
    private JComboBox comboCategoria;

    /**
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    // -----------------------------------------------
    // M�todos
    // -----------------------------------------------

    /**
     * CConstruye el di�logo e inicializa los elementos de la interfaz.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal !=null.
     */
    public DialogoEquipajeCategoria( InterfazAvion pPrincipal )
    {

        super( pPrincipal, true );

        principal = pPrincipal;

        setLayout( new BorderLayout( 10, 10 ) );
        setSize( 300, 170 );

        JPanel panelCentral = new JPanel( );
        JPanel panelSur = new JPanel( );

        panelCentral.setBorder( new TitledBorder( "Informaci�n pel�cula" ) );

        panelCentral.setLayout( new GridLayout( 2, 2, 5, 5 ) );

        labelCedulaPasajero = new JLabel( "C�dula pasajero:" );
        panelCentral.add( labelCedulaPasajero );

        textoCedulaPasajero = new JTextField( );
        panelCentral.add( textoCedulaPasajero );

        labelCategoria = new JLabel( "G�nero:" );
        panelCentral.add( labelCategoria );

        comboCategoria = new JComboBox( );
        comboCategoria.addItem( Equipaje.EQUIPAJE_DE_MANO );
        comboCategoria.addItem( Equipaje.EQUIPAJE_MUSICAL );
        comboCategoria.addItem( Equipaje.EQUIPAJE_DEPORTIVO );
        comboCategoria.addItem( Equipaje.EQUIPAJE_ESPECIAL );
        panelCentral.add( comboCategoria );

        add( panelCentral, BorderLayout.CENTER );

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        panelSur.add( botonAceptar );

        add( panelSur, BorderLayout.SOUTH );

        setLocationRelativeTo( principal );

    }

    /**
     * M�todo que se ejecuta cuando se hace click en el bot�n ACEPTAR.<br>
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ACEPTAR ) )
        {

            try
            {
                int cedula = Integer.parseInt( textoCedulaPasajero.getText( ) );
                String genero = ( String )comboCategoria.getSelectedItem( );
                principal.categoriaEquipajes( cedula, genero );

            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Error en el formato de la c�dula." );
            }
            dispose( );

        }

    }
}
