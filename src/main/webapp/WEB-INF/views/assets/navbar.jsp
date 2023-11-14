<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 11/14/2023
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="#">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Features</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="#">Pricing</a>
        </li>

      </ul>
    </div>
    <c:if test="${sessionScope.containsKey('user_login')}">
      <a href="<%=request.getContextPath()%>/TransactionController?action=PAY" class="btn btn-primary">Chuyển tiền</a>
    </c:if>
    <c:choose>
      <c:when test="${!sessionScope.containsKey('user_login')}">
        <div class="">
          <a href="<%=request.getContextPath()%>/AuthController?action=REGISTER" class="btn btn-primary">Đăng Ký</a>
          <a href="<%=request.getContextPath()%>/AuthController?action=LOGIN" class="btn btn-primary">Đăng nhập</a>
        </div>
      </c:when>
      <c:otherwise>
        <div class="d-flex gap-2 align-items-center">
          <span>Số dư : ${sessionScope.get("user_login").balance}</span>
          <img width="50" height="50" style="border-radius: 50%;object-fit: cover" src="${sessionScope.get("user_login").avatarUrl}" alt="">
          <p class="m-0">${sessionScope.get("user_login").fullName}</p>
          <a href="<%=request.getContextPath()%>/AuthController?action=LOGOUT" class="btn btn-primary">Đăng xuất</a>
        </div>
      </c:otherwise>
    </c:choose>


  </div>
</nav>