package com.udemy.kad.lesson2.controller

import com.udemy.kad.lesson2.exceptions.UnsupportedMathOperationException
import com.udemy.kad.lesson2.service.MathService
import com.udemy.kad.lesson2.utils.NumberConverter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    private val mathService: MathService = MathService()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.subtraction(
            NumberConverter.convertToDouble(numberOne),
            NumberConverter.convertToDouble(numberTwo)
        )
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.multiplication(
            NumberConverter.convertToDouble(numberOne),
            NumberConverter.convertToDouble(numberTwo)
        )
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.division(
            NumberConverter.convertToDouble(numberOne),
            NumberConverter.convertToDouble(numberTwo)
        )
    }

    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(
        @PathVariable(value = "numberOne") numberOne: String?,
        @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(
        @PathVariable(value = "number") number: String?
    ): Double {
        if (!NumberConverter.isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!")
        return mathService.squareRoot(NumberConverter.convertToDouble(number))
    }

}