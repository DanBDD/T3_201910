package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations {

	private int id;
	
	private String location;
	
	private String date;
	
	private int total;
	
	private String accidentIndicator;
	
	private String description;
	
	public VOMovingViolations(int pId, String pLoc, String pDate, int pTotal, String pIndicator, String pDescription){
		
		id= pId;
		location = pLoc;
		date = pDate;
		total = pTotal;
		accidentIndicator = pIndicator;
		description = pDescription;
	}
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() {
		
		return id;
	}	
	
	
	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {
		
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {
		
		return date;
	}
	
	/**
	 * @return totalPaid - Cuanto dinero efectivamente pagó el que recibió la infracción en USD.
	 */
	public int getTotalPaid() {
		
		return total;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		
		return accidentIndicator;
	}
		
	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {

		return description;
	}
}
