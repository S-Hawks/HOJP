package org.example;

import org.reactivestreams.Subscription;
import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {
    public static void main(String[] args) throws IOException {
        //User Reactive.intNumberFlux() and ReactiveSources.userMono()

        //Subscribe to a flux using the error and completion hooks
//        Disposable subscribe = ReactiveSources.intNumberFlux()
//                .subscribe(
//                        number -> System.out.println(number),
//                        err -> System.out.println(err),
//                        () -> System.out.println("Completed")
//                        );


        //Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumberFlux().subscribe(new MySubscriber<>());

        System.out.println("Enter nay key to exit");
        System.in.read();
    }

}
class MySubscriber<T> extends BaseSubscriber<T>{
    public void hookOnSubscribe(Subscription subscription){
        System.out.println("Subscribe happened");
        request(2);
    }
    public void hookOnNext(T value){
        System.out.println(value.toString() + " received");
        request(3);
    }
}

