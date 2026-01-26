package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest 
{
    /**
     * Test The constructor with a valid binary vallue
     */
    @Test
    public void normalConstructor()
    {
		Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    /**
     * Test The constructor with an invalid binary value of out-of-range digits
     */
    @Test
    public void constructorWithInvalidDigits()
    {
		Binary binary=new Binary("1001001211");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value of alphabetic characters
     */
    @Test
    public void constructorWithInvalidChars()
    {
		Binary binary=new Binary("1001001A");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * Test The constructor with an invalid binary value that has a sign
     */
    @Test
    public void constructorWithNegativeSign()
    {
		Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    /**
     * T	est The constructor with a zero tailing valid binary value
     */
    @Test
    public void constructorWithZeroTailing()
    {
		Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    /**
     * Test The constructor with an empty string
     */
    @Test
    public void constructorEmptyString()
    {
		Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
	/**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
    public void add()
    {
		Binary binary1=new Binary("1000");
		Binary binary2=new Binary("1111");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void add2()
    {
		Binary binary1=new Binary("1010");
		Binary binary2=new Binary("11");
		Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
	/**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
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
     * Test The add functions with a binary numbers with zero
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
	/**
     * Test The or function with two test nums, with the first being shorter
     */
    @Test
    public void or_test()
    {
		Binary binary1=new Binary("101110");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.or(binary1,binary2);
        assertTrue( binary3.getValue().equals("1111110"));
    }
	/**
     * Test The or function with two test nums, with the second being shorter
     */
    @Test
    public void or_test2()
    {
		Binary binary1=new Binary("11001010");
		Binary binary2=new Binary("101000");
		Binary binary3=Binary.or(binary1,binary2);
        assertTrue( binary3.getValue().equals("11101010"));
    }
	/**
     * Test The or function with a test num and a zero
     */
    @Test
    public void or_test3()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.or(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010010"));
    }
	/**
     * Test The and function with two test nums, with the first being shorter
     */
    @Test
    public void and_test()
    {
		Binary binary1=new Binary("101110");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.and(binary1,binary2);
        assertTrue( binary3.getValue().equals("10"));
    }
	/**
     * Test The and function with two test nums, with the second being shorter
     */
    @Test
    public void and_test2()
    {
		Binary binary1=new Binary("11001010");
		Binary binary2=new Binary("101000");
		Binary binary3=Binary.and(binary1,binary2);
        assertTrue( binary3.getValue().equals("1000"));
    }
	/**
     * Test The and function with a test num and a zero
     */
    @Test
    public void and_test3()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.and(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
	/**
     * Test The multiply function with two test nums, with the first being shorter
     */
    @Test
    public void mult_test()
    {
		Binary binary1=new Binary("101110");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("111010111100"));
    }
    /**
     * Test The multiply function with two test nums, with the second being shorter
     */
    @Test
    public void mult_test2()
    {
		Binary binary1=new Binary("11001010");
		Binary binary2=new Binary("101000");
		Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("1111110010000"));
    }
	/**
     * Test The multiply function with a test num and a zero
     */
    @Test
    public void mult_test3()
    {
		Binary binary1=new Binary("0");
		Binary binary2=new Binary("1010010");
		Binary binary3=Binary.multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
}
