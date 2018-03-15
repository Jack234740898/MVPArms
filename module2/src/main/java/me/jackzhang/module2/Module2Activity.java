package me.jackzhang.module2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/module2/module2activity")
public class Module2Activity extends AppCompatActivity {
    String mName = "";
    int mAge = 0;
    @BindView(R2.id.tv_module2)
    TextView mTvModule2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();
        mName = intent.getExtras().getString("name");
        mAge = intent.getExtras().getInt("age");
        mTvModule2.setText("toModule2"+"name="+mName+"age="+mAge);
    }
    public static void launchActivity(String name, int age) {
        ARouter.getInstance()
                .build("/module2/module2activity")
                .withString("name", name)
                .withInt("age", age)
                .navigation();
    }
}
