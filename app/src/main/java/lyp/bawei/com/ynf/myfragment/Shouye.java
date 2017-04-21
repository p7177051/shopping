package lyp.bawei.com.ynf.myfragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import lyp.bawei.com.ynf.MyBean.Bean;
import lyp.bawei.com.ynf.R;
import lyp.bawei.com.ynf.activity.XianqingActivity;
import lyp.bawei.com.ynf.myadapter.GridviewAdapter;
import lyp.bawei.com.ynf.myadapter.HomeAdapter;
import lyp.bawei.com.ynf.myadapter.ItemHomeAdapter;
import lyp.bawei.com.ynf.myadapter.MoreItem;
import lyp.bawei.com.ynf.utile.Imag;

import lyp.bawei.com.ynf.utile.Myokhttp;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Shouye extends Fragment {


    private View view;
    private Bean.DataBean data;
    private Banner shouye_banner;
    private ArrayList<String> imglist;
    private List<Bean.DataBean.Ad1Bean> ad1;
    private GridView shouye_gridview;
    private RecyclerView shouye_hrecycler;
    private RecyclerView shouye_moreitem;
    private SwipeRefreshLayout shouye_mrefresh;
    private Handler mHandler = new Handler();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shouye, null);
        init();
        getdatafrominter();
        getRefresh();
        return view;
    }

    private void init() {
        shouye_banner = (Banner) view.findViewById(R.id.shouye_banner);
        shouye_gridview = (GridView) view.findViewById(R.id.shouye_gridview);
        shouye_hrecycler = (RecyclerView) view.findViewById(R.id.shouye_hrecycler);
        shouye_moreitem = (RecyclerView) view.findViewById(R.id.shouye_moreitem);
        shouye_mrefresh = (SwipeRefreshLayout) view.findViewById(R.id.shouye_mrefresh);

    }
public void getRefresh(){
    shouye_mrefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh(){
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    getdatafrominter();
                    shouye_mrefresh.setRefreshing(false);
                }
            },1000);
        }
    });

}
public void getmoreitem(List<Bean.DataBean.SubjectsBean> mDatas){
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
    shouye_moreitem.setLayoutManager(linearLayoutManager);

    MoreItem moreItem=new MoreItem(getActivity(),mDatas);
    shouye_moreitem.setAdapter(moreItem);


}

    public void getHrecycler(List<Bean.DataBean.BestSellersBean.GoodsListBeanX> list) {
//设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        shouye_hrecycler.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//设置adapter
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(), list);
        shouye_hrecycler.setAdapter(homeAdapter);
//设置Item增加、移除动画
        shouye_hrecycler.setItemAnimator(new DefaultItemAnimator());
/*//添加分割线
    shouye_hrecycler.addItemDecoration(new RecyclerViewDivider(
            this, LinearLayoutManager.VERTICAL, 5, ContextCompat.getColor(getActivity(), R.color.colorAccent)));*/
    }

    private void getbanner(ArrayList<String> imglist, final List<Bean.DataBean.Ad1Bean> ad1) {
        shouye_banner.setImageLoader(new Imag());
        shouye_banner.setImages(imglist);
        shouye_banner.setIndicatorGravity(BannerConfig.RIGHT);
        shouye_banner.start();
        shouye_banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                Intent intent = new Intent(getActivity(), XianqingActivity.class);
                intent.putExtra("url", ad1.get(position).getAd_type_dynamic_data());
                startActivity(intent);
            }
        });
    }

    public void getridview(final List<Bean.DataBean.Ad5Bean> ad5) {
        GridviewAdapter gridviewAdapter = new GridviewAdapter(getActivity(), ad5);
        shouye_gridview.setAdapter(gridviewAdapter);
        shouye_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), XianqingActivity.class);
                intent.putExtra("url", ad5.get(position).getAd_type_dynamic_data());
                startActivity(intent);
            }
        });
    }

    public void getdatafrominter() {

        String url = "http://m.yunifang.com/yunifang/mobile/home?random=84831&encode=9dd34239798e8cb22bf99a75d1882447";
        Myokhttp myokhttp = Myokhttp.getInstance();
        myokhttp.getData(url);
        myokhttp.getMyData(new Myokhttp.MyData() {
            @Override
            public void getdata(String json) {
                Gson gson = new Gson();
                Bean bean = gson.fromJson(json, Bean.class);
                data = bean.getData();
                ad1 = data.getAd1();
                imglist = new ArrayList<>();
                for (int i = 0; i < ad1.size(); i++) {
                    imglist.add(ad1.get(i).getImage());
                }

                final List<Bean.DataBean.Ad5Bean> ad5 = data.getAd5();
                final List<Bean.DataBean.BestSellersBean.GoodsListBeanX> goodsList = data.getBestSellers().get(0).getGoodsList();
                final List<Bean.DataBean.SubjectsBean> subjects = data.getSubjects();
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getbanner(imglist, ad1);
                        getridview(ad5);
                        getHrecycler(goodsList);
                        getmoreitem(subjects);
                    }
                });

            }
        });


    }
}
