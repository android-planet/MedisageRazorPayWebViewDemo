package com.medisage.medisagerazorpaydemo

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient


class MyWebViewClient(private val activity: Activity): WebViewClient() {

    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("_____url_2:","$url")

    }
    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        val errorMessage =
            "Error: ${error?.description}, Code: ${error?.errorCode}, URL: ${request?.url}"
        Log.e("WebView Error", errorMessage)

        // Handle the error as needed
    }


    /** This function is used to handle deeplink in webview */
    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        val url = request!!.url.toString()
        if (!url.startsWith("https") || !url.startsWith("http")){
            try {
                val i = Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(request.url.toString()))
                activity.startActivityForResult(i, 2001)
            } catch (e: ActivityNotFoundException) {

            }
        }
        return true

    }

}