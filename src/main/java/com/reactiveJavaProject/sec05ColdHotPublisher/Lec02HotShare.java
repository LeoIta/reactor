package com.reactiveJavaProject.sec05ColdHotPublisher;

import com.reactiveJavaProject.courseUtil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec02HotShare {

    public static void main(String[] args) {


        Flux<String> movieStream = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                .share(); // we use share to change a cold publisher to hot publisher

        //user Sam watching movie in the Cinema
        movieStream
                .subscribe(Util.subscriber("sam"));

        Util.sleepSeconds(5);

        //user Mike watching movie in the Cinema
        movieStream
                .subscribe(Util.subscriber("mike"));

        Util.sleepSeconds(60);


    }

    // movie in the Cinema
    private static Stream<String> getMovie() {
        System.out.println("Got the movie streaming req");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }

}