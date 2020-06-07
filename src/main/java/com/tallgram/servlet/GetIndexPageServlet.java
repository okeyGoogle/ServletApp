package com.tallgram.servlet;

import com.tallgram.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GetIndexPageServlet extends HttpServlet {

    private Map<Integer, User> users;


 /* метод init без параметров - в сервлете не принято использовать
 конструктор для инициализации объекта, как это делается обычно
 в Java классах, но в сервлетах делается не так, в сервлетах
 для этого используется переопределение метода init без параметров
  */

    @Override
    public void init() throws ServletException {
        final Object users = getServletContext().getAttribute("users");
        if (users == null || !(users instanceof ConcurrentHashMap)) {

            throw new IllegalStateException("Your repo doesn't initialize");
        } else {
            this.users = (ConcurrentHashMap<Integer, User>) users;
        }
    }


    //Multithreading scope (Singleton)
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("doGet is work");
        req.setAttribute("users", users.values()); // метод сет принимает значения (ключ, значение)
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, resp);
    }
}
