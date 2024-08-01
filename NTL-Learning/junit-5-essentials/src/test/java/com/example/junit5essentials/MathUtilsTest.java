package com.example.junit5essentials;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.lang.reflect.Executable;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {
    MathUtils mathUtils;

    @BeforeEach
    void init(){
        mathUtils = new MathUtils();
    }

    @AfterEach
    void cleanup(){
        System.out.println("Cleaning up...");
    }

    @Test
    @DisplayName("Testing add method")
    void add() {
      int expected = 2;
      int actual =  mathUtils.add(1,1);
      assertEquals(expected, actual);
    }
    /*Nested class while writing JUnit test*/
   @Nested
   @DisplayName("When adding two positive numbers")
    class nestedTest{
        @Test
        @DisplayName("return the right sum")
        void add() {
            int expected = 2;
            int actual =  mathUtils.add(1,1);
            assertEquals(expected, actual);
        }
        @Test
        @DisplayName("return the right subtraction")
        void subtract() {
            int expected = 2;
            int actual =  mathUtils.subtract(4,2);
            assertEquals(expected, actual);
        }
    }
    @Test
    @Tag("Math")
    void testDivide(){
        assertThrows(ArithmeticException.class, () ->mathUtils.divide(1, 0), "The method should add 2 number");
    }

    @Test
    @Tag("Math")
    void testMultiply(){
//      assertEquals(10, mathUtils.multiply(2,5), "should return the right sum");
        assertAll(
                () -> assertEquals(2, mathUtils.add(1,1)),
                () -> assertEquals(2, mathUtils.subtract(4,2)),
                () -> assertEquals(4, mathUtils.multiply(2,2))
        );
    }

    @Test
    @Tag("Math")
    @DisplayName("when adding two positive numbers")
    void testAddNegative(){
       int expected = -2;
       int actual = mathUtils.add(-1, -1);
       assertEquals(expected, actual, () -> "should return sum " + expected + " but return " + actual);
    }

//    using supplier for assert message
    @Test
    @Tag("Math")
    void testSubtraction(){
        assertEquals(2, mathUtils.subtract(4, 2), "should return the right subtraction");
    }
    /*
    @BeforeAll -> Run without instance. note: need to use static before void
    @AfterAll -> Run without instance
    @DisplayName -> Will display name
    @Disable -> Will disable a specific method.
    @EnableOnOs
    @EnableOnJar
    @Tag -> Selective tag only run for running test "Need to configure in pom.xml"
    assertAll = by using this we can write all method at once
    assumeTrue
    TestInfo & TestReporter -> Test info and test reporter are actually java interfaces, not classes. But you
    We shouldn't worry about the underlying implementation. Make sure to use these interfaces directly.
    * */

    @RepeatedTest(3)
    @Tag("Circle")
    void testComputeCircleRadius(RepetitionInfo repetitionInfo){

        MathUtils mathUtils = new MathUtils();
        assertEquals(314.0, mathUtils.computeCircleArea(10), "Should return compute circle area");
    }

}