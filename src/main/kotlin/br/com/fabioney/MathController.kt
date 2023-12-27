package br.com.fabioney

import br.com.fabioney.Exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.sqrt

@RestController
class MathController {

    val counter: AtomicLong = AtomicLong()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    @RequestMapping(value = ["/mean/{numberOne}/{numberTwo}"])
    fun mean(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo) / 2;
    }
    @RequestMapping(value = ["/squareRoot/{number}"])
    fun squareRoot(@PathVariable(value="number") number: String?
    ): Double {
        if (!isNumeric(number))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return sqrt(convertToDouble(number));
    }

    @RequestMapping(value = ["/subtract/{numberOne}/{numberTwo}"])
    fun subtract(@PathVariable(value="numberOne") numberOne: String?,
                 @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = ["/multi/{numberOne}/{numberTwo}"])
    fun multi(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    @RequestMapping(value = ["/divisible/{numberOne}/{numberTwo}"])
    fun divisible(@PathVariable(value="numberOne") numberOne: String?,
            @PathVariable(value="numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0;

        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0;
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false;
        val number = strNumber.replace(",".toRegex(), ".");
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex());

    }
}