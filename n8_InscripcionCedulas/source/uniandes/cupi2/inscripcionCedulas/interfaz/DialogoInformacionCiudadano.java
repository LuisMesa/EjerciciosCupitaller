/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n8_inscripcionCedulas
 * Autor: Equipo Cupi2 - 2015
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.inscripcionCedulas.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

/**
 * Dialogo con la información de un ciudadano.
 */
public class DialogoInformacionCiudadano extends JDialog 
{
	// -----------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------

    /**
     * Campo de texto del número de cédula del ciudadano.
     */
    private JTextField txtCedula;
    
    /**
     * Campo de texto de los apellidos del ciudadano.
     */
    private JTextField txtApellidos;
    
    /**
     * Campo de texto con los nombres del ciudadano.
     */
    private JTextField txtNombres;
    
    /**
     * Campo de texto con la fecha de nacimiento del ciudadano.
     */
    private JTextField txtFechaNacimiento;
    
    /**
     * Campo de texto con el lugar de nacimiento del ciudadano.
     */
    private JTextField txtLugarNacimiento;
    
    /**
     * Campo de texto con el sexo del ciudadano.
     */
    private JTextField txtSexo;
    
    /**
     * Campo de texto con la fecha de expedición de la cédula del ciudadano.
     */
    private JTextField txtFechaExpedicion;
    
    /**
     * Campo de texto con el lugar de expedición de la cédula del ciudadano.
     */
    private JTextField txtLugarExpedicion;
        
    // -----------------------------------------------
    // Métodos
    // -----------------------------------------------

    /**
     * Crea el dialogo con la información de un ciudadano.
     * @param pCedula Cédula del ciudadano. pCedula != null && pCedula != "".
     * @param pApellidos Apellidos del ciudadano. pApellidos != null && pApellidos != "".
     * @param pNombres Nombres del ciudadano. pNombres != null && pNombres != "".
     * @param pFechaNacimiento Fecha de nacimiento del ciudadano. pFechaNacimiento != null.
     * @param pLugarNacimiento Lugar de nacimiento del ciudadano. pLugarNacimiento != null && pLugarNacimiento != "".
     * @param pSexo Sexo del ciudadano. pSexo != null && (pSexo == FEMENINO || pSexo == MASCULINO ).
     * @param pFechaExpedicion Fecha de expedición de la cédula del ciudadano. pExpedicion != null.
     * @param pLugarExpedicion Lugar de expedición de la cédula del ciudadano. pLugarExpedicion != null && pLugarExpedicion != "".
     */
    public DialogoInformacionCiudadano(String pCedula, String pApellidos, String pNombres, Date pFechaNacimiento, String pLugarNacimiento, String pSexo, Date pFechaExpedicion, String pLugarExpedicion )
    {
    	setLayout(new GridBagLayout());
    	setSize(320, 350);
    	setTitle("Información ciudadano");
    	setLocationRelativeTo(null);
    	setModal(true);
    	    	
    	JPanel aux1 = new JPanel();
    	aux1.setBorder(new TitledBorder(" Información cédula: "));
    	aux1.setLayout(new GridBagLayout());	
    	
    	GridBagConstraints gridBagConstraints = new GridBagConstraints( );
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1;
        gridBagConstraints.anchor = GridBagConstraints.WEST;
        gridBagConstraints.insets = new Insets( 5, 5, 5, 5 );
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel cedula = new JLabel("Cédula: ");
        aux1.add(cedula, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtCedula = new  JTextField("" + pCedula);
        txtCedula.setEditable(false);
        aux1.add(txtCedula, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel expedicion = new JLabel("Fecha de expedición: ");
        aux1.add(expedicion, gridBagConstraints);
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        gridBagConstraints.gridx = 1;
        txtFechaExpedicion = new JTextField(formato.format(pFechaExpedicion));
        txtFechaExpedicion.setEditable(false);
        aux1.add(txtFechaExpedicion, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JLabel lugarExpedicion = new JLabel("Lugar de expedición: ");
        aux1.add(lugarExpedicion, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtLugarExpedicion = new JTextField(pLugarExpedicion);
        txtLugarExpedicion.setEditable(false);
        aux1.add(txtLugarExpedicion, gridBagConstraints); 
        
        JPanel aux2 = new JPanel();
        aux2.setBorder(new TitledBorder("Información personal: "));
        aux2.setLayout(new GridBagLayout());
               
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        JLabel apellidos = new JLabel("Apellidos: ");
        aux2.add(apellidos, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtApellidos = new JTextField(pApellidos);
        txtApellidos.setEditable(false);
        aux2.add(txtApellidos, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        JLabel nombres = new JLabel("Nombres: ");
        aux2.add(nombres, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtNombres = new JTextField(pNombres);
        txtNombres.setEditable(false);
        aux2.add(txtNombres, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        JLabel nacimiento = new JLabel("Fecha de nacimiento: ");
        aux2.add(nacimiento, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtFechaNacimiento = new JTextField(formato.format(pFechaNacimiento));
        txtFechaNacimiento.setEditable(false);
        txtFechaNacimiento.setSize(75, 75);
        aux2.add(txtFechaNacimiento, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        JLabel lugarNacimiento = new JLabel("Lugar de nacimiento: ");
        aux2.add(lugarNacimiento, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtLugarNacimiento = new JTextField(pLugarNacimiento);
        txtLugarNacimiento.setEditable(false);
        aux2.add(txtLugarNacimiento, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        JLabel sexo = new JLabel("Sexo: ");
        aux2.add(sexo, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        txtSexo = new JTextField(pSexo);
        txtSexo.setEditable(false);
        aux2.add(txtSexo, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(aux1, gridBagConstraints);
        
        gridBagConstraints.gridy = 1;
        add(aux2, gridBagConstraints);
    }
}
