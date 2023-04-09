# javaSpringBoot-MVC-Basic

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



### HTTP mapping

* @RequestMapping(value = "path", method=RequestMothod.GET)
  
  - path 호출이 오면 이 메서드가 실행되도록 매핑 
  - 대부분의 속성을 배열로 제공하므로 다중 설정이 가능 
  - ex) {"/hello-basic", "/hello-go"}
  - http 메서드를 지정하지 않으면 메서드와 무관하게 모든 메서드가 호출 가능하다

* @GetMapping("/mapping")

  - HTTP 메서드를 축약한 애노테이션
  - 더욱 직관적으로 코드를 알아볼 수 있다.
  - @RequestMapping + get
  - @GetMapping("mapping/{userId}") 등으로 리소스 경로에 식별자 주입 가능
  - 인자로 받을 때는 @PathVariable("userId") 사용



-> RequestMapping, GetMapping RespnoseBody 정리 해서 다시

### HTTP Response

> 스프링(서버)에서 응답 데이터를 만드는 방법은 크게 3가지이다.

1. 정적 리소스

  * 웹 브라우저에 정적인 HTML, css, js를 제공할 때는, 정적 리소스를 사용한다.

2. 뷰 템플릿 사용

  * 웹 브라우저에 동적인 HTML을 제공할 때는 뷰 템플릿을 사용한다.

3. HTTP 메시지 사용

  * HTTP API를 제공하는 경우에는 HTML이 아니라 데이터를 전달해야 하므로, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.


* 정적 리소스

> 스프링 부트는 클래스패스의 다음 디렉토리에 있는 정적 리소스를 제공한다.

> "/static, /public, /resources, /META-INF/resources

> src/main/resources는 리소스를 보관하는 곳이고 또 클래스 패스의 시작 경로이다.

> 따라서 다음 디렉토리에 리소스를 넣어두면 스프링 부트가 정적 리소스로 서비스를 제공한다.

  + 정적 리소스 경로
  
  > src/main/resources/static

  * 다음 경로에 파일이 들어있으면
  
  > src/main/resources/static/basic/hello-form.html

  * 웹 브라우저에서 다음과 같이 실행하면 된다.

  > http://localhost:8080/basic/hello-form.html

  > 정적 리소스는 해당 파일을 변경없이 그대로 서비스 하는 것이다.

* 뷰 템플릿

> 뷰 템플릿을 거쳐서 HTML이 생성되고, 뷰가 응답을 만들어서 전달한다.

> 일반적으로 HTML을 동적으로 생성하는 용도로 사용하지만, 다른 것들도 가능하다. 

> 뷰 템플릿이 만들 수 있는 것이라면 뭐든지 가능하다

> 스프링 부트는 기본 뷰 템플릿 경로를 제공한다.

  + 뷰 템플릿 경로
  
  > src/main/resources/templates

  * 뷰 템플릿 생성

  > src/main/resources/templates/response/hello.html




* HTTP 응답 - HTTP API, 메시지 바디에 직접 입력

> HTTP API를 제공하는 경우에는 HTML이 아니라 데이터를 전달해야 하므로, HTTP 메시지 바디에 JSON 같은 형식으로 데이터를 실어 보낸다.

* String 반환

> View or HTTP 메시지

> @ResponseBody가 없으면 뷰 리졸버가 실행되어 뷰를 찾고 렌더링

> @ResponseBody가 있으면 뷰 리졸버를 실행하지 않고, HTTP 메시지 바디에 직접 String을 입력한다

* Void를 반환하는 경우

> @Controller를 사용하고, HttpServletResponse, OutputStream(Writer) 같은 HTTP 메시지 바디를 처리하는 파라미터가 없으면 요청 URL을 참고해서 논리 뷰 이름으로 사용

> 명시성이 떨어지기 때문에 권장하지 x

* HTTP 메시지

> @ResponseBody, HttpEntity를 사용하면, 뷰 템플릿을 사용하는 것이 아니라, HTTP 메시지 바디에 직접 응답 데이터를 출력할 수 있다. 


## Item Service Web Application

* 요구 사항
> 상품을 관리할 수 있는 서비스 구현

* 상품 도메인 모델

  + 상품 ID
  + 상품명
  + 가격
  + 수량

* 상품 관리 기능

  + 상품 목록
  + 상품 상세
  + 상품 등록
  + 상품 수정

![image](https://user-images.githubusercontent.com/94096054/148730504-7c5a4eb0-4ea9-4f82-8042-45ce22fc4ac1.png)

