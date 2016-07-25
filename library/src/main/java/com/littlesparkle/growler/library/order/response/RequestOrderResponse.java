package com.littlesparkle.growler.library.order.response;

import com.littlesparkle.growler.library.http.Response;

public class RequestOrderResponse extends Response<RequestOrderResponse.Data> {
    public class Data {
        public int order_id;
        public int status_code;
        public String status_description;

        @Override
        public String toString() {
            return "Data{" +
                    "order_id=" + order_id +
                    ", status_code=" + status_code +
                    ", status_description='" + status_description + '\'' +
                    '}';
        }
    }
}
