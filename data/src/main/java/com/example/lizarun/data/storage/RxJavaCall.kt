package com.example.lizarun.data.storage

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

fun <T : Any> rxJavaSingleCall(simpleCall: () -> Single<T>): Single<T> {
    return simpleCall()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun rxJavaCompletableCall(completableCall: () -> Completable): Completable {
    return completableCall()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}