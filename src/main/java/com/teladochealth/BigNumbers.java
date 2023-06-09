package com.teladochealth;

public class BigNumbers {

    /**
     * Take 2 big numbers represented as String. It's assuming both are non-negative numbers
     * Get their length, use it to set the indexes for each number, iterate them from end to start
     * Initialize sum variable with the carry value (it will be 0 the first time)
     * Grab each digit accessing to the String by index, and update sum
     * Append the result of sum mod 10 (it will give us the reminder) in the string builder.
     *  i.e:  8 + 6 = 14
     *       14 % 10 = 4
     * Update the carry value by doing: sum / 10, it will give us only the int part of it
     *  i.e: 8 + 6 = 14
     *      14 / 10 = 1.4
     *      carry = 1
     * It will be executed while indexes are greater equals than 0 (any of them) or carry is not 0
     *
     * Once outside the while loop, since we store the digits from end to beginning we need to reverse the string builder
     * before to return the result as a String
     *
     * O(n) time | O(n) space
     *
     * @param number1
     * @param number2
     * @return arithmetic sum result as a String
     */
    public String sum(String number1, String number2) {
        StringBuilder resultBuilder = new StringBuilder();
        int number1Index = number1.length() - 1, number2Index = number2.length() - 1, carry = 0;
        while (number1Index >= 0 || number2Index >= 0 || carry != 0) {
            int sum = carry;
            if (number1Index >= 0)
                sum += Character.getNumericValue(number1.charAt(number1Index--));
            if (number2Index >= 0)
                sum += Character.getNumericValue(number2.charAt(number2Index--));
            resultBuilder.append(sum % 10);
            carry = sum / 10;
        }
        return resultBuilder.reverse().toString();
    }
}
