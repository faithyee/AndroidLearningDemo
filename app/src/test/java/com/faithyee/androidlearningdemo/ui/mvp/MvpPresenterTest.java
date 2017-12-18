package com.faithyee.androidlearningdemo.ui.mvp;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Author：yewmf on 2017/12/18 17:13
 * E-mail：faith_yee@163.com
 */
public class MvpPresenterTest implements MvpContract.View {


    @Test
    public void login() throws Exception {
        MvpPresenter presenter = new MvpPresenter(this);
        UserManager userManager = Mockito.mock(UserManager.class);
        presenter.setUserManager(userManager);
        presenter.login("", "");
        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                //这里可以获得传给performLogin的参数
                Object[] arguments = invocation.getArguments();
                //NetworkCallback是第三个参数
                NetworkCallback callback = (NetworkCallback) arguments[2];
                callback.onFailure(500,"server error");
                return 500;
            }
        }).when(userManager).performLogin(Mockito.anyString(),Mockito.anyString(),any(NetworkCallback.class));

        userManager.performLogin(Mockito.anyString(),Mockito.anyString(),any(NetworkCallback.class));

    }

    @Override
    public void commitSuccess(String result) {

    }

    @Override
    public void commitFailed(String result) {

    }
}