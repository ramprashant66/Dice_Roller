/*
Name: Prashant Ram
Class: CISP 401
Assignment 2 - Dice Roll
 */

import java.util.Scanner; //for I/O operations.
import java.security.SecureRandom; //to generate secure random numbers.

//Declare a public class to house our entire program.
public class DiceRoller
{

  //The driver function for the program.
  public static void main(String[] args)
  {
    /*Declares and initializes a string variable with the getInput function.
    The getInput function returns the user's entered input in the form of XdY*/
    String xDY= DiceRoller.getInput();

    //Create a new input object.
    Scanner programEnd = new Scanner(System.in);

    /*Declare and initialize a local variable "play". This variable will hold
    the chars of either 'y' in which, the program does not end, and we keep looping
    or 'n', which will end the loop which ultimately quits the program*/
    char play = 'y'; //initialized to 'y' so the loop executes at least once.

    /*This loop keeps on executing until the user enters n/N to end it. This loop
    * invokes the generateNumber() function and passes in the string variable xDY.
    * We invoke the static function using the class name.*/
    while (!((play == 'n') || (play == 'N')))
    {
      DiceRoller.generateNumbers(xDY); //invoking the generateNumbers function.
      System.out.println("|---------------|");
      System.out.println("|  Roll again?  |"); //prompting user if they wish to end the rollings.
      System.out.println("|---------------|");
      play = programEnd.next().charAt(0); //reading user's choice of either (n/N or y/Y)

      //This block performs input validation on the variable (play).
      while (!((play == 'y') || (play == 'Y') || (play == 'n') || (play == 'N')))
      {
        System.out.println("Invalid input. Enter only; n/N y/Y..Try again");
        System.out.println("|---------------|");
        System.out.println("|  Roll again?  |"); //prompting user if they wish to end the rollings.
        System.out.println("|---------------|");
        play = programEnd.next().charAt(0); //reading user's choice of either (n/N or y/Y)
      }

    }

  }//end main()

/*This function gets the user's input of the number of dice/die and the number of faces on each dice/
die in the format XdY and returns the input. Since I did not create any objects of class DiceRoller, I
declared this function static and invoked it using the class name.*/
  public static String getInput()
  {
    //These are the instructions provided to the user on how to enter the data in the XdY format.
    System.out.println("Legends\n========");
    System.out.println("X = number of dice/die to be rolled.");
    System.out.println("d = necessary character constant");
    System.out.println("Y = number of sides on the dice/die.");
    System.out.println("Enter your input in the format (XdY) "); //prompting the user.

    //Creating a new input object.
    Scanner forXDY = new Scanner(System.in);

    return forXDY.nextLine(); //reading and returning the user's input directly from one statement.

  } //end getInput

  /*This function does most of the heavy lifting for this program. It does not return anything so
  its return type is void and since there's no DiceRoller objects that we created, I've declared the function
  static. This function takes in the user's input of the XDY numbers, splits it into X and Y integers,
  then creates a loop to generate the secure random numbers.*/
  public static void generateNumbers(String userXDY)
  {
    //Creates a new Secure Random object to work with.
    SecureRandom dice = new SecureRandom();

    /*Splits the user's string (XdY) into X and Y integers while ignoring "d". We store the results
    in a declared string array.*/
    String [] user = userXDY.split("d"); //splitting the string

    //Converting the results of the splits into integers.
    int xInt = Integer.parseInt(user[0]); //converting X of (XdY) from string -> integers.
    int yInt = Integer.parseInt(user[1]); //converting Y of (XdY) from string -> integers.

  /*The generation of numbers (xInt) number of times with the numbers being between 1 to (yInt). For example,
    an input of 5d6 will execute the loop 5 times with each result ranging from 1 to 6.*/
    for (int rollCount = 0; rollCount < xInt; rollCount++)
    {
      System.out.println("You rolled a " + (dice.nextInt(yInt) + 1)); //output of the rolls
    }

  } //end generateNumbers

} //end class DiceRoller
