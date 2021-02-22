package com.ashish.buchalka.collection;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
	
	private final String  theatreName;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<Seat> seats = new ArrayList();
	
	public void getSeats() {
		for (Seat seat : seats) {
			System.out.println(seat.getSeatNumber());
		}
	}


	public Theatre(String theatreName, int numRows, int seatsPerRow){
		this.theatreName = theatreName;
		int lastRow = 'A' + (numRows-1);
		
		for(char row = 'A'; row <= lastRow; row++ ) {
			for(int seatNum = 1; seatNum <= seatsPerRow ;seatNum++){
				Seat seat = new Seat(row + String.format("%02d", seatNum));
				seats.add(seat);
			}
		}
	}
	
	
	public String getTheatreName() {
		return theatreName;
	}
	
	public boolean reserveSeat(String seatNumber) {
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			if(seat.getSeatNumber().equals(seatNumber)){
				requestedSeat = seat;
				break;
			}
		}
		if (requestedSeat == null) {
			System.out.println("There is no seat" + seatNumber);
			return false;
		}
		
		return requestedSeat.reserve();
	}
	
	public boolean cancelSeat(String seatNumber) {
		Seat requestedSeat = null;
		
		for (Seat seat : seats) {
			if(seat.getSeatNumber().equals(seatNumber)){
				requestedSeat = seat;
				//break;
			}
		}
		if (requestedSeat == null) {
			System.out.println("There is no seat" + seatNumber);
			//return false;
		}
		
		//return requestedSeat.reserve();
		return requestedSeat.cancel();
	}
	
	private class Seat{
		
		private final String seatNumber;
		
		private boolean reserved = false;
		
		public Seat(String seatNumber){
			this.seatNumber = seatNumber;
		}

		public boolean reserve() {
			if(!this.reserved){
				this.reserved = true;
				System.out.println("Seat reserved - - - " + seatNumber);
				return true;
			}else {
				return false;
			}
		}
		
		public boolean cancel() {
			if(this.reserved){
				this.reserved = false;
				System.out.println("Seat Number Reservation Cancelled --- " + seatNumber);
				return true;
			} else{
				return false;
			}
		}

		public String getSeatNumber() {
			return seatNumber;
		}
	}
}













