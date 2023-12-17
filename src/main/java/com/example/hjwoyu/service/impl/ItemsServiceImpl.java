package com.example.hjwoyu.service.impl;

import com.example.hjwoyu.entity.Items;
import com.example.hjwoyu.mapper.ItemsMapper;
import com.example.hjwoyu.service.IItemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 大洋
 * @since 2023-11-23
 */
@Service
public class ItemsServiceImpl extends ServiceImpl<ItemsMapper, Items> implements IItemsService {

}
