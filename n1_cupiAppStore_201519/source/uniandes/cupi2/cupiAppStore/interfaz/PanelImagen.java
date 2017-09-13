/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_cupiAppStore
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.cupiAppStore.interfaz;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con la imagen de la aplicación.
 */
public class PanelImagen extends JPanel
{
    // ------------------------------------------------------------
    // Constantes
    // ------------------------------------------------------------

    /**
     * Constante para la ruta a la imagen del cupiAppStore.
     */
    private static final String IMAGEN = "data/imagenes/encabezado.jpg";

    // ------------------------------------------------------------
    // Atributos de interfaz
    // ------------------------------------------------------------

    /**
     * Etiqueta con la imagen del título del cupiAppStore.
     */
    private JLabel etiquetaImagen;

    // ------------------------------------------------------------
    // Constructor
    // ------------------------------------------------------------

    /**
     * Constructor del panel de la imagen de la tienda de juegos.
     */
    public PanelImagen( )
    {
        setLayout( new BorderLayout( ) );

        // Etiqueta de Imagen
        ImageIcon icono = new ImageIcon( IMAGEN );
        etiquetaImagen = new JLabel( "" );

        etiquetaImagen.setIcon( icono );
        etiquetaImagen.setBorder( new TitledBorder( "" ) );
        add( etiquetaImagen, BorderLayout.CENTER );

    }
}