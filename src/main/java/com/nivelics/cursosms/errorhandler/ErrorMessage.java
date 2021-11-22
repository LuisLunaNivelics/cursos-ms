package com.nivelics.estudiantesms.errorhandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author Ferney.Estupinan
 * Date: 19/11/2021
 */
@Data
@AllArgsConstructor
public class ErrorMessage {

    private final Date timestamp;
    private final String message;
    private int code;

}
