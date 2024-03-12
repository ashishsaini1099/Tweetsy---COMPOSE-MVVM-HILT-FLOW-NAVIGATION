// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
//    ext.kotlin_version = '1.6.0'
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        //classpath required for applovin sdk "com.applovin.quality:AppLovinQualityServiceGradlePlugin:+"
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("com.android.library") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
}