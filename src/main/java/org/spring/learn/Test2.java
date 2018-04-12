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
import org.apache.log4j.PropertyConfigurator;

/**
 * @author yinjimin
 * @Description: 测试使用java直接启动main方法是否可以使用日志
 * @date 2018年04月12日
 */
public class Test2 {

    private static final Log log = LogFactory.getLog(Test2.class);

    public static void main(String[] args){

        PropertyConfigurator.configure("C:\\Users\\admin\\Desktop\\workspaces\\log4jTest\\src\\main\\webapp\\WEB-INF\\config\\log4j.properties");
        log.info("测试是否可以通过main方法来输出日志");
        System.out.println("Hello World");
    }
}
