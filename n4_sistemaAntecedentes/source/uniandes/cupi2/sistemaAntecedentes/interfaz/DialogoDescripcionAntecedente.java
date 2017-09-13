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

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Diálogo para mostrar la descripción de un antecedente.
 */
public class DialogoDescripcionAntecedente extends JDialog
{
    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Campo de texto para el identificador del antecedente.
     */
    private JTextField txtIdentificador;
    
    /**
     * Campo de texto para el tipo del antecedente.
     */
    private JTextField txtTipo;
    
    /**
     * Campo de texto para la gravedad del antecedente.
     */
    private JTextField txtGravedad;
    
    /**
     * Campo de texto para los años de condena por el antecedente.
     */
    private JTextField txtAnhosCondena;
    
    /**
     * Área de texto donde va la descripción.
     */
    private JTextArea areaDescripcion;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el diálogo que resume la información del antecedente.
     * @param pPrincipal La ventana principal de la aplicación. !pPrincipal.equeals("") && pPrincipal != null.
     * @param pIdentificador El identificador del antecedente que se está visualizando. pIdentificador >= 0.
     * @param pTipo El tipo del antecedente que se está visualizando. !pTipo.equeals("") && pTipo != null.
     * @param pGravedad La gravedad del antecedente que se está visualizando. !pGravedad.equeals("") && pGravedad != null.
     * @param pAnhosCondena Los años de condena por el antecedente que se está visualizando. pAnhosCondena >= 0.
     * @param pDescripcion La descripción del antecedente que se está visualizando. !pDescripcion.equeals("") && pDescripcion != null.
     */
    public DialogoDescripcionAntecedente( InterfazSistemaAntecedentes pPrincipal, int pIdentificador, String pTipo, String pGravedad, int pAnhosCondena, String pDescripcion )
    {
        setTitle( "Descripción" );
        setSize( 300, 200 );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLayout( new GridLayout( 6, 2 ) );
        setLocationRelativeTo( pPrincipal );
        setModal( true );
        
        add( new JLabel( "Identificador: " ) );
        txtIdentificador = new JTextField( "" + pIdentificador );
        txtIdentificador.setEditable( false );
        add( txtIdentificador );
        
//        add( new JLabel( " " ) );
        add( new JLabel( "Tipo: " ) );
        txtTipo = new JTextField( pTipo );
        txtTipo.setEditable( false );
        add( txtTipo );
        
//        add( new JLabel( " " ) );
        add( new JLabel( "Gravedad: " ) );
        txtGravedad = new JTextField( pGravedad );
        txtGravedad.setEditable( false );
        add( txtGravedad );
        
//        add( new JLabel( " " ) );
        add( new JLabel( "Años condena: " ) );
        txtAnhosCondena = new JTextField( "" + pAnhosCondena );
        txtAnhosCondena.setEditable( false );
        add( txtAnhosCondena );
        
//        add( new JLabel( " " ) );
        add( new JLabel( "Descripción: " ) );
        
        areaDescripcion = new JTextArea( pDescripcion );
        areaDescripcion.setLineWrap( true );
        areaDescripcion.setWrapStyleWord( true );
        areaDescripcion.setEditable( false );

        add( areaDescripcion );
    }
}
