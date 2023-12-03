package com.adevinta.lbc_fizzbuzz.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FizzBuzzServiceTest {

    @Autowired
    private FizzBuzzService fizzBuzzService;

    @Test
    void shouldGenerateAFizzBuzz(){
        List<String> result = fizzBuzzService.generateAndRecordFizzBuzz(3,5,15,"fizz", "buzz");
        List<String> expected = new ArrayList<>(){{
         add("1"); add("2"); add("fizz"); add("4"); add("buzz"); add("fizz"); add("7"); add("8"); add("fizz");
         add("buzz"); add("11");add("fizz");add("13");add("14");add("fizzbuzz");
        }};
        assertEquals(expected, result);
    }

}
