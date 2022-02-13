package com.kingyal.usequart;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class MyJob implements Job {
    private static int count = 0;
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        count++;
        System.out.println("count : " + count);
        System.out.println(new Date() + "it is time to running my job!");
    }
}
