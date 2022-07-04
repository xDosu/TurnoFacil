package Utilidad;
/*
 * Clase a cargo de 
 * 
 * @author Matias Sorenson
 * 
 * @date 10/06/2022
 */
public class FechaYHora implements Comparable<FechaYHora>{
	private int anio;
	private int mes;
	private int dia;
	private int hora;
	
	public FechaYHora(int anio, int mes, int dia, int hora) {
		super();
		this.anio = anio;
		if(mes<12)
			this.mes = mes;
		else
			this.mes = 12;
		if(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			if(dia<=31)
				this.dia = dia;
			else this.dia = 31;
			}
		else if(mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			if(dia<=30)
				this.dia = dia;
			else 
				this.dia = 30;
		}
		else
			if(dia<28) 
				this.dia = dia;
			else 
				this.dia = 28;
			
			
		if(hora<23)
			this.hora = hora;
		else
			this.hora = 23;

	}

	@Override
	public String toString() {
		return "(" + anio + "/" + mes + "/" + dia + ") a las " + hora;
	}
	
	public boolean equals(FechaYHora f) {
		return (anio == f.getAnio() && mes == f.getMes() && dia == f.getDia() && hora==f.getHora());
	}
	
	public int compareTo(FechaYHora f) {
		double anio1 = this.anio;
		double mes1 = this.mes;
		double dia1 = this.dia;
		double hora1= this.hora;
		double comparador = anio1 + mes1/13 + dia1/(12*32) + hora1/(12*31*25);
		
		double anio2 = f.getAnio();
		double mes2 =  f.getMes();
		double dia2 =  f.getDia();
		double hora2=  f.getHora();
		double comparador2 = anio2+ mes2/13 + dia2/(12*32) + hora2/(12*31*25);
		
		double aux = comparador - comparador2;
		if (aux > 0) {
			return 1;
		}
		else {
			if (aux == 0) {
				return 0;
			}
			else {
				return -1;
			}
		}
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getHora() {
		return hora;
	}

	public void setHora(int hora) {
		this.hora = hora;
	}
}
