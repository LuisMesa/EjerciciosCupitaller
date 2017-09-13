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

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


/**
 * Panel con la información general del zoológico.
 */
public class PanelInformacion extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta con la cantidad de jaulas.
     */
    private JLabel txtCantJaulas;

    /**
     * Etiqueta con la cantidad de jaulas en el sector norte.
     */
    private JLabel txtCantNorte;

    /**
     * Etiqueta con la cantidad de jaulas en el sector sur.
     */
    private JLabel txtCantSur;

    /**
     * Etiqueta con el porcentaje de ocupación de las jaulas.
     */
    private JLabel txtPorcentaje;

    /**
     * Etiqueta con la cantidad de animales del zoológico.
     */
    private JLabel txtCantAnimales;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelInformacion( )
    {
        setBorder( new TitledBorder( "Información zoológico" ) );
        setLayout( new GridLayout( 7, 3 ) );
        add( new JLabel( ) );
        add( new JLabel( ) );
        add( new JLabel( ) );

        add( new JLabel( "  Cantidad de jaulas: " ) );
        txtCantJaulas = new JLabel( );
        add( txtCantJaulas );
        add( new JLabel( ) );

        add( new JLabel( "  Jaulas sector norte: " ) );
        txtCantNorte = new JLabel( );
        add( txtCantNorte );
        add( new JLabel( ) );

        add( new JLabel( "  Jaulas sector sur: " ) );
        txtCantSur = new JLabel( );
        add( txtCantSur );
        add( new JLabel( ) );

        add( new JLabel( "  Cantidad de animales: " ) );
        txtCantAnimales = new JLabel( );
        add( txtCantAnimales );
        add( new JLabel( ) );

        add( new JLabel( "  Porcentaje ocupación: " ) );
        txtPorcentaje = new JLabel( );
        add( txtPorcentaje );
        add( new JLabel( ) );
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información del panel.
     * @param pCantidadJaulas Cantidad de jaulas que tiene el zoológico. pCantidadJaulas >= 0.
     * @param pCantidadJaulasNorte Cantidad jaulas ubicadas en el sector norte.  pCantidadJaulasNorte >= 0.
     * @param pCantidadJaulasSur Cantidad jaulas ubicadas en el sector sur.  pCantidadJaulasSur >= 0.
     * @param pPorcentajeOcupacion Porcentaje de ocupación de las jaulas. pPorcentajeOcupacion >= 0.
     * @param pCantidadAnimales Cantidad de animales que tiene el zoológico. pCantidadAnimales >= 0.
     */
    public void actualizar(int pCantidadJaulas, int pCantidadJaulasNorte, int pCantidadJaulasSur, double pPorcentajeOcupacion, int pCantidadAnimales  )
    {
        txtCantJaulas.setText( "" + pCantidadJaulas );
        txtCantNorte.setText( "" + pCantidadJaulasNorte );
        txtCantSur.setText( "" + pCantidadJaulasSur );
        txtPorcentaje.setText( ( Math.floor( pPorcentajeOcupacion * 100 + 0.5 ) / 100 ) + "%" );
        txtCantAnimales.setText( "" + pCantidadAnimales );
    }

    /**
     * Sobreescribe el método paintComponent para poder pintar la imagen de fondo del panel.
     * @param pGraphic Imagen del fondo. pGraphic != null.
     */
    public void paintComponent( Graphics pGraphic )
    {
        Dimension tamanio = getSize( );
        ImageIcon imagenFondo = new ImageIcon( "data/fondo_zoo.png" );
        pGraphic.drawImage( imagenFondo.getImage( ), 0, 0, tamanio.width, tamanio.height, null );
        setOpaque( false );
        super.paintComponent( pGraphic );

    }
}
