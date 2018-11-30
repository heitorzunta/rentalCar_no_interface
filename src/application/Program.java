package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxService;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {


			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
		try {	
			System.out.println("Enter rendal data");
			System.out.print("Car model: ");
			String model = sc.nextLine();
			System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
			Date start = sdf.parse(sc.nextLine());
			System.out.print("Return (dd/MM/yyyy hh:ss): ");
			Date finish = sdf.parse(sc.nextLine());
		
			System.out.print("Enter price per hour: ");
			double pricePerHour = sc.nextDouble();
			System.out.print("Enter price per day: ");
			double pricePerDay= sc.nextDouble();
			
			CarRental rental = new CarRental(start, finish, new Vehicle(model));
			
			RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
			
			rentalService.processInvoice(rental);
			
			StringBuilder sb = new StringBuilder();
			sb.append("\nINVOICE\n");
			sb.append("Basic payment: ");
			sb.append(String.format("%.2f", rental.getInvoice().getBasicPayment()));
			sb.append("\n");
			sb.append("Tax: " );
			sb.append(String.format("%.2f", rental.getInvoice().getTax()));
			sb.append("\n");
			sb.append("Total payment: ");
			sb.append(String.format("%.2f", rental.getInvoice().getTotalPayment()));
			
			System.out.println(sb);
		}
		
		catch (ParseException error) {
			System.out.println(error.getMessage());
		}
		
		sc.close();	

	}
}
