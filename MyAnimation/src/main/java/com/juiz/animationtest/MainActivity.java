package com.juiz.animationtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BaseInterpolator;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //通过属性动画来控制，有两种方式：1.代码向2.xml文档向
    Button btn_translate,btn_scale,btn_alpha,btn_rotate,btn_all;
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_rotate= (Button) findViewById(R.id.btn_rotate);
        btn_scale= (Button) findViewById(R.id.btn_scale);
        btn_alpha= (Button) findViewById(R.id.btn_alpha);
        btn_translate= (Button) findViewById(R.id.btn_translate);
        btn_all= (Button) findViewById(R.id.btn_all);
        iv = (ImageView) findViewById(R.id.iv);
        //设置坚挺
        btn_scale.setOnClickListener(this);
        btn_translate.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_alpha.setOnClickListener(this);
        btn_all.setOnClickListener(this);
    }

    //以上都是根据其iv中动画效果设定值的名称来的，设置的内容是通过之前补间动画时设置的东西一样
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_translate:
                ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv, "TranslationX", 10, 100);
                oa1.setRepeatMode(Animation.REVERSE);
                oa1.setRepeatCount(1);
                oa1.setDuration(3000);
                oa1.start();
                break;
            case R.id.btn_alpha:
                ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv, "Alpha", 0, 0.5f, 1);
                oa2.setDuration(4000);
                oa2.start();
                break;
            case R.id.btn_rotate:
                ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv, "Rotation", 0, 180, 0, 360, -200);
                oa3.setDuration(3000);
                oa3.start();
                break;
            case R.id.btn_scale:
                ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv, "ScaleX", 1, 0.4f, 2);
                oa4.setDuration(2000);
                oa4.start();
                break;
            case R.id.btn_all:
                AnimatorSet as=new AnimatorSet();
                as.setTarget(iv);
                //这个会设置其开始坐标
                ObjectAnimator oa11 = ObjectAnimator.ofFloat(iv, "TranslationX", 10, -34, 100);
                ObjectAnimator oa22 = ObjectAnimator.ofFloat(iv, "Alpha", 0, 0.5f, 1);
                ObjectAnimator oa33 = ObjectAnimator.ofFloat(iv, "Rotation", 0, 180, 0, 360, -200);
                ObjectAnimator oa44 = ObjectAnimator.ofFloat(iv, "ScaleX", 1, 0.4f, 2);
                //一起显示
                //as.playTogether(oa11,oa22,oa33,oa44);
                //分别显示
                as.playSequentially(oa11,oa22,oa33,oa44);
                as.start();


        }
    }
}
