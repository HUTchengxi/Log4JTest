package org.spring.learn;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yinjimin
 * @Description: log4j学习
 * @date 2018年04月12日
 */
@Controller
public class Log4jTest {

    private static final Log LOG = LogFactory.getLog(Log4jTest.class);

    public Log4jTest(){
        LOG.info("log4jtest init");
    }

    @RequestMapping("/logtest")
    public @ResponseBody String logTest(){

        LOG.info("logtest ing");
        return "logtest ing";
    }

    @RequestMapping("/logtest2")
    public @ResponseBody String logTest2(){

        LOG.debug("logtest ing");
        return "logtest ing";
    }

    @RequestMapping("/logtest3")
    public @ResponseBody String logTest3(){

        LOG.error("logtest ing");
        return "logtest ing";
    }
}
