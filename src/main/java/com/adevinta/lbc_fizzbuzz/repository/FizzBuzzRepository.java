package com.adevinta.lbc_fizzbuzz.repository;

import com.adevinta.lbc_fizzbuzz.dto.FizzBuzzStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FizzBuzzRepository extends JpaRepository<FizzBuzzStatisticsDto, Long> {
    Optional<FizzBuzzStatisticsDto> findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2(int int1, int int2, int limit, String str1, String str2);

    Optional<FizzBuzzStatisticsDto> findTopByOrderByCounterDesc();
}
