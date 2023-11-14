package ra.academy.controller;

import ra.academy.model.Account;
import ra.academy.service.IAccountService;
import ra.academy.serviceimpl.AccountService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AuthController", value = "/AuthController")
public class AuthController extends HttpServlet {
    private IAccountService accountService = new AccountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "REGISTER":
                    request.getRequestDispatcher("/WEB-INF/views/page/register.jsp").forward(request, response);
                    break;
                case "LOGIN":
                    request.getRequestDispatcher("/WEB-INF/views/page/login.jsp").forward(request, response);
                    break;
                case "LOGOUT":
                    HttpSession session = request.getSession();
                    session.removeAttribute("user_login");
                    request.getRequestDispatcher("/").forward(request,response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "REGISTER":
                    // lấy toàn bộ dữ liệu ra
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    String fullName = request.getParameter("fullName");
                    String phone = request.getParameter("phone");
                    Date birthday = null;
                    try {
                        birthday = simple.parse(request.getParameter("birthday"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    Account formRegister = new Account(phone, username, password, fullName, birthday);

                    boolean check = accountService.save(formRegister);
                    if (check){
                        request.getRequestDispatcher("/WEB-INF/views/page/login.jsp").forward(request, response);
                    }
                    break;
                case "LOGIN" :
                    // lấy ra thông tin đăng nhập
                    String user = request.getParameter("username");
                    String pass = request.getParameter("password");
                    Account userLogin = accountService.login(user,pass);
                    if (userLogin==null){
                        // thất bại
                        request.setAttribute("username",user);
                        request.setAttribute("login_fail","Tên đăng nhập hoặc mật khẩu không đúng");
                        request.getRequestDispatcher("/WEB-INF/views/page/login.jsp").forward(request,response);
                    }else {
//                        thành công
                        // lấy session - phiên:
                        HttpSession session = request.getSession();
                        session.setAttribute("user_login",userLogin);
                      request.getRequestDispatcher("/").forward(request,response);
                    }
                    break;

            }
        }
    }
}