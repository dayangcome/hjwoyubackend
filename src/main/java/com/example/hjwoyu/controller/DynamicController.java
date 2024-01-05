package com.example.hjwoyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Dynamic;
import com.example.hjwoyu.entity.Uandi;
import com.example.hjwoyu.service.IDynamicService;
import com.example.hjwoyu.service.IUandiService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-11-24
 */
@RestController
@RequestMapping("/dynamic")
public class DynamicController {

    @Resource
    private IDynamicService dynamicService;

    @Resource
    private IUandiService uandiService;

    @GetMapping("/getdy")
    public R listdy(Integer type) {         //按照类型查找
        LambdaQueryWrapper<Dynamic> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dynamic::getCategory, type);
        queryWrapper.orderByDesc(Dynamic::getCreateDate);
        List<Dynamic> dynamicList = dynamicService.list(queryWrapper);
        return R.success(dynamicList);
    }

    @PostMapping("/adddy")
    public R adddy(@RequestBody Dynamic dynamic) {         //发表动态
        dynamic.setCreateDate(LocalDateTime.now());
        dynamic.setDeleted(false);
        dynamicService.save(dynamic);
        return R.success("添加成功");
    }

    @GetMapping("/deldy")
    public R deldy(Integer dyid) {         //删除动态
        try {
            dynamicService.removeById(dyid);
        } catch (Exception e) {
            return R.fail("删除失败");
        }
        return R.success("删除成功");
    }


    @GetMapping("/getdylike/{type}/{uid}")      //获得用户点赞动态
    public R getdyattitudelike(@PathVariable("type") Integer type, @PathVariable("uid") Long uid) {         //按照类型查找
        LambdaQueryWrapper<Uandi> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Uandi::getUid, uid);
        queryWrapper.eq(Uandi::getAttitude, 1);
        List<Uandi> uandisList = uandiService.list(queryWrapper);
        List<Long> likeList = new ArrayList<>();
        for (Uandi u : uandisList) {                        //过滤，找出type和目标相等的动态
            Dynamic dynamic = dynamicService.getById(u.getIid());
            if (dynamic != null && dynamic.getCategory().equals(type)) {
                likeList.add(u.getIid());
            }
        }
        return R.success(likeList);
    }

    @GetMapping("/getdydislike/{type}/{uid}")   //获得用户点踩动态
    public R getdyattitudedislike(@PathVariable("type") Integer type, @PathVariable("uid") Long uid) {         //按照类型查找
        LambdaQueryWrapper<Uandi> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Uandi::getUid, uid);
        queryWrapper.eq(Uandi::getAttitude, 2);
        List<Uandi> uandisList = uandiService.list(queryWrapper);
        List<Long> dislikeList = new ArrayList<>();
        for (Uandi u : uandisList) {                        //过滤，找出type和目标相等的动态
            Dynamic dynamic = dynamicService.getById(u.getIid());
            if (dynamic != null && dynamic.getCategory().equals(type)) {
                dislikeList.add(u.getIid());
            }
        }
        return R.success(dislikeList);
    }


    //点赞或者点踩，code为 1：点赞，2：点踩
    @GetMapping("/changedy/{code}/{uid}/{iid}")
    public R changedy(@PathVariable("code") Integer code, @PathVariable("uid") Long uid, @PathVariable("iid") Long iid) {

        // 定义常量
        final Integer LIKE_CODE = 1;
        final Integer DISLIKE_CODE = 2;

        LambdaQueryWrapper<Uandi> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Uandi::getIid, iid);
        queryWrapper.eq(Uandi::getUid, uid);
        Uandi uandi = uandiService.getOne(queryWrapper);
        if (uandi == null) {
            Uandi uandi1 = new Uandi();
            uandi1.setAttitude(code);
            uandi1.setIid(iid);
            uandi1.setUid(uid);
            uandiService.save(uandi1);
            //如果是点赞，则动态点赞数+1，热度值+3
            if (LIKE_CODE.equals(code)) {
                Dynamic dynamic = dynamicService.getById(iid);
                dynamic.setLikeCounts(dynamic.getLikeCounts() + 1);
                dynamic.setHots(dynamic.getHots() + 3);
                dynamicService.updateById(dynamic);
            }
            //如果是点踩，则动态点踩数+1，热度值-2
            if (DISLIKE_CODE.equals(code)) {
                Dynamic dynamic = dynamicService.getById(iid);
                dynamic.setDislikeCounts(dynamic.getDislikeCounts() + 1);
                dynamic.setHots(dynamic.getHots() - 2);
                dynamicService.updateById(dynamic);
            }
        } else {
            //点赞改为点踩，点踩数+1，点赞数-1，热度-5
            if (LIKE_CODE.equals(uandi.getAttitude())) {
                Dynamic dynamic = dynamicService.getById(iid);
                dynamic.setLikeCounts(dynamic.getLikeCounts() - 1);
                dynamic.setDislikeCounts(dynamic.getDislikeCounts() + 1);
                dynamic.setHots(dynamic.getHots() - 5);
                dynamicService.updateById(dynamic);
            }
            //点踩改为点赞，点赞数+1，点踩数-1，热度+5
            if (DISLIKE_CODE.equals(uandi.getAttitude())) {
                Dynamic dynamic = dynamicService.getById(iid);
                dynamic.setDislikeCounts(dynamic.getDislikeCounts() - 1);
                dynamic.setLikeCounts(dynamic.getLikeCounts() + 1);
                dynamic.setHots(dynamic.getHots() + 5);
                dynamicService.updateById(dynamic);
            }
            uandi.setAttitude(code);
            uandiService.updateById(uandi);
        }
        return R.success("更改成功");
    }

}

