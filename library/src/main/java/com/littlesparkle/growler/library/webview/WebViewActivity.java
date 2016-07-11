package com.littlesparkle.growler.library.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.numberprogressbar.NumberProgressBar;
import com.littlesparkle.growler.library.R;
import com.littlesparkle.growler.library.activity.BaseActivity;
import com.littlesparkle.growler.library.dialog.DialogHelper;
import com.littlesparkle.growler.library.utility.FileUtils;

import java.io.File;

public class WebViewActivity extends BaseActivity implements BaseWebChromeClient.OnOpenFileChooserListener {
    private static final int PHOTO_REQUEST_CAMERA = 1;
    private static final int PHOTO_REQUEST_GALLERY = 2;

    private static final String PHOTO_FILE_NAME = "temp_photo.jpg";
    private File mTempFile;

    private WebView mWebView;
    private NumberProgressBar mNpb;
    private AppCompatImageView mBack;
    private AppCompatImageView mClose;
    private TextView mTitle;

    private ValueCallback<Uri> mOneFileUploadCallback;
    private ValueCallback<Uri[]> mMultiFilesUploadCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mWebView = (WebView) findViewById(R.id.webview);
        mNpb = (NumberProgressBar) findViewById(R.id.number_progress_bar);
        mBack = (AppCompatImageView) findViewById(R.id.back);
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mClose = (AppCompatImageView) findViewById(R.id.close);
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mTitle = (TextView) findViewById(R.id.title_text);

        mNpb.setMax(100);
        mNpb.setProgress(0);

        initWebView();

        String url = getIntent().getStringExtra("url");
        String title = getIntent().getStringExtra("title");
        mTitle.setText(title);
//        mWebView.loadUrl(url);
//        mWebView.loadUrl("file:///android_asset/index.html");
        mWebView.loadUrl("file:///android_asset/test.html");
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);


        mWebView.setWebViewClient(new BaseWebViewClient());
        BaseWebChromeClient webChromeClient = new BaseWebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                mNpb.setProgress(newProgress);
                if (newProgress == 100) {
                    mNpb.setVisibility(View.INVISIBLE);
                } else {
                    mNpb.setVisibility(View.VISIBLE);
                }
            }
        };
        webChromeClient.setOnOpenFileChooserListener(this);
        mWebView.setWebChromeClient(webChromeClient);
        mWebView.addJavascriptInterface(new WebViewResultInterface(this), "WebViewResultInterface");

        mWebView.requestFocusFromTouch();
    }

    private class WebViewResultInterface {
        private Context mContext;

        public WebViewResultInterface(Context context) {
            this.mContext = context;
        }

        @JavascriptInterface
        public void onSuccess(String resule) {
            Toast.makeText(mContext, resule, Toast.LENGTH_SHORT).show();
            if (mListener != null) {
                mListener.onSuccess(resule);
            }
        }

        @JavascriptInterface
        public void onFailed(String resule) {
            Toast.makeText(mContext, resule, Toast.LENGTH_SHORT).show();
            if (mListener != null) {
                mListener.onFailed(resule);
            }
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private final void getImage() {
        if (!FileUtils.hasSdcard()) {
            return;
        }

        DialogHelper.showOptionsDialog(this, new int[]{R.string.capture, R.string.album},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                camera();
                                break;
                            case 1:
                                gallery();
                                break;
                            default:
                                break;
                        }
                    }
                },
                new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        if (mOneFileUploadCallback != null) {
                            mOneFileUploadCallback.onReceiveValue(null);
                            mOneFileUploadCallback = null;
                        }
                        if (mMultiFilesUploadCallback != null) {
                            mMultiFilesUploadCallback.onReceiveValue(null);
                            mMultiFilesUploadCallback = null;
                        }
                    }
                }, null
        );
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (null == mOneFileUploadCallback && null == mMultiFilesUploadCallback) {
            return;
        }
        Uri uri = null;
        if (requestCode == PHOTO_REQUEST_CAMERA) {
            if (FileUtils.hasSdcard()) {
                uri = Uri.fromFile(mTempFile);
            } else {
                Toast.makeText(this, R.string.sdcard_not_found, Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == PHOTO_REQUEST_GALLERY) {
            if (intent != null) {
                uri = intent.getData();
            }
        }

        if (mMultiFilesUploadCallback != null) {
            if (uri == null) {
                mMultiFilesUploadCallback.onReceiveValue(null);
            } else {
                Uri[] uris = {uri};
                mMultiFilesUploadCallback.onReceiveValue(uris);
            }
            mMultiFilesUploadCallback = null;
        }
        if (mOneFileUploadCallback != null) {
            mOneFileUploadCallback.onReceiveValue(uri);
            mOneFileUploadCallback = null;
        }
    }

    private void camera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        mTempFile = new File(Environment.getExternalStorageDirectory(),
                PHOTO_FILE_NAME);
        Uri uri = Uri.fromFile(mTempFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        startActivityForResult(intent, PHOTO_REQUEST_CAMERA);
    }

    private void gallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, PHOTO_REQUEST_GALLERY);
    }

    @Override
    public void openFileChooserWithOneFile(ValueCallback<Uri> uploadMsg) {
        mOneFileUploadCallback = uploadMsg;
        getImage();
    }

    @Override
    public void openFileChooserWithMultiFiles(ValueCallback<Uri[]> filePathCallback) {
        mMultiFilesUploadCallback = filePathCallback;
        getImage();
    }

    private ResultListener mListener;

    public void setResultListener(ResultListener listener) {
        mListener = listener;
    }

    public interface ResultListener {
        void onSuccess(String resule);

        void onFailed(String resule);
    }
}
