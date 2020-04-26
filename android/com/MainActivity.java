package android.com;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * Demo of creating an application to open any URL inside the application and clicking on any link from that URl
should not open Native browser but  that URL should open in the same screen.
 */
public class MainActivity extends Activity {
    /** Called when the activity is first created. */

    WebView web1,web2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        web1 = (WebView) findViewById(R.id.webview01);
        web1.setWebViewClient(new myWebClient());
        web1.getSettings().setJavaScriptEnabled(true);
        web1.loadUrl("http://xx.duckdns.org:8081/cam.html");

        web2 = (WebView) findViewById(R.id.webview02);
        web2.setWebViewClient(new myWebClient());
        web2.getSettings().setJavaScriptEnabled(true);
        web2.loadUrl("http://xx.duckdns.org:8081/list.html");
        web2.setVerticalScrollBarEnabled(true);
        web2.setHorizontalScrollBarEnabled(true);
    }

    public class myWebClient extends WebViewClient
    {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @SuppressWarnings("deprecation")
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            Log.e("webview",errorCode + " : " + description + " at " + failingUrl);
        }

    }



}
