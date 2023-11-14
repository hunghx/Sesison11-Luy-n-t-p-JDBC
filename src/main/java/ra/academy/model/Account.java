package ra.academy.model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
    private Long id = 0L;
    private String accountCode,phone, username,password,fullName,avatarUrl;
    private Date birthDay;
    private boolean status;
    private BigDecimal balance;

    public Account() {
    }

    public Account(String phone, String username, String password, String fullName, Date birthDay) {
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthDay = birthDay;
    }

    public Account(Long id, String accountCode, String phone, String username, String password, String fullName, String avatarUrl, Date birthDay, boolean status, BigDecimal balance) {
        this.id = id;
        this.accountCode = accountCode;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.avatarUrl = avatarUrl;
        this.birthDay = birthDay;
        this.status = status;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
