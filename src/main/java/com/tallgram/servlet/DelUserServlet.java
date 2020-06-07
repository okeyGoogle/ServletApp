package com.tallgram.servlet;

import com.tallgram.model.User;
import com.tallgram.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DelUserServlet extends HttpServlet {


    private Map<Integer, User> users;

    @Override
    public void init() throws ServletException {

        final Object users = getServletContext().getAttribute("users");

        if (users == null || !(users instanceof ConcurrentHashMap) ) {
        throw new IllegalStateException("Your repo does't initialize");
    } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        if (Utils.idIsNumber(req)){
            users.remove(Integer.valueOf(req.getParameter("id")));
        }
            resp.sendRedirect(req.getContextPath()+"/");
    }
}

