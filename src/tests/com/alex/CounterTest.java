package com.alex;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterTest {

    @Test
    public void testOneIsRenderingCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("1");
        assertEquals("11", result);
    }

    @Test
    public void testTwoOnesReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("11");
        assertEquals("21", result);
    }

    @Test
    public void testTwoAndOneReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("21");
        assertEquals("1211", result);
    }

    @Test
    public void testOneTwoAndOneOneReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("1211");
        assertEquals("111221", result);
    }

    @Test
    public void testThreeOnesTwoTwosAndOneOneReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("111221");
        assertEquals("312211", result);
    }

    @Test
    public void testOneThreeOneOneTwoTwosAndTwoOnesReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("312211");
        assertEquals("13112221", result);
    }

    @Test
    public void testOneOneOneThreeTwoOnesThreeTwosAndOneOneReturnsCorrectResult() {
        Counter counter = new Counter();
        String result = counter.run("13112221");
        assertEquals("1113213211", result);
    }

    @Test
    public void testTenExecutionsGiveResult() {
        String result = "1113222113";
        Counter counter = new Counter();

        for (int i=0; i < 10; i++) {
            result = counter.runHalved(result);
        }

        assertEquals(100, result.length());
    }

    @Test
    public void testThirtyExecutionsGiveResult() {
        String result = "1113222113";
        Counter counter = new Counter();

        for (int i=0; i < 30; i++) {
            result = counter.runHalved(result);
        }

        assertEquals(17874, result.length());
    }

    @Test
    public void testFortyExecutionsGiveResult() {
        String result = "1113222113";
        Counter counter = new Counter();

        for (int i=0; i < 40; i++) {
            result = counter.runHalved(result);
        }

        assertEquals(252594, result.length());
    }

    @Test
    public void testFiftyExecutionsGiveResult() {
        String result = "1113222113";
        Counter counter = new Counter();

        for (int i=0; i < 50; i++) {
            result = counter.run(result);
        }

        assertEquals(3579328, result.length());
    }
}
