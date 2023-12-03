package com.adevinta.lbc_fizzbuzz.service;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import com.adevinta.lbc_fizzbuzz.model.FizzBuzzStatistics;
import com.adevinta.lbc_fizzbuzz.repository.FizzBuzzRepository;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final FizzBuzzRepository fizzBuzzRepository;

    public StatisticsService(FizzBuzzRepository fizzBuzzRepository) {
        this.fizzBuzzRepository = fizzBuzzRepository;
    }

    public FizzBuzzStatistics findMostCommonFizzBuzz(){
        FizzBuzzStatisticsDto fizzBuzzStatisticsDto = fizzBuzzRepository.findTopByOrderByCounterDesc().orElseThrow();
        FizzBuzzStatistics.fromStatisticsDto(fizzBuzzStatisticsDto);

        return FizzBuzzStatistics.fromStatisticsDto(fizzBuzzStatisticsDto);
    }
    public FizzBuzzStatisticsDto findCurrentFizzBuzzByParameters(int int1, int int2, int limit, String str1, String str2){
        return fizzBuzzRepository.findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2(int1, int2, limit, str1, str2)
                .orElse(FizzBuzzStatisticsDto.builder().firstDivisor(int1).secondDivisor(int2)
                        .size(limit).str1(str1).str2(str2).counter(0L).build());
    }

    public void saveFizzBuzz(FizzBuzzStatisticsDto dto){
        fizzBuzzRepository.save(dto);
    }

}
