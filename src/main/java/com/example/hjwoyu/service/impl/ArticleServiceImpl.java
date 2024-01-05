package com.example.hjwoyu.service.impl;

import com.example.hjwoyu.entity.Article;
import com.example.hjwoyu.mapper.ArticleMapper;
import com.example.hjwoyu.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 大洋
 * @since 2023-12-24
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
