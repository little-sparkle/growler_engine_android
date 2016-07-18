package com.littlesparkle.growler.library.update;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.littlesparkle.growler.library.activity.UpdateActivity;
import com.littlesparkle.growler.library.http.BaseHttpSubscriber;
import com.littlesparkle.growler.library.http.Request;
import com.littlesparkle.growler.library.http.api.ApiException;
import com.littlesparkle.growler.library.http.converter.ConvertFactory;
import com.littlesparkle.growler.library.misc.MiscHelper;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.io.File;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by dell on 2016/7/14.
 */

public class UpdateTask extends Request<UpdateService> {


    public void setContext(Context context) {
        this.context = context;
    }


    public void setUpdateActivity(UpdateActivity updateActivity) {
        this.updateActivity = updateActivity;
    }

    private UpdateActivity updateActivity = null;
    private Context context = null;
    private UpdateRequestInfo updateRequestInfo = null;

    public UpdateTask(String baseUrl) {
        super(baseUrl);

        updateRequestInfo = new UpdateRequestInfo();
//        设置平台名
        updateRequestInfo.setPlatform("");
//        包名
        updateRequestInfo.setIdentification(MiscHelper.getPackageName(context));
//        版本名
        updateRequestInfo.setVersion_name(MiscHelper.getVersionName(context));
//        版本号
        updateRequestInfo.setVersion_code(MiscHelper.getVersionCode(context));


    }


    @Override
    protected Class<UpdateService> getServiceClass() {
        return UpdateService.class;
    }

    public void askUpdate() {

        this.mService
                .otaUpdate(updateRequestInfo)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseHttpSubscriber<UpdatePackageInfo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    protected void onError(ApiException err) {

                    }

                    @Override
                    public void onNext(UpdatePackageInfo updatePackageInfo) {
                        if (updatePackageInfo.getVersionI() > updateRequestInfo.getVersion_code()) {

                            Intent intent = new Intent(context, updateActivity.getClass());
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("updatePackageInfo", updatePackageInfo);
                            intent.putExtra("packageBundle", bundle);
                            context.startActivity(intent);

                        } else {
                            Toast.makeText(context, "当前为最新版本", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
