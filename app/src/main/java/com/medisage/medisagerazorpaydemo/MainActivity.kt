package com.medisage.medisagerazorpaydemo

import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val webView = findViewById<WebView>(R.id.webview)
        webView.settings.apply {
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_CACHE_ELSE_NETWORK
        }
        webView.settings.setSupportMultipleWindows(true);
        webView.settings.javaScriptCanOpenWindowsAutomatically = true;
        webView.webViewClient = MyWebViewClient(this@MainActivity)

        // Load the URL in the WebView
        val url = "https://whatsapp-clinic-dev2.mymedisage.com/?medisage_ref_number=mirajs&fname=dilip&lname=sahu&mobile_number=8898400705&country_code=91&speciality=miraj&qualification=miraj&versionname=1.7.55"
        webView.loadUrl(url)
    }
}

