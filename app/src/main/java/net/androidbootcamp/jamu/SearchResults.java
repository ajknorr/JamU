package net.androidbootcamp.jamu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class SearchResults extends AppCompatActivity {

    WebView wv;
    @Override
    public void onBackPressed(){
        if(wv.canGoBack()){
            wv.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        wv = (WebView) findViewById(R.id.wv);
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // we are getting the day name and if not available it defaults
        // to the second parameter No Day which will produce nothing on the php page
        //Toast.makeText(getApplicationContext(), "Selected Day of Week for Deals:\n" + dayname, Toast.LENGTH_LONG).show();
        // set url to load to the url plus the day of week added at the end as a parameter
        // the question mark sets the name that goes in the php page which is dayofweek
        // apart from the actual name of the day that is from the getString method to the persistent class for dayofweek
        String urltoload = "http://www.profthompson.net/profpam_1/jamu.php";
        wv.loadUrl(urltoload);
        wv.setWebViewClient(new WebViewClient());

    }
}
