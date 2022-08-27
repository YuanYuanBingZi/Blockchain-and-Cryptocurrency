package api;
import model1.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class AdminResource {
    private static CustomerService customerService = new CustomerService();
    private static ReservationService reservationService = new ReservationService();

    public Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public static void addRoom(String roomNumber, double roomPrice, RoomType roomType){
        reservationService.addRoom(roomNumber, roomPrice, roomType);
        System.out.println("Your room has been Created");
    }

    public Collection<IRoom> getAllRooms(){
        return reservationService.allRooms();
    }

    public Collection<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    public void displayAllReservations(){
        reservationService.printAllReservation();
    }


}
