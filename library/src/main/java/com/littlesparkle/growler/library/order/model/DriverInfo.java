package com.littlesparkle.growler.library.order.model;

public class DriverInfo {
    public int user_id;
    public String mobile;
    public String nickname;

    @Override
    public String toString() {
        return "DriverInfo{" +
                "user_id=" + user_id +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
