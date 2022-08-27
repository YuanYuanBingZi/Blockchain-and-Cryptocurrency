package console;
import api.AdminResource;
import model1.*;
import java.util.*;

public class AdminMenu {
    public static int backToMainMenu = 6;
    public static Scanner input;
    public static AdminResource adminResource;

    public static void displayMenu(){
        System.out.println("Admin Menu");
        System.out.println("1.See all Customers");
        System.out.println("2. See all Rooms");
        System.out.println("3. See all Reservations");
        System.out.println("4. Add a Room");
        System.out.println("5. Back to Main Menu");
    }

    public static void addAHotelRoom(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Room Number: ");
        String roomNumber = scanner.next();
        System.out.println("Enter the Room Type --- Single/Double: ");
        RoomType roomType = RoomType.valueOf(scanner.next());
        System.out.println("Enter the Room Price Per Night: ");
        Double roomPrice = scanner.nextDouble();

        AdminResource.addRoom(roomNumber, roomPrice, roomType);

    }

    public static void startAdmin() throws IllegalAccessException {
        input = new Scanner(System.in);
        int choice = 0;

        while (choice != backToMainMenu){
            switch(choice){
                case 1:
                    System.out.println("You requested to see all customers");
                    System.out.println(adminResource.getAllCustomers());
                    break;
                case 2:
                    System.out.println("You requested to see all rooms");
                    System.out.println(adminResource.getAllRooms());
                    break;
                case 3:
                    System.out.println("You requested to see all reservations");
                    adminResource.displayAllReservations();
                    break;
                case 4:
                    System.out.println("You will add a room to the system");
                    addAHotelRoom();
                    break;
                case 5:
                    MainMenu.mainMenu();
                    return;

            }
            displayMenu();
            choice = input.nextInt();
        }
    }
}
