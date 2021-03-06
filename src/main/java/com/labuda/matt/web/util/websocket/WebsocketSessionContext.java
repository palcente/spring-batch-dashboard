package com.labuda.matt.web.util.websocket;

import com.labuda.matt.web.controller.websocket.DashboardController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by matt on 06/12/2015.
 * At the moment this class only keeps record of open sessions
 * This could be refined to keep track of users data etc
 */

@Component
public class WebsocketSessionContext {

    @Autowired
    private DashboardController dashboardController;

    private Set<String> activeSessions = new HashSet<String>();

    public boolean registerSession(String sessionId){
        dashboardController.pushFreshEntries();
        return activeSessions.add(sessionId);
    }

    public boolean deregisterSession(String sessionId){
        return activeSessions.remove(sessionId);
    }

    public boolean hasActiveSessions(){
        return activeSessions.isEmpty() ? false:true;
    }

}
