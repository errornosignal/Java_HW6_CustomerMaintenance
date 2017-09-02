import org.jetbrains.annotations.Contract;

/**
 * /** Created by errornosignal on 4/22/2017.
 * Reid_Nolan_HW6_[Cust_Main_App]_[PROG 1403]
 * Constants Interface for Cust_Main_App
 * @author Reid Nolan
 * @since 04/22/2017
 * @version 1.0
 */
public interface CustomerConstants
{
    //declare interface variables
    int kFIRSTNAME_SIZE = 15;
    int kLASTNAME_SIZE = 15;
    int kEMAIL_SIZE = 30;

    /**
     * gets kFIRSTNAME_SIZE
     * @return kFIRSTNAME_SIZE
     */
    @Contract(pure = true)
    static int get_kFIRSTNAME_SIZE()
    {
    return kFIRSTNAME_SIZE;
    }

    /**
     * gets kLASTNAME_SIZE
     * @return kLASTNAME_SIZE
     */
    @Contract(pure = true)
    static int get_kLASTNAME_SIZE()
    {
        return kLASTNAME_SIZE;
    }

    /**
     * gets kEMAIL_SIZE
     * @return kEMAIL_SIZE
     */
    @Contract(pure = true)
    static int get_kEMAIL_SIZE()
    {
        return kEMAIL_SIZE;
    }


}
