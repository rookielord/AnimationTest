package com.juiz.bujiananimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button btn_rotate,btn_translate,btn_scale,btn_alpha,btn_all;
    private ImageView iv;
    private TranslateAnimation translateAnima;
    private RotateAnimation rotateAnima;
    private ScaleAnimation scaleAnima;
    private AlphaAnimation alphaAnima;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件设置监听
        btn_translate= (Button) findViewById(R.id.btn_translate);
        btn_scale= (Button) findViewById(R.id.btn_scale);
        btn_alpha= (Button) findViewById(R.id.btn_alpha);
        btn_rotate= (Button) findViewById(R.id.btn_rotate);
        btn_all= (Button) findViewById(R.id.btn_all);
        btn_translate.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_rotate.setOnClickListener(this);
        btn_alpha.setOnClickListener(this);
        btn_all.setOnClickListener(this);
        //对图片添加效果
        iv = (ImageView) findViewById(R.id.iv);
    }

    //根据效果的不同使用的是4个动画对象
    @Override
    public void onClick(View v) {
        //移动的参考物是自己
        final int MOVE=Animation.RELATIVE_TO_SELF;
        switch (v.getId()){
            //里氏替换原则
            case R.id.btn_translate:
                //第一种根据原本位置的像素移动
                //translateAnima = new TranslateAnimation(0,50,0,50);
                //第二种设置移动的参考物，即相对于什么的宽度进行移动
                translateAnima=new TranslateAnimation(MOVE,0,MOVE,0.5f,MOVE,0,MOVE,-0.5f);
                translateAnima.setDuration(2000);
                translateAnima.setFillAfter(true);
                iv.startAnimation(translateAnima);
                break;
            case R.id.btn_rotate:
                //第一种表示旋转的角度以及以哪个点来旋转
                //rotateAnima = new RotateAnimation(0,240,0,0);
                rotateAnima=new RotateAnimation(0,180,MOVE,0.5f,MOVE,0.5f);
                rotateAnima.setDuration(2000);
                iv.startAnimation(rotateAnima);
                break;
            case R.id.btn_scale:
                //第一种表示相对于左上角来进行x和y方向的缩放
                //scaleAnima = new ScaleAnimation(1,2,0.5f,2);
                //第二种指定缩放的位置,用相对于自己找到
                scaleAnima=new ScaleAnimation(1,2,0.5f,2,MOVE,0.5f,MOVE,0.5f);
                scaleAnima.setDuration(2000);
                iv.startAnimation(scaleAnima);
                break;
            case R.id.btn_alpha:
                alphaAnima = new AlphaAnimation(1,0);
                alphaAnima.setDuration(2000);
                iv.startAnimation(alphaAnima);
                break;
            case R.id.btn_all:
                AnimationSet as=new AnimationSet(false);
                as.addAnimation(translateAnima);
                as.addAnimation(rotateAnima);
                as.addAnimation(scaleAnima);
                as.addAnimation(alphaAnima);
                iv.startAnimation(as);
                break;
        }

    }
}
