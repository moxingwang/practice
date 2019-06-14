package top.moxingwang.demo.rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @description:
 * @author: MoXingwang 2019-06-14 14:31
 **/
public class RXJavaTest {
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
        System.out.println("主开始"+Thread.currentThread().getName());

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("内部开始"+Thread.currentThread().getName() + integer);
                try {
                    Thread.sleep(111);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {
                System.out.println("onComplete"+Thread.currentThread().getName() );

            }
        });


        for (;;){

        }

//        System.out.println("over");

    }
}
