package br.com.fabioney

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.w3c.dom.css.Counter
import java.util.concurrent.atomic.AtomicLong

@RestController
class GreentingController {


    val counter: AtomicLong = AtomicLong()
    @RequestMapping("/greeting")
    fun greeting(@RequestParam(value="name", defaultValue = "World") name: String?): Greeting {
        return Greeting(counter.incrementAndGet(), "Hello, $name")
    }
}