package uniandes.dpoo.interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class VentanaReporteGeneral extends JFrame
{
	private PanelReporteGeneral panelreportegeneral;
	
	private JScrollPane barras;
	
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
