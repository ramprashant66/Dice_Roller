import java.util.Scanner;
import java.security.SecureRandom;

public class DiceRoller
{

  public static void main(String[] args)
  {
    //Declares and initializes the string variable to the getInput method.
    String xDY= DiceRoller.getInput();

    Scanner programEnd = new Scanner(System.in);
    char exit = 'n';

    while (!((exit == 'y') || (exit == 'Y')))
    {
      DiceRoller.generateNumbers(xDY);
      System.out.println("Stop rolling?");
      exit = programEnd.next().charAt(0);

    }

  }//end main()


  public static String getInput()
  {
    System.out.println("Legends\n========");
    System.out.println("X = number of dice/die to be rolled.");
    System.out.println("d = necessary character constant");
    System.out.println("Y = number of sides on the dice/die.");
    System.out.println("Enter your input in the format (XdY) ");

    Scanner forXDY = new Scanner(System.in);

    return forXDY.nextLine();

  } //end getInput

  public static void generateNumbers(String userXDY)
  {
    //Create a new Secure Random object to work with.
    SecureRandom dice = new SecureRandom();

    //Split the string into X and Y.
    String [] user = userXDY.split("d");

    //Convert the two elements into integers.
    int xInt = Integer.parseInt(user[0]);
    int yInt = Integer.parseInt(user[1]);

//generate numbers (xInt) number of times with the numbers being between 1 - (yInt)
    for (int rollCount = 0; rollCount < xInt; rollCount++)
    {
      System.out.println(dice.nextInt(yInt) + 1);
    }

  } //end generateNumbers

} //end class DiceRoller
