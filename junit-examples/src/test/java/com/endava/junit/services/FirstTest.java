package com.endava.junit.services;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by astoicovici on 9/27/2018.
 */
public class FirstTest {

    @Test
    public void testIt()
    {
        //Arrange

        String expected = "test";
        String actual = "test";

        //Act



        //Assert

        //Assert.fail();
        //Assert.assertThat();

        //hamcrest
        assertThat(actual, is(equalTo(expected)));
        Assert.assertTrue("Fail to the 1 and 1 test!",1==1);


    }

}
