package api;
import model1.*;
import service.CustomerService;
import service.ReservationService;

import java.util.*;

public class HotelResource {
    private static CustomerService customerService = new CustomerService();
    private static ReservationService reservationService = new ReservationService();

    public static Customer getCustomer(String email){
        return customerService.getCustomer(email);
    }

    public static void createACustomer(String email, String firstName, String lastName) throws IllegalAccessException {
        customerService.addCustomer(email, firstName, lastName);
        System.out.println("Successful! Your account has been created!");
    }

    public static IRoom getRoom(String roomNumber){
        return reservationService.getARoom(roomNumber);
    }

    public static Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkoutDate){
        return reservationService.reserveARoom(getCustomer(customerEmail), room, checkInDate, checkoutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        return reservationService.getCustomersReservation(getCustomer(customerEmail));
    }

    public static Collection<IRoom> findARoom(Date checkIn, Date checkOut){
        return reservationService.findRooms(checkIn, checkOut);
    }
}
