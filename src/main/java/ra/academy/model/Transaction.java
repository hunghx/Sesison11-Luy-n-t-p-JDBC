package ra.academy.model;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
  private String id , comment;
  private Long senderId,receiverId;
  private Date datePay;
  private BigDecimal amount;

    public Transaction() {
    }


    public Transaction(String id, String comment, Long senderId, Long receiverId, Date datePay, BigDecimal amount) {
        this.id = id;
        this.comment = comment;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.datePay = datePay;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
