package com.example.hjwoyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Items;
import com.example.hjwoyu.service.IItemsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-11-23
 */
@RestController
@RequestMapping("/items")
public class ItemsController {

    @Resource
    private IItemsService iItemsService;

    @GetMapping("/getitem")
    public R listitem(Integer type) {         //按照类型查找
        LambdaQueryWrapper<Items> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Items::getCategory, type);
        List<Items> itemsList = iItemsService.list(queryWrapper);
        return R.success(itemsList);
    }

    @GetMapping("/likeitem")
    public R likeitem(Long itemid) {         //给某个物品点赞
        Items items = iItemsService.getById(itemid);
        if (items == null) {
            return R.fail("");
        }
        items.setPrepared1(items.getPrepared1() + 1);
        iItemsService.updateById(items);
        return R.success("点赞成功");
    }

    @PostMapping("/additem")
    public R additem(@RequestBody Items item) {         //按照类型添加
        item.setReleaseDate(LocalDateTime.now());
        item.setPrepared1(0);
        //逻辑删除，审核通过后改为true
        item.setDeleted(true);
        iItemsService.save(item);
        return R.success("itemsList");
    }

}

