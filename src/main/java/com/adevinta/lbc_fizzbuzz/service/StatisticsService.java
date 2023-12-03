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

    /**
     * findMostCommonFizzBuzz returns a FizzBuzzStatistics object containing the most common fizzbuzz parameters
     * @return FizzBuzzStatistics of the most common FizzBuzz
     */
    public FizzBuzzStatistics findMostCommonFizzBuzz(){
        FizzBuzzStatisticsDto fizzBuzzStatisticsDto = fizzBuzzRepository.findTopByOrderByCounterDesc().orElseThrow();
        FizzBuzzStatistics.fromStatisticsDto(fizzBuzzStatisticsDto);

        return FizzBuzzStatistics.fromStatisticsDto(fizzBuzzStatisticsDto);
    }

    /**
     * findCurrentFizzBuzzByParameters finds or create a new FizzBuzzStatisticsDto
     * @param int1 first divisor of the fizz
     * @param int2 second divisor of the fiz
     * @param limit size of the list
     * @param str1 value to use with int1
     * @param str2 value to use with int2
     * @return FizzBuzzStatisticsDto with 0 or more at the counter.
     */
    public FizzBuzzStatisticsDto findCurrentFizzBuzzByParameters(int int1, int int2, int limit, String str1, String str2){
        return fizzBuzzRepository.findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2(int1, int2, limit, str1, str2)
                .orElse(FizzBuzzStatisticsDto.builder().firstDivisor(int1).secondDivisor(int2)
                        .size(limit).str1(str1).str2(str2).counter(0L).build());
    }

    /**
     * saveFizzBuzz saves a new or new version of a FizzBuzzStatisticsDto
     * @param dto FizzBuzzStatisticsDto to save to the database
     */
    public void saveFizzBuzz(FizzBuzzStatisticsDto dto){
        fizzBuzzRepository.save(dto);
    }

}
