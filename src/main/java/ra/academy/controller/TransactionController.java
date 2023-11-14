package ra.academy.controller;

import ra.academy.model.Account;
import ra.academy.model.Transaction;
import ra.academy.service.IAccountService;
import ra.academy.service.ITransactionService;
import ra.academy.serviceimpl.AccountService;
import ra.academy.serviceimpl.TransactionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet(name = "TransactionController", value = "/TransactionController")
public class TransactionController extends HttpServlet {

    private IAccountService accountService = new AccountService();
    private ITransactionService transactionService =new TransactionService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "PAY":
                    request.getRequestDispatcher("/WEB-INF/views/page/form-payment.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "CHECK":
                    String receiverCode = request.getParameter("receiver_code");
                    Account account = accountService.checkAccountByCode(receiverCode);
                    if (account == null) {
                        request.setAttribute("error_code", "Số tài khoản không đúng");
                        request.getRequestDispatcher("/WEB-INF/views/page/form-payment.jsp").forward(request, response);
                    } else {
                        request.setAttribute("receiver", account);
                        request.getRequestDispatcher("/WEB-INF/views/page/form-confirm.jsp").forward(request, response);
                    }
                    break;
                case "SEND":
                    String receiver = request.getParameter("receiver_code");
                    double amount = Double.parseDouble(request.getParameter("amount"));
                    String comment = request.getParameter("comment");
                    HttpSession session = request.getSession();
                    Account userLogin = (Account) session.getAttribute("user_login");
                    boolean check = transactionService.payment(receiver, userLogin.getAccountCode(), amount, comment);
                    if (check) {
                        Account userLoginUp = accountService.checkAccountByCode(userLogin.getAccountCode());
                        session.setAttribute("user_login",userLoginUp);
                        request.getRequestDispatcher("/").forward(request,response);
                    }
                    break;
            }
        }
    }
}