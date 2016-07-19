package com.littlesparkle.growler.library.user.driver;

import com.littlesparkle.growler.library.bean.Car;
import com.littlesparkle.growler.library.bean.CarBrand;
import com.littlesparkle.growler.library.bean.CarSerie;
import com.littlesparkle.growler.library.bean.Driver;

public class DriverInfoResponse {
    public Driver driver;
    public Car car;
    public CarBrand car_brand;
    public CarSerie car_serie;

    @Override
    public String toString() {
        return "DriverInfoResponse{" +
                "driver=" + driver +
                ", car=" + car +
                ", car_brand=" + car_brand +
                ", car_serie=" + car_serie +
                '}';
    }
}
