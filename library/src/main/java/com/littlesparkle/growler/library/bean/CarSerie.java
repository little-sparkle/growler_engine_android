package com.littlesparkle.growler.library.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CarSerie extends Bean implements Parcelable {
    public int car_serie_id;
    public String name;

    public CarSerie() {
    }

    protected CarSerie(Parcel in) {
        car_serie_id = in.readInt();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(car_serie_id);
        dest.writeString(name);
    }

    public static final Creator<CarSerie> CREATOR = new Creator<CarSerie>() {
        @Override
        public CarSerie createFromParcel(Parcel in) {
            return new CarSerie(in);
        }

        @Override
        public CarSerie[] newArray(int size) {
            return new CarSerie[size];
        }
    };
}
