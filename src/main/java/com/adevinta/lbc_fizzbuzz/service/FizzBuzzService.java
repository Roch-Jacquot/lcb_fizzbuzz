package com.adevinta.lbc_fizzbuzz.service;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FizzBuzzService {

    StatisticsService statisticsService;

    public FizzBuzzService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }


    /**
     * generateAndRecordFizzBuzz builds a FizzBuzz list and records its parameters
     * @param int1: first divisor of the fiz
     * @param int2: second divisor of the fi
     * @param limit: size of the list
     * @param str1: value to use with int1
     * @param str2: value to use with int2
     * @return List of String made up of the FizzBuzz generated
     */
    public List<String> generateAndRecordFizzBuzz(int int1, int int2, int limit, String str1, String str2){
        String[] fizzBuzzResult = buildFizzBuzz(int1, int2, limit, str1, str2);
        findAndIncrementStatistics(int1, int2, limit, str1, str2);

        return Arrays.stream(fizzBuzzResult).toList();
    }

    /**
     * findAndIncrementStatistics finds the FizzBuzz saved in database or creates a new one then increments it
     * @param int1: first divisor of the fiz
     * @param int2: second divisor of the fi
     * @param limit: size of the list
     * @param str1: value to use with int1
     * @param str2: value to use with int2
     */
    private void findAndIncrementStatistics(int int1, int int2, int limit, String str1, String str2) {
        FizzBuzzStatisticsDto dto = statisticsService.findCurrentFizzBuzzByParameters(int1, int2, limit, str1, str2);
        dto.setCounter(dto.getCounter()+1);
        statisticsService.saveFizzBuzz(dto);
    }

    private String[] buildFizzBuzz(int int1, int int2, int limit, String str1, String str2) {
        String[] fizzBuzzResult = new String[limit];
        boolean indexDividesInt1;
        boolean indexDividesInt2;

        for (int i = 0; i < limit; i++) {
            indexDividesInt1 = (i+1)% int1 == 0;
            indexDividesInt2 = (i+1)% int2 == 0;
            if(indexDividesInt1 && indexDividesInt2){
                fizzBuzzResult[i] = str1 + str2;
            }
            else if(indexDividesInt1){
                fizzBuzzResult[i] = str1;
            }
            else if(indexDividesInt2){
                fizzBuzzResult[i] = str2;
            }
            else {
                fizzBuzzResult[i] = String.valueOf(i+1);
            }
        }
        return fizzBuzzResult;
    }

}
