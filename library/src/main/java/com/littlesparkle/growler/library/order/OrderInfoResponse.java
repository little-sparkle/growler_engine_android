package com.littlesparkle.growler.library.order;

import com.littlesparkle.growler.library.http.Response;

public class OrderInfoResponse extends Response<OrderInfoResponse.Data> {
    public class Data {
        public OrderInfo order;
        public DriverInfo driver;
        public PassengerInfo passenger;
        public CarInfo car;
        public CouponInfo passenger_coupon;

        @Override
        public String toString() {
            return "Data{" +
                    "order=" + order +
                    ", driver=" + driver +
                    ", passenger=" + passenger +
                    ", car=" + car +
                    ", passenger_coupon=" + passenger_coupon +
                    '}';
        }
    }
}
