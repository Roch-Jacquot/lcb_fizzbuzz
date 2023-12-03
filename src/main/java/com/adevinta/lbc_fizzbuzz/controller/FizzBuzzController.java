package com.adevinta.lbc_fizzbuzz.controller;

import com.adevinta.lbc_fizzbuzz.model.FizzBuzzStatistics;
import com.adevinta.lbc_fizzbuzz.service.FizzBuzzService;
import com.adevinta.lbc_fizzbuzz.service.StatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class FizzBuzzController {


    FizzBuzzService fizzBuzzService;
    StatisticsService statisticsService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService, StatisticsService statisticsService) {
        this.fizzBuzzService = fizzBuzzService;
        this.statisticsService = statisticsService;
    }

    /**
     * fizzBuzzCalculator generates the results to a fizzbuzz exercise
     * @param int1: first divisor of the fizzbuzz
     * @param int2: second divisor of the fizzbuzz
     * @param limit: size of the list
     * @param str1: value to use with int1
     * @param str2: value to use with int2
     * @return: List of string containing the fizzbuzz results
     */
    @GetMapping("/fizzbuzz")
    List<String> fizzBuzzCalculator(@RequestParam int int1, @RequestParam int int2, @RequestParam int limit,
                                    @RequestParam String str1, @RequestParam String str2){

        return fizzBuzzService.generateAndRecordFizzBuzz(int1, int2, limit, str1, str2);
    }

    /**
     * fizzBuzzStatistics returns the most common fizzBuzz generated
     * @return: FizzBuzzStatistics object containing the parameters of the most generated fizzbuzz
     */
    @GetMapping("/fizzbuzz/statistics")
    FizzBuzzStatistics fizzBuzzStatistics(){
        try{
            return statisticsService.findMostCommonFizzBuzz();
        } catch(NoSuchElementException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No fizzbuzz statistics found", exception);
        }
    }
}