// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at http://www.site.uottawa.ca/school/research/lloseng/

import design2.PointCP2;
import design3.PointCP3;
import design5.PointCP5;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 * This class prompts the user for a set of coordinates, and then 
 * converts them from polar to cartesian or vice-versa.
 *
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Dr Timothy C. Lethbridge
 * @author Paul Holden
 * @version July 2000
 */
public class PointCPTest {
  //Class methods *****************************************************

  /**
   * This method is responsible for the creation of the PointCP
   * object.  This can be done in two ways; the first, by using the
   * command line and running the program using <code> java
   * PointCPTest &lt;coordtype (c/p)&gt; &lt;X/RHO&gt; &lt;Y/THETA&gt;
   * </code> and the second by getting the program to prompt the user.
   * If the user does not enter a valid sequence at the command line,
   * the program will prompte him or her.
   *
   * @param args[0] The coordinate type.  P for polar and C for
   *                cartesian.
   * @param args[1] The value of X or RHO.
   * @param args[2] The value of Y or THETA.
   */
  public static void main(String[] args) {
    testInput point;

    System.out.println("Cartesian-Polar Coordinates Conversion Program");

    // Check if the user input coordinates from the command line
    // If he did, create the PointCP object from these arguments.
    // If he did not, prompt the user for them.
//    try
//    {
//      point = new PointCP(args[0].toUpperCase().charAt(0),
//        Double.valueOf(args[1]).doubleValue(),
//        Double.valueOf(args[2]).doubleValue());
//    }
//    catch(Exception e)
//    {
//      // If we arrive here, it is because either there were no
//      // command line arguments, or they were invalid
//      if(args.length != 0)
//        System.out.println("Invalid arguments on command line");

    try {
      Scanner in = new Scanner(System.in);
      System.out.println("Which Design you want to test (PointCP/PointCP2/PointCP3/PointCP5)");
      String testType = in.nextLine();
      point = getInput(testType);
      if (point.testType.equals("PointCP2")) {
        PointCP2 testpoint = new PointCP2(point.a, point.b);
        System.out.println("\nYou entered:\n" + testpoint);
        PointCP3 point3 = testpoint.convertStorageToCartesian();
        System.out.println("\nAfter asking to present as Cartesian:\n" + point3);
        PointCP2 point2 = testpoint.convertStorageToPolar();
        System.out.println("\nAfter asking to present as Polar:\n" + point2);
      } else if (point.testType.equals("PointCP3")) {
        PointCP3 testpoint = new PointCP3(point.a, point.b);
        System.out.println("\nYou entered:\n" + testpoint);
        PointCP3 point3 = testpoint.convertStorageToCartesian();
        System.out.println("\nAfter asking to present as Cartesian:\n" + point3);
        PointCP2 point2 = testpoint.convertStorageToPolar();
        System.out.println("\nAfter asking to present as Polar:\n" + point2);
      } else if (point.testType.equals("PointCP")) {
        PointCP testpoint=new PointCP(point.type, point.a, point.b);
        long start=System.currentTimeMillis();
        System.out.println("\nYou entered:\n" + testpoint);
        testpoint.convertStorageToCartesian();
        System.out.println("\nAfter asking to store as Cartesian:\n" + testpoint);
        testpoint.convertStorageToPolar();
        System.out.println("\nAfter asking to store as Polar:\n" + testpoint);
        long end=System.currentTimeMillis();
        long timeUsed=end-start;
        System.out.println("Time used in design1: "+ timeUsed+" milliseconds");
      } else {
        long start=System.currentTimeMillis();
        if (point.type=='C'){
          design5.PointCP3 testpoint=new design5.PointCP3(point.a,point.b);
          System.out.println("\nYou entered:\n" + testpoint);
          System.out.println("\nAfter asking to present as Cartesian:\n" + testpoint.convertStorageToCartesian());
          System.out.println("\nAfter asking to present as Polar:\n" + testpoint.convertStorageToPolar());
        }else{
          design5.PointCP2 testpoint=new design5.PointCP2(point.a,point.b);
          System.out.println("\nYou entered:\n" + testpoint);
          System.out.println("\nAfter asking to present as Cartesian:\n" + testpoint.convertStorageToCartesian());
          System.out.println("\nAfter asking to present as Polar:\n" + testpoint.convertStorageToPolar());
        }
        long end=System.currentTimeMillis();
        long timeUsed=end-start;
        System.out.println("Time used in design5: "+ timeUsed+" milliseconds");
      }
      in.close();

    } catch (IOException ex) {
      System.out.println("Error getting input. Ending program.");
      return;
    }

  }

  /**
   * This method obtains input from the user and verifies that
   * it is valid.  When the input is valid, it returns a PointCP
   * object.
   *
   * @return A PointCP constructed using information obtained
   * from the user.
   * @throws IOException If there is an error getting input from
   *                     the user.
   */
  private static testInput getInput(String testType) throws IOException {
    byte[] buffer = new byte[1024];  //Buffer to hold byte input
    boolean isOK = false;  // Flag set if input correct
    String theInput = "";  // Input information

    //Information to be passed to the constructor
    char coordType = 'A'; // Temporary default, to be set to P or C
    double a = 0.0;
    double b = 0.0;
    boolean typeNeedCheck = true;

    // Allow the user to enter the three different arguments
    for (int i = 0; i < 3; i++) {
      while (!(isOK)) {
        isOK = true;  //flag set to true assuming input will be valid

        // Prompt the user
        if (i == 0) // First argument - type of coordinates
        {
          if (testType.equals("PointCP")) {
            System.out.print("Enter the type of Coordinates you "
                    + "are inputting ((C)artesian / (P)olar): ");
          } else if (testType.equals("PointCP2")) {
            typeNeedCheck = false;
            System.out.print("Please enter the (P) as type of Coordinates you "
                    + "are inputting");


          } else if (testType.equals("PointCP3")) {
            typeNeedCheck = false;
            System.out.print("Please enter the (P) as type of Coordinates you "
                    + "are inputting");
          } else {
            System.out.print("Enter the type of Coordinates you "
                    + "are inputting ((C)artesian / (P)olar): ");
          }
        } else {// Second and third arguments
          System.out.print("Enter the value of "
                  + (coordType == 'C'
                  ? (i == 1 ? "X " : "Y ")
                  : (i == 1 ? "Rho " : "Theta "))
                  + "using a decimal point(.): ");
        }

        // Get the user's input      

        // Initialize the buffer before we read the input
//        for (int k = 0; k < 1024; k++)
//          buffer[k] = '\u0020';
//
//        System.in.read(buffer);
//        theInput = new String(buffer).trim();

        Scanner in = new Scanner(System.in);
        theInput = in.nextLine();

        // Verify the user's input
        try {
          if (i == 0) // First argument -- type of coordinates
          {
            if (!((theInput.toUpperCase().charAt(0) == 'C')
                    || (theInput.toUpperCase().charAt(0) == 'P'))) {
              //Invalid input, reset flag so user is prompted again
              isOK = false;
            } else {
              coordType = theInput.toUpperCase().charAt(0);
            }
          } else  // Second and third arguments
          {
            //Convert the input to double values
            if (i == 1)
              a = Double.valueOf(theInput).doubleValue();
            else
              b = Double.valueOf(theInput).doubleValue();
          }
        } catch (Exception e) {
          System.out.println("Incorrect input");
          isOK = false;  //Reset flag as so not to end while loop
        }
      }

      //Reset flag so while loop will prompt for other arguments
      isOK = false;

    }
    //Return a new PointCP object

    return (new testInput(a, b, testType, coordType));

  }

  private static class testInput {

    private double a;
    private double b;
    private String testType;
    private char type;

    private testInput(double a, double b, String testType, char type) {
      this.a = a;
      this.b = b;
      this.testType = testType;
      this.type = type;
    }
  }
}

