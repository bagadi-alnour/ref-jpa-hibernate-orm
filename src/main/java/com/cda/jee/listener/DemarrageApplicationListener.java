package com.cda.jee.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class DemarrageApplicationListener implements ServletContextListener {
	private static final Logger LOG = 
            LoggerFactory.getLogger( DemarrageApplicationListener.class.getName() );
   
	@Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("Application a demarré à " + new Date() );
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	LOG.info("Application s'est arrêté à " + new Date() );
    }
}
