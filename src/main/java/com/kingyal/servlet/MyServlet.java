package com.kingyal.servlet;

import com.github.pagehelper.PageInfo;
import com.kingyal.usemybatis.entity.Page;
import com.kingyal.usemybatis.entity.User;
import com.kingyal.usemybatis.service.UserService;
import com.kingyal.usemybatis.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users")
public class MyServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("my servlet test");
        String pageNum = req.getParameter("pageNum");
        String pageSize = req.getParameter("pageSize");
        Page page = new Page();
        if(pageNum != null && pageSize != null) {
            page.setPageNum(Integer.parseInt(pageNum));
            page.setPageSize(Integer.parseInt(pageSize));
        }
        // 獲取數據
        PageInfo<User> pageInfo = userService.queryUsers(page);
        req.setAttribute("pageInfo", pageInfo);
        // 跳轉頁面
        req.getRequestDispatcher("/users.jsp").forward(req, resp);

    }
}
