package com.tallgram.servlet;

import com.tallgram.model.User;
import com.tallgram.utils.Utils;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class AddUserServlet extends HttpServlet {


    private Map <Integer, User> users;
    private AtomicInteger id;

    @Override
    public void init() throws SecurityException {
        final Object users = getServletContext().getAttribute("users");
        if (users == null || !(users instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("Your repo doesn't initialize");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }

        id = new AtomicInteger(2);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws SecurityException, IOException {

        req.setCharacterEncoding("UTF-8");
        if (Utils.requestIsValid(req)) {
            final String name = req.getParameter("name");
            final String age = req.getParameter("age");

            final User user = new User();
            final int id = this.id.getAndIncrement();
            user.setId(id);
            user.setName(name);
            user.setAge(Integer.valueOf(age));

            users.put(id, user);
        }
        resp.sendRedirect(req.getContextPath()+"/");
    }

}
