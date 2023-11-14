<%--
  Created by IntelliJ IDEA.
  User: hung1
  Date: 11/14/2023
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

<div class="container py-5">
    <h1 class="text-center">Sign In</h1>
    <form action="<%=request.getContextPath()%>/TransactionController" method="post" class="row g-3" style="max-width: 30rem;margin: 0 auto">
        <div class="col-md-12">
            <label for="receiver_code" class="form-label">Số tài khoản nhận</label>
            <input type="text" class="form-control" name="receiver_code" readonly id="receiver_code" value="${receiver.accountCode}">
        </div>
        <div class="col-md-12">
            <label for="receiver_name" class="form-label">Tên người nhận</label>
            <input type="text" class="form-control" readonly id="receiver_name" value="${receiver.fullName}">
        </div>
        <div class="col-md-12">
            <label for="amount" class="form-label">Số tiền chuyển</label>
            <input type="number" min="10000" class="form-control"  name="amount" id="amount">
        </div>
        <div class="col-md-12">
            <label for="comment" class="form-label">Nội dung</label>
            <input type="text" class="form-control"  name="comment" id="comment">
        </div>
        <div class="col-12 text-center">
            <input type="submit" class="btn btn-primary" name="action" value="SEND">
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>

