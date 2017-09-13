/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n7_cupiCava
 * Autor: Equipo Cupi2 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.cupiCava.interfaz;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Panel con la información detallada de un vino.
 */
public class PanelInformacionVino extends JPanel
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto con el nombre del vino.
     */
    private JTextField txtNombre;

    /**
     * Campo de texto con la presentación del vino.
     */
    private JTextField txtPresentacion;

    /**
     * Campo de texto con el año de elaboración del vino.
     */
    private JTextField txtAnhoElaboracion;

    /**
     * Campo de texto con el contenido en azúcar del vino.
     */
    private JTextField txtContenidoAzucar;

    /**
     * Campo de texto con el lugar de origen del vino.
     */
    private JTextField txtLugarOrigen;

    /**
     * Campo de texto con el tipo del vino.
     */
    private JTextField txtTipo;

    /**
     * Campo de texto con el color del vino.
     */
    private JTextField txtColor;

    /**
     * Etiqueta con la imagen del vino.
     */
    private JLabel lblImagen;

    // -----------------------------------------------------------------
    // Constructor
    // -----------------------------------------------------------------

    /**
     * Constructor del panel.
     */
    public PanelInformacionVino( )
    {
        setBorder( new TitledBorder( " Información del vino " ) );

        JPanel panelAuxiliar = new JPanel( );
        panelAuxiliar.setLayout( new GridBagLayout( ) );

        setLayout( new BorderLayout( ) );

        GridBagConstraints gbc = new GridBagConstraints( );
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.insets = new Insets( 5, 3, 5, 3 );

        panelAuxiliar.add( new JLabel( " Nombre: " ), gbc );
        gbc.gridy = 1;
        panelAuxiliar.add( new JLabel( " Presentación: " ), gbc );
        gbc.gridy = 2;
        panelAuxiliar.add( new JLabel( " Año de elaboración: " ), gbc );
        gbc.gridy = 3;
        panelAuxiliar.add( new JLabel( " Contenido de azúcar (g/l): " ), gbc );
        gbc.gridy = 4;
        panelAuxiliar.add( new JLabel( " Tipo: " ), gbc );
        gbc.gridy = 5;
        panelAuxiliar.add( new JLabel( " Lugar de origen: " ), gbc );
        gbc.gridy = 6;
        panelAuxiliar.add( new JLabel( " Color: " ), gbc );

        gbc.gridx = 1;
        gbc.gridy = 0;
        txtNombre = new JTextField( );
        txtNombre.setEditable( false );
        panelAuxiliar.add( txtNombre, gbc );

        gbc.gridy = 1;
        txtPresentacion = new JTextField( );
        txtPresentacion.setEditable( false );
        panelAuxiliar.add( txtPresentacion, gbc );

        gbc.gridy = 2;
        txtAnhoElaboracion = new JTextField( );
        txtAnhoElaboracion.setEditable( false );
        panelAuxiliar.add( txtAnhoElaboracion, gbc );

        gbc.gridy = 3;
        txtContenidoAzucar = new JTextField( );
        txtContenidoAzucar.setEditable( false );
        panelAuxiliar.add( txtContenidoAzucar, gbc );

        gbc.gridy = 4;
        txtTipo = new JTextField( );
        txtTipo.setEditable( false );
        panelAuxiliar.add( txtTipo, gbc );

        gbc.gridy = 5;
        txtLugarOrigen = new JTextField( );
        txtLugarOrigen.setEditable( false );
        panelAuxiliar.add( txtLugarOrigen, gbc );

        gbc.gridy = 6;
        txtColor = new JTextField( );
        txtColor.setEditable( false );
        panelAuxiliar.add( txtColor, gbc );

        add( panelAuxiliar, BorderLayout.CENTER );

        lblImagen = new JLabel( );
        add( lblImagen, BorderLayout.EAST );

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la información del vino con la información que entra por parámetro.
     * @param pNombre Nombre del vino. pNombre != null && pNombre != "".
     * @param pPresentacion Presentación del vino. pPresentacion != null && pPresentacion != "" && (pPresentacion == BOTELLA || pPresentacion == BARRIL).
     * @param pAnhoElaboracion Año de elaboración del vino. pAnhoElaboracion > 0.
     * @param pContenidoAzucar Contenido en azúcar del vino. pContenidoAzucar >= 0
     * @param pTipo Tipo de vino de acuerdo a su contenido en azúcar. pTipo != null && pTipo != "" && (pTipo == SECO || pTipo == ABOCADO || pTipo == SEMI_SECO || pTipo ==
     *        SEMI_DULCE || pTipo == DULCE).
     * @param pColor Color del vino. pColor != null && pColor != "" && (pColor == TINTO || pColor == ROSADO || pColor == BLANCO).
     * @param pLugarOrigen Lugar de origen del vino. lugarElaboracion != null y lugarElaboracion != "".
     * @param pImagen Imagen del vino. pImagen != null && pImagen != "".
     */
    public void actualizarInformacion( String pNombre, String pPresentacion, int pAnhoElaboracion, double pContenidoAzucar, String pTipo, String pLugarOrigen, String pColor, String pImagen )
    {
        txtNombre.setText( pNombre );
        txtPresentacion.setText( pPresentacion );
        txtAnhoElaboracion.setText( "" + pAnhoElaboracion );
        txtContenidoAzucar.setText( "" + pContenidoAzucar );
        txtTipo.setText( pTipo );
        txtLugarOrigen.setText( pLugarOrigen );
        txtColor.setText( pColor );
        lblImagen.setIcon( new ImageIcon( pImagen ) );
    }
}