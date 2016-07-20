package com.littlesparkle.growler.library.user.driver;

import com.littlesparkle.growler.library.bean.Car;
import com.littlesparkle.growler.library.bean.CarBrand;
import com.littlesparkle.growler.library.bean.CarSerie;
import com.littlesparkle.growler.library.bean.Driver;
import com.littlesparkle.growler.library.http.Response;

public class DriverInfoResponse extends Response<DriverInfoResponse.Date> {
    public class Date {
        public Driver driver;
        public Car car;
        public CarBrand car_brand;
        public CarSerie car_serie;

        @Override
        public String toString() {
            return "Date{" +
                    "driver=" + driver +
                    ", car=" + car +
                    ", car_brand=" + car_brand +
                    ", car_serie=" + car_serie +
                    '}';
        }
    }
}
