package uniandes.dpoo.modelo;

public class Fecha 

{
	private int dia;
	
	private int mes;
	
	private int año;
	
	public Fecha(int pdia,int pmes,int paño)
	{
		this.dia = pdia;
		this.mes = pmes;
		this.año = paño;
	}
	
	public int getdia()
	{
		return dia;
	}
	
	public int getmes()
	{
		return mes;
	}
	
	public int getaño()
	{
		return año;
	}
	
	public String toString()
	{
		return dia + "/" + mes + "/" + año;
	}
}
