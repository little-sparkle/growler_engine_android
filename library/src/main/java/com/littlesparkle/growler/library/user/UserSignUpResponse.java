package com.littlesparkle.growler.library.user;

import com.littlesparkle.growler.library.bean.User;
import com.littlesparkle.growler.library.http.Response;

public class UserSignUpResponse extends Response<UserSignUpResponse.Data> {
    public class Data {
        public User user;

        @Override
        public String toString() {
            return "Data{" +
                    "user=" + user +
                    '}';
        }
    }
}
