package model.vo;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations {

	/**
	 * Atributo que da el ID de la infracci髇
	 */
	private int id;
	
	/**
	 * Atributo que da la ubicaci髇 de la infracci髇
	 */
	private String location;
	
	/**
	 * Atributo que da la fecha de la infracci髇
	 */
	private String date;
	
	/**
	 * Atributo que da el total a pagar por infracci髇 (FINEAMT)
	 */
	private int total;
	
	/**
	 * Atributo que da si hubo accidente o no
	 */
	private String accidentIndicator;
	
	/**
	 * Atributo que da la descripci髇 de la infracci髇
	 */
	private String description;
	
	/**
	 * Constructor
	 * @param pId id infracci髇
	 * @param pLoc ubicaci髇 infracci髇
	 * @param pDate fecha infracci髇
	 * @param pTotal total a pagar por infracci髇
	 * @param pIndicator indicador de infracci髇
	 * @param pDescription descripcion de infracci髇
	 */
	public VOMovingViolations(int pId, String pLoc, String pDate, int pTotal, String pIndicator, String pDescription){
		
		id= pId;
		location = pLoc;
		date = pDate;
		total = pTotal;
		accidentIndicator = pIndicator;
		description = pDescription;
	}
	/**
	 * @return id - Identificador 煤nico de la infracci贸n
	 */
	public int objectId() {
		
		return id;
	}	
	
	
	/**
	 * @return location - Direcci贸n en formato de texto.
	 */
	public String getLocation() {
		
		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracci贸n .
	 */
	public String getTicketIssueDate() {
		
		return date;
	}
	
	/**
	 * @return FINEAMT - Cantidad a pagar po la infraccion en USD
	 */
	public int getFineAMT() {
		
		return total;
	}
	
	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {
		
		return accidentIndicator;
	}
		
	/**
	 * @return description - Descripci贸n textual de la infracci贸n.
	 */
	public String  getViolationDescription() {

		return description;
	}
}
