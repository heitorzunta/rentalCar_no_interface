package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private Double pricePerHour;
	private Double pricePerDay;
	
	private BrazilTaxService brasilTaxService;
	
	public RentalService(Double pricePerHour, Double pricePerDay, BrazilTaxService brasilTaxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.brasilTaxService = brasilTaxService;
	}


	public void processInvoice(CarRental carRental) {
		
		long timeTotal = carRental.getFinish().getTime() - carRental.getStart().getTime();
		double hours = (double) timeTotal /1000 /60 /60;
		double basicPayment;
		
		if(hours <= 12) 
			basicPayment = Math.ceil(hours) * pricePerHour;		
		
		else
			basicPayment = Math.ceil(hours/24) * pricePerDay;
		
		double tax = brasilTaxService.tax(basicPayment);
		
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
		
	}

}
