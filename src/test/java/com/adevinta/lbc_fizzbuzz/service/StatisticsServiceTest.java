package com.adevinta.lbc_fizzbuzz.service;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import com.adevinta.lbc_fizzbuzz.model.FizzBuzzStatistics;
import com.adevinta.lbc_fizzbuzz.repository.FizzBuzzRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StatisticsServiceTest {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private FizzBuzzRepository repository;

    FizzBuzzStatisticsDto testFizzBuzzStatisticsDtoOne = FizzBuzzStatisticsDto.builder()
            .id(1L)
            .firstDivisor(3)
            .secondDivisor(5)
            .size(100)
            .str1("fizz")
            .str2("buzz")
            .counter(1L).build();

    FizzBuzzStatisticsDto testFizzBuzzStatisticsDtoTwo = FizzBuzzStatisticsDto.builder()
            .firstDivisor(3)
                .secondDivisor(7)
                .size(100)
                .str1("fizz")
                .str2("buzz")
                .counter(0L).build();


    @BeforeAll
    void localInit(){
        repository.save(testFizzBuzzStatisticsDtoOne);
    }

    @Test
    @Order(1)
    void shouldFindMostCommonFizzBuzz(){

        FizzBuzzStatistics result = statisticsService.findMostCommonFizzBuzz();
        FizzBuzzStatistics expected = FizzBuzzStatistics.builder()
                .int1(3)
                .int2(5)
                .limit(100)
                .str1("fizz")
                .str2("buzz")
                .counter(1L)
                .build();

        assertEquals(result, expected);
    }




    @Test
    @Order(4)
    void shouldReturnException(){

        repository.delete(testFizzBuzzStatisticsDtoOne);

        Exception result = assertThrows(NoSuchElementException.class, () -> statisticsService.findMostCommonFizzBuzz());

        String expectedValue = "No value present";

        assertEquals(result.getMessage(), expectedValue);
    }

    @Test
    @Order(2)
    void shouldReturnFizzBuzzStatisticsOfSelectedParameters(){

        FizzBuzzStatisticsDto result = statisticsService.findCurrentFizzBuzzByParameters(3,5,100, "fizz", "buzz");

        assertEquals(result, testFizzBuzzStatisticsDtoOne);

    }

    @Test
    @Order(3)
    void shouldReturnFizzBuzzStatisticsOfSelectedParametersWithCounterAt0(){

        FizzBuzzStatisticsDto result = statisticsService.findCurrentFizzBuzzByParameters(3,7,100, "fizz", "buzz");
        FizzBuzzStatisticsDto expected = testFizzBuzzStatisticsDtoTwo;

        assertEquals(result, expected);
    }

    @Test
    @Order(5)
    void shouldSaveNewStatisticsDtoToDb(){

        FizzBuzzStatisticsDto newDbEntry = testFizzBuzzStatisticsDtoTwo;
        newDbEntry.setCounter(1L);

        statisticsService.saveFizzBuzz(testFizzBuzzStatisticsDtoTwo);

        FizzBuzzStatisticsDto result = statisticsService.findCurrentFizzBuzzByParameters(3,7,100, "fizz", "buzz");
        FizzBuzzStatisticsDto expected = testFizzBuzzStatisticsDtoTwo;
        expected.setCounter(1L);

        assertEquals(expected, result);
    }


}
