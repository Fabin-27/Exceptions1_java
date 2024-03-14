package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.printf("Room number: ");
			int number = sc.nextInt();
			System.out.printf("Check-in date (dd/MM/yyyy): ");
			Date CheckIn = sdf.parse(sc.next());
			System.out.printf("Check-out date (dd/MM/yyyy): ");
			Date CheckOut = sdf.parse(sc.next());

			Reservation reservation = new Reservation(number, CheckIn, CheckOut);
			System.out.printf("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.printf("Check-in date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.printf("Check-out date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());

			reservation.updateDates(CheckIn, CheckOut);
			System.out.printf("Reservation: " + reservation);
		}
		
		catch (ParseException e) {
			System.out.println("Invalid date format");
		} 
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error");
		}

		sc.close();
	}

}