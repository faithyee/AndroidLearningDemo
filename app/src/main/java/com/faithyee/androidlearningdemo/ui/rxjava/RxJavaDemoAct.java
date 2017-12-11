package com.faithyee.androidlearningdemo.ui.rxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faithyee.androidlearningdemo.R;
import com.faithyee.androidlearningdemo.utils.LogUtils;
import com.faithyee.androidlearningdemo.utils.TimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class RxJavaDemoAct extends AppCompatActivity{
        private static final String TAG = "RxJavaDemoAct";
        private TextView result;
        private StringBuffer sb;
        private boolean intervalSwitch = true;
        private Disposable disposableInterval;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.act_rx_java_demo);
            sb = new StringBuffer();

            result = (TextView) findViewById(R.id.result);

        }

        public void doCreate(View v) {
            clear();
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {

                    sb.append("Observable emit 1" + "\n");
                    LogUtils.i(TAG, "Observable emit 1" + "\n");
                    e.onNext(1);
                    sb.append("Observable emit 2" + "\n");
                    LogUtils.i(TAG, "Observable emit 2" + "\n");
                    e.onNext(2);
                    sb.append("Observable emit 3" + "\n");
                    LogUtils.i(TAG, "Observable emit 3" + "\n");
                    e.onNext(3);
                    sb.append("Observable emit 4" + "\n");
                    LogUtils.i(TAG, "Observable emit 4" + "\n");
                    e.onNext(4);
                    e.onComplete();
                }


            }).subscribe(new Observer<Integer>() {

                private int i;
                private Disposable mDisposable;

                @Override
                public void onSubscribe(@NonNull Disposable d) {
                    sb.append("onSubscribe Disposable: " + d.isDisposed() + "\n");
                    LogUtils.i(TAG, "onSubscribe Disposable: " + d.isDisposed() + "\n");
                    mDisposable = d;

                }

                @Override
                public void onNext(@NonNull Integer integer) {
                    sb.append("onNext : value : " + integer + "\n");
                    LogUtils.i(TAG, "onNext : value : " + integer + "\n");

                    i++;
                    if (i == 3) {
                        // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                        mDisposable.dispose();
                        sb.append("onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                        LogUtils.i(TAG, "onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                        result.setText(sb.toString());
                    }
                }

                @Override
                public void onError(@NonNull Throwable e) {
                    sb.append("onError : value : " + e.getMessage() + "\n");
                    LogUtils.i(TAG, "onError : value : " + e.getMessage() + "\n");
                    result.setText(sb.toString());
                }

                @Override
                public void onComplete() {
                    sb.append("onComplete" + "\n");
                    LogUtils.i(TAG, "onComplete" + "\n");
                    result.setText(sb.toString());
                }
            });

        }

        /**
         * map基本作用就是将一个Observable通过某种函数关系，
         * 转换为另一种Observable，上面例子中就是把我们的Integer数据变成了String类型
         *
         * @param v
         */
        public void doMap(View v) {
            clear();
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    sb.append("Observable emit 1" + "\n");
                    LogUtils.i(TAG, "Observable emit 1" + "\n");
                    e.onNext(1);
                    sb.append("Observable emit 2" + "\n");
                    LogUtils.i(TAG, "Observable emit 2" + "\n");
                    e.onNext(2);
                    sb.append("Observable emit 3" + "\n");
                    LogUtils.i(TAG, "Observable emit 3" + "\n");
                    e.onNext(3);
                    sb.append("Observable emit 4" + "\n");
                    LogUtils.i(TAG, "Observable emit 4" + "\n");
                    e.onNext(4);
                }
            }).map(new Function<Integer, String>() {
                @Override
                public String apply(@NonNull Integer integer) throws Exception {
                    String mapResult = "mapResult" + integer;
                    LogUtils.i(TAG, "map->apply mapResult = " + mapResult);
                    return mapResult;
                }
            }).subscribe(new Consumer<String>() {
                @Override
                public void accept(String str) throws Exception {
                    LogUtils.i(TAG, "doMapResult accept = " + str);
                    sb.append("doMapResult accept = " + str + "\n");
                    result.setText(sb.toString());
                }
            });
        }

        /**
         * zip 组合事件的过程就是分别从发射器A和发射器B各取出一个事件来组合，
         * 并且一个事件只能被使用一次，组合的顺序是严格按照事件发送的顺序来进行的
         *
         * @param v
         */
        public void doZip(View v) {
            clear();
            Observable.zip(getIntegerObservable(), getStringObservable(), new BiFunction<Integer, String, String>() {
                @Override
                public String apply(@NonNull Integer integer, @NonNull String s) throws Exception {
                    return s + integer;
                }
            }).subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                    sb.append("zip : accept : " + s + "\n");
                    LogUtils.i(TAG, "zip : accept : " + s + "\n");
                    result.setText(sb.toString());
                }


            });
        }

        /**
         * 发射器B 搭配doZip使用
         *
         * @return
         */
        private Observable<String> getStringObservable() {
            return Observable.create(new ObservableOnSubscribe<String>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                    if (!e.isDisposed()) {
                        e.onNext("A");
                        sb.append("String emit : A \n");
                        LogUtils.i(TAG, "String emit : A \n");
                        e.onNext("B");
                        sb.append("String emit : B \n");
                        LogUtils.i(TAG, "String emit : B \n");
                        e.onNext("C");
                        sb.append("String emit : C \n");
                        LogUtils.i(TAG, "String emit : C \n");
                    }
                }
            });
        }

        /**
         * 发射器A 搭配doZip使用
         *
         * @return
         */
        private Observable<Integer> getIntegerObservable() {
            return Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    if (!e.isDisposed()) {
                        e.onNext(1);
                        sb.append("Integer emit : 1 \n");
                        LogUtils.i(TAG, "Integer emit : 1 \n");
                        e.onNext(2);
                        sb.append("Integer emit : 2 \n");
                        LogUtils.i(TAG, "Integer emit : 2 \n");
                        e.onNext(3);
                        sb.append("Integer emit : 3 \n");
                        LogUtils.i(TAG, "Integer emit : 3 \n");
                        e.onNext(4);
                        sb.append("Integer emit : 4 \n");
                        LogUtils.i(TAG, "Integer emit : 4 \n");
                        e.onNext(5);
                        sb.append("Integer emit : 5 \n");
                        LogUtils.i(TAG, "Integer emit : 5 \n");
                    }
                }
            });
        }

        /**
         * 发射器B把自己的三个孩子送给了发射器A，让他们组合成了一个新的发射器
         * @param v
         */
        public void doConcat(View v) {
            clear();
            Observable.concat(Observable.just(4, 5, 6), Observable.just(1, 2, 3))
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(@NonNull Integer integer) throws Exception {
                            sb.append("concat : " + integer + "\n");
                            LogUtils.i(TAG, "concat : " + integer + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         *它可以把一个发射器Observable 通过某种方法转换为多个Observables，
         * 然后再把这些分散的Observables装进一个单一的发射器Observable
         * 但有个需要注意的是，flatMap并不能保证事件的顺序
         * @param v
         */
        public void doFlatMap(View v){
            clear();
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    e.onNext(1);
                    e.onNext(2);
                    e.onNext(3);
                }
            }).flatMap(new Function<Integer, ObservableSource<String>>() {
                @Override
                public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {//把多个Observable弄成一个集合。然后通过flatMap发出。直译铺平
                        list.add("I am value " + integer);
                    }
                    int delayTime = (int) (1 + Math.random() * 10);
                    return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);

                }
            })
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            //把多个list铺平了。把数据都铺平成了String
                            LogUtils.i(TAG, "flatMap : accept : " + s + "\n");
                            sb.append("flatMap : accept : " + s + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         *它可以把一个发射器Observable 通过某种方法转换为多个Observables，
         * 然后再把这些分散的Observables装进一个单一的发射器Observable
         * 能保证事件的顺序
         * @param v
         */
        public void doConcatMap(View v){
            clear();
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    e.onNext(1);
                    e.onNext(2);
                    e.onNext(3);
                }
            }).concatMap(new Function<Integer, ObservableSource<String>>() {
                @Override
                public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                    List<String> list = new ArrayList<>();
                    for (int i = 0; i < 3; i++) {//把多个Observable弄成一个集合。然后通过flatMap发出。直译铺平
                        list.add("I am value " + integer);
                    }
                    int delayTime = (int) (1 + Math.random() * 10);
                    return Observable.fromIterable(list).delay(delayTime, TimeUnit.MILLISECONDS);
                }
            })
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<String>() {
                        @Override
                        public void accept(String s) throws Exception {
                            //把多个list铺平了。把数据都铺平成了String
                            LogUtils.i(TAG, "concatMap : accept : " + s + "\n");
                            sb.append("concatMap : accept : " + s + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         * 把重复的发送事件去掉
         * @param v
         */
        public void doDistinct(View v){
            clear();
            Observable.just(1,2,3,2,1,5,4,6)
                    .distinct()
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "distinct accept = " + integer);
                            sb.append("distinct accept = " + integer + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         * 过滤器。过滤不符合条件的事件
         */
        public void doFilter(View v){
            clear();
            sb.append("doFilter emit -1, 20, 30, -50, 100, 41, filter : integer > 20");
            Observable.just(-1, 20, 30, -50, 100, 41).filter(new Predicate<Integer>() {
                @Override
                public boolean test(@NonNull Integer integer) throws Exception {
                    return integer > 20;
                }
            }).subscribe(new Consumer<Integer>() {
                @Override
                public void accept(Integer integer) throws Exception {
                    LogUtils.i(TAG, "filter accept = " + integer);
                    sb.append("filter accept = " + integer + "\n");
                    result.setText(sb.toString());
                }
            });
        }

        /**
         * buffef(count,skip)
         *  buffer 的第一个参数是count，代表最大取值，在事件足够的时候，一般都是取count个值，然后每次跳过skip个事件
         * @param v
         */
        public void doBuffer(View v){
            clear();
            Observable.just(1,2,3,4,5).buffer(3,2)
                    .subscribe(new Consumer<List<Integer>>() {
                        @Override
                        public void accept(List<Integer> integers) throws Exception {
                            LogUtils.i(TAG, "buffer size : " + integers.size() + "\n");
                            sb.append("buffer size : " + integers.size() + "\n");
                            result.setText("buffer size : " + integers.size() + "\n");

                            LogUtils.i(TAG, "buffer value : \n");
                            sb.append("buffer value : \n");
                            result.setText("buffer value : \n");



                            for(Integer i : integers){
                                LogUtils.i(TAG, "buffer(3,2) accept = " + i);
                                sb.append("buffer(3,2) accept = " + i + "\n");
                            }

                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         * 定时器
         *  timer 默认在新线程，所以需要切换回主线程
         * @param v
         */
        public void doTimer(View v){
            clear();
            sb.append("timer start at " + TimeUtils.getNowtime() + "\n");
            result.setText(sb.toString());
            LogUtils.i(TAG, "timer start at " + TimeUtils.getNowtime());
            Observable.timer(10, TimeUnit.SECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Long>() {
                        @Override
                        public void accept(Long aLong) throws Exception {
                            sb.append("timer accept + " + aLong + " + at " + TimeUtils.getNowtime() + "\n");
                            result.setText(sb.toString());
                            LogUtils.i(TAG, "timer accept + " + aLong + " + at " + TimeUtils.getNowtime());

                        }
                    });
        }

        /**
         * interval 操作符用于间隔时间执行某个操作，其接受三个参数，第一次发送延迟，间隔时间，时间单位
         * @param v
         */
        public void doInterval(View v){


            if(intervalSwitch){
                clear();
                sb.append("interval start at " + TimeUtils.getNowtime() + "\n");
                result.setText(sb.toString());
                LogUtils.i(TAG, "interval start at " + TimeUtils.getNowtime());

                disposableInterval = Observable.interval(3, 2, TimeUnit.SECONDS)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<Long>() {
                            @Override
                            public void accept(Long aLong) throws Exception {
                                sb.append("interval accept + " + aLong + " + at " + TimeUtils.getNowtime() + "\n");
                                result.setText(sb.toString());
                                LogUtils.i(TAG, "interval accept + " + aLong + " + at " + TimeUtils.getNowtime());

                            }
                        });

                intervalSwitch = false;
            }else {
                doStopInterval();
            }
        }

        public void doStopInterval(){
            if(disposableInterval != null && !disposableInterval.isDisposed()){
                disposableInterval.dispose();
                sb.append("interval isDisposed at " + TimeUtils.getNowtime() + "\n");
                result.setText(sb.toString());
                LogUtils.i(TAG, "interval isDisposed at " + TimeUtils.getNowtime() + "\n");
                intervalSwitch = true;
            }
        }

        /**
         * 在监听者每次处理之前进行doOnNext操作。可以在事件处理前对事件做一些数据保存之类的操作
         * @param v
         */
        public void doOnNext(View v){
            clear();
            Observable.just(1,2,3,4)
                    .doOnNext(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "doOnNext :save data " + integer + "\n");
                            sb.append("doOnNext :save data " + integer + "\n");
                            result.setText(sb.toString());
                        }
                    })
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "accept data " + integer + "\n");
                            sb.append("accept data " + integer + "\n");
                            result.setText(sb.toString());
                        }
                    });

        }

        /**
         * 接受一个 long 型参数 count ，代表跳过 count 个数目开始接收
         * @param v
         */
        public void doSkip(View v){
            clear();
            LogUtils.i(TAG, "doSkip start data: (1,2,3,4,5)");
            sb.append( "doSkip start data: (1,2,3,4,5)\n");
            Observable.just(1,2,3,4,5)
                    .skip(3)
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "doSkip accept data" + integer + "\n");
                            sb.append("doSkip accept data" + integer + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         * 接收一个参数count，代表最多接收count个事件
         * @param v
         */
        public void doTake(View v){
            clear();
            LogUtils.i(TAG, "doTake start data : 1,2,3,4,5");
            Observable.just(1,2,3,4,5)
                    .take(2)
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "take accept data : " +integer + "\n");
                            sb.append("take accept data : " +integer + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        /**
         * Single 只会接收一个参数，而SingleObserver 只会调用onError 或者onSuccess
         * @param v
         */
        public void doSingle(View v){
            clear();
            LogUtils.i(TAG, "doSingle -> Single.just(new Random().nextInt())\n");
            sb.append("doSingle -> Single.just(new Random().nextInt())\n");
            Single.just(new Random().nextInt())
                    .subscribe(new SingleObserver<Integer>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onSuccess(@NonNull Integer integer) {
                            LogUtils.i(TAG, "doSingle -> onSuccess " + integer + "\n");
                            sb.append("doSingle -> onSuccess " + integer + "\n");
                            result.setText(sb.toString());
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });
        }

        /**
         * 去除发送间隔时间小于500毫秒的发射事件
         * @param v
         */
        public void doDebounce(View v){
            clear();
            LogUtils.i(TAG, "doDebounce start debounce(500, TimeUnit.MILLISECONDS)500毫秒间隔");
            sb.append("doDebounce start debounce(500, TimeUnit.MILLISECONDS)500毫秒间隔\n");
            Observable.create(new ObservableOnSubscribe<Integer>() {
                @Override
                public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                    e.onNext(1);
                    LogUtils.i(TAG, "doDebounce Emit 1");
                    sb.append("doDebounce Emit 1\n");
                    Thread.sleep(100);
                    e.onNext(2);
                    LogUtils.i(TAG, "doDebounce Emit 2");
                    sb.append("doDebounce Emit 2\n");
                    Thread.sleep(501);
                    e.onNext(3);
                    LogUtils.i(TAG, "doDebounce Emit 3");
                    sb.append("doDebounce Emit 3\n");
                    Thread.sleep(200);
                    e.onNext(4);
                    LogUtils.i(TAG, "doDebounce Emit 4");
                    sb.append("doDebounce Emit 4\n");
                    Thread.sleep(600);
                    e.onNext(5);
                    LogUtils.i(TAG, "doDebounce Emit 5");
                    sb.append("doDebounce Emit 5\n");
                    Thread.sleep(100);
                    e.onComplete();
                }
            }).debounce(500, TimeUnit.MILLISECONDS)//500毫秒
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "debounce accept " + integer + "successed!\n");
                            sb.append("debounce accept " + integer + "successed!\n");
                            result.setText(sb.toString());
                        }
                    });

        }

        /**
         * 简单地时候就是每次订阅都会创建一个新的Observable，并且如果没有被订阅，就不会产生新的Observable
         * @param v
         */
        public void doDefer(View v){
            clear();
            LogUtils.i(TAG, "doDefer start\n");
            sb.append("doDefer start\n");
            Observable<Integer> defer = Observable.defer(new Callable<ObservableSource<Integer>>() {
                @Override
                public ObservableSource<Integer> call() throws Exception {
                    return Observable.just(1, 2, 3);//每次订阅defer，都会创建一个新的Observable
                }
            });

            defer.subscribe(new Observer<Integer>() {
                @Override
                public void onSubscribe(@NonNull Disposable d) {

                }

                @Override
                public void onNext(@NonNull Integer integer) {
                    LogUtils.i(TAG, "defer onNext" + integer + "\n");
                    sb.append("defer onNext" + integer + "\n");
                    result.setText(sb.toString());
                }

                @Override
                public void onError(@NonNull Throwable e) {

                }

                @Override
                public void onComplete() {
                    LogUtils.i(TAG, "defer complete\n");
                    sb.append("defer complete");
                    result.setText(sb.toString());
                }
            });
        }

        /**
         * last 操作符仅取出可观察到的最后一个值，或者是满足某些条件的最后一项。
         * @param v
         */
        public void doLast(View v){
            clear();
            LogUtils.i(TAG, "doLast start Observable.just(11,22,33)  .last(4)\n");
            sb.append("doLast start Observable.just(11,22,33)  .last(4)\n");
            Observable.just(11,22,33)
                    .last(4)
                    .subscribe(new Consumer<Integer>() {
                        @Override
                        public void accept(Integer integer) throws Exception {
                            LogUtils.i(TAG, "doLast accept" + integer + "\n");
                            sb.append("doLast accept" + integer + "\n");
                            result.setText(sb.toString());
                        }
                    });
        }

        public void clear() {
            sb.replace(0, sb.length(), "");
            result.setText("");
        }

        @Override
        protected void onDestroy() {
            super.onDestroy();
            doStopInterval();
        }
}
