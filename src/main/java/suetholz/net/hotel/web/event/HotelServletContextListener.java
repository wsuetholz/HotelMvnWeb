/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suetholz.net.hotel.web.event;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author wsuetholz
 */
public class HotelServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
	ServletContext ctx = sce.getServletContext();

	String managementName = ctx.getInitParameter("ManagementName");

	synchronized(ctx) {
	    ctx.setAttribute("ManagementName", managementName);
	}
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
    
}
