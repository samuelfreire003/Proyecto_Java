package uniandes.dpoo.interfaz;

import java.awt.BorderLayout;
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
import javax.swing.JTextPane;

import uniandes.dpoo.procesamiento.ManejadorProyecto;

public class PanelCreacionParticipante extends JPanel implements ActionListener

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
	
	public PanelCreacionParticipante()
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
		
		lblpreedifinicion = new JLabel( "Porfavor seleccione la caja si desea preedefinir la fecha y hora inicial actual " );
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
		
		BtnCrear = new JButton( "Crear y Guardar Registro" );
		BtnCrear.addActionListener( this );
		BtnCrear.setActionCommand( "CrearRegistro" );
		add(BtnCrear);
		
		
		
	}
	
	@Override
    public void actionPerformed( ActionEvent e )
    {
		String comando = e.getActionCommand( );

		if(comando.equals( "CrearRegistro" ))
        {
			String TituloActividad = txtTituloActividad.getText();
			String DescripcionActividad = txtDescripcionActividad.getText();
			String TipoActividad = txtTipoActividad.getText();
			String NombreCreador = txtNombreCreador.getText();
			String CorreoCreador = txtCorreoCreador.getText();
			int HoraFinal = Integer.valueOf(txtHoraFinal.getText());
			int MinutoFinal = Integer.valueOf(txtMinutoFinal.getText());
			
			if(cajapre.isSelected() == true)
			{
				LocalDateTime locaDate = LocalDateTime.now();
				int HoraInicioActividad  = locaDate.getHour();
				int MinutoInicioActividad = locaDate.getMinute();
				
				Calendar fecha = Calendar.getInstance();
				int AñoInicioActividad = fecha.get(Calendar.YEAR);
		        int MesInicioActividad = fecha.get(Calendar.MONTH) + 1;
		        int DiaInicioActividad = fecha.get(Calendar.DAY_OF_MONTH);
		        
				ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicioActividad,MesInicioActividad,AñoInicioActividad,HoraInicioActividad,MinutoInicioActividad,HoraFinal,MinutoFinal,NombreCreador,CorreoCreador);
			}
			
			else if(cajapre.isSelected() == false)
			{
				
				int HoraInicio= Integer.valueOf(txtHoraInicio.getText());
				int MinutoInicio = Integer.valueOf(txtMinutoInicio.getText());
				int DiaInicio = Integer.valueOf(txtDiaInicio.getText());
				int MesInicio = Integer.valueOf(txtMeaInicio.getText());
				int AñoInicio = Integer.valueOf(txtAñoInicio.getText());
				
				ManejadorProyecto.CrearRegistro(TituloActividad,DescripcionActividad,TipoActividad,DiaInicio,MesInicio,AñoInicio,HoraInicio,MinutoInicio,HoraFinal,MinutoFinal,NombreCreador,CorreoCreador);
				
			}
			
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
