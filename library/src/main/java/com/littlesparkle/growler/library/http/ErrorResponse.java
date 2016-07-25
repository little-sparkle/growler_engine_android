package com.littlesparkle.growler.library.http;

public class ErrorResponse extends Response<ErrorResponse.Data> {
    public class Data {
        public String err_no;
        public String err_msg;

        @Override
        public String toString() {
            return "Data{" +
                    "err_no='" + err_no + '\'' +
                    ", err_msg='" + err_msg + '\'' +
                    '}';
        }
    }

    public ErrorResponse() {
        this.code = -1;
        this.data = new Data();
    }
}
