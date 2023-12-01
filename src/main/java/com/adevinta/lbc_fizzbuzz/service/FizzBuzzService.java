package com.adevinta.lbc_fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class FizzBuzzService {

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

        return Arrays.stream(fizzBuzzResult).toList();
    }

}
