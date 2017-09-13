/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n3_cupiZoologico
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */

package uniandes.cupi2.cupiZoologico.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiZoologico.mundo.Animal;

/**
 * Dialogo de creación de un animal.
 */
public class DialogoAgregarAnimal extends JDialog implements ActionListener
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el comando para aceptar.
     */
    public static final String ACEPTAR = "Aceptar";

    /**
     * Constante que representa el comando para cancelar.
     */
    public static final String CANCELAR = "Cancelar";

    /**
     * Constante que representa el comando para eliminar.
     */
    public static final String EXAMINAR = "Examinar";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación.
     */
    private InterfazCupiZoologico principal;

    // -----------------------------------------------------------------
    // Atributos de Interfaz
    // -----------------------------------------------------------------

    /**
     * Panel de ingreso de la información.
     */
    public JPanel panelIngreso;

    /**
     * Panel de ingreso de la imagen.
     */
    public JPanel panelImagen;

    /**
     * Campo de texto del nombre.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto de la especie.
     */
    private JTextField txtEspecie;

    /**
     * Campo de texto de la imagen.
     */
    private JTextField txtImagen;

    /**
     * Combobox con las opciones de tipo.
     */
    private JComboBox txtTipo;

    /**
     * Combobox con las opciones de hábitat.
     */
    private JComboBox txtHabitat;

    /**
     * Botón para aceptar.
     */
    private JButton btnAceptar;

    /**
     * Botón para cancelar.
     */
    private JButton btnCancelar;

    /**
     * Botón para examinar.
     */
    private JButton btnExaminar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del diálogo.
     * @param pPrincipal Ventana principal de la aplicación. pPrincipal != null.
     */
    public DialogoAgregarAnimal( InterfazCupiZoologico pPrincipal )
    {
        super( pPrincipal, "Agregar animal" );
        principal = pPrincipal;

        panelIngreso = new JPanel( );
        panelIngreso.setBorder( new TitledBorder( "Ingreso datos" ) );
        panelIngreso.setLayout( new GridLayout( 7, 2 ) );

        panelIngreso.add( new JLabel( "Nombre:" ) );
        txtNombre = new JTextField( );
        panelIngreso.add( txtNombre );

        panelIngreso.add( new JLabel( "Especie:" ) );
        txtEspecie = new JTextField( );
        panelIngreso.add( txtEspecie );

        panelIngreso.add( new JLabel( "Tipo:" ) );
        String[] lista = { Animal.HERBIVORO, Animal.CARNIVORO };
        txtTipo = new JComboBox( lista );
        panelIngreso.add( txtTipo );

        panelIngreso.add( new JLabel( "Hábitat:" ) );
        String[] lista2 = { Animal.ACUATICO, Animal.TERRESTRE };
        txtHabitat = new JComboBox( lista2 );
        panelIngreso.add( txtHabitat );

        panelIngreso.add( new JLabel( "Imagen:" ) );
        panelImagen = new JPanel( );
        panelImagen.setLayout( new GridLayout( ) );

        txtImagen = new JTextField( "" );
        txtImagen.setEditable( false );
        panelImagen.add( txtImagen );
        btnExaminar = new JButton( "Examinar" );
        btnExaminar.setActionCommand( EXAMINAR );
        btnExaminar.addActionListener( this );
        panelImagen.add( btnExaminar );
        panelIngreso.add( panelImagen );

        panelIngreso.add( new JLabel( "" ) );
        panelIngreso.add( new JLabel( "" ) );

        btnAceptar = new JButton( "Aceptar" );
        btnAceptar.setActionCommand( ACEPTAR );
        btnAceptar.addActionListener( this );
        panelIngreso.add( btnAceptar );

        btnCancelar = new JButton( "Cancelar" );
        btnCancelar.setActionCommand( CANCELAR );
        btnCancelar.addActionListener( this );
        panelIngreso.add( btnCancelar );

        add( panelIngreso );

        pack( );
        setLocationRelativeTo( null );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones.
     * @param pEvento Acción que generó el evento. pEvento != null.
     */
    public void actionPerformed( ActionEvent pEvento )
    {
        if( pEvento.getActionCommand( ).equals( ACEPTAR ) )
        {
            String nombre = txtNombre.getText( );
            String especie = txtEspecie.getText( );
            String tipo = txtTipo.getSelectedItem( ).toString( );
            String habitat = txtHabitat.getSelectedItem( ).toString( );
            String imagen = txtImagen.getText( );
            if( !nombre.equals( "" ) && !especie.equals( "" ) && !imagen.equals( "" ) )
            {
                if( imagen.endsWith( ".jpg" ) || imagen.endsWith( ".jpge" ) || imagen.endsWith( ".png" ) )
                {

                    principal.agregarAnimal( nombre, especie, tipo, habitat, imagen );
                    setVisible( false );
                    dispose( );
                }
                else
                {
                    JOptionPane.showMessageDialog( this, "Debe ingresar una imagen y no otro tipo de archivo.", "Agregar animal", JOptionPane.ERROR_MESSAGE );
                }

            }
            else
            {
                JOptionPane.showMessageDialog( this, "Debe llenar todos los campos.", "Agregar animal", JOptionPane.ERROR_MESSAGE );
            }
        }
        else if( pEvento.getActionCommand( ).equals( CANCELAR ) )
        {
            setVisible( false );
            dispose( );
        }
        else if( pEvento.getActionCommand( ).equals( EXAMINAR ) )
        {
            JFileChooser fc = new JFileChooser( "./data" );
            fc.setDialogTitle( "Buscar imagen" );
            fc.setMultiSelectionEnabled( false );

            int resultado = fc.showOpenDialog( this );
            if( resultado == JFileChooser.APPROVE_OPTION )
            {
                String imagen = fc.getSelectedFile( ).getAbsolutePath( );
                txtImagen.setText( imagen );
            }
        }
    }

}