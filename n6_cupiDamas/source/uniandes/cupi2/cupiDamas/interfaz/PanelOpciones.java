package uniandes.cupi2.cupiDamas.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener
{
	public static final String R="Reinciar";public static final String C="Cargar";public static final String OP2="Opcion 2";public static final String OP1="Opcion 1";
	private JButton reiniciar,cargar,op1,op2;
	private Interfaz interfaz;
	public PanelOpciones(Interfaz pInterfaz)
	{
		setLayout(new GridLayout(1,4));
		setBorder(BorderFactory.createTitledBorder("Opciones"));
		setPreferredSize(new Dimension(0,50));
		interfaz=pInterfaz;
		
		reiniciar= new JButton(R);
		reiniciar.setActionCommand(R);
		reiniciar.addActionListener(this);
		add(reiniciar);
		cargar= new JButton(C);
		cargar.setActionCommand(C);
		cargar.addActionListener(this);
		add(cargar);
		op1= new JButton(OP1);
		op1.setActionCommand(OP1);
		op1.addActionListener(this);
		add(op1);
		op2= new JButton(OP2);
		op2.setActionCommand(OP2);
		op2.addActionListener(this);
		add(op2);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		
		if(comando.equals(C))
		{
			interfaz.cargar();
		}
		
	}

}
