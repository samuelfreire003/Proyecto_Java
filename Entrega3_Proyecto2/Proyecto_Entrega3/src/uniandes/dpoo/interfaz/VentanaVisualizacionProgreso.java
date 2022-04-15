package uniandes.dpoo.interfaz;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import uniandes.dpoo.procesamiento.ManejadorProyecto;
import uniandes.dpoo.procesamiento.ManejadorRegistro;

public class VentanaVisualizacionProgreso extends JFrame

{
	
	@SuppressWarnings("removal")
	public VentanaVisualizacionProgreso () throws FileNotFoundException, IOException
	{
		
		setSize( 700, 500 );
		
		List<String> ProyectoCreados = ManejadorProyecto.CargarProyectos();
		
		int opcion = PanelInfoProyectos.Obteneropcion();
		String proyecto = ProyectoCreados.get(opcion);
		Map<String, Map<String, String>> registrosDia = ManejadorRegistro.CargarRegistrosTiempoDia(proyecto);
		
		Collection<Map<String, String>> valoresmapa = registrosDia.values();
		
		Map<String, String> mapafinal = new HashMap<String, String>();
		
		for (Map<String, String> mapainternoparticipantes : valoresmapa)
		{
			
			Set<String> llavesmapadia = mapainternoparticipantes.keySet();
			
			for (String llavedia : llavesmapadia)
			{
				String tiempo = mapafinal.get(llavedia);
				
				if ( tiempo == null )
				{
					mapafinal.put(llavedia, mapainternoparticipantes.get(llavedia));
				}
				else if ( tiempo != null )
				{
					String TiempoNuevo = String.valueOf(Integer.valueOf(tiempo) + Integer.valueOf(mapainternoparticipantes.get(llavedia)));
					mapafinal.put(llavedia, TiempoNuevo);
				}
			}
			
			
		}
		
		String title = "Progreso del proyecto por dias";
	    Integer[] values = new Integer[(mapafinal.values()).size()];
	    String[] labels = new String[(mapafinal.keySet()).size()];
	    
	    int i = 0;
	    for (String valor : mapafinal.values())
        {
	    	
	    	values[i] = new Integer(Integer.valueOf(valor));
	    	i += 1;
	    	
        }
	    
	    int j = 0;
	    for (String llave : mapafinal.keySet())
        {
	    	
	    	labels[j] = new String(llave);
	    	j += 1;
	    	
        }
	    
	    Diagramabarra bc = new Diagramabarra(values, labels, title);
	 
	    add(bc);
	    setVisible(true);
		
		setTitle( "Visualizacion" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo( null );
	}

}