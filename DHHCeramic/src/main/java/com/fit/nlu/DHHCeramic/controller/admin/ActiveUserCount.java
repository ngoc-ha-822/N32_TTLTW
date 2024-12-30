package com.fit.nlu.DHHCeramic.controller.admin;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@WebListener
public class ActiveUserCount implements HttpSessionListener {
    public static final String COUNTER = "SESSION-COUNTER";
    private static final List<String> sessions = new ArrayList<>();

    public void sessionCreated(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionCreated");
        HttpSession session = event.getSession();
        sessions.add(session.getId());
        session.setAttribute(ActiveUserCount.COUNTER, this);
    }

    public void sessionDestroyed(HttpSessionEvent event) {
        System.out.println("SessionCounter.sessionDestroyed");
        HttpSession session = event.getSession();
        sessions.remove(session.getId());
        session.setAttribute(ActiveUserCount.COUNTER, this);
    }

    public static int getActiveSessionNumber() {
        return sessions.size();
    }
}