package uniandes.dpoo.interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfazPrincipal extends JFrame
{
	
	private PanelImagen panelbanner;
	
	private PanelInfo panelinfo;
	
	private PanelBotones panelbotones;
	
	private PanelInfoProyectos panelinfoproyectos;
	
	private PanelParticipante panelparticipante;
	
	public InterfazPrincipal () 
	{
		
		setSize( 900, 400 );
		setTitle( "Aplicacion Proyectos" );
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout( new BorderLayout());
		
		panelbanner = new  PanelImagen();
		add(panelbanner, BorderLayout.NORTH);
		
		panelinfo = new  PanelInfo();
		add(panelinfo, BorderLayout.CENTER);
		
		panelbotones = new  PanelBotones();
		add(panelbotones, BorderLayout.SOUTH);
		
		panelinfoproyectos = new  PanelInfoProyectos();
		add(panelinfoproyectos, BorderLayout.WEST);
		
		panelparticipante = new  PanelParticipante();
		add(panelparticipante, BorderLayout.EAST);
		
		
	}
	
	public static void main( String[] pArgs )
	{
		InterfazPrincipal interfaz = new InterfazPrincipal();
		interfaz.setVisible( true );
	}
	
	

}
