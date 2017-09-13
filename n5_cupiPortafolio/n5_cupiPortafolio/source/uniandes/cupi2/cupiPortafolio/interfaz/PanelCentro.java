package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCentro extends JPanel
{

	private JLabel nombre,codigo,semestre,promedio,creditos;
	private JCheckBox graduado;
	
	public PanelCentro()
	{
		
		
		setLayout(new GridLayout(6,1));
		
		nombre= new JLabel("Nombre");
		nombre.setForeground(new Color(0 ,154, 205));
		add(nombre);
		codigo = new JLabel("Código");
		codigo.setForeground(new Color(0 ,154, 205));
		add(codigo);
		semestre = new JLabel("Semestre");
		semestre.setForeground(new Color(0 ,154, 205));
		add(semestre);
		promedio = new JLabel("Promedio");
		promedio.setForeground(new Color(0 ,154, 205));
		add(promedio);
		creditos=new JLabel ("Créditos vistos");
		creditos.setForeground(new Color(0 ,154, 205));
		add(creditos);
		
		graduado = new JCheckBox("Estudiante graduado");
		graduado.setEnabled(false);
		
		
		add(graduado);
		
	}
	
	public void actualizarGraduado(boolean a)
	{
		graduado.setSelected(a);
	}
}
