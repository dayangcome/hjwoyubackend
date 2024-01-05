package com.example.hjwoyu.controller;

import com.alibaba.dashscope.aigc.generation.Generation;
import com.alibaba.dashscope.aigc.generation.GenerationResult;
import com.alibaba.dashscope.aigc.generation.models.QwenParam;
import com.alibaba.dashscope.common.Message;
import com.alibaba.dashscope.common.MessageManager;
import com.alibaba.dashscope.common.Role;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.alibaba.dashscope.utils.Constants;
import com.example.hjwoyu.common.R;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 大洋
 * @since 2023-12-02
 */
@RestController
@RequestMapping("/gpt")
public class GPTController {

    //获取回答
    @GetMapping("/answer")
    public R getanswer(String question) throws NoApiKeyException, InputRequiredException {
        Constants.apiKey="sk-b8876154e7e74210bbdace3e65bd4cfa";
        GenerationResult result=callWithMessage(question);
        return R.success(result.getOutput().getChoices().get(0).getMessage().getContent());
    }


    public static GenerationResult callWithMessage(String question)
            throws NoApiKeyException, ApiException, InputRequiredException {
        Generation gen = new Generation();
        MessageManager msgManager = new MessageManager(2);
        Message systemMsg =
                Message.builder().role(Role.SYSTEM.getValue()).content("你是答案之书，你知道很多知识").build();
        Message userMsg = Message.builder().role(Role.USER.getValue()).content(question).build();
        msgManager.add(systemMsg);
        msgManager.add(userMsg);
        QwenParam param =
                QwenParam.builder().model(Generation.Models.QWEN_MAX).messages(msgManager.get())
                        .resultFormat(QwenParam.ResultFormat.MESSAGE)
                        .topP(0.8)
                        .enableSearch(false)
                        .build();
        return gen.call(param);
    }
}
