package com.sxgan.domain;

public class UserAccount {
    private Integer acctId;
    private String acctNum;
    private String acctPwd;
    
    public UserAccount() {
    
    }
    
    public Integer getAcctId() {
        return acctId;
    }
    
    public void setAcctId(Integer acctId) {
        this.acctId = acctId;
    }
    
    public String getAcctNum() {
        return acctNum;
    }
    
    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }
    
    public String getAcctPwd() {
        return acctPwd;
    }
    
    public void setAcctPwd(String acctPwd) {
        this.acctPwd = acctPwd;
    }
    
    @Override
    public String toString() {
        return "UserAccount{" +
                "acctId=" + acctId +
                ", acctNum='" + acctNum + '\'' +
                ", acctPwd='" + acctPwd + '\'' +
                '}';
    }
}
