package com.littlesparkle.growler.library.bean;

import android.os.Parcel;
import android.os.Parcelable;


public class User extends Bean implements Parcelable {
    public int user_id;
    public String mobile;
    public String realname;
    public String thumb;
    public int rate;
    public int create_time;
    public int loc_report_time;
    public double lat;
    public double lng;
    public String token;
    public String nickname;
    public int b_y;
    public int b_m;
    public int b_d;
    public int is_driver;
    public String id_num;
    public int verified;
    public int company_id;

    public User() {
    }

    protected User(Parcel in) {
        user_id = in.readInt();
        mobile = in.readString();
        realname = in.readString();
        thumb = in.readString();
        rate = in.readInt();
        create_time = in.readInt();
        loc_report_time = in.readInt();
        lat = in.readDouble();
        lng = in.readDouble();
        token = in.readString();
        nickname = in.readString();
        b_y = in.readInt();
        b_m = in.readInt();
        b_d = in.readInt();
        is_driver = in.readInt();
        id_num = in.readString();
        verified = in.readInt();
        company_id = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(user_id);
        dest.writeString(mobile);
        dest.writeString(realname);
        dest.writeString(thumb);
        dest.writeInt(rate);
        dest.writeInt(create_time);
        dest.writeInt(loc_report_time);
        dest.writeDouble(lat);
        dest.writeDouble(lng);
        dest.writeString(token);
        dest.writeString(nickname);
        dest.writeInt(b_y);
        dest.writeInt(b_m);
        dest.writeInt(b_d);
        dest.writeInt(is_driver);
        dest.writeString(id_num);
        dest.writeInt(verified);
        dest.writeInt(company_id);
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", mobile='" + mobile + '\'' +
                ", realname='" + realname + '\'' +
                ", thumb='" + thumb + '\'' +
                ", rate=" + rate +
                ", create_time=" + create_time +
                ", loc_report_time=" + loc_report_time +
                ", lat=" + lat +
                ", lng=" + lng +
                ", token='" + token + '\'' +
                ", nickname='" + nickname + '\'' +
                ", b_y=" + b_y +
                ", b_m=" + b_m +
                ", b_d=" + b_d +
                ", is_driver=" + is_driver +
                ", id_num='" + id_num + '\'' +
                ", verified=" + verified +
                ", company_id=" + company_id +
                '}';
    }
}
