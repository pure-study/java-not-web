package net.will.javatest.javax.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Conclusion: @PostConstruct & @PreDestroy actually are not working without the support of a container.
 * 
 * @author Will
 */
public class Irrelevant {
    private static Logger logger = LoggerFactory.getLogger(Irrelevant.class);
    
    public Irrelevant() {
        logger.info("See if the logging is working - this object is constructed.");
    }
    
    @PostConstruct
    public void someMethodFirst() {
        logger.info("Some method with @PostConstruct");
    }
    
    @PreDestroy
    public void someMethodSecond() {
        logger.info("Some method with @PreDestroy");
    }
}
