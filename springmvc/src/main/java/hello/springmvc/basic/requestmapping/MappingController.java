package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value="/mapping-get-v1", method= RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }

    @GetMapping(value="/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mapping-get-v2");
        return "ok";
    }
    /*
    @GetMapping PathVariable(경로변수 사용)
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String data){
        log.info("mappingPati userId={}", data);
        return "ok";
    }
    /*
    @GetMapping PathVariable(경로변수 사용 다중)
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPati(@PathVariable String userId, @PathVariable Long orderId){
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    /*
    특정 파라미터 조건 매핑
     */

    @GetMapping(value="/mapping-param", params="mode=debug")
    public String mappingParam(){
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
        * headers="mode",
        * headers="!mode"
        * headers="mode=debug"
        * headers="mode!=debug" (! = )
     */

    @GetMapping(value="/mapping-header", headers = "mode=debug")
    public String mappingHeader(){
        log.info("mappingHeander");
        return "ok";
    }
    /*
    미디어 타입 조건 매핑 - HTTP 요청 Content-Type, consume
     */
    @PostMapping(value="/mapping-consume", consumes="application/json")
    public String mappingConsumes(){
        log.info("mappingConsumes");
        return "ok";
    }

    @PostMapping(value="/mapping-produce", produces = "text/html")
    public String mappingProduces(){
        log.info("mappingConsumes");
        return "ok";
    }



}
