package model.entities;

public class Invoice {

	private Double basicPayment;
	private Double tax;
	private Double totalPayment;
	
	public Invoice() {
		
	}

	public Invoice(Double basicPayment, Double tax) {
		super();
		this.basicPayment = basicPayment;
		this.tax = tax;
		this.totalPayment = basicPayment + tax; 
	}

	public Double getBasicPayment() {
		return basicPayment;
	}

	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(Double totalPayment) {
		this.totalPayment = totalPayment;
	}
	
	
}
