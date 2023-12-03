package com.adevinta.lbc_fizzbuzz.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder()
@Table(name = "statistics")
public class StatisticsDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    int firstDivisor;

    int secondDivisor;

    int size;

    String str1;

    String str2;

    Long counter;

}
