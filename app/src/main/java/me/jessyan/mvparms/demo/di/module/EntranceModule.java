package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

import me.jessyan.mvparms.demo.mvp.contract.EntranceContract;
import me.jessyan.mvparms.demo.mvp.model.EntranceModel;


@Module
public class EntranceModule {
    private EntranceContract.View view;

    /**
     * 构建EntranceModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public EntranceModule(EntranceContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    EntranceContract.View provideEntranceView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    EntranceContract.Model provideEntranceModel(EntranceModel model) {
        return model;
    }
}