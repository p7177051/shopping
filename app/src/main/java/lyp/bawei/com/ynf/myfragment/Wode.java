package lyp.bawei.com.ynf.myfragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import lyp.bawei.com.ynf.R;
import lyp.bawei.com.ynf.activity.LoginActivity;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Wode extends Fragment{

    private ImageView user_img;
    private Button user_login;
    private ImageView user_zhuxuao;
    private SharedPreferences.Editor edit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_wode, null);
        user_img = (ImageView) inflate.findViewById(R.id.user_img);
        user_login = (Button) inflate.findViewById(R.id.user_login);
        user_zhuxuao = (ImageView) inflate.findViewById(R.id.user_zhuxuao);
        getZhuce();
        SharedPreferences denglu = getActivity().getSharedPreferences("denglu", getActivity().MODE_PRIVATE);
        edit = denglu.edit();
        if (denglu.getBoolean("flag", false)) {
            user_img.setImageResource(R.mipmap.ic_launcher);
            user_login.setText(denglu.getString("zhanghao", "登陆"));
        }
        getZhuxiao();
        return inflate;
    }
public void getZhuce(){
    user_login.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivityForResult(intent, 201);
        }
    });
}
    public void getZhuxiao(){
        user_zhuxuao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.putBoolean("flag",false);
                edit.commit();
                Toast.makeText(getActivity(), "注销成功", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==201&&resultCode==101){
            user_img.setImageResource(R.mipmap.ic_launcher);
            user_login.setText(data.getStringExtra("name"));
        }
    }
}
