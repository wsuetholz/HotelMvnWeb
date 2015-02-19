/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suetholz.net.hotel.web.event;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author wsuetholz
 */
public class HotelHttpSessionListener implements HttpSessionListener {

    public static int sessionCount = 0;
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
	++sessionCount;
	se.getSession().getServletContext().setAttribute("sessionCount", HotelHttpSessionListener.sessionCount);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
	--sessionCount;
	se.getSession().getServletContext().setAttribute("sessionCount", HotelHttpSessionListener.sessionCount);
    }
    
}
