package com.littlesparkle.growler.library.bean;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

public class Car extends Bean implements Parcelable {
    public int car_id;
    public String car_number;
    public String vehicle_license_pic;

    public Car() {
    }

    protected Car(Parcel in) {
        car_id = in.readInt();
        car_number = in.readString();
        vehicle_license_pic = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(car_id);
        dest.writeString(car_number);
        dest.writeString(vehicle_license_pic);
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

    @Override
    public String toString() {
        return "Car{" +
                "car_id=" + car_id +
                ", car_number='" + car_number + '\'' +
                ", vehicle_license_pic='" + vehicle_license_pic + '\'' +
                '}';
    }
}
