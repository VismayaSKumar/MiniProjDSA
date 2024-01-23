import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BusReservation{

    private static final int TOTAL_SEATS = 20;
    private static List<Integer> availableSeats;
    private static Map<Integer, String> reservations;
    
    public static void main(String[] args) {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                Welcome to Bus reservation system                        ");
        System.out.println("----------------------------------------------------------------------");

        Scanner sc = new Scanner(System.in);
        
        address();
        initializeSeats();

        while(true){

        displayMenu();
        int choice=sc.nextInt();
        switch(choice){
            case 1:
            showAvailableSeats();
            break;

            case 2:
            reserveSeat(sc);
            break;

            case 3:
            cancelReservation(sc);
            break;

            case 4:
                    System.out.println("\n----------------------- Thankyou ---------------------------- ");
                    System.out.println("                    Hope to see you again                   ");
                    System.exit(0);
            break;

            default:
            System.out.println("--------------------------------------------");
            System.out.println("Invalid choice. Enter the right option !!");
            System.out.println("--------------------------------------------");                
            }
        }
    }

 private static void displayMenu() {

    System.out.println("1. Show Available Seats");
    System.out.println("2. Reserve a Seat");
    System.out.println("3. Cancel Reservation");
    System.out.println("4. Exit");
    System.out.print("Enter your choice: ");
}

    private static void address() {

        System.out.print("From address :");
        Scanner sc=new Scanner(System.in);
        String from=sc.nextLine();
        System.out.print("To address :");
        String to= sc.nextLine();
        System.out.println("--------------------------------------------------");
        System.out.println("  The bus from "+from+" to "+to+" is your choice");
        System.out.println("--------------------------------------------------");
        
    }

     private static void initializeSeats() {
        availableSeats = new ArrayList<>();
        reservations = new HashMap<>();

        for (int i = 1; i <= TOTAL_SEATS; i++) {
            availableSeats.add(i);
        }
    }

     private static void showAvailableSeats() {
         System.out.println("--------------------------------------------------------------------------------------------");
         System.out.println("Available Seats: " + availableSeats);
         System.out.println("--------------------------------------------------------------------------------------------");
        }

     private static void reserveSeat(Scanner sc) {
        if (availableSeats.isEmpty()) {
            System.out.println("----------------------------------------------------");
            System.out.println("Sorry, the bus is fully booked. No available seats.");
            System.out.println("-----------------------------------------------------");
        } else {
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.println("Available Seats: " + availableSeats);
            System.out.println("-----------------------------------------------------------------------------------------------");
            System.out.print("Enter the seat number you want to reserve: ");
            int seatNumber = sc.nextInt();
            if (!availableSeats.contains(seatNumber))
            {
            System.out.println("---------------------------------------------------------------------------");
            System.out.println("Seat already booked");
            System.out.println("--------------------------------------------------------------------------");
        }
            else{
            System.out.println("To proceed your booking process,");
            System.out.print("Enter your name: ");
            String passengerName = sc.next();
            System.out.print("Enter your email id:");
            String passengerEmail = sc.next();
        
        System.out.println("---------------------------------------------------------------------");
            if (availableSeats.contains(seatNumber)) {
                availableSeats.remove(Integer.valueOf(seatNumber));
                reservations.put(seatNumber, passengerName);
                System.out.println("Seat " + seatNumber + " reserved for " + passengerName + ", through the email "+passengerEmail);
        } 
    
        else {
                System.out.println("---------------------------------------------------------------");
                System.out.println("Invalid seat number. Please choose an available seat.");
        }
        System.out.println("-----------------------------------------------------------------------");
    }
}
     }

private static void cancelReservation(Scanner sc) {
    System.out.print("Enter the seat number to cancel the reservation: ");
    int seatNumber = sc.nextInt();
    System.out.println("-----------------------------------------------------------------------");
    if (reservations.containsKey(seatNumber)) {
        String passengerName = reservations.remove(seatNumber);
        availableSeats.add(seatNumber);
        System.out.println("Reservation for seat " + seatNumber + " (Passenger: " + passengerName + ") canceled.");
    } else {
        System.out.println("Invalid seat number. No reservation found.");
    }
    System.out.println("-------------------------------------------------------------------------");
  }
}