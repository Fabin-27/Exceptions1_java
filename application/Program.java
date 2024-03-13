package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.printf("Room number: ");
		int number = sc.nextInt();
		System.out.printf("Check-in date (dd/MM/yyyy): ");
		Date CheckIn = sdf.parse(sc.next());
		System.out.printf("Check-out date (dd/MM/yyyy): ");
		Date CheckOut = sdf.parse(sc.next());

		if (!CheckOut.after(CheckIn)) { // if check-out não for depois do check-in
			System.out.println("Error in reservation: check-out date must be afte check-in date");
		} else {
			Reservation reservation = new Reservation(number, CheckIn, CheckOut);
			System.out.printf("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");

			System.out.printf("Check-in date (dd/MM/yyyy): ");
			CheckIn = sdf.parse(sc.next());
			System.out.printf("Check-out date (dd/MM/yyyy): ");
			CheckOut = sdf.parse(sc.next());

			String error = reservation.updateDates(CheckIn, CheckOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} 
			else {
				System.out.printf("Reservation: " + reservation);
			}

		}

		sc.close();
	}

}