package com.bookcode.entity;





public class RV<T> {
    private boolean code;

    private String msg;

    private T data;

    public RV(boolean code, T data) {
        this.code = code;
        this.data = data;
    }

    public RV(boolean code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RV() {
    }

    /**
     * 成功返回数据
     *
     * @param object 数据
     * @param <T>    数据类型
     */
    public static <T> RV<T> success(T object) {
        return new RV<T>(true, "操作成功", object);
    }

    public static <T> RV<T> success() {
        return new RV<T>(true, "操作成功", null);
    }

    /**
     * 失败返回数据
     *
     * @param msg 错误信息
     */
    public static <T> RV<T> error(String msg) {
        return new RV<T>(false, msg, null);
    }


//    /**
//     * 描述: 通过errorCode和数据对象参数，构建一个新的对象
//     *
//     * @param errorCode
//     * @param data
//     * @return
//     */
//    public static ResultVO result(IErrorCode errorCode, Object data) {
//        return new ResultVO(errorCode, data);
//    }
}
