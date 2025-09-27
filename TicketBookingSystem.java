import java.util.HashMap;
import java.util.Map;

public class TicketBookingSystem {
    private Map<Integer, String> seats; // seat number -> customer name
    private int totalSeats;

    public TicketBookingSystem(int totalSeats) {
        this.totalSeats = totalSeats;
        seats = new HashMap<>();
    }

    // Book a ticket
    public void bookTicket(String name, int seatNumber) throws SeatNotAvailableException {
        if(seatNumber < 1 || seatNumber > totalSeats) {
            throw new SeatNotAvailableException("Seat number " + seatNumber + " is invalid!");
        }
        if(seats.containsKey(seatNumber)) {
            throw new SeatNotAvailableException("Seat number " + seatNumber + " is already booked!");
        }
        seats.put(seatNumber, name);
        System.out.println("Ticket booked successfully for " + name + " at seat " + seatNumber);
    }

    // Show available seats
    public void showAvailableSeats() {
        System.out.println("Available Seats:");
        for(int i=1; i<=totalSeats; i++) {
            if(!seats.containsKey(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Show all bookings
    public void showAllBookings() {
        System.out.println("Booked Tickets:");
        if(seats.isEmpty()) {
            System.out.println("No tickets booked yet.");
        } else {
            seats.forEach((seat, name) -> System.out.println("Seat " + seat + ": " + name));
        }
    }
}
