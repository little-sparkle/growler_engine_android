package com.littlesparkle.growler.library.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.service.DownloadService;
import com.littlesparkle.growler.library.update.UpdatePackageInfo;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public abstract class UpdateActivity extends BaseFragmentActivity {
    UpdatePackageInfo updatePackageInfo = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void initData() {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("packageBundle");
        updatePackageInfo = (UpdatePackageInfo) bundle.getSerializable("updatePackageInfo");
    }

    @Override
    public void initView() {


    }

    public void StartServiceForDownload(DownloadService service) {
        Intent intent = new Intent(this, service.getClass());
        intent.putExtra("url", updatePackageInfo.getUrl());
        this.startService(intent);

    }

    @Subscribe(threadMode = ThreadMode.MainThread)
    public abstract void helloEventBus(float message);


}
