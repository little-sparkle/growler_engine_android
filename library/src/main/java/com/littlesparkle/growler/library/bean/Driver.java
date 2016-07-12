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

//    public Car car;
//    public CarBrand car_brand;
//    public CarSerie car_serie;

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
//        car = in.readParcelable(Car.class.getClassLoader());
//        car_brand = in.readParcelable(CarBrand.class.getClassLoader());
//        car_serie = in.readParcelable(CarSerie.class.getClassLoader());
    }

    @Override
    public void persist(Context context) {
        super.persist(context);
//        car.persist(context);
//        car_brand.persist(context);
//        car_serie.persist(context);
    }

    @Override
    public void load(Context context) {
        super.load(context);
//        if (car == null) {
//            car = new Car();
//        }
//        car.load(context);
//        if (car_brand == null) {
//            car_brand = new CarBrand();
//        }
//        car_brand.load(context);
//        if (car_serie == null) {
//            car_serie = new CarSerie();
//        }
//        car_serie.load(context);
    }

    @Override
    public void dump() {
        super.dump();
//        car.dump();
//        car_brand.dump();
//        car_serie.dump();
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
//        dest.writeParcelable(car, flags);
//        dest.writeParcelable(car_brand, flags);
//        dest.writeParcelable(car_serie, flags);
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
}
