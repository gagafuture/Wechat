package com.hzp.Utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/7 23:45
 */
public class NFDFlightDataTaskListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        new TimerManager();
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }
}
