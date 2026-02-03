package com.ontariotechu.sofe3980U;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Unit test for Binary class.
 */
public class BinaryTest
{
    // --- Constructor Tests ---
    @Test
    public void normalConstructor()
    {
        Binary binary=new Binary("1001001");
        assertTrue( binary.getValue().equals("1001001"));
    }
    @Test
    public void constructorEmptyString()
    {
        Binary binary=new Binary("");
        assertTrue( binary.getValue().equals("0"));
    }
    @Test
    public void constructorWithInvalidDigits()
    {
        Binary binary=new Binary("10010201");
        assertTrue( binary.getValue().equals("0"));
    }
    @Test
    public void constructorWithInvalidChars()
    {
        Binary binary=new Binary("10010A01");
        assertTrue( binary.getValue().equals("0"));
    }
    @Test
    public void constructorWithNegativeSign()
    {
        Binary binary=new Binary("-1001001");
        assertTrue( binary.getValue().equals("0"));
    }
    @Test
    public void constructorWithZeroTailing()
    {
        Binary binary=new Binary("00001001");
        assertTrue( binary.getValue().equals("1001"));
    }
    // --- Add Tests ---
    @Test
    public void add()
    {
        Binary binary1=new Binary("1000");
        Binary binary2=new Binary("1111");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("10111"));
    }
    @Test
    public void add2()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("11");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
    @Test
    public void add3()
    {
        Binary binary1=new Binary("11");
        Binary binary2=new Binary("1010");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1101"));
    }
    @Test
    public void add4()
    {
        Binary binary1=new Binary("0");
        Binary binary2=new Binary("1010");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
    @Test
    public void add5()
    {
        Binary binary1=new Binary("0");
        Binary binary2=new Binary("0");
        Binary binary3=Binary.add(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    // --- OR Tests ---
    @Test
    public void or1()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("1100");
        Binary binary3=Binary.OR(binary1,binary2);
        assertTrue( binary3.getValue().equals("1110"));
    }
    @Test
    public void or2()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("0000");
        Binary binary3=Binary.OR(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010"));
    }
    @Test
    public void or3()
    {
        Binary binary1=new Binary("0101");
        Binary binary2=new Binary("1010");
        Binary binary3=Binary.OR(binary1,binary2);
        assertTrue( binary3.getValue().equals("1111"));
    }
    // --- AND Tests ---
    @Test
    public void and1()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("1100");
        Binary binary3=Binary.AND(binary1,binary2);
        assertTrue( binary3.getValue().equals("1000"));
    }
    @Test
    public void and2()
    {
        Binary binary1=new Binary("1010");
        Binary binary2=new Binary("0101");
        Binary binary3=Binary.AND(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
    @Test
    public void and3()
    {
        Binary binary1=new Binary("1111");
        Binary binary2=new Binary("1111");
        Binary binary3=Binary.AND(binary1,binary2);
        assertTrue( binary3.getValue().equals("1111"));
    }
    // --- Multiply Tests ---
    @Test
    public void multiply1()
    {
        Binary binary1=new Binary("10"); // 2
        Binary binary2=new Binary("11"); // 3
        Binary binary3=Binary.Multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("110")); // 6
    }
    @Test
    public void multiply2()
    {
        Binary binary1=new Binary("101"); // 5
        Binary binary2=new Binary("10");  // 2
        Binary binary3=Binary.Multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("1010")); // 10
    }
    @Test
    public void multiply3()
    {
        Binary binary1=new Binary("111"); // 7
        Binary binary2=new Binary("0");   // 0
        Binary binary3=Binary.Multiply(binary1,binary2);
        assertTrue( binary3.getValue().equals("0"));
    }
}