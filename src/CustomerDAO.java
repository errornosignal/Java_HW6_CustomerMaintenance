import java.util.List;

/** Created by errornosignal on 4/25/2017.
 * Reid_Nolan_HW6_[Cust_Maint_App_[PROG 1403]
 * CustomerDAO Interface
 * Interface for Customer Class
 * @author Reid Nolan
 * @since 04/25/2017
 * @version 1.0
 */
interface CustomerDAO
{
    /**
     * gets all customers
     * @return customers
     */
    List<Customer> getAllCustomers();

    /**
     * gets a customer
     * @param emailAddress emailAddress
     * @return i / 0
     */
    int getCustomer(String emailAddress);

    /**
     * adds a customer
     * @param customer customer
     */
    void addCustomer(Customer customer);

    /**
     * deletes a customer
     * @param customer customer
     */
    void deleteCustomer(Customer customer);

    /**
     * sorts customers by emailAddress
     */
    void sortCustomers_emailAddress();

    /**
     * sorts customers by firstName
     */
    void sortCustomers_firstName();

    /**
     * sorts customers by lastName
     */
    void sortCustomers_lastName();

    /**
     * updates a customer
     * @param customer customer
     */
    void updateCustomer(Customer customer);

    /**
     * displays customer details
     * @param customer customer
     * @return string
     */
    String printCustomerDetails(Customer customer);
}