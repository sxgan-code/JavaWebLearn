package com.sxgan.domain;

public class UserInfo {
    private Integer userid;
    private String username;
    private Integer userage;
    private String usersex;
    private String certtype;
    private String certid;
    private String phone;
    
    public UserInfo() {
    }
    
    public Integer getUserid() {
        return userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public Integer getUserage() {
        return userage;
    }
    
    public void setUserage(Integer userage) {
        this.userage = userage;
    }
    
    public String getUsersex() {
        return usersex;
    }
    
    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }
    
    public String getCerttype() {
        return certtype;
    }
    
    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }
    
    public String getCertid() {
        return certid;
    }
    
    public void setCertid(String certid) {
        this.certid = certid;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "UserInfo{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", userage=" + userage +
                ", usersex='" + usersex + '\'' +
                ", certtype='" + certtype + '\'' +
                ", certid='" + certid + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
