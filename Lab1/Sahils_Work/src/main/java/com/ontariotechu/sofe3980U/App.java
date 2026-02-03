package com.ontariotechu.sofe3980U;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Binary num1 = new Binary("1001000");
        Binary num2 = new Binary("111000");

        System.out.println("First binary number is " + num1.getValue());
        System.out.println("Second binary number is " + num2.getValue());

        Binary sum = Binary.add(num1, num2);
        System.out.println("Their summation is " + sum.getValue());

        Binary andResult = Binary.and(num1, num2);
        System.out.println("Their AND is " + andResult.getValue());

        Binary orResult = Binary.or(num1, num2);
        System.out.println("Their OR is " + orResult.getValue());

        Binary multiplyResult = Binary.multiply(num1, num2);
        System.out.println("Their MULTIPLICATION is " + multiplyResult.getValue());
    }
}
