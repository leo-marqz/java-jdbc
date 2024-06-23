package com.leomarqz.data;

public class DBConfigurations {
    //jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC
    //jdbc:mysql://localhost:3306/test
    private String host = "localhost";
    private Integer port = 3306;
    private String dbname = "test";
    private String user = "root";
    private String password = "MainRoot";

    public String getUrl(){
        String url = new StringBuilder("jdbc:mysql://")
                .append(this.host)
                .append(":")
                .append(this.port)
                .append("/")
                .append(this.dbname)
                .toString();
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
