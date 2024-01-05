package com.example.hjwoyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Dyuser;
import com.example.hjwoyu.service.IDyuserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-11-20
 */
@RestController
@RequestMapping("/dyuser")
public class DyuserController {
    @Resource
    private IDyuserService dyuserService;

    @GetMapping("/login")
    public R login(String token) {
        LambdaQueryWrapper<Dyuser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dyuser::getQqnum, token);
        Dyuser dyuser = dyuserService.getOne(queryWrapper);
        if (dyuser == null) {
            return R.fail("");
        }
        if (dyuser.getAdmin()) {
            dyuser.setLastLogin(LocalDateTime.now());
            //更新登录时间
            dyuserService.updateById(dyuser);
            return R.success(dyuser);
        }
        return R.fail("");
    }


}

