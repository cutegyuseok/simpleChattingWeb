package com.example.wilwebprac.chatting.DTO;

public class chatDTO {
    private String nickName;
    private String msg;
    private String time;

    public chatDTO(String nickName, String msg, String time) {
        this.nickName = nickName;
        this.msg = msg;
        this.time = time;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
