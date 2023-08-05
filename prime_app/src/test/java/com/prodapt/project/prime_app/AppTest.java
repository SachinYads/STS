package com.prodapt.project.age;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1()
    {
    	int result=Calculator.getAge(6);
        assertEquals( 33,result );
    }
    @Test
    public void test2()
    {
    	int result=Calculator.getAge(3);
        assertEquals( 21,result);
    }
    
    
}
