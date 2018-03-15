package com.jackzhang.modules.example;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import me.jessyan.mvparms.demo.BuildConfig;

@Route(path = "/entrance/loadactivity")
public class LoadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        //arouter配置
        ARouter.init(((Application) getApplicationContext())); // 尽可能早，推荐在Application中初始化
        ARouter.getInstance()
                .build(BuildConfig.MODULE_ENTRANCE)
                .navigation();
        finish();
    }
}
