package com.faithyee.androidlearningdemo.ui.dagger2;

import com.faithyee.androidlearningdemo.ui.dagger2.component.AppComponent;

import dagger.Component;

/**
 * @Component 用来将@Inject和@Module联系起来的桥梁，从@Module中获取依赖并将依赖注入给@Inject
 * Author：yewmf on 2017/12/20 17:33
 * E-mail：faith_yee@163.com
 * 注意dependencies = AppComponent.class,如果不是该依赖方式，那么在Dagger2DemoAct里一个inject方式实现不了所有组件的注入
 */
@ActivityScope
@Component(modules = Dagger2Module.class, dependencies = AppComponent.class)//Component之间也可以依赖的。
public interface Dagger2Component {

    void inject(Dagger2DemoAct dagger2DemoAct);

}
