package com.littlesparkle.growler.library.order.model;

public class CouponInfo {
    public int customer_coupon_id;
    public String name;
    public String value;

    @Override
    public String toString() {
        return "CouponInfo{" +
                "customer_coupon_id=" + customer_coupon_id +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
