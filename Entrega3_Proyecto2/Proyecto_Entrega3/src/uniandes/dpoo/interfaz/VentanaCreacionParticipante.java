package uniandes.dpoo.interfaz;

import javax.swing.JFrame;

public class VentanaCreacionParticipante extends JFrame

{
	
	private PanelCreacionParticipante panelcreacionparticipantel;
	
	public VentanaCreacionParticipante()
	{
		setSize( 900, 400 );
		setTitle( "Ventana Creacion Participante" );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo( null );
		
		panelcreacionparticipantel = new  PanelCreacionParticipante();
		add(panelcreacionparticipantel);
	}

}
