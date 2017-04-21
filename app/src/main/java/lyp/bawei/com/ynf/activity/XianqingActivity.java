package lyp.bawei.com.ynf.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import lyp.bawei.com.ynf.R;

/**
 * Created by Administrator on 2017/4/13.
 */
public class XianqingActivity extends Activity{

    private WebView xingqing_web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.xiangqing);
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        xingqing_web = (WebView) findViewById(R.id.xingqing_web);
        xingqing_web.loadUrl(url);
    }
}
