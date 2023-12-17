package com.example.hjwoyu.entity;

import java.math.BigDecimal;
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
 * @since 2023-11-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Items implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String iname;

    private Double rating;

    /**
     * 游戏有出厂商
     */
    private String manufacturer;

    /**
     * 1：游戏
     */
    private Integer category;

    /**
     * 介绍
     */
    private String description;

    private LocalDateTime releaseDate;

    private String platform;

    private BigDecimal price;

    /**
     * 0：未删除，1：删除
     */
    @TableLogic
    private Boolean deleted;

    private Integer prepared1;

    private String prepared2;

    /**
     * 图片链接
     */
    private String imgsrc;

    /**
     * 启动链接
     */
    private String playsrc;


}
