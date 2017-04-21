package lyp.bawei.com.ynf.myadapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lyp.bawei.com.ynf.MyBean.Bean;
import lyp.bawei.com.ynf.R;

/**
 * Created by Administrator on 2017/4/18.
 */

public class MoreItem extends RecyclerView.Adapter<MoreItem.MyHolder>{
    private Context context;
    private List<Bean.DataBean.SubjectsBean> list;

    public MoreItem(Context context, List<Bean.DataBean.SubjectsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.shouye_more_item, parent, false);
        final MyHolder holder =  new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
//设置adapter
        List<Bean.DataBean.SubjectsBean.GoodsListBean> goodsList = list.get(position).getGoodsList();
        List<String> goodsIdsList = list.get(position).getGoodsIdsList();
        ItemHomeAdapter itemHomeAdapter=new ItemHomeAdapter(context,goodsList,goodsIdsList);
        holder.recyclerView.setAdapter(itemHomeAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        RecyclerView recyclerView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.moreitem_img);
            recyclerView= (RecyclerView) itemView.findViewById(R.id.moreitem_recycler);
        }
    }
}
