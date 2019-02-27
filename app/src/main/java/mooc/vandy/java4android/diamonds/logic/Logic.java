package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        printTopBottomLine(size);
        topHalf(size);
        middle(size);
        bottomHalf(size);
        printTopBottomLine(size);
    }

    // print the top and bottom line of the diamond
    public void printTopBottomLine(int size) {

        mOut.print("+");
        printStrings("-", 2*size);
        mOut.println("+");
    }

    // print all types of strings by passing string as parameter
    public void printStrings(String str, int num) {

        for(int i=1; i<=num; i++) {
            mOut.print(str);
        }
    }

    // print the diamond shape
    public void printLine(int size, int line, String left, String right) {

        mOut.print("|");
        printStrings(" ", size - line);
        mOut.print(left);
        if(line % 2 == 0) {
            printStrings("-", 2*(line-1));
        }
        else {
            printStrings("=", 2*(line-1));
        }
        mOut.print(right);
        printStrings(" ", size - line);
        mOut.println("|");
    }

    // print the upper half of the diamond
    public void topHalf(int size) {
        for(int i=1; i<=size-1; i++) {
            printLine(size, i, "/", "\\");
        }
    }

    // print the middle part of the diamond
    public void middle(int size) {
        printLine(size, size, "<", ">");
    }

    // print the bottom half of the diamond
    public void bottomHalf(int size) {
        for(int i=size-1; i>=1; i--) {
            printLine(size, i, "\\", "/");
        }
    }


}
