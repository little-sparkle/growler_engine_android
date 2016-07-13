package com.littlesparkle.growler.library.webview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.DownloadListener;

import com.littlesparkle.growler.library.log.Logger;

public class BaseWebViewDownloadListener implements DownloadListener {
    private Context mContext;

    public BaseWebViewDownloadListener(@NonNull Context context) {
        mContext = context;
    }

    @Override
    public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
        Logger.log("onDownloadStart " + url);
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        mContext.startActivity(intent);
    }
}
