package lyp.bawei.com.ynf.myadapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lyp.bawei.com.ynf.MyBean.Bean;
import lyp.bawei.com.ynf.MyBean.MyGoodsBean;
import lyp.bawei.com.ynf.R;

/**
 * Created by Administrator on 2017/4/18.
 */

public class GouwucheAdapter extends RecyclerView.Adapter<GouwucheAdapter.MyHolder>{
    private Context context;
    private  List<MyGoodsBean.CartItemListBean> list;

    public GouwucheAdapter(Context context,  List<MyGoodsBean.CartItemListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.car_item, parent, false);
        final MyHolder holder =  new MyHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, final int position) {
        Glide.with(context).load(list.get(position).pic).into(holder.imageView);
       holder.price.setText("$"+list.get(position).price);
        holder.name.setText(list.get(position).name);
        holder.ch.setChecked(list.get(position).isChecked);
holder.ch.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if(holder.ch.isChecked()){
            list.get(position).isChecked=true;
        }else {
            list.get(position).isChecked=false;
        }

    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView price;
        TextView name;
        CheckBox ch;
        public MyHolder(View itemView) {
            super(itemView);
            imageView= (ImageView) itemView.findViewById(R.id.car_item_img);
            name= (TextView) itemView.findViewById(R.id.car_item_name);
            price=(TextView) itemView.findViewById(R.id.car_item_price);
            ch= (CheckBox) itemView.findViewById(R.id.car_item_check);
        }
    }
}
