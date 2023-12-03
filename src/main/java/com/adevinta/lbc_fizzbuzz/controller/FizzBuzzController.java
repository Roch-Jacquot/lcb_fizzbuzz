package com.adevinta.lbc_fizzbuzz.controller;

import com.adevinta.lbc_fizzbuzz.dto.StatisticsDto;
import com.adevinta.lbc_fizzbuzz.model.FizzBuzzStatistics;
import com.adevinta.lbc_fizzbuzz.service.FizzBuzzService;
import com.adevinta.lbc_fizzbuzz.service.StatisticsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzController {


    FizzBuzzService fizzBuzzService;
    StatisticsService statisticsService;

    public FizzBuzzController(FizzBuzzService fizzBuzzService, StatisticsService statisticsService) {
        this.fizzBuzzService = fizzBuzzService;
        this.statisticsService = statisticsService;
    }

    @GetMapping("/fizzbuzz")
    List<String> fizzBuzzCalculator(@RequestParam int int1, @RequestParam int int2, @RequestParam int limit,
                                    @RequestParam String str1, @RequestParam String str2){
        System.out.println("Got all params: int1-" + int1 + " int2-" + int2 + " limit-" + limit + " str1-" + str1 + " str2-" + str2);

        return fizzBuzzService.generateFizzBuzz(int1, int2, limit, str1, str2);
    }

    @GetMapping("/fizzbuzz/statistics")
    FizzBuzzStatistics fizzBuzzStatistics(){
        return statisticsService.findMostCommonFizzBuzz();
    }
}