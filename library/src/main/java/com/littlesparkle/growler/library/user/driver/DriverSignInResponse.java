package com.littlesparkle.growler.library.user.driver;

import com.littlesparkle.growler.library.bean.Car;
import com.littlesparkle.growler.library.bean.CarBrand;
import com.littlesparkle.growler.library.bean.CarSerie;
import com.littlesparkle.growler.library.bean.Driver;
import com.littlesparkle.growler.library.http.Response;

public class DriverSignInResponse extends Response<DriverSignInResponse.Date> {
    public class Date {
        public Driver driver;
        public Car car;
        public CarBrand car_brand;
        public CarSerie car_serie;
    }
}
