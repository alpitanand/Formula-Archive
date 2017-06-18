package com.example.alpit.formula2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by 1407268 on 07-05-2017.
 */
public class mseries extends Fragment {
    private Toolbar toolbar;
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mosfunction, container, false);
        webView = (WebView)v.findViewById(R.id.phy_law_web);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/mathscribe/mostseries.html");
        return v;
    }
}

