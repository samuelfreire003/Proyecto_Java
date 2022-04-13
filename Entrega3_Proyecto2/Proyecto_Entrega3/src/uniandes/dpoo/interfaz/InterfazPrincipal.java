package uniandes.dpoo.interfaz;

import java.awt.BorderLayout;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uniandes.dpoo.procesamiento.ManejadorProyecto;

public class InterfazPrincipal extends JFrame
{
	
	private PanelImagen panelbanner;
	
	private PanelInfo panelinfo;
	
	private PanelBotones panelbotones;
	
	private PanelInfoProyectos panelinfoproyectos;
	
	private PanelParticipante panelparticipante;
	
	private ManejadorProyecto proyectos;
	
	public InterfazPrincipal () throws FileNotFoundException, IOException 
	{
		
		setSize( 900, 400 );
		setTitle( "Aplicacion Proyectos" );
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setLayout( new BorderLayout());
		setLocationRelativeTo( null );
		
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
	
	public void CrearProyecto(String nombreProyecto,String descripcionProyecto,int diaInicio,int mesInicio,int añoInicio, String nombreCreador,String correoCreador,int diaFinal,int mesFinal,int añoFinal,String tipos)
    {
        try
        {
            ManejadorProyecto.IniciarProyecto( nombreProyecto, descripcionProyecto, diaInicio, mesInicio, añoInicio,  nombreCreador, correoCreador, diaFinal, mesFinal, añoFinal, tipos );
            ManejadorProyecto.AgregarProyecto();
            ManejadorProyecto.CrearArchivoReporte();
            
        }
        catch( Exception e )
        {
            JOptionPane.showMessageDialog( this, "	No se creo de manera correcta el proyecto" );
        }
    }
	
	public static void main( String[] pArgs ) throws FileNotFoundException, IOException
	{
		InterfazPrincipal interfaz = new InterfazPrincipal();
		interfaz.setVisible( true );
	}
	
	

}
