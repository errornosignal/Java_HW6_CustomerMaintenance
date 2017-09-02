import java.io.File;
import java.io.IOException;

/** Created by errornosignal on 4/25/2017.
 * Reid_Nolan_HW6_[Cust_Maint_App_[PROG 1403]
 * CustomerMaintApp Class
 * Class for manipulation of records
 * @author Reid Nolan
 * @since 04/25/2017
 * @version 1.0
 */
public class CustomerMaintApp
{
    private static CustomerDAO customerDAO = new CustomerDAOImpl();
    static final String fileToOpen= "customers.txt";

    /**
     * main method
     * @param args args
     * @throws InterruptedException IEx
     */
    public static void main(String[] args) throws InterruptedException
    {
        displayProgramHeader();

        try
        {
            //create new file object
            File file = new File(fileToOpen);

            //check for file in directory
            if (!file.exists())
            {
                System.out.println("[" + fileToOpen + "] was not found in the current working directory.");
            }
            else
            {
                //do nothing
            }

            //creates file if it does not exist
            if (file.createNewFile())
            {
                System.out.println("[" + fileToOpen + "] was successfully created in the current working directory.");
            }
            else
            {
                System.out.println("[" + fileToOpen + "] was found in the current working directory.");
            }

            //read contents of file into memory
            CSVReader.readFile();
        }
        catch ( IOException | InterruptedException IEx)
        {
            IEx.printStackTrace();
            //display error on thrown custom exception
            System.err.println(IEx.getMessage());
            Thread.sleep(CSVReader.kTIMER_DELAY);
            System.out.println();
        }

        //display command menu
        System.out.println("-----------------------------------------------\n");
        System.out.println("Welcome to the Customer Maintenance application\n");
        displayCommandMenu();

        //menu options
        String command = "";
        while (!command.equalsIgnoreCase("exit"))
        {
            //prompt for command menu input
            command = Validator.getString("Enter a command: ");

            if (command.equalsIgnoreCase("list"))
            {
                //list all customers************************************************************************************
                System.out.println("\n-Print All:");
                printAllCustomers();
            }
            else if (command.equalsIgnoreCase("add"))
            {
                //add customer******************************************************************************************
                System.out.println("\n-Add Customer...");
                String emailAddress = Validator.getString("Enter customer email address: ");
                String firstName = Validator.getString("Enter first name: ");
                String lastName = Validator.getString("Enter last name: ");
                Customer customer = new Customer(emailAddress, firstName, lastName);
                customerDAO.addCustomer(customer);
            }
            else if (command.equalsIgnoreCase("del"))
            {
                //delete customer***************************************************************************************
                System.out.println("\n-Delete Customer:");
                String emailAddress = Validator.getString("Enter customer email to delete: ");
                Customer customer = customerDAO.getAllCustomers().get(customerDAO.getCustomer(emailAddress));
                if (customerDAO.getCustomer(emailAddress) != 0)
                {
                    customerDAO.deleteCustomer(customer);
                }
                else
                {
                    displayNoMatch();
                }
            }
            else if (command.equalsIgnoreCase("upd"))
            {
                //update customer***************************************************************************************
                System.out.println("\n-Update Customer:");
                String emailAddress = Validator.getString("Enter customer email to update: ");
                Customer customer = customerDAO.getAllCustomers().get(customerDAO.getCustomer(emailAddress));
                if (customerDAO.getCustomer(emailAddress) != 0)
                {
                    customerDAO.updateCustomer(customer);
                }
                else
                {
                    displayNoMatch();
                }
            }
            else if (command.equalsIgnoreCase("sort"))
            {
                displaySortMenu();

                //prompt for sort menu input
                String sortBy = Validator.getString("Sort by: ");

                if (sortBy.equalsIgnoreCase("email"))
                {
                    customerDAO.sortCustomers_emailAddress();
                }
                else if (sortBy.equalsIgnoreCase("first"))
                {
                    customerDAO.sortCustomers_firstName();
                }
                else if (sortBy.equalsIgnoreCase("last"))
                {
                    customerDAO.sortCustomers_lastName();
                }
                else
                {
                    //do nothing
                }
            }
            else if (command.equalsIgnoreCase("help"))
            {
                displayHelp();
                displayCommandMenu();
            }
            else if (command.equalsIgnoreCase("exit"))
            {
                //exit program and write contents of memory to file
                CSVReader.writeToFile(fileToOpen);
                System.out.println("\nGoodBye...\n");
            }
            else
            {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }

    /**
     * displays program header
     */
    private static void displayProgramHeader()
    {
        System.out.println("Reid_Nolan+HW_6[CustomerMaintApp]\n");
    }

    /**
     * displays main menu
     */
    private static void displayCommandMenu()
    {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all customers");
        System.out.println("add     - Add a customer");
        System.out.println("del     - Delete a customer");
        System.out.println("upd     - Update a customer");
        System.out.println("sort    - Sort by last, first, and email");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    private  static void displaySortMenu()
    {
        System.out.println("\nSORT OPTIONS");
        System.out.println("email   - sort by email");
        System.out.println("first   - sort by first name");
        System.out.println("last    - sort by last name");
    }

    /**
     * prints all customers
     */
    private static void printAllCustomers()
    {
        try
        {
            for (int i = 0; i < CustomerDAOImpl.customers.size(); i++)
            {
                System.out.println(customerDAO.printCustomerDetails(CustomerDAOImpl.customers.get(i)));
            }
            System.out.println();
        }
        catch (NullPointerException NPEx)
        {
            NPEx.printStackTrace();
        }
    }

    /**
     * displays help details
     */
    private static void displayHelp()
    {
        System.out.println("\nMENU DETAILS");
        System.out.println("list    - List all customers: Displays a list containing all customer records in the database. These\n\t\t\trecords contain first name, last name, and email addresses fields for each customer.");
        System.out.println("add     - Add a customer: Provides options for adding a new customer record to the database.");
        System.out.println("del     - Delete a customer: Provides options for removing a customer record from the database.");
        System.out.println("update  - Update a customer: Provides options for updating an existing customer record in the database.");
        System.out.println("sort    - Sort customers: Sorts the records stored in the database, in ascending alphabetical order,\n\t\t\tby either last name, first name, or email address.");
        System.out.println("help    - Show this menu: Shows details for each of the main menu options.");
        System.out.println("exit    - Exit this application: Self-explanatory.\n");
    }

    /**
     * displays no match found message
     */
    private static void displayNoMatch()
    {
        System.out.println("Sorry, there are no customers with that email.\n");
    }
}