package cn.abel.controller;

import cn.abel.bean.News;
import cn.abel.service.NewsService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description:
 * @author: lyq
 * @createDate: 2020/1/31
 */

@RestController
@RequestMapping("/new")

public class NewController {

    @Autowired
    private NewsService newsService;

    @PostMapping("/list")
    public Object queryNewList(@RequestBody News news)throws Exception{
        System.out.println(JSON.toJSON(news));
        ExecutorService executorService =Executors.newFixedThreadPool(20);
        for (int i = 0; i < 1; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    newsService.getByMap(JSONObject.parseObject(JSONObject.toJSONString(news)).getInnerMap());
                }
            });

        }
        return null;
    }
}
