package com.ihrm.common.handler;

import com.ihrm.common.entity.Result;
import com.ihrm.common.entity.ResultCode;
import com.ihrm.common.exception.CommonException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 公共异常处理器
 */
//@RestControllerAdvice =  @ControllerAdvice + @ResponseBody
@ControllerAdvice
public class BaseExceptionHandler {
    private static final String logExceptionFormat = "Catch Exception by BaseExceptionHandler : code: %s detail: %s";
    private static Logger logger = LoggerFactory.getLogger(BaseExceptionHandler.class);

    @ExceptionHandler({Exception.class}) //可以针对不同的异常做出捕获
    @ResponseBody
    public Result error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        if (e.getClass() == CommonException.class) {
            CommonException ce = (CommonException) e;
            return new Result(((CommonException) e).getResultCode());
        }

        logger.error("--------------" + String.format(logExceptionFormat, ResultCode.SERVER_ERROR, e.getMessage()), e);
        return new Result(ResultCode.SERVER_ERROR);
    }

}
