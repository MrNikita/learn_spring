package com.luv2code.springdemo;

/**
 * @author Dmytro Melnychuk
 */
public class BaseballCoach implements Coach
{
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 minutes on batting practice";
    }
}