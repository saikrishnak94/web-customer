package com.CustomerControllers;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class CRMLoggingAspect {

	private Logger logger=Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.CustomerControllers.CustomerController.*(..))")
	private void forControllerPackage(){}
	
	@Pointcut("execution(* com.CustomerControllers.AddressDAOImpl.*(..))")
	private void forDaoimplPackage(){}
	
	@Pointcut("execution(* com.CustomerControllers.AddressDAO.*(..))")
	private void forDaoPackage(){}
	
	@Pointcut("execution(* com.CustomerControllers.CustomerServiceImpl.*(..))")
	private void forServiceimplPackage(){}
	
	@Pointcut("execution(* com.CustomerControllers.CustomerService.*(..))")
	private void forServicePackage(){}
	
	@Pointcut("forControllerPackage() || forDaoimplPackage() || forDaoPackage() || forServiceimplPackage() || forServicePackage()")
	private void forAllPackage(){}
	
	@Before("forAllPackage()")
	public void before(JoinPoint theJoinPoint){
		String theMethod=theJoinPoint.getSignature().toShortString();
		logger.info("@Before calling method "+ theMethod);
	}
	
	/*@AfterReturning("forAllPackage()")
	public void afterReturning(JoinPoint theJoinPoint){
		
	}*/
}
