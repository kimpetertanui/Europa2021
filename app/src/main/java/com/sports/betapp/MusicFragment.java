package com.sports.betapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MusicFragment extends Fragment {

    Context context;
    public WebView webView;
    public ProgressDialog progress;
    String url="https://www.eurosport.com/football/europa-league/standingperson.shtml";
    public MusicFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_music, container, false);
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

}
