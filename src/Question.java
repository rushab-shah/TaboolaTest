import java.util.Scanner;

public class Question {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String input ="";
        int userChoice = 1;
        while (userChoice!=0) {
            System.out.println("\nPlease select the method to test(0 to exit) \n1)Convert to Int \n2)Check if contains Int\n");
            userChoice = reader.nextInt();
            if (userChoice>2 || userChoice<0) {
                System.out.println("Invalid choice!");
            } else if(userChoice==1){
                System.out.println("Provide Input string");
                input = reader.next();
                toInt(input);
            } else if(userChoice==2) {
                System.out.println("Provide Input string");
                input = reader.next();
                System.out.println("Answer:-"+ containsInt(input));
            }
        }
    }

    public static void toInt(String input) {
        int length = input.length();
        boolean negativeNumber = false;
        int answer=0;
        if(length>0) {
            int i =0;
            if(input.charAt(0) == '-') {
                // Negative number
                negativeNumber = true;
                i =1;
            }
            while (i<length) {
                // Get offset from 0 since all integers have consecutive ASCII values.
                // Getting offset with respect to ASCII value of 0 would give the int value of the number
                int offset = input.charAt(i) - '0';
                if(offset> 9 || offset < 0) {
                    System.out.println("Non-integer character at position "+i);
                    return;
                }
                answer += offset;
                if(i<length-1) {
                    answer = answer * 10;
                }
                i+=1;
            }
            if(negativeNumber && length>1) {
                answer = answer*-1;
            } else if(negativeNumber && length==1) {
                System.out.println("Invalid input");
                return;
            }
            System.out.println(answer);
        } else {
            System.out.println("No Input provided");
            return;
        }
    }

    public static boolean containsInt(String input) {
        int length = input.length();
        for(int i=0;i<length;i++) {
            if(offsetInRange(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean offsetInRange(char character) {
        if(character-'0'>=0 && character-'0'<=9) {
            return true;
        }
        return false;
    }

}
