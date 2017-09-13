package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDerecha extends JPanel implements ActionListener 
{
	public static final String CAMBIAR = "Cambiar promedio";
	
	private JTextField nombre,codigo,semestre,promedio,creditos;
	private JButton cambiarP;
	
	private Interfaz interfaz;
	
	public PanelDerecha(Interfaz pInterfaz)
	{
		setLayout(new GridLayout(6,1));
		setPreferredSize(new Dimension(200,0));
		
		interfaz = pInterfaz;
		
		nombre = new JTextField();
		add(nombre);
		codigo = new JTextField();
		add(codigo);
		semestre = new JTextField();
		add(semestre);
		promedio =new JTextField();
		add(promedio);
		creditos = new JTextField();
		add(creditos);
		
		cambiarP = new JButton("Cambiar promedio");
		cambiarP.addActionListener(this);
		cambiarP.setActionCommand(CAMBIAR);
		add(cambiarP);
		
	}
	public void actualizarPanelDerecho(String pNombre, int pCodigo, int pSemestre, double pPromedio, double pCreditos)
	{
		nombre.setText(pNombre);
		codigo.setText(pCodigo+"");
		semestre.setText(pSemestre+"");
		promedio.setText(pPromedio+"");
		creditos.setText(pCreditos+"");
		
	}
	public void actualizarPromedio(double pPromedio)
	{
		promedio.setText(pPromedio+"");
	}
	public void actionPerformed(ActionEvent e)
	{
		String comando=e.getActionCommand();
		if(comando.equals(CAMBIAR))
			interfaz.cambiarPromedio();
		
	}
}
