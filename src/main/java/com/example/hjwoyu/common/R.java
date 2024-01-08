package com.example.hjwoyu.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 通用结果类
 * </p>
 *
 * @author 大洋
 * @since 2023-11-28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private boolean success;

    private Integer code;

    private String msg;

    private Object data;


    public static R success(Object data) {
        return new R(true, 200, "success", data);
    }

    public static R fail(String msg) {
        return new R(false, 100, msg, null);
    }
}
