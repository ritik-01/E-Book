package in.ac.sharda;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class DescriptionActivity extends AppCompatActivity {

    private Bundle extras;
    private static final String TAG = "DescriptionActivity";
    private Context mContext;
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        mContext=DescriptionActivity.this;

        webView=(WebView)findViewById(R.id.simpleWebView);

        extras = getIntent().getExtras();
        if(!extras.equals(null)){
            String data  = extras.getString("titles");
            Log.d(TAG, "onCreate: the coming data is "+data);

            webView.loadUrl("file:///android_asset/"+data+".html");

            WebSettings webSettings= webView.getSettings();
            webSettings.setBuiltInZoomControls(true);
            webSettings.setDisplayZoomControls(true);
            webSettings.setJavaScriptEnabled(true);
        }
    }
}
