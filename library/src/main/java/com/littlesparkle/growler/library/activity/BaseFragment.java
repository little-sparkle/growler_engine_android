package com.littlesparkle.growler.library.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.littlesparkle.growler.library.R;


/**
 * Created by dell on 2016/7/2.
 */
public abstract class BaseFragment extends Fragment {
    public BaseActivity mBaseActivity;
    public BaseFragment mBaseFragment;
    public String mTAG;
    public FragmentManager mFragmentManager;
    public LayoutInflater mLayoutInflater;
    public View mContentView;

    public BaseFragment() {
        mTAG = this.getClass().getSimpleName() + System.currentTimeMillis();
        mBaseFragment = this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        mBaseActivity = (BaseActivity) this.getActivity();
        mLayoutInflater = mBaseActivity.getLayoutInflater();
        mFragmentManager = this.getFragmentManager();
        mContentView = mLayoutInflater.inflate(setContentView(), container, false);
        initViews(savedInstanceState);
        initData();
        return mContentView;
    }

    public abstract int setContentView();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initData();

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public void killSelf() {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        transaction.remove(this);
        mFragmentManager.popBackStackImmediate();
        transaction.commit();
    }


    //跳转到其他Activity的操作
    public void startActivity(Class ActivityClass) {
        Intent intent = new Intent(mBaseActivity, ActivityClass);
        this.startActivity(intent);
    }

    //跳转到其他ActivityForRS的操作
    public void startActivityForResult(Class ActivityClass, int reqCode) {
        Intent intent = new Intent(mBaseActivity, ActivityClass);
        this.startActivityForResult(intent, reqCode);
    }
}
