package com.faithyee.androidlearningdemo;

import com.faithyee.androidlearningdemo.ui.eventBus.EventBusDemoAct;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Author：yewmf on 2017/12/15 17:48
 * E-mail：faith_yee@163.com
 */
@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {

    @Before
    public void setUp() {
        //执行初始化的操作

    }
    @Test
    public void testCase() {
        //执行各种测试逻辑判断
        EventBusDemoAct sampleActivity = Robolectric.buildActivity(EventBusDemoAct.class).
                create().resume().get();
        assertNotNull(sampleActivity);
//        assertEquals("Activity的标题", sampleActivity.getTitle());
    }

}
