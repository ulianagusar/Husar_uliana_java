package org.example;
import static org.junit.Assert.assertEquals;
//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.Before;

//import static org.junit.jupiter.api.Assertions.*;
//import static org.junit.Assert.*;

public class StringCalculatorTest {
    private StringCalculator calc ;
    @Before
    void setUp() throws Exception{

        calc = new StringCalculator();
    }

    @Test
    void addEmptyString() {

        assertEquals(0, calc.add(""));
    }
}