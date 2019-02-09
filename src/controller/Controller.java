package controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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
			CSVReader lector = new CSVReader(new FileReader(ruta1));
			String[] nextLineQueue = lector.readNext();
			while((nextLineQueue = lector.readNext()) != null){
				String id = nextLineQueue[0];
				int idObjeto = Integer.parseInt(id);
				String location = nextLineQueue[2];
				String fecha = nextLineQueue[14];
				String total = nextLineQueue[9];
				int totalObjeto = Integer.parseInt(total);
				String indicator = nextLineQueue[12];
				String description = nextLineQueue[15];
				movingViolationsQueue.enqueue(new VOMovingViolations(idObjeto, location, fecha, totalObjeto, indicator, description));
				movingViolationsStack.push(new VOMovingViolations(idObjeto, location, fecha, totalObjeto, indicator, description));
			}
			
			CSVReader lector2 = new CSVReader(new FileReader(ruta2));
			String[] nextLineStack = lector2.readNext();
			while((nextLineStack = lector2.readNext()) != null){
				String id = nextLineStack[0];
				int idObjeto = Integer.parseInt(id);
				String location = nextLineStack[2];
				String fecha = nextLineStack[14];
				String total = nextLineStack[9];
				int totalObjeto = Integer.parseInt(total);
				String indicator = nextLineStack[12];
				String description = nextLineStack[15];
				movingViolationsQueue.enqueue(new VOMovingViolations(idObjeto, location, fecha, totalObjeto, indicator, description));
				movingViolationsStack.push(new VOMovingViolations(idObjeto, location, fecha, totalObjeto, indicator, description));
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
	public IQueue <VODaylyStatistic> getDailyStatistics () {
		Cola<VODaylyStatistic> cola = new Cola<VODaylyStatistic>();
		
		return cola;
	}
	
	public IStack <VOMovingViolations> nLastAccidents(int n) {
		Pila<VOMovingViolations> pila = new Pila<VOMovingViolations>();
		
		return pila;
	}
}
