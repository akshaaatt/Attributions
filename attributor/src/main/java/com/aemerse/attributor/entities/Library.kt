package com.aemerse.attributor.entities

/**
 * An enumeration of common Android libraries with their Attribution information.
 */
enum class Library(val attribution: Attribution) {
    // Presentation
    GLIDE(
        Attribution.Builder("Glide")
            .addCopyrightNotice("Copyright 2014 Google, Inc. All rights reserved.")
            .addLicense(License.BSD_3)
            .addLicense(License.MIT)
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/bumptech/glide")
            .build()
    ),
    // Architecture
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
    RETROFIT(
        Attribution.Builder("Retrofit")
            .addCopyrightNotice("Copyright 2013 Square, Inc.")
            .addLicense(License.APACHE)
            .setWebsite("http://square.github.io/retrofit/")
            .build()
    ),
    // Parser
    GSON(
        Attribution.Builder("Gson")
            .addCopyrightNotice("Copyright 2008 Google Inc.")
            .addLicense(License.APACHE)
            .setWebsite("https://github.com/google/gson")
            .build()
    );
}