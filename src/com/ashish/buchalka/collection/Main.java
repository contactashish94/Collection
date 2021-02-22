package com.ashish.buchalka.collection;

public class Main {

	public static void main(String[] args) {
		
		Theatre theatre= new Theatre("PVR", 8, 12);
		
		theatre.getSeats();
		
		if(theatre.reserveSeat("H11")){
			System.out.println("Please Proceed for payment pay");
		} else {
			System.out.println("seat already reserved");
		}
		if(theatre.reserveSeat("H11")){
			System.out.println("Please Proceed for payment pay");
		} else {
			System.out.println("Sorry, seat already reserved!");
		}
		
		theatre.cancelSeat("H11");
		
		if(theatre.reserveSeat("H11")){
			System.out.println("booked after cancellation - Please Proceed for payment pay");
		} else {
			System.out.println("seat already reserved");
		}
		if(theatre.reserveSeat("H11")){
			System.out.println("Please Proceed for payment pay");
		} else {
			System.out.println("seat already reserved");
		}
		
	}

}
