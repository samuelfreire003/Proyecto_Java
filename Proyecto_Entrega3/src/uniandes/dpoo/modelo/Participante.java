package uniandes.dpoo.modelo;

public class Participante 

{
	
	private String nombre;
	
	private String correo;
	
	public Participante(String pnombre, String pcorreo)
	{
		this.nombre = pnombre;
		this.correo = pcorreo;
	
	}
	
	public String getNombre()
	{
		return nombre;
	}
	
	public String getCorreo()
	{
		return correo;
	}
	
	public String toString()
	{
		return nombre + " (" + correo + ")";
	}

}
