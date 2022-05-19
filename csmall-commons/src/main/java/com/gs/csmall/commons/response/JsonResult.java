package com.gs.csmall.commons.response;

import com.gs.csmall.commons.exception.ServiceException;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {
    @ApiModelProperty(value = "业务状态码", position = 1)
    private Integer state;

    @ApiModelProperty(value = "消息", position = 2)
    private String message;

    @ApiModelProperty(value = "数据", position = 3)
    private T data;

    public JsonResult() {
    }

    public static JsonResult<Void> ok() {
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        JsonResult<T> jsonResult = new JsonResult<>();
        jsonResult.state = ServiceCode.OK.getValue();
        jsonResult.data = data;
        return jsonResult;
    }

    public static JsonResult<Void> fail(ServiceException e) {
        return fail(e.getServiceCode(), e.getMessage());
    }

    public static JsonResult<Void> fail(ServiceCode serviceCode, String message) {
        JsonResult<Void> jsonResult = new JsonResult<>();
        jsonResult.state = serviceCode.getValue();
        jsonResult.message = message;
        return jsonResult;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
