package com.example.hjwoyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author 大洋
 * @since 2023-11-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dyuser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是不是怀瑾握瑜成员，1：是，0：否
     */
    private Boolean admin;

    /**
     * 注册时间
     */
    private LocalDateTime createDate;

    /**
     * 是否删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * qq号（登录验证用）
     */
    private String qqnum;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 手机号
     */
    private String address;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像链接
     */
    private String avatar;

    /**
     * 状态
     */
    private String status;

    /**
     * 个人介绍
     */
    private String intro;

    private String school;

    private String major;

    private String sex;
}
