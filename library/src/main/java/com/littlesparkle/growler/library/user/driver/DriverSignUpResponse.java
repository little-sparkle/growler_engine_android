package com.littlesparkle.growler.library.user.driver;

import com.littlesparkle.growler.library.bean.Driver;
import com.littlesparkle.growler.library.bean.Passenger;
import com.littlesparkle.growler.library.http.Response;

public class DriverSignUpResponse extends Response<DriverSignUpResponse.Data> {
    public class Data {
        public Driver user;

        @Override
        public String toString() {
            return "Data{" +
                    "user=" + user +
                    '}';
        }
    }
}
