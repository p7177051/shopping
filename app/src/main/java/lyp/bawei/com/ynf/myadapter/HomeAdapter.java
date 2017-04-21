package lyp.bawei.com.ynf.myadapter;

import android.content.Context;
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
import lyp.bawei.com.ynf.utile.Imag;

/**
 * Created by Administrator on 2017/4/18.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder>{
    private Context context;
    private List<Bean.DataBean.BestSellersBean.GoodsListBeanX> list;

    public HomeAdapter(Context context, List<Bean.DataBean.BestSellersBean.GoodsListBeanX> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.gridview_item, parent, false);
        final MyHolder holder =  new MyHolder(inflate);
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
