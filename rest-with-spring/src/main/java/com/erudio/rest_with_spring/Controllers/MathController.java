package com.erudio.rest_with_spring.Controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.erudio.rest_with_spring.Converters.NumberConverter;
import com.erudio.rest_with_spring.exceptions.UnsupportedMathOperationsException;
import com.erudio.rest_with_spring.math.SimpleMath;

@RestController
public class MathController {
    private final AtomicLong counter= new AtomicLong();
    private SimpleMath math = new SimpleMath();

    //recuperar dados da url
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double sum(
        
        @PathVariable(value="numberOne")
        String numberOne,
        @PathVariable(value="numberTwo")
        String numberTwo
    ) throws Exception
    {
        if ( !NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/mult/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double mult(
        
        @PathVariable(value="numberOne")
        String numberOne,
        @PathVariable(value="numberTwo")
        String numberTwo
    ) throws Exception
        {
            if ( !NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)){
                throw new UnsupportedMathOperationsException("Please set a numeric value");
            }
            return math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
        }
    @RequestMapping(value="/sub/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double sub(
            
        @PathVariable(value="numberOne")
        String numberOne,
        @PathVariable(value="numberTwo")
        String numberTwo
        ) throws Exception
            {
                if ( !NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)){
                    throw new UnsupportedMathOperationsException("Please set a numeric value");
                }
                return math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }
        
    @RequestMapping(value="/div/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double div(
                
            @PathVariable(value="numberOne")
            String numberOne,
            @PathVariable(value="numberTwo")
                String numberTwo
            ) throws Exception
                {
                    if ( !NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)){
                        throw new UnsupportedMathOperationsException("Please set a numeric value");
                    }
                    return math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
                }
    @RequestMapping(value="/med/{numberOne}/{numberTwo}",method=RequestMethod.GET)
    public Double med( @PathVariable(value="numberOne")String numberOne,@PathVariable(value="numberTwo")String numberTwo)throws Exception{

        if ( !NumberConverter.isNumeric(numberOne)||!NumberConverter.isNumeric(numberTwo)){
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return math.med(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value="/raiz/{numberOne}",method=RequestMethod.GET)
    public Double raiz(@PathVariable(value="numberOne")String numberOne) throws Exception{
        
        if ( !NumberConverter.isNumeric(numberOne)){
            throw new UnsupportedMathOperationsException("Please set a numeric value");
        }
        return (Math.sqrt(NumberConverter.convertToDouble(numberOne)));
    }            
}
