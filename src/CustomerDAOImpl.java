import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/** Created by errornosignal on 4/25/2017.
 * Reid_Nolan_HW6_[Cust_Maint_App_[PROG 1403]
 * CustomerDAOImpl Class
 * Class to run CustomerDAO
 * @author Reid Nolan
 * @since 04/25/2017
 * @version 1.0
 */
public class CustomerDAOImpl implements CustomerDAO
{
    static List<Customer> customers = new ArrayList<>();

    /**
     * gets all customers
     * @return customers
     */
    @Override
    public List<Customer> getAllCustomers()
    {
        return customers;
    }

    /**
     * gets index of a customer object
     * @param emailAddress emailAddress
     * @return i / 0
     */
    @Override
    public int getCustomer(String emailAddress)
    {
        for (int i = 0; i < customers.size(); i++)
        {
            if (emailAddress.equals(customers.get(i).getEmailAddress()))
            {
                return i;
            }
            else
            {
                //do nothing
            }
        }
        return 0;
    }

    /**
     * adds a customer
     * @param customer customer
     */
    @Override
    public void addCustomer(Customer customer)
    {
        customers.add(customer);
        System.out.println("\n" + customer.getFirstName() + " " + customer.getLastName() +
                " was added to the database.\n");
    }

    /**
     * deletes a customer
     * @param customer customer
     */
    @Override
    public void deleteCustomer(Customer customer)
    {
        customers.remove(customer);
        System.out.println("\n" + customer.getFirstName() + " " + customer.getLastName() + " has been deleted.\n");
    }

    /**
     * sorts customers by emailAddress
     */
    @Override
    public void sortCustomers_emailAddress()
    {
        if (customers.size() > 0)
        {
            customers.sort(Comparator.comparing(Customer::getEmailAddress));
        }
    }

    /**
     * sorts customers by firstName
     */
    @Override
    public void sortCustomers_firstName()
    {
        if (customers.size() > 0)
        {
            customers.sort(Comparator.comparing(Customer::getFirstName));
        }
    }

    /**
     * sorts customers by lastName
     */
    @Override
    public void sortCustomers_lastName()
    {
        if (customers.size() > 0)
        {
            customers.sort(Comparator.comparing(Customer::getLastName));
        }
    }

    /**
     * updates a customer
     * @param customer customer
     */
    @Override
    public void updateCustomer(Customer customer)
    {
        customer.setFirstName(Validator.getString("First name: "));
        customer.setLastName(Validator.getString("Last name: "));
        System.out.println("\n" + customer.getFirstName() + " " + customer.getLastName() +
                " was updated in the database.\n");
    }

    /**
     * displays customer details
     * @param customer customer
     * @return string
     */
    @Override
    public String printCustomerDetails(Customer customer)
    {
        return StringUtils.padWithSpaces(customer.getEmailAddress(), CustomerConstants.get_kEMAIL_SIZE()) +
                StringUtils.padWithSpaces(customer.getFirstName(), CustomerConstants.get_kFIRSTNAME_SIZE()) +
                StringUtils.padWithSpaces(customer.getLastName(), CustomerConstants.get_kLASTNAME_SIZE());
    }
}