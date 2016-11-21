package com.luv2code.springdemo.coaches;

import com.luv2code.springdemo.coaches.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static java.lang.System.out;


/**
 * @author Dmytro Melnychuk
 */
@Component
@Scope("singleton")
public class CricketCoach implements Coach
{
    @Value("melnik@mit.com")
    private String emailAddress;
    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("myFortune")
    private FortuneService fortuneService;

    public CricketCoach() {
    }

    public CricketCoach(FortuneService reservedFortuneService) {
        out.println("Reserved fortune: "+reservedFortuneService.getFortune());
        fortuneService=reservedFortuneService;
    }

    @Override
    public String getDailyWorkout()
    {
        return fortuneService.getFortune();
    }


    public FortuneService getFortuneService()
    {
        return fortuneService;
    }

    @PostConstruct
    public void afterPropertiesSet()
    {
        out.println("CricketCoach initialized");
    }

    @PreDestroy
    public void beforeDestroy()
    {
        out.println("CricketCoach destroyed");
    }

}
