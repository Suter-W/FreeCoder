package com.freecoder.utils;

import io.goeasy.GoEasy;
import io.goeasy.publish.GoEasyError;
import io.goeasy.publish.PublishListener;


/**
 * @ClassName GoEasyServer
 * @Description TODO
 * @DATE 2023/7/10 17:50
 */
public class GoEasyServer {

    /**
     * @Description 发布公告
     * @param notice  通知内容
     * @Date 17:58 2023/7/10
     * @Param [java.lang.String]
     * @return void
     **/
    public static void publish(String notice) {
//        notice = "亲爱的各位员工，大家好，很高兴认识你们，接下来你们的人生将交由本餐厅支配，感谢大家的积极配合";
        GoEasy goEasy = new GoEasy("https://rest-hz.goeasy.io","BC-a0191921df274d3f826449fca32b26e9");
        goEasy.publish("my_channel", notice, new PublishListener() {
            @Override
            public void onSuccess() {
                System.out.println("Publish success.");
            }

            @Override
            public void onFailed(GoEasyError error) {
                System.out.println("Failed to Publish message, error:" + error.getCode() + " , " + error.getContent());
            }
        });
    }


}

