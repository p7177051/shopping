package lyp.bawei.com.ynf.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lyp.bawei.com.ynf.R;
import xlistview.bawei.com.xlistviewlibrary.XListView;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Shouye extends Fragment{

    private XListView shouye_xlistview;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shouye, null);
        init();

        return view;
    }

    private void init() {
        shouye_xlistview = (XListView) view.findViewById(R.id.shouye_xlistview);
    }
}
