import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketBookingSystem tbs = new TicketBookingSystem(10); // 10 seats

        boolean exit = false;
        while(!exit) {
            System.out.println("\n1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Show All Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    tbs.showAvailableSeats();
                    break;
                case 2:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter seat number: ");
                    int seat = sc.nextInt();
                    sc.nextLine(); // consume newline
                    try {
                        tbs.bookTicket(name, seat);
                    } catch (SeatNotAvailableException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    tbs.showAllBookings();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting Ticket Booking System...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }
        sc.close();
    }
}
