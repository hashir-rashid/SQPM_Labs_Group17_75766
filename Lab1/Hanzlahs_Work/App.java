package com.ontariotechu.sofe3980U;

import org.joda.time.LocalTime;
import java.util.Scanner;

/**
 * The App class serves as the main entry point for the
 * Binary Operations Program. It accepts user input,
 * performs binary operations, and displays the results.
 */
public class App
{
	/**
	 * Main method that runs the Binary Operations Program.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args)
	{
		System.out.println("Time now: " + new LocalTime());
		System.out.println("\n=== Binary Operations Program ===");

		Scanner in = new Scanner(System.in);

		System.out.print("Input binary value #1: ");
		Binary b1 = new Binary(in.nextLine());

		System.out.print("Input binary value #2: ");
		Binary b2 = new Binary(in.nextLine());

		System.out.println("\nBinary A = " + b1.getValue());
		System.out.println("Binary B = " + b2.getValue());
		System.out.println("-------------------------------");

		System.out.println("Addition      : " + Binary.add(b1, b2).getValue());
		System.out.println("Bitwise OR    : " + Binary.OR(b1, b2).getValue());
		System.out.println("Bitwise AND   : " + Binary.AND(b1, b2).getValue());
		System.out.println("Multiplication: " + Binary.Multiply(b1, b2).getValue());

		in.close();
	}
}
