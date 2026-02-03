package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    /**
    * Main program:  The entry point of the program. 
    *
    * @param args: not used
    */
    public static void main( String[] args )
    {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nBinary Calculator");
        System.out.println("-----------------");

        System.out.println("Enter the first binary number:");
        String input1 = scanner.nextLine();
        Binary binary1 = new Binary(input1);
        
        System.out.println("Enter the second binary number:");
        String input2 = scanner.nextLine();
        Binary binary2 = new Binary(input2);
        
        System.out.println("\nFirst binary: " + binary1.getValue());
        System.out.println("Second binary: " + binary2.getValue());
        System.out.println("-----------------");
        
        Binary sum = Binary.add(binary1, binary2);
        System.out.println("Sum (Add): " + sum.getValue());
        
        Binary orResult = Binary.OR(binary1, binary2);
        System.out.println("Result (OR): " + orResult.getValue());
        
        Binary andResult = Binary.AND(binary1, binary2);
        System.out.println("Result (AND): " + andResult.getValue());
        
        Binary multiplyResult = Binary.Multiply(binary1, binary2);
        System.out.println("Result (Multiply): " + multiplyResult.getValue());
        
        scanner.close();
    }
}