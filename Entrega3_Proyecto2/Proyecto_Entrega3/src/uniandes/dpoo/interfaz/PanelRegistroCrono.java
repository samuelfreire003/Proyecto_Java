package uniandes.dpoo.interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import uniandes.dpoo.procesamiento.ManejadorProyecto;

public class PanelRegistroCrono extends JPanel implements ActionListener


{
	
	private JLabel lblTituloActividad;
	private JTextField txtTituloActividad;
	private JLabel lblDescripcionActividad;
	private JTextField txtDescripcionActividad;
	private JLabel lblTipoActividad;
	private JTextField txtTipoActividad;
	private JLabel lblNombreCreador;
	private JTextField txtNombreCreador;
	private JLabel lblCorreoCreador;
	private JTextField txtCorreoCreador;
	private JLabel lblpreedifinicion;
	private JCheckBox cajapre;
	private JLabel lblHoraInicio;
	private JTextField txtHoraInicio;
	private JLabel lblMinutoInicio;
	private JTextField txtMinutoInicio;
	private JLabel lblDiaInicio;
	private JTextField txtDiaInicio;
	private JLabel lblMeaInicio;
	private JTextField txtMeaInicio;
	private JLabel lblAñoInicio;
	private JTextField txtAñoInicio;
	private JLabel lblHoraFinal;
	private JTextField txtHoraFinal;
	private JLabel lblMinutoFinal;
	private JTextField txtMinutoFinal;
	private JButton BtnCrear;
	
	public PanelRegistroCrono()
	{
		setLayout( new GridLayout(14,2));
		
		lblTituloActividad = new JLabel( "Tittulo de la Actividad" );
		add(lblTituloActividad);	
		txtTituloActividad = new JTextField();
		add(txtTituloActividad);
		
		lblDescripcionActividad = new JLabel( "Descripcion de la actividad" );
		add(lblDescripcionActividad);	
		txtDescripcionActividad = new JTextField();
		add(txtDescripcionActividad);
		
		lblTipoActividad = new JLabel( "Tipo Actividad" );
		add(lblTipoActividad);	
		txtTipoActividad = new JTextField();
		add(txtTipoActividad);
		
		lblNombreCreador = new JLabel( "Nombre Creador" );
		add(lblNombreCreador);	
		txtNombreCreador = new JTextField();
		add(txtNombreCreador);
		
		lblCorreoCreador = new JLabel( "Correo Creador" );
		add(lblCorreoCreador);	
		txtCorreoCreador = new JTextField();
		add(txtCorreoCreador);
		
		lblpreedifinicion = new JLabel( "Porfavor seleccione la caja si desea preedefinir la fecha actual " );
		add(lblpreedifinicion);
		
		cajapre = new JCheckBox();
		add(cajapre);
		
		lblHoraInicio = new JLabel( "Hora Inicio Actividad (formato 24 horas)" );
		add(lblHoraInicio);	
		txtHoraInicio = new JTextField();
		add(txtHoraInicio);
		
		lblMinutoInicio = new JLabel( "Minuto Inicio Actividad" );
		add(lblMinutoInicio);	
		txtMinutoInicio = new JTextField();
		add(txtMinutoInicio);
		
		lblDiaInicio = new JLabel( "Dia Inicio Actividad" );
		add(lblDiaInicio);	
		txtDiaInicio = new JTextField();
		add(txtDiaInicio);
		
		lblMeaInicio = new JLabel( "Mes Inicio Actividad" );
		add(lblMeaInicio);	
		txtMeaInicio = new JTextField();
		add(txtMeaInicio);
		
		lblAñoInicio = new JLabel( "Año Inicio Actividad" );
		add(lblAñoInicio);	
		txtAñoInicio = new JTextField();
		add(txtAñoInicio);
		
		lblHoraFinal = new JLabel( "Hora final (formato 24 horas)" );
		add(lblHoraFinal);	
		txtHoraFinal = new JTextField();
		add(txtHoraFinal);
		
		lblMinutoFinal = new JLabel( "Minuto final" );
		add(lblMinutoFinal);	
		txtMinutoFinal = new JTextField();
		add(txtMinutoFinal);
		
		BtnCrear = new JButton( "Empezar a cronometrar" );
		BtnCrear.addActionListener( this );
		BtnCrear.setActionCommand( "CrearRegistrocrono" );
		add(BtnCrear);
		
		
		
	}
	
	@Override
    public void actionPerformed( ActionEvent e )
    {
		String comando = e.getActionCommand( );

		if(comando.equals( "CrearRegistrocrono" ))
        {
			String TituloActividad = txtTituloActividad.getText();
			String DescripcionActividad = txtDescripcionActividad.getText();
			String TipoActividad = txtTipoActividad.getText();
			String NombreCreador = txtNombreCreador.getText();
			String CorreoCreador = txtCorreoCreador.getText();
			int AñoInicio = 0;
	        int MesInicio = 0;
	        int DiaInicio = 0;
	        
	        int HoraFinal = 0;
	        int MinutoFinal = 0;
			
			LocalDateTime locaDate = LocalDateTime.now();
			int HoraInicio  = locaDate.getHour();
			int MinutoInicio = locaDate.getMinute();
			
			if(cajapre.isSelected() == true)
			{
				
				Calendar fecha = Calendar.getInstance();
				AñoInicio = fecha.get(Calendar.YEAR);
				MesInicio = fecha.get(Calendar.MONTH) + 1;
				DiaInicio = fecha.get(Calendar.DAY_OF_MONTH);
		        
			}
			
			else if(cajapre.isSelected() == false)
			{
				
				DiaInicio = Integer.valueOf(txtDiaInicio.getText());
				MesInicio = Integer.valueOf(txtMeaInicio.getText());
				AñoInicio = Integer.valueOf(txtAñoInicio.getText());
				
			}
			
			String[] options = {"PARAR", "FINALIZAR"};

	        int x = JOptionPane.showOptionDialog(null, "Marque una de estas opciones, teniendo en cuenta que el tiempo en el que marque es el que se almacena",
	                "Click a button",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        
	        if (x == 0)
	        {
	        	LocalDateTime locaDateparar = LocalDateTime.now();
				int tiempodesdeinicioHoras = (locaDateparar.minusHours(HoraInicio)).getHour();
				int tiempodesdeinicioMinutos = (locaDateparar.minusMinutes(MinutoInicio)).getMinute();
				
				String[] options2 = {"Continuar"};

		        int x2 = JOptionPane.showOptionDialog(null, "Marque una de estas opciones, teniendo en cuenta que el tiempo en el que marque es el que se almacena",
		                "Click a button",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
				if (x2 == 0)
				{
					LocalDateTime locaDateContinuar = LocalDateTime.now();
					int horascontinuar = locaDateContinuar.getHour();
					int Minutoscontinuar = locaDateContinuar.getMinute();
					
					String[] options3 = {"FINALIZAR"};

			        int x3 = JOptionPane.showOptionDialog(null, "Marque una de estas opciones, teniendo en cuenta que el tiempo en el que marque es el que se almacena",
			                "Click a button",
			                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options3, options3[0]);
					if (x3 == 0)	
					{
						LocalDateTime locaDatefiNALcontinuar = LocalDateTime.now();
						int tiempodesdefinalHoras = (locaDatefiNALcontinuar.minusHours(horascontinuar)).getHour();
						int tiempodesdefinalMinutos = (locaDatefiNALcontinuar.minusMinutes(Minutoscontinuar)).getMinute();
						
						int horasactivas = tiempodesdeinicioHoras + tiempodesdefinalHoras;
						int minutosactivas = tiempodesdeinicioMinutos + tiempodesdefinalMinutos;
						
						HoraFinal  = (locaDate.plusHours(horasactivas)).getHour();
						MinutoFinal = (locaDate.plusMinutes(minutosactivas)).getMinute();
						
					}
				}
	        }
	        
	        else if(x == 1)
	        {
					LocalDateTime locaDatefiNAL = LocalDateTime.now();
					HoraFinal  = locaDatefiNAL.getHour();
					MinutoFinal = locaDatefiNAL.getMinute();
					
	        }
	        
	        ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicio,MesInicio,AñoInicio,HoraInicio,MinutoInicio,HoraFinal,MinutoFinal,NombreCreador,CorreoCreador);

			
			List<String> ProyectoCreados;
			try {
				ProyectoCreados = ManejadorProyecto.CargarProyectos();
				int opcion = PanelInfoProyectos.Obteneropcion();
				
				if (opcion == -1)
				{
					JOptionPane.showMessageDialog(BtnCrear, "Porfavor seleccione un proyecto, de la lista de la pantalla prinicipal de la izquirda, para guardar el registro");
				}
				String proyecto = ProyectoCreados.get(opcion);
				ManejadorProyecto.GuardarReporte(proyecto);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
        }
    }

}

