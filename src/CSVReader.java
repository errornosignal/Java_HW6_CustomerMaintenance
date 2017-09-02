import java.io.*;
import java.util.*;

/** Created by errornosignal on 4/7/2017.
 * Reid_Nolan_HW5_[CSVReader]_[PROG 1403]
 * CSVReader Class
 * Class for reading data stored in a .csv file
 * @author Reid Nolan
 * @since 04/07/2017
 * @version 1.01
 */
class CSVReader
{
    //declare and initialize class variables
    final static int kTIMER_DELAY = 250;
    private static List<Customer> customers = CustomerDAOImpl.customers;
    private static CustomerDAO customerDAO = new CustomerDAOImpl();

    /**
     * reads file into memory and parses data
     * @throws FileNotFoundException FNFEx
     * @throws InterruptedException IEx
     */
    static void readFile() throws FileNotFoundException, InterruptedException
    {
        //set counter for parsing string elements
        int elementCount = 0;

        try (Scanner input = new Scanner(new BufferedReader(new FileReader(CustomerMaintApp.fileToOpen))))
        {
            //set delimiter
            input.useDelimiter(" ");

            //read file until no lines left to read
            while (input.hasNextLine())
            {
                //declare and initialize local variables
                String emailAddress = "";
                String firstName = "";
                String lastName = "";

                //set next line in file to string variable
                String s1 = input.nextLine();

                //split string elements and place in array
                String[] s1_string = s1.split("\\s+");

                //throw custom exception of mal-formatted file
                if (s1_string.length > MaximumColumnsExceededException.get_kMAX_COLUMNS())
                {
                    throw new MaximumColumnsExceededException();
                }
                else
                {
                    //do nothing
                }

                //loop through string elements and set to variables
                for (String element : s1_string)
                {
                    while (elementCount >= 3)
                    {
                        elementCount = 0;
                    }

                    if (elementCount == 0)
                    {
                        emailAddress = element;
                        elementCount++;
                    }
                    else if (elementCount == 1)
                    {
                        firstName = element;
                        elementCount++;
                    }
                    else if (elementCount == 2)
                    {
                        lastName = element;
                        elementCount++;
                    }
                    else
                    {
                        elementCount = 0;
                    }
                }

                //add new Customer object to list
                Customer customer = new Customer(emailAddress, firstName, lastName);
                customers.add(customer);
            }

            //close file and display file read confirmation message
            input.close();
            displayFileReadConfirmation(CustomerMaintApp.fileToOpen);
        }
        catch (MaximumColumnsExceededException MCEEx)
        {
            //display error on thrown custom exception
            System.err.println(MCEEx.getMessage());
            Thread.sleep(kTIMER_DELAY);
            System.out.println();
        }
    }

    /**
     * displays file read successfully status message
     * @param fileToOpen file to open
     */
    private static void displayFileReadConfirmation(String fileToOpen)
    {
        System.out.println("[" + fileToOpen + "] has been successfully read.");
    }

    /**
     * writes contents of memory to file
     * @param fileToOpen fileToOpen
     * @throws InterruptedException IOEx
     */
    static void writeToFile(String fileToOpen) throws InterruptedException
    {
        BufferedWriter bufferedWriter = null;
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter(fileToOpen, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("");

            //write customer records stored in memory to file
            for (Customer customer : customerDAO.getAllCustomers())
            {
                bufferedWriter.write(customerDAO.printCustomerDetails(customer)+ "\n");
            }

            //display successful write to file message
            System.out.println("Changes were saved to [" + fileToOpen + "]");
        }
        catch (IOException IOEx)
        {
            System.err.println(IOEx.getMessage());
            Thread.sleep(kTIMER_DELAY);
            System.out.println();
        }
        finally
        {
            try
            {
                //close file
                if (bufferedWriter != null)
                {
                    bufferedWriter.close();
                }
                if (fileWriter != null)
                {
                    fileWriter.close();
                }
            }
            catch (IOException IOEx)
            {
                System.err.println(IOEx.getMessage());
                Thread.sleep(kTIMER_DELAY);
                System.out.println();
            }
        }
    }
}