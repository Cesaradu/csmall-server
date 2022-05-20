package com.gs.csmall.commons.exception.handler;

import com.gs.csmall.commons.exception.ServiceException;
import com.gs.csmall.commons.response.JsonResult;
import com.gs.csmall.commons.response.ServiceCode;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleServiceException(ServiceException serviceException) {
        return JsonResult.fail(serviceException);
    }

    @ExceptionHandler(BindException.class)
    public JsonResult<Void> handleBindException(BindException bindException) {
        String message = bindException.getBindingResult().getFieldError().getDefaultMessage();
        return JsonResult.fail(ServiceCode.BAD_REQUEST, message);
    }

    @ExceptionHandler(Throwable.class)
    public JsonResult<Void> handleThrowable(Throwable throwable) {
        throwable.printStackTrace();
        return JsonResult.fail(ServiceCode.INTERNAL_SERVER_ERROR, "服务器忙，请稍后再次尝试！");
    }

}
