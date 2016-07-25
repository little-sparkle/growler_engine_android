package com.littlesparkle.growler.library.order.model;

public class CustomerInfo {
    public int user_id;
    public String mobile;
    public String nickname;

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "user_id=" + user_id +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
