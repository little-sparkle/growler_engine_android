package com.littlesparkle.growler.library.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;


public class Driver extends User implements Parcelable {
    public int driver_type;
    public String driving_license_type;
    public String driving_license;
    public String driving_license_reg_date;
    public String driving_license_pic;
    public String idcard_number;
    public String idcard_pic;
    public long register_time;
    public int register_status;
    public String register_fail_reason;
    public int order_count;
    public int order_success_count;
    public int is_online;

    public Driver() {
    }

    protected Driver(Parcel in) {
        driver_type = in.readInt();
        driving_license_type = in.readString();
        driving_license = in.readString();
        driving_license_reg_date = in.readString();
        driving_license_pic = in.readString();
        idcard_number = in.readString();
        idcard_pic = in.readString();
        register_time = in.readLong();
        register_status = in.readInt();
        register_fail_reason = in.readString();
        order_count = in.readInt();
        order_success_count = in.readInt();
        is_online = in.readInt();
    }

    @Override
    public void persist(Context context) {
        super.persist(context);
    }

    @Override
    public void load(Context context) {
        super.load(context);
    }

    @Override
    public void dump() {
        super.dump();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(driver_type);
        dest.writeString(driving_license_type);
        dest.writeString(driving_license);
        dest.writeString(driving_license_reg_date);
        dest.writeString(driving_license_pic);
        dest.writeString(idcard_number);
        dest.writeString(idcard_pic);
        dest.writeLong(register_time);
        dest.writeInt(register_status);
        dest.writeString(register_fail_reason);
        dest.writeInt(order_count);
        dest.writeInt(order_success_count);
        dest.writeInt(is_online);
    }

    public static final Creator<Driver> CREATOR = new Creator<Driver>() {
        @Override
        public Driver createFromParcel(Parcel in) {
            return new Driver(in);
        }

        @Override
        public Driver[] newArray(int size) {
            return new Driver[size];
        }
    };

    @Override
    public String toString() {
        return super.toString() + "\n" + "Driver{" +
                "driver_type=" + driver_type +
                ", driving_license_type='" + driving_license_type + '\'' +
                ", driving_license='" + driving_license + '\'' +
                ", driving_license_reg_date='" + driving_license_reg_date + '\'' +
                ", driving_license_pic='" + driving_license_pic + '\'' +
                ", idcard_number='" + idcard_number + '\'' +
                ", idcard_pic='" + idcard_pic + '\'' +
                ", register_time=" + register_time +
                ", register_status=" + register_status +
                ", register_fail_reason='" + register_fail_reason + '\'' +
                ", order_count=" + order_count +
                ", order_success_count=" + order_success_count +
                ", is_online=" + is_online +
                '}';
    }
}
