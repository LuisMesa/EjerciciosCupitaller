package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferiorCentro extends JPanel implements ActionListener
{

	private Interfaz interfaz;
	private JButton btnIz2,btnIz1,btnBuscar,btnDe1,btnDe2;
	
	public PanelInferiorCentro(Interfaz pInterfaz)
	{
		setLayout(new GridLayout(1,5));
		interfaz = pInterfaz;
		
		btnIz2 = new JButton("<<");
		btnIz2.setActionCommand("<<");
		btnIz2.addActionListener(this);
		add(btnIz2);

		btnIz1 = new JButton("<");
		btnIz1.setActionCommand("<");
		btnIz1.addActionListener(this);
		btnIz1.setBackground(new Color(124, 205, 124));
		add(btnIz1);

		btnBuscar = new JButton("Buscar Estudiante");
		btnBuscar.setActionCommand("Buscar Estudiante");
		btnBuscar.addActionListener(this);
		btnBuscar.setBackground(new Color(0 ,154, 205));
		add(btnBuscar);

		btnDe1 = new JButton(">");
		btnDe1.setActionCommand(">");
		btnDe1.addActionListener(this);
		btnDe1.setBackground(new Color(124, 205, 124));
		add(btnDe1);

		btnDe2 = new JButton(">>");
		btnDe2.setActionCommand(">>");
		btnDe2.addActionListener(this);
		add(btnDe2);

	

		}
	
	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if(comando.equals("Buscar Estudiante"))
			interfaz.buscarEstudiante();
		else if(comando.equals("<<"))
			interfaz.moverIz2();
		else if(comando.equals("<"))
			interfaz.moverIz1();
		else if(comando.equals(">"))
			interfaz.moverDe1();
		else if(comando.equals(">>"))
			interfaz.moverDe2();
			
		
	}
}
