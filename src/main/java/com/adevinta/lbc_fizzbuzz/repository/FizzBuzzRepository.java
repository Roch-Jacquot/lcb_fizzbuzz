package com.adevinta.lbc_fizzbuzz.repository;

import com.adevinta.lbc_fizzbuzz.dto.StatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FizzBuzzRepository extends JpaRepository<StatisticsDto, Long> {
    public Optional<StatisticsDto> findByFirstDivisorAndSecondDivisorAndSizeAndStr1AndStr2(int int1, int int2, int limit, String str1, String str2);

    public Optional<StatisticsDto> findTopByOrderByCounterDesc();
}
