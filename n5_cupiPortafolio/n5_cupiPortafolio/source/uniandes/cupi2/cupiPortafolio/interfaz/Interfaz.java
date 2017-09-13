package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import uniandes.cupi2.cupiPortafolio.mundo.Estudiante;
import uniandes.cupi2.cupiPortafolio.mundo.PortafolioEstudiantil;

public class Interfaz extends JFrame 
{

	private PanelCentro panelCentro;
	private PanelDerecha panelDerecha;
	private PanelIzquierda panelIzquierda;
	private PanelInferiorCentro panelInferiorCentro;
	private PanelInferior panelInferior;
	private PortafolioEstudiantil mundo;


	public  Interfaz() throws Exception
	{

		setSize(730,700);
		setTitle("Portafolio estudiantil");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		mundo = new PortafolioEstudiantil();

		JPanel arriba = new JPanel();
		arriba.setLayout(new GridLayout(1,1));
		ImageIcon im1=new ImageIcon("./data/imagenes/banner.png");
		JLabel lb1=new JLabel();
		lb1.setIcon(im1);
		arriba.add(lb1);
		add(arriba, BorderLayout.NORTH);

		JPanel panelAux = new JPanel();
		panelAux.setLayout(new BorderLayout());
		panelAux.setBorder(BorderFactory.createTitledBorder("Información del estudiante"));

		panelCentro = new PanelCentro();
		panelAux.add(panelCentro, BorderLayout.CENTER);

		panelDerecha = new PanelDerecha(this);
		panelAux.add(panelDerecha, BorderLayout.EAST);

		panelIzquierda = new PanelIzquierda(this);
		panelAux.add(panelIzquierda, BorderLayout.WEST);

		panelInferiorCentro = new PanelInferiorCentro(this);
		panelAux.add(panelInferiorCentro, BorderLayout.SOUTH);

		add(panelAux);

		panelInferior = new PanelInferior(this);
		add(panelInferior, BorderLayout.SOUTH);

		actualizarEstudiante(null);
	}
	public void actualizarEstudiante(Estudiante es)
	{

		Estudiante e =es==null?mundo.darEstudianteActual():es;
		panelDerecha.actualizarPanelDerecho(e.darNombre(), e.darCodigo(), e.darSemestre(), e.darPromedio(), e.darCreditosVistos());
		panelIzquierda.cambiarImagen(e.darRutaImagen());
		panelCentro.actualizarGraduado(e.darEstadoEstudiante());
	}
	public void cambiarPromedio()
	{
		String a =JOptionPane.showInputDialog(this,"Ingrese el nuevo prmedio del estudiante:","Cambiar promedio",JOptionPane.INFORMATION_MESSAGE);
		if(a!=null)
		{
			double prom=Double.parseDouble(a);
			panelDerecha.actualizarPromedio(prom);
		}
	}
	public void buscarEstudiante()
	{

		String a =JOptionPane.showInputDialog(this,"Ingrese el código del estudiante:","Buscar estudiante",JOptionPane.INFORMATION_MESSAGE);
		if(a!=null)
		{
			int codigo =Integer.parseInt(a);
			Estudiante e =mundo.buscarEstudiante(codigo);
			if(e==null)
				mostrarMsj("No hay un estudainte con este código: "+codigo);
			else
				actualizarEstudiante(e);
		}

	}
	public String darRutaImagen()
	{
		return mundo.darEstudianteActual().darRutaImagen();
	}
	public void mostrarMsj(String pMensaje)
	{
		JOptionPane.showMessageDialog(this, pMensaje);
	}
	public void moverIz2()
	{
		try
		{
			Estudiante e = mundo.darPrimerEstudiante();
			actualizarEstudiante(e);
		}
		catch (Exception e)
		{
			mostrarMsj(e.getMessage());
		}
	}
	public void moverIz1()
	{
		try
		{
			Estudiante e = mundo.darEstudianteAnterior();
			actualizarEstudiante(e);
		}
		catch (Exception e)
		{
			mostrarMsj(e.getMessage());
		}
	}
	public void moverDe1()
	{
		try
		{
			Estudiante e = mundo.darEstudianteSiguiente();
			actualizarEstudiante(e);
		}
		catch (Exception e)
		{
			mostrarMsj(e.getMessage());
		}
	}
	public void moverDe2()
	{
		try
		{
			Estudiante e = mundo.darUltimoEstudiante();
			actualizarEstudiante(e);
		}
		catch (Exception e)
		{
			mostrarMsj(e.getMessage());
		}
	}
	public void op1()
	{
		mostrarMsj(mundo.metodo1());
	}
	public void op2()
	{
		mostrarMsj(mundo.metodo2());
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try
		{
			Interfaz a= new Interfaz();
			a.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}

}
