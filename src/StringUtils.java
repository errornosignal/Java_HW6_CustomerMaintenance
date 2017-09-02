/** Created by errornosignal on 4/22/2017.
 * Reid_Nolan_HW6_[Cust_Main_App]_[PROG 1403]
 * StringUtils Class
 * Custom StringUtils class
 * @author Reid Nolan
 * @since 04/22/2017
 * @version 1.0
 */
class StringUtils
{
    /**
     * pads output string with spaces
     * @param string string
     * @param sizeToPad sizeToPad
     * @return string
     */
    static String padWithSpaces(String string, int sizeToPad)
    {
        return String.format("%1$-" + sizeToPad + "s", string);
    }
}