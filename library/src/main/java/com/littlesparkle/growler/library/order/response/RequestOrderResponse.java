package com.littlesparkle.growler.library.order.response;

import com.littlesparkle.growler.library.http.Response;
import com.littlesparkle.growler.library.order.model.OrderInfo;

public class RequestOrderResponse extends Response<RequestOrderResponse.Data> {
    public class Data {
        public OrderInfo order;

        @Override
        public String toString() {
            return "Data{" +
                    "order=" + order +
                    '}';
        }
    }
}
