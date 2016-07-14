package com.littlesparkle.growler.library.boradcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.igexin.sdk.PushConsts;
import com.littlesparkle.growler.library.bean.User;

/**
 * Created by dell on 2016/7/13.
 */
public abstract class PushGeTuiReceiver<T> extends BroadcastReceiver {

    public abstract void onMessageGet(Context context, String data);

    public abstract void onCidGet(Context context, String cid);


    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        switch (bundle.getInt(PushConsts.CMD_ACTION)) {
            case PushConsts.GET_CLIENTID:
                String cid = bundle.getString("clientid");
//                这里获取到用户的CID  可以跟用户个人资料绑定  实现定向发送
                onCidGet(context, cid);
                break;
            case PushConsts.GET_MSG_DATA:
                byte[] payload = bundle.getByteArray("payload");

                if (payload != null) {
                    String data = new String(payload);
//                    这里处理字符串
                    onMessageGet(context, data);
                }
                break;

        }

    }
}
