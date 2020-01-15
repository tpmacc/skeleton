package skeleton.greeting


import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

import java.util.concurrent.atomic.AtomicLong

@RestController
class GreetingController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(
                id: counter.incrementAndGet(),
                content: "Hello, ${name}"
        )
    }
}
