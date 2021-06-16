package com.sports.betapp;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class NewsFragment extends Fragment {
    Context context;
    public WebView webView;
    public ProgressDialog progress;
    String url="https://www.eurosport.com/football/europa-league/score-center.shtml";

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_news, container, false);
        webView = (WebView) v.findViewById(R.id.webview);

        final ProgressDialog dialog = ProgressDialog.show(getActivity(), "", "Please wait, Loading ...", true);


        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setBuiltInZoomControls(false);

        webView.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {}

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                dialog.show();
            }

            @Override
            public void onPageFinished(WebView view, String url){
                dialog.dismiss();
                String webUrl = webView.getUrl();
            }


        });

        webView.loadUrl(url);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
