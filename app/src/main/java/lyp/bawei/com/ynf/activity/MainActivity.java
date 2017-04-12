package lyp.bawei.com.ynf.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import lyp.bawei.com.ynf.R;
import lyp.bawei.com.ynf.utile.CustomVideoView;

public class MainActivity extends AppCompatActivity {


    private VideoView m_vv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            initView();

    }
    private void initView() {
        m_vv = (CustomVideoView) findViewById(R.id.m_vv);
        //设置播放加载路径
        m_vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.guide_1));
        //播放
        m_vv.start();
       m_vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
           @Override
           public void onCompletion(MediaPlayer mp) {
               Intent intent=new Intent(MainActivity.this,NextActivity.class);
               startActivity(intent);
               finish();
           }
       });

    }


    }


