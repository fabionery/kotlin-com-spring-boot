package br.com.fabioney.math

import org.springframework.web.bind.annotation.PathVariable
import kotlin.math.sqrt

class SimpleMath {
    fun sum(numberOne: Double, numberTwo: Double) = numberOne + numberTwo;
    fun subtract(numberOne: Double, numberTwo: Double) = numberOne - numberTwo;
    fun multi(numberOne: Double, numberTwo: Double) = numberOne * numberTwo;
    fun divisible(numberOne: Double, numberTwo: Double) = numberOne / numberTwo;
    fun mean(numberOne: Double, numberTwo: Double) = (numberOne + numberTwo) / 2;
    fun squareRoot(number: Double) = sqrt(number);

}