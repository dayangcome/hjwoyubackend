package com.example.hjwoyu.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 大洋
 * @since 2023-11-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Uandi implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long uid;

    private Long iid;

    /**
     * 1：点赞，0：无态度，2：点踩
     */
    private Integer attitude;


}
