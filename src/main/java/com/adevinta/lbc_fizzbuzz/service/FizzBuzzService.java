package com.adevinta.lbc_fizzbuzz.service;

import com.adevinta.lbc_fizzbuzz.dto.StatisticsDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FizzBuzzService {

    StatisticsService statisticsService;

    public FizzBuzzService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public List<String> generateFizzBuzz(int int1, int int2, int limit, String str1, String str2){
        String[] fizzBuzzResult = new String[limit];
        boolean indexDividesInt1;
        boolean indexDividesInt2;

        for (int i = 0; i < limit; i++) {
            indexDividesInt1 = (i+1)%int1 == 0;
            indexDividesInt2 = (i+1)%int2 == 0;
            if(indexDividesInt1 && indexDividesInt2){
                fizzBuzzResult[i] = str1+str2;
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
        StatisticsDto dto = statisticsService.findCurrentFizzBuzzByParameters(int1, int2, limit, str1, str2);
        dto.setCounter(dto.getCounter()+1);
        statisticsService.saveFizzBuzz(dto);

        return Arrays.stream(fizzBuzzResult).toList();
    }

}
