package org.rule.engine.base;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 200 OK - [GET]：服务器成功返回用户请求的数据，该操作是幂等的（Idempotent）。
 * 201 CREATED - [POST/PUT/PATCH]：用户新建或修改数据成功。
 * 202 Accepted - [*]：表示一个请求已经进入后台排队（异步任务）
 * 204 NO CONTENT - [DELETE]：用户删除数据成功。
 * 400 INVALID REQUEST - [POST/PUT/PATCH]：用户发出的请求有错误，服务器没有进行新建或修改数据的操作，该操作是幂等的。
 * 401 Unauthorized - [*]：表示用户没有权限（令牌、用户名、密码错误）。
 * 403 Forbidden - [*] 表示用户得到授权（与401错误相对），但是访问是被禁止的。
 * 404 NOT FOUND - [*]：用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的。
 * 406 Not Acceptable - [GET]：用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）。
 * 410 Gone -[GET]：用户请求的资源被永久删除，且不会再得到的。
 * 422 Unprocesable entity - [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误。
 * 500 INTERNAL SERVER ERROR - [*]：服务器发生错误，用户将无法判断发出的请求是否成功。
 * 502 网关错误
 * 503 Service Unavailable
 * 504 网关超时
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultInfo<T> {

    public static final int SUCCESS = 200;
    public static final int FAILURE = 400;

    public static final String MSG_SUCCESS = "成功";
    public static final String MSG_FAILURE = "失败";

    private Integer code;
    private String message;
    private T data;
    private Long timestamp;

    public static <T> ResultInfo<T> OK() {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS);
    }

    public static <T> ResultInfo<T> OK(String message) {
        return new ResultInfo<>(ResultInfo.SUCCESS, message);
    }


    public static <T> ResultInfo<T> OK(T data) {
        return new ResultInfo<>(ResultInfo.SUCCESS, ResultInfo.MSG_SUCCESS, data);
    }


    public static <T>ResultInfo<T> FALL(String message) {
        return new ResultInfo<>(ResultInfo.FAILURE, message);
    }

    public static ResultInfo<?> FALL() {
        return new ResultInfo<>(ResultInfo.FAILURE, ResultInfo.MSG_FAILURE);
    }

    public ResultInfo(Integer code) {
        this.code = code;
    }

    public ResultInfo(Integer code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public ResultInfo(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }


}
