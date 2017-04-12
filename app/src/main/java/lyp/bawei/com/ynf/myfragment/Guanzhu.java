package lyp.bawei.com.ynf.myfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lyp.bawei.com.ynf.R;

/**
 * Created by Administrator on 2017/4/11.
 */

public class Guanzhu extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_guanzhu, null);
        return inflate;
    }
}
