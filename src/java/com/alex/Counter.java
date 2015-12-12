package com.alex;

import java.util.HashMap;

public class Counter {

    private HashMap<String, String> data = new HashMap<>();

    /**
     * Running the execution of the counter
     * @return result
     */
    public String run(String number) {
        StringBuilder result = new StringBuilder();

        if (data.containsKey(number)) {
            return data.get(number);
        }

        if (number.length() == 1) {
            return 1+""+number;
        }

        int count = 1;
        int currentNumber;
        int nextNumber = 0;
        for (int i=1; i < number.length(); i++) {
            currentNumber = Character.getNumericValue(number.charAt(i-1));
            nextNumber = Character.getNumericValue(number.charAt(i));
            if (currentNumber == nextNumber) {
                count++;
            } else {
                result.append(count).append(currentNumber);
                count = 1;
            }
        }

        result.append(count).append(nextNumber);

        return result.toString();
    }

    public String runHalved(String number) {
        if (number.length() < 10) {
            throw new RuntimeException("Unexpected number");
        }
        StringBuilder result = new StringBuilder();

        if (data.containsKey(number)) {
            return data.get(number);
        }

        if ((number.charAt(number.length()/2-1) != number.charAt(number.length()/2))) {
            String number1 = number.substring(0, number.length() / 2);
            String number2 = number.substring(number.length() / 2, number.length());
            if (number.length() > 20 && number.length() > 20000) {
                String result1 = runHalved(number1);
                String result2 = runHalved(number2);

                data.put(number1, result1);
                data.put(number2, result2);

                result.append(result1).append(result2);
            } else {
                String result1 = run(number1);
                String result2 = run(number2);

                data.put(number1, result1);
                data.put(number2, result2);

                result.append(result1).append(result2);
            }
        } else {
            result.append(run(number));
            data.put(number, result.toString());
        }

        return result.toString();
    }
}
