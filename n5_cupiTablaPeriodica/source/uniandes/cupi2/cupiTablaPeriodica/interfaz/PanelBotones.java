package uniandes.cupi2.cupiTablaPeriodica.interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel implements ActionListener
{

	public static final String BUSCAR_NOMBRE = "Buscar por nombre";
	public static final String BUSCAR_SIMBOLO="Buscar por símbolo";
	public static final String BUSCAR_NUMERO = "Buscar por N° atómico";
	public static final String OPCION1="Opcion 1";
	public static final String OPCION2="Opcion 2";
	
	private JButton bNombre;
	private JButton bSimbolo;
	private JButton bNumero;
	private JButton bOp1;
	private JButton bOp2;
	
	private Interfaz interfaz;
	
	public PanelBotones(Interfaz pInterfaz)
	{
		interfaz=pInterfaz;
		
		setPreferredSize(new Dimension(0,50));
		TitledBorder borde= BorderFactory.createTitledBorder("Opciones");
		setBorder(borde);
		
		GridLayout layout=(new GridLayout(1,5));
		layout.setVgap( 2 );
		layout.setHgap( 2 );
		setLayout(layout);
		
		bNombre= new JButton(BUSCAR_NOMBRE);
		bNombre.addActionListener(this);
		bNombre.setActionCommand(BUSCAR_NOMBRE);
		add(bNombre);
		
		bSimbolo= new JButton(BUSCAR_SIMBOLO);
		bSimbolo.addActionListener(this);
		bSimbolo.setActionCommand(BUSCAR_SIMBOLO);
		add(bSimbolo);
		
		bNumero= new JButton(BUSCAR_NUMERO);
		bNumero.addActionListener(this);
		bNumero.setActionCommand(BUSCAR_NUMERO);
		add(bNumero);
		
		bOp1= new JButton(OPCION1);
		bOp1.addActionListener(this);
		bOp1.setActionCommand(OPCION1);
		add(bOp1);
		
		bOp2= new JButton(OPCION2);
		bOp2.addActionListener(this);
		bOp2.setActionCommand(OPCION2);
		add(bOp2);
	}
	public void actionPerformed(ActionEvent e)
	{
		String comando=e.getActionCommand();
		if(comando.equals(BUSCAR_NOMBRE))
			interfaz.buscarPorNombre();
		else if(comando.equals(BUSCAR_SIMBOLO))
			interfaz.buscarPorSimbolo();
		else if(comando.equals(BUSCAR_NUMERO))
			interfaz.buscarPorNumero();
		else if (comando.equals(OPCION1))
		{
			interfaz.reqFuncionOpcion1();
		}
		else if (comando.equals(OPCION2))
		{
			interfaz.reqFuncionOpcion2();
		}
		//interfaz.refrescarPanelElemento(comando);
	}
}
