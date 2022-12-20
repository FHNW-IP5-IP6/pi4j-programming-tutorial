import java.util.Random;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
      // Generating a Random String, which Simon will say
      int leftLimit = 48; // numeral '0'
      int rightLimit = 122; // letter 'z'
      int targetStringLength = 4;
      Random random = new Random();

      String simonPattern = random.ints(leftLimit, rightLimit + 1)
              .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
              .limit(targetStringLength)
              .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
              .toString();

      // Printing the SimonPattern for 3 Seconds, so you need to memorize it
      System.out.println("The Pattern you need to match: " + simonPattern);
      try {
         Thread.sleep(3000);
      }catch (InterruptedException e){
         Thread.currentThread().interrupt();
      }

      // Entering many lines, so in the console, the pattern is not visible anymore without scrolling
      for (int i = 0; i < 20; i++) {
         System.out.println("");
      }

      // reading the input of the console
      System.out.print("Please give in the Pattern: ");
      Scanner sc = new Scanner(System.in);
      String userPattern = sc.nextLine();

      // Calculating, how many Symbols were right
      int userScore = 0;

      for(int i = 0; simonPattern.length() > i; i++){
         if (simonPattern.charAt(i) == userPattern.charAt(i)){
            userScore += 1;
         }else{
            break;
         }
      }

      // Printing the score
      System.out.println("You had " + userScore + " symbols right of " + targetStringLength + ".");
   }
}