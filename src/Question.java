public class Question {
    public static void main(String[] args) {
        toInt("-a");
        System.out.println(containsInt("This Is A Test4me"));
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
            } else {
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
