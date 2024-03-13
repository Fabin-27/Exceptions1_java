package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

	private Integer RoomNumber;
	private Date CheckIn;
	private Date CheckOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		RoomNumber = roomNumber;
		CheckIn = checkIn;
		CheckOut = checkOut;
	}

	public Integer getRoomNumber() {
		return RoomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		RoomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return CheckIn;
	}

	public Date getCheckOut() {
		return CheckOut;
	}

	public long duration() {
		long diff = CheckOut.getTime() - CheckIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates (Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (CheckIn.before(now) || CheckOut.before(now)) {
			return "Reservation dates for update must be future dates";
		} 
		if (!CheckOut.after(CheckIn)) {
			return "check-out date must be afte check-in date";
		}
		this.CheckIn = checkIn;
		this.CheckOut = checkOut;
		
		return null; // criterio para falar que a minha operação não deu nenhum erro 
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ RoomNumber 
				+ ", Check-in: " 
				+ sdf.format(CheckIn) 
				+ ", Chek-out: " 
				+ sdf.format(CheckOut) 
				+ ", " 
				+ duration()
				+" nights";
	}

}