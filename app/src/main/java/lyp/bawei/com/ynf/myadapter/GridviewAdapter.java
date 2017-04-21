package lyp.bawei.com.ynf.myadapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import lyp.bawei.com.ynf.MyBean.Bean;
import lyp.bawei.com.ynf.R;

/**
 * Created by Administrator on 2017/4/18.
 */

public class GridviewAdapter extends BaseAdapter{
    private Context context;
    private List<Bean.DataBean.Ad5Bean> list;

    public GridviewAdapter(Context context, List<Bean.DataBean.Ad5Bean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=null;
        if (convertView==null){
            convertView=convertView.inflate(context, R.layout.gridview_item,null);
            holder=new Holder();
            holder.imageView= (ImageView) convertView.findViewById(R.id.gridview_item_img);
            holder.textView= (TextView) convertView.findViewById(R.id.gridview_item_text);
convertView.setTag(holder);
        }else {
            holder= (Holder) convertView.getTag();
        }
        Glide.with(context).load(list.get(position).getImage()).into(holder.imageView);
        holder.textView.setText(list.get(position).getTitle());
        return convertView;
    }
    class Holder{
        ImageView imageView;
        TextView textView;
    }
}
