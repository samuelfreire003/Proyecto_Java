package uniandes.dpoo.interfaz;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelBotones extends JPanel

{
	
	private JButton BOTON1;
	private JButton BOTON2;
	private JButton BOTON3;
	private JButton BOTON4;
	private JButton BOTON5;
	private JButton BOTON6;
	private JButton BOTON7;
	private JButton BOTON8;
	
	public PanelBotones () 
	{
		setBorder( new TitledBorder ( "Opciones" ));
		setLayout( new GridLayout(2, 4));
		
		BOTON1 = new JButton( "Buscar por nombre" );
		add(BOTON1);
		
		BOTON2 = new JButton( "Crear reporte Predefinida" );
		add(BOTON2);
		
		BOTON3 = new JButton( "Crear Proyecto" );
		add(BOTON3);
		
		BOTON4 = new JButton( "Ver reporte general" );
		add(BOTON4);
		
		BOTON5 = new JButton( "Crear rep. cronometrada" );
		add(BOTON5);
		
		BOTON6 = new JButton( "Agregar Participante" );
		add(BOTON6);
		
		BOTON7 = new JButton( "Mirar Proyecto" );
		add(BOTON7);

		BOTON8 = new JButton( "Visualizar Actividades dia" );
		add(BOTON8);
	}

}
