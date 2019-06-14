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

        observable.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {

            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("开始"+integer);
                for (;;){

                }
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

        for (;;){

        }

//        System.out.println("over");

    }
}
