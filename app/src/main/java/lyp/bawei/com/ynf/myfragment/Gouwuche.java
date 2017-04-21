package lyp.bawei.com.ynf.myfragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import lyp.bawei.com.ynf.MyBean.MyGoodsBean;
import lyp.bawei.com.ynf.R;
import lyp.bawei.com.ynf.myadapter.GouwucheAdapter;
import lyp.bawei.com.ynf.utile.Myokhttp;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Gouwuche extends Fragment{

    private View view;
    private CheckBox gouwuche_checkbox;
    private Button gouwuche_jiesuan;
    private RecyclerView gouwuche_recycler;
    private TextView gouyuche_count;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gouwuche, null);
        init();
        getDat();
        return view;
    }

    private void init() {
        gouwuche_checkbox = (CheckBox) view.findViewById(R.id.gouwuche_checkbox);
        gouwuche_jiesuan = (Button) view.findViewById(R.id.gouwuche_jiesuan);
        gouwuche_recycler = (RecyclerView) view.findViewById(R.id.gouwuche_recycler);
        gouyuche_count = (TextView) view.findViewById(R.id.gouyuche_count);

    }
    public void getDat(){
        SharedPreferences denglu = getActivity().getSharedPreferences("denglu", getActivity().MODE_PRIVATE);
        int id = denglu.getInt("id", 110);
        String url="http://169.254.217.5:8080/bullking1/cart?userID="+id;
        Myokhttp myokhttp = Myokhttp.getInstance();
        myokhttp.getData(url);
        myokhttp.getMyData(new Myokhttp.MyData() {

            private List<MyGoodsBean.CartItemListBean> cartItemList;

            @Override
            public void getdata(String json) {
                Gson gson=new Gson();
                cartItemList = gson.fromJson(json, MyGoodsBean.class).cartItemList;

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GouwucheAdapter gouwucheAdapter=new GouwucheAdapter(getActivity(), cartItemList);
                        gouwuche_recycler.setAdapter(gouwucheAdapter);
                        gouwuche_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
                        gouwuche_recycler.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
                    }
                });

            }
        });
    }
}
