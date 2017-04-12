package lyp.bawei.com.ynf.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import android.widget.Button;
import android.widget.RadioGroup;

import lyp.bawei.com.ynf.R;
import lyp.bawei.com.ynf.myfragment.Fenlei;
import lyp.bawei.com.ynf.myfragment.Gouwuche;
import lyp.bawei.com.ynf.myfragment.Guanzhu;
import lyp.bawei.com.ynf.myfragment.Shouye;
import lyp.bawei.com.ynf.myfragment.Wode;

/**
 * Created by Administrator on 2017/4/11.
 */
public class NextActivity extends FragmentActivity implements View.OnClickListener{

    private RadioGroup radiogroup;
    private FragmentManager supportFragmentManager;
    private Fenlei fenlei;
    private Gouwuche gouwuche;
    private Guanzhu guanzhu;
    private Shouye shouye;
    private Wode wode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next);
init();
    }

    private void init() {
        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);
       Button shouyebutton= (Button) findViewById(R.id.shouye);
        Button fenleibutton= (Button) findViewById(R.id.fenlei);
        Button guanzhubutton= (Button) findViewById(R.id.guanzhu);
        Button gouwuchebutton= (Button) findViewById(R.id.gouwuche);
        Button wodebutton= (Button) findViewById(R.id.wode);
        shouyebutton.setOnClickListener(this);
        fenleibutton.setOnClickListener(this);
        guanzhubutton.setOnClickListener(this);
        gouwuchebutton.setOnClickListener(this);
        wodebutton.setOnClickListener(this);

        fenlei = new Fenlei();
        gouwuche = new Gouwuche();
        guanzhu = new Guanzhu();
        shouye = new Shouye();
        wode = new Wode();
//默认选中
        radiogroup.check(R.id.shouye);

        supportFragmentManager = getSupportFragmentManager();
//开启事物
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//添加到布局
        fragmentTransaction.add(R.id.framelayout, shouye,"shouye");
        fragmentTransaction.add(R.id.framelayout, fenlei,"fenlei");
        fragmentTransaction.add(R.id.framelayout, guanzhu,"guanzhu");
        fragmentTransaction.add(R.id.framelayout, gouwuche,"gouwuche");
        fragmentTransaction.add(R.id.framelayout, wode,"wode");
//控制隐藏显示
        fragmentTransaction.show(shouye);
        fragmentTransaction.hide(fenlei);
        fragmentTransaction.hide(guanzhu);
        fragmentTransaction.hide(gouwuche);
        fragmentTransaction.hide(wode);

//提交事务
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.shouye:
                FragmentTransaction f1 = supportFragmentManager.beginTransaction();
                f1.show(shouye);
                f1.hide(wode);
                f1.hide(guanzhu);
                f1.hide(gouwuche);
                f1.hide(fenlei);
                /*f1.beginTransaction()
                        .setCustomAnimations(R.animator.animator_two_enter, R.animator.animator_one_exit)
                        .replace(R.id.fragment, new FragmentTwo())
                        .commit();*/
                f1.commit();
                break;
            case R.id.fenlei:
                FragmentTransaction f2 = supportFragmentManager.beginTransaction();
                f2.show(fenlei);
                f2.hide(wode);
                f2.hide(guanzhu);
                f2.hide(gouwuche);
                f2.hide(shouye);
                f2.commit();
                break;
            case R.id.wode:
                FragmentTransaction f3 = supportFragmentManager.beginTransaction();
                f3.show(wode);
                f3.hide(fenlei);
                f3.hide(guanzhu);
                f3.hide(gouwuche);
                f3.hide(shouye);
                f3.commit();
                break;
            case R.id.gouwuche:
                FragmentTransaction f4= supportFragmentManager.beginTransaction();
                f4.show(gouwuche);
                f4.hide(fenlei);
                f4.hide(guanzhu);
                f4.hide(wode);
                f4.hide(shouye);
                f4.commit();
                break;
            case R.id.guanzhu:
                FragmentTransaction f5= supportFragmentManager.beginTransaction();
                f5.show(guanzhu);
                f5.hide(fenlei);
                f5.hide(gouwuche);
                f5.hide(wode);
                f5.hide(shouye);
                f5.commit();
                break;
        }
    }
}
