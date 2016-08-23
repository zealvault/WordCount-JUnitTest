package com.ee.frequency;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shubham on 23-08-2016.
 */
public class WordCountTest {
    WordCount wordCountObject = null;
    int cutOff;
    @Before
    public void setUp() throws Exception {
        cutOff = 2;
        wordCountObject = new WordCount("abc.txt",cutOff);
    }

    @After
    public void tearDown() throws Exception {
        wordCountObject = null;
    }



    @Test(expected = java.lang.NullPointerException.class)
    public void testFileAsNull() throws Exception {
        wordCountObject = new WordCount(null,cutOff);
    }

    @Test(expected = java.lang.IllegalArgumentException.class)
    public void testFileAsWrongFile() throws Exception {
    wordCountObject = new WordCount("xyz.txt",cutOff);
    }

    @Test/*(expected = java.io.FileNotFoundException.class)*/
    public void testFindFrequency() throws Exception {
    wordCountObject.findFrequency();
    }



}