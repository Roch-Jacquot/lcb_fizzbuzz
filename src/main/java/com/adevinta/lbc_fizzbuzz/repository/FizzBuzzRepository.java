package com.adevinta.lbc_fizzbuzz.repository;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FizzBuzzRepository extends JpaRepository<FizzBuzzStatisticsDto, Long> {

    /**
     * findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2 searches for the FizzBuzz statistics stored
     * @param int1 first divisor of the fizzbuzz
     * @param int2 second divisor of the fizzbuz
     * @param limit size of the list
     * @param str1 value to use with int1
     * @param str2 value to use with int2
     * @return Option of FizzBuzzStatisticsDto as the object might not exist already in database
     */
    Optional<FizzBuzzStatisticsDto> findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2(int int1, int int2, int limit, String str1, String str2);

    /**
     * findTopByOrderByCounterDesc searches for the fizzBuzzStatistics of the most generated FizzBuzz
     * @return Optional of FizzBuzzStatisticsDto as it might be the first call
     */
    Optional<FizzBuzzStatisticsDto> findTopByOrderByCounterDesc();
}
