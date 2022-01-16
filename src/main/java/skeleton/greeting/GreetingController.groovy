package skeleton.greeting

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    @Value('${skel.envvar}')
//    @Value("${systemValue}")
    String variable;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/param")
        Greeting greetingWithRequestParam(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(
                id: counter.incrementAndGet(),
                content: "Hello, ${name}"
        )
    }

    @RequestMapping("/variable")
    Greeting greetingWithEnvironmentVariable() {
        return new Greeting(
                id: counter.incrementAndGet(),
                content: "Hello, ${variable}"
        )
    }

}
