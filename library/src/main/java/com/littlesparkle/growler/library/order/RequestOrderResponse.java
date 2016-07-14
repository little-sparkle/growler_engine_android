package com.littlesparkle.growler.library.order;

import com.littlesparkle.growler.library.http.Response;

public class RequestOrderResponse extends Response<RequestOrderResponse.Data> {
    public class Data {
        public int order_id;
        public int status_code;
        public String status_description;
    }
}
