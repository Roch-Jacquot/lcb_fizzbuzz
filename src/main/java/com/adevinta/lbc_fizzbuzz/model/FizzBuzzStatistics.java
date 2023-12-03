package com.adevinta.lbc_fizzbuzz.model;

import com.adevinta.lbc_fizzbuzz.dto.StatisticsDto;
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



    public static FizzBuzzStatistics fromStatisticsDto(StatisticsDto statisticsDto){
        return FizzBuzzStatistics.builder()
                .int1(statisticsDto.getFirstDivisor())
                .int2(statisticsDto.getSecondDivisor())
                .limit(statisticsDto.getSize())
                .str1(statisticsDto.getStr1())
                .str2(statisticsDto.getStr2())
                .counter(statisticsDto.getCounter()).build();
    }

    public StatisticsDto toStatisticsDto(){
        return StatisticsDto.builder()
                .firstDivisor(this.int1)
                .secondDivisor(this.int2)
                .size(this.limit)
                .str1(this.str1)
                .str2(this.str2)
                .counter(this.getCounter()).build();
    }
}
