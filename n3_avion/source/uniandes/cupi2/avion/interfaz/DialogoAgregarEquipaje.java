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
 * Dialogo para agregar un equipaje.
 */
public class DialogoAgregarEquipaje extends JDialog implements ActionListener
{

    // -----------------------------------------------
    // Atributos
    // -----------------------------------------------

    /**
     * Comando para la acci�n de aceptar.
     */
    private final static String ACEPTAR = "ACEPTAR";

    /**
     * Comando para la acci�n de cancelar.
     */
    private final static String CANCELAR = "CANCELAR";

    /**
     * Ventana principal de la aplicaci�n.
     */
    private InterfazAvion principal;

    /**
     * Etiqueta de la c�dula del pasajero.
     */
    private JLabel labelCedulaPasajero;

    /**
     * Etiqueta del ancho del equipaje.
     */
    private JLabel labelAncho;

    /**
     * Etiqueta del largo del equipaje.
     */
    private JLabel labelLargo;

    /**
     * Etiqueta del alto del equipaje.
     */
    private JLabel labelAlto;

    /**
     * Etiqueta de la categor�a del equipaje.
     */
    private JLabel labelCategoria;

    /**
     * Etiqueta del peso del equipaje.
     */
    private JLabel labelPeso;

    /**
     * Etiqueta de la ciudad destino del equipaje.
     */
    private JLabel labelCiudaDestino;

    /**
     * Texto con la c�dula del pasajero.
     */
    private JTextField textoCedulaPasajero;

    /**
     * Texto con el ancho del equipaje.
     */
    private JTextField textoAncho;

    /**
     * Texto con el largo del equipaje.
     */
    private JTextField textoLargo;

    /**
     * Texto con el alto del equipaje.
     */
    private JTextField textoAlto;

    /**
     * Combo con la categor�a del equipaje.
     */
    private JComboBox comboCategoria;

    /**
     * Texto con el peso del equipaje.
     */
    private JTextField textoPeso;

    /**
     * Texto con la ciudad de destino del equipaje.
     */
    private JTextField textoCiudadDestino;

    /**
     * Bot�n aceptar.
     */
    private JButton botonAceptar;

    /**
     * Bot�n cancelar.
     */
    private JButton botonCancelar;

    // -----------------------------------------------
    // M�todos
    // -----------------------------------------------

    /**
     * Construye el di�logo e inicializa los elementos de la interfaz.
     * @param pPrincipal Ventana principal de la aplicaci�n. pPrincipal !=null.
     */
    public DialogoAgregarEquipaje( InterfazAvion pPrincipal )
    {

        super( pPrincipal, true );

        principal = pPrincipal;

        setLayout( new BorderLayout( 10, 10 ) );
        setTitle( "Agregar equipaje" );
        JPanel panelNorte = new JPanel( );
        JPanel panelCentral = new JPanel( );
        JPanel panelSur = new JPanel( );

        panelNorte.setLayout( new GridLayout( 1, 2 ) );
        labelCedulaPasajero = new JLabel( "C�dula pasajero:" );
        panelNorte.add( labelCedulaPasajero );
        textoCedulaPasajero = new JTextField( );
        panelNorte.add( textoCedulaPasajero );
        add( panelNorte, BorderLayout.NORTH );

        panelCentral.setBorder( new TitledBorder( "Informaci�n equipaje" ) );
        panelCentral.setLayout( new GridLayout( 6, 2, 5, 5 ) );

        labelAncho = new JLabel( "Ancho:" );
        panelCentral.add( labelAncho );

        textoAncho = new JTextField( );
        panelCentral.add( textoAncho );

        labelLargo = new JLabel( "Largo:" );
        panelCentral.add( labelLargo );

        textoLargo = new JTextField( );
        panelCentral.add( textoLargo );

        labelAlto = new JLabel( "Alto:" );
        panelCentral.add( labelAlto );

        textoAlto = new JTextField( );
        panelCentral.add( textoAlto );

        labelCategoria = new JLabel( "Categor�a:" );
        panelCentral.add( labelCategoria );

        comboCategoria = new JComboBox( );
        comboCategoria.addItem( Equipaje.EQUIPAJE_DE_MANO );
        comboCategoria.addItem( Equipaje.EQUIPAJE_MUSICAL );
        comboCategoria.addItem( Equipaje.EQUIPAJE_DEPORTIVO );
        comboCategoria.addItem( Equipaje.EQUIPAJE_ESPECIAL );
        panelCentral.add( comboCategoria );

        labelPeso = new JLabel( "Peso (Kg):" );
        panelCentral.add( labelPeso );

        textoPeso = new JTextField( );
        panelCentral.add( textoPeso );

        labelCiudaDestino = new JLabel( "Ciudad destino:" );
        panelCentral.add( labelCiudaDestino );

        textoCiudadDestino = new JTextField( );
        panelCentral.add( textoCiudadDestino );

        add( panelCentral, BorderLayout.CENTER );

        botonAceptar = new JButton( "Aceptar" );
        botonAceptar.setActionCommand( ACEPTAR );
        botonAceptar.addActionListener( this );

        botonCancelar = new JButton( "Cancelar" );
        botonCancelar.setActionCommand( CANCELAR );
        botonCancelar.addActionListener( this );

        panelSur.add( botonAceptar );
        panelSur.add( botonCancelar );

        add( panelSur, BorderLayout.SOUTH );

        setSize( new Dimension( 230, 250 ) );
        setLocationRelativeTo( principal );
        pack( );

    }

    /**
     * M�todo que se ejecuta cuando se hace click en el bot�n ACEPTAR o CANCELAR<br>
     * @param pEvento Acci�n que gener� el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ACEPTAR ) )
        {

            try
            {
                int cedula = Integer.parseInt( textoCedulaPasajero.getText( ) );
                double peso = Double.parseDouble( textoPeso.getText( ) );
                double ancho = Double.parseDouble( textoAncho.getText( ) );
                double largo = Double.parseDouble( textoLargo.getText( ) );
                double alto = Double.parseDouble( textoAlto.getText( ) );
                String categoria = ( String )comboCategoria.getSelectedItem( );
                String ciudadDestino = textoCiudadDestino.getText( );

                if( !ciudadDestino.equals( "" ) )
                {

                    if( peso > 0 && ancho > 0 && largo > 0 && alto > 0 )
                    {
                        principal.agregarEquipaje( cedula, categoria, peso, ciudadDestino, ancho, largo, alto );
                        dispose( );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog( this, "El peso, el alto, el ancho y el largo del equipaje deben ser mayor a cero.", "Agregar equipaje", JOptionPane.ERROR_MESSAGE );
                    }

                }
                else
                    JOptionPane.showMessageDialog( this, "Debe ingresar la ciudad destino del equipaje.", "Agregar equipaje", JOptionPane.ERROR_MESSAGE );
            }
            catch( Exception e2 )
            {
                JOptionPane.showMessageDialog( this, "Error en el formato del peso, la c�dula o las dimensiones del equipaje.", "Agregar equipaje", JOptionPane.ERROR_MESSAGE );
            }

        }
        else if( pEvento.getActionCommand( ).equals( CANCELAR ) )
        {
            dispose( );
        }

    }

}
