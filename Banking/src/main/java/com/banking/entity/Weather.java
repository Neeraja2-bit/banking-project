package com.banking.entity;
/*Create a console-based application that:
Accepts daily temperature readings for a week.
Calculates:
Average temperature
Highest and lowest temperature
Days above average

Displays a summary report.
Use:

Arrays or ArrayList to store temperatures.
Loops and conditional logic for calculations.*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Weather {
    public static void main(String[] args){
        if(args.length<7){
            System.out.println("please provide 7 temparaturess");
            return;
        }
        List<Double> temparature = Arrays.stream(args).map(Double::parseDouble).collect(Collectors.toList());

        double average = temparature.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double maxTemparature = temparature.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        long aboveAverage = temparature.stream().filter(temp -> temp>maxTemparature).count();

        System.out.println("aver:"+ average);
        System.out.println("max:"+ maxTemparature);


    }
}
