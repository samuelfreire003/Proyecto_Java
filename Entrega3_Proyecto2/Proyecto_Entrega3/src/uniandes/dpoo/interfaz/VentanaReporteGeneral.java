package uniandes.dpoo.interfaz;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class VentanaReporteGeneral extends JFrame
{
	private PanelReporteGeneral panelreportegeneral;
	
	public VentanaReporteGeneral () throws FileNotFoundException, IOException
	{
		setSize( 900, 600 );
		setTitle( "Ventana Reporte General" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo( null );
		
		panelreportegeneral = new  PanelReporteGeneral();
		add(panelreportegeneral);
	}
}
