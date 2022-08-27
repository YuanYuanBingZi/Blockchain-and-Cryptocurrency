package model1;
import java.util.*;

public class Reservation {
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkoutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkoutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkoutDate = checkoutDate;

    }

    public IRoom getRoom(){
        return room;
    }

    public Date getCheckInDate(){
        return checkInDate;
    }

    public Date getCheckoutDate(){
        return checkoutDate;
    }

    public Customer getCustomer(){
        return customer;
    }
    @Override
    public String toString(){
        return "Customer: " + customer + "room: " + room + "Check-in: " + checkInDate + "Check-out" + checkoutDate;
    }


}
