package com.littlesparkle.growler.library.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class CarBrand extends Bean implements Parcelable {
    public int car_brand_id;
    public String name;

    public CarBrand() {
    }

    protected CarBrand(Parcel in) {
        car_brand_id = in.readInt();
        name = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(car_brand_id);
        dest.writeString(name);
    }

    public static final Creator<CarBrand> CREATOR = new Creator<CarBrand>() {
        @Override
        public CarBrand createFromParcel(Parcel in) {
            return new CarBrand(in);
        }

        @Override
        public CarBrand[] newArray(int size) {
            return new CarBrand[size];
        }
    };
}
