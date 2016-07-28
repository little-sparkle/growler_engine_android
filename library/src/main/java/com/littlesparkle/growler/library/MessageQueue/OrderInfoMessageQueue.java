package com.littlesparkle.growler.library.MessageQueue;

import android.widget.Toast;

import com.littlesparkle.growler.library.order.response.OrderInfoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by dell on 2016/7/28.
 */
public class OrderInfoMessageQueue<T> {

    private List<T> mOrderInfoResponses = new ArrayList<>();
    protected Timer mTimer;
    protected int i = 0;

    private static OrderInfoMessageQueue orderInfoMessageQueue;

    private OrderInfoMessageQueue() {

    }

    public static OrderInfoMessageQueue getInstance() {
        if (orderInfoMessageQueue == null) {
            synchronized (OrderInfoMessageQueue.class) {
                if (orderInfoMessageQueue == null) {
                    orderInfoMessageQueue = new OrderInfoMessageQueue();
                }
            }
        }
        return orderInfoMessageQueue;
    }

    public void sendMessageToMainThread() {
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (mOrderInfoResponses != null && mOrderInfoResponses.size() > i) {
                    EventBus.getDefault().post(new OrderInfoEvent(mOrderInfoResponses.get(i)));
                    i = i + 1;
                } else {
                    return;
                }
            }
        }, 5000, 5000);
    }


    public void stopSend() {
        try {
            mTimer.cancel();
        } catch (Exception e) {
            e.printStackTrace();
        }
        mOrderInfoResponses = null;
        System.gc();
    }


    public void prepare() {
        EventBus.getDefault().register(this);
    }


    public void onDestroy() {
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onReceiverMessage(T orderInfoResponse) {
        mOrderInfoResponses.add(orderInfoResponse);
    }

    public class OrderInfoEvent {
        public OrderInfoResponse mOrderInfoResponse;

        public OrderInfoEvent(T t) {
            mOrderInfoResponse = (OrderInfoResponse) t;
        }

        @Override
        public String toString() {
            return "OrderInfoEvent{" +
                    "mOrderInfoResponse=" + mOrderInfoResponse +
                    '}';
        }


    }
}
