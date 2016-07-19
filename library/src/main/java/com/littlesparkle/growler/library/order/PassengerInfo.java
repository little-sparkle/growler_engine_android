package com.littlesparkle.growler.library.order;

public class PassengerInfo {
    public int user_id;
    public String mobile;
    public String nickname;

    @Override
    public String toString() {
        return "PassengerInfo{" +
                "user_id=" + user_id +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
