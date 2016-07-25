package com.littlesparkle.growler.library.order.response;

import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.order.model.CarInfo;
import com.littlesparkle.growler.library.order.model.CouponInfo;
import com.littlesparkle.growler.library.order.model.CustomerInfo;
import com.littlesparkle.growler.library.order.model.DriverInfo;
import com.littlesparkle.growler.library.order.model.OrderInfo;

public class OrderInfoResponse extends Response<OrderInfoResponse.Data> {
    public class Data {
        public OrderInfo order;
        public DriverInfo driver;
        public CustomerInfo passenger;
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
