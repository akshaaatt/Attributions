package com.limerse.attributor.entities

/**
 * An enumeration of common Android libraries with their Attribution information.
 */
enum class Library(val attribution: Attribution) {
    // Presentation
    BUTTER_KNIFE(
        Attribution.Builder("Butter Knife")
            .addCopyrightNotice("Copyright 2013 Jake Wharton")
            .addLicense(License.APACHE)
            .setWebsite("http://jakewharton.github.io/butterknife/")
            .build()
    ),
    PICASSO(
        Attribution.Builder("Picasso")
            .addCopyrightNotice("Copyright 2013 Square, Inc.")
            .addLicense(License.APACHE)
            .setWebsite("http://square.github.io/picasso/")
            .build()
    ),
    GLIDE(
        Attribution.Builder("Glide")
            .addCopyrightNotice("Copyright 2014 Google, Inc. All rights reserved.")
            .addLicense(License.BSD_3)
            .addLicense(License.MIT)
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/bumptech/glide")
            .build()
    ),  // Architecture
    DAGGER(
        Attribution.Builder("Dagger")
            .addCopyrightNotice("Copyright 2013 Square, Inc.")
            .addLicense(License.APACHE)
            .setWebsite("http://square.github.io/dagger/")
            .build()
    ),
    DAGGER_2(
        Attribution.Builder("Dagger 2")
            .addCopyrightNotice("Copyright 2012 The Dagger Authors")
            .addLicense(License.APACHE)
            .setWebsite("https://google.github.io/dagger/")
            .build()
    ),
    EVENT_BUS(
        Attribution.Builder("EventBus")
            .addCopyrightNotice("Copyright (C) 2012-2016 Markus Junginger, greenrobot")
            .addLicense(License.APACHE)
            .setWebsite("http://greenrobot.org/eventbus/")
            .build()
    ),
    RX_JAVA(
        Attribution.Builder("RxJava")
            .addCopyrightNotice("Copyright (c) 2016-present, RxJava Contributors")
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/ReactiveX/RxJava")
            .build()
    ),
    RX_ANDROID(
        Attribution.Builder("RxAndroid")
            .addCopyrightNotice("Copyright 2015 The RxAndroid authors")
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/ReactiveX/RxAndroid")
            .build()
    ),  // Networking
    OK_HTTP(
        Attribution.Builder("OkHttp")
            .addCopyrightNotice("Copyright 2016 Square, Inc.")
            .addLicense(License.APACHE)
            .setWebsite("http://square.github.io/okhttp/")
            .build()
    ),
    RETROFIT(
        Attribution.Builder("Retrofit")
            .addCopyrightNotice("Copyright 2013 Square, Inc.")
            .addLicense(License.APACHE)
            .setWebsite("http://square.github.io/retrofit/")
            .build()
    ),  // Parser
    GSON(
        Attribution.Builder("Gson")
            .addCopyrightNotice("Copyright 2008 Google Inc.")
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/google/gson")
            .build()
    ),  // ORM & Database
    REALM(
        Attribution.Builder("Realm")
            .addCopyrightNotice("Copyright 2016 Realm Inc.")
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/realm/realm-java")
            .build()
    );

}