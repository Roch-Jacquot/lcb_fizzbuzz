package com.adevinta.lbc_fizzbuzz.model;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FizzBuzzStatistics {

    int int1;

    int int2;

    int limit;

    String str1;

    String str2;

    Long counter;

    /**
     * fromStatisticsDto takes a FizzBuzzStatisticsDto and build a FizzBuzzStatistics from it
     * @param fizzBuzzStatisticsDto
     * @return FizzBuzzStatistics
     */
    public static FizzBuzzStatistics fromStatisticsDto(FizzBuzzStatisticsDto fizzBuzzStatisticsDto){
        return FizzBuzzStatistics.builder()
                .int1(fizzBuzzStatisticsDto.getFirstDivisor())
                .int2(fizzBuzzStatisticsDto.getSecondDivisor())
                .limit(fizzBuzzStatisticsDto.getSize())
                .str1(fizzBuzzStatisticsDto.getStr1())
                .str2(fizzBuzzStatisticsDto.getStr2())
                .counter(fizzBuzzStatisticsDto.getCounter()).build();
    }
}
