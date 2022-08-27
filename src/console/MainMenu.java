package console;
import api.HotelResource;
import model1.*;
import service.CustomerService;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainMenu {
    private static CustomerService customerService = new CustomerService();
    private static ReservationService reservationService = new ReservationService();
    public static int exit = 5;
    public static Scanner input;

    public static void displayMenu(){
        System.out.println("Welcome to CRS Hotels Reservation System");
        System.out.println("1.Find and reserve a room");
        System.out.println("2.See my reservations");
        System.out.println("3.Create an account");
        System.out.println("4.Admin");
        System.out.println("5.Exit");
    }

    private static void findAndReserveARoom(){
        // Prepare for date search
        Date checkoutDate = new Date();
        Date checkInDate = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your check in date in DD/MM/YYYY format");
        String checkInString = scanner.next();
        try{
            checkInDate = formatter.parse(checkInString);
        }catch(ParseException e){
            e.printStackTrace();
        }

        System.out.println("Enter your check out date in DD/MM/YYYY format");
        String checkoutString = scanner.next();
        try{
            checkoutDate = formatter.parse(checkoutString);
        }catch(ParseException e){
            e.printStackTrace();
        }

        System.out.println("Available Rooms as below: ");
        System.out.println(HotelResource.findARoom(checkInDate, checkoutDate));

        System.out.println("Enter room number: ");
        String roomNumber = scanner.next();
        IRoom room = HotelResource.getRoom(roomNumber);
        System.out.println(room);
        System.out.println(roomNumber);

        System.out.println("Enter you email: ");
        String email = scanner.next();

        HotelResource.bookARoom(email, room, checkInDate, checkoutDate);
        System.out.println(email + room + checkInDate + checkoutDate);
        System.out.println("Your reservation has been finished");

    }

    public static void seeMyReservation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = scanner.next();
        System.out.println(HotelResource.getCustomersReservations(email));

    }

    public static Customer createAccount() throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your first name: ");
        String firstName = scanner.next();
        System.out.println("Enter your last name: ");
        String lastName = scanner.next();
        System.out.println("Enter your email: ");
        String email = scanner.next();

        HotelResource.createACustomer(email, firstName, lastName);
        return new Customer(firstName, lastName, email);

    }

    public static void mainMenu() throws IllegalAccessException {
        displayMenu();
        input = new Scanner(System.in);
        int choice = input.nextInt();

        while (choice != exit){

            switch(choice){
                case 1:
                    // find and reserve a room
                    System.out.println("Now, let's find and reserve a room");
                    findAndReserveARoom();
                    break;
                case 2:
                    // See my reservations
                    System.out.println("This is your reservation status");
                    seeMyReservation();
                    break;
                case 3:
                    //Create a new account
                    System.out.println("Let's create a new account");
                    createAccount();
                    break;
                case 4:
                    //Admin menu
                    System.out.println("This is admin menu");
                    AdminMenu.startAdmin();
                    return;
                case 5:
                    //exit
                    input.close();
                    System.exit(0);
                default:
                    //User inputs an unexpected choice
                    System.out.println("Incorrect Input");
                    break;
            }
            displayMenu();
            choice = input.nextInt();

        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        mainMenu();
    }
}
