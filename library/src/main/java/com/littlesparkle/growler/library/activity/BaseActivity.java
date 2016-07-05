package com.littlesparkle.growler.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.littlesparkle.growler.library.utility.ActivityMaster;

public abstract class BaseActivity extends FragmentActivity {

    public BaseActivity mBaseActivity;
    public LayoutInflater mLayoutInflater;
    public FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBaseActivity = this;
        mFragmentManager = this.getSupportFragmentManager();
        mLayoutInflater = this.getLayoutInflater();
        ActivityMaster.addActivityToMaster(this);
        setContentView(setActivityContentView());
        initData();
        initView();
    }

    public abstract int setActivityContentView();

    public abstract void initData();

    public abstract void initView();

    public void killself() {
        this.finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityMaster.delActivityToMaster(this);

    }

    public void startActivity(Class Activity) {
        Intent intent = new Intent(this, Activity);
        startActivity(intent);
    }

    public void startService(Class service) {
        Intent intent = new Intent(this, service);
        startService(intent);
    }

    public void startBroadcastReceiver(Class broadcastReceiver) {
        Intent intent = new Intent(this, broadcastReceiver);
        sendBroadcast(intent);
    }

    public void addFragment(int id, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.add(id, fragment, fragment.mTAG);
        fragmentTransaction.commit();
    }

    //移除fragment到Activiy
    public void removeFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }

    //隐藏fragment到Activiy
    public void hideFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.hide(fragment);
        fragmentTransaction.commit();
    }

    //显示fragment到Activiy
    public void showFragment(BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.show(fragment);
        fragmentTransaction.commit();
    }

    //替换fragment到Activiy
    public void replaceFragment(int contentID, BaseFragment fragment) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(contentID, fragment, fragment.mTAG);
        fragmentTransaction.commit();
    }

}
