package com.seleniumtest.allure;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase1 {

    @Test
    public void testMethod1()
    {
        Assert.fail();
        System.out.println("testMethod1 is not working as expected!");
    }
}
