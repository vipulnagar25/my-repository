package com.Java8;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TypesOfStream {

    Subscriber<Integer> consumer = new Subscriber<Integer>() {
        @Override
        public void onSubscribe(Subscription subscription) {
            System.out.println("subscription");
        }

        @Override
        public void onNext(Integer number) {
            System.out.println(number);
        }

        @Override
        public void onError(Throwable e) {
            System.out.println("error");
        }

        @Override
        public void onComplete() {
            System.out.println("completed");
        }

    };


    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(12,23,33);

        TypesOfStream ss= new TypesOfStream();

        flux.subscribe(ss.consumer);
        flux.map(ee->ee*22);

    }


}

