package kr.or.ddit.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;

@Configuration // <context:annotation-config/> 역활을 @configuration에서 담당
@ComponentScan(basePackages = {"kr.or.ddit"}, //<context:component-scan/> 이부분
	includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Aspect.class)) //<context:include-filter 이부분 
@EnableAspectJAutoProxy //<aop:aspectj-autoproxy/> 이부분

public class AopScanConfig {

}
