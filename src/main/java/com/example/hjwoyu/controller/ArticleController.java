package com.example.hjwoyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Article;
import com.example.hjwoyu.service.IArticleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-12-24
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private IArticleService articleService;

    /**
     * 根据给定的页码和每页显示的数量，返回文章的分页信息
     *
     * @param page 当前页码
     * @param pageSize 每页显示的文章数量
     * @return 文章的分页信息
     */
    @GetMapping("/page")
    public R page(Integer page, Integer pageSize){
        Page<Article> pageinfo=new Page<>(page,pageSize);
        LambdaQueryWrapper<Article> queryWrapper=new LambdaQueryWrapper<>();
        //按照创建时间排序
        queryWrapper.orderByDesc(Article::getCreateDate);  
        articleService.page(pageinfo,queryWrapper);
        return R.success(pageinfo);
    }

}

