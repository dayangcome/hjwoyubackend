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
 * @since 2023-12-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 评论数量
     */
    private Integer commentCounts;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 简介
     */
    private String summary;

    /**
     * 标题
     */
    private String title;

    /**
     * 浏览数量
     */
    private Integer viewCounts;

    /**
     * 是否置顶
     */
    private Integer weight;

    /**
     * 作者id
     */
    private Long authorId;

    /**
     * 内容id
     */
    private Long bodyId;

    /**
     * 类别id
     */
    private Integer categoryId;

    /**
     * 0：未删除，1：删除
     */
    @TableLogic
    private Boolean deleted;

    /**
     * 作者头像
     */
    private String authorAva;

    /**
     * 作者名字
     */
    private String authorName;

    /**
     * 封面图片链接，没有则为空
     */
    private String havepic;


}
