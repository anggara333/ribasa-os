package com.ribasa.os;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;
public class MainActivity extends Activity {
    private WebView webView;
    private static final String REMOTE_URL = "https://anggara333.github.io/ribasa-os/";
    private static final String LOCAL_URL = "file:///android_asset/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        webView = new WebView(this);
        setContentView(webView);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onReceivedError(WebView view, int code, String desc, String url){
                if(url.equals(REMOTE_URL)) view.loadUrl(LOCAL_URL);
            }
        });
        webView.loadUrl(REMOTE_URL);
    }
    @Override
    public void onBackPressed() {
        if(webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }
}
