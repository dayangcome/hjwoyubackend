package com.example.hjwoyu.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2023-11-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dycomment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String content;

    private LocalDateTime createDate;

    /**
     * 点赞数量
     */
    private Integer likes;

    /**
     * 评论者uid
     */
    private Long authorId;

    /**
     * 动态uid
     */
    private Long parentId;

    /**
     * 回复的评论者uid
     */
    private Long toUid;

    private String level;

    /**
     * 评论者头像链接
     */
    private String authorAva;

    /**
     * 评论者昵称
     */
    private String authorName;

    /**
     * 0：未删除，1：删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 回复的评论者名字
     */
    private String toName;


}
