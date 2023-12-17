package com.example.hjwoyu.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 大洋
 * @since 2023-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * 反馈类型，0：普通反馈，1：举报其他动态  2: 账号封号申诉
     */
    private Integer type;

    /**
     * 反馈人uid
     */
    private Long useruid;

    private String content;

    private String email;

    private String phone;

    /**
     * 被举报的讨论iid
     */
    private Long reportiid;

    /**
     * 举报类型，可以为null
     */
    private String reporttype;

    private String message;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 发送时间
     */
    private LocalDateTime createTime;

    /**
     * 逻辑删除
     */
    @TableLogic
    private Boolean deleted;


}
