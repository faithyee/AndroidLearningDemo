package com.faithyee.androidlearningdemo.ui.mvp;

import com.faithyee.androidlearningdemo.entity.HotMovies;
import com.faithyee.androidlearningdemo.ui.rxjava.retrofit.MovieService;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Author：yewmf on 2017/12/18 10:15
 * E-mail：faith_yee@163.com
 */
public class MvpPresenter implements MvpContract.Presenter {

    private MvpContract.View view;
    private PasswordValidator mPasswordValidator = new PasswordValidator();
    private UserManager userManager = new UserManager();

    public MvpPresenter(MvpContract.View view){
        this.view = view;
    }

    @Override
    public void login(String name, String pw) {

        if (mPasswordValidator.verify(name, pw)){
            userManager.performLogin(name, pw, new NetworkCallback() {
                @Override
                public void onSuccess(HotMovies data) {
                    view.commitSuccess("observable accept hotMovies===" + data.toString() + "\n");
                }

                @Override
                public void onFailure(int code, String msg) {
                    view.commitSuccess(msg);
                }
            });
        }


    }

    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
}
