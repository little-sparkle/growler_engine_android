package com.littlesparkle.growler.library.order.model;

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

    @Override
    public String toString() {
        return "OrderInfo{" +
                "order_id=" + order_id +
                ", status_code=" + status_code +
                ", type=" + type +
                ", rate_driver=" + rate_driver +
                ", rate_customer=" + rate_customer +
                ", guess_price=" + guess_price +
                ", guess_distance=" + guess_distance +
                ", real_distance=" + real_distance +
                ", due_price=" + due_price +
                ", discount_price=" + discount_price +
                ", real_price=" + real_price +
                ", create_time=" + create_time +
                ", use_time=" + use_time +
                ", from_lat=" + from_lat +
                ", from_lng=" + from_lng +
                ", to_lat=" + to_lat +
                ", to_lng=" + to_lng +
                ", status_description='" + status_description + '\'' +
                ", route_path='" + route_path + '\'' +
                '}';
    }
}
