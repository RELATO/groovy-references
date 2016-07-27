package org.zirbes

import org.joda.time.LocalDate

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import org.springframework.web.bind.annotation.PathVariable

import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicLong

@Configuration
@EnableAutoConfiguration
@RestController
class SampleApplication {

    AtomicLong requestCounter = new AtomicLong()

    Jerk jerk = new Jerk()

    @RequestMapping("/")
    def helloWorld() {
        LocalDate localToday = new LocalDate()
        String today = localToday.toString('yyyy-MM-dd')

        Long requests = requestCounter.incrementAndGet()

        return [message: "Hello Gr8conf", author: "Spring Boot", timestamp: today, requests: requests]
    }

    @RequestMapping("/foas/{subject}")
    def fuckOff(@PathVariable(value='subject') String subject) {

        CopyOnWriteArrayList<String> insults = []

        requestCounter.incrementAndGet()

        jerk.insult('Anonymous', subject.split(',')).subscribe{
            insults << it.toString()
        }

        return insults
    }

    static void main(String[] args) throws Exception {
        SpringApplication.run(SampleApplication.class, args)
    }

}
