package com.faithyee.androidlearningdemo.ui.dagger2;

import dagger.Module;
import dagger.Provides;

/**
 * 该module里的方法，是当Presenter被实例化的时候，发现构造函数有个参数，
 * 此时会在Module里查找提供这个依赖的方法，将该View传递进去，这样就完成了presenter里View的注入
 *
 * @Module 带有此注解的类，用来提供依赖，里面定义一些用@Provides注解的以provide开头的方法，
 * 这些方法就是所提供的依赖，Dagger2会在该类中寻找实例化某个类所需要的依赖。
 */

@Module
public class Dagger2Module {

    private final Dagger2Contract.View mView;

    public Dagger2Module(Dagger2Contract.View view) {
        mView = view;
    }

    @Provides
    Dagger2Contract.View provideDagger2View() {
        return mView;
    }
}
