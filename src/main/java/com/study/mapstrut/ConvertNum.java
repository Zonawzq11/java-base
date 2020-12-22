package com.study.mapstrut;

import org.mapstruct.Named;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @Authorzhiqiangwang
 */

@Component
@Named("ConvertNum")
public class ConvertNum {
    public  Long stringToLong(String numberString){
           return  Long.parseLong(numberString);
    }
}
