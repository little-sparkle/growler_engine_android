package com.littlesparkle.growler.library.order;

public class RequestOrderResponse {
    public InnerData order;

    public class InnerData {
        public int order_id;
        public int status_code;
        public String status_description;
    }
}
