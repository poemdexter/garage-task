package com.poemdexter.garage.controller

import com.poemdexter.garage.service.WeatherService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.RequestMapping


import static org.springframework.web.bind.annotation.RequestMethod.GET
import static org.springframework.web.bind.annotation.RequestMethod.POST

@Controller
class GarageController {

    @Autowired WeatherService weatherService

    @RequestMapping(value = "/", method = GET)
    String index(final ModelMap model) {

        model.addAttribute('g', new GarageForm())
        model.addAttribute('result', '')

        return 'index'
    }

    @RequestMapping(value = "/", method = POST)
    String submit(final GarageForm request, final ModelMap model) {

        def temp = weatherService.getTempByZip(request.zipCode)

        def result = "The temp in $request.zipCode is $temp F."

        model.addAttribute('g', new GarageForm())
        model.addAttribute('result', result)

        return 'index'
    }
}

class GarageForm {
    String zipCode
    String temp
}