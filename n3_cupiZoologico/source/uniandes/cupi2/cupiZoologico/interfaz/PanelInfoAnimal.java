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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import uniandes.cupi2.cupiZoologico.mundo.Animal;

/**
 * Panel que contiene la información de un animal.
 */
public class PanelInfoAnimal extends JPanel
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * La altura que debe tener la imagen de un individuo.
     */
    private static final int ALTURA = 150;

    /**
     * El ancho que debe tener la imagen de un individuo.
     */
    private static final int ANCHO = 150;

    /**
     * La ruta de la imagen que muestra el panel cuando no hay ningún animal seleccionado.
     */
    private static final String IMAGEN = "./data/cupiElefante.png";

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel con la información del animal.
     */
    private JPanel panelInformacion;

    /**
     * Panel con la foto del animal.
     */
    private JPanel panelFoto;

    /**
     * Campo de texto con el nombre.
     */
    private JTextField txtNombre;
    
    /**
     * Campo de texto con la especie.
     */
    private JTextField txtEspecie;

    /**
     * Campo de texto con el tipo.
     */
    private JTextField txtTipo;

    /**
     * Campo de texto con el hábitat.
     */
    private JTextField txtHabitat;

    /**
     * Etiqueta con la imagen del animal.
     */
    private JLabel lblImagen;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelInfoAnimal( )
    {
        setBorder( new TitledBorder( "Información animal" ) );
        setLayout( new BorderLayout( ) );

        panelInformacion = new JPanel( );
        panelInformacion.setLayout( new GridLayout( 7, 2 ) );

        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );

        panelInformacion.add( new JLabel( " Nombre:" ) );
        txtNombre = new JTextField( );
        txtNombre.setEditable(false);
        panelInformacion.add( txtNombre );

        panelInformacion.add( new JLabel( " Especie:" ) );
        txtEspecie = new JTextField( );
        txtEspecie.setEditable(false);
        panelInformacion.add( txtEspecie );

        panelInformacion.add( new JLabel( " Tipo:" ) );
        txtTipo = new JTextField( );
        txtTipo.setEditable(false);
        panelInformacion.add( txtTipo );

        panelInformacion.add( new JLabel( " Hábitat:" ) );
        txtHabitat = new JTextField( );
        txtHabitat.setEditable(false);
        panelInformacion.add( txtHabitat );

        panelInformacion.add( new JLabel( "" ) );
        panelInformacion.add( new JLabel( "" ) );

        add( panelInformacion, BorderLayout.CENTER );

        panelFoto = new JPanel( );

        lblImagen = new JLabel( );
        lblImagen.setBorder( new LineBorder( Color.BLACK, 1 ) );
        lblImagen.setMinimumSize( new Dimension( 230, 153 ) );
        lblImagen.setMaximumSize( new Dimension( 230, 153 ) );
        panelFoto.add( lblImagen );

        try
        {
            String imagen = IMAGEN;
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );

        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE );
        }
        add( panelFoto, BorderLayout.SOUTH );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Muestra los datos del animal dado por parámetro.
     * @param pAnimal Animal a mostrar. pAnimal != null.
     */
    public void mostrarDatos( Animal pAnimal )
    {
        try
        {
            txtNombre.setText( pAnimal.darNombre( ) );
            txtEspecie.setText( pAnimal.darEspecie( ) );
            txtTipo.setText( pAnimal.darTipo( ) );
            txtHabitat.setText( pAnimal.darHabitat( ) );

            String imagen = pAnimal.darImagen( );
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen del animal " + pAnimal.darNombre( )+".", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }

    /**
     * Borra los datos en el panel del animal actual.
     */
    public void borrarDatos( )
    {
        try
        {
            txtNombre.setText( "" );
            txtEspecie.setText( "" );
            txtTipo.setText( "" );
            txtHabitat.setText( "" );

            String imagen = IMAGEN;
            BufferedImage bImagen = ImageIO.read( new File( imagen ) );
            Image laImagen = bImagen.getScaledInstance( ( int ) ( ANCHO * 0.85 ), ( int ) ( ALTURA * 0.85 ), Image.SCALE_AREA_AVERAGING );
            lblImagen.setIcon( new ImageIcon( laImagen ) );
        }
        catch( IOException e )
        {
            JOptionPane.showMessageDialog( this, "Error al cargar la imagen.", "Error", JOptionPane.ERROR_MESSAGE );
        }
    }
}