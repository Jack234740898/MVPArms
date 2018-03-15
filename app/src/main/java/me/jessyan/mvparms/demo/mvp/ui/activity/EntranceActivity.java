package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import butterknife.BindView;
import butterknife.OnClick;
import me.jackzhang.module2.Module2Activity;
import me.jackzhang.module1.Module1Activity;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerEntranceComponent;
import me.jessyan.mvparms.demo.di.module.EntranceModule;
import me.jessyan.mvparms.demo.mvp.contract.EntranceContract;
import me.jessyan.mvparms.demo.mvp.presenter.EntrancePresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class EntranceActivity extends BaseActivity<EntrancePresenter> implements EntranceContract.View {


    @BindView(R.id.btn_toModule1)
    Button mBtnToModule1;
    @BindView(R.id.btn_toModule2)
    Button mBtnToModule2;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerEntranceComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .entranceModule(new EntranceModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_entrance; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


    @OnClick({R.id.btn_toModule1, R.id.btn_toModule2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_toModule1:
                Module1Activity.launchActivity("module1=",1111);
                break;
            case R.id.btn_toModule2:
                Module2Activity.launchActivity("module2=",2222);
                break;
        }
    }
}
