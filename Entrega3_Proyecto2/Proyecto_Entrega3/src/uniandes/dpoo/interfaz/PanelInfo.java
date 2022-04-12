package uniandes.dpoo.interfaz;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelInfo extends JPanel

{
	private JLabel lblNombreProyecto;
	private JTextField txtNombreProyecto;
	private JLabel lblFechaInicio;
	private JTextField txtFechaInicio;
	private JLabel lblParticipanteInicial;
	private JTextField txtParticipanteInicial;
	private JLabel lblFechaFinal;
	private JTextField txtFechaFinal;
	
	public PanelInfo () 
	{
		setBorder( new TitledBorder ( "Informacion Proyectos" ));
		setLayout( new GridLayout(4, 2));
		
		lblNombreProyecto = new JLabel( " Nombre Proyecto:" );
		txtNombreProyecto = new JTextField( "nombre...." );
		add(lblNombreProyecto);
		add(txtNombreProyecto);
		
		lblFechaInicio = new JLabel( " Fecha Inicio:" );
		txtFechaInicio = new JTextField( "fecha...." );
		add(lblFechaInicio);
		add(txtFechaInicio);
		
		lblParticipanteInicial = new JLabel( " Partici. Inicial:" );
		txtParticipanteInicial = new JTextField( "particpante...." );
		add(lblParticipanteInicial);
		add(txtParticipanteInicial);
		
		lblFechaFinal = new JLabel( " Fecha Final:" );
		txtFechaFinal = new JTextField( "final...." );
		add(lblFechaFinal);
		add(txtFechaFinal);
	}

}
