package com.littlesparkle.growler.library.bean;

import android.os.Parcel;
import android.os.Parcelable;


public class Passenger extends User implements Parcelable {
    public String nickname;
    public int b_y;
    public int b_m;
    public int b_d;
    public int is_driver;
    public String id_num;
    public int verified;
    public int company_id;

    public Passenger() {
    }

    protected Passenger(Parcel in) {
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
        dest.writeString(nickname);
        dest.writeInt(b_y);
        dest.writeInt(b_m);
        dest.writeInt(b_d);
        dest.writeInt(is_driver);
        dest.writeString(id_num);
        dest.writeInt(verified);
        dest.writeInt(company_id);
    }

    public static final Creator<Passenger> CREATOR = new Creator<Passenger>() {
        @Override
        public Passenger createFromParcel(Parcel in) {
            return new Passenger(in);
        }

        @Override
        public Passenger[] newArray(int size) {
            return new Passenger[size];
        }
    };
}
