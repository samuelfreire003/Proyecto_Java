package uniandes.dpoo.modelo;

public class Hora 

{
		private int hora;
		
		private int minuto;
		
		public Hora(int phora,int pminuto)
		{
			this.hora = phora;
			this.minuto = pminuto;
		}
		
		public int getHora()
		{
			return hora;
		}
		
		public int getMinuto()
		{
			return minuto;
		}
		
		public String toString()
		{
			return hora + ":" + minuto;
		}
	}
