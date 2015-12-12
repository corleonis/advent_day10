package java.com.alex;

public class Application {

    private static String finalResult = "1211";

    public static void main(String args[])
    {
        System.out.println("Start counting\n");
        for(int i=0; i<41; i++) {
            String number = finalResult;
            finalResult = "";
            count(0, number);
            System.out.println(number.length());
        }

        System.out.println(finalResult.length());
    }

    public static void count(int position, String number) {
        if (number.isEmpty())
            return;

        int count = 1;
        int i=position+1;
        int newNumber = Character.getNumericValue(number.charAt(position));
        int nextNumber = Character.getNumericValue(number.charAt(i));
        for (; i < number.length(); i++) {
            nextNumber = Character.getNumericValue(number.charAt(i));
            if (newNumber == nextNumber) {
                count++;
            } else {
                finalResult += count+""+newNumber;
                newNumber = Character.getNumericValue(number.charAt(i));
                count = 1;
            }
        }

        finalResult += count+""+newNumber;
    }
}
