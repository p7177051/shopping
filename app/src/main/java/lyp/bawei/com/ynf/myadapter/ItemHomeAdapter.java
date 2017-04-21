package lyp.bawei.com.ynf.myadapter;

import android.content.Context;
import android.content.Intent;
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
import lyp.bawei.com.ynf.activity.GoumaiActivity;

/**
 * Created by Administrator on 2017/4/18.
 */

public class ItemHomeAdapter extends RecyclerView.Adapter<ItemHomeAdapter.MyHolder>{
    private Context context;
    private List<Bean.DataBean.SubjectsBean.GoodsListBean> list;
   private List<String> goodsIdsList;

    public ItemHomeAdapter(Context context, List<Bean.DataBean.SubjectsBean.GoodsListBean> list, List<String> goodsIdsList) {
        this.context = context;
        this.list = list;
        this.goodsIdsList = goodsIdsList;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.gridview_item, parent, false);
        final MyHolder holder =  new MyHolder(inflate);
        inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,GoumaiActivity.class);
                String s = goodsIdsList.get(holder.getLayoutPosition());
                intent.putExtra("id",s);
                context.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        Glide.with(context).load(list.get(position).getGoods_img()).into(holder.imageView);
        holder.textView.setText(list.get(position).getGoods_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.gridview_item_img);
            textView= (TextView) itemView.findViewById(R.id.gridview_item_text);
        }
    }
}
