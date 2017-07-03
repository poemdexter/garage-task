package com.poemdexter.garage.service

import groovy.json.JsonSlurper
import org.springframework.stereotype.Service

@Service
class WeatherService {

    def getTempByZip(String zip) {

        def url = "http://api.openweathermap.org/data/2.5/weather?zip=$zip,us&units=imperial&APPID=f413ed752b6a6c5c30869718762a336f"

        def slurper = new JsonSlurper()

        def result = slurper.parse(url.toURL().text)
        return result.main.temp
    }
}
