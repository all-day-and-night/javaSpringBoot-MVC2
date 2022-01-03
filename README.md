# javaSpringBoot-MVC2

> 스프링 MVC의 기본 기능에 대한 정리 및 실습



## 로깅

* 로깅 라이브러리
  + SLF4J - http://www.slf4j.org
  + Logback - http://logback.qos.ch

* 로그 선언

  + private Logger log = LoggerFactory.getLogger(getClass());
  + private static final Logger log = LoggerFactory.getLogger(Xxx.class)

* 로그 호출 

  + log.info("hello");
  + 실무에서는 System.out.println을 사용하지 않고 항상 로그를 사용한다

