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



## 매핑 정보

### @RestController

> @Controller는 반환 값이 String이면 뷰 이름으로 인식되어 뷰를 찾고 뷰가 렌더링 된다. 

> @RestController는 반환 값으로 뷰를 찾는 것이 아니라 HTTP 메시지 바디에 바로 입력한다.

* HTTP 메서드

> @RequestMapping에 method 속성으로 HTTP 메서드를 지정하지 않으면 HTTP 메서드와 무관하게 호출된다.

> GET, HEAD, POST, PUT, PATCH, DELETE 모두 허용


