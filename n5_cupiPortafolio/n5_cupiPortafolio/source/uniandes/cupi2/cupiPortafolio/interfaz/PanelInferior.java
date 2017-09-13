package uniandes.cupi2.cupiPortafolio.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelInferior extends JPanel implements ActionListener
{
	public static final String OP1 = "Opción 1";
	public static final String OP2 = "Opción 2";
	
	private Interfaz interfaz;
	private JButton op1,op2;
	
	public PanelInferior(Interfaz pInterfaz)
	{
		setBorder(BorderFactory.createTitledBorder("Extensiones"));
		setLayout(new GridLayout(1,2));
		interfaz = pInterfaz;
		
		op1= new JButton(OP1);
		op1.addActionListener(this);
		op1.setActionCommand(OP1);
		add(op1);
		
		op2= new JButton(OP2);
		op2.addActionListener(this);
		op2.setActionCommand(OP2);
		add(op2);
		
	}

	public void actionPerformed(ActionEvent e)
	{
		String comando = e.getActionCommand();
		if(comando.equals(OP1))
			interfaz.op1();
		else if(comando.equals(OP2))
			interfaz.op2();
	}
}
