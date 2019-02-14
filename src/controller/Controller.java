package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import com.opencsv.CSVReader;

import model.data_structures.Cola;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Pila;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import view.MovingViolationsManagerView;

public class Controller {
 
	private MovingViolationsManagerView view;
	
	/**
	 * Cola donde se van a cargar los datos de los archivos
	 */
	private IQueue<VOMovingViolations> movingViolationsQueue;
	
	/**
	 * Pila donde se van a cargar los datos de los archivos
	 */
	private IStack<VOMovingViolations> movingViolationsStack;

	/**
	 * Ruta para el archivo con los datos de Febrero
	 */
	private static final String ruta1 = "./data/Moving_Violations_Issued_in_February_2018_ordered.csv";
	
	/**
	 * Ruta para el archivo con los datos de Enero
	 */
	private static final String ruta2 = "./data/Moving_Violations_Issued_in_January_2018_ordered.csv";
	
	public Controller() {
		view = new MovingViolationsManagerView();
		
		//TODO, inicializar la pila y la cola
		movingViolationsQueue = new Cola<>();
		movingViolationsStack = new Pila<>();
	}
	
	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin = false;
		
		while(!fin)
		{
			view.printMenu();
			
			int option = sc.nextInt();
			
			switch(option)
			{
				case 1:
					this.loadMovingViolations();
					break;
					
				case 2:
					IQueue<VODaylyStatistic> dailyStatistics = this.getDailyStatistics();
					view.printDailyStatistics(dailyStatistics);
					break;
					
				case 3:
					view.printMensage("Ingrese el número de infracciones a buscar");
					int n = sc.nextInt();

					IStack<VOMovingViolations> violations = this.nLastAccidents(n);
					view.printMovingViolations(violations);
					break;
											
				case 4:	
					fin=true;
					sc.close();
					break;
			}
		}
	}

	

	public void loadMovingViolations() {
		
		try {
			CSVReader lector = new CSVReader(new FileReader(ruta2));
			String[] nextLineR1 = lector.readNext();
			while((nextLineR1 = lector.readNext()) != null){
				String id = nextLineR1[0];
				int idObjeto = Integer.parseInt(id);
				String location = nextLineR1[2];
				String fecha = nextLineR1[13];
				String fechaFormato = formatearFecha(fecha);
				String total = nextLineR1[8];
				int totalObjeto = Integer.parseInt(total);
				String indicator = nextLineR1[12];
				String description = nextLineR1[15];
				movingViolationsQueue.enqueue(new VOMovingViolations(idObjeto, location, fechaFormato, totalObjeto, indicator, description));
				movingViolationsStack.push(new VOMovingViolations(idObjeto, location, fechaFormato, totalObjeto, indicator, description));
				
			}
			lector.close();
			CSVReader lector2 = new CSVReader(new FileReader(ruta1));
			String[] nextLineR2 = lector2.readNext();
			while((nextLineR2 = lector2.readNext()) != null){
				String id = nextLineR2[0];
				int idObjeto = Integer.parseInt(id);
				String location = nextLineR2[2];
				String fecha = nextLineR2[13];
				String fechaFormato = formatearFecha(fecha);
				String total = nextLineR2[8];
				int totalObjeto = Integer.parseInt(total);
				String indicator = nextLineR2[12];
				String description = nextLineR2[15];
				movingViolationsQueue.enqueue(new VOMovingViolations(idObjeto, location, fechaFormato, totalObjeto, indicator, description));
				movingViolationsStack.push(new VOMovingViolations(idObjeto, location, fechaFormato, totalObjeto, indicator, description));
				
			}
			lector2.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public IQueue <VODaylyStatistic> getDailyStatistics () {
		
		Cola<VODaylyStatistic> cola = new Cola<VODaylyStatistic>();
		Iterator<VOMovingViolations> it = movingViolationsQueue.iterator();
		
		String fecha = null;
		int totalAccidentes = 0;
		int totalInfracciones = 0;
		int totalPagarDia = 0;
		
		while(it.hasNext()){
			
			VOMovingViolations actual = it.next();
			totalInfracciones++;
			
			if(fecha == null){
				
				fecha = actual.getTicketIssueDate();
			}
			
			if(fecha.equals(formatearFecha(actual.getTicketIssueDate()))){
				totalPagarDia += actual.getFineAMT();
				if(actual.getAccidentIndicator().equals("Yes")){
					totalAccidentes++;
				}
				
			}
			
			else{
				
				cola.enqueue(new VODaylyStatistic(fecha, totalAccidentes, totalInfracciones, totalPagarDia));
				fecha = actual.getTicketIssueDate();

				totalPagarDia = 0;
				totalAccidentes = 0;
				
				if(actual.getAccidentIndicator().equals("Yes")){
					totalAccidentes = 1;
				}

				totalInfracciones = 1;
				totalPagarDia += actual.getFineAMT();
			}
		}
		
		if(fecha != null){
			
			cola.enqueue(new VODaylyStatistic(fecha, totalAccidentes, totalInfracciones, totalPagarDia));
		}
		return cola ;
	}
	
	public IStack<VOMovingViolations> nLastAccidents(int n) {
		IStack<VOMovingViolations> pila = new Pila<VOMovingViolations>();
		Iterator<VOMovingViolations> it = movingViolationsStack.iterator();
		int cont = 0;
		
		while(it.hasNext() && cont<n){
			VOMovingViolations actual = it.next();
			if(actual.getAccidentIndicator().equals("Yes")){
				pila.push(actual);
				cont++;
			}
		}

		return pila;
	}
	
	public String formatearFecha(String pFecha){
		
		String fechaFormateada = pFecha.substring(0,10);
		
		return fechaFormateada;
	}
}
