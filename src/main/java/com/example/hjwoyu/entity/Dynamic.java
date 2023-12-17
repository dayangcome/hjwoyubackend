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
 * @since 2023-11-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Dynamic implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论数量
     */
    private Integer commentCounts;

    /**
     * 点赞数量
     */
    private Integer likeCounts;

    /**
     * 点踩数量
     */
    private Integer dislikeCounts;

    /**
     * 举报数量
     */
    private Integer jubaoCounts;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 内容
     */
    private String contents;

    /**
     * 图片链接
     */
    private String picsrc;

    /**
     * 热度
     */
    private Integer hots;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 作者头像链接
     */
    private String authorPic;

    /**
     * 作者昵称
     */
    private String authorName;

    /**
     * 类别id（1：游戏）
     */
    private Integer category;

    /**
     * 0：未删除，1：删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 备用字段
     */
    private String prepared;


}
