package com.kingyal.usequarttest;

import org.junit.Before;
import org.junit.Test;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest {
    ClassPathXmlApplicationContext context;
    @Before
    public void init() {
        // 启动工厂
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void test1() {
        StdScheduler stdScheduler = (StdScheduler)context.getBean("scheduler");
        try {
            // 休眠5s
            Thread.sleep(5000);
            // 暂停
            stdScheduler.pauseJob(JobKey.jobKey("job1", "job_group1"));
            System.out.println("*****暂停任务*****");
            // 休眠5s
            Thread.sleep(5000);
            // 恢复
            stdScheduler.resumeJob(JobKey.jobKey("job1", "job_group1"));
            System.out.println("*****恢复任务*****");
            // 休眠5s
            Thread.sleep(5000);
            // 删除
            stdScheduler.deleteJob(JobKey.jobKey("job1", "job_group1"));
            System.out.println("*****删除任务*****");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        StdScheduler stdScheduler = (StdScheduler)context.getBean("scheduler");
        try {
            // 休眠5s
            Thread.sleep(5000);
            stdScheduler.pauseJobs(GroupMatcher.<JobKey>groupEquals("job_group1"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
