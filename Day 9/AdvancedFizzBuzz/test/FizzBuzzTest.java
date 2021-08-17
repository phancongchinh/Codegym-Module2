import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    @DisplayName("divisible by 15")
    void fizzBuzz15() {
        int number = 15;
        String expected = "FIZZBUZZ";
        String actual = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("divisible by 5")
    void fizzBuzz5() {
        int number = 5;
        String expected = "BUZZ";
        String actual = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("divisible by 3")
    void fizzBuzz3() {
        int number = 3;
        String expected = "FIZZ";
        String actual = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("divisible by 1")
    void fizzBuzz1() {
        int number = 1;
        String expected = "1";
        String actual = FizzBuzz.fizzBuzz(number);
        assertEquals(expected,actual);
    }

    @Test
    void readOutLoud2() {
        int number = 11;
        String expected = "mot mot";
        String actual = FizzBuzz.readOutLoud(number);
        assertEquals(expected,actual);
    }
    @Test
    void readOutLoud1() {
        int number = 1;
        String expected = "mot";
        String actual = FizzBuzz.readOutLoud(number);
        assertEquals(expected,actual);
    }
}