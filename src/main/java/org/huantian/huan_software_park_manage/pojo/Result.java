package org.huantian.huan_software_park_manage.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
/**
 * 返回实体类
 * @author 幻天
 */
public class Result<T> {
    private Integer code;//业务状态码
    private String msg;//提示信息
    private T data;//响应数据

    //快速返回操作成功响应结果(带响应数据)
    public static <E> Result<E> success(E data) {
        return new Result<>(200, "操作成功", data);
    }

    //快速返回操作成功响应结果
    public static Result success() {
        return new Result(200, "操作成功", null);
    }

    // 
    public static Result error(int code, String message) {
        return new Result(code, message, null);
    }
    /**
     * 返回状态码
     * @author 幻天
     */
    public static class Code{
        /**
         * 操作成功
         */
        public static final int SUCCESS = 200;

        /**
         * 对象创建成功
         */
        public static final int CREATED = 201;

        /**
         * 请求已经被接受
         */
        public static final int ACCEPTED = 202;

        /**
         * 操作已经执行成功，但是没有返回数据
         */
        public static final int NO_CONTENT = 204;

        /**
         * 资源已被移除
         */
        public static final int MOVED_PERM = 301;

        /**
         * 重定向
         */
        public static final int SEE_OTHER = 303;

        /**
         * 资源没有被修改
         */
        public static final int NOT_MODIFIED = 304;

        /**
         * 参数列表错误（缺少，格式不匹配）
         */
        public static final int BAD_REQUEST = 400;

        /**
         * 未授权
         */
        public static final int UNAUTHORIZED = 401;

        /**
         * 访问受限，授权过期
         */
        public static final int FORBIDDEN = 403;

        /**
         * 资源，服务未找到
         */
        public static final int NOT_FOUND = 404;

        /**
         * 不允许的http方法
         */
        public static final int BAD_METHOD = 405;

        /**
         * 资源冲突，或者资源被锁
         */
        public static final int CONFLICT = 409;

        /**
         * 不支持的数据，媒体类型
         */
        public static final int UNSUPPORTED_TYPE = 415;

        /**
         * 系统内部错误
         */
        public static final int ERROR = 500;

        /**
         * 接口未实现
         */
        public static final int NOT_IMPLEMENTED = 501;


        /**
         * vip
         */
        public static final int VIP = 701;


        /**
         * 系统警告消息
         */
        public static final int WARN = 601;
    }
}