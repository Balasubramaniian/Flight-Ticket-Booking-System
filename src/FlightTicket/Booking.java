package FlightTicket;

import java.util.*;
public class Booking {
    static ArrayList<Passenger> Passengersdetails=new ArrayList<>();
    static ArrayList<Flight> flights=Flight.flight;
	public static void main(String[] args) {
         Scanner sc=new Scanner(System.in);
         boolean ans=true;
		while(ans) {
			System.out.println("1-Book 2-Cancel 3-Display 4 -break");
			int choice =sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("----------------Booking-----------------");
				System.out.println("Enter the FlightId");
				int fid=sc.nextInt();
				if(fid>flights.size()) {
					System.out.println("Flight is Not Found");
				}
					   Addpassenger(fid);
					   break;
					   
			case 2:
				System.out.println("Enter the Passenger Id and Flight Id");
				int passengerid=sc.nextInt();
				int flightid=sc.nextInt();
					if(flightid>flights.size()) {
						System.out.println("Flight Id Not fount");
					}
					if(passengerid>Passengersdetails.size()) {
						System.out.println("Passenger Id Not fount");
					}
					if(flightid>flights.size() && passengerid>Passengersdetails.size()) {
						System.out.println("Flight Id and Passenger Id Not Fount");
					}
////				System.out.println("How many tickets wants to cancel?");
////				int cancel=sc.nextInt();
		        	cancelPassenger(passengerid,flightid);
				    System.out.println("Cancel Successfully");
				break;
			case 3:	
				Display();
				passengerdetails();
				break;
			case 4:
				ans=false;
				break;
			}
		}

	}
	public static void Addpassenger(int fid) {
		Scanner sc=new Scanner(System.in);
		for(Flight flight:flights) {
            if(flight.flightid==fid) {
            	System.out.println("Enter Your Name");
        		String Name=sc.next();
        		System.out.println("Enter the Tickets You Want?");
        		int tickets=sc.nextInt();
        		Passenger passenger=new Passenger(Name,tickets,fid);
            	int ticketprice=tickets*flight.price;
        		passenger.setTicketprice(ticketprice);
            	flight.tickets-=tickets;
            	flight.price+=200;
        		Passengersdetails.add(passenger);
			}
            
		}
		System.out.println("Successfully Booked");
		   passengerdetails();
	}
	
	public static void cancelPassenger(int passengerId, int flightId) {
	    Flight currentFlight = null;
	    for (Flight f : flights) {
	        if (f.flightid == flightId) {
	            currentFlight = f;
	            break;
	        }
	    }

	    if (currentFlight == null) {
	        System.out.println("Flight with ID " + flightId + " not found.");
	        return;
	    }

	    int canceledTickets = 0;
	    Passenger passengerToRemove = null;
	    for (Passenger p : Passengersdetails) {
	        if (p.PassengerId == passengerId) {
	            canceledTickets = p.ticketsBooking;
	            passengerToRemove = p;
	            break;
	        }
	    }

	    if (passengerToRemove != null) {
	        Passengersdetails.remove(passengerToRemove);
	    } else {
	        System.out.println("Passenger with ID " + passengerId + " not found.");
	        return;
	    }

	    currentFlight.tickets += canceledTickets;
	    currentFlight.price -= 200;

	    System.out.println(currentFlight.toString());
	}

	
	public static void Display() {
		for(Flight flight:flights) {
			System.out.println(flight.flightid+" ->");
			System.out.println("Available tickets:"+flight.tickets+" Current Ticket Price: "+flight.price);
		}
	}
	public static void passengerdetails() {
		for(Passenger passenger:Passengersdetails) {
			System.out.println("----------------------------------------");
			System.out.println("Paasenger Id: "+passenger.PassengerId);
			System.out.println("Passenger Name: "+passenger.PassengerName+" Passenger Tickets: "+passenger.ticketsBooking+" TicketPrice: "+passenger.getTicketprice());
			System.out.println("----------------------------------------");
		}
	}

}
