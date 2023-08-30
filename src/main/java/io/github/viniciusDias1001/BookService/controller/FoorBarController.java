package io.github.viniciusDias1001.BookService.controller;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("book-service")
public class FoorBarController {


    private Logger logger= LoggerFactory.getLogger(FoorBarController.class);
    @GetMapping("ForBar")
    //@Retry(name = "default", fallbackMethod = "fallbackMethod")
    @CircuitBreaker(name = "default",fallbackMethod = "fallbackMethod")
    public String fooBar(){
        logger.info("Request-FooBar is received");
        var response =new RestTemplate().getForEntity("http://localhost:8080/foo-bar",String.class);
        return response.getBody();
    }


    public String fallbackMethod(Exception ex){
        return "Tentamos mas não deu certo";
    }
}
