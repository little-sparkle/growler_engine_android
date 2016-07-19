package com.littlesparkle.growler.library.order;

public class OrderConstants {
    public enum ORDER_STATUS_CODE {
        ORDER_ASSIGNING,            // 0
        ORDER_ASSIGNED,             // 1
        ORDER_CONFIRMED,            // 2
        ORDER_READY,                // 3
        ORDER_STARTED,              // 4
        ORDER_FINISHED_NOT_PAYED,   // 5
        ORDER_PAUSED,               // 6
        ORDER_FINISHED_PAYED,       // -1
        ORDER_INTERRUPTED,          // -2
        ORDER_NO_RESPONSE,          // -3
        ORDER_CANCELED_BY_DRIVER,   // -4
        ORDER_CANCELED_BY_PASSENGER // -5
    }
}
