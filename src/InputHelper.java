package u5pp;
import java.util.Scanner;

public class InputHelper {

    Scanner scanner = new Scanner(System.in);

    public InputHelper(Scanner scanner){
        this.scanner = scanner;
    }
    
    public int[] getChessLocation(String prompt){

    //repeats the prompt until the user has inputted a correctly formatted chess location, such as 'a1' or 'h8'. Returns an `int` array of size 2, where the first element is the row (0-7) and the second element is the col (0-7).
    //`a1` should return `[0,0]`
    //`a8` should return `[7,0]`
    //`h1` should return `[0,7]`
        boolean question = true;
        while(question == true){
            System.out.println(prompt);
            String answer = scanner.nextLine();
            if((answer.length() == 2) && (((int) answer.charAt(0)) - 96 > 0) && (((int) answer.charAt(0)) - 96 < 9) && ((int) answer.charAt(1) - 48 > 0) && ((int) answer.charAt(1) - 48 < 9)){
                question = false;
                System.out.println((int) answer.charAt(1) - 49);
                System.out.println((int) answer.charAt(0) - 97);
                int a = ((int) answer.charAt(0)) - 97;
                int b = answer.charAt(1) - 49;
                int donkey [] = {b, a};
                return donkey;
            } else {
                System.out.println("That's not a valid answer idiot");
            }
        }
        int donkeynutz [] = {0, 0};
        return donkeynutz;
    }

}
