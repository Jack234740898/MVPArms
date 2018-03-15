package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;

import com.jess.arms.di.component.AppComponent;

import me.jessyan.mvparms.demo.di.module.EntranceModule;

import me.jessyan.mvparms.demo.mvp.ui.activity.EntranceActivity;

@ActivityScope
@Component(modules = EntranceModule.class, dependencies = AppComponent.class)
public interface EntranceComponent {
    void inject(EntranceActivity activity);
}