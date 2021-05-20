package com.example.aopdemo.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class ExecutionTimeLogger {

	@Around("@annotation(com.example.aopdemo.controller.LoggingExecutionTime)")
	public Object trackTime(final ProceedingJoinPoint proceedingJointPoint) throws Throwable {
		final long startTime = System.currentTimeMillis();
		final Object obj = proceedingJointPoint.proceed();
		final long endTime = System.currentTimeMillis();
		final long executionTime = endTime - startTime;
		log.info(proceedingJointPoint.getSignature() + "Execution Time is :   " + executionTime);

		return obj;

	}

}
