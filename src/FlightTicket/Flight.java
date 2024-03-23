package FlightTicket;

import java.util.*;
public class Flight {

	static int id;
	int flightid;
	int tickets;
	int price=5000; 
	static ArrayList<Flight> flight=new ArrayList<>(Arrays.asList(new Flight(),new Flight()));
	Flight(){
		id=id+1;
		flightid=id;
		tickets=50;
		price=5000;
	}
	@Override
	public String toString() {
		return "Flight [flightid=" + flightid + ", tickets=" + tickets + ", price=" + price + "]";
	}
	
	
	
}
