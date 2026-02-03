package com.ontariotechu.sofe3980U;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class BinaryTest 
{
	/**
	 * Test The add functions with a binary numbers with the same length.
	 */
	@Test
	public void add1()
	{
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
		assertTrue( binary3.getValue().equals("10100"));
	}

	/**
	 * Test The add functions with a binary numbers with different length.
	 */
	@Test
	public void add2()
	{
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
		assertTrue( binary3.getValue().equals("1101"));
	}

	/**
	 * Test The add functions with a binary numbers with different length.
	 */
	@Test
	public void add3()
	{
		Binary binary1=new Binary("11");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
		assertTrue( binary3.getValue().equals("1101"));
	}

	/**
	 * Test The add functions with a binary numbers with different length.
	 */
	@Test
	public void add4()
	{
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010");
		Binary binary3=Binary.add(binary1,binary2);
		assertTrue( binary3.getValue().equals("1010"));
	}

	/**
	 * Test The add functions with two zeros
	 */
	@Test
	public void add5()
	{
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("0");
		Binary binary3=Binary.add(binary1,binary2);
		assertTrue( binary3.getValue().equals("0"));
	}

	// ------------------- OR TESTS -------------------

	@Test
	public void or1()
	{
		Binary a = new Binary("1010");
		Binary b = new Binary("0110");
		Binary c = Binary.or(a, b);
		assertTrue(c.getValue().equals("1110"));
	}

	@Test
	public void or2()
	{
		Binary a = new Binary("0");
		Binary b = new Binary("1010");
		Binary c = Binary.or(a, b);
		assertTrue(c.getValue().equals("1010"));
	}

	@Test
	public void or3()
	{
		Binary a = new Binary("111");
		Binary b = new Binary("1000");
		Binary c = Binary.or(a, b);
		assertTrue(c.getValue().equals("1111"));
	}

	// ------------------- AND TESTS -------------------

	@Test
	public void and1()
	{
		Binary a = new Binary("1010");
		Binary b = new Binary("0110");
		Binary c = Binary.and(a, b);
		assertTrue(c.getValue().equals("10"));
	}

	@Test
	public void and2()
	{
		Binary a = new Binary("1111");
		Binary b = new Binary("1111");
		Binary c = Binary.and(a, b);
		assertTrue(c.getValue().equals("1111"));
	}

	@Test
	public void and3()
	{
		Binary a = new Binary("111");
		Binary b = new Binary("1000");
		Binary c = Binary.and(a, b);
		assertTrue(c.getValue().equals("0"));
	}

	// ------------------- MULTIPLY TESTS -------------------

	@Test
	public void multiply1()
	{
		// 3 * 5 = 15
		Binary a = new Binary("11");
		Binary b = new Binary("101");
		Binary c = Binary.multiply(a, b);
		assertTrue(c.getValue().equals("1111"));
	}

	@Test
	public void multiply2()
	{
		Binary a = new Binary("10101");
		Binary b = new Binary("0");
		Binary c = Binary.multiply(a, b);
		assertTrue(c.getValue().equals("0"));
	}

	@Test
	public void multiply3()
	{
		Binary a = new Binary("1101");
		Binary b = new Binary("1");
		Binary c = Binary.multiply(a, b);
		assertTrue(c.getValue().equals("1101"));
	}
}
