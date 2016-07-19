package com.littlesparkle.growler.library.order;

public class CarInfo {
    public int car_id;
    public int car_type;
    public String car_number;

    @Override
    public String toString() {
        return "CarInfo{" +
                "car_id=" + car_id +
                ", car_type=" + car_type +
                ", car_number='" + car_number + '\'' +
                '}';
    }
}
