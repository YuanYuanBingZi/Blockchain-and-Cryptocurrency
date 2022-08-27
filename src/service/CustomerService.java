package service;
import java.util.*;
import model1.Customer;

public class CustomerService {
    private static CustomerService customerService = null;
    public CustomerService(){}
    private Map<String, Customer> customers = new HashMap<>();

    public static CustomerService getInstance(){
        if(null == customerService){
            customerService = new CustomerService();
        }
        return customerService;
    }

     public void addCustomer(String email, String firstName, String lastName)throws IllegalAccessException{
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail){
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers(){
        return customers.values();
    }
}
