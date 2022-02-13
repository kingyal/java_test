package com.kingyal.logbacktest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    private Logger log = LoggerFactory.getLogger(LogbackTest.class);
    @Test
    public void test1() {
        log.trace("hello trace");
        log.debug("hello debug");
        log.info("hello info");
        log.warn("hello warn");
        log.error("hello error");
    }
}
