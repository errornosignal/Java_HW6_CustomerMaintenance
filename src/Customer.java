/** Created by errornosignal on 4/25/2017.
 * Reid_Nolan_HW6_[Cust_Maint_App_[PROG 1403]
 * Customer Class
 * Class for storing and retrieving customer object data
 * @author Reid Nolan
 * @since 04/25/2017
 * @version 1.0
 */
class Customer
{
    private String emailAddress;
    private String firstName;
    private String lastName;

    /**
     * Constructors for Customer Class
     * @param emailAddress emailAddress
     * @param firstName firstName
     * @param lastName lastName
     */
    Customer(String emailAddress, String firstName, String lastName)
    {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * gets emailAddress variable
     * @return emailAddress
     */
    String getEmailAddress()
    {
        return emailAddress;
    }

    /**
     * gets firstName variable
     * @return firstName
     */
    String getFirstName()
    {
    return firstName;
    }

    /**
     * gets lastName variable
     * @return lastName
     */
    String getLastName()
    {
        return lastName;
    }

    /**
     * sets emailAddress variable
     * @param emailAddress emailAddress
     */
    void setEmailAddress(String emailAddress)
    {
        this.emailAddress = emailAddress;
    }

    /**
     * sets firstName  variable
     * @param firstName firstName
     */
    void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * sets lastName variable
     * @param lastName lastName
     */
    void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

}