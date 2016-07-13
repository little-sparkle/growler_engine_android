package com.littlesparkle.growler.library.order;

public class OrderInfo {
    public int order_id;
    public int status_code;
    public int type;
    public int rate_driver;
    public int rate_customer;
    public int guess_price;
    public int guess_distance;
    public int real_distance;
    public int due_price;
    public int discount_price;
    public int real_price;

    public long create_time;
    public long use_time;
    public double from_lat;
    public double from_lng;
    public double to_lat;
    public double to_lng;

    public String status_description;
    public String route_path;
}
