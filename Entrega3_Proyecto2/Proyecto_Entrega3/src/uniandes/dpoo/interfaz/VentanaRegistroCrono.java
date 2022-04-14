package uniandes.dpoo.interfaz;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaRegistroCrono extends JFrame

{
	
	private PanelRegistroCrono panelregistrocrono;
	
	public VentanaRegistroCrono () throws FileNotFoundException, IOException
	{
		setSize( 900, 600 );
		setTitle( "ReporteCrono" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo( null );
		
		panelregistrocrono = new  PanelRegistroCrono();
		add(panelregistrocrono);
	}

}
