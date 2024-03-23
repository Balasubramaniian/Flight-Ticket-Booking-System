package FlightTicket;

public class Passenger {
	static int id=1;
	int PassengerId;
	int fid;
	String PassengerName;
	int ticketsBooking;
	private int ticketprice;
	
	public int getTicketprice() {
		return ticketprice;
	}
	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}
	public Passenger(String passengerName, int ticketsBooking,int fid) {
		PassengerId=id;
		id=id+1;
		PassengerName = passengerName;
		this.ticketsBooking = ticketsBooking;
		this.fid=fid;
	}
	Passenger(){
		
	}

}
