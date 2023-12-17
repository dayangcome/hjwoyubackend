package com.example.hjwoyu.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Dycomment;
import com.example.hjwoyu.entity.Dynamic;
import com.example.hjwoyu.service.IDycommentService;
import com.example.hjwoyu.service.IDynamicService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-11-28
 */
@RestController
@RequestMapping("/dycomment")
public class DycommentController {

    @Resource
    private IDycommentService dycommentService;

    @Resource
    private IDynamicService dynamicService;

    @GetMapping("/getcomments")
    public R listcomments(Long iid){         //按照父动态查询评论
        LambdaQueryWrapper<Dycomment> queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(Dycomment::getParentId,iid);
        List<Dycomment> dycommentList=dycommentService.list(queryWrapper);
        if(dycommentList==null){
            return R.success(new ArrayList<Dycomment>());
        }
        return R.success(dycommentList);
    }

    @PostMapping("/addcomments")
    public R addcomments(@RequestBody Dycomment mycomment){         //发表评论
        mycomment.setCreateDate(LocalDateTime.now());
        dycommentService.save(mycomment);

        //发表评论，原讨论评论数+1，热度+2
        Dynamic dynamic=dynamicService.getById(mycomment.getParentId());
        dynamic.setCommentCounts(dynamic.getCommentCounts()+1);
        dynamic.setHots(dynamic.getHots()+2);
        dynamicService.updateById(dynamic);

        return R.success("添加成功");
    }


    @GetMapping("/delcomment")
    public R delcomment(Integer commentid){         //删除评论
        try{
            //删除评论，原讨论评论数-1，热度-2
            Dycomment mycomment=dycommentService.getById(commentid);
            Dynamic dynamic=dynamicService.getById(mycomment.getParentId());
            dynamic.setCommentCounts(dynamic.getCommentCounts()-1);
            dynamic.setHots(dynamic.getHots()-2);
            dynamicService.updateById(dynamic);

            dycommentService.removeById(commentid); //从数据库中删掉该评论

        }catch (Exception e){
            return R.fail("删除失败");
        }
        return R.success("删除成功");
    }

}

