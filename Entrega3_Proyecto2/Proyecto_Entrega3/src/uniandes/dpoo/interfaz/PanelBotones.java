package uniandes.dpoo.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import uniandes.dpoo.consola.AplicacionProyecto;
import uniandes.dpoo.procesamiento.ManejadorProyecto;
import uniandes.dpoo.procesamiento.ManejadorRegistro;

public class PanelBotones extends JPanel implements ActionListener

{
	
	private JButton BOTON1;
	private JButton BOTON2;
	private JButton BOTON3;
	private JButton BOTON4;
	private JButton BOTON5;
	private JButton BOTON6;
	private JButton BOTON7;
	
	private InterfazPrincipal principal;
	
	public PanelBotones () 
	{
		setBorder( new TitledBorder ( "Opciones" ));
		setLayout( new GridLayout(2, 4));
		
		BOTON1 = new JButton( "Buscar por nombre" );
		add(BOTON1);
		
		BOTON2 = new JButton( "Crear reporte Predefinida" );
		add(BOTON2);
		
		BOTON3 = new JButton( "Crear Proyecto" );
		BOTON3.addActionListener( this );
		BOTON3.setActionCommand( "CrearProyecto" );
		add(BOTON3);
		
		BOTON4 = new JButton( "Ver reporte general" );
		BOTON4.addActionListener( this );
		BOTON4.setActionCommand( "ReporteGeneral" );
		add(BOTON4);
		
		BOTON5 = new JButton( "Crear rep. cronometrada" );
		add(BOTON5);
		
		BOTON6 = new JButton( "Agregar Participante" );
		BOTON6.addActionListener( this );
		BOTON6.setActionCommand( "AgregarParticipante" );
		add(BOTON6);
		
		BOTON7 = new JButton( "Visualizar Actividades dia" );
		add(BOTON7);
	}
	
	@Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        
        if(comando.equals( "CrearProyecto" ))
        {
            String NombreProyecto = JOptionPane.showInputDialog( "Ingrese el nombre del Proyecto" );
            String DescripcionProyecto = JOptionPane.showInputDialog( "Ingrese la descripcion dle proyecto" );
            int DiaInicioProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el dia de inicio del proyecto" ));
            int MesInicioProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el mes de inicio del proyecto" ));
            int AñoInicioProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el año de inicio del Proyecto" ));
            String NombreCreadorProyecto = JOptionPane.showInputDialog( "Ingrese el nombre del creador" );
            String CorreoCreadorProyecto = JOptionPane.showInputDialog( "Ingrese el correo del creador" );
            int DiaFinalProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el dia de final del Proyecto" ));
            int MesFinalProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el mes de final del Proyecto" ));
            int AñoFinalProyecto = Integer.valueOf(JOptionPane.showInputDialog( "Ingrese el año de final del Proyecto" ));
            String tiposProyecto = JOptionPane.showInputDialog( "Ingrese los tipos de actividades aadmitidas en el proyecto" );

            ManejadorProyecto.IniciarProyecto(NombreProyecto, DescripcionProyecto, DiaInicioProyecto, MesInicioProyecto, AñoInicioProyecto, NombreCreadorProyecto, CorreoCreadorProyecto, DiaFinalProyecto, MesFinalProyecto, AñoFinalProyecto, tiposProyecto);
            try {
				ManejadorProyecto.AgregarProyecto();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
				ManejadorProyecto.CrearArchivoReporte();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        }
        
        else if(comando.equals( "AgregarParticipante" ))
        {
        	
            String NombreProyecto = JOptionPane.showInputDialog( "Ingrese el nombre del creador" );
            String DescripcionProyecto = JOptionPane.showInputDialog( "Ingrese la descripcion dle proyecto" );
            
        }
        
        else if(comando.equals( "ReporteGeneral" ))
        {
        	VentanaReporteGeneral ventanaPrincipal;
			try {
				ventanaPrincipal = new VentanaReporteGeneral();
				ventanaPrincipal.setVisible(true);
	    		ventanaPrincipal.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 
    		
        }
        
        
        
    }

}
