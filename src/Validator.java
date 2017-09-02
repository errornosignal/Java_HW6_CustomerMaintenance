import java.util.Scanner;

/** Created by errornosignal on 3/3/2017.
 * Reid_Nolan_HW6_[Cust_Maint_App_[PROG 1403]
 * Validator Class
 * Class for validating user input
 * @author Reid Nolan
 * @since 03/03/2017
 * @version 1.02
 */
class Validator
{
    /**
     * gets validated user input
     * @param prompt prompt
     * @return inputString
     */
    static String getString(String prompt)
    {
        //create new scanner
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        //loop until string is valid
        boolean stringIsValid = false;
        while(!stringIsValid)
        {
            //prompt for input
            System.out.print(prompt);
            //assign next scanner input string to variable
            inputString = sc.nextLine();
            //verify input is entered
            if (inputString.isEmpty())
            {
                //do nothing
            }
            else
            {
                //set boolean to true to exit loop
                stringIsValid = true;
            }
        }
        return inputString;
    }
}