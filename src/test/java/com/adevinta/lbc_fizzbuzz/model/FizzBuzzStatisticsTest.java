package com.adevinta.lbc_fizzbuzz.model;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FizzBuzzStatisticsTest {

    @Test
    void fromStatisticsDtoShouldBuildAFizzBuzzStatisticsFromDto(){
        FizzBuzzStatisticsDto fizzBuzzStatisticsDto = FizzBuzzStatisticsDto.builder()
                .id(1L)
                .firstDivisor(3)
                .secondDivisor(5)
                .size(100)
                .str1("fizz")
                .str2("buzz")
                .counter(1L).build();

        FizzBuzzStatistics result = FizzBuzzStatistics.fromStatisticsDto(fizzBuzzStatisticsDto);
        FizzBuzzStatistics expected = FizzBuzzStatistics.builder()
                .int1(3)
                .int2(5)
                .limit(100)
                .str1("fizz")
                .str2("buzz")
                .counter(1L).build();


        assertEquals(expected, result);
    }
}
