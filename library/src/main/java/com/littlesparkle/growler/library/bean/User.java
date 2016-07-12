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
}
