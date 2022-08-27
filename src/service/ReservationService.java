package service;
import model1.*;
import java.util.*;


public class ReservationService {
    private static ReservationService reservation = null;
    public ReservationService() {};

    //adding static reference
    public static ReservationService getInstance(){
        if (reservation == null){
            reservation = new ReservationService();
        }
        return reservation;
    }
    private Collection<IRoom> rooms = new HashSet<>();
    private Collection<Reservation> reservations = new HashSet<>();
    public void addRoom(String roomNumber, Double price, RoomType roomType){
        Room room = new Room(roomNumber, price, roomType);
        rooms.add(room);
    }

    public IRoom getARoom(String roomNumber){
        for(IRoom room: rooms){
            if (roomNumber.equals(room.getRoomNumber())){
                return room;
            }
        }
        return null;
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkoutDate){
        Reservation reservation = new Reservation(customer, room, checkInDate, checkoutDate);
        reservations.add(reservation);
        return reservation;
    }

    public List<IRoom> findRooms(Date checkInDate, Date checkoutDate){
        boolean found = false;
        List<IRoom> findAvailableRooms = new ArrayList<>();
        for(IRoom room: rooms){
            for(Reservation reservation: reservations){
                if((room.getRoomNumber() == reservation.getRoom().getRoomNumber())
                        && ((!checkInDate.after(reservation.getCheckInDate())) &&
                        !checkoutDate.before(reservation.getCheckoutDate()))){
                    findAvailableRooms.add(room);
                }
            }
        }
        return findAvailableRooms;
    }

    public List<Reservation> getCustomersReservation(Customer customer){
        List<Reservation> reservationByCustomer = new ArrayList<>();
        for(Reservation reservation: reservations){
            if(reservation.getCustomer().equals(customer)){
                reservationByCustomer.add(reservation);
            }
        }
        return reservationByCustomer;
    }

    public Collection<Reservation> getAllReservations(){
        return reservations;
    }

    public void printAllReservation(){
        if(reservations.isEmpty()){
            System.out.println("No reservation found.");
        } else{
            for (Reservation reservation: reservations){
                System.out.println(reservation + "\n");
            }
        }

    }
    public Collection<IRoom> allRooms(){
        return rooms;
    }




}
