package com.example.hjwoyu.controller;


import com.example.hjwoyu.common.R;
import com.example.hjwoyu.entity.Dynamic;
import com.example.hjwoyu.entity.Feedback;
import com.example.hjwoyu.service.IDynamicService;
import com.example.hjwoyu.service.IFeedbackService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-12-01
 */
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Resource
    private IFeedbackService feedbackService;

    @Resource
    private IDynamicService dynamicService;

    //添加反馈
    @PostMapping("/addfeedback")
    public R addfeedbcak(@RequestBody Feedback myfeedback){
        myfeedback.setCreateTime(LocalDateTime.now());
        myfeedback.setStatus(0);
        feedbackService.save(myfeedback);

        //举报某个讨论，该讨论举报次数+1，热度-2
        Dynamic dynamic=dynamicService.getById(myfeedback.getReportiid());
        dynamic.setJubaoCounts(dynamic.getJubaoCounts()+1);
        dynamic.setHots(dynamic.getHots()-2);
        dynamicService.updateById(dynamic);
        return R.success("添加成功");
    }
}

