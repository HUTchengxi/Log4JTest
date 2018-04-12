/*
 * Copyright (C) 2011-2013 ShenZhen iBoxpay Information Technology Co. Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary information of iBoxPay Company of China.
 * ("Confidential Information").
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement you entered into with iBoxpay inc.
 *
 *
 */
package org.spring.learn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinjimin
 * @Description: 测试对指定的类输出到指定的日志文件中
 * @date 2018年04月12日
 */
@Controller
public class Test1 {

    private static final Log log = LogFactory.getLog(Test1.class);

    @RequestMapping("/test")
    public @ResponseBody String test(){

        log.info("对指定的类输出到指定的日志文件中");
        return "test ok";
    }
}
