package com.hcl.flagpicker.logging;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SystemArchitecture {

	@Pointcut("execution(* com.hcl.flagpicker.controller.*.*(..))")
	public void inWebLayer() {
	}

	@Pointcut("within(com.hcl.flagpicker.repository..*)")
	public void inServiceLayer() {
	}
}
