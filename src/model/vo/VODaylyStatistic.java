package model.vo;

public class VODaylyStatistic {
	
	/**
	 * Atributo que da la fecha
	 */
	private String date;
	
	/**
	 * Atributo que da cantidad de accidentes en el d�a.
	 */
	private int cantAccidentes;
	
	/**
	 * Atributo que da la cantidad de infracciones en el d�a.
	 */
	private int cantInfracciones;
	
	/**
	 * Atributo que da el precio total de las infracciones del d�a (FINEAMT)
	 */
	private int totalPagado;
	
	/**
	 * Constructor de la clase.
	 * @param pDate fecha 
	 * @param pCantAccidentes accidentes de la fecha
	 * @param pCantInfracciones infracciones de la fecha
	 * @param pTotalPagado costo total de las infracciones en el d�a
	 */
	public VODaylyStatistic(String pDate, int pCantAccidentes, int pCantInfracciones, int pTotalPagado){
		
		date = pDate;
		cantAccidentes = pCantAccidentes;
		cantInfracciones = pCantInfracciones;
		totalPagado = pTotalPagado;
	}
	/**
	 * Retorna fecha
	 * @return fecha
	 */
	public String darFecha(){
		return date;
	}
	
	/**
	 * Retorna cantidad de accidentes
	 * @return cantidad de accidentes
	 */
	public int darAccidentes(){
		return cantAccidentes;
	}
	
	/**
	 * Retorna cantidad de infracciones.
	 * @return
	 */
	public int darInfracciones(){
		return cantInfracciones;
	}
	
	/**
	 * Retorna precio total de infracciones del d�a
	 * @return total de infracciones
	 */
	public int darCostoInfracciones(){
		return totalPagado;
	}

}
