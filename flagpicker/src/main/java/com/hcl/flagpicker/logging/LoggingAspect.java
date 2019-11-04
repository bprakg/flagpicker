package com.hcl.flagpicker.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import net.bytebuddy.asm.Advice.This;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Around("com.hcl.flagpicker.logging.SystemArchitecture.inWebLayer()")
    public Object loggingAdvice(ProceedingJoinPoint pjp) throws Throwable {
		logger.info("Calling ... "+pjp.getSignature()+"\n");
        Object retVal = pjp.proceed();
        logger.info("Done calling ...\n");
        return retVal;
    }
}
